package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ceo;
import com.tencent.mm.protocal.c.cep;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public d(long paramLong1, long paramLong2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ceo();
    ((b.a)localObject).ecI = new cep();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoipredirect";
    ((b.a)localObject).ecG = 285;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ceo)this.dmK.ecE.ecN;
    ((ceo)localObject).tTo = paramLong1;
    ((ceo)localObject).sSU = paramLong2;
    ((ceo)localObject).tAB = System.currentTimeMillis();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 285;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.d
 * JD-Core Version:    0.7.0.1
 */