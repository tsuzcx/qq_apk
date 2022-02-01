package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.e;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitHistoryUI$7
  implements r.a
{
  BankRemitHistoryUI$7(BankRemitHistoryUI paramBankRemitHistoryUI, e parame) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67526);
    Log.e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", new Object[] { Integer.valueOf(this.Oek.Oce.hAV), this.Oek.Oce.wYI });
    AppMethodBeat.o(67526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.7
 * JD-Core Version:    0.7.0.1
 */