package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletRealNameVerifyUI$3
  implements View.OnClickListener
{
  WalletRealNameVerifyUI$3(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = WalletRealNameVerifyUI.b(this.qse).getText();
    String str = WalletRealNameVerifyUI.c(this.qse).getText();
    WalletRealNameVerifyUI.a(this.qse, paramView, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.3
 * JD-Core Version:    0.7.0.1
 */