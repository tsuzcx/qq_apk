package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$8
  implements DialogInterface.OnCancelListener
{
  SettingsUI$8(SettingsUI paramSettingsUI, ad paramad) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127567);
    g.Rc().a(this.qHi);
    g.Rc().b(281, SettingsUI.k(this.qKL));
    SettingsUI.l(this.qKL);
    if (SettingsUI.m(this.qKL) != null)
    {
      SettingsUI.m(this.qKL).stopTimer();
      SettingsUI.n(this.qKL);
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).dismiss();
    }
    AppMethodBeat.o(127567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.8
 * JD-Core Version:    0.7.0.1
 */