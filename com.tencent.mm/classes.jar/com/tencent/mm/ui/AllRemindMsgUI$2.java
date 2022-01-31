package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AllRemindMsgUI$2
  implements MenuItem.OnMenuItemClickListener
{
  AllRemindMsgUI$2(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(29113);
    this.yTD.onBackPressed();
    AppMethodBeat.o(29113);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.2
 * JD-Core Version:    0.7.0.1
 */