package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogInstance;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "isOpenTPFlowControl", "", "Ljava/lang/Boolean;", "isOpenTPPlayer", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isEnableMultiXLog", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private Log.LogInstance Ggm;
  private int Ggn;
  private final kotlin.f Ggo;
  private Boolean Ggp;
  private Boolean Ggq;
  private final String TAG;
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(238610);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.Ggo = kotlin.g.ah((kotlin.g.a.a)a.Ggr);
    AppMethodBeat.o(238610);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(238607);
    this.Ggn = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sne, 0);
    if ((this.Ggn == 0) && (((PluginThumbPlayer)this).Ggm == null))
    {
      Log.LogInstance localLogInstance = Log.openLogInstance(2, 0, XLogSetup.cachePath, XLogSetup.logPath, "TP", 0);
      p.g(localLogInstance, "Log.openLogInstance(Xlog…ogSetup.logPath, \"TP\", 0)");
      this.Ggm = localLogInstance;
    }
    TPPlayerMgr.setOnLogListener((TPPlayerMgr.OnLogListener)new b(this));
    TPPlayerMgr.initSdk(MMApplicationContext.getContext(), "60303", 1);
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setProxyServiceType(100);
    AppMethodBeat.o(238607);
  }
  
  private final boolean isEnableMultiXLog(int paramInt)
  {
    return (!BuildInfo.DEBUG) && (paramInt == 0) && (((PluginThumbPlayer)this).Ggm != null);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(238604);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.Ggo.getValue();
    AppMethodBeat.o(238604);
    return locala;
  }
  
  public final boolean isOpenTPFlowControl()
  {
    AppMethodBeat.i(238609);
    if (this.Ggq == null) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smp, 0) != 1) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.Ggq = Boolean.valueOf(bool);
      Boolean localBoolean = this.Ggq;
      if (localBoolean == null) {
        break;
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(238609);
      return bool;
    }
    AppMethodBeat.o(238609);
    return false;
  }
  
  public final boolean isOpenTPPlayer()
  {
    AppMethodBeat.i(238608);
    if (this.Ggp == null) {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smo, 1) != 1) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.Ggp = Boolean.valueOf(bool);
      Boolean localBoolean = this.Ggp;
      if (localBoolean == null) {
        break;
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(238608);
      return bool;
    }
    AppMethodBeat.o(238608);
    return true;
  }
  
  public final boolean isOpenTPPlayerBgPrepare()
  {
    return true;
  }
  
  public final boolean isOpenTPPlayerScroll()
  {
    return true;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(238605);
    initThumbPlayer();
    AppMethodBeat.o(238605);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(238606);
    com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
    Log.i(locala.TAG, "release cdn task controller");
    locala.Ggw.clear();
    locala.Ggx.clear();
    locala.Ggu.clear();
    locala.Ggv.clear();
    com.tencent.mm.an.f.baR().a(null);
    com.tencent.mm.an.f.baR().a(null);
    AppMethodBeat.o(238606);
  }
  
  public final void parallelsDependency() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a Ggr;
    
    static
    {
      AppMethodBeat.i(238598);
      Ggr = new a();
      AppMethodBeat.o(238598);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"})
  public static final class b
    implements TPPlayerMgr.OnLogListener
  {
    private final String TAG = "Finder.TPPlayerMgr";
    
    public final int d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238599);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, PluginThumbPlayer.access$getOpenXlogMulti$p(this.Ggs))) {
        PluginThumbPlayer.access$getLog$p(this.Ggs).d(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(238599);
        return 0;
        Log.d(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238602);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, PluginThumbPlayer.access$getOpenXlogMulti$p(this.Ggs))) {
        PluginThumbPlayer.access$getLog$p(this.Ggs).e(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(238602);
        return 0;
        Log.e(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238600);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, PluginThumbPlayer.access$getOpenXlogMulti$p(this.Ggs))) {
        PluginThumbPlayer.access$getLog$p(this.Ggs).i(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(238600);
        return 0;
        Log.i(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238603);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, PluginThumbPlayer.access$getOpenXlogMulti$p(this.Ggs))) {
        PluginThumbPlayer.access$getLog$p(this.Ggs).v(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(238603);
        return 0;
        Log.v(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(238601);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.Ggs, PluginThumbPlayer.access$getOpenXlogMulti$p(this.Ggs))) {
        PluginThumbPlayer.access$getLog$p(this.Ggs).w(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(238601);
        return 0;
        Log.w(this.TAG, paramString1 + ':' + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */