package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.e vcx;
  private final PluginVideoEditor.a vcy;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.vcy = new PluginVideoEditor.a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.d.vdA;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.d.dgE().hashCode()), b.vcz);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.vga;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.dgE().hashCode()), PluginVideoEditor.c.vcA);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.j.c.gwl;
    paramg = aj.getContext();
    k.g(paramg, "MMApplicationContext.getContext()");
    k.h(paramg, "context");
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
            ax localax = ax.aFC("mmkv_gl_key");
            i = localax.decodeInt("support_egl_context_client_version", 3);
            ad.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              ad.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              locald = com.tencent.mm.media.j.d.gwr;
              com.tencent.mm.media.j.d.akH();
            }
            if (localax.decodeBool("has_reported_egl_version", false)) {
              break label279;
            }
            ad.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.akI();
            localax.encode("has_reported_egl_version", true);
            break label279;
            localax.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            ad.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pqQ, true))
          {
            ax.aFC("mmkv_gl_key").encode("support_egl_context_client_version", 3);
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
        ad.printErrStackTrace("MicroMsg.GLEnvironmentUtil", (Throwable)paramg, "", new Object[0]);
        AppMethodBeat.o(75045);
        return;
      }
      label279:
      if (j >= 3) {
        i = 3;
      }
      int j = i;
      if (i <= 2) {
        j = 2;
      }
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.background.e getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.g.afz().aeD();
    if (this.vcx == null)
    {
      localObject = com.tencent.mm.kernel.g.afB();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afg();
      k.g(localObject, "MMKernel.storage().dataDB");
      this.vcx = new com.tencent.mm.plugin.recordvideo.background.e((com.tencent.mm.sdk.e.e)localObject);
    }
    Object localObject = this.vcx;
    if (localObject == null) {
      k.fvU();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(75046);
    this.vcy.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.g.vdS;
    com.tencent.mm.plugin.recordvideo.background.g.dgP();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.vcy.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      k.fvU();
    }
    this.vcx = new com.tencent.mm.plugin.recordvideo.background.e((com.tencent.mm.sdk.e.e)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class b
    implements h.b
  {
    public static final b vcz;
    
    static
    {
      AppMethodBeat.i(75042);
      vcz = new b();
      AppMethodBeat.o(75042);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75041);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.e.vdE;
      localObject = com.tencent.mm.plugin.recordvideo.background.e.clk();
      AppMethodBeat.o(75041);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */