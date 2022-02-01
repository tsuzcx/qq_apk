package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.c.b.i;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.c.b.g
{
  private long HSU;
  private long HSV;
  private long HSW;
  private int HSX;
  private Set<Integer> HSY;
  private String jjx;
  private c<n> mag;
  private int pFC;
  
  public f()
  {
    AppMethodBeat.i(196448);
    this.HSY = new HashSet();
    this.mag = new c() {};
    AppMethodBeat.o(196448);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(196458);
    ac.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jjx });
    AppMethodBeat.o(196458);
  }
  
  private boolean fmM()
  {
    AppMethodBeat.i(196459);
    if (bs.isNullOrNil(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(196459);
      return false;
    }
    boolean bool = w.xq(this.cLy.getTalkerUserName());
    AppMethodBeat.o(196459);
    return bool;
  }
  
  private void lO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196457);
    com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.jjx });
    AppMethodBeat.o(196457);
  }
  
  public final void aaV(int paramInt)
  {
    AppMethodBeat.i(196456);
    if (!fmM())
    {
      AppMethodBeat.o(196456);
      return;
    }
    this.HSY.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(196456);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(196450);
    super.fgg();
    if (!fmM())
    {
      AppMethodBeat.o(196450);
      return;
    }
    com.tencent.mm.kernel.g.agP();
    this.pFC = com.tencent.mm.kernel.a.getUin();
    this.HSV = bs.Gn();
    this.HSU = System.currentTimeMillis();
    this.HSW = 0L;
    this.HSX = 0;
    this.HSY.clear();
    AppMethodBeat.o(196450);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(196449);
    super.fgh();
    if (!fmM())
    {
      AppMethodBeat.o(196449);
      return;
    }
    if (((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().aly("appbrand_notify_message") >= 2)
    {
      localObject = ((i)this.cLy.bf(i.class)).aaP(0);
      if ((localObject != null) && (((dy)localObject).field_isSend == 2)) {
        ((i)this.cLy.bf(i.class)).aaR(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.jjx = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aVg();
      localObject = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aVh();
      i = ((g.a)localObject).cYG;
      j = ((g.a)localObject).lWC;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, bs.Gn(), j);
      AppMethodBeat.o(196449);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(196451);
    super.fgj();
    if (!fmM())
    {
      AppMethodBeat.o(196451);
      return;
    }
    this.HSV = bs.Gn();
    com.tencent.mm.sdk.b.a.GpY.c(this.mag);
    AppMethodBeat.o(196451);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(196452);
    super.fgk();
    if (!fmM())
    {
      AppMethodBeat.o(196452);
      return;
    }
    this.HSW += bs.aO(this.HSV) / 1000L;
    com.tencent.mm.sdk.b.a.GpY.d(this.mag);
    AppMethodBeat.o(196452);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(196453);
    super.fgm();
    if (!fmM())
    {
      AppMethodBeat.o(196453);
      return;
    }
    this.HSW += bs.aO(this.HSV) / 1000L;
    a(8, this.HSW, this.HSY.size(), com.tencent.mm.ah.a.a.vI(com.tencent.mm.ah.a.a.vH(((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alk("appbrand_notify_message").field_content).title), this.HSX, 0, bs.Gn(), 0);
    Object localObject1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().dN("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      ac.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.pFC;
      localObject1 = ah.dg(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().dN("appbrand_notify_message", this.HSX);
      if (localObject4 != null) {
        break label565;
      }
      ac.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
    }
    label565:
    StringBuilder localStringBuilder;
    for (;;)
    {
      for (;;)
      {
        this.HSY.clear();
        this.jjx = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)localObject1).clear();
        }
        AppMethodBeat.o(196453);
        return;
        i = 1;
        try
        {
          while (((Cursor)localObject1).moveToNext())
          {
            bo localbo = new bo();
            localbo.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.ah.a.a.vH(localbo.field_content);
            if (localbo.field_isSend == 2)
            {
              i += 1;
            }
            else
            {
              if (((this.HSU > bs.aLz(localbo.dvs)) && (this.HSU - bs.aLz(localbo.dvs) <= 60000L)) || ((bs.aLz(localbo.dvs) > this.HSU) && (this.HSW >= 3L)))
              {
                ac.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.ah.a.a)localObject4).dtG });
                com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.ah.a.a)localObject4).appId, null, null, ((com.tencent.mm.ah.a.a)localObject4).dtG, Integer.valueOf(0), null, com.tencent.mm.ah.a.a.vI(((com.tencent.mm.ah.a.a)localObject4).title), Integer.valueOf(1), null, null });
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
          AppMethodBeat.o(196453);
        }
      }
      localStringBuilder = new StringBuilder();
      i = 0;
      int j = 0;
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          Object localObject6 = new bo();
          ((bo)localObject6).convertFrom((Cursor)localObject4);
          Object localObject5 = com.tencent.mm.ah.a.a.vH(((dy)localObject6).field_content);
          if (((dy)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.ah.a.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.ah.a.a)localObject5).dtG;
            j += 1;
            localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (localStringBuilder.length() > 5000)
            {
              ac.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              localStringBuilder.setLength(localStringBuilder.length() - 1);
              lO((String)localObject1, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
              i = 1;
            }
          }
        }
        ((Cursor)localObject4).close();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.setLength(localStringBuilder.length() - 1);
        }
        if (bs.isNullOrNil(localStringBuilder.toString().trim())) {
          ac.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(196453);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      lO(str1, localStringBuilder.toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void fmL()
  {
    AppMethodBeat.i(196455);
    if (!fmM())
    {
      AppMethodBeat.o(196455);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(196455);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(196454);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!fmM())
    {
      AppMethodBeat.o(196454);
      return;
    }
    this.HSX = Math.max(this.HSX, paramInt3 - paramInt1);
    AppMethodBeat.o(196454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.f
 * JD-Core Version:    0.7.0.1
 */