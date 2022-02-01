package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends a<cof>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68449);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new coe();
    ((b.a)localObject).hQG = new cof();
    ((b.a)localObject).funcId = 1276;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    coe localcoe = (coe)((b)localObject).hQD.hQJ;
    localcoe.HAb = paramString1;
    localcoe.HAc = paramInt1;
    localcoe.uIM = paramInt2;
    localcoe.HAd = paramString2;
    localcoe.HyB = paramString3;
    localcoe.CPO = paramInt3;
    localcoe.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */