package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.v;

public final class a
  extends s
{
  public b dmK;
  private f dmL;
  public int qqv = 0;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt1, String paramString8, int paramInt2)
  {
    this.qqv = paramInt1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new pk();
    ((b.a)localObject).ecI = new pl();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).ecG = 580;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (pk)this.dmK.ecE.ecN;
    ((pk)localObject).euK = paramString1;
    ((pk)localObject).sBi = paramString2;
    ((pk)localObject).sNf = paramString3;
    ((pk)localObject).sNg = paramString4;
    ((pk)localObject).sNi = paramString5;
    ((pk)localObject).sNh = paramString6;
    ((pk)localObject).sMg = paramString7;
    ((pk)localObject).sNj = paramInt1;
    ((pk)localObject).sHl = i.bVj();
    if (v.cMA()) {
      ((pk)localObject).sNk = v.cMC();
    }
    ((pk)localObject).svA = 1;
    ((pk)localObject).sNm = paramString8;
    ((pk)localObject).sNl = paramInt2;
    y.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", new Object[] { paramString1, paramString7, Integer.valueOf(paramInt1) });
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt)
  {
    this.qqv = 16;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new pk();
    ((b.a)localObject).ecI = new pl();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
    ((b.a)localObject).ecG = 580;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (pk)this.dmK.ecE.ecN;
    ((pk)localObject).euK = paramString1;
    ((pk)localObject).sBi = paramString2;
    ((pk)localObject).sNf = paramString3;
    ((pk)localObject).sNg = paramString4;
    ((pk)localObject).sNi = paramString5;
    ((pk)localObject).sNh = paramString6;
    ((pk)localObject).sNj = 16;
    ((pk)localObject).hPY = paramString7;
    ((pk)localObject).kWt = paramString8;
    ((pk)localObject).svA = 2;
    ((pk)localObject).sNm = paramString9;
    ((pk)localObject).sNl = paramInt;
    ((pk)localObject).sHl = i.bVj();
    if (v.cMA()) {
      ((pk)localObject).sNk = v.cMC();
    }
    y.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", new Object[] { paramString1, paramString7, paramString8 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final String bUH()
  {
    return ((pl)this.dmK.ecF.ecN).sog;
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    y.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    String str = paramString;
    if (paramInt1 == 0)
    {
      str = paramString;
      if (paramInt2 == 0)
      {
        paramString = (pl)((b)paramq).ecF.ecN;
        y.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.jxl + " resp.ErrMsg is " + paramString.jxm);
        paramq = (pk)((b)paramq).ecE.ecN;
        if (paramq.sMg == null) {
          break label389;
        }
        str = Uri.parse(paramq.sMg).getQueryParameter("appid");
        if (str == paramq.euK) {
          break label301;
        }
        h.nFQ.f(14954, new Object[] { paramString.sog, "", Integer.valueOf(paramq.sNj), paramq.sNm, paramq.euK, Integer.valueOf(paramq.svA), Integer.valueOf(paramq.sNl), paramq.sMg, str });
      }
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + paramString.jxl + " resp.ErrMsg is " + paramString.jxm);
      str = paramString.jxm;
      this.dmL.onSceneEnd(paramInt1, paramInt2, str, this);
      return;
      label301:
      h.nFQ.f(14954, new Object[] { paramString.sog, "", Integer.valueOf(paramq.sNj), paramq.sNm, paramq.euK, Integer.valueOf(paramq.svA), Integer.valueOf(paramq.sNl), paramq.sMg });
      continue;
      label389:
      if ((paramq.hPY != null) && (paramq.kWt != null)) {
        h.nFQ.f(14954, new Object[] { paramString.sog, "", Integer.valueOf(paramq.sNj), paramq.sNm, paramq.euK, Integer.valueOf(paramq.svA), Integer.valueOf(paramq.sNl), paramq.kWt, paramq.hPY });
      }
    }
  }
  
  public final String getToken()
  {
    return ((pl)this.dmK.ecF.ecN).token;
  }
  
  public final int getType()
  {
    return 580;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */