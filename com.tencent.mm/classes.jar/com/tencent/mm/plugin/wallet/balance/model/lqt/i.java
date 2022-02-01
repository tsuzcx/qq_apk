package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzd;

public final class i
  extends c<bzd>
{
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bzc();
    ((b.a)localObject).hvu = new bzd();
    ((b.a)localObject).funcId = 2585;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    bzc localbzc = (bzc)((b)localObject).hvr.hvw;
    localbzc.ErG = paramInt1;
    localbzc.AYa = paramInt2;
    localbzc.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */