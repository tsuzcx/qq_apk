package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.remittance.bankcard.model.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitMoneyInputUI$3
  extends u
{
  BankRemitMoneyInputUI$3(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void aEI()
  {
    y.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
    double d = a.ew(BankRemitMoneyInputUI.c(this.nxh).getText(), "100");
    if (d <= 0.0D)
    {
      y.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
      Toast.makeText(this.nxh, a.i.bank_remit_illegal_arg_text, 1).show();
      return;
    }
    if (d > BankRemitMoneyInputUI.d(this.nxh))
    {
      y.w("MicroMsg.BankRemitMoneyInputUI", "more than max: %s", new Object[] { Double.valueOf(d) });
      Toast.makeText(this.nxh, this.nxh.getString(a.i.bank_remit_max_money_toast, new Object[] { a.ev(new StringBuilder().append(BankRemitMoneyInputUI.d(this.nxh)).toString(), "100") }), 0).show();
      return;
    }
    BankRemitMoneyInputUI.e(this.nxh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.3
 * JD-Core Version:    0.7.0.1
 */