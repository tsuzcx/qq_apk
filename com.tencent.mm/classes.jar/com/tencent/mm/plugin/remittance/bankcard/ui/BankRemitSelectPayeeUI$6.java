package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitSelectPayeeUI$6
  implements r.a
{
  BankRemitSelectPayeeUI$6(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67590);
    ae.e("MicroMsg.BankRemitSelectPayeeUI", "net error: %s", new Object[] { paramn });
    AppMethodBeat.o(67590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.6
 * JD-Core Version:    0.7.0.1
 */