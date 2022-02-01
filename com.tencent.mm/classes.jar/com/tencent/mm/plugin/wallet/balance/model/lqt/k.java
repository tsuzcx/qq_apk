package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends a<clm>
{
  public int scene;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cll();
    ((b.a)localObject).hNN = new clm();
    ((b.a)localObject).funcId = 1770;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    cll localcll = (cll)((b)localObject).hNK.hNQ;
    localcll.scene = paramInt1;
    localcll.CwW = paramInt2;
    c((b)localObject);
    this.scene = paramInt1;
    ad.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */