package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c zYL;
  private b zYM;
  private a zYN;
  private WebView.c zYO = WebView.c.KzZ;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    d.a(this.zYO, new PluginTopStory.1(this));
    ac.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.zYO.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.zYN;
  }
  
  public b getRedDotMgr()
  {
    return this.zYM;
  }
  
  public c getReporter()
  {
    return this.zYL;
  }
  
  public WebView.c getWebViewType()
  {
    return this.zYO;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88410);
    this.zYL = new c();
    this.zYM = new b();
    this.zYN = new a();
    com.tencent.mm.sdk.g.b.c(new PluginTopStory.a(this, (byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.zYL != null)
    {
      localObject = this.zYL;
      ((c)localObject).yGZ.removeCallbacksAndMessages(null);
      ((c)localObject).yGZ.quit();
      this.zYL = null;
    }
    if (this.zYM != null)
    {
      localObject = this.zYM;
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).zYU);
      com.tencent.mm.sdk.b.a.GpY.d(((b)localObject).zYY);
      this.zYM = null;
    }
    if (this.zYN != null)
    {
      this.zYN.zYQ.clear();
      this.zYN = null;
    }
    if (com.tencent.mm.plugin.topstory.a.b.a.zZi != null)
    {
      if (com.tencent.mm.plugin.topstory.a.b.a.zZi.zZm != null)
      {
        com.tencent.mm.kernel.g.agi().a(com.tencent.mm.plugin.topstory.a.b.a.zZi.zZm);
        com.tencent.mm.plugin.topstory.a.b.a.zZi.zZm = null;
      }
      if (com.tencent.mm.plugin.topstory.a.b.a.zZi.zZn != null)
      {
        com.tencent.mm.kernel.g.agi().a(com.tencent.mm.plugin.topstory.a.b.a.zZi.zZn);
        com.tencent.mm.plugin.topstory.a.b.a.zZi.zZn = null;
      }
      com.tencent.mm.kernel.g.agi().b(2748, com.tencent.mm.plugin.topstory.a.b.a.zZi);
      com.tencent.mm.plugin.topstory.a.b.a.zZi = null;
    }
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(dil paramdil) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */