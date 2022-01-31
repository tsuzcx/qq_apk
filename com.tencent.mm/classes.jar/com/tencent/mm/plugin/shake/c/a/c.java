package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.ah.m
  implements k
{
  private final b dmK;
  private f dmL;
  e nZn;
  
  public c(float paramFloat1, float paramFloat2, int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqw();
    ((b.a)localObject).ecI = new bqx();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/shakecard";
    ((b.a)localObject).ecG = 1250;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqw)this.dmK.ecE.ecN;
    ((bqw)localObject).bRt = paramFloat2;
    ((bqw)localObject).bTc = paramFloat1;
    ((bqw)localObject).scene = paramInt;
    ((bqw)localObject).tHH = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250 errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bqx)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        this.nZn = new e();
        this.nZn.imX = paramq.imX;
        this.nZn.iln = paramq.iln;
        this.nZn.bZd = paramq.bZd;
        this.nZn.title = paramq.title;
        this.nZn.ilq = paramq.ilq;
        this.nZn.ilr = paramq.ilr;
        this.nZn.imA = paramq.imA;
        this.nZn.ilp = paramq.ilp;
        this.nZn.color = paramq.color;
        this.nZn.nZo = paramq.nZo;
        this.nZn.nZr = paramq.nZr;
        this.nZn.nZs = paramq.nZs;
        this.nZn.nZt = paramq.nZt;
        this.nZn.nZu = paramq.nZu;
        this.nZn.nZv = paramq.nZv;
        this.nZn.end_time = paramq.end_time;
        this.nZn.nZw = paramq.nZw;
        this.nZn.nZx = paramq.nZx;
        com.tencent.mm.plugin.shake.b.m.bAa().nZq = this.nZn.nZv;
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      this.nZn = new e();
      this.nZn.imX = 3;
      this.nZn.nZv = com.tencent.mm.plugin.shake.b.m.bAa().nZq;
      continue;
      this.nZn = new e();
      this.nZn.imX = 3;
      this.nZn.nZv = com.tencent.mm.plugin.shake.b.m.bAa().nZq;
    }
  }
  
  public final int getType()
  {
    return 1250;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */