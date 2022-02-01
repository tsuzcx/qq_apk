package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.buo;

public final class j
  extends c<buo>
{
  public j(int paramInt)
  {
    AppMethodBeat.i(68407);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bun();
    ((b.a)localObject).gUV = new buo();
    ((b.a)localObject).funcId = 1830;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    bun localbun = (bun)((b)localObject).gUS.gUX;
    localbun.CYU = paramInt;
    localbun.zFY = ae.dYR();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.j
 * JD-Core Version:    0.7.0.1
 */