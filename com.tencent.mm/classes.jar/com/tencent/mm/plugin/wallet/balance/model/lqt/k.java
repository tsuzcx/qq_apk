package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends a<cmg>
{
  public int scene;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cmf();
    ((b.a)localObject).hQG = new cmg();
    ((b.a)localObject).funcId = 1770;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    cmf localcmf = (cmf)((b)localObject).hQD.hQJ;
    localcmf.scene = paramInt1;
    localcmf.COB = paramInt2;
    c((b)localObject);
    this.scene = paramInt1;
    ae.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */