package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ceh;
import com.tencent.mm.protocal.c.cei;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public a(int paramInt1, long paramLong1, long paramLong2, String paramString, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ceh();
    ((b.a)localObject).ecI = new cei();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/csvoiphangup";
    ((b.a)localObject).ecG = 880;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ceh)this.dmK.ecE.ecN;
    ((ceh)localObject).tAC = paramInt1;
    ((ceh)localObject).tTo = paramLong1;
    ((ceh)localObject).sSU = paramLong2;
    ((ceh)localObject).tTp = paramString;
    ((ceh)localObject).sZO = paramInt2;
    ((ceh)localObject).tAB = System.currentTimeMillis();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 880;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c.a
 * JD-Core Version:    0.7.0.1
 */