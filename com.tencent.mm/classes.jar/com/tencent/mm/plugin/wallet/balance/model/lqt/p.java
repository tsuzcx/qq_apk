package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends c<dlv>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dlu();
    ((d.a)localObject).iLO = new dlv();
    ((d.a)localObject).funcId = 1338;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dlu localdlu = (dlu)((d)localObject).iLK.iLR;
    localdlu.MJd = paramInt1;
    localdlu.Lmm = paramString1;
    localdlu.MJi = paramString2;
    localdlu.yba = paramInt2;
    localdlu.MJh = paramString3;
    localdlu.HuS = ag.fNb();
    c((d)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */