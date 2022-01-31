package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitHistoryUI$6
  implements p.a
{
  BankRemitHistoryUI$6(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44611);
    ab.e("MicroMsg.BankRemitHistoryUI", "net error: %s", new Object[] { paramm });
    AppMethodBeat.o(44611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.6
 * JD-Core Version:    0.7.0.1
 */