package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class RemittanceUI$3
  implements p.a
{
  RemittanceUI$3(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45162);
    ab.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { this.qrz.qiX.wJa, this.qrz.qiX.qrx });
    this.qrA.qlK = this.qrz.qiX.wJa;
    this.qrA.qrx = this.qrz.qiX.qrx;
    this.qrA.qlo = this.qrz.qiX.wJb;
    RemittanceUI.a(this.qrA, this.qrz.qiX.qry);
    this.qrA.qnV = this.qrz.qiX.qkr;
    this.qrA.chl();
    AppMethodBeat.o(45162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.3
 * JD-Core Version:    0.7.0.1
 */