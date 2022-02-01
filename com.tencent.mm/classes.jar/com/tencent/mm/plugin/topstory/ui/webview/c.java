package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.plugin.topstory.ui.home.d;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.plugin.topstory.a.c.b yLc;
  public com.tencent.mm.al.g yPw;
  public a ySH;
  private boolean ySI;
  public b ySJ;
  public byte[] ySK;
  public com.tencent.mm.al.g ySL;
  public com.tencent.mm.al.g ySM;
  
  public c()
  {
    AppMethodBeat.i(126558);
    this.ySL = new c.1(this);
    this.yPw = new c.2(this);
    this.ySM = new c.3(this);
    AppMethodBeat.o(126558);
  }
  
  private void a(dcn paramdcn, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(126564);
    if (this.ySI)
    {
      if (this.ySH != null) {
        this.ySH.asD(paramString);
      }
      this.ySI = false;
      AppMethodBeat.o(126564);
      return;
    }
    if ((!paramBoolean) && (paramdcn.cJR == 100))
    {
      this.ySJ = new b((byte)0);
      this.ySJ.ySR = paramdcn;
      this.ySJ.mTi = System.currentTimeMillis();
      this.ySJ.ySQ = paramString;
      AppMethodBeat.o(126564);
      return;
    }
    this.ySJ = null;
    AppMethodBeat.o(126564);
  }
  
  private static String dQd()
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
  
  public final void a(dcn paramdcn, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(126561);
    a(paramdcn, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(126561);
  }
  
  public final void a(dcn paramdcn, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(126562);
    ad.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.yLc != null) && (paramdcn.sessionId.equals(this.yLc.dBe.sessionId)))
    {
      this.ySI = paramBoolean1;
      ad.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      com.tencent.mm.plugin.topstory.a.i.a(paramdcn, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(126562);
      return;
    }
    this.yLc = new com.tencent.mm.plugin.topstory.a.c.b(paramdcn, paramInt, paramString);
    com.tencent.mm.kernel.g.aeS().a(1943, this);
    com.tencent.mm.kernel.g.aeS().a(this.yLc, 0);
    this.ySI = paramBoolean1;
    ad.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(126562);
  }
  
  public final void dQc()
  {
    AppMethodBeat.i(126559);
    a locala = new a((byte)0);
    com.tencent.e.h.Iye.f(locala, "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(126559);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(126563);
    if (paramn.equals(this.yLc))
    {
      com.tencent.mm.kernel.g.aeS().b(1943, this);
      this.yLc = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramn;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.dBe, dQd(), true);
        AppMethodBeat.o(126563);
        return;
      }
      paramn = paramString.dOd();
      final String str = paramn.DLy;
      ((com.tencent.mm.plugin.topstory.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().ub(paramn.EHr);
      a(paramString.dBe, str, false);
      if ((paramString.dOd().EHq != null) && ((paramString.dOd().EHq.EcJ == 1) || (((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getTopStoryCommand().yMl))) {
        com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
        {
          public final String getKey()
          {
            return "TopStory.CacheHomeData";
          }
          
          public final void run()
          {
            AppMethodBeat.i(126556);
            dco localdco = new dco();
            localdco.Category = paramn.EHq.Category;
            localdco.EtZ = System.currentTimeMillis();
            localdco.EcG = paramn.EHq.EcG;
            localdco.Eua = paramn.EHq.EcH;
            localdco.gKr = str;
            localdco.EcI = paramn.EHq.EcI;
            ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getWebViewMgr().yOf.put(Integer.valueOf(localdco.Category), localdco);
            try
            {
              byte[] arrayOfByte = localdco.toByteArray();
              com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.topstory.a.h.dNU());
              if (!locale.exists()) {
                locale.mkdirs();
              }
              com.tencent.mm.vfs.i.f(com.tencent.mm.plugin.topstory.a.h.dNU() + localdco.Category, arrayOfByte, arrayOfByte.length);
              ad.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", new Object[] { Integer.valueOf(localdco.Category), Integer.valueOf(arrayOfByte.length) });
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", localIOException, "putHomeDataCache ", new Object[0]);
              }
            }
            ((PluginTopStoryUI)com.tencent.mm.kernel.g.ad(PluginTopStoryUI.class)).getWebViewMgr().ca(localdco.Category, "");
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
    if (this.ySK != null) {
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
      this.ySK = new String(this.ySK).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      ad.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.ySK.length) });
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
      String str = String.format("%s/%s", new Object[] { aa.RZ(1).eil(), "app.html" });
      c.this.ySK = com.tencent.mm.vfs.i.aR(str, 0, -1);
      AppMethodBeat.o(126557);
    }
  }
  
  final class b
  {
    long mTi;
    String ySQ;
    dcn ySR;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */