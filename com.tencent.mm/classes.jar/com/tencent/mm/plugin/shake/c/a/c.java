package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.dcw;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  extends n
  implements k
{
  private f callback;
  private final b rr;
  e yMo;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    AppMethodBeat.i(28185);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dcv();
    ((b.a)localObject).hNN = new dcw();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).funcId = 1250;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dcv)this.rr.hNK.hNQ;
    ((dcv)localObject).dyz = paramFloat2;
    ((dcv)localObject).dAp = paramFloat1;
    ((dcv)localObject).scene = paramInt;
    ((dcv)localObject).HrD = paramString;
    AppMethodBeat.o(28185);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(28186);
    this.callback = paramf;
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
      paramq = (dcw)this.rr.hNL.hNQ;
      if (paramq != null)
      {
        this.yMo = new e();
        this.yMo.ozA = paramq.ozA;
        this.yMo.oxM = paramq.oxM;
        this.yMo.dHY = paramq.dHY;
        this.yMo.title = paramq.title;
        this.yMo.oxN = paramq.oxN;
        this.yMo.oxO = paramq.oxO;
        this.yMo.oze = paramq.oze;
        this.yMo.hzB = paramq.hzB;
        this.yMo.hAD = paramq.hAD;
        this.yMo.yMp = paramq.yMp;
        this.yMo.yMs = paramq.yMs;
        this.yMo.yMt = paramq.yMt;
        this.yMo.yMu = paramq.yMu;
        this.yMo.yMv = paramq.yMv;
        this.yMo.yMw = paramq.yMw;
        this.yMo.oxQ = paramq.oxQ;
        this.yMo.yMx = paramq.yMx;
        this.yMo.yMy = paramq.yMy;
        m.dOU().yMr = this.yMo.yMw;
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28187);
      return;
      this.yMo = new e();
      this.yMo.ozA = 3;
      this.yMo.yMw = m.dOU().yMr;
      continue;
      this.yMo = new e();
      this.yMo.ozA = 3;
      this.yMo.yMw = m.dOU().yMr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */