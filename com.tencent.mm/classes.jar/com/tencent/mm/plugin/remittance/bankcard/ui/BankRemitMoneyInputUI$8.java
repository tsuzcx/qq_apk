package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.plugin.wallet_core.ui.view.a;

final class BankRemitMoneyInputUI$8
  implements o.a
{
  BankRemitMoneyInputUI$8(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(44640);
    a.a(this.qij, this.qij.getString(2131297508), BankRemitMoneyInputUI.j(this.qij), this.qij.getString(2131302541), 20, new BankRemitMoneyInputUI.8.1(this), new BankRemitMoneyInputUI.8.2(this));
    h.qsU.e(14673, new Object[] { Integer.valueOf(4) });
    AppMethodBeat.o(44640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8
 * JD-Core Version:    0.7.0.1
 */