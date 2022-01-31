package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.home.a;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements f
{
  private com.tencent.mm.plugin.topstory.a.c.b teF;
  public f tiS;
  public a tlT;
  private boolean tlU;
  public c.b tlV;
  public byte[] tlW;
  byte[] tlX;
  byte[] tlY;
  public f tlZ;
  public f tma;
  
  public c()
  {
    AppMethodBeat.i(2153);
    this.tlZ = new c.1(this);
    this.tiS = new c.2(this);
    this.tma = new c.3(this);
    AppMethodBeat.o(2153);
  }
  
  private void a(cko paramcko, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(2158);
    if (this.tlU)
    {
      if (this.tlT != null) {
        this.tlT.aej(paramString);
      }
      this.tlU = false;
      AppMethodBeat.o(2158);
      return;
    }
    if ((!paramBoolean) && (paramcko.bWu == 100))
    {
      this.tlV = new c.b(this, (byte)0);
      this.tlV.tme = paramcko;
      this.tlV.jSQ = System.currentTimeMillis();
      this.tlV.tmd = paramString;
      AppMethodBeat.o(2158);
      return;
    }
    this.tlV = null;
    AppMethodBeat.o(2158);
  }
  
  private static String cKx()
  {
    AppMethodBeat.i(2159);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("ret", -1);
      label22:
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(2159);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      break label22;
    }
  }
  
  public final void a(cko paramcko, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(2156);
    a(paramcko, paramBoolean1, paramBoolean2, paramInt, "");
    AppMethodBeat.o(2156);
  }
  
  public final void a(cko paramcko, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    AppMethodBeat.i(155125);
    ab.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", new Object[] { Boolean.valueOf(paramBoolean2) });
    if ((!paramBoolean2) && (this.teF != null) && (paramcko.cpW.equals(this.teF.cKi.cpW)))
    {
      this.tlU = paramBoolean1;
      ab.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      h.a(paramcko, "WaitCurrentNetScene", System.currentTimeMillis());
      AppMethodBeat.o(155125);
      return;
    }
    this.teF = new com.tencent.mm.plugin.topstory.a.c.b(paramcko, paramInt, paramString);
    g.Rc().a(1943, this);
    g.Rc().a(this.teF, 0);
    this.tlU = paramBoolean1;
    ab.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
    AppMethodBeat.o(155125);
  }
  
  public final void cKw()
  {
    AppMethodBeat.i(2154);
    d.post(new c.a(this, (byte)0), "TopStory.LoadHtmlDataFromSdcardTask");
    AppMethodBeat.o(2154);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(2157);
    if (paramm.equals(this.teF))
    {
      g.Rc().b(1943, this);
      this.teF = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.b)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
        a(paramString.cKi, cKx(), true);
        AppMethodBeat.o(2157);
        return;
      }
      paramm = paramString.cID();
      String str = paramm.wAa;
      ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().na(paramm.yfr);
      a(paramString.cKi, str, false);
      if ((paramString.cID().yfq != null) && ((paramString.cID().yfq.xFz == 1) || (((PluginTopStoryUI)g.G(PluginTopStoryUI.class)).getTopStoryCommand().tfC))) {
        d.post(new c.4(this, paramm, str), "TopStory.CacheHomeData");
      }
    }
    AppMethodBeat.o(2157);
  }
  
  public final void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(2155);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(2155);
      return;
    }
    JSONObject localJSONObject;
    if (this.tlW != null) {
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
        if (!bo.isNullOrNil(paramString2)) {
          localJSONObject.put("filterDocidList", new JSONArray(paramString2));
        }
      }
      catch (Exception paramString1)
      {
        int i;
        continue;
      }
      this.tlW = new String(this.tlW).replace("'###preloadObjFeedsData###'", localJSONObject.toString() + "\n").getBytes();
      ab.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", new Object[] { Integer.valueOf(this.tlW.length) });
      AppMethodBeat.o(2155);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */