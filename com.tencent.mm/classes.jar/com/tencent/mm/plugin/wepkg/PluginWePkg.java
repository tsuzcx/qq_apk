package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.protobuf.GetGameCenterGlobalSettingResponse;
import com.tencent.mm.plugin.game.protobuf.dj;
import com.tencent.mm.plugin.game.protobuf.en;
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
  com.tencent.f.i.d JLv;
  private com.tencent.mm.plugin.wepkg.utils.c JLw;
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(200142);
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
    AppMethodBeat.o(200142);
    return localHashMap;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "PluginWePkg execute");
      com.tencent.mm.plugin.game.commlib.d.a.a(new com.tencent.mm.plugin.game.commlib.d.b()
      {
        public final void awp()
        {
          AppMethodBeat.i(110517);
          com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110516);
              Object localObject1 = b.a.dSQ();
              if (localObject1 != null) {
                MMApplicationContext.getContext();
              }
              for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).dSE();; bool1 = false)
              {
                int i;
                if ((z.aUd() & 0x800000) != 0L)
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
                  if (com.tencent.mm.plugin.game.commlib.a.xvl == null) {
                    break label387;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.xvl.WepkgControl == null) {
                    break label390;
                  }
                  localObject2 = com.tencent.mm.plugin.game.commlib.a.xvl.WepkgControl.xNM;
                  if (Util.isNullOrNil((List)localObject2)) {
                    break label390;
                  }
                  localObject1 = new ArrayList();
                  localObject2 = ((List)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (dj)((Iterator)localObject2).next();
                    if ((localObject3 != null) && (!Util.isNullOrNil(((dj)localObject3).xJD))) {
                      ((List)localObject1).add(((dj)localObject3).xJD);
                    }
                  }
                  i = 0;
                  break;
                }
                for (;;)
                {
                  localObject3 = com.tencent.mm.plugin.game.commlib.a.dSW();
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
                  Object localObject4 = com.tencent.mm.plugin.wepkg.b.f.gkF().gkG();
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
                  com.tencent.mm.plugin.game.commlib.a.dSS();
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
    if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.dTf().a("preload_commlib", new PluginWePkg.2(this));
    }
    if (paramg.FY(":lite"))
    {
      Log.i("MicroMsg.WePkg.PluginWePkg", "cpan offline registerService IGameLiteAppOfficeService");
      ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).iw(ToolsProcessIPCService.dkO, c.class.getName());
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110519);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountInitialized");
    this.JLv = com.tencent.f.h.RTc.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200141);
        if (PluginWePkg.this.JLw == null) {
          PluginWePkg.access$002(PluginWePkg.this, new com.tencent.mm.plugin.wepkg.utils.c());
        }
        Object localObject = PluginWePkg.this.JLw;
        Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        EventCenter.instance.addListener(((com.tencent.mm.plugin.wepkg.utils.c)localObject).JOg);
        EventCenter.instance.addListener(((com.tencent.mm.plugin.wepkg.utils.c)localObject).JOf);
        com.tencent.mm.plugin.wepkg.downloader.i.cBn();
        ((com.tencent.mm.plugin.wepkg.utils.c)localObject).appForegroundListener.alive();
        localObject = MMApplicationContext.getContext();
        if (localObject != null) {
          try
          {
            localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
            if (localObject == null)
            {
              Log.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
              AppMethodBeat.o(200141);
              return;
            }
            if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
            {
              Log.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
              ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
            }
            ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
            AppMethodBeat.o(200141);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
          }
        }
        AppMethodBeat.o(200141);
      }
    }, 1000L);
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onAccountRelease");
    if (this.JLv != null) {
      this.JLv.cancel(true);
    }
    if (this.JLw != null)
    {
      com.tencent.mm.plugin.wepkg.utils.c localc = this.JLw;
      Log.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
      EventCenter.instance.removeListener(localc.JOg);
      localc.appForegroundListener.dead();
      EventCenter.instance.removeListener(localc.JOf);
      com.tencent.mm.plugin.wepkg.downloader.i.cBo();
      com.tencent.mm.plugin.wepkg.utils.d.bZm();
      this.JLw = null;
    }
    AppMethodBeat.o(110520);
  }
  
  public void onDataBaseClosed(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(200144);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseClosed");
    com.tencent.mm.plugin.wepkg.utils.b.JOe = false;
    AppMethodBeat.o(200144);
  }
  
  public void onDataBaseOpened(com.tencent.mm.storagebase.h paramh1, com.tencent.mm.storagebase.h paramh2)
  {
    AppMethodBeat.i(200143);
    Log.i("MicroMsg.WePkg.PluginWePkg", "onDataBaseOpened");
    com.tencent.mm.plugin.wepkg.utils.b.JOe = true;
    AppMethodBeat.o(200143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */