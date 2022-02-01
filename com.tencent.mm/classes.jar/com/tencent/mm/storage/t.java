package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.ag;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "officialAccountShow", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellExposeHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class t
{
  static volatile boolean Iog;
  private static Boolean Ioh;
  static long Ioi;
  public static final t Ioj;
  
  static
  {
    AppMethodBeat.i(207361);
    Ioj = new t();
    Ioi = -1L;
    AppMethodBeat.o(207361);
  }
  
  static void a(ax paramax, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(207360);
    String str = String.valueOf(paramLong1);
    paramLong1 = paramax.decodeLong(aSx(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = paramax.decodeLong(aSy(str), 0L) + paramLong2 - paramLong1;
      paramax.encode(aSy(str), paramLong1);
      ad.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(207360);
  }
  
  public static void aP(final String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(207356);
    h.LTJ.f((Runnable)new a(paramInt1, paramString, paramInt2), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(207356);
  }
  
  public static String aSA(String paramString)
  {
    AppMethodBeat.i(207354);
    d.g.b.p.h(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(207354);
    return paramString;
  }
  
  public static void aSB(String paramString)
  {
    AppMethodBeat.i(207357);
    h.LTJ.f((Runnable)new t.b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(207357);
  }
  
  public static String aSx(String paramString)
  {
    AppMethodBeat.i(207351);
    d.g.b.p.h(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(207351);
    return paramString;
  }
  
  public static String aSy(String paramString)
  {
    AppMethodBeat.i(207352);
    d.g.b.p.h(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(207352);
    return paramString;
  }
  
  public static String aSz(String paramString)
  {
    AppMethodBeat.i(207353);
    d.g.b.p.h(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(207353);
    return paramString;
  }
  
  private static void d(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(207358);
    if (!Iog)
    {
      AppMethodBeat.o(207358);
      return;
    }
    Iog = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = ax.aQA("brandService");
    if (paramLong != 0L) {}
    while (paramLong == 0L)
    {
      AppMethodBeat.o(207358);
      return;
      paramLong = ((ax)localObject1).decodeLong("BizLastMsgId");
    }
    long l2 = 0L;
    try
    {
      localObject1 = ag.aGf().Dn(paramLong);
      if (localObject1 == null)
      {
        AppMethodBeat.o(207358);
        return;
      }
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(207358);
      return;
    }
    long l1 = l2;
    if (((w)localObject1).fpd())
    {
      localObject2 = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(((w)localObject1).field_msgId, ((w)localObject1).field_content);
      l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        if (!bt.hj((List)((u)localObject2).hDb))
        {
          localObject2 = (v)((u)localObject2).hDb.get(0);
          l1 = l2;
          if (!bt.isNullOrNil(((v)localObject2).url)) {
            l1 = bt.getLong(Uri.parse(((v)localObject2).url).getQueryParameter("mid"), 0L);
          }
        }
      }
    }
    Object localObject2 = (ax)com.tencent.mm.am.c.hPJ.fjV();
    paramLong = ((ax)localObject2).decodeLong(aSx(String.valueOf(paramLong)), 0L);
    a((ax)localObject2, ((w)localObject1).field_msgId, l3);
    com.tencent.mm.plugin.report.service.g.yhR.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((w)localObject1).field_talker, Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(paramLong), Long.valueOf(l3) });
    ad.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { ((w)localObject1).field_talker, Long.valueOf(l1), Long.valueOf(paramLong) });
    AppMethodBeat.o(207358);
  }
  
  public static boolean foW()
  {
    AppMethodBeat.i(207355);
    if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG) || (bu.flY()))
    {
      AppMethodBeat.o(207355);
      return true;
    }
    Boolean localBoolean;
    if (Ioh != null)
    {
      localBoolean = Ioh;
      if (localBoolean == null) {
        d.g.b.p.gfZ();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(207355);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.quw, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Ioh = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + Ioh);
      localBoolean = Ioh;
      if (localBoolean == null) {
        d.g.b.p.gfZ();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(207355);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207349);
      long l3 = System.currentTimeMillis();
      long l2 = ax.aQA("brandService").decodeLong("BizLastMsgId");
      if (l2 == 0L)
      {
        AppMethodBeat.o(207349);
        return;
      }
      Object localObject1 = t.Ioj;
      if (t.foX())
      {
        localObject1 = t.Ioj;
        if (l2 == t.foZ())
        {
          AppMethodBeat.o(207349);
          return;
        }
      }
      localObject1 = (ax)com.tencent.mm.am.c.hPJ.fjV();
      Object localObject2 = t.Ioj;
      if (t.foX())
      {
        localObject2 = t.Ioj;
        if (t.foZ() != 0L)
        {
          localObject2 = t.Ioj;
          localObject2 = t.Ioj;
          t.ch("", t.foZ());
        }
      }
      localObject2 = t.Ioj;
      t.Dl(l2);
      localObject2 = t.Ioj;
      t.foY();
      if (((ax)localObject1).decodeInt(String.valueOf(l2), 0) == 1) {}
      for (int i = 0;; i = 1) {
        try
        {
          localObject2 = ag.aGf().Dn(l2);
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(207349);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(207349);
          return;
        }
      }
      Object localObject3;
      long l1;
      label539:
      int k;
      if (((w)localObject2).fpd())
      {
        localObject3 = ((a)com.tencent.mm.kernel.g.ab(a.class)).a(((w)localObject2).field_msgId, ((w)localObject2).field_content);
        if ((localObject3 != null) && (!bt.hj((List)((u)localObject3).hDb)))
        {
          localObject3 = (v)((u)localObject3).hDb.get(0);
          if (!bt.isNullOrNil(((v)localObject3).url))
          {
            l1 = bt.getLong(Uri.parse(((v)localObject3).url).getQueryParameter("mid"), 0L);
            localObject3 = String.valueOf(l2);
            localException.encode((String)localObject3, 1);
            Object localObject4 = t.Ioj;
            localException.encode(t.aSx((String)localObject3), l3);
            localObject4 = t.Ioj;
            localObject4 = t.aSz((String)localObject3);
            t localt = t.Ioj;
            localException.encode((String)localObject4, localException.decodeInt(t.aSz((String)localObject3), 0) + 1);
            localObject4 = t.Ioj;
            localObject4 = t.aSA((String)localObject3);
            localt = t.Ioj;
            localException.encode((String)localObject4, Math.min(localException.decodeInt(t.aSA((String)localObject3), this.odE), this.odE));
            String str = com.tencent.mm.pluginsdk.ui.tools.x.aNF(paramString);
            if (i == 1)
            {
              localObject3 = com.tencent.mm.pluginsdk.c.EIZ;
              boolean bool = com.tencent.mm.pluginsdk.c.bNe().getBoolean("biz_time_preload_at_biz_box_expose", false);
              ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                localObject3 = com.tencent.mm.pluginsdk.c.EIZ;
                com.tencent.mm.pluginsdk.c.eYN();
              }
            }
            p.InU.aaD(0);
            if ((p.InS) || (!p.foP()))
            {
              ad.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + p.InS + ", canvasPreloadOpen=" + p.foP());
              com.tencent.mm.plugin.report.service.g.yhR.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((w)localObject2).field_talker, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.odE), str, Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3) });
              ad.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCount %d, currentTime %d", new Object[] { ((w)localObject2).field_talker, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.odE), Integer.valueOf(paramInt2), Long.valueOf(l3) });
              AppMethodBeat.o(207349);
              return;
            }
            localObject3 = com.tencent.mm.plugin.biz.b.b.nOV;
            k = com.tencent.mm.plugin.biz.b.b.bMy().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
            if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
              break label824;
            }
            if (bu.flY()) {
              break label824;
            }
          }
        }
      }
      for (;;)
      {
        label748:
        localObject3 = com.tencent.mm.plugin.biz.b.b.nOV;
        if (j != 0) {}
        for (l2 = 0L;; l2 = 600000L)
        {
          if (!com.tencent.mm.plugin.biz.b.b.a(k, l2, "biz_canvas_card_expose_preload_last_time", 11L)) {
            break label816;
          }
          p.InS = true;
          h.LTJ.r((Runnable)new p.e(k), 10000L);
          break;
          j = 0;
          break label748;
        }
        label816:
        break label539;
        l1 = 0L;
        break;
        label824:
        int j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storage.t
 * JD-Core Version:    0.7.0.1
 */