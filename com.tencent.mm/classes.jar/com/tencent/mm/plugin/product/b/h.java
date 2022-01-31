package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ajb;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class h
  extends com.tencent.mm.ah.m
  implements k
{
  private b dmK;
  private f dmL;
  public String mSk;
  public m mSl;
  public List<n> mSm;
  
  public h(m paramm, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aja();
    ((b.a)localObject).ecI = new ajb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getproductdetail";
    ((b.a)localObject).ecG = 553;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aja)this.dmK.ecE.ecN;
    this.mSk = paramString;
    ((aja)localObject).tfK = paramString;
    y.d("MicroMsg.NetSceneMallGetProductDetail", "pid " + paramString);
    ((aja)localObject).hQQ = 0;
    this.mSl = paramm;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (ajb)((b)paramq).ecF.ecN;
    if (!bk.bl(paramArrayOfByte.tfM))
    {
      y.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + paramArrayOfByte.tfM);
      this.mSl = m.a(this.mSl, paramArrayOfByte.tfM);
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
    if (!bk.bl(paramArrayOfByte.tfN))
    {
      y.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + paramArrayOfByte.tfN);
      this.mSm = n.parse(paramArrayOfByte.tfN);
    }
    y.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + paramInt1 + ", errMsg " + paramq);
    this.dmL.onSceneEnd(paramInt2, paramInt1, paramq, this);
  }
  
  public final int getType()
  {
    return 553;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.b.h
 * JD-Core Version:    0.7.0.1
 */