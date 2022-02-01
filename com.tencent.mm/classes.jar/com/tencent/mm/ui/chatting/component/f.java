package com.tencent.mm.ui.chatting.component;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.r;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.service.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.component.api.m;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.h.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.component.api.h
{
  private long aepS;
  private long aepT;
  private long aepU;
  private int aepV;
  private Set<Integer> aepW;
  private String qBl;
  private IListener<r> tYk;
  private int yze;
  
  public f()
  {
    AppMethodBeat.i(256076);
    this.aepW = new HashSet();
    this.tYk = new ChattingAppBrandNotifyComponent.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(256076);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(256088);
    Log.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.qBl });
    AppMethodBeat.o(256088);
  }
  
  private boolean jrv()
  {
    AppMethodBeat.i(256089);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(256089);
      return false;
    }
    boolean bool = au.bwA(this.hlc.getTalkerUserName());
    AppMethodBeat.o(256089);
    return bool;
  }
  
  private void pZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256082);
    com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.qBl });
    AppMethodBeat.o(256082);
  }
  
  public final void aCc(int paramInt)
  {
    AppMethodBeat.i(256131);
    if (!jrv())
    {
      AppMethodBeat.o(256131);
      return;
    }
    this.aepW.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(256131);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(256098);
    super.jjf();
    if (!jrv())
    {
      AppMethodBeat.o(256098);
      return;
    }
    com.tencent.mm.kernel.h.baC();
    this.yze = b.getUin();
    this.aepT = Util.currentTicks();
    this.aepS = System.currentTimeMillis();
    this.aepU = 0L;
    this.aepV = 0;
    this.aepW.clear();
    AppMethodBeat.o(256098);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256092);
    super.jjg();
    if (!jrv())
    {
      AppMethodBeat.o(256092);
      return;
    }
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLW("appbrand_notify_message") >= 2)
    {
      localObject = ((m)this.hlc.cm(m.class)).aBV(0);
      if ((localObject != null) && (((fi)localObject).field_isSend == 2)) {
        ((m)this.hlc.cm(m.class)).aBX(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.qBl = ((com.tencent.mm.plugin.appbrand.service.h)localObject).cez();
      localObject = ((com.tencent.mm.plugin.appbrand.service.h)localObject).ceA();
      i = ((h.a)localObject).hzj;
      j = ((h.a)localObject).tTy;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, Util.currentTicks(), j);
      AppMethodBeat.o(256092);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256100);
    super.jji();
    if (!jrv())
    {
      AppMethodBeat.o(256100);
      return;
    }
    this.aepT = Util.currentTicks();
    this.tYk.alive();
    AppMethodBeat.o(256100);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256104);
    super.jjj();
    if (!jrv())
    {
      AppMethodBeat.o(256104);
      return;
    }
    this.aepU += Util.ticksToNow(this.aepT) / 1000L;
    this.tYk.dead();
    AppMethodBeat.o(256104);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256115);
    super.jjl();
    if (!jrv())
    {
      AppMethodBeat.o(256115);
      return;
    }
    this.aepU += Util.ticksToNow(this.aepT) / 1000L;
    a(8, this.aepU, this.aepW.size(), com.tencent.mm.message.c.a.Hs(com.tencent.mm.message.c.a.Hr(((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLG("appbrand_notify_message").field_content).title), this.aepV, 0, Util.currentTicks(), 0);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().fT("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.yze;
      localObject1 = MD5Util.getMD5String(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().fT("appbrand_notify_message", this.aepV);
      if (localObject4 == null)
      {
        Log.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
        label209:
        this.aepW.clear();
        this.qBl = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.h)localObject1).clear();
        }
        AppMethodBeat.o(256115);
      }
    }
    else
    {
      i = 1;
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      for (;;)
      {
        try
        {
          if (((Cursor)localObject1).moveToNext())
          {
            cc localcc = new cc();
            localcc.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.message.c.a.Hr(localcc.field_content);
            if ((localcc.field_isSend == 2) || (localObject4 == null)) {
              break label843;
            }
            if (((this.aepS > Util.safeParseLong(localcc.iah)) && (this.aepS - Util.safeParseLong(localcc.iah) <= 60000L)) || ((Util.safeParseLong(localcc.iah) > this.aepS) && (this.aepU >= 3L)))
            {
              Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.message.c.a)localObject4).msgId });
              com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.message.c.a)localObject4).appId, null, null, ((com.tencent.mm.message.c.a)localObject4).msgId, Integer.valueOf(0), null, com.tencent.mm.message.c.a.Hs(((com.tencent.mm.message.c.a)localObject4).title), Integer.valueOf(1), null, null, this.qBl });
            }
            i += 1;
            continue;
          }
          ((Cursor)localObject1).close();
          break;
        }
        finally
        {
          ((Cursor)localObject1).close();
          AppMethodBeat.o(256115);
        }
        localStringBuilder = new StringBuilder();
        i = 0;
        int j = 0;
        try
        {
          while (((Cursor)localObject4).moveToNext())
          {
            Object localObject6 = new cc();
            ((cc)localObject6).convertFrom((Cursor)localObject4);
            Object localObject5 = com.tencent.mm.message.c.a.Hr(((fi)localObject6).field_content);
            if ((((fi)localObject6).field_isSend != 2) && (localObject5 != null))
            {
              localObject6 = Locale.US;
              String str2 = ((com.tencent.mm.message.c.a)localObject5).appId;
              localObject5 = ((com.tencent.mm.message.c.a)localObject5).msgId;
              j += 1;
              localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
              if (localStringBuilder.length() > 5000)
              {
                Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
                localStringBuilder.setLength(localStringBuilder.length() - 1);
                pZ((String)localObject1, localStringBuilder.toString());
                localStringBuilder.delete(0, localStringBuilder.length());
                i = 1;
              }
            }
          }
          ((Cursor)localObject4).close();
          if (localStringBuilder.length() > 0) {
            localStringBuilder.setLength(localStringBuilder.length() - 1);
          }
          if (Util.isNullOrNil(localStringBuilder.toString().trim()))
          {
            Log.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
            break label209;
          }
        }
        finally
        {
          ((Cursor)localObject4).close();
          AppMethodBeat.o(256115);
        }
      }
      if (i != 0) {}
      for (;;)
      {
        pZ(str1, localStringBuilder.toString());
        break;
        Object localObject2 = null;
      }
      label843:
      i += 1;
    }
  }
  
  public final void jru()
  {
    AppMethodBeat.i(256124);
    if (!jrv())
    {
      AppMethodBeat.o(256124);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(256124);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256120);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!jrv())
    {
      AppMethodBeat.o(256120);
      return;
    }
    this.aepV = Math.max(this.aepV, paramInt3 - paramInt1);
    AppMethodBeat.o(256120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.f
 * JD-Core Version:    0.7.0.1
 */