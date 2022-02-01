package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.c.b.g
{
  private long Gtb;
  private long Gtc;
  private long Gtd;
  private int Gte;
  private Set<Integer> Gtf;
  private c<n> lyl;
  private int pcr;
  
  public f()
  {
    AppMethodBeat.i(191493);
    this.Gtf = new HashSet();
    this.lyl = new c() {};
    AppMethodBeat.o(191493);
  }
  
  private static void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2)
  {
    AppMethodBeat.i(191503);
    ad.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(0), Long.valueOf(paramLong2), Integer.valueOf(0), null, null, null });
    com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null });
    AppMethodBeat.o(191503);
  }
  
  private boolean eXa()
  {
    AppMethodBeat.i(191504);
    if (bt.isNullOrNil(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(191504);
      return false;
    }
    boolean bool = w.tn(this.cOd.getTalkerUserName());
    AppMethodBeat.o(191504);
    return bool;
  }
  
  private static void lr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191502);
    com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1 });
    AppMethodBeat.o(191502);
  }
  
  public final void YK(int paramInt)
  {
    AppMethodBeat.i(191501);
    if (!eXa())
    {
      AppMethodBeat.o(191501);
      return;
    }
    this.Gtf.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(191501);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(191495);
    super.eQA();
    if (!eXa())
    {
      AppMethodBeat.o(191495);
      return;
    }
    com.tencent.mm.kernel.g.afz();
    this.pcr = com.tencent.mm.kernel.a.getUin();
    this.Gtc = bt.GC();
    this.Gtb = System.currentTimeMillis();
    this.Gtd = 0L;
    this.Gte = 0;
    this.Gtf.clear();
    AppMethodBeat.o(191495);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(191494);
    super.eQB();
    if (!eXa())
    {
      AppMethodBeat.o(191494);
      return;
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agE("appbrand_notify_message") >= 2)
    {
      bl localbl = ((i)this.cOd.be(i.class)).YE(0);
      if ((localbl != null) && (localbl.field_isSend == 2)) {
        ((i)this.cOd.be(i.class)).YG(1);
      }
    }
    AppMethodBeat.o(191494);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(191496);
    super.eQD();
    if (!eXa())
    {
      AppMethodBeat.o(191496);
      return;
    }
    this.Gtc = bt.GC();
    com.tencent.mm.sdk.b.a.ESL.c(this.lyl);
    AppMethodBeat.o(191496);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(191497);
    super.eQE();
    if (!eXa())
    {
      AppMethodBeat.o(191497);
      return;
    }
    this.Gtd += bt.aS(this.Gtc) / 1000L;
    com.tencent.mm.sdk.b.a.ESL.d(this.lyl);
    AppMethodBeat.o(191497);
  }
  
  public final void eQG()
  {
    AppMethodBeat.i(191498);
    super.eQG();
    if (!eXa())
    {
      AppMethodBeat.o(191498);
      return;
    }
    this.Gtd += bt.aS(this.Gtc) / 1000L;
    a(8, this.Gtd, this.Gtf.size(), com.tencent.mm.ai.a.a.rF(com.tencent.mm.ai.a.a.rE(((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().agq("appbrand_notify_message").field_content).title), this.Gte, bt.GC());
    Object localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().dG("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      ad.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.pcr;
      localObject1 = ai.du(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).cOI().dG("appbrand_notify_message", this.Gte);
      if (localObject4 != null) {
        break label509;
      }
      ad.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
    }
    Object localObject3;
    for (;;)
    {
      this.Gtf.clear();
      AppMethodBeat.o(191498);
      return;
      i = 1;
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new bl();
        ((bl)localObject3).convertFrom((Cursor)localObject1);
        localObject4 = com.tencent.mm.ai.a.a.rE(((du)localObject3).field_content);
        if (((du)localObject3).field_isSend == 2)
        {
          i += 1;
        }
        else
        {
          if (((this.Gtb > bt.aGi(((du)localObject3).dxG)) && (this.Gtb - bt.aGi(((du)localObject3).dxG) <= 60000L)) || ((bt.aGi(((du)localObject3).dxG) > this.Gtb) && (this.Gtd >= 3L)))
          {
            ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.ai.a.a)localObject4).dvT });
            com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.ai.a.a)localObject4).appId, null, null, ((com.tencent.mm.ai.a.a)localObject4).dvT, Integer.valueOf(0), null, com.tencent.mm.ai.a.a.rF(((com.tencent.mm.ai.a.a)localObject4).title), Integer.valueOf(1), null, null });
          }
          i += 1;
        }
      }
      break;
      label509:
      localObject3 = new StringBuilder();
      i = 0;
      int j = 0;
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          Object localObject6 = new bl();
          ((bl)localObject6).convertFrom((Cursor)localObject4);
          Object localObject5 = com.tencent.mm.ai.a.a.rE(((du)localObject6).field_content);
          if (((du)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.ai.a.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.ai.a.a)localObject5).dvT;
            j += 1;
            ((StringBuilder)localObject3).append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (((StringBuilder)localObject3).length() > 5000)
            {
              ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              ((StringBuilder)localObject3).setLength(((StringBuilder)localObject3).length() - 1);
              lr((String)localObject1, ((StringBuilder)localObject3).toString());
              ((StringBuilder)localObject3).delete(0, ((StringBuilder)localObject3).length());
              i = 1;
            }
          }
        }
        ((Cursor)localObject4).close();
        if (((StringBuilder)localObject3).length() > 0) {
          ((StringBuilder)localObject3).setLength(((StringBuilder)localObject3).length() - 1);
        }
        if (bt.isNullOrNil(((StringBuilder)localObject3).toString().trim())) {
          ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(191498);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      lr(str1, ((StringBuilder)localObject3).toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(191500);
    if (!eXa())
    {
      AppMethodBeat.o(191500);
      return;
    }
    a(10, 0L, 0, null, 0, 0L);
    AppMethodBeat.o(191500);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191499);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!eXa())
    {
      AppMethodBeat.o(191499);
      return;
    }
    this.Gte = Math.max(this.Gte, paramInt3 - paramInt1);
    AppMethodBeat.o(191499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.f
 * JD-Core Version:    0.7.0.1
 */