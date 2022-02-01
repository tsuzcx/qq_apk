package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.thumbplayer.b.h;
import com.tencent.thumbplayer.b.h.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isOpenTPFlowControl", "", "isOpenTPPlayer", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private ae.b BHh;
  private int BHi;
  private final d.f BHj;
  private final String TAG;
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(211670);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.BHj = d.g.O((d.g.a.a)a.BHk);
    AppMethodBeat.o(211670);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(211665);
    this.BHi = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPT, 0);
    if ((this.BHi == 0) && (((PluginThumbPlayer)this).BHh == null))
    {
      ae.b localb = ae.bd(XLogSetup.cachePath, XLogSetup.logPath, "TP");
      p.g(localb, "Log.openLogInstance(Xlog…ogSetup.logPath, \"TP\", 0)");
      this.BHh = localb;
    }
    h.a((h.a)new b(this));
    h.cC(ak.getContext(), "60303");
    h.gaU();
    h.gaV();
    AppMethodBeat.o(211665);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(211662);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.BHj.getValue();
    AppMethodBeat.o(211662);
    return locala;
  }
  
  public final boolean isOpenTPFlowControl()
  {
    AppMethodBeat.i(211669);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("tpplayer", "openFlowControl")) == 1)
      {
        AppMethodBeat.o(211669);
        return true;
      }
      AppMethodBeat.o(211669);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPh, 0) == 1)
    {
      AppMethodBeat.o(211669);
      return true;
    }
    AppMethodBeat.o(211669);
    return false;
  }
  
  public final boolean isOpenTPPlayer()
  {
    AppMethodBeat.i(211666);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("tpplayer", "openFlag")) == 1)
      {
        AppMethodBeat.o(211666);
        return true;
      }
      AppMethodBeat.o(211666);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPg, 1) == 1)
    {
      AppMethodBeat.o(211666);
      return true;
    }
    AppMethodBeat.o(211666);
    return false;
  }
  
  public final boolean isOpenTPPlayerBgPrepare()
  {
    AppMethodBeat.i(211667);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("tpplayer", "openBgPrepare")) == 1)
      {
        AppMethodBeat.o(211667);
        return true;
      }
      AppMethodBeat.o(211667);
      return false;
    }
    AppMethodBeat.o(211667);
    return true;
  }
  
  public final boolean isOpenTPPlayerScroll()
  {
    AppMethodBeat.i(211668);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LDf;
    if (com.tencent.mm.util.c.fSh())
    {
      localc = com.tencent.mm.util.c.LDf;
      if (com.tencent.mm.util.c.aZw(com.tencent.mm.util.c.mz("tpplayer", "openScroll")) == 1)
      {
        AppMethodBeat.o(211668);
        return true;
      }
      AppMethodBeat.o(211668);
      return false;
    }
    AppMethodBeat.o(211668);
    return true;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(211663);
    initThumbPlayer();
    AppMethodBeat.o(211663);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(211664);
    if (isOpenTPPlayer())
    {
      com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
      ae.i(locala.TAG, "release cdn task controller");
      locala.BHo.clear();
      locala.BHp.clear();
      locala.BHm.clear();
      locala.BHn.clear();
      com.tencent.mm.an.f.aHa().a(null);
      com.tencent.mm.an.f.aHa().a(null);
    }
    AppMethodBeat.o(211664);
  }
  
  public final void parallelsDependency() {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a BHk;
    
    static
    {
      AppMethodBeat.i(211656);
      BHk = new a();
      AppMethodBeat.o(211656);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"})
  public static final class b
    implements h.a
  {
    private final String TAG = "Finder.TPPlayerMgr";
    
    public final int d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211657);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BHl) == 0) && (PluginThumbPlayer.access$getLog$li(this.BHl) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BHl).d(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(211657);
        return 0;
        ae.d(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211660);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BHl) == 0) && (PluginThumbPlayer.access$getLog$li(this.BHl) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BHl).e(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(211660);
        return 0;
        ae.e(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211658);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BHl) == 0) && (PluginThumbPlayer.access$getLog$li(this.BHl) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BHl).i(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(211658);
        return 0;
        ae.i(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211661);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BHl) == 0) && (PluginThumbPlayer.access$getLog$li(this.BHl) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BHl).v(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(211661);
        return 0;
        ae.v(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(211659);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BHl) == 0) && (PluginThumbPlayer.access$getLog$li(this.BHl) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BHl).w(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(211659);
        return 0;
        ae.w(this.TAG, paramString1 + ':' + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */