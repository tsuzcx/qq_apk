package com.tencent.mm.plugin.wepkg.version;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.hp.a;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h.6;
import com.tencent.mm.plugin.wepkg.model.h.7;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
  WepkgVersionUpdater$WepkgNetSceneProcessTask$1$1(WepkgVersionUpdater.WepkgNetSceneProcessTask.1 param1, tk paramtk) {}
  
  public final void run()
  {
    AppMethodBeat.i(63667);
    Object localObject3 = this.vHp;
    int i = WepkgVersionUpdater.WepkgNetSceneProcessTask.b(this.vHq.vHo);
    boolean bool1 = WepkgVersionUpdater.WepkgNetSceneProcessTask.c(this.vHq.vHo);
    if (localObject3 != null)
    {
      if (bo.es(((tk)localObject3).wLN))
      {
        ab.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
        AppMethodBeat.o(63667);
        return;
      }
      Object localObject1 = new HashSet();
      Object localObject2 = new ArrayList();
      localObject3 = ((tk)localObject3).wLN.iterator();
      Object localObject4;
      Object localObject5;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bml)((Iterator)localObject3).next();
        if (localObject4 != null)
        {
          localObject5 = ((bml)localObject4).nqD;
          Object localObject6 = ((bml)localObject4).xAN;
          cyq localcyq = ((bml)localObject4).xAP;
          if (!bo.isNullOrNil((String)localObject5))
          {
            if (localcyq != null)
            {
              if (localcyq.yfI)
              {
                ab.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 17L, 1L, false);
                if (((bml)localObject4).xAO != null) {
                  ForceUpdateNotify.xB(((bml)localObject4).nqD);
                }
              }
              if (localcyq.yfH)
              {
                com.tencent.mm.plugin.wepkg.model.b.dkA().ee((String)localObject5, 2);
                continue;
              }
            }
            if ((localObject6 != null) && (((cyu)localObject6).yfQ != null))
            {
              if (bo.isNullOrNil(((cyu)localObject6).yfQ.yfJ))
              {
                localObject4 = new WepkgCrossProcessTask();
                ((WepkgCrossProcessTask)localObject4).vA = 2004;
                ((WepkgCrossProcessTask)localObject4).vGb.ezY = ((String)localObject5);
                if (ah.brt()) {
                  d.aNS().ac(new h.6((WepkgCrossProcessTask)localObject4));
                }
                for (;;)
                {
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(859L, 18L, 1L, false);
                  break;
                  ((WepkgCrossProcessTask)localObject4).hxp = new h.7((WepkgCrossProcessTask)localObject4);
                  ((WepkgCrossProcessTask)localObject4).aBj();
                  WepkgMainProcessService.a((WepkgMainProcessTask)localObject4);
                }
              }
              boolean bool2 = ((cyu)localObject6).yfQ.yfK;
              long l1 = ((cyu)localObject6).yfQ.yfL;
              long l2 = ((cyu)localObject6).yfQ.yfM;
              localObject6 = new WepkgCrossProcessTask();
              ((WepkgCrossProcessTask)localObject6).vA = 3004;
              ((WepkgCrossProcessTask)localObject6).vGb.ezY = ((String)localObject5);
              ((WepkgCrossProcessTask)localObject6).vGb.vGJ = bool2;
              ((WepkgCrossProcessTask)localObject6).vGb.vGK = l1;
              ((WepkgCrossProcessTask)localObject6).vGb.vGL = l2;
              if (ah.brt())
              {
                ((WepkgCrossProcessTask)localObject6).ata();
                label434:
                localObject6 = new WepkgCrossProcessTask();
                ((WepkgCrossProcessTask)localObject6).vA = 3009;
                ((WepkgCrossProcessTask)localObject6).vGb.ezY = ((String)localObject5);
                if (!ah.brt()) {
                  break label561;
                }
                ((WepkgCrossProcessTask)localObject6).ata();
                label472:
                localObject6 = new WepkgCrossProcessTask();
                ((WepkgCrossProcessTask)localObject6).vA = 4006;
                ((WepkgCrossProcessTask)localObject6).vGe.ezY = ((String)localObject5);
                if (!ah.brt()) {
                  break label570;
                }
                ((WepkgCrossProcessTask)localObject6).ata();
              }
              for (;;)
              {
                if (bool1)
                {
                  localObject5 = g.a((bml)localObject4);
                  if (!bo.es((List)localObject5)) {
                    ((Set)localObject1).addAll((Collection)localObject5);
                  }
                }
                ((List)localObject2).add(localObject4);
                break;
                WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
                break label434;
                label561:
                WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
                break label472;
                label570:
                WepkgMainProcessService.b((WepkgMainProcessTask)localObject6);
              }
            }
          }
        }
      }
      ForceUpdateNotify.boB();
      a.a.dkF().k((Set)localObject1);
      if (!bo.es((List)localObject2))
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bml)((Iterator)localObject1).next();
          localObject3 = i.dkE();
          if ((localObject2 == null) || (((bml)localObject2).xAO == null))
          {
            ab.i("MicroMsg.Wepkg.WepkgUpdater", "dont need to update wepkg");
            if (localObject2 != null) {
              ((i)localObject3).bX(((bml)localObject2).nqD, false);
            }
          }
          else
          {
            localObject4 = ((bml)localObject2).xAO.yfU;
            localObject5 = ((bml)localObject2).xAO.yfV;
            if ((localObject4 == null) && (localObject5 == null))
            {
              ab.i("MicroMsg.Wepkg.WepkgUpdater", "bigPackage is null and preloadFiles is null");
              com.tencent.mm.plugin.wepkg.model.b.dkA().ee(((bml)localObject2).nqD, 2);
            }
            else
            {
              com.tencent.mm.plugin.wepkg.model.h.a((bml)localObject2, i);
              ab.i("MicroMsg.Wepkg.WepkgUpdater", "downloadTriggerType:%d", new Object[] { Integer.valueOf(i) });
              switch (i)
              {
              default: 
                break;
              case -1: 
              case 0: 
                ((i)localObject3).bX(((bml)localObject2).nqD, false);
                break;
              case 1: 
                if (d.eD(ah.getContext())) {
                  ((i)localObject3).bX(((bml)localObject2).nqD, false);
                }
                break;
              case 2: 
                localObject4 = new hp();
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
                if (((hp)localObject4).cwJ.cwK) {
                  ((i)localObject3).bX(((bml)localObject2).nqD, false);
                }
                break;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(63667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1
 * JD-Core Version:    0.7.0.1
 */