package com.tencent.mm.plugin.wallet_index.c.a;

import android.content.Context;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class a
  extends s
{
  private b dmK;
  private f dmL;
  public String jumpUrl;
  public String prepayId;
  public String qLi;
  public String qLu;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bdj();
    ((b.a)localObject).ecI = new bdk();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payibggenprepay";
    ((b.a)localObject).ecG = 1563;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bdj)this.dmK.ecE.ecN;
    ((bdj)localObject).euK = paramString1;
    ((bdj)localObject).sNg = paramString4;
    ((bdj)localObject).sNf = paramString2;
    ((bdj)localObject).sNh = paramString5;
    ((bdj)localObject).sNi = paramString6;
    ((bdj)localObject).sBi = paramString3;
    ((bdj)localObject).sMg = paramString7;
    ((bdj)localObject).sZw = paramString8;
    ((bdj)localObject).sss = paramInt;
    y.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString2, paramString5, paramString6, paramString3, paramString7, paramString8 }));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramq = (bdk)((b)paramq).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[] { Integer.valueOf(paramq.jxl), paramq.jxm });
      paramString = paramq.jxm;
      paramInt2 = paramq.jxl;
      this.jumpUrl = paramq.kRP;
      this.prepayId = paramq.sZx;
      this.qLi = paramq.sZy;
      this.qLu = paramq.tyB;
    }
    for (;;)
    {
      paramq = paramString;
      if (bk.bl(paramString)) {
        paramq = ae.getContext().getString(a.i.wallet_data_err);
      }
      this.dmL.onSceneEnd(paramInt1, paramInt2, paramq, this);
      return;
      y.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
      this.jumpUrl = null;
    }
  }
  
  public final int getType()
  {
    return 1563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a.a
 * JD-Core Version:    0.7.0.1
 */