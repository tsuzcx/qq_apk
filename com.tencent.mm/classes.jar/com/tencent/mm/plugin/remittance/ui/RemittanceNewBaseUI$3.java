package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class RemittanceNewBaseUI$3
  implements ar.b.a
{
  RemittanceNewBaseUI$3(RemittanceNewBaseUI paramRemittanceNewBaseUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(68216);
    if (paramBoolean)
    {
      ac.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (bs.eWj() - this.ozS) + " ms");
      c.ag(paramString, 3);
    }
    for (;;)
    {
      RemittanceNewBaseUI.m(this.wSg);
      AppMethodBeat.o(68216);
      return;
      ac.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.3
 * JD-Core Version:    0.7.0.1
 */