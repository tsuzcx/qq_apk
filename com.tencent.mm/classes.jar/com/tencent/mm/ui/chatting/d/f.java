package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.d.b.g
{
  private long PnA;
  private long PnB;
  private long PnC;
  private int PnD;
  private Set<Integer> PnE;
  private String kIg;
  private IListener<o> nRQ;
  private int rGT;
  
  public f()
  {
    AppMethodBeat.i(233038);
    this.PnE = new HashSet();
    this.nRQ = new IListener() {};
    AppMethodBeat.o(233038);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(233048);
    Log.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    h.CyF.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.kIg });
    AppMethodBeat.o(233048);
  }
  
  private boolean gPo()
  {
    AppMethodBeat.i(233049);
    if (Util.isNullOrNil(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(233049);
      return false;
    }
    boolean bool = ab.JC(this.dom.getTalkerUserName());
    AppMethodBeat.o(233049);
    return bool;
  }
  
  private void nh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233047);
    h.CyF.a(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.kIg });
    AppMethodBeat.o(233047);
  }
  
  public final void amz(int paramInt)
  {
    AppMethodBeat.i(233046);
    if (!gPo())
    {
      AppMethodBeat.o(233046);
      return;
    }
    this.PnE.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(233046);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(233041);
    super.cFx();
    if (!gPo())
    {
      AppMethodBeat.o(233041);
      return;
    }
    this.PnB = Util.currentTicks();
    EventCenter.instance.addListener(this.nRQ);
    AppMethodBeat.o(233041);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(233042);
    super.cFy();
    if (!gPo())
    {
      AppMethodBeat.o(233042);
      return;
    }
    this.PnC += Util.ticksToNow(this.PnB) / 1000L;
    EventCenter.instance.removeListener(this.nRQ);
    AppMethodBeat.o(233042);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(233040);
    super.gIk();
    if (!gPo())
    {
      AppMethodBeat.o(233040);
      return;
    }
    com.tencent.mm.kernel.g.aAf();
    this.rGT = com.tencent.mm.kernel.a.getUin();
    this.PnB = Util.currentTicks();
    this.PnA = System.currentTimeMillis();
    this.PnC = 0L;
    this.PnD = 0;
    this.PnE.clear();
    AppMethodBeat.o(233040);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(233039);
    super.gIl();
    if (!gPo())
    {
      AppMethodBeat.o(233039);
      return;
    }
    if (((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEM("appbrand_notify_message") >= 2)
    {
      localObject = ((k)this.dom.bh(k.class)).amt(0);
      if ((localObject != null) && (((eo)localObject).field_isSend == 2)) {
        ((k)this.dom.bh(k.class)).amv(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.kIg = ((com.tencent.mm.plugin.appbrand.service.g)localObject).bul();
      localObject = ((com.tencent.mm.plugin.appbrand.service.g)localObject).bum();
      i = ((g.a)localObject).dCm;
      j = ((g.a)localObject).nMs;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, Util.currentTicks(), j);
      AppMethodBeat.o(233039);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(233043);
    super.gIo();
    if (!gPo())
    {
      AppMethodBeat.o(233043);
      return;
    }
    this.PnC += Util.ticksToNow(this.PnB) / 1000L;
    a(8, this.PnC, this.PnE.size(), com.tencent.mm.ag.a.a.HL(com.tencent.mm.ag.a.a.HK(((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aEx("appbrand_notify_message").field_content).title), this.PnD, 0, Util.currentTicks(), 0);
    Object localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().ez("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.rGT;
      localObject1 = MD5Util.getMD5String(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().ez("appbrand_notify_message", this.PnD);
      if (localObject4 != null) {
        break label573;
      }
      Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
    }
    label573:
    StringBuilder localStringBuilder;
    for (;;)
    {
      for (;;)
      {
        this.PnE.clear();
        this.kIg = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)localObject1).clear();
        }
        AppMethodBeat.o(233043);
        return;
        i = 1;
        try
        {
          while (((Cursor)localObject1).moveToNext())
          {
            ca localca = new ca();
            localca.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.ag.a.a.HK(localca.field_content);
            if (localca.field_isSend == 2)
            {
              i += 1;
            }
            else
            {
              if (((this.PnA > Util.safeParseLong(localca.ean)) && (this.PnA - Util.safeParseLong(localca.ean) <= 60000L)) || ((Util.safeParseLong(localca.ean) > this.PnA) && (this.PnC >= 3L)))
              {
                Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.ag.a.a)localObject4).msgId });
                h.CyF.a(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.ag.a.a)localObject4).appId, null, null, ((com.tencent.mm.ag.a.a)localObject4).msgId, Integer.valueOf(0), null, com.tencent.mm.ag.a.a.HL(((com.tencent.mm.ag.a.a)localObject4).title), Integer.valueOf(1), null, null, this.kIg });
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
          AppMethodBeat.o(233043);
        }
      }
      localStringBuilder = new StringBuilder();
      i = 0;
      int j = 0;
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          Object localObject6 = new ca();
          ((ca)localObject6).convertFrom((Cursor)localObject4);
          Object localObject5 = com.tencent.mm.ag.a.a.HK(((eo)localObject6).field_content);
          if (((eo)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.ag.a.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.ag.a.a)localObject5).msgId;
            j += 1;
            localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (localStringBuilder.length() > 5000)
            {
              Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              localStringBuilder.setLength(localStringBuilder.length() - 1);
              nh((String)localObject1, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
              i = 1;
            }
          }
        }
        ((Cursor)localObject4).close();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.setLength(localStringBuilder.length() - 1);
        }
        if (Util.isNullOrNil(localStringBuilder.toString().trim())) {
          Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(233043);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      nh(str1, localStringBuilder.toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void gPn()
  {
    AppMethodBeat.i(233045);
    if (!gPo())
    {
      AppMethodBeat.o(233045);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(233045);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233044);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!gPo())
    {
      AppMethodBeat.o(233044);
      return;
    }
    this.PnD = Math.max(this.PnD, paramInt3 - paramInt1);
    AppMethodBeat.o(233044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.f
 * JD-Core Version:    0.7.0.1
 */