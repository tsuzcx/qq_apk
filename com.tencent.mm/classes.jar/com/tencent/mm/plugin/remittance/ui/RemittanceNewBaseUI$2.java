package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceNewBaseUI$2
  implements ao.b.a
{
  RemittanceNewBaseUI$2(RemittanceNewBaseUI paramRemittanceNewBaseUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142227);
    if (paramBoolean)
    {
      ab.v("MicroMsg.RemittanceNewBaseUI", "getContact suc; cost=" + (bo.aoy() - this.kQi) + " ms");
      b.U(paramString, 3);
    }
    for (;;)
    {
      RemittanceNewBaseUI.l(this.qqR);
      AppMethodBeat.o(142227);
      return;
      ab.w("MicroMsg.RemittanceNewBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.2
 * JD-Core Version:    0.7.0.1
 */