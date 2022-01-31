package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.bee;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class a
  extends s
{
  private b dmK;
  private f dmL;
  public String qLh;
  public String qLi;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bed();
    ((b.a)localObject).ecI = new bee();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((b.a)localObject).ecG = 1521;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bed)this.dmK.ecE.ecN;
    ((bed)localObject).euK = paramString1;
    ((bed)localObject).sNg = paramString4;
    ((bed)localObject).sNf = paramString3;
    ((bed)localObject).sNh = paramString5;
    ((bed)localObject).sNi = paramString2;
    ((bed)localObject).sBi = paramString6;
    ((bed)localObject).sMg = paramString7;
    ((bed)localObject).sZw = paramString8;
    ((bed)localObject).sss = paramInt;
    y.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    paramString = (bee)((b)paramq).ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.sZx);
      this.qLh = paramString.sZx;
      this.qLi = paramString.sZy;
    }
    paramString = paramString.jxm;
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramString, this);
  }
  
  public final int getType()
  {
    return 1521;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */