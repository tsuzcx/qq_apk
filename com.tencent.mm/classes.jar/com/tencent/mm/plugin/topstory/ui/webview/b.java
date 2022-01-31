package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements f
{
  private com.tencent.mm.plugin.topstory.a.c.a pCT;
  public com.tencent.mm.plugin.topstory.ui.home.a pIe;
  private boolean pIf;
  public b.b pIg;
  public byte[] pIh;
  byte[] pIi;
  byte[] pIj;
  
  private void a(byb parambyb, String paramString, boolean paramBoolean)
  {
    if (this.pIf)
    {
      if (this.pIe != null) {
        this.pIe.PK(paramString);
      }
      this.pIf = false;
      return;
    }
    if (!paramBoolean)
    {
      this.pIg = new b.b(this, (byte)0);
      this.pIg.pIn = parambyb;
      this.pIg.ica = System.currentTimeMillis();
      this.pIg.pIm = paramString;
      return;
    }
    this.pIg = null;
  }
  
  private static String bOG()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ret", -1);
      label16:
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label16;
    }
  }
  
  public final void a(byb parambyb, boolean paramBoolean)
  {
    if ((this.pCT != null) && (parambyb.bIB.equals(this.pCT.cbF.bIB)))
    {
      this.pIf = paramBoolean;
      y.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
      h.a(parambyb, "WaitCurrentNetScene", System.currentTimeMillis());
      return;
    }
    this.pCT = new com.tencent.mm.plugin.topstory.a.c.a(parambyb);
    g.Dk().a(1943, this);
    g.Dk().a(this.pCT, 0);
    this.pIf = paramBoolean;
    y.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
  }
  
  public final void bOF()
  {
    e.post(new b.a(this, (byte)0), "TopStory.LoadHtmlDataFromSdcardTask");
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.equals(this.pCT))
    {
      g.Dk().b(1943, this);
      this.pCT = null;
      paramString = (com.tencent.mm.plugin.topstory.a.c.a)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label61;
      }
      y.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
      a(paramString.cbF, bOG(), true);
    }
    label61:
    String str;
    do
    {
      return;
      paramm = paramString.bNh();
      str = paramm.sEb;
      a(paramString.cbF, str, false);
    } while ((paramString.bNh().tXZ == null) || ((paramString.bNh().tXZ.tDj != 1) && (!((PluginTopStoryUI)g.t(PluginTopStoryUI.class)).getTopStoryCommand().pDI)));
    e.post(new b.1(this, paramm, str), "TopStory.CacheHomeData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.b
 * JD-Core Version:    0.7.0.1
 */