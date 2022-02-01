package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.d xJj;
  private final PluginVideoEditor.a xJk;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.xJk = new PluginVideoEditor.a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.xKd;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.dHZ().hashCode()), b.xJl);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.xMz;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.dHZ().hashCode()), PluginVideoEditor.c.xJm);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.k.c.hrD;
    paramg = ak.getContext();
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
            ay localay = ay.aRW("mmkv_gl_key");
            i = localay.decodeInt("support_egl_context_client_version", 3);
            ae.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              ae.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              locald = com.tencent.mm.media.k.d.hrI;
              com.tencent.mm.media.k.d.auD();
            }
            if (localay.decodeBool("has_reported_egl_version", false)) {
              break label279;
            }
            ae.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.auE();
            localay.encode("has_reported_egl_version", true);
            break label279;
            localay.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            ae.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGp, true))
          {
            ay.aRW("mmkv_gl_key").encode("support_egl_context_client_version", 3);
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
        ae.printErrStackTrace("MicroMsg.GLEnvironmentUtil", (Throwable)paramg, "", new Object[0]);
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
  
  public final com.tencent.mm.plugin.recordvideo.background.d getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.g.ajP().aiU();
    if (this.xJj == null)
    {
      localObject = com.tencent.mm.kernel.g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      this.xJj = new com.tencent.mm.plugin.recordvideo.background.d((com.tencent.mm.sdk.e.e)localObject);
    }
    Object localObject = this.xJj;
    if (localObject == null) {
      p.gkB();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(75046);
    this.xJk.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.f.xKs;
    com.tencent.mm.plugin.recordvideo.background.f.dIk();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.xJk.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      p.gkB();
    }
    this.xJj = new com.tencent.mm.plugin.recordvideo.background.d((com.tencent.mm.sdk.e.e)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class b
    implements h.b
  {
    public static final b xJl;
    
    static
    {
      AppMethodBeat.i(75042);
      xJl = new b();
      AppMethodBeat.o(75042);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75041);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.d.xKh;
      localObject = com.tencent.mm.plugin.recordvideo.background.d.cBk();
      AppMethodBeat.o(75041);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */