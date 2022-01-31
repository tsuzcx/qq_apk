package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.hd;

public final class i
  extends a<bnk>
{
  public i(int paramInt1, hd paramhd, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(45235);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bnj();
    ((b.a)localObject).fsY = new bnk();
    ((b.a)localObject).funcId = 1324;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preredeemfund";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bnj localbnj = (bnj)((b)localObject).fsV.fta;
    localbnj.xBA = paramInt1;
    if (paramhd != null) {
      localbnj.xBB = 1;
    }
    for (localbnj.xBC = paramhd;; localbnj.xBC = null)
    {
      localbnj.wMx = paramInt2;
      localbnj.xBD = paramInt3;
      localbnj.xBE = paramString;
      localbnj.tNy = ab.cQT();
      this.rr = ((b)localObject);
      AppMethodBeat.o(45235);
      return;
      localbnj.xBB = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.i
 * JD-Core Version:    0.7.0.1
 */