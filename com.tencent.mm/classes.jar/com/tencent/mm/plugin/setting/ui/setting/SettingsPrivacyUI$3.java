package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPrivacyUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsPrivacyUI$3(SettingsPrivacyUI paramSettingsPrivacyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(127410);
    this.qJI.hideVKB();
    this.qJI.finish();
    AppMethodBeat.o(127410);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.3
 * JD-Core Version:    0.7.0.1
 */