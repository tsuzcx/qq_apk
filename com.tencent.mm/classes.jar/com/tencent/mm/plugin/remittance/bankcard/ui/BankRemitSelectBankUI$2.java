package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.bankcard.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class BankRemitSelectBankUI$2
  implements p.a
{
  BankRemitSelectBankUI$2(BankRemitSelectBankUI paramBankRemitSelectBankUI, h paramh) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(44664);
    ab.e("MicroMsg.BankRemitSelectBankUI", "net error: %s", new Object[] { this.qiu });
    AppMethodBeat.o(44664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectBankUI.2
 * JD-Core Version:    0.7.0.1
 */