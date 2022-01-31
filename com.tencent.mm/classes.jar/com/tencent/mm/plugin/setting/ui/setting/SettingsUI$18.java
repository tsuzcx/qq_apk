package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsUI$18
  implements DialogInterface.OnCancelListener
{
  SettingsUI$18(SettingsUI paramSettingsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
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
      SettingsUI.p(this.nWB).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.18
 * JD-Core Version:    0.7.0.1
 */