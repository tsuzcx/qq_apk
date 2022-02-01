package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.j;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.plugin.topstory.a.c.b BIg;
  public com.tencent.mm.ak.f BMw;
  public a BPG;
  private boolean BPH;
  public b BPI;
  public byte[] BPJ;
  public com.tencent.mm.ak.f BPK;
  public com.tencent.mm.ak.f BPL;
  
  public c()
  {
    AppMethodBeat.i(126558);
    this.BPK = new com.tencent.mm.ak.f()
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
            ae.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStoryPostComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.BPG != null) {
            c.this.BPG.aEm(localJSONObject.toString());
          }
          AppMethodBeat.o(126553);
          return;
          if (c.this.BPG != null)
          {
            paramAnonymousString = ((com.tencent.mm.plugin.topstory.a.c.f)paramAnonymousn).esE().HVx;
            paramAnonymousn = ((com.tencent.mm.plugin.topstory.a.c.f)paramAnonymousn).esE().Hvt;
            localJSONObject.put("commentId", paramAnonymousString);
            localJSONObject.put("requestId", paramAnonymousn);
          }
        }
      }
    };
    this.BMw = new com.tencent.mm.ak.f()
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
            ae.w("MicroMsg.TopStory.TopStoryWebData", "NetSceneTopStorySetComment response, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          }
          catch (JSONException paramAnonymousString)
          {
            continue;
          }
          if (c.this.BPG != null) {
            c.this.BPG.aEn(localJSONObject.toString());
          }
          AppMethodBeat.o(126554);
          return;
          if (c.this.BPG != null) {
            localJSONObject.put("requestId", ((j)paramAnonymousn).esG().Hvt);
          }
        }
      }
    };
    this.BPL = new c.3(this);
    AppMethodBeat.o(126558);
  }
  
  private void a(dom paramdom, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.BPH)
    {
      if (this.BPG != null) {
        this.BPG.aEk(paramString);
      }
      this.BPH = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (paramdom.cSM == 100))
    {
      this.BPI = new b((byte)0);
      this.BPI.BPQ = paramdom;
      this.BPI.ocH = System.currentTimeMillis();
      this.BPI.BPP = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.BPI = null;
    AppMethodBeat.o(126564);
  }
  
  private static String euA()
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
  
  public final void a(dom paramdom, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    a(paramdom, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(126561);
  }
  
  public final void a(dom paramdom, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    ae.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.BIg != null) && (paramdom.sessionId.equals(this.BIg.dMt.sessionId)))
    {
      this.BPH = paramBoolean1;
      ae.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(paramdom, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.BIg = new com.tencent.mm.plugin.topstory.a.c.b(paramdom, paramInt, paramString);
    g.ajj().a(1943, this);
    g.ajj().a(this.BIg, 0);
    this.BPH = paramBoolean1;
    ae.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void euz()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    h.MqF.f(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126563);
    if (paramn.equals(this.BIg))
    {
      g.ajj().b(1943, this);
      this.BIg = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.dMt, euA(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramn = paramString.esB();
      String str = paramn.GWB;
      ((com.tencent.mm.plugin.topstory.a.b)g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().BA(paramn.IjQ);
      a(paramString.dMt, str, false);
      if ((paramString.esB().IjP != null) && ((paramString.esB().IjP.HDm == 1) || (((PluginTopStoryUI)g.ad(PluginTopStoryUI.class)).getTopStoryCommand().BJo))) {
        h.MqF.aO(new c.4(this, paramn, str));
      }
    }
    AppMethodBeat.o(126563);
  }
  
  public final void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(126560);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(126560);
      return;
    }
    JSONObject localJSONObject;
    if (this.BPJ != null) {
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
        if (!bu.isNullOrNil(paramString2)) {
          localJSONObject.put("filterDocidList", new JSONArray(paramString2));
        }
      }
      catch (Exception paramString1)
      {
        int i;
        continue;
      }
      this.BPJ = new String(this.BPJ).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      ae.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.BPJ.length) });
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
      String str = String.format("%s/%s", new Object[] { ad.WJ(1).eQf(), "app.html" });
      c.this.BPJ = o.bb(str, 0, -1);
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    String BPP;
    dom BPQ;
    long ocH;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */