package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsAboutMicroMsgUI$5
  implements DialogInterface.OnCancelListener
{
  SettingsAboutMicroMsgUI$5(SettingsAboutMicroMsgUI paramSettingsAboutMicroMsgUI, t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127095);
    g.Rc().a(this.qHk);
    g.Rc().b(255, SettingsAboutMicroMsgUI.c(this.qHg));
    SettingsAboutMicroMsgUI.d(this.qHg);
    if (SettingsAboutMicroMsgUI.e(this.qHg) != null)
    {
      SettingsAboutMicroMsgUI.e(this.qHg).stopTimer();
      SettingsAboutMicroMsgUI.f(this.qHg);
    }
    if (SettingsAboutMicroMsgUI.a(this.qHg) != null) {
      SettingsAboutMicroMsgUI.a(this.qHg).dismiss();
    }
    AppMethodBeat.o(127095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.5
 * JD-Core Version:    0.7.0.1
 */