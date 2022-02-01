package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cux;

public final class j
  extends c<cux>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cuw();
    ((d.a)localObject).iLO = new cux();
    ((d.a)localObject).funcId = 1830;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    cuw localcuw = (cuw)((d)localObject).iLK.iLR;
    localcuw.yba = paramInt;
    localcuw.HuS = ag.fNb();
    c((d)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */