package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsActiveTimeUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsActiveTimeUI$1(SettingsActiveTimeUI paramSettingsActiveTimeUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127154);
    this.qHO.hideVKB();
    this.qHO.finish();
    AppMethodBeat.o(127154);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI.1
 * JD-Core Version:    0.7.0.1
 */