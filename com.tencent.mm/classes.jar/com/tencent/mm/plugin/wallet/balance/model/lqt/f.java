package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.abc;

public final class f
  extends c<abc>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new abb();
    ((d.a)localObject).iLO = new abc();
    ((d.a)localObject).funcId = 1386;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    abb localabb = (abb)((d)localObject).iLK.iLR;
    localabb.Lmm = paramString;
    localabb.yba = paramInt;
    localabb.HuS = ag.fNb();
    c((d)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */