package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitSelectPayeeUI$8
  implements r.a
{
  BankRemitSelectPayeeUI$8(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67592);
    ae.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
    BankRemitSelectPayeeUI.b(this.ykG, this.ykK.yhI, this.ykK.iWF);
    AppMethodBeat.o(67592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.8
 * JD-Core Version:    0.7.0.1
 */