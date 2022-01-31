package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ap;

final class SettingsUI$18
  implements DialogInterface.OnCancelListener
{
  SettingsUI$18(SettingsUI paramSettingsUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(127579);
    g.Rc().b(281, SettingsUI.v(this.qKL));
    g.Rc().b(282, SettingsUI.x(this.qKL));
    SettingsUI.w(this.qKL);
    SettingsUI.y(this.qKL);
    if (SettingsUI.s(this.qKL) != null)
    {
      SettingsUI.s(this.qKL).stopTimer();
      SettingsUI.t(this.qKL);
    }
    if (SettingsUI.o(this.qKL) != null) {
      SettingsUI.o(this.qKL).dismiss();
    }
    AppMethodBeat.o(127579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.18
 * JD-Core Version:    0.7.0.1
 */