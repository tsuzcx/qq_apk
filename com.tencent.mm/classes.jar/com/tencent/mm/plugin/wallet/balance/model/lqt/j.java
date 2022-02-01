package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bze;
import com.tencent.mm.protocal.protobuf.bzf;

public final class j
  extends c<bzf>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bze();
    ((b.a)localObject).hvu = new bzf();
    ((b.a)localObject).funcId = 1830;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    bze localbze = (bze)((b)localObject).hvr.hvw;
    localbze.ErG = paramInt;
    localbze.AYl = ae.eon();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */