package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;

public final class as
{
  long DMH;
  private boolean DMI;
  int DMJ;
  int DMK;
  IListener<vv> DML;
  IListener DMM;
  IListener DMN;
  boolean jre;
  boolean jrf;
  
  as()
  {
    AppMethodBeat.i(95927);
    this.DMH = 0L;
    this.jre = false;
    this.jrf = false;
    this.DMI = false;
    this.DMJ = 0;
    this.DMK = 1440;
    this.DML = new IListener()
    {
      private boolean fbz()
      {
        AppMethodBeat.i(95923);
        as localas = as.this;
        try
        {
          if (localas.fby())
          {
            Date localDate = new Date();
            i = localDate.getHours();
            i = localDate.getMinutes() + i * 60;
            if ((i >= localas.DMJ) && (i <= localas.DMK))
            {
              Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in [%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localas.DMJ), Integer.valueOf(localas.DMK) });
              AppMethodBeat.o(95923);
              return false;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i = h.aqJ().getInt("SnsImgPreLoadingSmallImage", 1);
            int k = h.aqJ().getInt("SnsImgPreLoadingBigImage", 1);
            int m = a.fcj();
            int j = a.fci();
            Log.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
            if ((i > 0) || (k > 0) || (m > 0))
            {
              i = j;
              if (j <= 0) {
                i = 1200;
              }
              if ((localas.jre) || (localas.jrf) || (Util.secondsToNow(localas.DMH) < i))
              {
                Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localas.jre), Boolean.valueOf(localas.jrf) });
              }
              else if (!z.aPa("@__weixintimtline"))
              {
                Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
              }
              else
              {
                g.aAi();
                if (!g.aAg().hqi.a(new u(), 0))
                {
                  Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
                  z.aPb("@__weixintimtline");
                }
                localas.DMH = Util.nowSecond();
              }
            }
          }
        }
      }
    };
    this.DMM = new IListener() {};
    this.DMN = new IListener() {};
    AppMethodBeat.o(95927);
  }
  
  final boolean fby()
  {
    AppMethodBeat.i(95928);
    Object localObject = h.aqJ().getValue("SnsImgPreLoadingTimeLimit");
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
      this.DMJ = (Util.safeParseInt(arrayOfString[1]) + i * 60);
      localObject = localObject[1].split(":");
      i = Util.safeParseInt(localObject[0]);
      this.DMK = (Util.safeParseInt(localObject[1]) + i * 60);
      Log.d("MicroMsg.SnsPreTimelineService", "preloadLimit:%d-%d", new Object[] { Integer.valueOf(this.DMJ), Integer.valueOf(this.DMK) });
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.as
 * JD-Core Version:    0.7.0.1
 */