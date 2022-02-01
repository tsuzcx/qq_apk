package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private g callback;
  private final b rr;
  e wmn;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new crz();
    ((b.a)localObject).gUV = new csa();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).funcId = 1250;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (crz)this.rr.gUS.gUX;
    ((crz)localObject).dpb = paramFloat2;
    ((crz)localObject).dqQ = paramFloat1;
    ((crz)localObject).scene = paramInt;
    ((crz)localObject).EjX = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(28186);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(28186);
    return i;
  }
  
  public final int getType()
  {
    return 1250;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28187);
    ad.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (csa)this.rr.gUT.gUX;
      if (paramq != null)
      {
        this.wmn = new e();
        this.wmn.ntg = paramq.ntg;
        this.wmn.nrr = paramq.nrr;
        this.wmn.dyd = paramq.dyd;
        this.wmn.title = paramq.title;
        this.wmn.nrs = paramq.nrs;
        this.wmn.nrt = paramq.nrt;
        this.wmn.nsK = paramq.nsK;
        this.wmn.gGR = paramq.gGR;
        this.wmn.gHT = paramq.gHT;
        this.wmn.wmo = paramq.wmo;
        this.wmn.wmr = paramq.wmr;
        this.wmn.wms = paramq.wms;
        this.wmn.wmt = paramq.wmt;
        this.wmn.wmu = paramq.wmu;
        this.wmn.wmv = paramq.wmv;
        this.wmn.nrv = paramq.nrv;
        this.wmn.wmw = paramq.wmw;
        this.wmn.wmx = paramq.wmx;
        m.dph().wmq = this.wmn.wmv;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.wmn = new e();
      this.wmn.ntg = 3;
      this.wmn.wmv = m.dph().wmq;
      continue;
      this.wmn = new e();
      this.wmn.ntg = 3;
      this.wmn.wmv = m.dph().wmq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */