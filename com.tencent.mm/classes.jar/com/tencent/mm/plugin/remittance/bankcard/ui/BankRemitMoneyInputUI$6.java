package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.o;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitMoneyInputUI$6
  implements p.a
{
  BankRemitMoneyInputUI$6(BankRemitMoneyInputUI paramBankRemitMoneyInputUI, o paramo) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44635);
    ab.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(this.qik.qfX.cnK), this.qik.qfX.kNv });
    BankRemitMoneyInputUI.a(this.qij, this.qik);
    if (BankRemitMoneyInputUI.h(this.qij)) {
      this.qij.hideLoading();
    }
    AppMethodBeat.o(44635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.6
 * JD-Core Version:    0.7.0.1
 */