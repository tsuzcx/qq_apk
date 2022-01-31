package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsAboutMicroMsgUI$2$3
  implements DialogInterface.OnCancelListener
{
  SettingsAboutMicroMsgUI$2$3(SettingsAboutMicroMsgUI.2 param2, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127090);
    g.Rc().a(this.qHi);
    g.Rc().b(281, SettingsAboutMicroMsgUI.2.a(this.qHh));
    SettingsAboutMicroMsgUI.2.b(this.qHh);
    if (SettingsAboutMicroMsgUI.2.c(this.qHh) != null)
    {
      SettingsAboutMicroMsgUI.2.c(this.qHh).stopTimer();
      SettingsAboutMicroMsgUI.2.d(this.qHh);
    }
    if (SettingsAboutMicroMsgUI.a(this.qHh.qHg) != null) {
      SettingsAboutMicroMsgUI.a(this.qHh.qHg).dismiss();
    }
    AppMethodBeat.o(127090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI.2.3
 * JD-Core Version:    0.7.0.1
 */