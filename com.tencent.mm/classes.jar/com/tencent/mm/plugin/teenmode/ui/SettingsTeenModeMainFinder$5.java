package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMainFinder$5
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMainFinder$5(SettingsTeenModeMainFinder paramSettingsTeenModeMainFinder) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(187430);
    this.FWP.onBackPressed();
    AppMethodBeat.o(187430);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainFinder.5
 * JD-Core Version:    0.7.0.1
 */