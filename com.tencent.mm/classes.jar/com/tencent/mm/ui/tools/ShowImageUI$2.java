package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

final class ShowImageUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShowImageUI$2(ShowImageUI paramShowImageUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    if ((ShowImageUI.a(this.weX)) && (d.SP("favorite")))
    {
      localLinkedList.add(Integer.valueOf(0));
      paramMenuItem.add(this.weX.getString(R.l.retransmits));
      localLinkedList.add(Integer.valueOf(1));
      paramMenuItem.add(this.weX.getString(R.l.plugin_favorite_opt));
      localLinkedList.add(Integer.valueOf(2));
      paramMenuItem.add(this.weX.getString(R.l.save_to_local));
    }
    for (;;)
    {
      do localdo = new do();
      localdo.bJZ.bIt = this.weX.getIntent().getLongExtra("key_message_id", -1L);
      a.udP.m(localdo);
      if (localdo.bKa.bJy)
      {
        localLinkedList.add(Integer.valueOf(3));
        paramMenuItem.add(this.weX.getString(R.l.chatting_long_click_menu_open));
      }
      h.a(this.weX, "", paramMenuItem, localLinkedList, "", false, new ShowImageUI.2.1(this));
      return true;
      localLinkedList.add(Integer.valueOf(0));
      paramMenuItem.add(this.weX.getString(R.l.retransmits));
      localLinkedList.add(Integer.valueOf(2));
      paramMenuItem.add(this.weX.getString(R.l.save_to_local));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI.2
 * JD-Core Version:    0.7.0.1
 */