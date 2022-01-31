package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPluginsNotifyUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPluginsNotifyUI$1(SettingsPluginsNotifyUI paramSettingsPluginsNotifyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127390);
    this.qJt.hideVKB();
    this.qJt.finish();
    AppMethodBeat.o(127390);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI.1
 * JD-Core Version:    0.7.0.1
 */