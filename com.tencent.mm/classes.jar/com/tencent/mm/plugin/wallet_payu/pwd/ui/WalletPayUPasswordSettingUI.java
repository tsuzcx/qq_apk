package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI
  extends WalletPasswordSettingUI
{
  public final int eaV()
  {
    return 2131951762;
  }
  
  public final void eaW()
  {
    AppMethodBeat.i(72162);
    ad.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
    a.a(this, g.class, null);
    AppMethodBeat.o(72162);
  }
  
  public final void eaX()
  {
    AppMethodBeat.i(72161);
    ad.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
    a.a(this, com.tencent.mm.plugin.wallet_payu.pwd.a.f.class, null);
    AppMethodBeat.o(72161);
  }
  
  public final void eaY()
  {
    AppMethodBeat.i(72163);
    getPreferenceScreen().cE("wallet_modify_gesture_password", true);
    getPreferenceScreen().cE("wallet_open_gesture_password", true);
    AppMethodBeat.o(72163);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */