package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.af;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "accessibilityConfigSet", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getAccessibilityConfigSet", "", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "registerAccessibilityConfig", "config", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.d NCY;
  private final HashSet<Class<? extends MMBaseAccessibilityConfig>> NCZ;
  private final PluginVideoEditor.a NDa;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.NCZ = new HashSet();
    this.NDa = new PluginVideoEditor.a();
    AppMethodBeat.o(75051);
  }
  
  private static final String[] collectDatabaseFactory$lambda-0()
  {
    AppMethodBeat.i(279331);
    Object localObject = com.tencent.mm.plugin.recordvideo.background.d.NDT;
    localObject = com.tencent.mm.plugin.recordvideo.background.d.dZh();
    AppMethodBeat.o(279331);
    return localObject;
  }
  
  private static final String[] collectDatabaseFactory$lambda-1()
  {
    AppMethodBeat.i(279338);
    Object localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.NFW;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.dZh();
    AppMethodBeat.o(279338);
    return localObject;
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.NDN;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.gGG().hashCode()), PluginVideoEditor..ExternalSyntheticLambda1.INSTANCE);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.NGj;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.gGG().hashCode()), PluginVideoEditor..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(279358);
    af.a("recordPlugin", "recordPlugin", 259200000L, 97);
    AppMethodBeat.o(279358);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.util.c.nFs;
    paramg = MMApplicationContext.getContext();
    s.s(paramg, "getContext()");
    s.u(paramg, "context");
    for (;;)
    {
      int i;
      try
      {
        paramg = (ActivityManager)paramg.getSystemService("activity");
        if (paramg == null)
        {
          paramg = null;
          if (paramg != null)
          {
            j = (paramg.reqGlEsVersion & 0xFFFF0000) >> 16;
            MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("mmkv_gl_key");
            i = localMultiProcessMMKV.decodeInt("support_egl_context_client_version", 3);
            Log.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              localf = com.tencent.mm.media.util.f.nFE;
              com.tencent.mm.media.util.f.bqB();
            }
            if (localMultiProcessMMKV.decodeBool("has_reported_egl_version", false)) {
              break label287;
            }
            Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.bqC();
            localMultiProcessMMKV.encode("has_reported_egl_version", true);
            break label287;
            localMultiProcessMMKV.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            Log.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWy, true))
          {
            MultiProcessMMKV.getMMKV("mmkv_gl_key").encode("support_egl_context_client_version", 3);
            AppMethodBeat.o(75045);
          }
        }
        else
        {
          paramg = paramg.getDeviceConfigurationInfo();
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
      label287:
      if (j >= 3) {
        i = 3;
      }
      int j = i;
      if (i <= 2) {
        j = 2;
      }
    }
  }
  
  public final Set<Class<? extends MMBaseAccessibilityConfig>> getAccessibilityConfigSet()
  {
    return (Set)this.NCZ;
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.d getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (this.NCY == null)
    {
      localObject = com.tencent.mm.kernel.h.baE().mCN;
      s.s(localObject, "storage().dataDB");
      this.NCY = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)localObject);
    }
    Object localObject = this.NCY;
    s.checkNotNull(localObject);
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(75046);
    this.NDa.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.f.NDY;
    com.tencent.mm.plugin.recordvideo.background.f.gGR();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.NDa.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(75049);
    s.checkNotNull(paramh1);
    this.NCY = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)paramh1);
    AppMethodBeat.o(75049);
  }
  
  public final void registerAccessibilityConfig(Class<? extends MMBaseAccessibilityConfig> paramClass)
  {
    AppMethodBeat.i(279394);
    if (paramClass != null) {
      this.NCZ.add(paramClass);
    }
    AppMethodBeat.o(279394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */