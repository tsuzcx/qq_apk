package com.tencent.mm.plugin.wepkg.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.ach;
import com.tencent.mm.f.a.ach.a;
import com.tencent.mm.f.a.ux;
import com.tencent.mm.f.a.ux.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.model.k;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c
{
  public IListener QNy;
  public final IListener QNz;
  public o.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(110787);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!b.aGE())
          {
            paramAnonymousString = new ach();
            paramAnonymousString.gcw.fvK = 3;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110787);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(110786);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!b.aGE())
          {
            paramAnonymousString = new ach();
            paramAnonymousString.gcw.fvK = 5;
            EventCenter.instance.publish(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110786);
      }
    };
    this.QNy = new IListener()
    {
      private boolean a(ux paramAnonymousux)
      {
        AppMethodBeat.i(110788);
        boolean bool = paramAnonymousux.fUl.fHD;
        Log.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) && (Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.Vra, Long.valueOf(0L)))) > 60L))
        {
          h.aHG().aHp().set(ar.a.Vra, Long.valueOf(Util.nowSecond()));
          c.a(c.this, 2);
        }
        AppMethodBeat.o(110788);
        return false;
      }
    };
    this.QNz = new IListener()
    {
      private boolean a(ach paramAnonymousach)
      {
        AppMethodBeat.i(110791);
        boolean bool = com.tencent.mm.plugin.game.commlib.a.ewd();
        Log.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymousach.gcw.fvK) });
        int i;
        switch (paramAnonymousach.gcw.fvK)
        {
        default: 
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          for (;;)
          {
            AppMethodBeat.o(110791);
            return false;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            com.tencent.mm.plugin.game.commlib.c.a.ewo().a("wepkg_download_retry", new a.a()
            {
              public final void cPQ()
              {
                AppMethodBeat.i(194101);
                d.cMC().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(194360);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).Vh = 2003;
                    if (MMApplicationContext.isMMProcess()) {
                      ((WepkgCrossProcessTask)localObject).RW();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).QMA;
                      if ((localObject != null) && (!Util.isNullOrNil(((WepkgVersion)localObject).jTB))) {
                        k.heN().dk(((WepkgVersion)localObject).jTB, true);
                      }
                      AppMethodBeat.o(194360);
                      return;
                      ((WepkgCrossProcessTask)localObject).bPu();
                    }
                  }
                });
                AppMethodBeat.o(194101);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymousach.gcw.gcx;
            i = paramAnonymousach.gcw.gcA;
            int j = paramAnonymousach.gcw.gcB;
            paramAnonymousach = new HashSet();
            if (!Util.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label206;
              }
              paramAnonymousach.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymousach, 1, i, false);
              break;
              if ((j == 1) && (j.boG((String)localObject) != null)) {
                paramAnonymousach.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymousach.gcw;
            com.tencent.mm.plugin.wepkg.b.f localf = com.tencent.mm.plugin.wepkg.b.f.hew();
            paramAnonymousach = paramAnonymousach.gcw.gcx;
            if ((!localf.omY) || (Util.isNullOrNil(paramAnonymousach))) {
              bool = false;
            }
            for (;;)
            {
              ((ach.a)localObject).gcy = bool;
              break;
              paramAnonymousach = localf.bom(paramAnonymousach);
              if ((paramAnonymousach != null) && (paramAnonymousach.field_bigPackageReady) && (paramAnonymousach.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (MMApplicationContext.isMMProcess())
            {
              com.tencent.mm.plugin.wepkg.model.c.heF().heG();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = j.boH(paramAnonymousach.gcw.gcx);
              if (localObject != null)
              {
                paramAnonymousach.gcw.gcz = ((WepkgVersion)localObject).QNr;
                Log.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymousach.gcw.gcz) });
              }
            }
          }
        case 5: 
          label206:
          if (bool)
          {
            AppMethodBeat.o(110791);
            return false;
          }
          if (Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.VqZ, Long.valueOf(0L)))) > 60L) {
            h.aHG().aHp().set(ar.a.VqZ, Long.valueOf(Util.nowSecond()));
          }
          break;
        }
        for (bool = c.a(c.this, 1); (!bool) && (Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().get(ar.a.VqY, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          h.aHG().aHp().set(ar.a.VqY, Long.valueOf(Util.nowSecond()));
          paramAnonymousach = new ach();
          paramAnonymousach.gcw.fvK = 0;
          EventCenter.instance.publish(paramAnonymousach);
          break;
          if (Util.isNullOrNil(paramAnonymousach.gcw.gcx))
          {
            paramAnonymousach = com.tencent.mm.plugin.wepkg.model.c.heF();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.cMC().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymousach));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.aK(null, 0, 7);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.heF().aJ(paramAnonymousach.gcw.gcx, 2, 7);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymousach.gcw.scene;
          paramAnonymousach = paramAnonymousach.gcw.gcC;
          if (Util.isNullOrNil(paramAnonymousach)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.G(paramAnonymousach, 4);
            break;
          case 1: 
            WepkgVersionUpdater.G(paramAnonymousach, 3);
            break;
          }
        }
      }
    };
    AppMethodBeat.o(110795);
  }
  
  public static void heR()
  {
    AppMethodBeat.i(194467);
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(194467);
      return;
    }
    try
    {
      localObject = ((Context)localObject).getSharedPreferences("we_pkg_sp", 4);
      if (localObject == null)
      {
        Log.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
        AppMethodBeat.o(194467);
        return;
      }
      if (((SharedPreferences)localObject).getBoolean("disable_we_pkg", false))
      {
        Log.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
        ((SharedPreferences)localObject).edit().putBoolean("disable_we_pkg", false).commit();
      }
      ((SharedPreferences)localObject).edit().putInt("white_screen_times", 0).commit();
      AppMethodBeat.o(194467);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Wepkg.WepkgListener", localException.getMessage());
      AppMethodBeat.o(194467);
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d
  {
    public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.f paramf)
    {
      AppMethodBeat.i(110794);
      com.tencent.mm.plugin.wepkg.e.hel();
      AppMethodBeat.o(110794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */