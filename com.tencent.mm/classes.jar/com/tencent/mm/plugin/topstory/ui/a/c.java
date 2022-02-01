package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends com.tencent.mm.plugin.websearch.webview.a<eii>
  implements com.tencent.mm.ak.i
{
  private com.tencent.mm.plugin.topstory.a.c.b GiP;
  public com.tencent.mm.ak.i Gnc;
  private boolean Gqn;
  public b Gqo;
  public byte[] Gqp;
  public com.tencent.mm.ak.i Gqq;
  public com.tencent.mm.ak.i Gqr;
  
  public c()
  {
    super(null);
    AppMethodBeat.i(126558);
    this.Gqq = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
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
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe).aTC(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe != null)
          {
            paramAnonymousString = ((f)paramAnonymousq).fyc().NhH;
            paramAnonymousq = ((f)paramAnonymousq).fyc().Mba;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousq);
          }
        }
      }
    };
    this.Gnc = new com.tencent.mm.ak.i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
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
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe != null) {
            ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe).aTD(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if ((com.tencent.mm.plugin.topstory.ui.home.a)c.this.IHe != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousq).fye().Mba);
          }
        }
      }
    };
    this.Gqr = new c.3(this);
    AppMethodBeat.o(126558);
  }
  
  private void a(eii parameii, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.Gqn)
    {
      if ((com.tencent.mm.plugin.topstory.ui.home.a)this.IHe != null) {
        ((com.tencent.mm.plugin.topstory.ui.home.a)this.IHe).aTA(paramString);
      }
      this.Gqn = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (parameii.channelId == 100))
    {
      this.Gqo = new b((byte)0);
      this.Gqo.Gqw = parameii;
      this.Gqo.pnE = System.currentTimeMillis();
      this.Gqo.Gqv = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.Gqo = null;
    AppMethodBeat.o(126564);
  }
  
  private static String fzU()
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
  
  public final void A(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(126560);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.Gqp != null) {
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
      this.Gqp = new String(this.Gqp).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      Log.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.Gqp.length) });
      AppMethodBeat.o(126560);
      return;
      i = 0;
    }
  }
  
  public final void a(eii parameii, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    a(parameii, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(126561);
  }
  
  public final void a(eii parameii, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    Log.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.GiP != null) && (parameii.sessionId.equals(this.GiP.eel.sessionId)))
    {
      this.Gqn = paramBoolean1;
      Log.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(parameii, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.GiP = new com.tencent.mm.plugin.topstory.a.c.b(parameii, paramInt, paramString);
    g.azz().a(1943, this);
    g.azz().a(this.GiP, 0);
    this.Gqn = paramBoolean1;
    Log.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void fzT()
  {
    AppMethodBeat.i(126559);
    c.a locala = new c.a(this, (byte)0);
    com.tencent.f.h.RTc.b(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(126563);
    if (paramq.equals(this.GiP))
    {
      g.azz().b(1943, this);
      this.GiP = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramq;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.eel, fzU(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramq = paramString.fxZ();
      final String str = paramq.MaZ;
      ((com.tencent.mm.plugin.topstory.a.b)g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().KH(paramq.NwP);
      a(paramString.eel, str, false);
      if ((paramString.fxZ().NwO != null) && (paramString.fxZ().NwO.MOe == 1)) {
        com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            eij localeij = new eij();
            localeij.Category = paramq.NwO.Category;
            localeij.NhD = System.currentTimeMillis();
            localeij.MOb = paramq.NwO.MOb;
            localeij.NhE = paramq.NwO.MOc;
            localeij.iAc = str;
            localeij.MOd = paramq.NwO.MOd;
            ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).getWebViewMgr().GlL.put(Integer.valueOf(localeij.Category), localeij);
            try
            {
              byte[] arrayOfByte = localeij.toByteArray();
              o localo = new o(com.tencent.mm.plugin.topstory.a.h.fxS());
              if (!localo.exists()) {
                localo.mkdirs();
              }
              s.f(com.tencent.mm.plugin.topstory.a.h.fxS() + localeij.Category, arrayOfByte, arrayOfByte.length);
              Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localeij.Category), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)g.ah(PluginTopStoryUI.class)).getWebViewMgr().cC(localeij.Category, "");
            AppMethodBeat.o(126556);
          }
        });
      }
    }
    AppMethodBeat.o(126563);
  }
  
  final class b
  {
    String Gqv;
    eii Gqw;
    long pnE;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.c
 * JD-Core Version:    0.7.0.1
 */