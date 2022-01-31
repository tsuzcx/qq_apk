package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.qn;
import com.tencent.mm.kernel.b;
import com.tencent.mm.m.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Date;

final class ao$1
  extends c<qn>
{
  ao$1(ao paramao)
  {
    this.udX = qn.class.getName().hashCode();
  }
  
  private boolean bEh()
  {
    int i = 1200;
    ao localao = this.otB;
    int j;
    try
    {
      if (localao.bEg())
      {
        Date localDate = new Date();
        j = localDate.getHours();
        j = localDate.getMinutes() + j * 60;
        if ((j >= localao.otw) && (j <= localao.otx))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(j), Integer.valueOf(localao.otw), Integer.valueOf(localao.otx) });
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
        k = com.tencent.mm.m.g.AA().getInt("SnsImgPreLoadingSmallImage", 1);
        m = com.tencent.mm.m.g.AA().getInt("SnsImgPreLoadingBigImage", 1);
        n = com.tencent.mm.m.g.AA().getInt("SnsPreLoadingVideo", 1);
        j = com.tencent.mm.m.g.AA().getInt("SnsImgPreLoadingInterval", 1200);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j) });
      } while ((k <= 0) && (m <= 0) && (n <= 0));
      if (j > 0) {}
    }
    for (;;)
    {
      if ((localao.eGA) || (localao.eGB) || (bk.cn(localao.otu) < i))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localao.eGA), Boolean.valueOf(localao.eGB) });
        return false;
      }
      if (!y.Nu("@__weixintimtline"))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
        return false;
      }
      com.tencent.mm.kernel.g.DQ();
      if (!com.tencent.mm.kernel.g.DO().dJT.a(new t(), 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
        y.Nv("@__weixintimtline");
      }
      localao.otu = bk.UX();
      return false;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao.1
 * JD-Core Version:    0.7.0.1
 */