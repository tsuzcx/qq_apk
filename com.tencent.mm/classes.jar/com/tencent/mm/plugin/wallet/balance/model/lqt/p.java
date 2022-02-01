package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends c<cni>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cnh();
    ((b.a)localObject).hvu = new cni();
    ((b.a)localObject).funcId = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cnh localcnh = (cnh)((b)localObject).hvr.hvw;
    localcnh.FuS = paramInt1;
    localcnh.ErF = paramString1;
    localcnh.FuX = paramString2;
    localcnh.ErG = paramInt2;
    localcnh.FuW = paramString3;
    localcnh.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */