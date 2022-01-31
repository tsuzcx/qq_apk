package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SettingsUI$10
  implements ap.a
{
  SettingsUI$10(SettingsUI paramSettingsUI, t paramt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127570);
    g.Rc().a(this.qHk);
    g.Rc().b(255, SettingsUI.q(this.qKL));
    SettingsUI.r(this.qKL);
    if (SettingsUI.s(this.qKL) != null)
    {
      SettingsUI.s(this.qKL).stopTimer();
      SettingsUI.t(this.qKL);
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).cancel();
    }
    SettingsUI.u(this.qKL);
    AppMethodBeat.o(127570);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.10
 * JD-Core Version:    0.7.0.1
 */