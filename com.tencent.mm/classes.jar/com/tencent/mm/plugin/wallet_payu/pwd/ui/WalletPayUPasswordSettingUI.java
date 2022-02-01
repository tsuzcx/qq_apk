package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wxpay.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI
  extends WalletPasswordSettingUI
{
  public final int gHO()
  {
    return a.m.wallet_payu_password_setting_pref;
  }
  
  public final void gHP()
  {
    AppMethodBeat.i(72162);
    Log.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
    a.a(this, g.class, null);
    AppMethodBeat.o(72162);
  }
  
  public final void gHQ()
  {
    AppMethodBeat.i(72161);
    Log.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
    a.a(this, com.tencent.mm.plugin.wallet_payu.pwd.a.f.class, null);
    AppMethodBeat.o(72161);
  }
  
  public final void gHR()
  {
    AppMethodBeat.i(72163);
    getPreferenceScreen().dz("wallet_modify_gesture_password", true);
    getPreferenceScreen().dz("wallet_open_gesture_password", true);
    AppMethodBeat.o(72163);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */