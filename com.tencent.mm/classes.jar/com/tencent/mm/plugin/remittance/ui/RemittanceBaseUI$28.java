package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class RemittanceBaseUI$28
  implements ao.b.a
{
  RemittanceBaseUI$28(RemittanceBaseUI paramRemittanceBaseUI, long paramLong) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(142159);
    if (paramBoolean)
    {
      ab.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bo.aoy() - this.kQi) + " ms");
      b.U(paramString, 3);
    }
    for (;;)
    {
      RemittanceBaseUI.e(this.qmk);
      AppMethodBeat.o(142159);
      return;
      ab.w("MicroMsg.RemittanceBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.28
 * JD-Core Version:    0.7.0.1
 */