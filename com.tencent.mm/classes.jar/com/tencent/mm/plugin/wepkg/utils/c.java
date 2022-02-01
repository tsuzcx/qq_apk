package com.tencent.mm.plugin.wepkg.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.g.a.rz.a;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.a;
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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class c
{
  public com.tencent.mm.sdk.b.c BJK;
  public final com.tencent.mm.sdk.b.c BJL;
  public n.a appForegroundListener;
  
  public c()
  {
    AppMethodBeat.i(110795);
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(110787);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new yh();
            paramAnonymousString.dEN.dbV = 3;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110787);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(110786);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC())
          {
            paramAnonymousString = new yh();
            paramAnonymousString.dEN.dbV = 5;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousString);
          }
        }
        AppMethodBeat.o(110786);
      }
    };
    this.BJK = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(rz paramAnonymousrz)
      {
        AppMethodBeat.i(110788);
        boolean bool = paramAnonymousrz.dxH.dml;
        ad.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[] { Boolean.valueOf(bool) });
        if ((bool) && (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FpZ, Long.valueOf(0L)))) > 60L))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpZ, Long.valueOf(bt.aGK()));
          c.a(c.this, 2);
        }
        AppMethodBeat.o(110788);
        return false;
      }
    };
    this.BJL = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(yh paramAnonymousyh)
      {
        AppMethodBeat.i(110791);
        if (aj.cbv())
        {
          bool = com.tencent.mm.m.g.Ze().YQ();
          ad.d("MicroMsg.Wepkg.WepkgListener", "wepkg notify event operation:%d", new Object[] { Integer.valueOf(paramAnonymousyh.dEN.dbV) });
        }
        int i;
        switch (paramAnonymousyh.dEN.dbV)
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
            bool = b.BJJ;
            break;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            com.tencent.mm.plugin.game.commlib.c.a.cBs().a("wepkg_download_retry", new a.a()
            {
              public final void bQi()
              {
                AppMethodBeat.i(192628);
                d.bNl().postToWorker(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(192627);
                    Object localObject = new WepkgCrossProcessTask();
                    ((WepkgCrossProcessTask)localObject).BX = 2003;
                    if (aj.cbv()) {
                      ((WepkgCrossProcessTask)localObject).aEz();
                    }
                    for (;;)
                    {
                      localObject = ((WepkgCrossProcessTask)localObject).BIL;
                      if ((localObject != null) && (!bt.isNullOrNil(((WepkgVersion)localObject).fUW))) {
                        j.etP().cm(((WepkgVersion)localObject).fUW, true);
                      }
                      AppMethodBeat.o(192627);
                      return;
                      AppBrandMainProcessService.b((MainProcessTask)localObject);
                    }
                  }
                });
                AppMethodBeat.o(192628);
              }
            });
            continue;
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            Object localObject = paramAnonymousyh.dEN.dEO;
            i = paramAnonymousyh.dEN.dER;
            int j = paramAnonymousyh.dEN.dES;
            paramAnonymousyh = new HashSet();
            if (!bt.isNullOrNil((String)localObject))
            {
              if (j != 0) {
                break label222;
              }
              paramAnonymousyh.add(localObject);
            }
            for (;;)
            {
              WepkgVersionUpdater.a(paramAnonymousyh, 1, i, false);
              break;
              if ((j == 1) && (i.azZ((String)localObject) != null)) {
                paramAnonymousyh.add(localObject);
              }
            }
            if (bool)
            {
              AppMethodBeat.o(110791);
              return false;
            }
            localObject = paramAnonymousyh.dEN;
            f localf = f.etA();
            paramAnonymousyh = paramAnonymousyh.dEN.dEO;
            if ((!localf.jqw) || (bt.isNullOrNil(paramAnonymousyh))) {
              bool = false;
            }
            for (;;)
            {
              ((yh.a)localObject).dEP = bool;
              break;
              paramAnonymousyh = localf.azH(paramAnonymousyh);
              if ((paramAnonymousyh != null) && (paramAnonymousyh.field_bigPackageReady) && (paramAnonymousyh.field_preloadFilesReady)) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (aj.cbv())
            {
              com.tencent.mm.plugin.wepkg.model.c.etK().etL();
              continue;
              if (bool)
              {
                AppMethodBeat.o(110791);
                return false;
              }
              localObject = i.aAa(paramAnonymousyh.dEN.dEO);
              if (localObject != null)
              {
                paramAnonymousyh.dEN.dEQ = ((WepkgVersion)localObject).BJD;
                ad.i("MicroMsg.Wepkg.WepkgListener", "total download count:%s", new Object[] { Integer.valueOf(paramAnonymousyh.dEN.dEQ) });
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
          if (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FpY, Long.valueOf(0L)))) > 60L) {
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpY, Long.valueOf(bt.aGK()));
          }
          break;
        }
        for (boolean bool = c.a(c.this, 1); (!bool) && (bt.lZ(bt.f((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FpX, Long.valueOf(0L)))) > 1800L); bool = false)
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FpX, Long.valueOf(bt.aGK()));
          paramAnonymousyh = new yh();
          paramAnonymousyh.dEN.dbV = 0;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousyh);
          break;
          if (bt.isNullOrNil(paramAnonymousyh.dEN.dEO))
          {
            paramAnonymousyh = com.tencent.mm.plugin.wepkg.model.c.etK();
            if (Looper.getMainLooper() == Looper.myLooper())
            {
              d.bNl().postToWorker(new com.tencent.mm.plugin.wepkg.model.c.2(paramAnonymousyh));
              break;
            }
            com.tencent.mm.plugin.wepkg.model.c.fo(null, 0);
            break;
          }
          com.tencent.mm.plugin.wepkg.model.c.etK().fn(paramAnonymousyh.dEN.dEO, 2);
          break;
          ToolsProcessIPCService.a(null, c.a.class, null);
          break;
          i = paramAnonymousyh.dEN.scene;
          paramAnonymousyh = paramAnonymousyh.dEN.dET;
          if (bt.gL(paramAnonymousyh)) {
            break;
          }
          switch (i)
          {
          default: 
            break;
          case 0: 
            WepkgVersionUpdater.w(paramAnonymousyh, 4);
            break;
          case 1: 
            WepkgVersionUpdater.w(paramAnonymousyh, 3);
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
      com.tencent.mm.plugin.wepkg.b.etq();
      AppMethodBeat.o(110794);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.utils.c
 * JD-Core Version:    0.7.0.1
 */