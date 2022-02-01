package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.hk;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.network.af;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class SettingsUI$4
  implements DialogInterface.OnClickListener
{
  SettingsUI$4(SettingsUI paramSettingsUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(74499);
    c.bpr().iq();
    ((e)com.tencent.mm.kernel.h.ae(e.class)).dbv();
    if ((SettingsUI.h(this.Jkp) != null) && (SettingsUI.h(this.Jkp).isChecked()))
    {
      Log.i("MicroMsg.SettingsUI", "push notify mode exit");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(99L, 143L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(6) });
      Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
      af.btN().edit().putBoolean("is_in_notify_mode", true).commit();
      SettingsUI.i(this.Jkp);
      AppMethodBeat.o(74499);
      return;
    }
    Log.i("MicroMsg.SettingsUI", "normally exit");
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(99L, 144L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.a(11545, new Object[] { Integer.valueOf(7) });
    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
    if ((com.tencent.mm.kernel.h.aGY() != null) && (com.tencent.mm.kernel.h.aGY().lCD != null)) {
      com.tencent.mm.kernel.h.aGY().lCD.gk(false);
    }
    paramDialogInterface = new hk();
    EventCenter.instance.publish(paramDialogInterface);
    SettingsUI.j(this.Jkp);
    AppMethodBeat.o(74499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsUI.4
 * JD-Core Version:    0.7.0.1
 */