package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;

public final class y
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  int rUy;
  x rUz;
  
  public y(int paramInt, x paramx)
  {
    this.rUy = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new dc();
    ((b.a)localObject).ecI = new dd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/appcenter";
    ((b.a)localObject).ecG = 452;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (dc)this.dmK.ecE.ecN;
    byte[] arrayOfByte = paramx.ckB();
    if (arrayOfByte != null) {
      ((dc)localObject).swr = new bmk().bs(arrayOfByte);
    }
    ((dc)localObject).hQR = paramInt;
    this.rUz = paramx;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.NetSceneAppCenter", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.rUz.bi(aa.a(((dd)this.dmK.ecF.ecN).sws));
    this.rUz.a(paramInt1, paramInt2, paramInt3, paramString, this.dmK, paramArrayOfByte);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.y
 * JD-Core Version:    0.7.0.1
 */