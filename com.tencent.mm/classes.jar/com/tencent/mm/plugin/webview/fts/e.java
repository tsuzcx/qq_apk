package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.u.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.c.ckt;
import com.tencent.mm.protocal.c.ckx;
import com.tencent.mm.protocal.c.cky;
import com.tencent.mm.protocal.c.cmx;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedList;
import org.json.JSONArray;

public final class e
  extends com.tencent.mm.plugin.websearch.api.b
  implements k
{
  s dZR;
  private f dmL;
  private com.tencent.mm.ah.b esv;
  private cky qZu;
  
  public e(s params)
  {
    this.dZR = params;
    this.Db = params.bGm;
    this.fzn = params.scene;
    this.qTt = params.bVm;
    Object localObject;
    int i;
    if (!bk.bl(params.bGm))
    {
      y.i("MicroMsg.FTS.NetSceneWebSuggest", "Constructors: query=%s", new Object[] { params.bGm });
      localObject = new b.a();
      if ((params.scene == 201) || (params.qTI == 1)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) && (r.aqs()))
      {
        ((b.a)localObject).ecG = 1747;
        ((b.a)localObject).uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
        label115:
        ((b.a)localObject).ecH = new ckx();
        ((b.a)localObject).ecI = new cky();
        this.esv = ((b.a)localObject).Kt();
        localObject = (ckx)this.esv.ecE.ecN;
        ((ckx)localObject).sYZ = params.bGm;
        ((ckx)localObject).sFC = params.businessType;
        ((ckx)localObject).tpI = aa.Bs(0);
        ((ckx)localObject).tEN = params.qTw;
        ((ckx)localObject).tqT = aa.Jx();
        ((ckx)localObject).pyo = params.scene;
        ((ckx)localObject).tpM = params.bIB;
        if (params.qTK == null) {}
      }
      try
      {
        ((ckx)localObject).tpN = new com.tencent.mm.bv.b(params.qTK.toByteArray());
        label252:
        if (params.qTJ != null) {}
        try
        {
          ((ckx)localObject).tpO = new com.tencent.mm.bv.b(params.qTJ.toByteArray());
          try
          {
            label278:
            JSONArray localJSONArray = new JSONArray(params.qTB);
            ((ckx)localObject).tYi = new LinkedList();
            i = 0;
            while (i < localJSONArray.length())
            {
              String str = URLDecoder.decode(localJSONArray.getString(i), "UTF-8");
              ((ckx)localObject).tYi.add(str);
              i += 1;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            y.printErrStackTrace("MicroMsg.FTS.NetSceneWebSuggest", localException1, "decode json error", new Object[0]);
            i = params.businessType;
            if (((ckx)localObject).tqT == null) {
              break label465;
            }
          }
          ((b.a)localObject).ecG = 1161;
          ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
          break label115;
          label465:
          for (boolean bool = true;; bool = false)
          {
            y.i("MicroMsg.FTS.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(params.scene), Integer.valueOf(params.businessType), Integer.valueOf(params.qTw), Integer.valueOf(params.bVm) });
            return;
          }
          y.e("MicroMsg.FTS.NetSceneWebSuggest", "keyword is unavailable");
          return;
        }
        catch (IOException localIOException)
        {
          break label278;
        }
      }
      catch (Exception localException2)
      {
        break label252;
      }
    }
  }
  
  public final String Jv()
  {
    if (this.qZu != null) {
      return this.qZu.sEb;
    }
    return "";
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FTS.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.qZu = ((cky)this.esv.ecF.ecN);
    if (this.qZu != null) {
      y.v("MicroMsg.FTS.NetSceneWebSuggest", "return data\n%s", new Object[] { this.qZu.sEb });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1161;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.e
 * JD-Core Version:    0.7.0.1
 */