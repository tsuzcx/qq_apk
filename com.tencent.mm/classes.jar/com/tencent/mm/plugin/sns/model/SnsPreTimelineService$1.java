package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.c.b;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.yt;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.LinkedList;

class SnsPreTimelineService$1
  extends IListener<yt>
{
  SnsPreTimelineService$1(at paramat, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309411);
    this.__eventId = yt.class.getName().hashCode();
    AppMethodBeat.o(309411);
  }
  
  private boolean hhl()
  {
    AppMethodBeat.i(95923);
    at localat = this.QwZ;
    try
    {
      if (localat.hhk())
      {
        Date localDate = new Date();
        i = localDate.getHours();
        i = localDate.getMinutes() + i * 60;
        if (t.m(localat.QwV, i))
        {
          Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  %d in %s", new Object[] { Integer.valueOf(i), localat.QwV.toArray() });
          AppMethodBeat.o(95923);
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = i.aRC().getInt("SnsImgPreLoadingSmallImage", 1);
        int k = i.aRC().getInt("SnsImgPreLoadingBigImage", 1);
        int m = com.tencent.mm.plugin.sns.model.b.a.hhU();
        int j = com.tencent.mm.plugin.sns.model.b.a.hhT();
        Log.i("MicroMsg.SnsPreTimelineService", " preloadingSamllImage %d preloadingBigImage %d preloadingVideo %d preloadingInterval %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j) });
        if ((i > 0) || (k > 0) || (m > 0))
        {
          i = j;
          if (j <= 0) {
            i = 1200;
          }
          if ((localat.oZR) || (localat.oZS) || (Util.secondsToNow(localat.QwR) < i))
          {
            Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked,  isInChatting:%b, isInSnsTimeline:%b", new Object[] { Boolean.valueOf(localat.oZR), Boolean.valueOf(localat.oZS) });
          }
          else if (!z.aYj("@__weixintimtline"))
          {
            Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: doing timeline");
          }
          else if ((com.tencent.matrix.c.a.ni(82)) && (b.ayx()))
          {
            Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync blocked: on doze mode");
            e.a.ns(82);
          }
          else
          {
            h.baF();
            if (!h.baD().mCm.a(new u(), 0))
            {
              Log.i("MicroMsg.SnsPreTimelineService", "newObjectSync triggered");
              z.aYk("@__weixintimtline");
            }
            localat.QwR = Util.nowSecond();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsPreTimelineService.1
 * JD-Core Version:    0.7.0.1
 */