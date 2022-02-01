package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "officialAccountShow", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellExposeHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class r
{
  static volatile boolean Fej;
  private static Boolean Fek;
  static long Fel;
  public static final r Fem;
  
  static
  {
    AppMethodBeat.i(191117);
    Fem = new r();
    Fel = -1L;
    AppMethodBeat.o(191117);
  }
  
  static void a(ax paramax, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191116);
    String str = String.valueOf(paramLong1);
    paramLong1 = paramax.decodeLong(aHr(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = paramax.decodeLong(aHs(str), 0L) + paramLong2 - paramLong1;
      paramax.encode(aHs(str), paramLong1);
      ad.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(191116);
  }
  
  public static String aHr(String paramString)
  {
    AppMethodBeat.i(191107);
    d.g.b.k.h(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(191107);
    return paramString;
  }
  
  public static String aHs(String paramString)
  {
    AppMethodBeat.i(191108);
    d.g.b.k.h(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(191108);
    return paramString;
  }
  
  public static String aHt(String paramString)
  {
    AppMethodBeat.i(191109);
    d.g.b.k.h(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(191109);
    return paramString;
  }
  
  public static String aHu(String paramString)
  {
    AppMethodBeat.i(191110);
    d.g.b.k.h(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(191110);
    return paramString;
  }
  
  public static void aHv(String paramString)
  {
    AppMethodBeat.i(191113);
    com.tencent.e.h.Iye.f((Runnable)new b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(191113);
  }
  
  public static void aI(final String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(191112);
    com.tencent.e.h.Iye.f((Runnable)new a(paramInt1, paramString, paramInt2), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(191112);
  }
  
  private static void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(191114);
    if (!Fej)
    {
      AppMethodBeat.o(191114);
      return;
    }
    Fej = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = ax.aFD("brandService");
    if (paramLong > 0L) {}
    while (paramLong <= 0L)
    {
      AppMethodBeat.o(191114);
      return;
      paramLong = ((ax)localObject1).decodeLong("BizLastMsgId");
    }
    long l2 = 0L;
    try
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).cOI().rm(paramLong);
      long l1 = l2;
      if (((bl)localObject1).eJL())
      {
        localObject2 = ((a)g.ab(a.class)).a(((bl)localObject1).SF(), ((bl)localObject1).getContent());
        l1 = l2;
        if (localObject2 != null)
        {
          l1 = l2;
          if (!bt.gL((List)((u)localObject2).gKs))
          {
            localObject2 = (v)((u)localObject2).gKs.get(0);
            l1 = l2;
            if (!bt.isNullOrNil(((v)localObject2).url)) {
              l1 = bt.getLong(Uri.parse(((v)localObject2).url).getQueryParameter("mid"), 0L);
            }
          }
        }
      }
      Object localObject2 = (ax)com.tencent.mm.am.b.gWP.eEX();
      paramLong = ((ax)localObject2).decodeLong(aHr(String.valueOf(paramLong)), 0L);
      a((ax)localObject2, ((bl)localObject1).SF(), l3);
      com.tencent.mm.plugin.report.service.h.vKh.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((bl)localObject1).SI(), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(paramLong), Long.valueOf(l3) });
      ad.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { ((bl)localObject1).SI(), Long.valueOf(l1), Long.valueOf(paramLong) });
      AppMethodBeat.o(191114);
      return;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(191114);
    }
  }
  
  public static boolean eJF()
  {
    AppMethodBeat.i(191111);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bu.eGT()))
    {
      AppMethodBeat.o(191111);
      return true;
    }
    Boolean localBoolean;
    if (Fek != null)
    {
      localBoolean = Fek;
      if (localBoolean == null) {
        d.g.b.k.fvU();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(191111);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmJ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Fek = Boolean.valueOf(bool);
      ad.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + Fek);
      localBoolean = Fek;
      if (localBoolean == null) {
        d.g.b.k.fvU();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(191111);
      return bool;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(191105);
      long l3 = System.currentTimeMillis();
      long l4 = ax.aFD("brandService").decodeLong("BizLastMsgId");
      if (l4 <= 0L)
      {
        AppMethodBeat.o(191105);
        return;
      }
      Object localObject1 = r.Fem;
      if (r.eJG())
      {
        localObject1 = r.Fem;
        if (l4 == r.eJI())
        {
          AppMethodBeat.o(191105);
          return;
        }
      }
      localObject1 = (ax)com.tencent.mm.am.b.gWP.eEX();
      Object localObject2 = r.Fem;
      if (r.eJG())
      {
        localObject2 = r.Fem;
        if (r.eJI() > 0L)
        {
          localObject2 = r.Fem;
          localObject2 = r.Fem;
          r.cb("", r.eJI());
        }
      }
      localObject2 = r.Fem;
      r.vS(l4);
      localObject2 = r.Fem;
      r.eJH();
      if (((ax)localObject1).decodeInt(String.valueOf(l4), 0) == 1) {}
      for (int i = 0;; i = 1)
      {
        long l2 = 0L;
        try
        {
          localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).cOI().rm(l4);
          long l1 = l2;
          if (((bl)localObject2).eJL())
          {
            localObject3 = ((a)g.ab(a.class)).a(((bl)localObject2).SF(), ((bl)localObject2).getContent());
            l1 = l2;
            if (localObject3 != null)
            {
              l1 = l2;
              if (!bt.gL((List)((u)localObject3).gKs))
              {
                localObject3 = (v)((u)localObject3).gKs.get(0);
                l1 = l2;
                if (!bt.isNullOrNil(((v)localObject3).url)) {
                  l1 = bt.getLong(Uri.parse(((v)localObject3).url).getQueryParameter("mid"), 0L);
                }
              }
            }
          }
          Object localObject3 = String.valueOf(l4);
          ((ax)localObject1).encode((String)localObject3, 1);
          Object localObject4 = r.Fem;
          ((ax)localObject1).encode(r.aHr((String)localObject3), l3);
          localObject4 = r.Fem;
          localObject4 = r.aHt((String)localObject3);
          r localr = r.Fem;
          ((ax)localObject1).encode((String)localObject4, ((ax)localObject1).decodeInt(r.aHt((String)localObject3), 0) + 1);
          localObject4 = r.Fem;
          localObject4 = r.aHu((String)localObject3);
          localr = r.Fem;
          ((ax)localObject1).encode((String)localObject4, Math.min(((ax)localObject1).decodeInt(r.aHu((String)localObject3), this.quh), this.quh));
          localObject1 = x.aCL(paramString);
          if (i == 1)
          {
            localObject3 = com.tencent.mm.pluginsdk.b.BMT;
            boolean bool = com.tencent.mm.pluginsdk.b.bCc().getBoolean("biz_time_preload_at_biz_box_expose", false);
            ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
            if (bool)
            {
              localObject3 = com.tencent.mm.pluginsdk.b.BMT;
              com.tencent.mm.pluginsdk.b.euG();
            }
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((bl)localObject2).SI(), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.quh), localObject1, Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3) });
          ad.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCount %d, currentTime %d", new Object[] { ((bl)localObject2).SI(), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.quh), Integer.valueOf(paramInt2), Long.valueOf(l3) });
          AppMethodBeat.o(191105);
          return;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(191105);
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(191106);
      r localr = r.Fem;
      r.aJ(this.Fen, this.quh, this.Feo);
      AppMethodBeat.o(191106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */