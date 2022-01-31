package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.ag.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class RemittanceBaseUI$22
  implements am.b.a
{
  RemittanceBaseUI$22(RemittanceBaseUI paramRemittanceBaseUI, long paramLong) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      y.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bk.UY() - this.iJC) + " ms");
      b.M(paramString, 3);
    }
    for (;;)
    {
      RemittanceBaseUI.c(this.nAH);
      return;
      y.w("MicroMsg.RemittanceBaseUI", "getContact failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.22
 * JD-Core Version:    0.7.0.1
 */