package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPluginsUI$2
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPluginsUI$2(SettingsPluginsUI paramSettingsPluginsUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74335);
    this.Jjd.hideVKB();
    this.Jjd.finish();
    AppMethodBeat.o(74335);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI.2
 * JD-Core Version:    0.7.0.1
 */