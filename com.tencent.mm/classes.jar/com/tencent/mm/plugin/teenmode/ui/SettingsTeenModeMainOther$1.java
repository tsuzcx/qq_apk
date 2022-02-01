package com.tencent.mm.plugin.teenmode.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsTeenModeMainOther$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsTeenModeMainOther$1(SettingsTeenModeMainOther paramSettingsTeenModeMainOther) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279152);
    this.TaZ.onBackPressed();
    AppMethodBeat.o(279152);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainOther.1
 * JD-Core Version:    0.7.0.1
 */