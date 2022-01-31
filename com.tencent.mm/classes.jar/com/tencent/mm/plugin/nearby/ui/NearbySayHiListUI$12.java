package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbySayHiListUI$12
  implements MenuItem.OnMenuItemClickListener
{
  NearbySayHiListUI$12(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(55506);
    this.pdR.hideVKB();
    this.pdR.setResult(0);
    this.pdR.finish();
    AppMethodBeat.o(55506);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.12
 * JD-Core Version:    0.7.0.1
 */