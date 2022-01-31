package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletResetInfoUI$1
  implements View.OnClickListener
{
  WalletResetInfoUI$1(WalletResetInfoUI paramWalletResetInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(45818);
    if (!WalletResetInfoUI.a(this.tTF))
    {
      ab.w("Micromsg.WalletResetInfoUI", "input format illegal!");
      AppMethodBeat.o(45818);
      return;
    }
    if (WalletResetInfoUI.b(this.tTF).getVisibility() == 0) {
      WalletResetInfoUI.c(this.tTF).ufa = WalletResetInfoUI.b(this.tTF).getText();
    }
    if (WalletResetInfoUI.d(this.tTF).getVisibility() == 0) {
      WalletResetInfoUI.c(this.tTF).ufb = bo.bf(WalletResetInfoUI.d(this.tTF).getText(), "");
    }
    if (WalletResetInfoUI.e(this.tTF).getVisibility() == 0)
    {
      WalletResetInfoUI.c(this.tTF).ubQ = bo.bf(WalletResetInfoUI.f(this.tTF).getText(), "");
      paramView = e.awd(WalletResetInfoUI.c(this.tTF).ubQ);
      this.tTF.getInput().putString("key_mobile", paramView);
    }
    ab.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[] { WalletResetInfoUI.c(this.tTF).poq, WalletResetInfoUI.c(this.tTF).por });
    WalletResetInfoUI.c(this.tTF).ueV = 1;
    WalletResetInfoUI.c(this.tTF).ufm = ("+" + WalletResetInfoUI.e(this.tTF).getCountryCode());
    if (this.tTF.getInput().getBoolean("key_is_changing_balance_phone_num", false))
    {
      this.tTF.doSceneProgress(a.b(WalletResetInfoUI.c(this.tTF), WalletResetInfoUI.g(this.tTF), this.tTF.getInput().getBoolean("key_isbalance", false)));
      AppMethodBeat.o(45818);
      return;
    }
    paramView = a.a(WalletResetInfoUI.c(this.tTF), WalletResetInfoUI.g(this.tTF), false);
    if (paramView != null) {
      this.tTF.doSceneProgress(paramView);
    }
    AppMethodBeat.o(45818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI.1
 * JD-Core Version:    0.7.0.1
 */