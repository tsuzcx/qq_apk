package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.d.dq;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
  com.tencent.e.i.d CZh;
  private com.tencent.mm.plugin.wepkg.utils.c CZi;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(199860);
    ac.i("MicroMsg.WePkg.PluginWePkg", "collectDatabaseFactory");
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
    AppMethodBeat.o(199860);
    return localHashMap;
  }
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.ahL())
    {
      ac.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new com.tencent.mm.plugin.game.commlib.d.b()
      {
        public final void adF()
        {
          AppMethodBeat.i(110517);
          com.tencent.mm.plugin.wepkg.utils.d.bUw().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110516);
              Object localObject1 = b.a.cOr();
              if (localObject1 != null) {
                ai.getContext();
              }
              for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).cOh();; bool1 = false)
              {
                int i;
                if ((u.axB() & 0x800000) != 0L)
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
                  ac.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  if ((!bool1) || (i != 0)) {
                    break label381;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.sWd == null) {
                    break label387;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.sWd.tjE == null) {
                    break label390;
                  }
                  localObject2 = com.tencent.mm.plugin.game.commlib.a.sWd.tjE.tlP;
                  if (bs.gY((List)localObject2)) {
                    break label390;
                  }
                  localObject1 = new ArrayList();
                  localObject2 = ((List)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (cu)((Iterator)localObject2).next();
                    if ((localObject3 != null) && (!bs.isNullOrNil(((cu)localObject3).thZ))) {
                      ((List)localObject1).add(((cu)localObject3).thZ);
                    }
                  }
                  i = 0;
                  break;
                }
                for (;;)
                {
                  localObject3 = com.tencent.mm.plugin.game.commlib.a.cOx();
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = new ArrayList();
                  }
                  ac.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = new ArrayList();
                  }
                  ac.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
                  Object localObject4 = com.tencent.mm.plugin.wepkg.b.f.eIT().eIU();
                  localObject3 = localObject4;
                  if (localObject4 == null) {
                    localObject3 = new ArrayList();
                  }
                  ac.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
                  localObject4 = new HashSet();
                  ((Set)localObject4).addAll((Collection)localObject3);
                  ((Set)localObject4).retainAll((Collection)localObject1);
                  ((Set)localObject4).addAll((Collection)localObject2);
                  WepkgVersionUpdater.a((Set)localObject4, 2, true);
                  label381:
                  AppMethodBeat.o(110516);
                  return;
                  label387:
                  com.tencent.mm.plugin.game.commlib.a.cOt();
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
    if ((paramg.up(":tools")) || (paramg.up(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.cOB().a("preload_commlib", new a.a()
      {
        public final void bXz()
        {
          AppMethodBeat.i(199858);
          try
          {
            b.bYw();
            AppMethodBeat.o(199858);
            return;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(859L, 19L, 1L, false);
            AppMethodBeat.o(199858);
          }
        }
      });
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110519);
    ac.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.CZh = com.tencent.e.h.JZN.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199859);
        if (PluginWePkg.this.CZi == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        Object localObject = PluginWePkg.this.CZi;
        ac.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).DbU);
        com.tencent.mm.sdk.b.a.GpY.c(((com.tencent.mm.plugin.wepkg.utils.c)localObject).DbT);
        com.tencent.mm.plugin.wepkg.downloader.i.bXA();
        ((com.tencent.mm.plugin.wepkg.utils.c)localObject).appForegroundListener.alive();
        localObject = ai.getContext();
        if (localObject != null) {
          try
          {
            localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
            if (localObject == null)
            {
              ac.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
              AppMethodBeat.o(199859);
              return;
            }
            if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
            {
              ac.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
              ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
            }
            ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
            AppMethodBeat.o(199859);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
          }
        }
        AppMethodBeat.o(199859);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    ac.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.CZh != null) {
      this.CZh.cancel(true);
    }
    if (this.CZi != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.CZi;
      ac.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      com.tencent.mm.sdk.b.a.GpY.d(localc.DbU);
      localc.appForegroundListener.dead();
      com.tencent.mm.sdk.b.a.GpY.d(localc.DbT);
      com.tencent.mm.plugin.wepkg.downloader.i.bXB();
      com.tencent.mm.plugin.wepkg.utils.d.bxi();
      this.CZi = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(199862);
    ac.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    AppMethodBeat.o(199862);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(199861);
    ac.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    AppMethodBeat.o(199861);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */