package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitHistoryUI$3
  implements p.a
{
  BankRemitHistoryUI$3(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44608);
    ab.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramm });
    AppMethodBeat.o(44608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */