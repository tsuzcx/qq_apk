package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r.a;

final class RemittanceUI$1
  implements r.a
{
  RemittanceUI$1(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68318);
    ac.e("MicroMsg.RemittanceUI", "net error: %s", new Object[] { this.wSO });
    AppMethodBeat.o(68318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.1
 * JD-Core Version:    0.7.0.1
 */