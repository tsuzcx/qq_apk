package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$22
  implements DialogInterface.OnCancelListener
{
  SettingsUI$22(SettingsUI paramSettingsUI, t paramt) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127585);
    g.Rc().a(this.qHk);
    g.Rc().b(255, SettingsUI.q(this.qKL));
    SettingsUI.r(this.qKL);
    if (SettingsUI.s(this.qKL) != null)
    {
      SettingsUI.s(this.qKL).stopTimer();
      SettingsUI.t(this.qKL);
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).dismiss();
    }
    AppMethodBeat.o(127585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.22
 * JD-Core Version:    0.7.0.1
 */