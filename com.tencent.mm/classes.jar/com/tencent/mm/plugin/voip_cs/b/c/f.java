package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cet;
import com.tencent.mm.protocal.c.ceu;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  public b dmK;
  private com.tencent.mm.ah.f dmL;
  
  public f(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cet();
    ((b.a)localObject).ecI = new ceu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipsync";
    ((b.a)localObject).ecG = 818;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cet)this.dmK.ecE.ecN;
    ((cet)localObject).tTo = paramLong1;
    ((cet)localObject).sSU = paramLong2;
    ((cet)localObject).tTy = paramInt;
    ((cet)localObject).tAB = System.currentTimeMillis();
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 818;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.f
 * JD-Core Version:    0.7.0.1
 */