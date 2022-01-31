package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.sdk.platformtools.am.a;

final class SettingsSelectBgUI$1
  implements am.a
{
  SettingsSelectBgUI$1(SettingsSelectBgUI paramSettingsSelectBgUI) {}
  
  public final boolean tC()
  {
    if (this.nVW.findViewById(a.f.settings_select_bg_gv).getWidth() <= 0) {
      return true;
    }
    SettingsSelectBgUI.a(this.nVW);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.1
 * JD-Core Version:    0.7.0.1
 */