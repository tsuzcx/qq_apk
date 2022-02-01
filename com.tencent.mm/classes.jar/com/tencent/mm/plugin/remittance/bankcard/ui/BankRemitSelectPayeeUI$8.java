package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.bankcard.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r.a;

final class BankRemitSelectPayeeUI$8
  implements r.a
{
  BankRemitSelectPayeeUI$8(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI, j paramj) {}
  
  public final void c(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(67592);
    Log.i("MicroMsg.BankRemitSelectPayeeUI", "modify success");
    BankRemitSelectPayeeUI.b(this.Ofk, this.Ofo.Ocb, this.Ofo.remark);
    AppMethodBeat.o(67592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.8
 * JD-Core Version:    0.7.0.1
 */