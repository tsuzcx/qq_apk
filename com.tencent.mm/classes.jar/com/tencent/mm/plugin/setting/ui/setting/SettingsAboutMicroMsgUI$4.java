package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SettingsAboutMicroMsgUI$4
  implements ap.a
{
  SettingsAboutMicroMsgUI$4(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI, t paramt) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127094);
    g.Rc().a(this.qHk);
    g.Rc().b(255, SettingsAboutMicroMsgUI.c(this.qHg));
    SettingsAboutMicroMsgUI.d(this.qHg);
    if (SettingsAboutMicroMsgUI.e(this.qHg) != null)
    {
      SettingsAboutMicroMsgUI.e(this.qHg).stopTimer();
      SettingsAboutMicroMsgUI.f(this.qHg);
    }
    if (SettingsAboutMicroMsgUI.a(this.qHg) != null) {
      SettingsAboutMicroMsgUI.a(this.qHg).cancel();
    }
    SettingsAboutMicroMsgUI.g(this.qHg);
    AppMethodBeat.o(127094);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.4
 * JD-Core Version:    0.7.0.1
 */