package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsAboutMicroMsgUI$5
  implements DialogInterface.OnCancelListener
{
  SettingsAboutMicroMsgUI$5(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI, r paramr) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
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
      SettingsAboutMicroMsgUI.a(this.nTg).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.5
 * JD-Core Version:    0.7.0.1
 */