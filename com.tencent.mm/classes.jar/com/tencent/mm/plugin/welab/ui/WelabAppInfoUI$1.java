package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WelabAppInfoUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WelabAppInfoUI$1(WelabAppInfoUI paramWelabAppInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(80599);
    this.vvu.hideVKB();
    this.vvu.finish();
    AppMethodBeat.o(80599);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.1
 * JD-Core Version:    0.7.0.1
 */