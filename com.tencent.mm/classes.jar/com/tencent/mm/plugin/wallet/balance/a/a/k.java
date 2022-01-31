package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bpu;

public final class k
  extends a<bpu>
{
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(45237);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bpt();
    ((b.a)localObject).fsY = new bpu();
    ((b.a)localObject).funcId = 1283;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bpt localbpt = (bpt)((b)localObject).fsV.fta;
    localbpt.xDG = paramString1;
    localbpt.qkt = paramString2;
    localbpt.xCQ = paramInt1;
    localbpt.wMx = paramInt2;
    localbpt.xBE = paramString3;
    localbpt.tNy = ab.cQT();
    this.rr = ((b)localObject);
    AppMethodBeat.o(45237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.k
 * JD-Core Version:    0.7.0.1
 */