package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$25
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$25(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    this.nwd.XM();
    paramView = BankRemitBankcardInputUI.o(this.nwd).getText();
    if ((BankRemitBankcardInputUI.p(this.nwd)) && (!bk.bl(paramView)))
    {
      String str = BankRemitBankcardInputUI.o(this.nwd).getMD5Value();
      BankRemitBankcardInputUI.a(this.nwd, paramView, str);
      return;
    }
    BankRemitBankcardInputUI.q(this.nwd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.25
 * JD-Core Version:    0.7.0.1
 */