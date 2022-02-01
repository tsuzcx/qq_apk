package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.ab;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.d HFw;
  private final PluginVideoEditor.a HFx;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.HFx = new PluginVideoEditor.a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.HGr;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.fuQ().hashCode()), b.HFy);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.HIR;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.fuQ().hashCode()), PluginVideoEditor.c.HFz);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(226690);
    ab.a("recordPlugin", "recordPlugin", 259200000L, 97);
    AppMethodBeat.o(226690);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.k.c.lar;
    paramg = MMApplicationContext.getContext();
    p.j(paramg, "MMApplicationContext.getContext()");
    p.k(paramg, "context");
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
              localf = com.tencent.mm.media.k.f.laB;
              com.tencent.mm.media.k.f.aVU();
            }
            if (localMultiProcessMMKV.decodeBool("has_reported_egl_version", false)) {
              break label280;
            }
            Log.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aVV();
            localMultiProcessMMKV.encode("has_reported_egl_version", true);
            break label280;
            localMultiProcessMMKV.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            Log.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGD, true))
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
    com.tencent.mm.kernel.h.aHE().aGH();
    if (this.HFw == null)
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).getDataDB();
      p.j(localObject, "MMKernel.storage().dataDB");
      this.HFw = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)localObject);
    }
    Object localObject = this.HFw;
    if (localObject == null) {
      p.iCn();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(75046);
    this.HFx.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.f.HGG;
    com.tencent.mm.plugin.recordvideo.background.f.fvb();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.HFx.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      p.iCn();
    }
    this.HFw = new com.tencent.mm.plugin.recordvideo.background.d((ISQLiteDatabase)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class b
    implements h.b
  {
    public static final b HFy;
    
    static
    {
      AppMethodBeat.i(75042);
      HFy = new b();
      AppMethodBeat.o(75042);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75041);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.d.HGv;
      localObject = com.tencent.mm.plugin.recordvideo.background.d.dqy();
      AppMethodBeat.o(75041);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */