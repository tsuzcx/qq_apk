package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.cq.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private WebView.c BqA = WebView.c.Mqu;
  private c Bqx;
  private b Bqy;
  private a Bqz;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    d.a(this.BqA, new PluginTopStory.1(this));
    ad.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.BqA.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.Bqz;
  }
  
  public b getRedDotMgr()
  {
    return this.Bqy;
  }
  
  public c getReporter()
  {
    return this.Bqx;
  }
  
  public WebView.c getWebViewType()
  {
    return this.BqA;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88410);
    this.Bqx = new c();
    this.Bqy = new b();
    this.Bqz = new a();
    com.tencent.mm.sdk.g.b.c(new PluginTopStory.a(this, (byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.Bqx != null)
    {
      localObject = this.Bqx;
      ((c)localObject).zYs.removeCallbacksAndMessages(null);
      ((c)localObject).zYs.quit();
      this.Bqx = null;
    }
    if (this.Bqy != null)
    {
      localObject = this.Bqy;
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).BqG);
      com.tencent.mm.sdk.b.a.IbL.d(((b)localObject).BqK);
      this.Bqy = null;
    }
    if (this.Bqz != null)
    {
      this.Bqz.BqC.clear();
      this.Bqz = null;
    }
    if (com.tencent.mm.plugin.topstory.a.b.a.BqU != null)
    {
      if (com.tencent.mm.plugin.topstory.a.b.a.BqU.BqY != null)
      {
        com.tencent.mm.kernel.g.aiU().a(com.tencent.mm.plugin.topstory.a.b.a.BqU.BqY);
        com.tencent.mm.plugin.topstory.a.b.a.BqU.BqY = null;
      }
      if (com.tencent.mm.plugin.topstory.a.b.a.BqU.BqZ != null)
      {
        com.tencent.mm.kernel.g.aiU().a(com.tencent.mm.plugin.topstory.a.b.a.BqU.BqZ);
        com.tencent.mm.plugin.topstory.a.b.a.BqU.BqZ = null;
      }
      com.tencent.mm.kernel.g.aiU().b(2748, com.tencent.mm.plugin.topstory.a.b.a.BqU);
      com.tencent.mm.plugin.topstory.a.b.a.BqU = null;
    }
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(doa paramdoa) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */