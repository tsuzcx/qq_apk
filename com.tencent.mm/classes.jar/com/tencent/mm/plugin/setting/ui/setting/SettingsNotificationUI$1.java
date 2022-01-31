package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsNotificationUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsNotificationUI$1(SettingsNotificationUI paramSettingsNotificationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127351);
    this.qJo.hideVKB();
    this.qJo.finish();
    AppMethodBeat.o(127351);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI.1
 * JD-Core Version:    0.7.0.1
 */