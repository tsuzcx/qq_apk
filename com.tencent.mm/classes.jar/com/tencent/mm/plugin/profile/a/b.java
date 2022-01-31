package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.protocal.c.bqh;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public b(String paramString, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqg();
    ((b.a)localObject).ecI = new bqh();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
    ((b.a)localObject).ecG = 1363;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqg)this.dmK.ecE.ecN;
    ((bqg)localObject).sCO = paramString;
    ((bqg)localObject).tHC = paramInt;
    ((bqg)localObject).tHD = 4;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1363;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.b
 * JD-Core Version:    0.7.0.1
 */