package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPersonalInfoUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPersonalInfoUI$1(SettingsPersonalInfoUI paramSettingsPersonalInfoUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127365);
    this.qJr.hideVKB();
    this.qJr.finish();
    AppMethodBeat.o(127365);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.1
 * JD-Core Version:    0.7.0.1
 */