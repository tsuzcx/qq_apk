package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.j.g;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.LinkedList;

final class ar$3
  implements Runnable
{
  ar$3(ar paramar) {}
  
  public final void run()
  {
    if (this.otO.otJ != null) {
      break label10;
    }
    label10:
    while ((!this.otO.otK.isEmpty()) || (this.otO.eGE != null) || (this.otO.eGA) || (this.otO.eGB)) {
      return;
    }
    Object localObject4 = null;
    Object localObject1 = null;
    PBool localPBool = new PBool();
    PInt localPInt = new PInt();
    PString localPString = new PString();
    for (;;)
    {
      Object localObject7;
      Object localObject8;
      int i;
      synchronized (this.otO.otM)
      {
        Iterator localIterator = this.otO.otM.iterator();
        localObject7 = localObject4;
        localObject8 = localObject1;
        if (!localIterator.hasNext()) {
          break label939;
        }
        localObject4 = (com.tencent.mm.plugin.sns.storage.n)localIterator.next();
        localObject7 = this.otO;
        if (localObject4 == null)
        {
          localPBool.value = true;
          i = 0;
          if (localPBool.value) {
            localIterator.remove();
          }
          if (i == 0) {
            break label1179;
          }
          i = localPInt.value;
          localObject7 = localPString.value;
          if (localObject4 != null) {
            break label583;
          }
          localObject1 = null;
          localObject7 = localObject4;
          localObject8 = localObject1;
          if (localObject1 != null) {
            break label939;
          }
          localIterator.remove();
        }
      }
      if (bk.cn(((com.tencent.mm.plugin.sns.storage.n)localObject4).field_createTime) >= 86400L)
      {
        localPBool.value = true;
        i = 0;
      }
      else if (o.St().cg(false))
      {
        localPBool.value = true;
        i = 0;
      }
      else
      {
        localObject8 = aj.p((com.tencent.mm.plugin.sns.storage.n)localObject4);
        if ((localObject8 == null) || (((bto)localObject8).tKn == null))
        {
          y.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
          localPBool.value = true;
          i = 0;
        }
        else
        {
          y.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", new Object[] { Integer.valueOf(localObject7.hashCode()), ((com.tencent.mm.plugin.sns.storage.n)localObject4).bGE(), Integer.valueOf(((bto)localObject8).tKn.tzV), Integer.valueOf(((bto)localObject8).tKn.tzW), ((bto)localObject8).tKn.tzX });
          if (((bto)localObject8).tKn.tzV <= 0)
          {
            y.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", new Object[] { Integer.valueOf(localObject7.hashCode()) });
            localPBool.value = true;
            i = 0;
          }
          else
          {
            localPString.value = ((bto)localObject8).sGd;
            localPInt.value = ((bto)localObject8).tKn.tzV;
            if (!b.lO(((bto)localObject8).tKn.tzX))
            {
              if (com.tencent.mm.sdk.platformtools.aq.isWifi(ae.getContext())) {
                i = ((bto)localObject8).tKn.tzW & 0x1;
              }
              for (;;)
              {
                if (i > 0)
                {
                  localPBool.value = false;
                  i = 1;
                  break;
                  if (com.tencent.mm.sdk.platformtools.aq.is4G(ae.getContext()))
                  {
                    i = ((bto)localObject8).tKn.tzW & 0x2;
                  }
                  else if (com.tencent.mm.sdk.platformtools.aq.is3G(ae.getContext()))
                  {
                    i = ((bto)localObject8).tKn.tzW & 0x4;
                  }
                  else
                  {
                    localPBool.value = false;
                    i = 0;
                    break;
                  }
                }
              }
            }
            localPBool.value = false;
            i = 0;
            continue;
            label583:
            localObject8 = (awd)((com.tencent.mm.plugin.sns.storage.n)localObject4).bGe().tNr.sPJ.get(0);
            ??? = ((com.tencent.mm.plugin.sns.storage.n)localObject4).bGE();
            String str = aq.a((String)???, (awd)localObject8);
            if (!bk.bl(str))
            {
              y.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", new Object[] { str });
              ??? = ((awd)localObject8).tsk;
              long l = com.tencent.mm.vfs.e.aeQ(str);
              o.St().a((String)???, 3, l, ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_userName, "", 0, "", ((awd)localObject8).kSC, (String)localObject7);
              h.nFQ.a(354L, 147L, 1L, false);
              ??? = null;
            }
            else
            {
              boolean bool = com.tencent.mm.vfs.e.nb(aq.NL(((awd)localObject8).lsK));
              str = aq.D((awd)localObject8);
              Object localObject9 = aq.NM((String)???);
              if (localObject9 == null) {
                aq.ct((String)???, 30);
              }
              for (;;)
              {
                y.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", new Object[] { str, Boolean.valueOf(bool) });
                localObject9 = new a(((awd)localObject8).lsK);
                ((a)localObject9).oqa = ((awd)localObject8);
                az localaz = az.cvd();
                localaz.time = ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_createTime;
                ((a)localObject9).ouK = localaz;
                ((a)localObject9).ouI = true;
                ((a)localObject9).url = ((awd)localObject8).kSC;
                int j = ((awd)localObject8).hQR;
                ((a)localObject9).ouH = false;
                com.tencent.mm.modelvideo.n.Sp();
                o.Ss();
                ??? = com.tencent.mm.ak.e.a(((a)localObject9).ouK, ((a)localObject9).url, str, aq.nR((String)???), 2);
                if (??? != null) {
                  break label892;
                }
                ??? = null;
                break;
                aq.c((s)localObject9, 30);
              }
              label892:
              ((g)???).bvB = ((awd)localObject8).tsk;
              ((g)???).field_preloadRatio = i;
              ((g)???).bRV = ((String)localObject7);
              localObject7 = ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_userName;
              ((g)???).dmh = ((String)localObject7);
              ((g)???).bRO = ((String)localObject7);
              continue;
              label939:
              if ((localObject7 == null) || (localObject8 == null)) {
                break;
              }
              i = 0;
              if (localObject8 != null) {}
              for (;;)
              {
                try
                {
                  this.otO.eGE = new f((g)localObject8, ((com.tencent.mm.plugin.sns.storage.n)localObject7).bGE());
                  if (this.otO.eGE.a(this.otO) < 0)
                  {
                    y.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(this.otO.hashCode()) });
                    i = 1;
                    this.otO.eGE = null;
                  }
                  if (i == 0) {
                    break;
                  }
                  synchronized (this.otO.otM)
                  {
                    localObject4 = this.otO.otM.iterator();
                    if (!((Iterator)localObject4).hasNext()) {
                      break label1175;
                    }
                    localObject8 = (com.tencent.mm.plugin.sns.storage.n)((Iterator)localObject4).next();
                    if ((localObject8 == null) || (!bk.isEqual(((com.tencent.mm.plugin.sns.storage.n)localObject8).bGE(), ((com.tencent.mm.plugin.sns.storage.n)localObject7).bGE()))) {
                      continue;
                    }
                    y.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[] { Integer.valueOf(this.otO.hashCode()), ((com.tencent.mm.plugin.sns.storage.n)localObject7).bGE() });
                    ((Iterator)localObject4).remove();
                  }
                  i = 1;
                }
                catch (Exception localException)
                {
                  y.printErrStackTrace("MicroMsg.SnsVideoService", localException, "", new Object[0]);
                  return;
                }
              }
              label1175:
              return;
              label1179:
              Object localObject6 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.3
 * JD-Core Version:    0.7.0.1
 */