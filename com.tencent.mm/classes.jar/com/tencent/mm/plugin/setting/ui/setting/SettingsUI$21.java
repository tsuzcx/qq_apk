package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class SettingsUI$21
  implements am.a
{
  SettingsUI$21(SettingsUI paramSettingsUI, r paramr) {}
  
  public final boolean tC()
  {
    g.Dk().c(this.nTk);
    g.Dk().b(255, SettingsUI.r(this.nWB));
    SettingsUI.s(this.nWB);
    if (SettingsUI.t(this.nWB) != null)
    {
      SettingsUI.t(this.nWB).stopTimer();
      SettingsUI.u(this.nWB);
    }
    if (SettingsUI.p(this.nWB) != null) {
      SettingsUI.p(this.nWB).cancel();
    }
    SettingsUI.C(this.nWB);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.21
 * JD-Core Version:    0.7.0.1
 */