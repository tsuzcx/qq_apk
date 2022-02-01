package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.protocal.protobuf.dre;

public final class n
  extends c<dre>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(215706);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new drd();
    ((d.a)localObject).lBV = new dre();
    ((d.a)localObject).funcId = 1283;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    drd localdrd = (drd)d.b.b(((d)localObject).lBR);
    localdrd.TXA = paramString1;
    localdrd.Ine = paramString2;
    localdrd.TWH = paramInt1;
    localdrd.DgI = paramInt2;
    localdrd.TUW = paramString3;
    localdrd.Oms = paramInt3;
    localdrd.OmF = ah.gFF();
    localdrd.TXB = paramInt4;
    c((d)localObject);
    AppMethodBeat.o(215706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */