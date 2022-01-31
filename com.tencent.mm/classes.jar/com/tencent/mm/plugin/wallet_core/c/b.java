package com.tencent.mm.plugin.wallet_core.c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.s;

public final class b
  extends s
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public int qqv = 0;
  public pz qqw;
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt, (byte)0);
  }
  
  private b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, byte paramByte)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new py();
    ((b.a)localObject).ecI = new pz();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
    ((b.a)localObject).ecG = 2728;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (py)this.dmK.ecE.ecN;
    ((py)localObject).euK = paramString1;
    ((py)localObject).sBi = paramString2;
    ((py)localObject).sNf = paramString3;
    ((py)localObject).sNg = paramString4;
    ((py)localObject).sNi = paramString5;
    ((py)localObject).sNh = paramString6;
    ((py)localObject).sMg = paramString7;
    ((py)localObject).sNj = 5;
    ((py)localObject).sHl = i.bVj();
    ((py)localObject).svA = 1;
    ((py)localObject).hPY = null;
    ((py)localObject).kWt = null;
    ((py)localObject).sNm = paramString8;
    ((py)localObject).sNl = paramInt;
    boolean bool = ((k)g.r(k.class)).aSw();
    paramString4 = ae.cqS();
    paramString3 = null;
    paramString2 = null;
    if (paramString4 != null)
    {
      paramString3 = paramString4.getString("cpu_id", null);
      paramString2 = paramString4.getString("uid", null);
    }
    ((py)localObject).sNJ = 0;
    ((py)localObject).psl = paramString3;
    ((py)localObject).psm = paramString2;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((py)localObject).sNK = paramInt;
      y.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", new Object[] { paramString3, paramString2 });
      y.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", new Object[] { paramString1, paramString7, Integer.valueOf(5), Boolean.valueOf(bool) });
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
    y.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + paramInt1 + ",errCode:" + paramInt2 + ",errMsg" + paramString);
    String str = paramString;
    if (paramInt1 == 0)
    {
      str = paramString;
      if (paramInt2 == 0)
      {
        this.qqw = ((pz)((com.tencent.mm.ah.b)paramq).ecF.ecN);
        paramString = (py)((com.tencent.mm.ah.b)paramq).ecE.ecN;
        if (paramString.sMg == null) {
          break label357;
        }
        paramq = Uri.parse(paramString.sMg).getQueryParameter("appid");
        if (paramq == paramString.euK) {
          break label272;
        }
        h.nFQ.f(14954, new Object[] { this.qqw.sog, "", Integer.valueOf(paramString.sNj), paramString.sNm, paramString.euK, Integer.valueOf(paramString.svA), Integer.valueOf(paramString.sNl), paramString.sMg, paramq });
      }
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.qqw.jxl + " resp.ErrMsg is " + this.qqw.jxm);
      str = this.qqw.jxm;
      this.dmL.onSceneEnd(paramInt1, paramInt2, str, this);
      return;
      label272:
      h.nFQ.f(14954, new Object[] { this.qqw.sog, "", Integer.valueOf(paramString.sNj), paramString.sNm, paramString.euK, Integer.valueOf(paramString.svA), Integer.valueOf(paramString.sNl), paramString.sMg });
      continue;
      label357:
      if ((paramString.hPY != null) && (paramString.kWt != null)) {
        h.nFQ.f(14954, new Object[] { this.qqw.sog, "", Integer.valueOf(paramString.sNj), paramString.sNm, paramString.euK, Integer.valueOf(paramString.svA), Integer.valueOf(paramString.sNl), paramString.kWt, paramString.hPY });
      }
    }
  }
  
  public final int getType()
  {
    return 580;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */