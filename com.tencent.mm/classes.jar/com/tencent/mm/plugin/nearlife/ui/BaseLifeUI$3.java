package com.tencent.mm.plugin.nearlife.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseLifeUI$3
  implements MenuItem.OnMenuItemClickListener
{
  BaseLifeUI$3(BaseLifeUI paramBaseLifeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22938);
    this.pfa.a(-1, false, "", this.pfa.peV);
    this.pfa.finish();
    AppMethodBeat.o(22938);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.3
 * JD-Core Version:    0.7.0.1
 */