package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsAboutMicroMsgUI$2$1
  implements f
{
  SettingsAboutMicroMsgUI$2$1(SettingsAboutMicroMsgUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127088);
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
    AppMethodBeat.o(127088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2.1
 * JD-Core Version:    0.7.0.1
 */