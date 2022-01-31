package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.b;

final class SettingsSwitchAccountUI$4
  implements SwitchAccountGridView.b
{
  SettingsSwitchAccountUI$4(SettingsSwitchAccountUI paramSettingsSwitchAccountUI) {}
  
  public final void YW(String paramString)
  {
    AppMethodBeat.i(127500);
    if (!bo.isNullOrNil(paramString))
    {
      if (SettingsSwitchAccountUI.b(this.qKt) == 0)
      {
        SettingsSwitchAccountUI.a(this.qKt, paramString);
        AppMethodBeat.o(127500);
        return;
      }
      SettingsSwitchAccountUI.b(this.qKt, paramString);
      AppMethodBeat.o(127500);
      return;
    }
    ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
    if (SettingsSwitchAccountUI.b(this.qKt) == 0)
    {
      SettingsSwitchAccountUI.ckA();
      AppMethodBeat.o(127500);
      return;
    }
    paramString = new Intent(this.qKt, MobileInputUI.class);
    paramString.putExtra("mobile_input_purpose", 1);
    paramString.putExtra("from_switch_account", true);
    this.qKt.startActivity(paramString);
    b.ie(this.qKt);
    AppMethodBeat.o(127500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI.4
 * JD-Core Version:    0.7.0.1
 */