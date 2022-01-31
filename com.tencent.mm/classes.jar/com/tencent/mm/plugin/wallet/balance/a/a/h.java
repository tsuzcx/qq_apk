package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
  extends a<bnd>
{
  public int scene;
  
  public h(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45234);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bnc();
    ((b.a)localObject).fsY = new bnd();
    ((b.a)localObject).funcId = 1770;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).ado();
    bnc localbnc = (bnc)((b)localObject).fsV.fta;
    localbnc.scene = paramInt1;
    localbnc.wpg = paramInt2;
    this.rr = ((b)localObject);
    this.scene = paramInt1;
    ab.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(45234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.h
 * JD-Core Version:    0.7.0.1
 */