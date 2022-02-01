package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.f wlq;
  private final a wlr;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.wlr = new a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.e.wmq;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.e.dum().hashCode()), b.wls);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.woM;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.dum().hashCode()), c.wlt);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.j.c.gWJ;
    paramg = ai.getContext();
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
            aw localaw = aw.aKT("mmkv_gl_key");
            i = localaw.decodeInt("support_egl_context_client_version", 3);
            ac.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              ac.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              locald = com.tencent.mm.media.j.d.gWO;
              com.tencent.mm.media.j.d.arB();
            }
            if (localaw.decodeBool("has_reported_egl_version", false)) {
              break label279;
            }
            ac.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.arC();
            localaw.encode("has_reported_egl_version", true);
            break label279;
            localaw.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            ac.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pUD, true))
          {
            aw.aKT("mmkv_gl_key").encode("support_egl_context_client_version", 3);
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
        ac.printErrStackTrace("MicroMsg.GLEnvironmentUtil", (Throwable)paramg, "", new Object[0]);
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
  
  public final com.tencent.mm.plugin.recordvideo.background.f getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.g.agP().afT();
    if (this.wlq == null)
    {
      localObject = com.tencent.mm.kernel.g.agR();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agw();
      k.g(localObject, "MMKernel.storage().dataDB");
      this.wlq = new com.tencent.mm.plugin.recordvideo.background.f((com.tencent.mm.sdk.e.e)localObject);
    }
    Object localObject = this.wlq;
    if (localObject == null) {
      k.fOy();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(75046);
    this.wlr.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.h.wmI;
    com.tencent.mm.plugin.recordvideo.background.h.dux();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.wlr.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2) {}
  
  public final void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      k.fOy();
    }
    this.wlq = new com.tencent.mm.plugin.recordvideo.background.f((com.tencent.mm.sdk.e.e)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
  public static final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(75040);
      if (com.tencent.mm.kernel.g.agM())
      {
        paramString = com.tencent.mm.kernel.g.agP();
        k.g(paramString, "account()");
        if (paramString.afZ()) {
          com.tencent.mm.kernel.a.afS();
        }
      }
      AppMethodBeat.o(75040);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(75039);
      if (com.tencent.mm.kernel.g.agM())
      {
        paramString = com.tencent.mm.kernel.g.agP();
        k.g(paramString, "account()");
        if ((paramString.afZ()) && (!com.tencent.mm.kernel.a.afS()))
        {
          paramString = com.tencent.mm.kernel.g.agR();
          k.g(paramString, "storage()");
          paramString = paramString.agA().get(ah.a.GTx, Long.valueOf(0L));
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(75039);
            throw paramString;
          }
          if (bs.pN(bs.g((Long)paramString)) > 86400L)
          {
            paramString = com.tencent.mm.kernel.g.agR();
            k.g(paramString, "storage()");
            paramString.agA().set(ah.a.GTx, Long.valueOf(bs.aNx()));
            paramString = com.tencent.mm.plugin.recordvideo.background.g.wmx;
            com.tencent.mm.plugin.recordvideo.background.g.duu();
          }
        }
      }
      AppMethodBeat.o(75039);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class b
    implements h.b
  {
    public static final b wls;
    
    static
    {
      AppMethodBeat.i(75042);
      wls = new b();
      AppMethodBeat.o(75042);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75041);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.f.wmu;
      localObject = com.tencent.mm.plugin.recordvideo.background.f.cty();
      AppMethodBeat.o(75041);
      return localObject;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements h.b
  {
    public static final c wlt;
    
    static
    {
      AppMethodBeat.i(75044);
      wlt = new c();
      AppMethodBeat.o(75044);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(75043);
      Object localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.woz;
      localObject = com.tencent.mm.plugin.recordvideo.background.provider.a.cty();
      AppMethodBeat.o(75043);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */