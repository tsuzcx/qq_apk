package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
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
    AppMethodBeat.i(34993);
    paramMenuItem = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    if ((ShowImageUI.a(this.AxN)) && (d.ahR("favorite")))
    {
      localLinkedList.add(Integer.valueOf(0));
      paramMenuItem.add(this.AxN.getString(2131302657));
      localLinkedList.add(Integer.valueOf(1));
      paramMenuItem.add(this.AxN.getString(2131302102));
      localLinkedList.add(Integer.valueOf(2));
      paramMenuItem.add(this.AxN.getString(2131302871));
    }
    for (;;)
    {
      dr localdr = new dr();
      localdr.crt.cpO = this.AxN.getIntent().getLongExtra("key_message_id", -1L);
      a.ymk.l(localdr);
      if (localdr.cru.cqS)
      {
        localLinkedList.add(Integer.valueOf(3));
        paramMenuItem.add(this.AxN.getString(2131298238));
      }
      h.a(this.AxN, "", paramMenuItem, localLinkedList, "", false, new ShowImageUI.2.1(this));
      AppMethodBeat.o(34993);
      return true;
      localLinkedList.add(Integer.valueOf(0));
      paramMenuItem.add(this.AxN.getString(2131302657));
      localLinkedList.add(Integer.valueOf(2));
      paramMenuItem.add(this.AxN.getString(2131302871));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI.2
 * JD-Core Version:    0.7.0.1
 */