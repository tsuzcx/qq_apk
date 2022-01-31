package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.platformtools.am;

final class SettingsAboutMicroMsgUI$2$3
  implements DialogInterface.OnCancelListener
{
  SettingsAboutMicroMsgUI$2$3(SettingsAboutMicroMsgUI.2 param2, ac paramac) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.nTi);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2.3
 * JD-Core Version:    0.7.0.1
 */