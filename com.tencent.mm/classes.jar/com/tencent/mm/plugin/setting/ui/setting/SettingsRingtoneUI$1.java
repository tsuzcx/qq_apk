package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsRingtoneUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsRingtoneUI$1(SettingsRingtoneUI paramSettingsRingtoneUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127424);
    this.qJP.hideVKB();
    this.qJP.finish();
    AppMethodBeat.o(127424);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI.1
 * JD-Core Version:    0.7.0.1
 */