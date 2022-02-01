package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.network.g;
import com.tencent.mm.sdk.platformtools.Log;

final class SettingsUI$2
  implements DialogInterface.OnClickListener
{
  SettingsUI$2(SettingsUI paramSettingsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74497);
    com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(3) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(99L, 145L, 1L, false);
    if ((com.tencent.mm.kernel.h.aGY() != null) && (com.tencent.mm.kernel.h.aGY().lCD != null)) {
      com.tencent.mm.kernel.h.aGY().lCD.gk(false);
    }
    if (SettingsUI.f(this.Jkp) != null) {
      SettingsUI.f(this.Jkp).dismiss();
    }
    SettingsUI.g(this.Jkp);
    AppMethodBeat.o(74497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.2
 * JD-Core Version:    0.7.0.1
 */