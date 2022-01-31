package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsUI$6
  implements f
{
  SettingsUI$6(SettingsUI paramSettingsUI) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.6
 * JD-Core Version:    0.7.0.1
 */