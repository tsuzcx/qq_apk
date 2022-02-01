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
    AppMethodBeat.i(28395);
    this.DjD.hideVKB();
    this.DjD.finish();
    AppMethodBeat.o(28395);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.5
 * JD-Core Version:    0.7.0.1
 */