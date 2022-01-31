package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bhe;
import com.tencent.mm.protocal.protobuf.bhf;

public final class e
  extends a<bhf>
{
  public e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45231);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhe();
    ((b.a)localObject).fsY = new bhf();
    ((b.a)localObject).funcId = 2585;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bhe localbhe = (bhe)((b)localObject).fsV.fta;
    localbhe.wMx = paramInt1;
    localbhe.uha = paramInt2;
    localbhe.tNy = ab.cQT();
    this.rr = ((b)localObject);
    AppMethodBeat.o(45231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.e
 * JD-Core Version:    0.7.0.1
 */