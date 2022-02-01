package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitHistoryUI$3
  implements r.a
{
  BankRemitHistoryUI$3(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67522);
    ae.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramn });
    AppMethodBeat.o(67522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */