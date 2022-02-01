package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r.a;

final class RemittanceUI$2
  implements r.a
{
  RemittanceUI$2(RemittanceUI paramRemittanceUI) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68319);
    ac.d("MicroMsg.RemittanceUI", "before transfer: %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(68319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.2
 * JD-Core Version:    0.7.0.1
 */