package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletResetInfoUI$1
  implements View.OnClickListener
{
  WalletResetInfoUI$1(WalletResetInfoUI paramWalletResetInfoUI) {}
  
  public final void onClick(View paramView)
  {
    if (!WalletResetInfoUI.a(this.qkF)) {
      y.w("Micromsg.WalletResetInfoUI", "input format illegal!");
    }
    do
    {
      return;
      if (WalletResetInfoUI.b(this.qkF).getVisibility() == 0) {
        WalletResetInfoUI.c(this.qkF).qsN = WalletResetInfoUI.b(this.qkF).getText();
      }
      if (WalletResetInfoUI.d(this.qkF).getVisibility() == 0) {
        WalletResetInfoUI.c(this.qkF).qsO = bk.aM(WalletResetInfoUI.d(this.qkF).getText(), "");
      }
      if (WalletResetInfoUI.e(this.qkF).getVisibility() == 0)
      {
        WalletResetInfoUI.c(this.qkF).qqU = bk.aM(WalletResetInfoUI.f(this.qkF).getText(), "");
        paramView = e.afk(WalletResetInfoUI.c(this.qkF).qqU);
        this.qkF.BX.putString("key_mobile", paramView);
      }
      y.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(this.qkF).mOb, WalletResetInfoUI.c(this.qkF).mOc });
      WalletResetInfoUI.c(this.qkF).qsH = 1;
      WalletResetInfoUI.c(this.qkF).qsZ = ("+" + WalletResetInfoUI.e(this.qkF).getCountryCode());
      if (this.qkF.BX.getBoolean("key_is_changing_balance_phone_num", false))
      {
        this.qkF.a(a.b(WalletResetInfoUI.c(this.qkF), WalletResetInfoUI.g(this.qkF), this.qkF.BX.getBoolean("key_isbalance", false)), true, true);
        return;
      }
      paramView = a.a(WalletResetInfoUI.c(this.qkF), WalletResetInfoUI.g(this.qkF), false);
    } while (paramView == null);
    this.qkF.a(paramView, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI.1
 * JD-Core Version:    0.7.0.1
 */