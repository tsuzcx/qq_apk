package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sns.model.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.util.Iterator;
import java.util.LinkedList;

final class as$3
  implements Runnable
{
  as$3(as paramas) {}
  
  public final void run()
  {
    AppMethodBeat.i(36647);
    if (this.riG.riB != null)
    {
      AppMethodBeat.o(36647);
      return;
    }
    if (!this.riG.riC.isEmpty())
    {
      AppMethodBeat.o(36647);
      return;
    }
    if (this.riG.fWu != null)
    {
      AppMethodBeat.o(36647);
      return;
    }
    if ((this.riG.fWq) || (this.riG.fWr))
    {
      AppMethodBeat.o(36647);
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
      synchronized (this.riG.riE)
      {
        Iterator localIterator = this.riG.riE.iterator();
        localObject7 = localObject4;
        localObject8 = localObject1;
        if (!localIterator.hasNext()) {
          break label968;
        }
        localObject4 = (com.tencent.mm.plugin.sns.storage.n)localIterator.next();
        localObject7 = this.riG;
        if (localObject4 == null)
        {
          localPBool.value = true;
          i = 0;
          if (localPBool.value) {
            localIterator.remove();
          }
          if (i == 0) {
            break label1236;
          }
          i = localPInt.value;
          localObject7 = localPString.value;
          if (localObject4 != null) {
            break label616;
          }
          localObject1 = null;
          localObject7 = localObject4;
          localObject8 = localObject1;
          if (localObject1 != null) {
            break label968;
          }
          localIterator.remove();
        }
      }
      if (bo.gz(((com.tencent.mm.plugin.sns.storage.n)localObject4).field_createTime) >= 86400L)
      {
        localPBool.value = true;
        i = 0;
      }
      else if (o.alG().dj(false))
      {
        localPBool.value = true;
        i = 0;
      }
      else
      {
        localObject8 = ak.p((com.tencent.mm.plugin.sns.storage.n)localObject4);
        if ((localObject8 == null) || (((SnsObject)localObject8).PreDownloadInfo == null))
        {
          ab.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
          localPBool.value = true;
          i = 0;
        }
        else
        {
          ab.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", new Object[] { Integer.valueOf(localObject7.hashCode()), ((com.tencent.mm.plugin.sns.storage.n)localObject4).csH(), Integer.valueOf(((SnsObject)localObject8).PreDownloadInfo.xBv), Integer.valueOf(((SnsObject)localObject8).PreDownloadInfo.xBw), ((SnsObject)localObject8).PreDownloadInfo.xBx });
          if (((SnsObject)localObject8).PreDownloadInfo.xBv <= 0)
          {
            ab.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", new Object[] { Integer.valueOf(localObject7.hashCode()) });
            localPBool.value = true;
            i = 0;
          }
          else
          {
            localPString.value = ((SnsObject)localObject8).Id;
            localPInt.value = ((SnsObject)localObject8).PreDownloadInfo.xBv;
            if (!b.sM(((SnsObject)localObject8).PreDownloadInfo.xBx))
            {
              if (at.isWifi(ah.getContext())) {
                i = ((SnsObject)localObject8).PreDownloadInfo.xBw & 0x1;
              }
              for (;;)
              {
                if (i > 0)
                {
                  localPBool.value = false;
                  i = 1;
                  break;
                  if (at.is4G(ah.getContext()))
                  {
                    i = ((SnsObject)localObject8).PreDownloadInfo.xBw & 0x2;
                  }
                  else if (at.is3G(ah.getContext()))
                  {
                    i = ((SnsObject)localObject8).PreDownloadInfo.xBw & 0x4;
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
            label616:
            localObject8 = (bcs)((com.tencent.mm.plugin.sns.storage.n)localObject4).csh().xTS.wOa.get(0);
            ??? = ((com.tencent.mm.plugin.sns.storage.n)localObject4).csH();
            String str = ar.a((String)???, (bcs)localObject8);
            if (!bo.isNullOrNil(str))
            {
              ab.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", new Object[] { str });
              ??? = ((bcs)localObject8).xsn;
              long l = com.tencent.mm.vfs.e.avI(str);
              o.alG().a((String)???, 3, l, ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_userName, "", 0, "", ((bcs)localObject8).Url, (String)localObject7);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(354L, 147L, 1L, false);
              ??? = null;
            }
            else
            {
              boolean bool = com.tencent.mm.vfs.e.um(ar.aaF(((bcs)localObject8).Id));
              str = ar.D((bcs)localObject8);
              Object localObject9 = ar.aaG((String)???);
              if (localObject9 == null) {
                ar.dp((String)???, 30);
              }
              for (;;)
              {
                ab.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", new Object[] { str, Boolean.valueOf(bool) });
                localObject9 = new a(((bcs)localObject8).Id);
                ((a)localObject9).reH = ((bcs)localObject8);
                az localaz = az.dxG();
                localaz.oLs = ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_createTime;
                ((a)localObject9).rjD = localaz;
                ((a)localObject9).rjB = true;
                ((a)localObject9).url = ((bcs)localObject8).Url;
                ((a)localObject9).rjA = false;
                com.tencent.mm.modelvideo.n.alC();
                o.alF();
                ??? = com.tencent.mm.al.e.a(((a)localObject9).rjD, ((a)localObject9).url, str, ar.ve((String)???), 2);
                if (??? != null) {
                  break label921;
                }
                ??? = null;
                break;
                ar.c((s)localObject9, 30);
              }
              label921:
              ((com.tencent.mm.i.h)???).bWM = ((bcs)localObject8).xsn;
              ((com.tencent.mm.i.h)???).field_preloadRatio = i;
              ((com.tencent.mm.i.h)???).czw = ((String)localObject7);
              localObject7 = ((com.tencent.mm.plugin.sns.storage.n)localObject4).field_userName;
              ((com.tencent.mm.i.h)???).edK = ((String)localObject7);
              ((com.tencent.mm.i.h)???).czp = ((String)localObject7);
              continue;
              label968:
              if ((localObject7 == null) || (localObject8 == null))
              {
                AppMethodBeat.o(36647);
                return;
              }
              i = 0;
              if (localObject8 != null) {}
              for (;;)
              {
                try
                {
                  this.riG.fWu = new f((com.tencent.mm.i.h)localObject8, ((com.tencent.mm.plugin.sns.storage.n)localObject7).csH());
                  if (this.riG.fWu.a(this.riG) < 0)
                  {
                    ab.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", new Object[] { Integer.valueOf(this.riG.hashCode()) });
                    i = 1;
                    this.riG.fWu = null;
                  }
                  if (i == 0) {
                    break label1230;
                  }
                  synchronized (this.riG.riE)
                  {
                    localObject4 = this.riG.riE.iterator();
                    if (!((Iterator)localObject4).hasNext()) {
                      break;
                    }
                    localObject8 = (com.tencent.mm.plugin.sns.storage.n)((Iterator)localObject4).next();
                    if ((localObject8 == null) || (!bo.isEqual(((com.tencent.mm.plugin.sns.storage.n)localObject8).csH(), ((com.tencent.mm.plugin.sns.storage.n)localObject7).csH()))) {
                      continue;
                    }
                    ab.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[] { Integer.valueOf(this.riG.hashCode()), ((com.tencent.mm.plugin.sns.storage.n)localObject7).csH() });
                    ((Iterator)localObject4).remove();
                  }
                  i = 1;
                }
                catch (Exception localException)
                {
                  ab.printErrStackTrace("MicroMsg.SnsVideoService", localException, "", new Object[0]);
                  AppMethodBeat.o(36647);
                  return;
                }
              }
              AppMethodBeat.o(36647);
              return;
              label1230:
              AppMethodBeat.o(36647);
              return;
              label1236:
              Object localObject6 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as.3
 * JD-Core Version:    0.7.0.1
 */