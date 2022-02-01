package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.d.b.g
{
  private long JHn;
  private long JHo;
  private long JHp;
  private int JHq;
  private Set<Integer> JHr;
  private String jDl;
  private c<n> mAa;
  private int qjh;
  
  public f()
  {
    AppMethodBeat.i(193972);
    this.JHr = new HashSet();
    this.mAa = new c() {};
    AppMethodBeat.o(193972);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(193982);
    ad.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jDl });
    AppMethodBeat.o(193982);
  }
  
  private boolean fDg()
  {
    AppMethodBeat.i(193983);
    if (bt.isNullOrNil(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(193983);
      return false;
    }
    boolean bool = w.An(this.cWM.getTalkerUserName());
    AppMethodBeat.o(193983);
    return bool;
  }
  
  private void mm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193981);
    com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.jDl });
    AppMethodBeat.o(193981);
  }
  
  public final void adh(int paramInt)
  {
    AppMethodBeat.i(193980);
    if (!fDg())
    {
      AppMethodBeat.o(193980);
      return;
    }
    this.JHr.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(193980);
  }
  
  public final void fDf()
  {
    AppMethodBeat.i(193979);
    if (!fDg())
    {
      AppMethodBeat.o(193979);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(193979);
  }
  
  public final void fws()
  {
    AppMethodBeat.i(193974);
    super.fws();
    if (!fDg())
    {
      AppMethodBeat.o(193974);
      return;
    }
    com.tencent.mm.kernel.g.ajA();
    this.qjh = com.tencent.mm.kernel.a.getUin();
    this.JHo = bt.HI();
    this.JHn = System.currentTimeMillis();
    this.JHp = 0L;
    this.JHq = 0;
    this.JHr.clear();
    AppMethodBeat.o(193974);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(193973);
    super.fwt();
    if (!fDg())
    {
      AppMethodBeat.o(193973);
      return;
    }
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqm("appbrand_notify_message") >= 2)
    {
      localObject = ((k)this.cWM.bh(k.class)).ada(0);
      if ((localObject != null) && (((ei)localObject).field_isSend == 2)) {
        ((k)this.cWM.bh(k.class)).adc(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.jDl = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aYA();
      localObject = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aYB();
      i = ((g.a)localObject).djY;
      j = ((g.a)localObject).mwr;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, bt.HI(), j);
      AppMethodBeat.o(193973);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(193975);
    super.fwv();
    if (!fDg())
    {
      AppMethodBeat.o(193975);
      return;
    }
    this.JHo = bt.HI();
    com.tencent.mm.sdk.b.a.IbL.c(this.mAa);
    AppMethodBeat.o(193975);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(193976);
    super.fww();
    if (!fDg())
    {
      AppMethodBeat.o(193976);
      return;
    }
    this.JHp += bt.aO(this.JHo) / 1000L;
    com.tencent.mm.sdk.b.a.IbL.d(this.mAa);
    AppMethodBeat.o(193976);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(193977);
    super.fwy();
    if (!fDg())
    {
      AppMethodBeat.o(193977);
      return;
    }
    this.JHp += bt.aO(this.JHo) / 1000L;
    a(8, this.JHp, this.JHr.size(), com.tencent.mm.ai.a.a.yz(com.tencent.mm.ai.a.a.yy(((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().apX("appbrand_notify_message").field_content).title), this.JHq, 0, bt.HI(), 0);
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().ee("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      ad.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.qjh;
      localObject1 = ai.ee(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().ee("appbrand_notify_message", this.JHq);
      if (localObject4 != null) {
        break label573;
      }
      ad.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
    }
    label573:
    StringBuilder localStringBuilder;
    for (;;)
    {
      for (;;)
      {
        this.JHr.clear();
        this.jDl = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)localObject1).clear();
        }
        AppMethodBeat.o(193977);
        return;
        i = 1;
        try
        {
          while (((Cursor)localObject1).moveToNext())
          {
            bu localbu = new bu();
            localbu.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.ai.a.a.yy(localbu.field_content);
            if (localbu.field_isSend == 2)
            {
              i += 1;
            }
            else
            {
              if (((this.JHn > bt.aRf(localbu.dHv)) && (this.JHn - bt.aRf(localbu.dHv) <= 60000L)) || ((bt.aRf(localbu.dHv) > this.JHn) && (this.JHp >= 3L)))
              {
                ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.ai.a.a)localObject4).msgId });
                com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.ai.a.a)localObject4).appId, null, null, ((com.tencent.mm.ai.a.a)localObject4).msgId, Integer.valueOf(0), null, com.tencent.mm.ai.a.a.yz(((com.tencent.mm.ai.a.a)localObject4).title), Integer.valueOf(1), null, null, this.jDl });
              }
              i += 1;
            }
          }
          ((Cursor)localObject1).close();
          break;
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(193977);
        }
      }
      localStringBuilder = new StringBuilder();
      i = 0;
      int j = 0;
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          Object localObject6 = new bu();
          ((bu)localObject6).convertFrom((Cursor)localObject4);
          Object localObject5 = com.tencent.mm.ai.a.a.yy(((ei)localObject6).field_content);
          if (((ei)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.ai.a.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.ai.a.a)localObject5).msgId;
            j += 1;
            localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (localStringBuilder.length() > 5000)
            {
              ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              localStringBuilder.setLength(localStringBuilder.length() - 1);
              mm((String)localObject1, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
              i = 1;
            }
          }
        }
        ((Cursor)localObject4).close();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.setLength(localStringBuilder.length() - 1);
        }
        if (bt.isNullOrNil(localStringBuilder.toString().trim())) {
          ad.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(193977);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      mm(str1, localStringBuilder.toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(193978);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!fDg())
    {
      AppMethodBeat.o(193978);
      return;
    }
    this.JHq = Math.max(this.JHq, paramInt3 - paramInt1);
    AppMethodBeat.o(193978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.f
 * JD-Core Version:    0.7.0.1
 */