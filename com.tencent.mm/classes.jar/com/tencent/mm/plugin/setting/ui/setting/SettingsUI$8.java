package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsUI$8
  implements DialogInterface.OnCancelListener
{
  SettingsUI$8(SettingsUI paramSettingsUI, ac paramac) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.8
 * JD-Core Version:    0.7.0.1
 */