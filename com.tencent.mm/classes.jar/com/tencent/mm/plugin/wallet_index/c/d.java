package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.cia;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.s;

public class d
  extends s
  implements g
{
  private b dmK;
  private f dmL;
  public String qLh;
  public String qLi;
  public cia qLj;
  
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9)
  {
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new aai();
    ((b.a)localObject1).ecI = new aaj();
    ((b.a)localObject1).uri = getUri();
    ((b.a)localObject1).ecG = getType();
    ((b.a)localObject1).ecJ = 189;
    ((b.a)localObject1).ecK = 1000000189;
    ((b.a)localObject1).ecM = com.tencent.mm.wallet_core.ui.e.afr(paramString4);
    this.dmK = ((b.a)localObject1).Kt();
    Object localObject2 = com.tencent.mm.plugin.soter.d.d.bKR();
    localObject1 = ((com.tencent.mm.plugin.soter.d.e)localObject2).psl;
    localObject2 = ((com.tencent.mm.plugin.soter.d.e)localObject2).psm;
    aai localaai = (aai)this.dmK.ecE.ecN;
    localaai.euK = paramString1;
    localaai.sNg = paramString4;
    localaai.sNf = paramString3;
    localaai.sNh = paramString5;
    localaai.sNi = paramString2;
    localaai.sBi = paramString6;
    localaai.sMg = paramString7;
    localaai.sZw = paramString8;
    localaai.sss = paramInt1;
    localaai.sZA = ((String)localObject1);
    localaai.sZz = ((String)localObject2);
    localaai.sHl = i.bVj();
    if (paramInt2 > 0) {
      localaai.pyo = paramInt2;
    }
    localaai.sZB = paramInt3;
    localaai.sZC = paramString9;
    y.d("MicroMsg.NetSceneGenPrepay", "appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s,WxAppScene:%s,cookie:%s", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString9 });
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneGenPrepay", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    paramString = (aaj)((b)paramq).ecF.ecN;
    y.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[] { Integer.valueOf(paramString.jxl), paramString.jxm });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.d("MicroMsg.NetSceneGenPrepay", "rr " + paramString.sZx);
      this.qLh = paramString.sZx;
      this.qLi = paramString.sZy;
      this.qLj = paramString.sZD;
    }
    paramq = paramString.jxm;
    paramInt2 = paramString.jxl;
    this.dmL.onSceneEnd(paramInt1, paramInt2, paramq, this);
  }
  
  public int getType()
  {
    return 398;
  }
  
  public String getUri()
  {
    return "/cgi-bin/mmpay-bin/genprepay";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.d
 * JD-Core Version:    0.7.0.1
 */