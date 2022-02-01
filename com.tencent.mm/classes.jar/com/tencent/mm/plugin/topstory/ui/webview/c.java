package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.protocal.protobuf.dnq;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.al.f
{
  private com.tencent.mm.plugin.topstory.a.c.b BqH;
  public com.tencent.mm.al.f BuY;
  public com.tencent.mm.plugin.topstory.ui.home.a Byi;
  private boolean Byj;
  public b Byk;
  public byte[] Byl;
  public com.tencent.mm.al.f Bym;
  public com.tencent.mm.al.f Byn;
  
  public c()
  {
    AppMethodBeat.i(126558);
    this.Bym = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(126553);
        JSONObject localJSONObject = new JSONObject();
        for (;;)
        {
          try
          {
            localJSONObject.put("retCode", paramAnonymousInt2);
            localJSONObject.put("errMsg", paramAnonymousString);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Byi != null) {
            c.this.Byi.aCT(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if (c.this.Byi != null)
          {
            paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.f)paramAnonymousn).eoX().HBK;
            paramAnonymousn = ((com.tencent.mm.plugin.topstory.a.c.f)paramAnonymousn).eoX().HbT;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousn);
          }
        }
      }
    };
    this.BuY = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(126554);
        JSONObject localJSONObject = new JSONObject();
        for (;;)
        {
          try
          {
            localJSONObject.put("retCode", paramAnonymousInt2);
            localJSONObject.put("errMsg", paramAnonymousString);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Byi != null) {
            c.this.Byi.aCU(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if (c.this.Byi != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousn).eoZ().HbT);
          }
        }
      }
    };
    this.Byn = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(126555);
        JSONObject localJSONObject = new JSONObject();
        for (;;)
        {
          try
          {
            localJSONObject.put("retCode", paramAnonymousInt2);
            localJSONObject.put("errMsg", paramAnonymousString);
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).dwW);
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Byi != null) {
            c.this.Byi.aCS(localJSONObject.toString());
          }
          AppMethodBeat.o(126555);
          return;
          if (c.this.Byi != null)
          {
            localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).eoT().HPm);
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).eoT().dwW);
          }
        }
      }
    };
    AppMethodBeat.o(126558);
  }
  
  private void a(dnp paramdnp, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.Byj)
    {
      if (this.Byi != null) {
        this.Byi.aCR(paramString);
      }
      this.Byj = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (paramdnp.cSc == 100))
    {
      this.Byk = new b((byte)0);
      this.Byk.Bys = paramdnp;
      this.Byk.nWY = System.currentTimeMillis();
      this.Byk.Byr = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.Byk = null;
    AppMethodBeat.o(126564);
  }
  
  private static String eqT()
  {
    AppMethodBeat.i(126565);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret", -1);
      label21:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(126565);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label21;
    }
  }
  
  public final void a(dnp paramdnp, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    a(paramdnp, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(126561);
  }
  
  public final void a(dnp paramdnp, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.BqH != null) && (paramdnp.sessionId.equals(this.BqH.dLe.sessionId)))
    {
      this.Byj = paramBoolean1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(paramdnp, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.BqH = new com.tencent.mm.plugin.topstory.a.c.b(paramdnp, paramInt, paramString);
    g.aiU().a(1943, this);
    g.aiU().a(this.BqH, 0);
    this.Byj = paramBoolean1;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void eqS()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    com.tencent.e.h.LTJ.f(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(126563);
    if (paramn.equals(this.BqH))
    {
      g.aiU().b(1943, this);
      this.BqH = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.dLe, eqT(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramn = paramString.eoU();
      final String str = paramn.GDb;
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().Bc(paramn.HPJ);
      a(paramString.dLe, str, false);
      if ((paramString.eoU().HPI != null) && ((paramString.eoU().HPI.HjM == 1) || (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().BrP))) {
        com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            dnq localdnq = new dnq();
            localdnq.Category = paramn.HPI.Category;
            localdnq.HBG = System.currentTimeMillis();
            localdnq.HjJ = paramn.HPI.HjJ;
            localdnq.HBH = paramn.HPI.HjK;
            localdnq.hDa = str;
            localdnq.HjL = paramn.HPI.HjL;
            ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getWebViewMgr().BtH.put(Integer.valueOf(localdnq.Category), localdnq);
            try
            {
              byte[] arrayOfByte = localdnq.toByteArray();
              com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.eoL());
              if (!locale.exists()) {
                locale.mkdirs();
              }
              com.tencent.mm.vfs.i.f(com.tencent.mm.plugin.topstory.a.h.eoL() + localdnq.Category, arrayOfByte, arrayOfByte.length);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localdnq.Category), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getWebViewMgr().cl(localdnq.Category, "");
            AppMethodBeat.o(126556);
          }
        });
      }
    }
    AppMethodBeat.o(126563);
  }
  
  public final void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(126560);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.Byl != null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("json", paramString1);
        localJSONObject.put("newQuery", true);
        localJSONObject.put("isCache", true);
        if (!paramBoolean) {
          continue;
        }
        i = 1;
        localJSONObject.put("recType", i);
        if (!bt.isNullOrNil(paramString2)) {
          localJSONObject.put("filterDocidList", new JSONArray(paramString2));
        }
      }
      catch (Exception paramString1)
      {
        int i;
        continue;
      }
      this.Byl = new String(this.Byl).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.Byl.length) });
      AppMethodBeat.o(126560);
      return;
      i = 0;
    }
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(126557);
      String str = String.format("%s/%s", new Object[] { com.tencent.mm.plugin.websearch.api.ad.Wc(1).eMw(), "app.html" });
      c.this.Byl = com.tencent.mm.vfs.i.aY(str, 0, -1);
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    String Byr;
    dnp Bys;
    long nWY;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */