package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.i;
import com.tencent.mm.protocal.protobuf.ekl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitHistoryUI$4
  implements r.a
{
  BankRemitHistoryUI$4(BankRemitHistoryUI paramBankRemitHistoryUI, i parami) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67523);
    Log.e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", new Object[] { Integer.valueOf(this.Oej.Oci.hAV), this.Oej.Oci.wYI });
    AppMethodBeat.o(67523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */