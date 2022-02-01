package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.c.b;
import com.tencent.matrix.report.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.bl;
import com.tencent.mm.f.a.xa;
import com.tencent.mm.f.a.xn;
import com.tencent.mm.kernel.c;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;

public final class ar
{
  long JZJ;
  private boolean JZK;
  int JZL;
  int JZM;
  IListener<xa> JZN;
  IListener JZO;
  IListener JZP;
  boolean mgH;
  boolean mgI;
  
  ar()
  {
    AppMethodBeat.i(95927);
    this.JZJ = 0L;
    this.mgH = false;
    this.mgI = false;
    this.JZK = false;
    this.JZL = 0;
    this.JZM = 1440;
    this.JZN = new IListener()
    {
      private boolean fPs()
      {
        AppMethodBeat.i(95923);
        ar localar = ar.this;
        try
        {
          if (localar.fPr())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localar.JZL) && (i <= localar.JZM))
            {
              Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localar.JZL), Integer.valueOf(localar.JZM) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = com.tencent.mm.n.h.axc().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = com.tencent.mm.n.h.axc().getInt("SnsImgPreLoadingBigImage", 1);
            int m = com.tencent.mm.plugin.sns.model.b.a.fQc();
            int j = com.tencent.mm.plugin.sns.model.b.a.fQb();
            Log.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localar.mgH) || (localar.mgI) || (Util.secondsToNow(localar.JZJ) < i))
              {
                Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localar.mgH), Boolean.valueOf(localar.mgI) });
              }
              else if (!z.aZV("@__weixintimtline"))
              {
                Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else if ((com.tencent.matrix.c.a.jC(82)) && (b.Xm()))
              {
                Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: on doze mode");
                d.a.jD(82);
              }
              else
              {
                com.tencent.mm.kernel.h.aHH();
                if (!com.tencent.mm.kernel.h.aHF().kcd.a(new u(), 0))
                {
                  Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  z.aZW("@__weixintimtline");
                }
                localar.JZJ = Util.nowSecond();
              }
            }
          }
        }
      }
    };
    this.JZO = new IListener() {};
    this.JZP = new IListener() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean fPr()
  {
    AppMethodBeat.i(95928);
    Object localObject = com.tencent.mm.n.h.axc().getValue("SnsImgPreLoadingTimeLimit");
    Log.i("MicroMsg.SnsPreTimelineService", "preloadLimit:%s", new Object[] { localObject });
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(95928);
      return false;
    }
    try
    {
      localObject = ((String)localObject).split("-");
      String[] arrayOfString = localObject[0].split(":");
      int i = Util.safeParseInt(arrayOfString[0]);
      this.JZL = (Util.safeParseInt(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = Util.safeParseInt(localObject[0]);
      this.JZM = (Util.safeParseInt(localObject[1]) + i * 60);
      Log.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.JZL), Integer.valueOf(this.JZM) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */