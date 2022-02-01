package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.cmi;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.ak.g
{
  public com.tencent.mm.ak.g Adn;
  public com.tencent.mm.ak.g AgA;
  public com.tencent.mm.ak.g AgB;
  public com.tencent.mm.plugin.topstory.ui.home.a Agw;
  private boolean Agx;
  public b Agy;
  public byte[] Agz;
  private com.tencent.mm.plugin.topstory.a.c.b zYV;
  
  public c()
  {
    AppMethodBeat.i(126558);
    this.AgA = new com.tencent.mm.ak.g()
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
            ac.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Agw != null) {
            c.this.Agw.axO(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if (c.this.Agw != null)
          {
            paramAnonymousString = ((f)paramAnonymousn).ecG().FRe;
            paramAnonymousn = ((f)paramAnonymousn).ecG().FrP;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousn);
          }
        }
      }
    };
    this.Adn = new com.tencent.mm.ak.g()
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
            ac.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Agw != null) {
            c.this.Agw.axP(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if (c.this.Agw != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousn).ecI().FrP);
          }
        }
      }
    };
    this.AgB = new com.tencent.mm.ak.g()
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
            ac.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).dlj);
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.Agw != null) {
            c.this.Agw.axN(localJSONObject.toString());
          }
          AppMethodBeat.o(126555);
          return;
          if (c.this.Agw != null)
          {
            localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).ecC().Geg);
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousn).ecC().dlj);
          }
        }
      }
    };
    AppMethodBeat.o(126558);
  }
  
  private void a(dia paramdia, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.Agx)
    {
      if (this.Agw != null) {
        this.Agw.axM(paramString);
      }
      this.Agx = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (paramdia.cGY == 100))
    {
      this.Agy = new b((byte)0);
      this.Agy.AgG = paramdia;
      this.Agy.nvA = System.currentTimeMillis();
      this.Agy.AgF = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.Agy = null;
    AppMethodBeat.o(126564);
  }
  
  private static String eeC()
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
  
  public final void a(dia paramdia, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    a(paramdia, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(126561);
  }
  
  public final void a(dia paramdia, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    ac.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.zYV != null) && (paramdia.sessionId.equals(this.zYV.dyS.sessionId)))
    {
      this.Agx = paramBoolean1;
      ac.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(paramdia, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.zYV = new com.tencent.mm.plugin.topstory.a.c.b(paramdia, paramInt, paramString);
    com.tencent.mm.kernel.g.agi().a(1943, this);
    com.tencent.mm.kernel.g.agi().a(this.zYV, 0);
    this.Agx = paramBoolean1;
    ac.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void eeB()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    com.tencent.e.h.JZN.f(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(126563);
    if (paramn.equals(this.zYV))
    {
      com.tencent.mm.kernel.g.agi().b(1943, this);
      this.zYV = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.dyS, eeC(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramn = paramString.ecD();
      final String str = paramn.FhN;
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().yE(paramn.GeD);
      a(paramString.dyS, str, false);
      if ((paramString.ecD().GeC != null) && ((paramString.ecD().GeC.FzE == 1) || (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getTopStoryCommand().Aad))) {
        com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            dib localdib = new dib();
            localdib.Category = paramn.GeC.Category;
            localdib.FRa = System.currentTimeMillis();
            localdib.FzB = paramn.GeC.FzB;
            localdib.FRb = paramn.GeC.FzC;
            localdib.hkR = str;
            localdib.FzD = paramn.GeC.FzD;
            ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getWebViewMgr().AbW.put(Integer.valueOf(localdib.Category), localdib);
            try
            {
              byte[] arrayOfByte = localdib.toByteArray();
              com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.ecu());
              if (!locale.exists()) {
                locale.mkdirs();
              }
              com.tencent.mm.vfs.i.f(com.tencent.mm.plugin.topstory.a.h.ecu() + localdib.Category, arrayOfByte, arrayOfByte.length);
              ac.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localdib.Category), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getWebViewMgr().ce(localdib.Category, "");
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
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.Agz != null) {
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
        if (!bs.isNullOrNil(paramString2)) {
          localJSONObject.put("filterDocidList", new JSONArray(paramString2));
        }
      }
      catch (Exception paramString1)
      {
        int i;
        continue;
      }
      this.Agz = new String(this.Agz).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      ac.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.Agz.length) });
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
      String str = String.format("%s/%s", new Object[] { z.Uj(1).exF(), "app.html" });
      c.this.Agz = com.tencent.mm.vfs.i.aU(str, 0, -1);
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    String AgF;
    dia AgG;
    long nvA;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */