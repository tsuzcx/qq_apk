package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends a<csl>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new csk();
    ((b.a)localObject).hNN = new csl();
    ((b.a)localObject).funcId = 1338;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    csk localcsk = (csk)((b)localObject).hNK.hNQ;
    localcsk.HeX = paramInt1;
    localcsk.FYP = paramString1;
    localcsk.Hfc = paramString2;
    localcsk.uxm = paramInt2;
    localcsk.Hfb = paramString3;
    localcsk.Cyu = ae.eCl();
    c((b)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */