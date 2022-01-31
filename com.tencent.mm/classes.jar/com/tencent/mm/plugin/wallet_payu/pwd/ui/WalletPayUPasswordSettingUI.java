package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI
  extends WalletPasswordSettingUI
{
  protected final int bUA()
  {
    return a.l.wallet_payu_password_setting_pref;
  }
  
  protected final void bUB()
  {
    y.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
    a.a(this, g.class, null);
  }
  
  protected final void bUC()
  {
    y.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
    a.a(this, com.tencent.mm.plugin.wallet_payu.pwd.a.f.class, null);
  }
  
  protected final void bUD()
  {
    this.vdd.bJ("wallet_modify_gesture_password", true);
    this.vdd.bJ("wallet_open_gesture_password", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */