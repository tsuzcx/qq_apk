package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.zm;
import com.tencent.mm.g.a.zm.a;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c
{
  public com.tencent.mm.sdk.b.c EFT;
  public final com.tencent.mm.sdk.b.c EFU;
  public n.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new c.1(this);
    this.EFT = new c.2(this);
    this.EFU = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(zm paramAnonymouszm)
      {
        AppMethodBeat.i(110791);
        if (aj.cnC())
        {
          bool = com.tencent.mm.n.g.acB().aco();
          ad.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymouszm.dOM.dkM) });
        }
        int i;
        switch (paramAnonymouszm.dOM.dkM)
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
            bool = b.EFR;
            break;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            com.tencent.mm.plugin.game.commlib.c.a.cWX().a("wepkg_download_retry", new a.a()
            {
              public final void ccc()
              {
                AppMethodBeat.i(214474);
                d.bZb().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(214473);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).EN = 2003;
                    if (aj.cnC()) {
                      ((WepkgCrossProcessTask)localObject).aOA();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).EET;
                      if ((localObject != null) && (!bt.isNullOrNil(((WepkgVersion)localObject).gsn))) {
                        j.eYc().cx(((WepkgVersion)localObject).gsn, true);
                      }
                      AppMethodBeat.o(214473);
                      return;
                      AppBrandMainProcessService.b((MainProcessTask)localObject);
                    }
                  }
                });
                AppMethodBeat.o(214474);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymouszm.dOM.dON;
            i = paramAnonymouszm.dOM.dOQ;
            int j = paramAnonymouszm.dOM.dOR;
            paramAnonymouszm = new HashSet();
            if (!bt.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label222;
              }
              paramAnonymouszm.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymouszm, 1, i, false);
              break;
              if ((j == 1) && (i.aKR((String)localObject) != null)) {
                paramAnonymouszm.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymouszm.dOM;
            f localf = f.eXN();
            paramAnonymouszm = paramAnonymouszm.dOM.dON;
            if ((!localf.kld) || (bt.isNullOrNil(paramAnonymouszm))) {
              bool = false;
            }
            for (;;)
            {
              ((zm.a)localObject).dOO = bool;
              break;
              paramAnonymouszm = localf.aKy(paramAnonymouszm);
              if ((paramAnonymouszm != null) && (paramAnonymouszm.field_bigPackageReady) && (paramAnonymouszm.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (aj.cnC())
            {
              com.tencent.mm.plugin.wepkg.model.c.eXW().eXX();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = i.aKS(paramAnonymouszm.dOM.dON);
              if (localObject != null)
              {
                paramAnonymouszm.dOM.dOP = ((WepkgVersion)localObject).EFL;
                ad.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymouszm.dOM.dOP) });
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
          if (bt.rM(bt.g((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAf, Long.valueOf(0L)))) > 60L) {
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAf, Long.valueOf(bt.aQJ()));
          }
          break;
        }
        for (boolean bool = c.a(c.this, 1); (!bool) && (bt.rM(bt.g((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IAe, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IAe, Long.valueOf(bt.aQJ()));
          paramAnonymouszm = new zm();
          paramAnonymouszm.dOM.dkM = 0;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymouszm);
          break;
          if (bt.isNullOrNil(paramAnonymouszm.dOM.dON))
          {
            paramAnonymouszm = com.tencent.mm.plugin.wepkg.model.c.eXW();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.bZb().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymouszm));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.aE(null, 0, 7);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.eXW().aD(paramAnonymouszm.dOM.dON, 2, 7);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymouszm.dOM.scene;
          paramAnonymouszm = paramAnonymouszm.dOM.dOS;
          if (bt.hj(paramAnonymouszm)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.y(paramAnonymouszm, 4);
            break;
          case 1: 
            WepkgVersionUpdater.y(paramAnonymouszm, 3);
            break;
          }
        }
      }
    };
    AppMethodBeat.o(110795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */