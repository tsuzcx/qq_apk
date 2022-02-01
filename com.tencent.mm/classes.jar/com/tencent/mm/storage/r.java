package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "officialAccountShow", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellExposeHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class r
{
  static volatile boolean GBS;
  private static Boolean GBT;
  static long GBU;
  public static final r GBV;
  
  static
  {
    AppMethodBeat.i(209597);
    GBV = new r();
    GBU = -1L;
    AppMethodBeat.o(209597);
  }
  
  static void a(aw paramaw, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209596);
    String str = String.valueOf(paramLong1);
    paramLong1 = paramaw.decodeLong(aML(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = paramaw.decodeLong(aMM(str), 0L) + paramLong2 - paramLong1;
      paramaw.encode(aMM(str), paramLong1);
      ac.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(209596);
  }
  
  public static void aL(final String paramString, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(209592);
    com.tencent.e.h.JZN.f((Runnable)new a(paramInt1, paramString, paramInt2), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(209592);
  }
  
  public static String aML(String paramString)
  {
    AppMethodBeat.i(209587);
    d.g.b.k.h(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(209587);
    return paramString;
  }
  
  public static String aMM(String paramString)
  {
    AppMethodBeat.i(209588);
    d.g.b.k.h(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(209588);
    return paramString;
  }
  
  public static String aMN(String paramString)
  {
    AppMethodBeat.i(209589);
    d.g.b.k.h(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(209589);
    return paramString;
  }
  
  public static String aMO(String paramString)
  {
    AppMethodBeat.i(209590);
    d.g.b.k.h(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(209590);
    return paramString;
  }
  
  public static void aMP(String paramString)
  {
    AppMethodBeat.i(209593);
    com.tencent.e.h.JZN.f((Runnable)new b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(209593);
  }
  
  private static void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(209594);
    if (!GBS)
    {
      AppMethodBeat.o(209594);
      return;
    }
    GBS = false;
    long l3 = System.currentTimeMillis();
    Object localObject1 = aw.aKU("brandService");
    if (paramLong > 0L) {}
    while (paramLong <= 0L)
    {
      AppMethodBeat.o(209594);
      return;
      paramLong = ((aw)localObject1).decodeLong("BizLastMsgId");
    }
    long l2 = 0L;
    try
    {
      localObject1 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject1).dcr().vP(paramLong);
      long l1 = l2;
      if (((bo)localObject1).eZj())
      {
        localObject2 = ((a)g.ab(a.class)).a(((bo)localObject1).Tz(), ((bo)localObject1).getContent());
        l1 = l2;
        if (localObject2 != null)
        {
          l1 = l2;
          if (!bs.gY((List)((u)localObject2).hkS))
          {
            localObject2 = (v)((u)localObject2).hkS.get(0);
            l1 = l2;
            if (!bs.isNullOrNil(((v)localObject2).url)) {
              l1 = bs.getLong(Uri.parse(((v)localObject2).url).getQueryParameter("mid"), 0L);
            }
          }
        }
      }
      Object localObject2 = (aw)com.tencent.mm.al.b.hxo.eUr();
      paramLong = ((aw)localObject2).decodeLong(aML(String.valueOf(paramLong)), 0L);
      a((aw)localObject2, ((bo)localObject1).Tz(), l3);
      com.tencent.mm.plugin.report.service.h.wUl.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((bo)localObject1).TC(), Long.valueOf(l1), Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(paramLong), Long.valueOf(l3) });
      ac.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { ((bo)localObject1).TC(), Long.valueOf(l1), Long.valueOf(paramLong) });
      AppMethodBeat.o(209594);
      return;
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(209594);
    }
  }
  
  public static boolean eZc()
  {
    AppMethodBeat.i(209591);
    if ((com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG) || (bt.eWo()))
    {
      AppMethodBeat.o(209591);
      return true;
    }
    Boolean localBoolean;
    if (GBT != null)
    {
      localBoolean = GBT;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(209591);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQj, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      GBT = Boolean.valueOf(bool);
      ac.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + GBT);
      localBoolean = GBT;
      if (localBoolean == null) {
        d.g.b.k.fOy();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(209591);
      return bool;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(209585);
      long l3 = System.currentTimeMillis();
      long l4 = aw.aKU("brandService").decodeLong("BizLastMsgId");
      if (l4 <= 0L)
      {
        AppMethodBeat.o(209585);
        return;
      }
      Object localObject1 = r.GBV;
      if (r.eZd())
      {
        localObject1 = r.GBV;
        if (l4 == r.eZf())
        {
          AppMethodBeat.o(209585);
          return;
        }
      }
      localObject1 = (aw)com.tencent.mm.al.b.hxo.eUr();
      Object localObject2 = r.GBV;
      if (r.eZd())
      {
        localObject2 = r.GBV;
        if (r.eZf() > 0L)
        {
          localObject2 = r.GBV;
          localObject2 = r.GBV;
          r.cd("", r.eZf());
        }
      }
      localObject2 = r.GBV;
      r.Av(l4);
      localObject2 = r.GBV;
      r.eZe();
      if (((aw)localObject1).decodeInt(String.valueOf(l4), 0) == 1) {}
      for (int i = 0;; i = 1)
      {
        long l2 = 0L;
        try
        {
          localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
          d.g.b.k.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject2).dcr().vP(l4);
          long l1 = l2;
          if (((bo)localObject2).eZj())
          {
            localObject3 = ((a)g.ab(a.class)).a(((bo)localObject2).Tz(), ((bo)localObject2).getContent());
            l1 = l2;
            if (localObject3 != null)
            {
              l1 = l2;
              if (!bs.gY((List)((u)localObject3).hkS))
              {
                localObject3 = (v)((u)localObject3).hkS.get(0);
                l1 = l2;
                if (!bs.isNullOrNil(((v)localObject3).url)) {
                  l1 = bs.getLong(Uri.parse(((v)localObject3).url).getQueryParameter("mid"), 0L);
                }
              }
            }
          }
          Object localObject3 = String.valueOf(l4);
          ((aw)localObject1).encode((String)localObject3, 1);
          Object localObject4 = r.GBV;
          ((aw)localObject1).encode(r.aML((String)localObject3), l3);
          localObject4 = r.GBV;
          localObject4 = r.aMN((String)localObject3);
          r localr = r.GBV;
          ((aw)localObject1).encode((String)localObject4, ((aw)localObject1).decodeInt(r.aMN((String)localObject3), 0) + 1);
          localObject4 = r.GBV;
          localObject4 = r.aMO((String)localObject3);
          localr = r.GBV;
          ((aw)localObject1).encode((String)localObject4, Math.min(((aw)localObject1).decodeInt(r.aMO((String)localObject3), this.sbw), this.sbw));
          localObject1 = x.aId(paramString);
          if (i == 1)
          {
            localObject3 = com.tencent.mm.pluginsdk.b.Dfd;
            boolean bool = com.tencent.mm.pluginsdk.b.bJa().getBoolean("biz_time_preload_at_biz_box_expose", false);
            ac.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
            if (bool)
            {
              localObject3 = com.tencent.mm.pluginsdk.b.Dfd;
              com.tencent.mm.pluginsdk.b.eJZ();
            }
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), ((bo)localObject2).TC(), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.sbw), localObject1, Integer.valueOf(paramInt2), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3) });
          ac.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCount %d, currentTime %d", new Object[] { ((bo)localObject2).TC(), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(this.sbw), Integer.valueOf(paramInt2), Long.valueOf(l3) });
          AppMethodBeat.o(209585);
          return;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(209585);
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(209586);
      r localr = r.GBV;
      r.aM(this.fSz, this.sbw, this.GBW);
      AppMethodBeat.o(209586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.r
 * JD-Core Version:    0.7.0.1
 */