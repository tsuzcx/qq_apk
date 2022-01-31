package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ccx;
import com.tencent.mm.protocal.c.ccy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  extends s
{
  private final b dmK;
  private f dmL;
  public int errCode;
  public String iZD = null;
  public String iZF;
  public int qLI = 0;
  
  public r(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ccx();
    ((b.a)localObject).ecI = new ccy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifypurchase";
    ((b.a)localObject).ecG = 414;
    ((b.a)localObject).ecJ = 215;
    ((b.a)localObject).ecK = 1000000215;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ccx)this.dmK.ecE.ecN;
    this.iZD = paramString1;
    ((ccx)localObject).syc = paramString1;
    ((ccx)localObject).tRN = paramInt1;
    ((ccx)localObject).tAj = paramInt3;
    ((ccx)localObject).mPQ = paramInt2;
    if (!bk.bl(paramString6))
    {
      ((ccx)localObject).tAh = paramString6;
      ((ccx)localObject).tAi = paramString5;
    }
    ((ccx)localObject).tAk = paramString2;
    ((ccx)localObject).tRP = paramString4;
    if (paramString3 != null) {
      paramString1 = paramString3.getBytes();
    }
    for (((ccx)localObject).tRM = new bmk().bs(paramString1);; ((ccx)localObject).tRM = new bmk())
    {
      ((ccx)localObject).tRO = ((int)bk.UX());
      y.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.iZD + ",verifyType:" + paramInt1 + ",palyType:" + paramInt2 + ",payload:" + paramString2 + ",purchaseData:" + paramString3 + ",dataSignature:" + paramString4);
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + paramInt1 + "   errCode:" + paramInt2);
    this.errCode = 0;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.errCode = -1;
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
      return;
    }
    paramq = (ccy)((b)paramq).ecF.ecN;
    if (paramq.tFx != null)
    {
      this.qLI = paramq.tRR;
      y.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + paramq.sTa);
      y.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + paramq.tRQ);
      this.iZF = paramq.sTa;
    }
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 414;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.r
 * JD-Core Version:    0.7.0.1
 */