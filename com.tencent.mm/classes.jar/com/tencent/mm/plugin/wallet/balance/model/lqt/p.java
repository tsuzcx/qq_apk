package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends a<ctf>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cte();
    ((b.a)localObject).hQG = new ctf();
    ((b.a)localObject).funcId = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cte localcte = (cte)((b)localObject).hQD.hQJ;
    localcte.Hyx = paramInt1;
    localcte.Gro = paramString1;
    localcte.HyC = paramString2;
    localcte.uIM = paramInt2;
    localcte.HyB = paramString3;
    localcte.CPZ = ae.eFT();
    c((b)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */