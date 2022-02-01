package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;

public final class f
  extends c<xk>
{
  public f(String paramString, int paramInt)
  {
    AppMethodBeat.i(68403);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new xj();
    ((b.a)localObject).hvu = new xk();
    ((b.a)localObject).funcId = 1386;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    xj localxj = (xj)((b)localObject).hvr.hvw;
    localxj.ErF = paramString;
    localxj.ErG = paramInt;
    localxj.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.f
 * JD-Core Version:    0.7.0.1
 */