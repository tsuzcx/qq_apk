package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.dcy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c yKS;
  private b yKT;
  private a yKU;
  private WebView.c yKV = WebView.c.INC;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    d.a(this.yKV, new WebView.PreInitCallback()
    {
      public final void aNK()
      {
        AppMethodBeat.i(88408);
        ad.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
        AppMethodBeat.o(88408);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(88407);
        ad.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
        AppMethodBeat.o(88407);
      }
    });
    ad.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.yKV.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.yKU;
  }
  
  public b getRedDotMgr()
  {
    return this.yKT;
  }
  
  public c getReporter()
  {
    return this.yKS;
  }
  
  public WebView.c getWebViewType()
  {
    return this.yKV;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88410);
    this.yKS = new c();
    this.yKT = new b();
    this.yKU = new a();
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.yKS != null)
    {
      localObject = this.yKS;
      ((c)localObject).xuj.removeCallbacksAndMessages(null);
      ((c)localObject).xuj.quit();
      this.yKS = null;
    }
    if (this.yKT != null)
    {
      localObject = this.yKT;
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).yLb);
      com.tencent.mm.sdk.b.a.ESL.d(((b)localObject).yLf);
      this.yKT = null;
    }
    if (this.yKU != null)
    {
      this.yKU.yKX.clear();
      this.yKU = null;
    }
    if (com.tencent.mm.plugin.topstory.a.b.a.yLp != null)
    {
      if (com.tencent.mm.plugin.topstory.a.b.a.yLp.yLt != null)
      {
        com.tencent.mm.kernel.g.aeS().a(com.tencent.mm.plugin.topstory.a.b.a.yLp.yLt);
        com.tencent.mm.plugin.topstory.a.b.a.yLp.yLt = null;
      }
      if (com.tencent.mm.plugin.topstory.a.b.a.yLp.yLu != null)
      {
        com.tencent.mm.kernel.g.aeS().a(com.tencent.mm.plugin.topstory.a.b.a.yLp.yLu);
        com.tencent.mm.plugin.topstory.a.b.a.yLp.yLu = null;
      }
      com.tencent.mm.kernel.g.aeS().b(2748, com.tencent.mm.plugin.topstory.a.b.a.yLp);
      com.tencent.mm.plugin.topstory.a.b.a.yLp = null;
    }
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(dcy paramdcy) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(88409);
      ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(i.cO(com.tencent.mm.loader.j.b.aih() + "ftsrecommendVideo/", true)) });
      ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(i.cO(com.tencent.mm.loader.j.b.aih() + "topstory/", true)) });
      ad.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(i.cO(aj.getContext().getCacheDir() + "topstory/", true)) });
      Object localObject1 = new e(h.dNS());
      if (((e)localObject1).exists())
      {
        localObject1 = ((e)localObject1).fhW();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            boolean bool = i.cO(com.tencent.mm.vfs.q.B(localObject2.fhU()), true);
            ad.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { com.tencent.mm.vfs.q.B(localObject2.fhU()), Boolean.valueOf(bool) });
            i += 1;
          }
        }
        i.aMF(h.dNS() + ".nomedia/");
        AppMethodBeat.o(88409);
        return;
      }
      i.aMF(h.dNS());
      i.aMF(h.dNS() + ".nomedia/");
      ad.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
      AppMethodBeat.o(88409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */