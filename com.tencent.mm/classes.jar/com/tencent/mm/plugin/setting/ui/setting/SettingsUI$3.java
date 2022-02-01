package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

final class SettingsUI$3
  implements DialogInterface.OnClickListener
{
  SettingsUI$3(SettingsUI paramSettingsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74498);
    h.IzE.a(11545, new Object[] { Integer.valueOf(2) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
    if (SettingsUI.f(this.Jkp) != null) {
      SettingsUI.f(this.Jkp).dismiss();
    }
    AppMethodBeat.o(74498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.3
 * JD-Core Version:    0.7.0.1
 */