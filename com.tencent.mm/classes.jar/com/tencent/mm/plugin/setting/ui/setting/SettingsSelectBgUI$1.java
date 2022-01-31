package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SettingsSelectBgUI$1
  implements ap.a
{
  SettingsSelectBgUI$1(SettingsSelectBgUI paramSettingsSelectBgUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127470);
    if (this.qKf.findViewById(2131827641).getWidth() <= 0)
    {
      AppMethodBeat.o(127470);
      return true;
    }
    SettingsSelectBgUI.a(this.qKf);
    AppMethodBeat.o(127470);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.1
 * JD-Core Version:    0.7.0.1
 */