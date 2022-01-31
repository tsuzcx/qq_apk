package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.protocal.c.nt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class RemittanceUI$3
  implements n.a
{
  RemittanceUI$3(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { this.nEz.nxW.sLm, this.nEz.nxW.nEy });
    this.nEA.nAo = this.nEz.nxW.sLm;
    this.nEA.nEy = this.nEz.nxW.nEy;
    this.nEA.bwv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.3
 * JD-Core Version:    0.7.0.1
 */