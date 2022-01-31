package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class c
  extends s
{
  private b dmK;
  private f dmL;
  public String qLh;
  public String qLi;
  
  public c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, String paramString9)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aag();
    ((b.a)localObject).ecI = new aah();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/genmallprepay";
    ((b.a)localObject).ecG = 2755;
    ((b.a)localObject).ecJ = 189;
    ((b.a)localObject).ecK = 1000000189;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aag)this.dmK.ecE.ecN;
    ((aag)localObject).euK = paramString1;
    ((aag)localObject).sNg = paramString4;
    ((aag)localObject).sNf = paramString3;
    ((aag)localObject).sNh = paramString5;
    ((aag)localObject).sNi = paramString2;
    ((aag)localObject).sBi = paramString6;
    ((aag)localObject).sMg = paramString7;
    ((aag)localObject).sZw = paramString8;
    ((aag)localObject).sss = paramInt1;
    ((aag)localObject).kWx = paramString9;
    if (paramInt2 > 0) {
      ((aag)localObject).pyo = paramInt2;
    }
    y.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    paramString = (aah)((b)paramq).ecF.ecN;
    y.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.jxl), paramString.jxm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.NetSceneGenMallPrepay", "rr " + paramString.sZx);
      this.qLh = paramString.sZx;
      this.qLi = paramString.sZy;
    }
    paramq = paramString.jxm;
    paramInt2 = paramString.jxl;
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramq, this);
  }
  
  public final int getType()
  {
    return 2755;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.c
 * JD-Core Version:    0.7.0.1
 */