package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WelabMainUI$2
  implements MenuItem.OnMenuItemClickListener
{
  WelabMainUI$2(WelabMainUI paramWelabMainUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(146286);
    this.JGz.hideVKB();
    this.JGz.finish();
    AppMethodBeat.o(146286);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.WelabMainUI.2
 * JD-Core Version:    0.7.0.1
 */