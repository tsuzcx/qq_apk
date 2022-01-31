package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class SettingsUI$15
  implements am.a
{
  SettingsUI$15(SettingsUI paramSettingsUI, ac paramac) {}
  
  public final boolean tC()
  {
    g.Dk().c(this.nTi);
    g.Dk().b(281, SettingsUI.w(this.nWB));
    g.Dk().b(282, SettingsUI.y(this.nWB));
    SettingsUI.x(this.nWB);
    SettingsUI.z(this.nWB);
    if (SettingsUI.t(this.nWB) != null)
    {
      SettingsUI.t(this.nWB).stopTimer();
      SettingsUI.u(this.nWB);
    }
    if (SettingsUI.p(this.nWB) != null) {
      SettingsUI.p(this.nWB).cancel();
    }
    SettingsUI.A(this.nWB);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.15
 * JD-Core Version:    0.7.0.1
 */