package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsSpecialSceneNotificationUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsSpecialSceneNotificationUI$1(SettingsSpecialSceneNotificationUI paramSettingsSpecialSceneNotificationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127490);
    this.qKj.hideVKB();
    this.qKj.finish();
    AppMethodBeat.o(127490);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI.1
 * JD-Core Version:    0.7.0.1
 */