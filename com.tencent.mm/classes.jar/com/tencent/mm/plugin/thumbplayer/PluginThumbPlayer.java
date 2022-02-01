package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.thumbplayer.b.h;
import com.tencent.thumbplayer.b.h.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isOpenTPFlowControl", "", "isOpenTPPlayer", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private ad.b BpI;
  private int BpJ;
  private final d.f BpK;
  private final String TAG;
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(217060);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.BpK = d.g.O((d.g.a.a)a.BpL);
    AppMethodBeat.o(217060);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(217055);
    this.BpJ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qIm, 0);
    if ((this.BpJ == 0) && (((PluginThumbPlayer)this).BpI == null))
    {
      ad.b localb = ad.bc(XLogSetup.cachePath, XLogSetup.logPath, "TP");
      p.g(localb, "Log.openLogInstance(Xlog…ogSetup.logPath, \"TP\", 0)");
      this.BpI = localb;
    }
    h.a((h.a)new b(this));
    h.cB(aj.getContext(), "60303");
    h.fWv();
    h.fWw();
    AppMethodBeat.o(217055);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(217052);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.BpK.getValue();
    AppMethodBeat.o(217052);
    return locala;
  }
  
  public final boolean isOpenTPFlowControl()
  {
    AppMethodBeat.i(217059);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("tpplayer", "openFlowControl")) == 1)
      {
        AppMethodBeat.o(217059);
        return true;
      }
      AppMethodBeat.o(217059);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHB, 0) == 1)
    {
      AppMethodBeat.o(217059);
      return true;
    }
    AppMethodBeat.o(217059);
    return false;
  }
  
  public final boolean isOpenTPPlayer()
  {
    AppMethodBeat.i(217056);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("tpplayer", "openFlag")) == 1)
      {
        AppMethodBeat.o(217056);
        return true;
      }
      AppMethodBeat.o(217056);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHA, 1) == 1)
    {
      AppMethodBeat.o(217056);
      return true;
    }
    AppMethodBeat.o(217056);
    return false;
  }
  
  public final boolean isOpenTPPlayerBgPrepare()
  {
    AppMethodBeat.i(217057);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("tpplayer", "openBgPrepare")) == 1)
      {
        AppMethodBeat.o(217057);
        return true;
      }
      AppMethodBeat.o(217057);
      return false;
    }
    AppMethodBeat.o(217057);
    return true;
  }
  
  public final boolean isOpenTPPlayerScroll()
  {
    AppMethodBeat.i(217058);
    com.tencent.mm.util.c localc = com.tencent.mm.util.c.LgD;
    if (com.tencent.mm.util.c.fNM())
    {
      localc = com.tencent.mm.util.c.LgD;
      if (com.tencent.mm.util.c.aXU(com.tencent.mm.util.c.ms("tpplayer", "openScroll")) == 1)
      {
        AppMethodBeat.o(217058);
        return true;
      }
      AppMethodBeat.o(217058);
      return false;
    }
    AppMethodBeat.o(217058);
    return true;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(217053);
    initThumbPlayer();
    AppMethodBeat.o(217053);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(217054);
    if (isOpenTPPlayer())
    {
      com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
      ad.i(locala.TAG, "release cdn task controller");
      locala.BpP.clear();
      locala.BpQ.clear();
      locala.BpN.clear();
      locala.BpO.clear();
      com.tencent.mm.ao.f.aGJ().a(null);
      com.tencent.mm.ao.f.aGJ().a(null);
    }
    AppMethodBeat.o(217054);
  }
  
  public final void parallelsDependency() {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a BpL;
    
    static
    {
      AppMethodBeat.i(217046);
      BpL = new a();
      AppMethodBeat.o(217046);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"})
  public static final class b
    implements h.a
  {
    private final String TAG = "Finder.TPPlayerMgr";
    
    public final int d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217047);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BpM) == 0) && (PluginThumbPlayer.access$getLog$li(this.BpM) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BpM).d(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(217047);
        return 0;
        ad.d(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217050);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BpM) == 0) && (PluginThumbPlayer.access$getLog$li(this.BpM) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BpM).e(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(217050);
        return 0;
        ad.e(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217048);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BpM) == 0) && (PluginThumbPlayer.access$getLog$li(this.BpM) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BpM).i(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(217048);
        return 0;
        ad.i(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217051);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BpM) == 0) && (PluginThumbPlayer.access$getLog$li(this.BpM) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BpM).v(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(217051);
        return 0;
        ad.v(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217049);
      if ((PluginThumbPlayer.access$getOpenXlogMulti$p(this.BpM) == 0) && (PluginThumbPlayer.access$getLog$li(this.BpM) != null)) {
        PluginThumbPlayer.access$getLog$p(this.BpM).w(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(217049);
        return 0;
        ad.w(this.TAG, paramString1 + ':' + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */