package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c MVq;
  private b MVr;
  private a MVs;
  private WebView.c MVt = WebView.c.aabm;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    com.tencent.mm.xwebutil.c.a(this.MVt, new WebView.PreInitCallback()
    {
      public final void bEj()
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
    Log.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.MVt.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(g paramg) {}
  
  public a getPerformTracer()
  {
    return this.MVs;
  }
  
  public b getRedDotMgr()
  {
    return this.MVr;
  }
  
  public c getReporter()
  {
    return this.MVq;
  }
  
  public WebView.c getWebViewType()
  {
    return this.MVt;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(88410);
    this.MVq = new c();
    this.MVr = new b();
    this.MVs = new a();
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
    if (this.MVq != null)
    {
      localObject = this.MVq;
      ((c)localObject).KMg.removeCallbacksAndMessages(null);
      ((c)localObject).KMg.quit();
      this.MVq = null;
    }
    if (this.MVr != null)
    {
      localObject = this.MVr;
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).MVC);
      this.MVr = null;
    }
    if (this.MVs != null)
    {
      this.MVs.MVv.clear();
      this.MVs = null;
    }
    com.tencent.mm.plugin.topstory.a.b.a.onFinish();
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(esv paramesv) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public boolean openJsAccelerate()
  {
    AppMethodBeat.i(262120);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vRp, 1) == 1)
    {
      AppMethodBeat.o(262120);
      return true;
    }
    AppMethodBeat.o(262120);
    return false;
  }
  
  public void parallelsDependency() {}
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(88409);
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(u.deleteDir(com.tencent.mm.loader.j.b.aSL() + "ftsrecommendVideo/")) });
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(u.deleteDir(com.tencent.mm.loader.j.b.aSL() + "topstory/")) });
      Log.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(u.deleteDir(MMApplicationContext.getContext().getCacheDir() + "topstory/")) });
      Object localObject1 = new q(com.tencent.mm.plugin.topstory.a.h.gpL());
      if (((q)localObject1).ifE())
      {
        localObject1 = ((q)localObject1).ifJ();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            boolean bool = u.deleteDir(localObject2.bOF());
            Log.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { localObject2.bOF(), Boolean.valueOf(bool) });
            i += 1;
          }
        }
        u.bBD(com.tencent.mm.plugin.topstory.a.h.gpL() + ".nomedia/");
        AppMethodBeat.o(88409);
        return;
      }
      u.bBD(com.tencent.mm.plugin.topstory.a.h.gpL());
      u.bBD(com.tencent.mm.plugin.topstory.a.h.gpL() + ".nomedia/");
      Log.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
      AppMethodBeat.o(88409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */