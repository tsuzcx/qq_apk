package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitSelectPayeeUI$8
  implements p.a
{
  BankRemitSelectPayeeUI$8(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44679);
    ab.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
    BankRemitSelectPayeeUI.b(this.qiD, this.qiH.qfK, this.qiH.hKa);
    AppMethodBeat.o(44679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.8
 * JD-Core Version:    0.7.0.1
 */