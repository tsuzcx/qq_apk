package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
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
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "isOpenTPFlowControl", "", "Ljava/lang/Boolean;", "isOpenTPPlayer", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isEnableMultiXLog", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "plugin-thumbplayer_release"})
public final class PluginThumbPlayer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private Log.LogInstance MPb;
  private int MPc;
  private final kotlin.f MPd;
  private Boolean MPe;
  private Boolean MPf;
  private final String TAG;
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(193230);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.MPd = kotlin.g.ar((kotlin.g.a.a)a.MPg);
    AppMethodBeat.o(193230);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(193214);
    this.MPc = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vYg, 0);
    if ((this.MPc == 0) && (((PluginThumbPlayer)this).MPb == null))
    {
      Log.LogInstance localLogInstance = Log.openLogInstance(2, 0, XLogSetup.cachePath, XLogSetup.logPath, "TP", 0);
      p.j(localLogInstance, "Log.openLogInstance(Xlog…ogSetup.logPath, \"TP\", 0)");
      this.MPb = localLogInstance;
    }
    TPPlayerMgr.setOnLogListener((TPPlayerMgr.OnLogListener)new b(this));
    TPPlayerMgr.initSdk(MMApplicationContext.getContext(), "60303", 1);
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setProxyServiceType(100);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbZ, false);
    Log.i(this.TAG, "enableLocalServerCheck: ".concat(String.valueOf(bool)));
    if (bool) {
      TPPlayerMgr.setHost(new JSONObject().put("EnableLiveDelayConfig", true).toString());
    }
    AppMethodBeat.o(193214);
  }
  
  private final boolean isEnableMultiXLog(int paramInt)
  {
    return (!BuildInfo.DEBUG) && (paramInt == 0) && (((PluginThumbPlayer)this).MPb != null);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(193203);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.MPd.getValue();
    AppMethodBeat.o(193203);
    return locala;
  }
  
  public final boolean isOpenTPFlowControl()
  {
    AppMethodBeat.i(193225);
    if (this.MPf == null) {
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXe, 0) != 1) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.MPf = Boolean.valueOf(bool);
      Boolean localBoolean = this.MPf;
      if (localBoolean == null) {
        break;
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(193225);
      return bool;
    }
    AppMethodBeat.o(193225);
    return false;
  }
  
  public final boolean isOpenTPPlayer()
  {
    AppMethodBeat.i(193218);
    if (this.MPe == null) {
      if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXd, 1) != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      this.MPe = Boolean.valueOf(bool);
      Boolean localBoolean = this.MPe;
      if (localBoolean == null) {
        break;
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(193218);
      return bool;
    }
    AppMethodBeat.o(193218);
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
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(193205);
    initThumbPlayer();
    AppMethodBeat.o(193205);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(193210);
    com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
    Log.i(locala.TAG, "release cdn task controller");
    locala.MPl.clear();
    locala.MPm.clear();
    locala.MPj.clear();
    locala.MPk.clear();
    com.tencent.mm.aq.f.bkh().a(null);
    com.tencent.mm.aq.f.bkh().a(null);
    AppMethodBeat.o(193210);
  }
  
  public final void parallelsDependency() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a MPg;
    
    static
    {
      AppMethodBeat.i(192721);
      MPg = new a();
      AppMethodBeat.o(192721);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"})
  public static final class b
    implements TPPlayerMgr.OnLogListener
  {
    private final String TAG = "Finder.TPPlayerMgr";
    
    public final int d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191245);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.MPh, PluginThumbPlayer.access$getOpenXlogMulti$p(this.MPh))) {
        PluginThumbPlayer.access$getLog$p(this.MPh).d(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(191245);
        return 0;
        Log.d(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191254);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.MPh, PluginThumbPlayer.access$getOpenXlogMulti$p(this.MPh))) {
        PluginThumbPlayer.access$getLog$p(this.MPh).e(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(191254);
        return 0;
        Log.e(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191249);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.MPh, PluginThumbPlayer.access$getOpenXlogMulti$p(this.MPh))) {
        PluginThumbPlayer.access$getLog$p(this.MPh).i(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(191249);
        return 0;
        Log.i(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191257);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.MPh, PluginThumbPlayer.access$getOpenXlogMulti$p(this.MPh))) {
        PluginThumbPlayer.access$getLog$p(this.MPh).v(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(191257);
        return 0;
        Log.v(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(191252);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.MPh, PluginThumbPlayer.access$getOpenXlogMulti$p(this.MPh))) {
        PluginThumbPlayer.access$getLog$p(this.MPh).w(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(191252);
        return 0;
        Log.w(this.TAG, paramString1 + ':' + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */