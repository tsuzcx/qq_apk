package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.e;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitHistoryUI$7
  implements r.a
{
  BankRemitHistoryUI$7(BankRemitHistoryUI paramBankRemitHistoryUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67526);
    ae.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(this.yjN.yhL.dmy), this.yjN.yhL.phe });
    AppMethodBeat.o(67526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */