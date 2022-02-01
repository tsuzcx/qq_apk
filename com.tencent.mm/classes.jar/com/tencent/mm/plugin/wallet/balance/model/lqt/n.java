package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhj;

public final class n
  extends c<dhj>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(213847);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dhi();
    ((d.a)localObject).iLO = new dhj();
    ((d.a)localObject).funcId = 1283;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    dhi localdhi = (dhi)((d)localObject).iLK.iLR;
    localdhi.MLF = paramString1;
    localdhi.CpP = paramString2;
    localdhi.MKM = paramInt1;
    localdhi.yba = paramInt2;
    localdhi.MJh = paramString3;
    localdhi.HuF = paramInt3;
    localdhi.HuS = ag.fNb();
    localdhi.MLG = paramInt4;
    c((d)localObject);
    AppMethodBeat.o(213847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */