package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.p;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.d.b.g
{
  private long WHM;
  private long WHN;
  private long WHO;
  private int WHP;
  private Set<Integer> WHQ;
  private String nBW;
  private IListener<p> qTt;
  private int vmC;
  
  public f()
  {
    AppMethodBeat.i(273387);
    this.WHQ = new HashSet();
    this.qTt = new IListener() {};
    AppMethodBeat.o(273387);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(273401);
    Log.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.nBW });
    AppMethodBeat.o(273401);
  }
  
  private boolean hOE()
  {
    AppMethodBeat.i(273402);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(273402);
      return false;
    }
    boolean bool = ab.QV(this.fgR.getTalkerUserName());
    AppMethodBeat.o(273402);
    return bool;
  }
  
  private void ob(String paramString1, String paramString2)
  {
    AppMethodBeat.i(273399);
    com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.nBW });
    AppMethodBeat.o(273399);
  }
  
  public final void avA(int paramInt)
  {
    AppMethodBeat.i(273398);
    if (!hOE())
    {
      AppMethodBeat.o(273398);
      return;
    }
    this.WHQ.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(273398);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(273390);
    super.hGU();
    if (!hOE())
    {
      AppMethodBeat.o(273390);
      return;
    }
    com.tencent.mm.kernel.h.aHE();
    this.vmC = b.getUin();
    this.WHN = Util.currentTicks();
    this.WHM = System.currentTimeMillis();
    this.WHO = 0L;
    this.WHP = 0;
    this.WHQ.clear();
    AppMethodBeat.o(273390);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(273389);
    super.hGV();
    if (!hOE())
    {
      AppMethodBeat.o(273389);
      return;
    }
    if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOW("appbrand_notify_message") >= 2)
    {
      localObject = ((k)this.fgR.bC(k.class)).avt(0);
      if ((localObject != null) && (((et)localObject).field_isSend == 2)) {
        ((k)this.fgR.bC(k.class)).avv(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.nBW = ((com.tencent.mm.plugin.appbrand.service.g)localObject).bFl();
      localObject = ((com.tencent.mm.plugin.appbrand.service.g)localObject).bFm();
      i = ((g.a)localObject).fuP;
      j = ((g.a)localObject).qOK;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, Util.currentTicks(), j);
      AppMethodBeat.o(273389);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(273391);
    super.hGX();
    if (!hOE())
    {
      AppMethodBeat.o(273391);
      return;
    }
    this.WHN = Util.currentTicks();
    EventCenter.instance.addListener(this.qTt);
    AppMethodBeat.o(273391);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(273393);
    super.hGY();
    if (!hOE())
    {
      AppMethodBeat.o(273393);
      return;
    }
    this.WHO += Util.ticksToNow(this.WHN) / 1000L;
    EventCenter.instance.removeListener(this.qTt);
    AppMethodBeat.o(273393);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(273395);
    super.hHa();
    if (!hOE())
    {
      AppMethodBeat.o(273395);
      return;
    }
    this.WHO += Util.ticksToNow(this.WHN) / 1000L;
    a(8, this.WHO, this.WHQ.size(), com.tencent.mm.aj.b.a.OZ(com.tencent.mm.aj.b.a.OY(((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH("appbrand_notify_message").field_content).title), this.WHP, 0, Util.currentTicks(), 0);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().fa("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.vmC;
      localObject1 = MD5Util.getMD5String(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().fa("appbrand_notify_message", this.WHP);
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
        this.WHQ.clear();
        this.nBW = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)localObject1).clear();
        }
        AppMethodBeat.o(273395);
        return;
        i = 1;
        try
        {
          while (((Cursor)localObject1).moveToNext())
          {
            ca localca = new ca();
            localca.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.aj.b.a.OY(localca.field_content);
            if (localca.field_isSend == 2)
            {
              i += 1;
            }
            else
            {
              if (((this.WHM > Util.safeParseLong(localca.fUk)) && (this.WHM - Util.safeParseLong(localca.fUk) <= 60000L)) || ((Util.safeParseLong(localca.fUk) > this.WHM) && (this.WHO >= 3L)))
              {
                Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.aj.b.a)localObject4).msgId });
                com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.aj.b.a)localObject4).appId, null, null, ((com.tencent.mm.aj.b.a)localObject4).msgId, Integer.valueOf(0), null, com.tencent.mm.aj.b.a.OZ(((com.tencent.mm.aj.b.a)localObject4).title), Integer.valueOf(1), null, null, this.nBW });
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
          AppMethodBeat.o(273395);
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
          Object localObject5 = com.tencent.mm.aj.b.a.OY(((et)localObject6).field_content);
          if (((et)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.aj.b.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.aj.b.a)localObject5).msgId;
            j += 1;
            localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (localStringBuilder.length() > 5000)
            {
              Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              localStringBuilder.setLength(localStringBuilder.length() - 1);
              ob((String)localObject1, localStringBuilder.toString());
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
        AppMethodBeat.o(273395);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      ob(str1, localStringBuilder.toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void hOD()
  {
    AppMethodBeat.i(273397);
    if (!hOE())
    {
      AppMethodBeat.o(273397);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(273397);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(273396);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!hOE())
    {
      AppMethodBeat.o(273396);
      return;
    }
    this.WHP = Math.max(this.WHP, paramInt3 - paramInt1);
    AppMethodBeat.o(273396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.f
 * JD-Core Version:    0.7.0.1
 */