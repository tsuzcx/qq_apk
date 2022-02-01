package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMainMiniProgram$5
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMainMiniProgram$5(SettingsTeenModeMainMiniProgram paramSettingsTeenModeMainMiniProgram) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279122);
    this.TaW.onBackPressed();
    AppMethodBeat.o(279122);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainMiniProgram.5
 * JD-Core Version:    0.7.0.1
 */