package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsUI$2
  implements DialogInterface.OnClickListener
{
  SettingsUI$2(SettingsUI paramSettingsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(11545, new Object[] { Integer.valueOf(3) });
    y.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
    h.nFQ.a(99L, 145L, 1L, false);
    if ((g.Dk() != null) && (g.Dk().edx != null)) {
      g.Dk().edx.bP(false);
    }
    if (SettingsUI.g(this.nWB) != null) {
      SettingsUI.g(this.nWB).dismiss();
    }
    SettingsUI.h(this.nWB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.2
 * JD-Core Version:    0.7.0.1
 */