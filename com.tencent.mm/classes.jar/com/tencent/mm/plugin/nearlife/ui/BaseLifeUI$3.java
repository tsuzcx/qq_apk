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
    AppMethodBeat.i(26562);
    this.ucz.a(-1, false, "", this.ucz.ucu);
    this.ucz.finish();
    AppMethodBeat.o(26562);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.3
 * JD-Core Version:    0.7.0.1
 */