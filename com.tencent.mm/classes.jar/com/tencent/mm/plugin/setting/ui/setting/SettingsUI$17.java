package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SettingsUI$17
  implements ap.a
{
  SettingsUI$17(SettingsUI paramSettingsUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127578);
    g.Rc().b(281, SettingsUI.v(this.qKL));
    g.Rc().b(282, SettingsUI.x(this.qKL));
    SettingsUI.w(this.qKL);
    SettingsUI.y(this.qKL);
    if (SettingsUI.A(this.qKL) != null) {
      SettingsUI.A(this.qKL).stopTimer();
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).cancel();
    }
    SettingsUI.z(this.qKL);
    AppMethodBeat.o(127578);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.17
 * JD-Core Version:    0.7.0.1
 */