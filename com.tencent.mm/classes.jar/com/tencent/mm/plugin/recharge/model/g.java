package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bwi;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class g
  extends s
  implements com.tencent.mm.wallet_core.c.g
{
  private b dmK;
  private f dmL;
  public String mAppId;
  public PayInfo nqa;
  
  public g(MallRechargeProduct paramMallRechargeProduct, String paramString)
  {
    this(paramMallRechargeProduct.appId, paramMallRechargeProduct.npy, paramMallRechargeProduct.bJd, paramString);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bwi();
    ((b.a)localObject).ecI = new bwj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
    ((b.a)localObject).ecG = 498;
    ((b.a)localObject).ecJ = 230;
    ((b.a)localObject).ecK = 1000000230;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bwi)this.dmK.ecE.ecN;
    y.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[] { paramString4 });
    this.mAppId = paramString1;
    ((bwi)localObject).sYA = paramString1;
    ((bwi)localObject).sYz = paramString2;
    ((bwi)localObject).tev = paramString3;
    ((bwi)localObject).sYB = paramString4;
    ((bwi)localObject).sRr = c.bWg().Qw(paramString2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    this.nqa = new PayInfo();
    Object localObject = (bwj)((b)paramq).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + ((bwj)localObject).sye);
      this.nqa.appId = this.mAppId;
      this.nqa.qLi = ((bwj)localObject).sZy;
      this.nqa.bMX = ((bwj)localObject).sye;
    }
    int i = paramInt2;
    if (paramInt2 == 0) {
      i = ((bwj)localObject).sYC;
    }
    paramq = paramString;
    if (bk.bl(paramString)) {
      paramq = ((bwj)localObject).sYD;
    }
    this.nqa.snW = String.valueOf(i);
    localObject = this.nqa;
    if (paramq != null) {}
    for (paramString = paramq;; paramString = "")
    {
      ((PayInfo)localObject).aox = paramString;
      y.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i + ", errMsg " + paramq);
      this.dmL.onSceneEnd(paramInt1, i, paramq, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 498;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.model.g
 * JD-Core Version:    0.7.0.1
 */