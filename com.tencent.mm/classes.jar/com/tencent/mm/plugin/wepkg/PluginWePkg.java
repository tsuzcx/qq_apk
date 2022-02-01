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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.downloader.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PluginWePkg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.wepkg.a.a
{
  private com.tencent.mm.plugin.wepkg.utils.c BHa;
  
  public void configure(g paramg) {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(110518);
    if (paramg.agu()) {
      com.tencent.mm.plugin.game.commlib.d.a.a(new com.tencent.mm.plugin.game.commlib.d.b()
      {
        public final void acz()
        {
          AppMethodBeat.i(110517);
          d.bNl().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110516);
              Object localObject1 = b.a.cBi();
              if (localObject1 != null) {
                aj.getContext();
              }
              for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).cAY();; bool1 = false)
              {
                int i;
                if ((u.aqL() & 0x800000) != 0L)
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
                  ad.i("MicroMsg.WePkg.PluginWePkg", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                  if ((!bool1) || (i != 0)) {
                    break label381;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.rOm == null) {
                    break label387;
                  }
                  if (com.tencent.mm.plugin.game.commlib.a.rOm.sbK == null) {
                    break label390;
                  }
                  localObject2 = com.tencent.mm.plugin.game.commlib.a.rOm.sbK.sdV;
                  if (bt.gL((List)localObject2)) {
                    break label390;
                  }
                  localObject1 = new ArrayList();
                  localObject2 = ((List)localObject2).iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    localObject3 = (cu)((Iterator)localObject2).next();
                    if ((localObject3 != null) && (!bt.isNullOrNil(((cu)localObject3).sag))) {
                      ((List)localObject1).add(((cu)localObject3).sag);
                    }
                  }
                  i = 0;
                  break;
                }
                for (;;)
                {
                  localObject3 = com.tencent.mm.plugin.game.commlib.a.cBo();
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = new ArrayList();
                  }
                  ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
                  localObject1 = localObject3;
                  if (localObject3 == null) {
                    localObject1 = new ArrayList();
                  }
                  ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", new Object[] { Integer.valueOf(((List)localObject1).size()) });
                  Object localObject4 = com.tencent.mm.plugin.wepkg.b.f.etA().etB();
                  localObject3 = localObject4;
                  if (localObject4 == null) {
                    localObject3 = new ArrayList();
                  }
                  ad.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
                  localObject4 = new HashSet();
                  ((Set)localObject4).addAll((Collection)localObject3);
                  ((Set)localObject4).retainAll((Collection)localObject1);
                  ((Set)localObject4).addAll((Collection)localObject2);
                  WepkgVersionUpdater.a((Set)localObject4, 2, true);
                  label381:
                  AppMethodBeat.o(110516);
                  return;
                  label387:
                  com.tencent.mm.plugin.game.commlib.a.cBk();
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
    if ((paramg.ra(":tools")) || (paramg.ra(":toolsmp"))) {
      com.tencent.mm.plugin.game.commlib.c.a.cBs().a("preload_commlib", new a.a()
      {
        public final void bQi()
        {
          AppMethodBeat.i(192614);
          try
          {
            b.bRh();
            AppMethodBeat.o(192614);
            return;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", localException, "", new Object[0]);
            h.vKh.idkeyStat(859L, 19L, 1L, false);
            AppMethodBeat.o(192614);
          }
        }
      });
    }
    AppMethodBeat.o(110518);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(110519);
    if (this.BHa == null) {
      this.BHa = new com.tencent.mm.plugin.wepkg.utils.c();
    }
    paramc = this.BHa;
    ad.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
    com.tencent.mm.sdk.b.a.ESL.c(paramc.BJL);
    com.tencent.mm.sdk.b.a.ESL.c(paramc.BJK);
    i.bQj();
    paramc.appForegroundListener.alive();
    paramc = aj.getContext();
    if (paramc != null) {
      try
      {
        paramc = paramc.getSharedPreferences("we_pkg_sp", 4);
        if (paramc == null)
        {
          ad.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
          AppMethodBeat.o(110519);
          return;
        }
        if (paramc.getBoolean("disable_we_pkg", false))
        {
          ad.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
          paramc.edit().putBoolean("disable_we_pkg", false).commit();
        }
        paramc.edit().putInt("white_screen_times", 0).commit();
        AppMethodBeat.o(110519);
        return;
      }
      catch (Exception paramc)
      {
        ad.e("MicroMsg.Wepkg.WepkgListener", paramc.getMessage());
      }
    }
    AppMethodBeat.o(110519);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(110520);
    com.tencent.mm.plugin.wepkg.utils.c localc = this.BHa;
    ad.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
    com.tencent.mm.sdk.b.a.ESL.d(localc.BJL);
    localc.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ESL.d(localc.BJK);
    i.bQk();
    d.bql();
    this.BHa = null;
    AppMethodBeat.o(110520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.PluginWePkg
 * JD-Core Version:    0.7.0.1
 */