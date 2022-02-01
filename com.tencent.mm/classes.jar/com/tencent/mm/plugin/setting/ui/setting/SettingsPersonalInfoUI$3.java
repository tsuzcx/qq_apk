package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.ui.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;

final class SettingsPersonalInfoUI$3
  implements a.a
{
  SettingsPersonalInfoUI$3(SettingsPersonalInfoUI paramSettingsPersonalInfoUI) {}
  
  public final void cjC()
  {
    AppMethodBeat.i(298899);
    Log.i("MicroMsg.SettingsPersonalInfoUI", "changeSwitchWechatCommonTips onCancalBtn.");
    AppMethodBeat.o(298899);
  }
  
  public final void onSuccess()
  {
    AppMethodBeat.i(298894);
    Log.i("MicroMsg.SettingsPersonalInfoUI", "changeSwitchWechatCommonTips onPositionBtn. ConfigStorageLogic.getExtStatus2FromUserInfo() = " + z.bAS());
    h.OAn.b(21650, new Object[] { Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.putExtra("launch_from_webview", false);
    localIntent.putExtra("isWecoinAuth", true);
    c.c(this.Pvn.getContext(), "wallet", ".wecoin.ui.WeCoinRechargeView", localIntent);
    AppMethodBeat.o(298894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.3
 * JD-Core Version:    0.7.0.1
 */