package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.d BJm;
  private final a BJn;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.BJn = new a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.BKh;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.eIM().hashCode()), b.BJo);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.BMF;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.eIM().hashCode()), c.BJp);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(237235);
    y.b("recordPlugin", "recordPlugin", 259200000L, 99);
    AppMethodBeat.o(237235);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.k.c.ilt;
    paramg = MMApplicationContext.getContext();
    p.g(paramg, "MMApplicationContext.getContext()");
    p.h(paramg, "context");
    for (;;)
    {
      int i;
      try
      {
        paramg = (ActivityManager)paramg.getSystemService("activity");
        if (paramg != null)
        {
          paramg = paramg.getDeviceConfigurationInfo();
          if (paramg != null)
          {
            j = (paramg.reqGlEsVersion & 0xFFFF0000) >> 16;
            MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gl_key");
            i = localMultiProcessMMKV.decodeInt("support_egl_context_client_version", 3);
            Log.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              locale = com.tencent.mm.media.k.e.ilC;
              com.tencent.mm.media.k.e.aNq();
            }
            if (localMultiProcessMMKV.decodeBool("has_reported_egl_version", false)) {
              break label280;
            }
            Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNr();
            localMultiProcessMMKV.encode("has_reported_egl_version", true);
            break label280;
            localMultiProcessMMKV.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            Log.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZD, true))
          {
            MultiProcessMMKV.getMMKV("mmkv_gl_key").encode("support_egl_context_client_version", 3);
            AppMethodBeat.o(75045);
          }
        }
        else
        {
          paramg = null;
          continue;
        }
        i = j;
      }
      catch (Exception paramg)
      {
        Log.printErrStackTrace("MicroMsg.GLEnvironmentUtil", (Throwable)paramg, "", new Object[0]);
        AppMethodBeat.o(75045);
        return;
      }
      label280:
      if (j >= 3) {
        i = 3;
      }
      int j = i;
      if (i <= 2) {
        j = 2;
      }
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.d getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.g.aAf().azk();
    if (this.BJm == null)
    {
      localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      this.BJm = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)localObject);
    }
    Object localObject = this.BJm;
    if (localObject == null) {
      p.hyc();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(75046);
    this.BJn.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.f.BKw;
    com.tencent.mm.plugin.recordvideo.background.f.eIX();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.BJn.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      p.hyc();
    }
    this.BJm = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(75040);
      if (com.tencent.mm.kernel.g.aAc())
      {
        paramString = com.tencent.mm.kernel.g.aAf();
        p.g(paramString, "account()");
        if (paramString.azq()) {
          com.tencent.mm.kernel.a.azj();
        }
      }
      AppMethodBeat.o(75040);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(75039);
      if (com.tencent.mm.kernel.g.aAc())
      {
        paramString = com.tencent.mm.kernel.g.aAf();
        p.g(paramString, "account()");
        if ((paramString.azq()) && (!com.tencent.mm.kernel.a.azj()))
        {
          paramString = com.tencent.mm.kernel.g.aAh();
          p.g(paramString, "storage()");
          paramString = paramString.azQ().get(ar.a.Oji, Long.valueOf(0L));
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(75039);
            throw paramString;
          }
          if (Util.secondsToNow(Util.nullAsNil((Long)paramString)) > 86400L)
          {
            paramString = com.tencent.mm.kernel.g.aAh();
            p.g(paramString, "storage()");
            paramString.azQ().set(ar.a.Oji, Long.valueOf(Util.nowSecond()));
            paramString = com.tencent.mm.plugin.recordvideo.background.e.BKp;
            com.tencent.mm.plugin.recordvideo.background.e.eIU();
          }
        }
      }
      AppMethodBeat.o(75039);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class b
    implements h.b
  {
    public static final b BJo;
    
    static
    {
      AppMethodBeat.i(75042);
      BJo = new b();
      AppMethodBeat.o(75042);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75041);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.d.BKl;
      localObject = com.tencent.mm.plugin.recordvideo.background.d.dax();
      AppMethodBeat.o(75041);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c BJp;
    
    static
    {
      AppMethodBeat.i(75044);
      BJp = new c();
      AppMethodBeat.o(75044);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75043);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.BMs;
      localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.dax();
      AppMethodBeat.o(75043);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */