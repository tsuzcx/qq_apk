package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "officialAccountShow", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellExposeHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class t
{
  static volatile boolean IIw;
  private static Boolean IIx;
  static long IIy;
  public static final t IIz;
  
  static
  {
    AppMethodBeat.i(188833);
    IIz = new t();
    IIy = -1L;
    AppMethodBeat.o(188833);
  }
  
  static void a(ay paramay, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188832);
    String str = String.valueOf(paramLong1);
    paramLong1 = paramay.decodeLong(aTU(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = paramay.decodeLong(aTV(str), 0L) + paramLong2 - paramLong1;
      paramay.encode(aTV(str), paramLong1);
      ae.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(188832);
  }
  
  public static void aS(String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(188828);
    h.MqF.f((Runnable)new a(paramString, paramInt2, paramInt1), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(188828);
  }
  
  public static String aTU(String paramString)
  {
    AppMethodBeat.i(188823);
    d.g.b.p.h(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(188823);
    return paramString;
  }
  
  public static String aTV(String paramString)
  {
    AppMethodBeat.i(188824);
    d.g.b.p.h(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(188824);
    return paramString;
  }
  
  public static String aTW(String paramString)
  {
    AppMethodBeat.i(188825);
    d.g.b.p.h(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(188825);
    return paramString;
  }
  
  public static String aTX(String paramString)
  {
    AppMethodBeat.i(188826);
    d.g.b.p.h(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(188826);
    return paramString;
  }
  
  public static void aTY(String paramString)
  {
    AppMethodBeat.i(188829);
    h.MqF.f((Runnable)new t.b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(188829);
  }
  
  private static void d(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(188830);
    if (!IIw)
    {
      AppMethodBeat.o(188830);
      return;
    }
    IIw = false;
    long l2 = System.currentTimeMillis();
    Object localObject = ay.aRX("brandService");
    if (paramLong != 0L) {}
    for (long l1 = paramLong; l1 == 0L; l1 = ((ay)localObject).decodeLong("BizLastMsgId"))
    {
      AppMethodBeat.o(188830);
      return;
    }
    paramLong = 0L;
    int i = 0;
    int j = ab.fxj();
    w localw;
    if (l1 > 0L) {
      try
      {
        localw = ag.aGv().DM(l1);
        if (localw == null)
        {
          AppMethodBeat.o(188830);
          return;
        }
      }
      catch (Exception paramString)
      {
        ae.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(188830);
        return;
      }
    }
    for (;;)
    {
      if (localw.fta())
      {
        localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(localw.field_msgId, localw.field_content);
        if ((localObject == null) || (bu.ht((List)((u)localObject).hFT))) {
          break label489;
        }
        localObject = (v)((u)localObject).hFT.get(0);
        if (bu.isNullOrNil(((v)localObject).url)) {
          break label489;
        }
      }
      label489:
      for (paramLong = bu.getLong(Uri.parse(((v)localObject).url).getQueryParameter("mid"), 0L);; paramLong = 0L)
      {
        localObject = localw.field_talker;
        d.g.b.p.g(localObject, "info.field_talker");
        for (;;)
        {
          ay localay = (ay)com.tencent.mm.al.c.hSB.fnP();
          l1 = localay.decodeLong(aTU(String.valueOf(l1)), 0L);
          a(localay, localw.field_msgId, l2);
          com.tencent.mm.plugin.report.service.g.yxI.f(18218, new Object[] { Integer.valueOf((int)(l2 / 1000L)), localObject, Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j) });
          ae.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { localObject, Long.valueOf(paramLong), Long.valueOf(l1) });
          AppMethodBeat.o(188830);
          return;
          localw = ag.aGw().DM(l1);
          if (localw != null) {
            break;
          }
          AppMethodBeat.o(188830);
          return;
          if (localw.fte())
          {
            localObject = ab.v(localw);
            i = ab.d(localw);
          }
          else
          {
            localObject = "";
          }
        }
      }
    }
  }
  
  public static boolean fsT()
  {
    AppMethodBeat.i(188827);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG) || (bv.fpT()))
    {
      AppMethodBeat.o(188827);
      return true;
    }
    Boolean localBoolean;
    if (IIx != null)
    {
      localBoolean = IIx;
      if (localBoolean == null) {
        d.g.b.p.gkB();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(188827);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBn, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      IIx = Boolean.valueOf(bool);
      ae.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + IIx);
      localBoolean = IIx;
      if (localBoolean == null) {
        d.g.b.p.gkB();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(188827);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(188821);
      long l3 = System.currentTimeMillis();
      long l4 = ay.aRX("brandService").decodeLong("BizLastMsgId");
      if (l4 == 0L)
      {
        AppMethodBeat.o(188821);
        return;
      }
      Object localObject1 = t.IIz;
      if (t.fsU())
      {
        localObject1 = t.IIz;
        if (l4 == t.fsW())
        {
          AppMethodBeat.o(188821);
          return;
        }
      }
      ay localay = (ay)com.tencent.mm.al.c.hSB.fnP();
      localObject1 = t.IIz;
      if (t.fsU())
      {
        localObject1 = t.IIz;
        if (t.fsW() != 0L)
        {
          localObject1 = t.IIz;
          localObject1 = t.IIz;
          t.ci("", t.fsW());
        }
      }
      localObject1 = t.IIz;
      t.DK(l4);
      localObject1 = t.IIz;
      t.fsV();
      if (localay.decodeInt(String.valueOf(l4), 0) == 1) {}
      long l2;
      int j;
      int n;
      String str;
      int i;
      for (int k = 0;; k = 1)
      {
        l2 = 0L;
        j = 0;
        n = ab.fxj();
        str = this.goz;
        i = paramInt2;
        localObject1 = "";
        if (l4 <= 0L) {
          break;
        }
        try
        {
          localObject4 = ag.aGv().DM(l4);
          localObject3 = localObject4;
          if (localObject4 != null) {
            break label268;
          }
          AppMethodBeat.o(188821);
          return;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(188821);
          return;
        }
      }
      Object localObject4 = ag.aGw().DM(l4);
      Object localObject3 = localObject4;
      if (localObject4 == null)
      {
        AppMethodBeat.o(188821);
        return;
      }
      label268:
      Object localObject2;
      long l1;
      if (((w)localObject3).fta())
      {
        localObject2 = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(((w)localObject3).field_msgId, ((w)localObject3).field_content);
        l1 = l2;
        if (localObject2 != null)
        {
          l1 = l2;
          if (!bu.ht((List)((u)localObject2).hFT))
          {
            localObject2 = (v)((u)localObject2).hFT.get(0);
            l1 = l2;
            if (!bu.isNullOrNil(((v)localObject2).url)) {
              l1 = bu.getLong(Uri.parse(((v)localObject2).url).getQueryParameter("mid"), 0L);
            }
          }
        }
        localObject2 = ((w)localObject3).field_talker;
        d.g.b.p.g(localObject2, "info.field_talker");
        j = 0;
        localObject3 = String.valueOf(l4);
        localay.encode((String)localObject3, 1);
        localObject4 = t.IIz;
        localay.encode(t.aTU((String)localObject3), l3);
        localObject4 = t.IIz;
        localObject4 = t.aTW((String)localObject3);
        t localt = t.IIz;
        localay.encode((String)localObject4, localay.decodeInt(t.aTW((String)localObject3), 0) + 1);
        localObject4 = t.IIz;
        localObject4 = t.aTX((String)localObject3);
        localt = t.IIz;
        localay.encode((String)localObject4, Math.min(localay.decodeInt(t.aTX((String)localObject3), paramInt1), paramInt1));
        str = com.tencent.mm.pluginsdk.ui.tools.x.aPc(str);
        if (k == 1)
        {
          localObject3 = com.tencent.mm.pluginsdk.c.Fbx;
          boolean bool = com.tencent.mm.pluginsdk.c.bOc().getBoolean("biz_time_preload_at_biz_box_expose", false);
          ae.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            localObject3 = com.tencent.mm.pluginsdk.c.Fbx;
            com.tencent.mm.pluginsdk.c.fcB();
          }
        }
        p.IIi.abj(2);
        if ((p.IIf) || (!p.fsK()))
        {
          ae.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + p.IIf + ", canvasPreloadOpen=" + p.fsK());
          com.tencent.mm.plugin.report.service.g.yxI.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), localObject2, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramInt1), str, Integer.valueOf(i), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(n) });
          ae.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCountReport %d, currentTime %d", new Object[] { localObject2, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(i), Long.valueOf(l3) });
          AppMethodBeat.o(188821);
        }
      }
      else
      {
        if (!((w)localObject3).fte()) {
          break label1040;
        }
        localObject2 = ab.v((w)localObject3);
        j = ab.d((w)localObject3);
        str = ab.u((w)localObject3);
        i = ag.aGw().bVY();
        ae.v("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose dyeing template bizUsername = " + (String)localObject2 + ", msgType = " + j);
        break label1040;
      }
      p.IIf = true;
      localObject3 = com.tencent.mm.plugin.webcanvas.g.DQG;
      com.tencent.mm.plugin.webcanvas.g.CH(14L);
      localObject3 = com.tencent.mm.plugin.biz.b.b.nUB;
      int i1 = com.tencent.mm.plugin.biz.b.b.bNw().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
      if ((!j.DEBUG) && (!j.IS_FLAVOR_RED)) {
        if (bv.fpT()) {
          break label1047;
        }
      }
      for (;;)
      {
        label938:
        localObject3 = com.tencent.mm.plugin.biz.b.b.nUB;
        if (m != 0)
        {
          l2 = 0L;
          label951:
          if (!com.tencent.mm.plugin.biz.b.b.a(i1, l2, "biz_canvas_card_expose_preload_last_time", 11L)) {
            break label1030;
          }
          localObject3 = h.MqF;
          localObject4 = (Runnable)new p.e(i1);
          if (System.currentTimeMillis() - PluginBiz.startTime <= 20000L) {
            break label1032;
          }
        }
        label1030:
        label1032:
        for (l2 = 0L;; l2 = 10000L)
        {
          ((i)localObject3).r((Runnable)localObject4, l2);
          break;
          m = 0;
          break label938;
          l2 = 600000L;
          break label951;
          break;
        }
        label1040:
        l1 = l2;
        break;
        label1047:
        int m = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */