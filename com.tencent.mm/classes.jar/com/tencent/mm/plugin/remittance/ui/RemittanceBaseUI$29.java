package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class RemittanceBaseUI$29
  implements ar.b.a
{
  RemittanceBaseUI$29(RemittanceBaseUI paramRemittanceBaseUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(67981);
    if (paramBoolean)
    {
      ac.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bs.eWj() - this.ozS) + " ms");
      c.ag(paramString, 3);
    }
    for (;;)
    {
      RemittanceBaseUI.e(this.wNx);
      AppMethodBeat.o(67981);
      return;
      ac.w("MicroMsg.RemittanceBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.29
 * JD-Core Version:    0.7.0.1
 */