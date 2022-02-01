package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends c<cie>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cid();
    ((b.a)localObject).gUV = new cie();
    ((b.a)localObject).funcId = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cid localcid = (cid)((b)localObject).gUS.gUX;
    localcid.DXY = paramInt1;
    localcid.CYT = paramString1;
    localcid.DYd = paramString2;
    localcid.CYU = paramInt2;
    localcid.DYc = paramString3;
    localcid.zFY = ae.dYR();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */