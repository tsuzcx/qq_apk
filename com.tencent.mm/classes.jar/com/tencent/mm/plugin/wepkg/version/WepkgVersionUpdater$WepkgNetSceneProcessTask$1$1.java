package com.tencent.mm.plugin.wepkg.version;

import com.tencent.mm.h.a.hl;
import com.tencent.mm.h.a.hl.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ReloadNotify;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.f.8;
import com.tencent.mm.plugin.wepkg.model.f.9;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.clb;
import com.tencent.mm.protocal.c.clc;
import com.tencent.mm.protocal.c.clf;
import com.tencent.mm.protocal.c.clh;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class WepkgVersionUpdater$WepkgNetSceneProcessTask$1$1
  implements Runnable
{
  WepkgVersionUpdater$WepkgNetSceneProcessTask$1$1(WepkgVersionUpdater.WepkgNetSceneProcessTask.1 param1, qf paramqf) {}
  
  public final void run()
  {
    Object localObject3 = this.rQy;
    int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(this.rQz.rQx);
    boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(this.rQz.rQx);
    if (localObject3 != null)
    {
      if (bk.dk(((qf)localObject3).sNT)) {
        y.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
      }
    }
    else {
      return;
    }
    Object localObject1 = new HashSet();
    Object localObject2 = new ArrayList();
    localObject3 = ((qf)localObject3).sNT.iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (bet)((Iterator)localObject3).next();
      if (localObject4 != null)
      {
        localObject5 = ((bet)localObject4).kSE;
        Object localObject6 = ((bet)localObject4).tzD;
        clb localclb = ((bet)localObject4).tzF;
        if (!bk.bl((String)localObject5))
        {
          if (localclb != null)
          {
            if (localclb.tYq)
            {
              y.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
              y.i("MicroMsg.Wepkg.WepkgManager", "sync clear wepkg info, pkgid:%s", new Object[] { localObject5 });
              com.tencent.mm.plugin.wepkg.b.d.cjN().US((String)localObject5);
              com.tencent.mm.plugin.wepkg.b.b.cjM().US((String)localObject5);
              e.Vh(com.tencent.mm.plugin.wepkg.utils.d.Vp((String)localObject5));
              h.nFQ.a(859L, 17L, 1L, false);
              ReloadNotify.qh((String)localObject5);
            }
            if (localclb.tYp)
            {
              e.Vf((String)localObject5);
              continue;
            }
          }
          if ((localObject6 != null) && (((clf)localObject6).tYx != null))
          {
            if (bk.bl(((clf)localObject6).tYx.tYr))
            {
              localObject4 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject4).uC = 2004;
              ((WepkgCrossProcessTask)localObject4).rPj.dCD = ((String)localObject5);
              if (ae.cqV()) {
                com.tencent.mm.plugin.wepkg.utils.d.DS().O(new f.8((WepkgCrossProcessTask)localObject4));
              }
              for (;;)
              {
                h.nFQ.a(859L, 18L, 1L, false);
                break;
                ((WepkgCrossProcessTask)localObject4).gfD = new f.9((WepkgCrossProcessTask)localObject4);
                ((WepkgCrossProcessTask)localObject4).ahC();
                WepkgMainProcessService.a((WepkgMainProcessTask)localObject4);
              }
            }
            boolean bool2 = ((clf)localObject6).tYx.tYs;
            long l1 = ((clf)localObject6).tYx.tYt;
            long l2 = ((clf)localObject6).tYx.tYu;
            localObject6 = new WepkgCrossProcessTask();
            ((WepkgCrossProcessTask)localObject6).uC = 3004;
            ((WepkgCrossProcessTask)localObject6).rPj.dCD = ((String)localObject5);
            ((WepkgCrossProcessTask)localObject6).rPj.rPS = bool2;
            ((WepkgCrossProcessTask)localObject6).rPj.rPT = l1;
            ((WepkgCrossProcessTask)localObject6).rPj.rPU = l2;
            if (ae.cqV())
            {
              ((WepkgCrossProcessTask)localObject6).Zu();
              label452:
              localObject6 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject6).uC = 3009;
              ((WepkgCrossProcessTask)localObject6).rPj.dCD = ((String)localObject5);
              if (!ae.cqV()) {
                break label579;
              }
              ((WepkgCrossProcessTask)localObject6).Zu();
              label490:
              localObject6 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject6).uC = 4006;
              ((WepkgCrossProcessTask)localObject6).rPl.dCD = ((String)localObject5);
              if (!ae.cqV()) {
                break label588;
              }
              ((WepkgCrossProcessTask)localObject6).Zu();
            }
            for (;;)
            {
              if (bool1)
              {
                localObject5 = e.a((bet)localObject4);
                if (!bk.dk((List)localObject5)) {
                  ((Set)localObject1).addAll((Collection)localObject5);
                }
              }
              ((List)localObject2).add(localObject4);
              break;
              WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
              break label452;
              label579:
              WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
              break label490;
              label588:
              WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
            }
          }
        }
      }
    }
    a.a.ckb().j((Set)localObject1);
    if (!bk.dk((List)localObject2))
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bet)((Iterator)localObject1).next();
        localObject3 = g.cka();
        if ((localObject2 == null) || (((bet)localObject2).tzE == null))
        {
          y.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
          if (localObject2 != null) {
            ((g)localObject3).bw(((bet)localObject2).kSE, false);
          }
        }
        else
        {
          localObject4 = ((bet)localObject2).tzE.tYB;
          localObject5 = ((bet)localObject2).tzE.tYC;
          if ((localObject4 == null) && (localObject5 == null))
          {
            y.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
            e.Vf(((bet)localObject2).kSE);
          }
          else
          {
            f.a((bet)localObject2, i);
            y.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
            switch (i)
            {
            default: 
              break;
            case -1: 
            case 0: 
              ((g)localObject3).bw(((bet)localObject2).kSE, false);
              break;
            case 1: 
              if (com.tencent.mm.plugin.wepkg.utils.d.dR(ae.getContext())) {
                ((g)localObject3).bw(((bet)localObject2).kSE, false);
              }
              break;
            case 2: 
              localObject4 = new hl();
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
              if (((hl)localObject4).bPq.bPr) {
                ((g)localObject3).bw(((bet)localObject2).kSE, false);
              }
              break;
            }
          }
        }
      }
    }
    ReloadNotify.cjW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1
 * JD-Core Version:    0.7.0.1
 */