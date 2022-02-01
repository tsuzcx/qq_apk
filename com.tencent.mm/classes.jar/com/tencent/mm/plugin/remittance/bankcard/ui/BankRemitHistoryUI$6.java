package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitHistoryUI$6
  implements r.a
{
  BankRemitHistoryUI$6(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67525);
    Log.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramp });
    AppMethodBeat.o(67525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.6
 * JD-Core Version:    0.7.0.1
 */