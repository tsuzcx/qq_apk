package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.model.e;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r.a;

final class RemittanceUI$3
  implements r.a
{
  RemittanceUI$3(RemittanceUI paramRemittanceUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(68320);
    ac.d("MicroMsg.RemittanceUI", "mask_name: %s truename_extend %s", new Object[] { this.wSO.wKd.EnI, this.wSO.wKd.wSM });
    this.wSP.wMX = this.wSO.wKd.EnI;
    this.wSP.wSM = this.wSO.wKd.wSM;
    this.wSP.wMB = this.wSO.wKd.EnJ;
    RemittanceUI.a(this.wSP, this.wSO.wKd.wSN);
    this.wSP.wIV = this.wSO.wKd.wLy;
    this.wSP.dye();
    AppMethodBeat.o(68320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceUI.3
 * JD-Core Version:    0.7.0.1
 */