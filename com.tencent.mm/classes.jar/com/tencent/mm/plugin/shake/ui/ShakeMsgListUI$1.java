package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeMsgListUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ShakeMsgListUI$1(ShakeMsgListUI paramShakeMsgListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24751);
    this.qQa.hideVKB();
    this.qQa.finish();
    AppMethodBeat.o(24751);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.1
 * JD-Core Version:    0.7.0.1
 */