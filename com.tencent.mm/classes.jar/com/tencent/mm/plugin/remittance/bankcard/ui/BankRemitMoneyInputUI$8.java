package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

final class BankRemitMoneyInputUI$8
  implements m.a
{
  BankRemitMoneyInputUI$8(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void aEP()
  {
    a.a(this.nxh, this.nxh.getString(a.i.bank_remit_remittance_desc_text), BankRemitMoneyInputUI.h(this.nxh), this.nxh.getString(a.i.remittance_desc_max_words_count_tip), 20, new BankRemitMoneyInputUI.8.1(this), new BankRemitMoneyInputUI.8.2(this));
    h.nFQ.f(14673, new Object[] { Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8
 * JD-Core Version:    0.7.0.1
 */