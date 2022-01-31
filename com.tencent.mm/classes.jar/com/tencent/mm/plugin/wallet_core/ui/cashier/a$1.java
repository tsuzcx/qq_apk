package com.tencent.mm.plugin.wallet_core.ui.cashier;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements WcPayCashierDialog.b
{
  a$1(a parama) {}
  
  public final void cWg()
  {
    AppMethodBeat.i(47736);
    ab.i("MicroMsg.WcPayCashierBankcardDialog", "cashier dialog has dismissed");
    this.uuG.dismiss();
    AppMethodBeat.o(47736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a.1
 * JD-Core Version:    0.7.0.1
 */