package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dvm;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.wallet_core.c.j;

public final class p
  extends c<dvn>
  implements j
{
  public p(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(68452);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dvm();
    ((d.a)localObject).lBV = new dvn();
    ((d.a)localObject).funcId = 1338;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/redeemfund";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dvm localdvm = (dvm)d.b.b(((d)localObject).lBR);
    localdvm.TUS = paramInt1;
    localdvm.SnA = paramString1;
    localdvm.TUX = paramString2;
    localdvm.DgI = paramInt2;
    localdvm.TUW = paramString3;
    localdvm.OmF = ah.gFF();
    c((d)localObject);
    AppMethodBeat.o(68452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.p
 * JD-Core Version:    0.7.0.1
 */