package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMain$11
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMain$11(SettingsTeenModeMain paramSettingsTeenModeMain) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279060);
    this.TaK.onBackPressed();
    AppMethodBeat.o(279060);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.11
 * JD-Core Version:    0.7.0.1
 */