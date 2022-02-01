package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cuv;

public final class i
  extends c<cuv>
{
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cuu();
    ((d.a)localObject).iLO = new cuv();
    ((d.a)localObject).funcId = 2585;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    cuu localcuu = (cuu)((d)localObject).iLK.iLR;
    localcuu.yba = paramInt1;
    localcuu.HuF = paramInt2;
    localcuu.HuS = ag.fNb();
    c((d)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */