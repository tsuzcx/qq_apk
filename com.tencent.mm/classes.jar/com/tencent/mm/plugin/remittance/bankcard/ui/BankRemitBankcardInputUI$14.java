package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitBankcardInputUI$14
  implements p.a
{
  BankRemitBankcardInputUI$14(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44528);
    ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", new Object[] { paramm });
    BankRemitBankcardInputUI.C(this.qhe);
    BankRemitBankcardInputUI.b(this.qhe, false);
    AppMethodBeat.o(44528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.14
 * JD-Core Version:    0.7.0.1
 */