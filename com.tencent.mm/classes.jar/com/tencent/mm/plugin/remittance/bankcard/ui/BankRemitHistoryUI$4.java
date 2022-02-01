package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.bankcard.a.i;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class BankRemitHistoryUI$4
  implements r.a
{
  BankRemitHistoryUI$4(BankRemitHistoryUI paramBankRemitHistoryUI, i parami) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(67523);
    ae.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(this.yjM.yhP.dmy), this.yjM.yhP.phe });
    AppMethodBeat.o(67523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */