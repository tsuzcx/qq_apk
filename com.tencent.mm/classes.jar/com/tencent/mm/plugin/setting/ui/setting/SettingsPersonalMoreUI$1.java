package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

final class SettingsPersonalMoreUI$1
  implements Preference.a
{
  SettingsPersonalMoreUI$1(SettingsPersonalMoreUI paramSettingsPersonalMoreUI) {}
  
  public final boolean a(Preference paramPreference, Object paramObject)
  {
    AppMethodBeat.i(127381);
    paramPreference = (String)paramObject;
    if ("male".equalsIgnoreCase(paramPreference)) {
      SettingsPersonalMoreUI.a(this.qJs, 1);
    }
    for (;;)
    {
      AppMethodBeat.o(127381);
      return false;
      if ("female".equalsIgnoreCase(paramPreference)) {
        SettingsPersonalMoreUI.a(this.qJs, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI.1
 * JD-Core Version:    0.7.0.1
 */