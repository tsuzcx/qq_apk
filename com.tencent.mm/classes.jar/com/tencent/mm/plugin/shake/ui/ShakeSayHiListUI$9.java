package com.tencent.mm.plugin.shake.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeSayHiListUI$9
  implements MenuItem.OnMenuItemClickListener
{
  ShakeSayHiListUI$9(ShakeSayHiListUI paramShakeSayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(24882);
    this.qRC.hideVKB();
    this.qRC.finish();
    AppMethodBeat.o(24882);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.9
 * JD-Core Version:    0.7.0.1
 */