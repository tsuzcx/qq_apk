package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.cr.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import java.util.Map;

public class PluginTopStory
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.topstory.a.b
{
  private c GiE;
  private b GiF;
  private a GiG;
  private WebView.c GiH = WebView.c.SAt;
  
  private void preInitXWebView()
  {
    AppMethodBeat.i(88412);
    d.a(this.GiH, new WebView.PreInitCallback()
    {
      public final void btl()
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
    Log.i("MicroMsg.TopStory.PluginTopStory", "Start To Load WebView %s", new Object[] { this.GiH.name() });
    AppMethodBeat.o(88412);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public a getPerformTracer()
  {
    return this.GiG;
  }
  
  public b getRedDotMgr()
  {
    return this.GiF;
  }
  
  public c getReporter()
  {
    return this.GiE;
  }
  
  public WebView.c getWebViewType()
  {
    return this.GiH;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(88410);
    this.GiE = new c();
    this.GiF = new b();
    this.GiG = new a();
    ThreadPool.post(new PluginTopStory.a(this, (byte)0), "TopStory.InitTopStoryCacheFolderTask");
    preInitXWebView();
    AppMethodBeat.o(88410);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(88411);
    Object localObject;
    if (this.GiE != null)
    {
      localObject = this.GiE;
      ((c)localObject).Eyp.removeCallbacksAndMessages(null);
      ((c)localObject).Eyp.quit();
      this.GiE = null;
    }
    if (this.GiF != null)
    {
      localObject = this.GiF;
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", ((b)localObject).GiO);
      EventCenter.instance.removeListener(((b)localObject).GiS);
      this.GiF = null;
    }
    if (this.GiG != null)
    {
      this.GiG.GiJ.clear();
      this.GiG = null;
    }
    if (com.tencent.mm.plugin.topstory.a.b.a.Gjc != null)
    {
      if (com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg != null)
      {
        com.tencent.mm.kernel.g.azz().a(com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg);
        com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjg = null;
      }
      if (com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh != null)
      {
        com.tencent.mm.kernel.g.azz().a(com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh);
        com.tencent.mm.plugin.topstory.a.b.a.Gjc.Gjh = null;
      }
      com.tencent.mm.kernel.g.azz().b(2748, com.tencent.mm.plugin.topstory.a.b.a.Gjc);
      com.tencent.mm.plugin.topstory.a.b.a.Gjc = null;
    }
    AppMethodBeat.o(88411);
  }
  
  public void onVideoListUICreate() {}
  
  public void onVideoListUIDestroy(eit parameit) {}
  
  public void onVideoListUIPause() {}
  
  public void onVideoListUIResume() {}
  
  public boolean openJsAccelerate()
  {
    AppMethodBeat.i(201208);
    com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
    b.a locala = b.a.sht;
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.QYz;
    if (localb.a(locala, Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("topstory", "openJsAccelerate")), 0)) == 1)
    {
      AppMethodBeat.o(201208);
      return true;
    }
    AppMethodBeat.o(201208);
    return false;
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory
 * JD-Core Version:    0.7.0.1
 */