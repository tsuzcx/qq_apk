package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r.a;

final class RemittanceUI$3
  implements r.a
{
  RemittanceUI$3(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68320);
    ae.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { this.ywm.ynC.Gnq, this.ywm.ynC.ywk });
    this.ywn.yqw = this.ywm.ynC.Gnq;
    this.ywn.ywk = this.ywm.ynC.ywk;
    this.ywn.yqa = this.ywm.ynC.Gnr;
    RemittanceUI.a(this.ywn, this.ywm.ynC.ywl);
    this.ywn.ymv = this.ywm.ynC.yoX;
    this.ywn.dMO();
    AppMethodBeat.o(68320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.3
 * JD-Core Version:    0.7.0.1
 */