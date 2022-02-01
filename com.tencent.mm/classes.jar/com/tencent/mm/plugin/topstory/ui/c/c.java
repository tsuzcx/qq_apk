package com.tencent.mm.plugin.topstory.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.dtu;
import com.tencent.mm.protocal.protobuf.esk;
import com.tencent.mm.protocal.protobuf.esl;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.protocal.protobuf.esp;
import com.tencent.mm.protocal.protobuf.fks;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.websearch.webview.a<esk>
{
  private com.tencent.mm.plugin.topstory.a.c.b MVD;
  public com.tencent.mm.an.i MZP;
  private boolean NcZ;
  public b Nda;
  public byte[] Ndb;
  public com.tencent.mm.an.i Ndc;
  public com.tencent.mm.an.i Ndd;
  
  public c()
  {
    super(null);
    AppMethodBeat.i(126558);
    this.Ndc = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
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
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs).bfa(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null)
          {
            paramAnonymousString = ((f)paramAnonymousq).gpX().Uun;
            paramAnonymousq = ((f)paramAnonymousq).gpX().Tkx;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousq);
          }
        }
      }
    };
    this.MZP = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
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
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs).bfb(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousq).gqa().Tkx);
          }
        }
      }
    };
    this.Ndd = new com.tencent.mm.an.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
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
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousq).fIY);
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs).beZ(localJSONObject.toString());
          }
          AppMethodBeat.o(126555);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.PBs != null)
          {
            localJSONObject.put("commResp", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousq).gpT().UJk);
            localJSONObject.put("requestId", ((com.tencent.mm.plugin.topstory.a.c.a)paramAnonymousq).gpT().fIY);
          }
        }
      }
    };
    AppMethodBeat.o(126558);
  }
  
  private void a(esk paramesk, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.NcZ)
    {
      if ((com.tencent.mm.plugin.topstory.ui.home.a)this.PBs != null) {
        ((com.tencent.mm.plugin.topstory.ui.home.a)this.PBs).beY(paramString);
      }
      this.NcZ = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (paramesk.channelId == 100))
    {
      this.Nda = new b((byte)0);
      this.Nda.Ndh = paramesk;
      this.Nda.swE = System.currentTimeMillis();
      this.Nda.Ndg = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.Nda = null;
    AppMethodBeat.o(126564);
  }
  
  public static void bB(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(202930);
    paramJSONObject = new f(paramJSONObject);
    com.tencent.mm.kernel.h.aGY().a(paramJSONObject, 0);
    AppMethodBeat.o(202930);
  }
  
  public static void bC(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(202931);
    paramJSONObject = new j(paramJSONObject);
    com.tencent.mm.kernel.h.aGY().a(paramJSONObject, 0);
    AppMethodBeat.o(202931);
  }
  
  private static String grV()
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
  
  public static void lG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202927);
    paramString1 = new com.tencent.mm.plugin.topstory.a.c.a(paramString1, paramString2);
    com.tencent.mm.kernel.h.aGY().a(paramString1, 0);
    AppMethodBeat.o(202927);
  }
  
  public final void C(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(126560);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.Ndb != null) {
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
      this.Ndb = new String(this.Ndb).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      Log.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.Ndb.length) });
      AppMethodBeat.o(126560);
      return;
      i = 0;
    }
  }
  
  public final void a(esk paramesk, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    Log.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.MVD != null) && (paramesk.sessionId.equals(this.MVD.fYA.sessionId)))
    {
      this.NcZ = paramBoolean1;
      Log.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(paramesk, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.MVD = new com.tencent.mm.plugin.topstory.a.c.b(paramesk, paramInt, paramString);
    com.tencent.mm.kernel.h.aGY().a(1943, this);
    com.tencent.mm.kernel.h.aGY().a(this.MVD, 0);
    this.NcZ = paramBoolean1;
    Log.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void grU()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    com.tencent.e.h.ZvG.d(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(126563);
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    if (paramq.equals(this.MVD))
    {
      com.tencent.mm.kernel.h.aGY().b(1943, this);
      this.MVD = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.fYA, grV(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramq = paramString.gpU();
      final String str = paramq.Tkw;
      if ((paramString.fYA != null) && (com.tencent.mm.plugin.topstory.a.h.aju(paramString.fYA.channelId))) {
        ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().Sd(paramq.UKf);
      }
      a(paramString.fYA, str, false);
      if ((paramString.gpU().UKe != null) && (paramString.gpU().UKe.TZX == 1)) {
        com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            esl localesl = new esl();
            localesl.Tei = paramq.UKe.Tei;
            localesl.Uuj = System.currentTimeMillis();
            localesl.TZU = paramq.UKe.TZU;
            localesl.Uuk = paramq.UKe.TZV;
            localesl.lpy = str;
            localesl.TZW = paramq.UKe.TZW;
            ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getWebViewMgr().MYx.put(Integer.valueOf(localesl.Tei), localesl);
            try
            {
              byte[] arrayOfByte = localesl.toByteArray();
              com.tencent.mm.vfs.q localq = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.topstory.a.h.gpN());
              if (!localq.ifE()) {
                localq.ifL();
              }
              u.H(com.tencent.mm.plugin.topstory.a.h.gpN() + localesl.Tei, arrayOfByte);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localesl.Tei), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)com.tencent.mm.kernel.h.ag(PluginTopStoryUI.class)).getWebViewMgr().cD(localesl.Tei, "");
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
      String str = String.format("%s/%s", new Object[] { ai.anf(1).gRd(), "app.html" });
      c.a(c.this, u.aY(str, 0, -1));
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    String Ndg;
    esk Ndh;
    long swE;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.c
 * JD-Core Version:    0.7.0.1
 */