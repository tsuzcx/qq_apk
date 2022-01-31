package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsAboutMicroMsgUI$2$1
  implements f
{
  SettingsAboutMicroMsgUI$2$1(SettingsAboutMicroMsgUI.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.Dk().b(281, SettingsAboutMicroMsgUI.2.a(this.nTh));
    SettingsAboutMicroMsgUI.2.b(this.nTh);
    if (SettingsAboutMicroMsgUI.2.c(this.nTh) != null)
    {
      SettingsAboutMicroMsgUI.2.c(this.nTh).stopTimer();
      SettingsAboutMicroMsgUI.2.d(this.nTh);
    }
    if (SettingsAboutMicroMsgUI.a(this.nTh.nTg) != null) {
      SettingsAboutMicroMsgUI.a(this.nTh.nTg).dismiss();
    }
    SettingsAboutMicroMsgUI.b(this.nTh.nTg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2.1
 * JD-Core Version:    0.7.0.1
 */