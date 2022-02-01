package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsSnsPrivacyUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SettingsSnsPrivacyUI$3(SettingsSnsPrivacyUI paramSettingsSnsPrivacyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(263694);
    this.JjM.hideVKB();
    this.JjM.finish();
    AppMethodBeat.o(263694);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSnsPrivacyUI.3
 * JD-Core Version:    0.7.0.1
 */