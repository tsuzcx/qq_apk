package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class SettingsAboutMicroMsgUI$2$2
  implements ap.a
{
  SettingsAboutMicroMsgUI$2$2(SettingsAboutMicroMsgUI.2 param2, ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(127089);
    g.Rc().a(this.qHi);
    g.Rc().b(281, SettingsAboutMicroMsgUI.2.a(this.qHh));
    SettingsAboutMicroMsgUI.2.b(this.qHh);
    if (SettingsAboutMicroMsgUI.2.c(this.qHh) != null)
    {
      SettingsAboutMicroMsgUI.2.c(this.qHh).stopTimer();
      SettingsAboutMicroMsgUI.2.d(this.qHh);
    }
    if (SettingsAboutMicroMsgUI.a(this.qHh.qHg) != null) {
      SettingsAboutMicroMsgUI.a(this.qHh.qHg).dismiss();
    }
    SettingsAboutMicroMsgUI.b(this.qHh.qHg);
    AppMethodBeat.o(127089);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2.2
 * JD-Core Version:    0.7.0.1
 */