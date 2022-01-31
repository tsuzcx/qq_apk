package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$25
  implements View.OnClickListener
{
  BankRemitBankcardInputUI$25(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44541);
    this.qhe.hideVKB();
    paramView = BankRemitBankcardInputUI.r(this.qhe).getText();
    if ((BankRemitBankcardInputUI.s(this.qhe)) && (!bo.isNullOrNil(paramView)))
    {
      String str = BankRemitBankcardInputUI.r(this.qhe).getMD5Value();
      BankRemitBankcardInputUI.a(this.qhe, paramView, str);
      AppMethodBeat.o(44541);
      return;
    }
    BankRemitBankcardInputUI.t(this.qhe);
    AppMethodBeat.o(44541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.25
 * JD-Core Version:    0.7.0.1
 */