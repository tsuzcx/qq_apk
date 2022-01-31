package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;

public final class f
  extends a<bhh>
{
  public f(int paramInt)
  {
    AppMethodBeat.i(45232);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bhg();
    ((b.a)localObject).fsY = new bhh();
    ((b.a)localObject).funcId = 1830;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickredeem";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bhg localbhg = (bhg)((b)localObject).fsV.fta;
    localbhg.wMx = paramInt;
    localbhg.tNy = ab.cQT();
    this.rr = ((b)localObject);
    AppMethodBeat.o(45232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.f
 * JD-Core Version:    0.7.0.1
 */