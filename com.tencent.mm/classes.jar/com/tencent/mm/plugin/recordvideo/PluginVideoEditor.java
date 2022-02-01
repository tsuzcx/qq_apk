package com.tencent.mm.plugin.recordvideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/IPluginVideoEditor;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreStorageCallbackBucket;", "()V", "appForegroundListener", "com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1;", "videoEditorDataStorage", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getVideoEditorDataStorage", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDataBaseClosed", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "readOnlyDB", "onDataBaseOpened", "plugin-recordvideo_release"})
public final class PluginVideoEditor
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, a
{
  private com.tencent.mm.plugin.recordvideo.background.d xtm;
  private final a xtn;
  
  public PluginVideoEditor()
  {
    AppMethodBeat.i(75051);
    this.xtn = new a();
    AppMethodBeat.o(75051);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(75048);
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    Object localObject = com.tencent.mm.plugin.recordvideo.background.c.xug;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.c.dEI().hashCode()), PluginVideoEditor.b.xto);
    localMap = (Map)localHashMap;
    localObject = com.tencent.mm.plugin.recordvideo.background.provider.b.xwC;
    localMap.put(Integer.valueOf(com.tencent.mm.plugin.recordvideo.background.provider.b.dEI().hashCode()), PluginVideoEditor.c.xtp);
    AppMethodBeat.o(75048);
    return localHashMap;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(75045);
    paramg = com.tencent.mm.media.k.c.hoP;
    paramg = aj.getContext();
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
            ax localax = ax.aQz("mmkv_gl_key");
            i = localax.decodeInt("support_egl_context_client_version", 3);
            ad.i("MicroMsg.GLEnvironmentUtil", "egl support version " + paramg.getGlEsVersion() + "   configurationInfo.reqGlEsVersion : " + paramg.reqGlEsVersion + "   major:" + j + "  curVersion:" + i);
            if ((i >= 3) && (j == 2))
            {
              ad.i("MicroMsg.GLEnvironmentUtil", "markEglVersion2");
              locald = com.tencent.mm.media.k.d.hoU;
              com.tencent.mm.media.k.d.auo();
            }
            if (localax.decodeBool("has_reported_egl_version", false)) {
              break label279;
            }
            ad.i("MicroMsg.GLEnvironmentUtil", "markEglVersion3");
            com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.aup();
            localax.encode("has_reported_egl_version", true);
            break label279;
            localax.encode("support_egl_context_client_version", j);
          }
          if (paramg == null) {
            ad.e("MicroMsg.GLEnvironmentUtil", "configurationInfo == null");
          }
          if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzj, true))
          {
            ax.aQz("mmkv_gl_key").encode("support_egl_context_client_version", 3);
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
  
  public final com.tencent.mm.plugin.recordvideo.background.d getVideoEditorDataStorage()
  {
    AppMethodBeat.i(75050);
    com.tencent.mm.kernel.g.ajA().aiF();
    if (this.xtm == null)
    {
      localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      this.xtm = new com.tencent.mm.plugin.recordvideo.background.d((com.tencent.mm.sdk.e.e)localObject);
    }
    Object localObject = this.xtm;
    if (localObject == null) {
      p.gfZ();
    }
    AppMethodBeat.o(75050);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(75046);
    this.xtn.alive();
    paramc = com.tencent.mm.plugin.recordvideo.background.f.xuv;
    com.tencent.mm.plugin.recordvideo.background.f.dET();
    AppMethodBeat.o(75046);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(75047);
    this.xtn.dead();
    AppMethodBeat.o(75047);
  }
  
  public final void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public final void onDataBaseOpened(h paramh1, h paramh2)
  {
    AppMethodBeat.i(75049);
    if (paramh1 == null) {
      p.gfZ();
    }
    this.xtm = new com.tencent.mm.plugin.recordvideo.background.d((com.tencent.mm.sdk.e.e)paramh1);
    AppMethodBeat.o(75049);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/PluginVideoEditor$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-recordvideo_release"})
  public static final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(75040);
      if (com.tencent.mm.kernel.g.ajx())
      {
        paramString = com.tencent.mm.kernel.g.ajA();
        p.g(paramString, "account()");
        if (paramString.aiL()) {
          com.tencent.mm.kernel.a.aiE();
        }
      }
      AppMethodBeat.o(75040);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(75039);
      if (com.tencent.mm.kernel.g.ajx())
      {
        paramString = com.tencent.mm.kernel.g.ajA();
        p.g(paramString, "account()");
        if ((paramString.aiL()) && (!com.tencent.mm.kernel.a.aiE()))
        {
          paramString = com.tencent.mm.kernel.g.ajC();
          p.g(paramString, "storage()");
          paramString = paramString.ajl().get(al.a.IGc, Long.valueOf(0L));
          if (paramString == null)
          {
            paramString = new v("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(75039);
            throw paramString;
          }
          if (bt.rM(bt.g((Long)paramString)) > 86400L)
          {
            paramString = com.tencent.mm.kernel.g.ajC();
            p.g(paramString, "storage()");
            paramString.ajl().set(al.a.IGc, Long.valueOf(bt.aQJ()));
            paramString = com.tencent.mm.plugin.recordvideo.background.e.xuo;
            com.tencent.mm.plugin.recordvideo.background.e.dEQ();
          }
        }
      }
      AppMethodBeat.o(75039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.PluginVideoEditor
 * JD-Core Version:    0.7.0.1
 */