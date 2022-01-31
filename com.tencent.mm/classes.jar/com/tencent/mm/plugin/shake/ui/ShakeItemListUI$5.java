package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeItemListUI$5
  implements MenuItem.OnMenuItemClickListener
{
  ShakeItemListUI$5(ShakeItemListUI paramShakeItemListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24724);
    this.qPL.hideVKB();
    this.qPL.finish();
    AppMethodBeat.o(24724);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.5
 * JD-Core Version:    0.7.0.1
 */