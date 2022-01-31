package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$27
  extends u
{
  BankRemitBankcardInputUI$27(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void aEI()
  {
    y.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
    this.nwd.XM();
    this.nwd.VH();
    if (BankRemitBankcardInputUI.r(this.nwd)) {
      return;
    }
    String str1 = BankRemitBankcardInputUI.u(this.nwd).getText();
    String str2 = BankRemitBankcardInputUI.o(this.nwd).getText();
    if ((bk.bl(str1)) || (str1.trim().isEmpty()) || (bk.bl(str2)) || (str2.trim().isEmpty()) || (BankRemitBankcardInputUI.s(this.nwd) == null))
    {
      y.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { str1, str2, BankRemitBankcardInputUI.s(this.nwd) });
      return;
    }
    if (BankRemitBankcardInputUI.i(this.nwd))
    {
      y.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
      BankRemitBankcardInputUI.v(this.nwd);
      return;
    }
    BankRemitBankcardInputUI.a(this.nwd, str1, str2, BankRemitBankcardInputUI.s(this.nwd).lnT, BankRemitBankcardInputUI.s(this.nwd).mOb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.27
 * JD-Core Version:    0.7.0.1
 */