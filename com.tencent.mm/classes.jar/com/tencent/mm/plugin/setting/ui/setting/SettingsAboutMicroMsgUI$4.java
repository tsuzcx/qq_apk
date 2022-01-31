package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class SettingsAboutMicroMsgUI$4
  implements am.a
{
  SettingsAboutMicroMsgUI$4(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI, r paramr) {}
  
  public final boolean tC()
  {
    g.Dk().c(this.nTk);
    g.Dk().b(255, SettingsAboutMicroMsgUI.c(this.nTg));
    SettingsAboutMicroMsgUI.d(this.nTg);
    if (SettingsAboutMicroMsgUI.e(this.nTg) != null)
    {
      SettingsAboutMicroMsgUI.e(this.nTg).stopTimer();
      SettingsAboutMicroMsgUI.f(this.nTg);
    }
    if (SettingsAboutMicroMsgUI.a(this.nTg) != null) {
      SettingsAboutMicroMsgUI.a(this.nTg).cancel();
    }
    SettingsAboutMicroMsgUI.g(this.nTg);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.4
 * JD-Core Version:    0.7.0.1
 */