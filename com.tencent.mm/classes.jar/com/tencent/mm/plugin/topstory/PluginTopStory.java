package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.topstory.a.b.a;
import com.tencent.mm.protocal.protobuf.foe;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private d THU;
  private c THV;
  private WebView.WebViewKind THW = WebView.WebViewKind.aifI;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    com.tencent.mm.xwebutil.c.a(this.THW, new WebView.PreInitCallback()
    {
      public final void aDm()
      {
        AppMethodBeat.i(88408);
        Log.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
        AppMethodBeat.o(88408);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(88407);
        Log.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
        AppMethodBeat.o(88407);
      }
    });
    Log.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.THW.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public c getRedDotMgr()
  {
    return this.THV;
  }
  
  public d getReporter()
  {
    return this.THU;
  }
  
  public WebView.WebViewKind getWebViewType()
  {
    return this.THW;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(88410);
    this.THU = new d();
    this.THV = new c();
    ThreadPool.post(new a((byte)0), "TopStory.InitTopStoryCacheFolderTask");
    if ((!MMApplicationContext.isMainProcess()) || (BuildInfo.IS_ARM64)) {
      preInitXWebView();
    }
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.THU != null)
    {
      localObject = this.THU;
      ((d)localObject).RlS.removeCallbacksAndMessages(null);
      ((d)localObject).RlS.quit();
      this.THU = null;
    }
    if (this.THV != null)
    {
      localObject = this.THV;
      ((v)h.az(v.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((c)localObject).TIf);
      this.THV = null;
    }
    a.onFinish();
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(foe paramfoe) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public boolean openJsAccelerate()
  {
    return true;
  }
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(88409);
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(y.ew(com.tencent.mm.loader.i.b.bmz() + "ftsrecommendVideo/", true)) });
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(y.ew(com.tencent.mm.loader.i.b.bmz() + "topstory/", true)) });
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(y.ew(MMApplicationContext.getContext().getCacheDir() + "topstory/", true)) });
      Object localObject1 = new u(com.tencent.mm.plugin.topstory.a.g.hMH());
      if (((u)localObject1).jKS())
      {
        localObject1 = ((u)localObject1).jKX();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            boolean bool = y.ew(ah.v(localObject2.jKT()), true);
            Log.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { ah.v(localObject2.jKT()), Boolean.valueOf(bool) });
            i += 1;
          }
        }
        y.bDX(com.tencent.mm.plugin.topstory.a.g.hMH() + ".nomedia/");
        AppMethodBeat.o(88409);
        return;
      }
      y.bDX(com.tencent.mm.plugin.topstory.a.g.hMH());
      y.bDX(com.tencent.mm.plugin.topstory.a.g.hMH() + ".nomedia/");
      Log.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
      AppMethodBeat.o(88409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */