package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.wallet_core.c.j;

public final class m
  extends c<dpw>
  implements j
{
  public m(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(204246);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dpv();
    ((d.a)localObject).lBV = new dpw();
    ((d.a)localObject).funcId = 1276;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/purchasefund";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    dpv localdpv = (dpv)d.b.b(((d)localObject).lBR);
    localdpv.Tyg = paramString1;
    localdpv.TWH = paramInt1;
    localdpv.DgI = paramInt2;
    localdpv.Tyf = paramString2;
    localdpv.TUW = paramString3;
    localdpv.Oms = paramInt3;
    localdpv.fvP = paramString4;
    localdpv.OOx = paramString5;
    localdpv.TWI = 1;
    localdpv.TWJ = 1;
    localdpv.OmF = ah.gFF();
    localdpv.TWJ = 1;
    localdpv.TWI = 1;
    c((d)localObject);
    AppMethodBeat.o(204246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.m
 * JD-Core Version:    0.7.0.1
 */