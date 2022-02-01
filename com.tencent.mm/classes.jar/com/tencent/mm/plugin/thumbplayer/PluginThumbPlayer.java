package com.tencent.mm.plugin.thumbplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ac;
import com.tencent.mm.app.ac.b;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogInstance;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/PluginThumbPlayer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/thumbplayer/api/IPluginThumbPlayer;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/app/ProcForegroundDelegate$Listener;", "()V", "TAG", "", "cdnTaskController", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "getCdnTaskController", "()Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;", "cdnTaskController$delegate", "Lkotlin/Lazy;", "isOpenTPFlowControl", "", "Ljava/lang/Boolean;", "isOpenTPPlayer", "log", "Lcom/tencent/mm/sdk/platformtools/Log$LogInstance;", "openXlogMulti", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "initThumbPlayer", "isEnableMultiXLog", "isOpenTPPlayerBgPrepare", "isOpenTPPlayerScroll", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onProcessBackground", "activityName", "onProcessForeground", "parallelsDependency", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginThumbPlayer
  extends f
  implements ac.b, b, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.thumbplayer.a.a
{
  private final String TAG;
  private Log.LogInstance TBB;
  private int TBC;
  private final j TBD;
  private Boolean TBE;
  private Boolean TBF;
  
  public PluginThumbPlayer()
  {
    AppMethodBeat.i(272027);
    this.TAG = "MicroMsg.TP.PluginThumbPlayer";
    this.TBD = kotlin.k.cm((kotlin.g.a.a)a.TBG);
    AppMethodBeat.o(272027);
  }
  
  private final void initThumbPlayer()
  {
    AppMethodBeat.i(272036);
    this.TBC = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zqW, 0);
    if ((this.TBC == 0) && (this.TBB == null))
    {
      Log.LogInstance localLogInstance = Log.openLogInstance(2, 0, XLogSetup.cachePath, XLogSetup.logPath, "TP", 0);
      s.s(localLogInstance, "openLogInstance(Xlog.LEV…ogSetup.logPath, \"TP\", 0)");
      this.TBB = localLogInstance;
    }
    TPPlayerMgr.setOnLogListener((TPPlayerMgr.OnLogListener)new b(this));
    TPPlayerMgr.initSdk(MMApplicationContext.getContext(), "60303", 1);
    TPPlayerMgr.setProxyEnable(true);
    TPPlayerMgr.setProxyServiceType(100);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zaj, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      TPPlayerMgr.setVideoMediaCodecStuckCheck(bool1);
      boolean bool2 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zvx, false);
      Log.i(this.TAG, "enableLocalServerCheck: " + bool2 + " mediaCodecStuckCheck: " + bool1);
      if (bool2) {
        TPPlayerMgr.setHost(new JSONObject().put("EnableCheckLocalServer", true).toString());
      }
      ac.aCN().a((ac.b)this);
      AppMethodBeat.o(272036);
      return;
    }
  }
  
  private final boolean isEnableMultiXLog(int paramInt)
  {
    return (!BuildInfo.DEBUG) && (paramInt == 0) && (this.TBB != null);
  }
  
  public final void execute(g paramg) {}
  
  public final com.tencent.mm.plugin.thumbplayer.b.a getCdnTaskController()
  {
    AppMethodBeat.i(272059);
    com.tencent.mm.plugin.thumbplayer.b.a locala = (com.tencent.mm.plugin.thumbplayer.b.a)this.TBD.getValue();
    AppMethodBeat.o(272059);
    return locala;
  }
  
  public final boolean isOpenTPFlowControl()
  {
    AppMethodBeat.i(272100);
    if (this.TBF == null) {
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpJ, 0) != 1) {
        break label61;
      }
    }
    Boolean localBoolean;
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.TBF = Boolean.valueOf(bool);
      localBoolean = this.TBF;
      if (localBoolean != null) {
        break;
      }
      AppMethodBeat.o(272100);
      return false;
    }
    bool = localBoolean.booleanValue();
    AppMethodBeat.o(272100);
    return bool;
  }
  
  public final boolean isOpenTPPlayer()
  {
    AppMethodBeat.i(272076);
    if (this.TBE == null) {
      if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpI, 1) != 1) {
        break label61;
      }
    }
    Boolean localBoolean;
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.TBE = Boolean.valueOf(bool);
      localBoolean = this.TBE;
      if (localBoolean != null) {
        break;
      }
      AppMethodBeat.o(272076);
      return true;
    }
    bool = localBoolean.booleanValue();
    AppMethodBeat.o(272076);
    return bool;
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
    AppMethodBeat.i(272064);
    initThumbPlayer();
    AppMethodBeat.o(272064);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(272069);
    com.tencent.mm.plugin.thumbplayer.b.a locala = getCdnTaskController();
    Log.i(locala.TAG, "release cdn task controller");
    locala.TBS.clear();
    locala.TBT.clear();
    locala.TBQ.clear();
    locala.TBR.clear();
    com.tencent.mm.modelcdntran.k.bHX().a(null);
    com.tencent.mm.modelcdntran.k.bHX().a(null);
    ac.aCN().b((ac.b)this);
    AppMethodBeat.o(272069);
  }
  
  public final void onProcessBackground(String paramString)
  {
    AppMethodBeat.i(272116);
    if (TPDownloadProxyNative.getInstance().isReadyForWork()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(13);
        AppMethodBeat.o(272116);
        return;
      }
      finally
      {
        Log.e(this.TAG, s.X("pushEvent failed, error: ", paramString));
      }
    }
    AppMethodBeat.o(272116);
  }
  
  public final void onProcessForeground(String paramString)
  {
    AppMethodBeat.i(272109);
    if (TPDownloadProxyNative.getInstance().isReadyForWork()) {
      try
      {
        TPDownloadProxyNative.getInstance().pushEvent(14);
        AppMethodBeat.o(272109);
        return;
      }
      finally
      {
        Log.e(this.TAG, s.X("pushEvent failed, error: ", paramString));
      }
    }
    AppMethodBeat.o(272109);
  }
  
  public final void parallelsDependency() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/cdn/CdnTaskController;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.b.a>
  {
    public static final a TBG;
    
    static
    {
      AppMethodBeat.i(272018);
      TBG = new a();
      AppMethodBeat.o(272018);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/PluginThumbPlayer$initThumbPlayer$2", "Lcom/tencent/thumbplayer/api/TPPlayerMgr$OnLogListener;", "TAG", "", "getTAG", "()Ljava/lang/String;", "d", "", "tag", "msg", "e", "i", "v", "w", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TPPlayerMgr.OnLogListener
  {
    private final String TAG = "Finder.TPPlayerMgr";
    
    b(PluginThumbPlayer paramPluginThumbPlayer) {}
    
    public final int d(String paramString1, String paramString2)
    {
      AppMethodBeat.i(272016);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.TBH, PluginThumbPlayer.access$getOpenXlogMulti$p(this.TBH)))
      {
        Log.LogInstance localLogInstance2 = PluginThumbPlayer.access$getLog$p(this.TBH);
        Log.LogInstance localLogInstance1 = localLogInstance2;
        if (localLogInstance2 == null)
        {
          s.bIx("log");
          localLogInstance1 = null;
        }
        localLogInstance1.d(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(272016);
        return 0;
        Log.d(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int e(String paramString1, String paramString2)
    {
      AppMethodBeat.i(272029);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.TBH, PluginThumbPlayer.access$getOpenXlogMulti$p(this.TBH)))
      {
        Log.LogInstance localLogInstance2 = PluginThumbPlayer.access$getLog$p(this.TBH);
        Log.LogInstance localLogInstance1 = localLogInstance2;
        if (localLogInstance2 == null)
        {
          s.bIx("log");
          localLogInstance1 = null;
        }
        localLogInstance1.e(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(272029);
        return 0;
        Log.e(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int i(String paramString1, String paramString2)
    {
      AppMethodBeat.i(272021);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.TBH, PluginThumbPlayer.access$getOpenXlogMulti$p(this.TBH)))
      {
        Log.LogInstance localLogInstance2 = PluginThumbPlayer.access$getLog$p(this.TBH);
        Log.LogInstance localLogInstance1 = localLogInstance2;
        if (localLogInstance2 == null)
        {
          s.bIx("log");
          localLogInstance1 = null;
        }
        localLogInstance1.i(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(272021);
        return 0;
        Log.i(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int v(String paramString1, String paramString2)
    {
      AppMethodBeat.i(272033);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.TBH, PluginThumbPlayer.access$getOpenXlogMulti$p(this.TBH)))
      {
        Log.LogInstance localLogInstance2 = PluginThumbPlayer.access$getLog$p(this.TBH);
        Log.LogInstance localLogInstance1 = localLogInstance2;
        if (localLogInstance2 == null)
        {
          s.bIx("log");
          localLogInstance1 = null;
        }
        localLogInstance1.v(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(272033);
        return 0;
        Log.v(this.TAG, paramString1 + ':' + paramString2);
      }
    }
    
    public final int w(String paramString1, String paramString2)
    {
      AppMethodBeat.i(272025);
      if (PluginThumbPlayer.access$isEnableMultiXLog(this.TBH, PluginThumbPlayer.access$getOpenXlogMulti$p(this.TBH)))
      {
        Log.LogInstance localLogInstance2 = PluginThumbPlayer.access$getLog$p(this.TBH);
        Log.LogInstance localLogInstance1 = localLogInstance2;
        if (localLogInstance2 == null)
        {
          s.bIx("log");
          localLogInstance1 = null;
        }
        localLogInstance1.w(this.TAG, paramString1 + ':' + paramString2, new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(272025);
        return 0;
        Log.w(this.TAG, paramString1 + ':' + paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer
 * JD-Core Version:    0.7.0.1
 */