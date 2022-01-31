package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Date;

final class ap$1
  extends c<rx>
{
  ap$1(ap paramap)
  {
    AppMethodBeat.i(36600);
    this.__eventId = rx.class.getName().hashCode();
    AppMethodBeat.o(36600);
  }
  
  private boolean cpG()
  {
    int i = 1200;
    AppMethodBeat.i(36601);
    ap localap = this.rit;
    int j;
    try
    {
      if (localap.cpF())
      {
        Date localDate = new Date();
        j = localDate.getHours();
        j = localDate.getMinutes() + j * 60;
        if ((j >= localap.rio) && (j <= localap.rip))
        {
          ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(j), Integer.valueOf(localap.rio), Integer.valueOf(localap.rip) });
          AppMethodBeat.o(36601);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      int k;
      int m;
      int n;
      do
      {
        k = com.tencent.mm.m.g.Nq().getInt("SnsImgPreLoadingSmallImage", 1);
        m = com.tencent.mm.m.g.Nq().getInt("SnsImgPreLoadingBigImage", 1);
        n = com.tencent.mm.m.g.Nq().getInt("SnsPreLoadingVideo", 1);
        j = com.tencent.mm.m.g.Nq().getInt("SnsImgPreLoadingInterval", 1200);
        ab.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j) });
      } while ((k <= 0) && (m <= 0) && (n <= 0));
      if (j > 0) {}
    }
    for (;;)
    {
      if ((localap.fWq) || (localap.fWr) || (bo.gz(localap.rim) < i))
      {
        ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localap.fWq), Boolean.valueOf(localap.fWr) });
        break;
      }
      if (!y.aan("@__weixintimtline"))
      {
        ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
        break;
      }
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RK().eHt.a(new t(), 0))
      {
        ab.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
        y.aao("@__weixintimtline");
      }
      localap.rim = bo.aox();
      break;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap.1
 * JD-Core Version:    0.7.0.1
 */