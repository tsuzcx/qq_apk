package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class SettingsUI$7
  implements am.a
{
  SettingsUI$7(SettingsUI paramSettingsUI, ac paramac) {}
  
  public final boolean tC()
  {
    g.Dk().c(this.nTi);
    g.Dk().b(281, SettingsUI.l(this.nWB));
    SettingsUI.m(this.nWB);
    if (SettingsUI.n(this.nWB) != null)
    {
      SettingsUI.n(this.nWB).stopTimer();
      SettingsUI.o(this.nWB);
    }
    if (SettingsUI.p(this.nWB) != null) {
      SettingsUI.p(this.nWB).dismiss();
    }
    SettingsUI.q(this.nWB);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.7
 * JD-Core Version:    0.7.0.1
 */