package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cej;
import com.tencent.mm.protocal.c.cek;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b(long paramLong1, long paramLong2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cej();
    ((b.a)localObject).ecI = new cek();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
    ((b.a)localObject).ecG = 795;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (cej)this.dmK.ecE.ecN;
    ((cej)localObject).tTo = paramLong1;
    ((cej)localObject).sSU = paramLong2;
    ((cej)localObject).tAB = System.currentTimeMillis();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 795;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.b
 * JD-Core Version:    0.7.0.1
 */