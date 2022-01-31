package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.util.List;

final class g$7
  implements Runnable
{
  g$7(g paramg, List paramList, az paramaz) {}
  
  public final void run()
  {
    AppMethodBeat.i(36142);
    long l = bo.yB();
    Object localObject = new com.tencent.mm.plugin.sns.data.e(this.rdV);
    ((com.tencent.mm.plugin.sns.data.e)localObject).ohe = i.cY(this.rdV);
    ((com.tencent.mm.plugin.sns.data.e)localObject).rbj = this.rdN;
    int j = 0;
    int k = 1;
    if ((j < this.rdV.size()) && (j < 4))
    {
      bcs localbcs = (bcs)this.rdV.get(j);
      if (ag.cpa().aab(localbcs.Id)) {
        i = 0;
      }
      do
      {
        do
        {
          do
          {
            j += 1;
            k = i;
            break;
            i = k;
          } while (com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), localbcs.Id) + i.e(localbcs)));
          i = k;
        } while (com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), localbcs.Id) + i.l(localbcs)));
        i = k;
      } while (com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), localbcs.Id) + i.m(localbcs)));
      b localb = ag.cpa();
      if (localbcs.jKs == 6) {}
      for (int i = 5;; i = 1)
      {
        localb.a(localbcs, i, (com.tencent.mm.plugin.sns.data.e)localObject, this.rdW);
        i = 0;
        break;
      }
    }
    l = bo.av(l);
    if (l > 100L) {
      ab.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.eQx + " " + ag.cpr() + " " + ((com.tencent.mm.plugin.sns.data.e)localObject).ohe);
    }
    if (bo.av(g.c(this.rdL)) > 60000L)
    {
      h.qsU.e(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
      g.a(this.rdL, bo.yB());
    }
    localObject = i.cY(this.rdV);
    if (k != 0) {
      ag.bEf().post(new g.7.1(this, (String)localObject));
    }
    AppMethodBeat.o(36142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.7
 * JD-Core Version:    0.7.0.1
 */