package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.dk;
import com.tencent.mm.plugin.game.protobuf.eo;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.EventCenter;
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
  com.tencent.e.i.d QKO;
  private com.tencent.mm.plugin.wepkg.utils.c QKP;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(194191);
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
    AppMethodBeat.o(194191);
    return localHashMap;
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new com.tencent.mm.plugin.game.commlib.d.b()
      {
        public final void bWp()
        {
          AppMethodBeat.i(110517);
          com.tencent.mm.plugin.wepkg.utils.d.cMC().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110516);
              Object localObject1 = b.a.evu();
              if (localObject1 != null) {
                MMApplicationContext.getContext();
              }
              for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).evh();; bool1 = false)
              {
                int i;
                if ((z.bde() & 0x800000) != 0L)
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
                  if (com.tencent.mm.plugin.game.commlib.a.Czb == null) {
                    break label387;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.Czb.WepkgControl == null) {
                    break label390;
                  }
                  localObject2 = com.tencent.mm.plugin.game.commlib.a.Czb.WepkgControl.CRW;
                  if (Util.isNullOrNil((List)localObject2)) {
                    break label390;
                  }
                  localObject1 = new ArrayList();
                  localObject2 = ((List)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (dk)((Iterator)localObject2).next();
                    if ((localObject3 != null) && (!Util.isNullOrNil(((dk)localObject3).CNL))) {
                      ((List)localObject1).add(((dk)localObject3).CNL);
                    }
                  }
                  i = 0;
                  break;
                }
                for (;;)
                {
                  localObject3 = com.tencent.mm.plugin.game.commlib.a.ewe();
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
                  Object localObject4 = com.tencent.mm.plugin.wepkg.b.f.hew().hex();
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
                  com.tencent.mm.plugin.game.commlib.a.ewa();
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
    if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.ewo().a("preload_commlib", new a.a()
      {
        public final void cPQ()
        {
          AppMethodBeat.i(194505);
          try
          {
            e.cQJ();
            b.tA();
            AppMethodBeat.o(194505);
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(859L, 19L, 1L, false);
            AppMethodBeat.o(194505);
          }
        }
      });
    }
    if (paramg.MY(":lite"))
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "cpan offline registerService IGameLiteAppOfficeService");
      ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.lite.a.a.class)).iI(ToolsProcessIPCService.PROCESS_NAME, c.class.getName());
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(110519);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.QKO = com.tencent.e.h.ZvG.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194591);
        if (PluginWePkg.this.QKP == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        com.tencent.mm.plugin.wepkg.utils.c localc = PluginWePkg.this.QKP;
        Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        EventCenter.instance.addListener(localc.QNz);
        EventCenter.instance.addListener(localc.QNy);
        com.tencent.mm.plugin.wepkg.downloader.i.cPR();
        localc.appForegroundListener.alive();
        com.tencent.mm.plugin.wepkg.utils.c.heR();
        AppMethodBeat.o(194591);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.QKO != null) {
      this.QKO.cancel(true);
    }
    if (this.QKP != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.QKP;
      Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      EventCenter.instance.removeListener(localc.QNz);
      localc.appForegroundListener.dead();
      EventCenter.instance.removeListener(localc.QNy);
      com.tencent.mm.plugin.wepkg.downloader.i.cPS();
      com.tencent.mm.plugin.wepkg.utils.d.clU();
      this.QKP = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(194197);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    com.tencent.mm.plugin.wepkg.utils.b.QNx = false;
    AppMethodBeat.o(194197);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(194196);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    com.tencent.mm.plugin.wepkg.utils.b.QNx = true;
    AppMethodBeat.o(194196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */