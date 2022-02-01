package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Date;

public final class ao
{
  boolean hzc;
  boolean hzd;
  long wIY;
  private boolean wIZ;
  int wJa;
  int wJb;
  c<tr> wJc;
  c wJd;
  c wJe;
  
  ao()
  {
    AppMethodBeat.i(95927);
    this.wIY = 0L;
    this.hzc = false;
    this.hzd = false;
    this.wIZ = false;
    this.wJa = 0;
    this.wJb = 1440;
    this.wJc = new c()
    {
      private boolean dua()
      {
        AppMethodBeat.i(95923);
        ao localao = ao.this;
        try
        {
          if (localao.dtZ())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localao.wJa) && (i <= localao.wJb))
            {
              ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localao.wJa), Integer.valueOf(localao.wJb) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = com.tencent.mm.m.g.Zd().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = com.tencent.mm.m.g.Zd().getInt("SnsImgPreLoadingBigImage", 1);
            int m = a.duH();
            int j = a.duG();
            ad.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localao.hzc) || (localao.hzd) || (bt.lZ(localao.wIY) < i))
              {
                ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localao.hzc), Boolean.valueOf(localao.hzd) });
              }
              else if (!x.aow("@__weixintimtline"))
              {
                ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else
              {
                com.tencent.mm.kernel.g.afC();
                if (!com.tencent.mm.kernel.g.afA().gcy.a(new s(), 0))
                {
                  ad.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  x.aox("@__weixintimtline");
                }
                localao.wIY = bt.aGK();
              }
            }
          }
        }
      }
    };
    this.wJd = new c() {};
    this.wJe = new c() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean dtZ()
  {
    AppMethodBeat.i(95928);
    Object localObject = com.tencent.mm.m.g.Zd().getValue("SnsImgPreLoadingTimeLimit");
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
      int i = bt.aGh(arrayOfString[0]);
      this.wJa = (bt.aGh(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bt.aGh(localObject[0]);
      this.wJb = (bt.aGh(localObject[1]) + i * 60);
      ad.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.wJa), Integer.valueOf(this.wJb) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */