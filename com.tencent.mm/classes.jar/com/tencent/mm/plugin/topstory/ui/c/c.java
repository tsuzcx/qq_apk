package com.tencent.mm.plugin.topstory.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.protocal.protobuf.fnu;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.protocal.protobuf.fny;
import com.tencent.mm.protocal.protobuf.ghg;
import com.tencent.mm.protocal.protobuf.ghu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.websearch.webview.a<fnt>
{
  public com.tencent.mm.am.h TMy;
  public HashMap<Integer, com.tencent.mm.plugin.topstory.a.c.b> TPJ;
  public HashMap<Integer, b> TPK;
  public HashMap<Integer, Boolean> TPL;
  public byte[] TPM;
  public com.tencent.mm.am.h TPN;
  public com.tencent.mm.am.h TPO;
  
  public c()
  {
    super(null);
    AppMethodBeat.i(126558);
    this.TPJ = new HashMap();
    this.TPK = new HashMap();
    this.TPL = new HashMap();
    this.TPN = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
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
            Log.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK).bex(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null)
          {
            paramAnonymousString = ((f)paramAnonymousp).hMT().abNQ;
            paramAnonymousp = ((f)paramAnonymousp).hMT().aaye;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousp);
          }
        }
      }
    };
    this.TMy = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
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
            Log.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK).bey(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousp).hMW().aaye);
          }
        }
      }
    };
    this.TPO = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
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
            Log.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneSearchWebComm response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousp).hOG);
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK).bew(localJSONObject.toString());
          }
          AppMethodBeat.o(126555);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.WrK != null)
          {
            localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousp).hMP().acds);
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousp).hMP().hOG);
          }
        }
      }
    };
    AppMethodBeat.o(126558);
  }
  
  private void a(fnt paramfnt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (((Boolean)this.TPL.get(Integer.valueOf(paramfnt.channelId))).booleanValue())
    {
      if ((com.tencent.mm.plugin.topstory.ui.home.a)this.WrK != null) {
        ((com.tencent.mm.plugin.topstory.ui.home.a)this.WrK).bev(paramString);
      }
      this.TPL.remove(Integer.valueOf(paramfnt.channelId));
      AppMethodBeat.o(126564);
      return;
    }
    if (!paramBoolean)
    {
      b localb = new b((byte)0);
      localb.TPS = paramfnt;
      localb.vCl = cn.bDw();
      localb.TPR = paramString;
      this.TPK.put(Integer.valueOf(paramfnt.channelId), localb);
      AppMethodBeat.o(126564);
      return;
    }
    this.TPK.remove(Integer.valueOf(paramfnt.channelId));
    AppMethodBeat.o(126564);
  }
  
  public static void bT(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271710);
    paramJSONObject = new f(paramJSONObject);
    com.tencent.mm.kernel.h.aZW().a(paramJSONObject, 0);
    AppMethodBeat.o(271710);
  }
  
  public static void bU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271713);
    paramJSONObject = new j(paramJSONObject);
    com.tencent.mm.kernel.h.aZW().a(paramJSONObject, 0);
    AppMethodBeat.o(271713);
  }
  
  private static String hOW()
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
  
  public static void no(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271707);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.a(paramString1, paramString2);
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(271707);
  }
  
  public final void I(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(126560);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.TPM != null) {
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
        if (!Util.isNullOrNil(paramString2)) {
          localJSONObject.put("filterDocidList", new JSONArray(paramString2));
        }
      }
      catch (Exception paramString1)
      {
        int i;
        continue;
      }
      this.TPM = new String(this.TPM).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      Log.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.TPM.length) });
      AppMethodBeat.o(126560);
      return;
      i = 0;
    }
  }
  
  public final void a(fnt paramfnt, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    int i = paramfnt.channelId;
    Log.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer, preTabChannelId = %s，homeContext channelId = %s, hashcode = %s, needCallback = %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean1) });
    com.tencent.mm.plugin.topstory.a.c.b localb = (com.tencent.mm.plugin.topstory.a.c.b)this.TPJ.get(Integer.valueOf(i));
    if ((!paramBoolean2) && (localb != null) && (paramfnt.sessionId.equals(localb.ieC.sessionId)))
    {
      this.TPL.put(Integer.valueOf(i), Boolean.valueOf(paramBoolean1));
      Log.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.h.a(paramfnt, "WaitCurrentNetScene", cn.bDw());
      AppMethodBeat.o(126561);
      return;
    }
    paramfnt = new com.tencent.mm.plugin.topstory.a.c.b(paramfnt, paramInt);
    com.tencent.mm.kernel.h.aZW().a(1943, this);
    com.tencent.mm.kernel.h.aZW().a(paramfnt, 0);
    this.TPJ.put(Integer.valueOf(i), paramfnt);
    this.TPL.put(Integer.valueOf(i), Boolean.valueOf(paramBoolean1));
    Log.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126561);
  }
  
  public final void hOV()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    com.tencent.threadpool.h.ahAA.g(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(126563);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    if ((this.TPJ.values() != null) && (this.TPJ.values().contains(paramp)))
    {
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramp;
      int i = paramString.ieC.channelId;
      this.TPJ.remove(Integer.valueOf(i));
      if (this.TPJ.isEmpty())
      {
        com.tencent.mm.kernel.h.aZW().b(1943, this);
        Log.i("MicroMsg.TopStory.TopStoryWebData", "cacheCgi.isEmpty() = " + this.TPJ.isEmpty());
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.ieC, hOW(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramp = paramString.hMQ();
      final String str = paramp.aayd;
      if ((paramString.ieC != null) && (g.aoJ(paramString.ieC.channelId)))
      {
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().wp(paramp.acen);
        Log.i("MicroMsg.TopStory.TopStoryWebData", "try to clear haokan red dot");
      }
      if ((paramString.ieC != null) && (g.aoK(paramString.ieC.channelId)))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "clear home red dot");
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMp();
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMq();
      }
      if ((paramString.ieC != null) && (g.aoL(paramString.ieC.channelId)))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "clear home red dot");
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMb();
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().hMr();
      }
      a(paramString.ieC, str, false);
      if ((paramString.hMQ().acem != null) && (paramString.hMQ().acem.abqU == 1)) {
        com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            fnu localfnu = new fnu();
            localfnu.aary = paramp.acem.aary;
            localfnu.abNM = cn.bDw();
            localfnu.abqR = paramp.acem.abqR;
            localfnu.abNN = paramp.acem.abqS;
            localfnu.nUB = str;
            localfnu.abqT = paramp.acem.abqT;
            ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getWebViewMgr().TLg.put(Integer.valueOf(localfnu.aary), localfnu);
            try
            {
              byte[] arrayOfByte = localfnu.toByteArray();
              u localu = new u(g.hMJ());
              if (!localu.jKS()) {
                localu.jKY();
              }
              y.f(g.hMJ() + localfnu.aary, arrayOfByte, arrayOfByte.length);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localfnu.aary), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)com.tencent.mm.kernel.h.az(PluginTopStoryUI.class)).getWebViewMgr().ds(localfnu.aary, "");
            AppMethodBeat.o(126556);
          }
        });
      }
    }
    AppMethodBeat.o(126563);
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(126557);
      String str = String.format("%s/%s", new Object[] { aj.asW(1).iqp(), "app.html" });
      c.a(c.this, y.bi(str, 0, -1));
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    String TPR;
    fnt TPS;
    long vCl;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.c
 * JD-Core Version:    0.7.0.1
 */