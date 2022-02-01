package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Date;

public final class ao
{
  boolean hZD;
  boolean hZE;
  long xVt;
  private boolean xVu;
  int xVv;
  int xVw;
  c<ua> xVx;
  c xVy;
  c xVz;
  
  ao()
  {
    AppMethodBeat.i(95927);
    this.xVt = 0L;
    this.hZD = false;
    this.hZE = false;
    this.xVu = false;
    this.xVv = 0;
    this.xVw = 1440;
    this.xVx = new c()
    {
      private boolean dIy()
      {
        AppMethodBeat.i(95923);
        ao localao = ao.this;
        try
        {
          if (localao.dIx())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localao.xVv) && (i <= localao.xVw))
            {
              ac.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localao.xVv), Integer.valueOf(localao.xVw) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = com.tencent.mm.m.g.ZY().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = com.tencent.mm.m.g.ZY().getInt("SnsImgPreLoadingBigImage", 1);
            int m = a.dJh();
            int j = a.dJg();
            ac.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localao.hZD) || (localao.hZE) || (bs.pN(localao.xVt) < i))
              {
                ac.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localao.hZD), Boolean.valueOf(localao.hZE) });
              }
              else if (!x.atI("@__weixintimtline"))
              {
                ac.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else
              {
                com.tencent.mm.kernel.g.agS();
                if (!com.tencent.mm.kernel.g.agQ().ghe.a(new s(), 0))
                {
                  ac.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  x.atJ("@__weixintimtline");
                }
                localao.xVt = bs.aNx();
              }
            }
          }
        }
      }
    };
    this.xVy = new c() {};
    this.xVz = new c() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean dIx()
  {
    AppMethodBeat.i(95928);
    Object localObject = com.tencent.mm.m.g.ZY().getValue("SnsImgPreLoadingTimeLimit");
    ac.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(95928);
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = bs.aLy(arrayOfString[0]);
      this.xVv = (bs.aLy(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = bs.aLy(localObject[0]);
      this.xVw = (bs.aLy(localObject[1]) + i * 60);
      ac.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.xVv), Integer.valueOf(this.xVw) });
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */