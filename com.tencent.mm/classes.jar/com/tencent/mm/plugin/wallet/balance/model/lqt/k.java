package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends c<cbl>
{
  public int scene;
  
  public k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68447);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cbk();
    ((b.a)localObject).gUV = new cbl();
    ((b.a)localObject).funcId = 1770;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/preaddplan";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    cbk localcbk = (cbk)((b)localObject).gUS.gUX;
    localcbk.scene = paramInt1;
    localcbk.zEA = paramInt2;
    this.rr = ((b)localObject);
    this.scene = paramInt1;
    ad.i("MicroMsg.CgiLqtPreAddPlan", "scene: %s, planId: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(68447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.k
 * JD-Core Version:    0.7.0.1
 */