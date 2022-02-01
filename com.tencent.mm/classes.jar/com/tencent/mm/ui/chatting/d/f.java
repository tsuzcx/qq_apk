package com.tencent.mm.ui.chatting.d;

import android.database.Cursor;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.n;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.service.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.d.b.k;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.g.class)
public class f
  extends a
  implements com.tencent.mm.ui.chatting.d.b.g
{
  private long Kce;
  private long Kcf;
  private long Kcg;
  private int Kch;
  private Set<Integer> Kci;
  private String jGj;
  private c<n> mFa;
  private int qpM;
  
  public f()
  {
    AppMethodBeat.i(187279);
    this.Kci = new HashSet();
    this.mFa = new c() {};
    AppMethodBeat.o(187279);
  }
  
  private void a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, int paramInt4, long paramLong2, int paramInt5)
  {
    AppMethodBeat.i(187289);
    ae.d("MicroMsg.ChattingAppBrandNotifyReportComponent", "report notify operate, eventId:%d, stayDuration:%d, opCount:%d, LastMsgContent:%s, readCount:%d, unreadCount:%d, timeStamp:%d, indexInSessionList:%d, appId:%s, pagePath:%s, label:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Long.valueOf(paramLong2), Integer.valueOf(paramInt5), null, null, null });
    com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Integer.valueOf(0), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, this.jGj });
    AppMethodBeat.o(187289);
  }
  
  private boolean fHi()
  {
    AppMethodBeat.i(187290);
    if (bu.isNullOrNil(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(187290);
      return false;
    }
    boolean bool = x.AX(this.cXJ.getTalkerUserName());
    AppMethodBeat.o(187290);
    return bool;
  }
  
  private void mt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187288);
    com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), paramString2, paramString1, this.jGj });
    AppMethodBeat.o(187288);
  }
  
  public final void adO(int paramInt)
  {
    AppMethodBeat.i(187287);
    if (!fHi())
    {
      AppMethodBeat.o(187287);
      return;
    }
    this.Kci.add(Integer.valueOf(Math.max(0, paramInt)));
    AppMethodBeat.o(187287);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(187281);
    super.fAs();
    if (!fHi())
    {
      AppMethodBeat.o(187281);
      return;
    }
    com.tencent.mm.kernel.g.ajP();
    this.qpM = com.tencent.mm.kernel.a.getUin();
    this.Kcf = bu.HQ();
    this.Kce = System.currentTimeMillis();
    this.Kcg = 0L;
    this.Kch = 0;
    this.Kci.clear();
    AppMethodBeat.o(187281);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(187280);
    super.fAt();
    if (!fHi())
    {
      AppMethodBeat.o(187280);
      return;
    }
    if (((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arr("appbrand_notify_message") >= 2)
    {
      localObject = ((k)this.cXJ.bh(k.class)).adI(0);
      if ((localObject != null) && (((ei)localObject).field_isSend == 2)) {
        ((k)this.cXJ.bh(k.class)).adK(1);
      }
    }
    Object localObject = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
    int i;
    int j;
    if (localObject != null)
    {
      this.jGj = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aYW();
      localObject = ((com.tencent.mm.plugin.appbrand.service.g)localObject).aYX();
      i = ((g.a)localObject).dla;
      j = ((g.a)localObject).mBo;
    }
    for (;;)
    {
      a(1, 0L, 0, null, 0, i, bu.HQ(), j);
      AppMethodBeat.o(187280);
      return;
      j = 0;
      i = 0;
    }
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(187282);
    super.fAv();
    if (!fHi())
    {
      AppMethodBeat.o(187282);
      return;
    }
    this.Kcf = bu.HQ();
    com.tencent.mm.sdk.b.a.IvT.c(this.mFa);
    AppMethodBeat.o(187282);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(187283);
    super.fAw();
    if (!fHi())
    {
      AppMethodBeat.o(187283);
      return;
    }
    this.Kcg += bu.aO(this.Kcf) / 1000L;
    com.tencent.mm.sdk.b.a.IvT.d(this.mFa);
    AppMethodBeat.o(187283);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(187284);
    super.fAy();
    if (!fHi())
    {
      AppMethodBeat.o(187284);
      return;
    }
    this.Kcg += bu.aO(this.Kcf) / 1000L;
    a(8, this.Kcg, this.Kci.size(), com.tencent.mm.ah.a.a.zj(com.tencent.mm.ah.a.a.zi(((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().arc("appbrand_notify_message").field_content).title), this.Kch, 0, bu.HQ(), 0);
    Object localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().el("appbrand_notify_message", -1);
    int i;
    Object localObject4;
    if (localObject1 == null)
    {
      ae.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
      i = this.qpM;
      localObject1 = aj.ej(i + String.valueOf(System.currentTimeMillis()));
      localObject4 = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().el("appbrand_notify_message", this.Kch);
      if (localObject4 != null) {
        break label573;
      }
      ae.e("MicroMsg.ChattingAppBrandNotifyReportComponent", "[buildShowReportParams] cursor is null!");
    }
    label573:
    StringBuilder localStringBuilder;
    for (;;)
    {
      for (;;)
      {
        this.Kci.clear();
        this.jGj = null;
        localObject1 = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)localObject1).clear();
        }
        AppMethodBeat.o(187284);
        return;
        i = 1;
        try
        {
          while (((Cursor)localObject1).moveToNext())
          {
            bv localbv = new bv();
            localbv.convertFrom((Cursor)localObject1);
            localObject4 = com.tencent.mm.ah.a.a.zi(localbv.field_content);
            if (localbv.field_isSend == 2)
            {
              i += 1;
            }
            else
            {
              if (((this.Kce > bu.aSC(localbv.dIA)) && (this.Kce - bu.aSC(localbv.dIA) <= 60000L)) || ((bu.aSC(localbv.dIA) > this.Kce) && (this.Kcg >= 3L)))
              {
                ae.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "report in time event, msgId:%s", new Object[] { ((com.tencent.mm.ah.a.a)localObject4).msgId });
                com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), ((com.tencent.mm.ah.a.a)localObject4).appId, null, null, ((com.tencent.mm.ah.a.a)localObject4).msgId, Integer.valueOf(0), null, com.tencent.mm.ah.a.a.zj(((com.tencent.mm.ah.a.a)localObject4).title), Integer.valueOf(1), null, null, this.jGj });
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
          AppMethodBeat.o(187284);
        }
      }
      localStringBuilder = new StringBuilder();
      i = 0;
      int j = 0;
      try
      {
        while (((Cursor)localObject4).moveToNext())
        {
          Object localObject6 = new bv();
          ((bv)localObject6).convertFrom((Cursor)localObject4);
          Object localObject5 = com.tencent.mm.ah.a.a.zi(((ei)localObject6).field_content);
          if (((ei)localObject6).field_isSend != 2)
          {
            localObject6 = Locale.US;
            String str2 = ((com.tencent.mm.ah.a.a)localObject5).appId;
            localObject5 = ((com.tencent.mm.ah.a.a)localObject5).msgId;
            j += 1;
            localStringBuilder.append(String.format((Locale)localObject6, "[%s:%s:%d];", new Object[] { str2, localObject5, Integer.valueOf(j) }));
            if (localStringBuilder.length() > 5000)
            {
              ae.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "cut off exposed message");
              localStringBuilder.setLength(localStringBuilder.length() - 1);
              mt((String)localObject1, localStringBuilder.toString());
              localStringBuilder.delete(0, localStringBuilder.length());
              i = 1;
            }
          }
        }
        ((Cursor)localObject4).close();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.setLength(localStringBuilder.length() - 1);
        }
        if (bu.isNullOrNil(localStringBuilder.toString().trim())) {
          ae.i("MicroMsg.ChattingAppBrandNotifyReportComponent", "empty msg show report content, skip report");
        }
      }
      finally
      {
        ((Cursor)localObject4).close();
        AppMethodBeat.o(187284);
      }
    }
    if (i != 0) {}
    for (;;)
    {
      mt(str1, localStringBuilder.toString());
      break;
      Object localObject2 = null;
    }
  }
  
  public final void fHh()
  {
    AppMethodBeat.i(187286);
    if (!fHi())
    {
      AppMethodBeat.o(187286);
      return;
    }
    a(10, 0L, 0, null, 0, 0, 0L, 0);
    AppMethodBeat.o(187286);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187285);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (!fHi())
    {
      AppMethodBeat.o(187285);
      return;
    }
    this.Kch = Math.max(this.Kch, paramInt3 - paramInt1);
    AppMethodBeat.o(187285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.f
 * JD-Core Version:    0.7.0.1
 */