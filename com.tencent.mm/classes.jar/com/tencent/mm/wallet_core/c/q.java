package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  extends s
{
  public final b dmK;
  private f dmL;
  public String iZD;
  public String qLe;
  public String qLf;
  
  public q(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bfn();
    ((b.a)localObject).ecI = new bfo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/preparepurchase";
    ((b.a)localObject).ecG = 422;
    ((b.a)localObject).ecJ = 214;
    ((b.a)localObject).ecK = 1000000214;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bfn)this.dmK.ecE.ecN;
    this.iZD = paramString1;
    ((bfn)localObject).syc = paramString1;
    this.qLf = paramString2;
    ((bfn)localObject).tAh = paramString2;
    this.qLe = paramString3;
    ((bfn)localObject).tAi = paramString3;
    ((bfn)localObject).mPQ = paramInt2;
    ((bfn)localObject).tAj = paramInt1;
    ((bfn)localObject).kWx = paramString4;
    y.d("MicroMsg.NetScenePreparePurchase", "productId:" + paramString1 + ",price:" + paramString2 + ",currencyType:" + paramString3 + ",payType:" + paramInt2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.network.q paramq)
  {
    y.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg:" + paramString);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 422;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.q
 * JD-Core Version:    0.7.0.1
 */