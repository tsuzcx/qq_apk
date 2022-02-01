package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.si;
import com.tencent.mm.g.a.si.a;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.a.ys.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c
{
  public com.tencent.mm.sdk.b.c DbT;
  public final com.tencent.mm.sdk.b.c DbU;
  public n.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(110787);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new ys();
            paramAnonymousString.dCz.cZu = 3;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110787);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(110786);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS())
          {
            paramAnonymousString = new ys();
            paramAnonymousString.dCz.cZu = 5;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110786);
      }
    };
    this.DbT = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(si paramAnonymoussi)
      {
        AppMethodBeat.i(110788);
        boolean bool = paramAnonymoussi.dvt.djT;
        ac.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) && (bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNP, Long.valueOf(0L)))) > 60L))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNP, Long.valueOf(bs.aNx()));
          c.a(c.this, 2);
        }
        AppMethodBeat.o(110788);
        return false;
      }
    };
    this.DbU = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(ys paramAnonymousys)
      {
        AppMethodBeat.i(110791);
        if (ai.ciE())
        {
          bool = com.tencent.mm.m.g.ZZ().ZN();
          ac.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymousys.dCz.cZu) });
        }
        int i;
        switch (paramAnonymousys.dCz.cZu)
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
            bool = b.DbS;
            break;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            com.tencent.mm.plugin.game.commlib.c.a.cOB().a("wepkg_download_retry", new a.a()
            {
              public final void bXz()
              {
                AppMethodBeat.i(199885);
                d.bUw().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(199884);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).CW = 2003;
                    if (ai.ciE()) {
                      ((WepkgCrossProcessTask)localObject).aLq();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).DaU;
                      if ((localObject != null) && (!bs.isNullOrNil(((WepkgVersion)localObject).fYR))) {
                        j.eJi().cs(((WepkgVersion)localObject).fYR, true);
                      }
                      AppMethodBeat.o(199884);
                      return;
                      AppBrandMainProcessService.b((MainProcessTask)localObject);
                    }
                  }
                });
                AppMethodBeat.o(199885);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymousys.dCz.dCA;
            i = paramAnonymousys.dCz.dCD;
            int j = paramAnonymousys.dCz.dCE;
            paramAnonymousys = new HashSet();
            if (!bs.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label222;
              }
              paramAnonymousys.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymousys, 1, i, false);
              break;
              if ((j == 1) && (i.aFr((String)localObject) != null)) {
                paramAnonymousys.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymousys.dCz;
            f localf = f.eIT();
            paramAnonymousys = paramAnonymousys.dCz.dCA;
            if ((!localf.jQO) || (bs.isNullOrNil(paramAnonymousys))) {
              bool = false;
            }
            for (;;)
            {
              ((ys.a)localObject).dCB = bool;
              break;
              paramAnonymousys = localf.aEY(paramAnonymousys);
              if ((paramAnonymousys != null) && (paramAnonymousys.field_bigPackageReady) && (paramAnonymousys.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (ai.ciE())
            {
              com.tencent.mm.plugin.wepkg.model.c.eJd().eJe();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = i.aFs(paramAnonymousys.dCz.dCA);
              if (localObject != null)
              {
                paramAnonymousys.dCz.dCC = ((WepkgVersion)localObject).DbM;
                ac.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymousys.dCz.dCC) });
              }
            }
          }
        case 5: 
          label222:
          if (bool)
          {
            AppMethodBeat.o(110791);
            return false;
          }
          if (bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNO, Long.valueOf(0L)))) > 60L) {
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNO, Long.valueOf(bs.aNx()));
          }
          break;
        }
        for (boolean bool = c.a(c.this, 1); (!bool) && (bs.pN(bs.g((Long)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GNN, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GNN, Long.valueOf(bs.aNx()));
          paramAnonymousys = new ys();
          paramAnonymousys.dCz.cZu = 0;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousys);
          break;
          if (bs.isNullOrNil(paramAnonymousys.dCz.dCA))
          {
            paramAnonymousys = com.tencent.mm.plugin.wepkg.model.c.eJd();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.bUw().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymousys));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.aA(null, 0, 7);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.eJd().az(paramAnonymousys.dCz.dCA, 2, 7);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymousys.dCz.scene;
          paramAnonymousys = paramAnonymousys.dCz.dCF;
          if (bs.gY(paramAnonymousys)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.w(paramAnonymousys, 4);
            break;
          case 1: 
            WepkgVersionUpdater.w(paramAnonymousys, 3);
            break;
          }
        }
      }
    };
    AppMethodBeat.o(110795);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b
  {
    public void invoke(Object paramObject, com.tencent.mm.ipcinvoker.d paramd)
    {
      AppMethodBeat.i(110794);
      com.tencent.mm.plugin.wepkg.b.eIJ();
      AppMethodBeat.o(110794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */