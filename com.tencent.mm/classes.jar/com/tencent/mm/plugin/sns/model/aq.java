package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Date;

public final class aq
{
  boolean ivS;
  boolean ivT;
  long zCE;
  private boolean zCF;
  int zCG;
  int zCH;
  c<ux> zCI;
  c zCJ;
  c zCK;
  
  aq()
  {
    AppMethodBeat.i(95927);
    this.zCE = 0L;
    this.ivS = false;
    this.ivT = false;
    this.zCF = false;
    this.zCG = 0;
    this.zCH = 1440;
    this.zCI = new c()
    {
      private boolean dYl()
      {
        AppMethodBeat.i(95923);
        aq localaq = aq.this;
        try
        {
          if (localaq.dYk())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localaq.zCG) && (i <= localaq.zCH))
            {
              ae.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localaq.zCG), Integer.valueOf(localaq.zCH) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = com.tencent.mm.n.g.acL().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = com.tencent.mm.n.g.acL().getInt("SnsImgPreLoadingBigImage", 1);
            int m = a.dYV();
            int j = a.dYU();
            ae.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localaq.ivS) || (localaq.ivT) || (bu.rZ(localaq.zCE) < i))
              {
                ae.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localaq.ivS), Boolean.valueOf(localaq.ivT) });
              }
              else if (!y.aAe("@__weixintimtline"))
              {
                ae.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else
              {
                com.tencent.mm.kernel.g.ajS();
                if (!com.tencent.mm.kernel.g.ajQ().gDv.a(new t(), 0))
                {
                  ae.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  y.aAf("@__weixintimtline");
                }
                localaq.zCE = bu.aRi();
              }
            }
          }
        }
      }
    };
    this.zCJ = new c() {};
    this.zCK = new c() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean dYk()
  {
    AppMethodBeat.i(95928);
    Object localObject = com.tencent.mm.n.g.acL().getValue("SnsImgPreLoadingTimeLimit");
    ae.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(95928);
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = bu.aSB(arrayOfString[0]);
      this.zCG = (bu.aSB(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bu.aSB(localObject[0]);
      this.zCH = (bu.aSB(localObject[1]) + i * 60);
      ae.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.zCG), Integer.valueOf(this.zCH) });
      AppMethodBeat.o(95928);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(95928);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */