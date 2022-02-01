package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.g.a.aaz.a;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tu.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.f;
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

public final class c
{
  public IListener JOf;
  public final IListener JOg;
  public o.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new c.1(this);
    this.JOf = new IListener()
    {
      private boolean a(tu paramAnonymoustu)
      {
        AppMethodBeat.i(110788);
        boolean bool = paramAnonymoustu.eao.dOs;
        Log.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) && (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.OcT, Long.valueOf(0L)))) > 60L))
        {
          g.aAh().azQ().set(ar.a.OcT, Long.valueOf(Util.nowSecond()));
          c.a(c.this, 2);
        }
        AppMethodBeat.o(110788);
        return false;
      }
    };
    this.JOg = new IListener()
    {
      private boolean a(aaz paramAnonymousaaz)
      {
        AppMethodBeat.i(110791);
        boolean bool = com.tencent.mm.plugin.game.commlib.a.dSV();
        Log.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymousaaz.eif.dDe) });
        int i;
        switch (paramAnonymousaaz.eif.dDe)
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
            com.tencent.mm.plugin.game.commlib.c.a.dTf().a("wepkg_download_retry", new a.a()
            {
              public final void cBm()
              {
                AppMethodBeat.i(200177);
                d.cyh().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(200176);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).EX = 2003;
                    if (MMApplicationContext.isMMProcess()) {
                      ((WepkgCrossProcessTask)localObject).bjj();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).JNh;
                      if ((localObject != null) && (!Util.isNullOrNil(((WepkgVersion)localObject).hhD))) {
                        k.gkU().cW(((WepkgVersion)localObject).hhD, true);
                      }
                      AppMethodBeat.o(200176);
                      return;
                      AppBrandMainProcessService.b((MainProcessTask)localObject);
                    }
                  }
                });
                AppMethodBeat.o(200177);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymousaaz.eif.eig;
            i = paramAnonymousaaz.eif.eij;
            int j = paramAnonymousaaz.eif.eik;
            paramAnonymousaaz = new HashSet();
            if (!Util.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label206;
              }
              paramAnonymousaaz.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymousaaz, 1, i, false);
              break;
              if ((j == 1) && (j.bcH((String)localObject) != null)) {
                paramAnonymousaaz.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymousaaz.eif;
            f localf = f.gkF();
            paramAnonymousaaz = paramAnonymousaaz.eif.eig;
            if ((!localf.lsb) || (Util.isNullOrNil(paramAnonymousaaz))) {
              bool = false;
            }
            for (;;)
            {
              ((aaz.a)localObject).eih = bool;
              break;
              paramAnonymousaaz = localf.bcm(paramAnonymousaaz);
              if ((paramAnonymousaaz != null) && (paramAnonymousaaz.field_bigPackageReady) && (paramAnonymousaaz.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (MMApplicationContext.isMMProcess())
            {
              com.tencent.mm.plugin.wepkg.model.c.gkN().gkO();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = j.bcI(paramAnonymousaaz.eif.eig);
              if (localObject != null)
              {
                paramAnonymousaaz.eif.eii = ((WepkgVersion)localObject).JNY;
                Log.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymousaaz.eif.eii) });
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
          if (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.OcS, Long.valueOf(0L)))) > 60L) {
            g.aAh().azQ().set(ar.a.OcS, Long.valueOf(Util.nowSecond()));
          }
          break;
        }
        for (bool = c.a(c.this, 1); (!bool) && (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(ar.a.OcR, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          g.aAh().azQ().set(ar.a.OcR, Long.valueOf(Util.nowSecond()));
          paramAnonymousaaz = new aaz();
          paramAnonymousaaz.eif.dDe = 0;
          EventCenter.instance.publish(paramAnonymousaaz);
          break;
          if (Util.isNullOrNil(paramAnonymousaaz.eif.eig))
          {
            paramAnonymousaaz = com.tencent.mm.plugin.wepkg.model.c.gkN();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.cyh().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymousaaz));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.aI(null, 0, 7);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.gkN().aH(paramAnonymousaaz.eif.eig, 2, 7);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymousaaz.eif.scene;
          paramAnonymousaaz = paramAnonymousaaz.eif.eil;
          if (Util.isNullOrNil(paramAnonymousaaz)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.F(paramAnonymousaaz, 4);
            break;
          case 1: 
            WepkgVersionUpdater.F(paramAnonymousaaz, 3);
            break;
          }
        }
      }
    };
    AppMethodBeat.o(110795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */