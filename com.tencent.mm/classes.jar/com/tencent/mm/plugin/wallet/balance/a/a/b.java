package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.protocal.protobuf.ty;

public final class b
  extends a<ty>
{
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(45228);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new tx();
    ((b.a)localObject).fsY = new ty();
    ((b.a)localObject).funcId = 1386;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/closefundaccount";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    tx localtx = (tx)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localtx.wMw = paramString;
    localtx.wMx = paramInt;
    localtx.tNy = ab.cQT();
    this.rr = ((com.tencent.mm.ai.b)localObject);
    AppMethodBeat.o(45228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.b
 * JD-Core Version:    0.7.0.1
 */