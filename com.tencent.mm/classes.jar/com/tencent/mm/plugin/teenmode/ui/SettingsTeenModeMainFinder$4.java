package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMainFinder$4
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMainFinder$4(SettingsTeenModeMainFinder paramSettingsTeenModeMainFinder) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279123);
    this.TaV.onBackPressed();
    AppMethodBeat.o(279123);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.4
 * JD-Core Version:    0.7.0.1
 */