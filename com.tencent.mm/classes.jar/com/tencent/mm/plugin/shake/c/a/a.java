package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public a(String paramString1, String paramString2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new lq();
    ((b.a)localObject).ecI = new lr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
    ((b.a)localObject).ecG = 1252;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (lq)this.dmK.ecE.ecN;
    ((lq)localObject).iln = paramString1;
    ((lq)localObject).bZd = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252 errType = " + paramInt2 + " errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1252;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.a
 * JD-Core Version:    0.7.0.1
 */