package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.do;
import com.tencent.mm.plugin.game.protobuf.et;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PluginWePkg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.bucket.d, com.tencent.mm.plugin.wepkg.a.a
{
  com.tencent.threadpool.i.d XEn;
  private com.tencent.mm.plugin.wepkg.utils.c XEo;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(278667);
    Log.i("MicroMsg.WePkg.PluginWePkg", "collectDatabaseFactory");
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.f.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.d.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("WEPKG_DIFF_PACK".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.wepkg.b.b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(278667);
    return localHashMap;
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new com.tencent.mm.plugin.game.commlib.d.b()
      {
        public final void cwC()
        {
          AppMethodBeat.i(110517);
          com.tencent.mm.plugin.wepkg.utils.d.dqg().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110516);
              Object localObject1 = b.a.fCn();
              if (localObject1 != null) {
                MMApplicationContext.getContext();
              }
              for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).fBZ();; bool1 = false)
              {
                int i;
                if ((z.bAR() & 0x800000) != 0L)
                {
                  i = 1;
                  if (i != 0) {
                    break label191;
                  }
                }
                Object localObject2;
                Object localObject3;
                label191:
                for (boolean bool2 = true;; bool2 = false)
                {
                  Log.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  if ((!bool1) || (i != 0)) {
                    break label381;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.IsN == null) {
                    break label387;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.IsN.WepkgControl == null) {
                    break label390;
                  }
                  localObject2 = com.tencent.mm.plugin.game.commlib.a.IsN.WepkgControl.IMm;
                  if (Util.isNullOrNil((List)localObject2)) {
                    break label390;
                  }
                  localObject1 = new ArrayList();
                  localObject2 = ((List)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (do)((Iterator)localObject2).next();
                    if ((localObject3 != null) && (!Util.isNullOrNil(((do)localObject3).IHV))) {
                      ((List)localObject1).add(((do)localObject3).IHV);
                    }
                  }
                  i = 0;
                  break;
                }
                for (;;)
                {
                  localObject3 = com.tencent.mm.plugin.game.commlib.a.fDU();
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = new ArrayList();
                  }
                  Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = new ArrayList();
                  }
                  Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
                  Object localObject4 = com.tencent.mm.plugin.wepkg.b.f.iFe().iFf();
                  localObject3 = localObject4;
                  if (localObject4 == null) {
                    localObject3 = new ArrayList();
                  }
                  Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
                  localObject4 = new HashSet();
                  ((Set)localObject4).addAll((Collection)localObject3);
                  ((Set)localObject4).retainAll((Collection)localObject1);
                  ((Set)localObject4).addAll((Collection)localObject2);
                  WepkgVersionUpdater.a((Set)localObject4, 2, true);
                  label381:
                  AppMethodBeat.o(110516);
                  return;
                  label387:
                  com.tencent.mm.plugin.game.commlib.a.fDQ();
                  label390:
                  localObject1 = null;
                }
              }
            }
          });
          AppMethodBeat.o(110517);
        }
      });
    }
    if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.fEf().a("preload_commlib", new a.a()
      {
        public final void dun()
        {
          AppMethodBeat.i(278652);
          try
          {
            e.dvc();
            b.Td();
            AppMethodBeat.o(278652);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 19L, 1L, false);
            AppMethodBeat.o(278652);
          }
        }
      });
    }
    if (paramg.FH(":lite"))
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "cpan offline registerService IGameLiteAppOfficeService");
      ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).jS(ToolsProcessIPCService.PROCESS_NAME, c.class.getName());
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(110519);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.XEn = com.tencent.threadpool.h.ahAA.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278650);
        if (PluginWePkg.this.XEo == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        com.tencent.mm.plugin.wepkg.utils.c localc = PluginWePkg.this.XEo;
        Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        localc.XGX.alive();
        localc.XGW.alive();
        com.tencent.mm.plugin.wepkg.downloader.i.duo();
        localc.appForegroundListener.alive();
        com.tencent.mm.plugin.wepkg.utils.c.iFz();
        AppMethodBeat.o(278650);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.XEn != null) {
      this.XEn.cancel(true);
    }
    if (this.XEo != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.XEo;
      Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      localc.XGX.dead();
      localc.appForegroundListener.dead();
      localc.XGW.dead();
      com.tencent.mm.plugin.wepkg.downloader.i.cuD();
      com.tencent.mm.plugin.wepkg.utils.d.cNl();
      this.XEo = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(278670);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    com.tencent.mm.plugin.wepkg.utils.b.XGV = false;
    AppMethodBeat.o(278670);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(278669);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    com.tencent.mm.plugin.wepkg.utils.b.XGV = true;
    AppMethodBeat.o(278669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */