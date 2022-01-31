package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class RemittanceUI$1
  implements p.a
{
  RemittanceUI$1(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45160);
    ab.e("MicroMsg.RemittanceUI", "net error: %s", new Object[] { this.qrz });
    AppMethodBeat.o(45160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.1
 * JD-Core Version:    0.7.0.1
 */