package com.tencent.mm.ui.chatting.b;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;

final class j$5$1
  implements View.OnCreateContextMenuListener
{
  j$5$1(j.5 param5) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramContextMenu.add(0, 0, 0, R.l.multi_select_send_normal);
    paramContextMenu.add(0, 1, 1, R.l.multi_select_send_record);
    if (WWAPIFactory.ik(this.vpv.vpr.byx.vtz.getContext()).cSb()) {
      paramContextMenu.add(0, 2, 2, this.vpv.vpr.byx.vtz.getContext().getString(R.l.multi_select_send_wework, new Object[] { WWAPIFactory.ik(this.vpv.vpr.byx.vtz.getContext()).cSc() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.5.1
 * JD-Core Version:    0.7.0.1
 */