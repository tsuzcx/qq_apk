package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.sdk.platformtools.ac;

public final class k
  extends c<cgn>
{
  public int scene;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cgm();
    ((b.a)localObject).hvu = new cgn();
    ((b.a)localObject).funcId = 1770;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
    cgm localcgm = (cgm)((b)localObject).hvr.hvw;
    localcgm.scene = paramInt1;
    localcgm.AWN = paramInt2;
    this.rr = ((b)localObject);
    this.scene = paramInt1;
    ac.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */