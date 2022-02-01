package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Date;

public final class ap
{
  boolean isY;
  boolean isZ;
  long zlp;
  private boolean zlq;
  int zlr;
  int zls;
  c<ut> zlt;
  c zlu;
  c zlv;
  
  ap()
  {
    AppMethodBeat.i(95927);
    this.zlp = 0L;
    this.isY = false;
    this.isZ = false;
    this.zlq = false;
    this.zlr = 0;
    this.zls = 1440;
    this.zlt = new c()
    {
      private boolean dUL()
      {
        AppMethodBeat.i(95923);
        ap localap = ap.this;
        try
        {
          if (localap.dUK())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localap.zlr) && (i <= localap.zls))
            {
              ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localap.zlr), Integer.valueOf(localap.zls) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = com.tencent.mm.n.g.acA().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = com.tencent.mm.n.g.acA().getInt("SnsImgPreLoadingBigImage", 1);
            int m = a.dVu();
            int j = a.dVt();
            ad.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localap.isY) || (localap.isZ) || (bt.rM(localap.zlp) < i))
              {
                ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localap.isY), Boolean.valueOf(localap.isZ) });
              }
              else if (!x.ayN("@__weixintimtline"))
              {
                ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else
              {
                com.tencent.mm.kernel.g.ajD();
                if (!com.tencent.mm.kernel.g.ajB().gAO.a(new s(), 0))
                {
                  ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  x.ayO("@__weixintimtline");
                }
                localap.zlp = bt.aQJ();
              }
            }
          }
        }
      }
    };
    this.zlu = new c() {};
    this.zlv = new c() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean dUK()
  {
    AppMethodBeat.i(95928);
    Object localObject = com.tencent.mm.n.g.acA().getValue("SnsImgPreLoadingTimeLimit");
    ad.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(95928);
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = bt.aRe(arrayOfString[0]);
      this.zlr = (bt.aRe(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bt.aRe(localObject[0]);
      this.zls = (bt.aRe(localObject[1]) + i * 60);
      ad.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.zlr), Integer.valueOf(this.zls) });
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap
 * JD-Core Version:    0.7.0.1
 */