package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsVoipSoundVibrateUI$1
  implements MenuItem.OnMenuItemClickListener
{
  SettingsVoipSoundVibrateUI$1(SettingsVoipSoundVibrateUI paramSettingsVoipSoundVibrateUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127624);
    this.qKQ.hideVKB();
    this.qKQ.finish();
    AppMethodBeat.o(127624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI.1
 * JD-Core Version:    0.7.0.1
 */