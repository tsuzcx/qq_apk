package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.cp.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c BHW;
  private b BHX;
  private a BHY;
  private WebView.c BHZ = WebView.c.MNy;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    d.a(this.BHZ, new WebView.PreInitCallback()
    {
      public final void aYf()
      {
        AppMethodBeat.i(88408);
        ae.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
        AppMethodBeat.o(88408);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(88407);
        ae.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
        AppMethodBeat.o(88407);
      }
    });
    ae.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.BHZ.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.BHY;
  }
  
  public b getRedDotMgr()
  {
    return this.BHX;
  }
  
  public c getReporter()
  {
    return this.BHW;
  }
  
  public WebView.c getWebViewType()
  {
    return this.BHZ;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88410);
    this.BHW = new c();
    this.BHX = new b();
    this.BHY = new a();
    com.tencent.mm.sdk.g.b.c(new a((byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.BHW != null)
    {
      localObject = this.BHW;
      ((c)localObject).ApE.removeCallbacksAndMessages(null);
      ((c)localObject).ApE.quit();
      this.BHW = null;
    }
    if (this.BHX != null)
    {
      localObject = this.BHX;
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).BIf);
      com.tencent.mm.sdk.b.a.IvT.d(((b)localObject).BIj);
      this.BHX = null;
    }
    if (this.BHY != null)
    {
      this.BHY.BIb.clear();
      this.BHY = null;
    }
    if (com.tencent.mm.plugin.topstory.a.b.a.BIt != null)
    {
      if (com.tencent.mm.plugin.topstory.a.b.a.BIt.BIx != null)
      {
        com.tencent.mm.kernel.g.ajj().a(com.tencent.mm.plugin.topstory.a.b.a.BIt.BIx);
        com.tencent.mm.plugin.topstory.a.b.a.BIt.BIx = null;
      }
      if (com.tencent.mm.plugin.topstory.a.b.a.BIt.BIy != null)
      {
        com.tencent.mm.kernel.g.ajj().a(com.tencent.mm.plugin.topstory.a.b.a.BIt.BIy);
        com.tencent.mm.plugin.topstory.a.b.a.BIt.BIy = null;
      }
      com.tencent.mm.kernel.g.ajj().b(2748, com.tencent.mm.plugin.topstory.a.b.a.BIt);
      com.tencent.mm.plugin.topstory.a.b.a.BIt = null;
    }
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(dox paramdox) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public boolean openJsAccelerate()
  {
    AppMethodBeat.i(195786);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.qLj;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (localb.a(locala, com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("topstory", "openJsAccelerate"))) == 1)
    {
      AppMethodBeat.o(195786);
      return true;
    }
    AppMethodBeat.o(195786);
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
      ae.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard ftsrecommendVideo folder %b", new Object[] { Boolean.valueOf(o.dd(com.tencent.mm.loader.j.b.asj() + "ftsrecommendVideo/", true)) });
      ae.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard topstory folder %b", new Object[] { Boolean.valueOf(o.dd(com.tencent.mm.loader.j.b.asj() + "topstory/", true)) });
      ae.i("MicroMsg.TopStory.PluginTopStory", "Delete sdcard cache topstory folder %b", new Object[] { Boolean.valueOf(o.dd(ak.getContext().getCacheDir() + "topstory/", true)) });
      Object localObject1 = new k(h.esq());
      if (((k)localObject1).exists())
      {
        localObject1 = ((k)localObject1).fTj();
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            boolean bool = o.dd(w.B(localObject2.fTh()), true);
            ae.i("MicroMsg.TopStory.PluginTopStory", "Delete Cache File %s %b", new Object[] { w.B(localObject2.fTh()), Boolean.valueOf(bool) });
            i += 1;
          }
        }
        o.aZI(h.esq() + ".nomedia/");
        AppMethodBeat.o(88409);
        return;
      }
      o.aZI(h.esq());
      o.aZI(h.esq() + ".nomedia/");
      ae.i("MicroMsg.TopStory.PluginTopStory", "Create TopStoryCacheFolder");
      AppMethodBeat.o(88409);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */