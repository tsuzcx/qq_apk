package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.g.a.zs.a;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c
{
  public com.tencent.mm.sdk.b.c EYp;
  public final com.tencent.mm.sdk.b.c EYq;
  public o.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new c.1(this);
    this.EYp = new c.2(this);
    this.EYq = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(zs paramAnonymouszs)
      {
        AppMethodBeat.i(110791);
        if (ak.cpe())
        {
          bool = com.tencent.mm.n.g.acM().acz();
          ae.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymouszs.dQc.dlO) });
        }
        int i;
        switch (paramAnonymouszs.dQc.dlO)
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
            bool = b.EYn;
            break;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            com.tencent.mm.plugin.game.commlib.c.a.cZE().a("wepkg_download_retry", new a.a()
            {
              public final void cdr()
              {
                AppMethodBeat.i(209402);
                d.caq().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(209401);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).EN = 2003;
                    if (ak.cpe()) {
                      ((WepkgCrossProcessTask)localObject).aOX();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).EXp;
                      if ((localObject != null) && (!bu.isNullOrNil(((WepkgVersion)localObject).guO))) {
                        j.fbO().cB(((WepkgVersion)localObject).guO, true);
                      }
                      AppMethodBeat.o(209401);
                      return;
                      AppBrandMainProcessService.b((MainProcessTask)localObject);
                    }
                  }
                });
                AppMethodBeat.o(209402);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymouszs.dQc.dQd;
            i = paramAnonymouszs.dQc.dQg;
            int j = paramAnonymouszs.dQc.dQh;
            paramAnonymouszs = new HashSet();
            if (!bu.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label222;
              }
              paramAnonymouszs.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymouszs, 1, i, false);
              break;
              if ((j == 1) && (i.aMn((String)localObject) != null)) {
                paramAnonymouszs.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymouszs.dQc;
            f localf = f.fbz();
            paramAnonymouszs = paramAnonymouszs.dQc.dQd;
            if ((!localf.kot) || (bu.isNullOrNil(paramAnonymouszs))) {
              bool = false;
            }
            for (;;)
            {
              ((zs.a)localObject).dQe = bool;
              break;
              paramAnonymouszs = localf.aLU(paramAnonymouszs);
              if ((paramAnonymouszs != null) && (paramAnonymouszs.field_bigPackageReady) && (paramAnonymouszs.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (ak.cpe())
            {
              com.tencent.mm.plugin.wepkg.model.c.fbI().fbJ();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = i.aMo(paramAnonymouszs.dQc.dQd);
              if (localObject != null)
              {
                paramAnonymouszs.dQc.dQf = ((WepkgVersion)localObject).EYh;
                ae.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymouszs.dQc.dQf) });
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
          if (bu.rZ(bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUE, Long.valueOf(0L)))) > 60L) {
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUE, Long.valueOf(bu.aRi()));
          }
          break;
        }
        for (boolean bool = c.a(c.this, 1); (!bool) && (bu.rZ(bu.i((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IUD, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IUD, Long.valueOf(bu.aRi()));
          paramAnonymouszs = new zs();
          paramAnonymouszs.dQc.dlO = 0;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymouszs);
          break;
          if (bu.isNullOrNil(paramAnonymouszs.dQc.dQd))
          {
            paramAnonymouszs = com.tencent.mm.plugin.wepkg.model.c.fbI();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.caq().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymouszs));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.aG(null, 0, 7);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.fbI().aF(paramAnonymouszs.dQc.dQd, 2, 7);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymouszs.dQc.scene;
          paramAnonymouszs = paramAnonymouszs.dQc.dQi;
          if (bu.ht(paramAnonymouszs)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.z(paramAnonymouszs, 4);
            break;
          case 1: 
            WepkgVersionUpdater.z(paramAnonymouszs, 3);
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