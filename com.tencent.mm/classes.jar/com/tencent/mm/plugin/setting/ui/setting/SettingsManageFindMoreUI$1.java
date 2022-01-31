package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

final class SettingsManageFindMoreUI$1
  implements Runnable
{
  SettingsManageFindMoreUI$1(SettingsManageFindMoreUI paramSettingsManageFindMoreUI, CheckBoxPreference paramCheckBoxPreference) {}
  
  public final void run()
  {
    AppMethodBeat.i(127269);
    this.qIP.vxW = false;
    SettingsManageFindMoreUI.a(this.qIQ, this.qIP.isChecked());
    AppMethodBeat.o(127269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.1
 * JD-Core Version:    0.7.0.1
 */