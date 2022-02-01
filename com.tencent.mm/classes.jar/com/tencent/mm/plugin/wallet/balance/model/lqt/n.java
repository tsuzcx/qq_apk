package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.cjq;

public final class n
  extends c<cjq>
{
  public n(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(68450);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cjp();
    ((b.a)localObject).hvu = new cjq();
    ((b.a)localObject).funcId = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cjp localcjp = (cjp)((b)localObject).hvr.hvw;
    localcjp.Fxp = paramString1;
    localcjp.wLA = paramString2;
    localcjp.Fww = paramInt1;
    localcjp.ErG = paramInt2;
    localcjp.FuW = paramString3;
    localcjp.AYa = paramInt3;
    localcjp.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.n
 * JD-Core Version:    0.7.0.1
 */