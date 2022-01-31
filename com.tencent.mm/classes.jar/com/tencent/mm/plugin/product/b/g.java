package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.wi;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public LinkedList<wi> mSc;
  public String mSk;
  
  public g(String paramString1, String paramString2, cm paramcm)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new agx();
    ((b.a)localObject).ecI = new agy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
    ((b.a)localObject).ecG = 578;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (agx)this.dmK.ecE.ecN;
    this.mSk = paramString1;
    ((agx)localObject).sFP = paramString1;
    y.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + paramString1);
    ((agx)localObject).sHh = paramString2;
    ((agx)localObject).tes = paramcm;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (agy)((b)paramq).ecF.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0) && (paramArrayOfByte.sHi == 0))
    {
      y.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + paramArrayOfByte.teu);
      this.mSc = paramArrayOfByte.tet;
    }
    paramInt1 = paramInt3;
    paramq = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      paramq = paramString;
      if (paramArrayOfByte.sHi != 0)
      {
        paramInt1 = paramArrayOfByte.sHi;
        paramq = paramArrayOfByte.sHj;
      }
    }
    y.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 578;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.g
 * JD-Core Version:    0.7.0.1
 */