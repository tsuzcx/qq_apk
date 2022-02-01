package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "officialAccountShow", "getOfficialAccountShow", "()Z", "setOfficialAccountShow", "(Z)V", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class v
{
  static volatile boolean NPE;
  private static Boolean NPF;
  static long NPG;
  public static final v NPH;
  private static final MultiProcessMMKV cQe;
  
  static
  {
    AppMethodBeat.i(212567);
    NPH = new v();
    cQe = MultiProcessMMKV.getSingleMMKV("brandService");
    NPG = -1L;
    AppMethodBeat.o(212567);
  }
  
  static void a(MultiProcessMMKV paramMultiProcessMMKV, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212566);
    String str = String.valueOf(paramLong1);
    paramLong1 = paramMultiProcessMMKV.decodeLong(biQ(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = paramMultiProcessMMKV.decodeLong(biR(str), 0L) + paramLong2 - paramLong1;
      paramMultiProcessMMKV.encode(biR(str), paramLong1);
      Log.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(212566);
  }
  
  public static void aO(String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(212562);
    com.tencent.f.h.RTc.b((Runnable)new a(paramString, paramInt2, paramInt1), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(212562);
  }
  
  public static MultiProcessMMKV aTI()
  {
    return cQe;
  }
  
  public static String biQ(String paramString)
  {
    AppMethodBeat.i(212557);
    p.h(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(212557);
    return paramString;
  }
  
  public static String biR(String paramString)
  {
    AppMethodBeat.i(212558);
    p.h(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(212558);
    return paramString;
  }
  
  public static String biS(String paramString)
  {
    AppMethodBeat.i(212559);
    p.h(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(212559);
    return paramString;
  }
  
  public static String biT(String paramString)
  {
    AppMethodBeat.i(212560);
    p.h(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(212560);
    return paramString;
  }
  
  public static void biU(String paramString)
  {
    AppMethodBeat.i(212563);
    com.tencent.f.h.RTc.b((Runnable)new b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(212563);
  }
  
  private static void e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(212564);
    if (!NPE)
    {
      AppMethodBeat.o(212564);
      return;
    }
    NPE = false;
    long l3 = System.currentTimeMillis();
    if (paramLong != 0L) {}
    for (long l1 = paramLong; l1 == 0L; l1 = cQe.decodeLong("BizLastMsgId"))
    {
      AppMethodBeat.o(212564);
      return;
    }
    long l2 = 0L;
    int k = 0;
    int m = ag.gBq();
    Object localObject2 = "";
    int i = 0;
    label589:
    for (;;)
    {
      z localz;
      try
      {
        localz = com.tencent.mm.al.ag.ban().MM(l1);
        if ((localz != null) || (l1 >= 0L)) {
          break label589;
        }
        localz = com.tencent.mm.al.ag.bap().MM(l1);
        if (localz == null)
        {
          AppMethodBeat.o(212564);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(212564);
        return;
      }
      int n = af.G(localz);
      int j;
      if (localz.gAt())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(localz.field_msgId, localz.field_content);
        paramLong = l2;
        if (localObject1 != null)
        {
          paramLong = l2;
          if (!Util.isNullOrNil((List)((u)localObject1).iAd))
          {
            localObject1 = (com.tencent.mm.ag.v)((u)localObject1).iAd.get(0);
            paramLong = l2;
            if (!Util.isNullOrNil(((com.tencent.mm.ag.v)localObject1).url)) {
              paramLong = Util.getLong(Uri.parse(((com.tencent.mm.ag.v)localObject1).url).getQueryParameter("mid"), 0L);
            }
          }
        }
        localObject1 = localz.field_talker;
        p.g(localObject1, "info.field_talker");
        j = k;
      }
      do
      {
        for (;;)
        {
          localObject2 = (MultiProcessMMKV)com.tencent.mm.al.c.iNQ.getSlot();
          l1 = ((MultiProcessMMKV)localObject2).decodeLong(biQ(String.valueOf(l1)), 0L);
          a((MultiProcessMMKV)localObject2, localz.field_msgId, l3);
          com.tencent.mm.plugin.report.service.h.CyF.a(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), localObject1, Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(m), "", "", Integer.valueOf(n), Integer.valueOf(i) });
          Log.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { localObject1, Long.valueOf(paramLong), Long.valueOf(l1) });
          AppMethodBeat.o(212564);
          return;
          if (!localz.gAx()) {
            break;
          }
          localObject1 = ag.I(localz);
          j = ag.f(localz);
          paramLong = l2;
        }
        localObject1 = localObject2;
        j = k;
        paramLong = l2;
      } while (!localz.gAu());
      Object localObject1 = localz.NQn;
      if (localObject1 != null) {}
      for (i = ((ege)localObject1).style;; i = 0)
      {
        localObject1 = localObject2;
        j = k;
        paramLong = l2;
        break;
      }
    }
  }
  
  public static boolean gAg()
  {
    return NPE;
  }
  
  public static void gAh()
  {
    NPE = true;
  }
  
  public static boolean gAi()
  {
    AppMethodBeat.i(212561);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(212561);
      return true;
    }
    Boolean localBoolean;
    if (NPF != null)
    {
      localBoolean = NPF;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212561);
      return bool;
    }
    if (((b)g.af(b.class)).a(b.a.rTW, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      NPF = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + NPF);
      localBoolean = NPF;
      if (localBoolean == null) {
        p.hyc();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(212561);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(212555);
      long l3 = System.currentTimeMillis();
      v localv1 = v.NPH;
      long l4 = v.aTI().decodeLong("BizLastMsgId");
      if (l4 == 0L)
      {
        AppMethodBeat.o(212555);
        return;
      }
      localv1 = v.NPH;
      if (v.gAg())
      {
        localv1 = v.NPH;
        if (l4 == v.gAj())
        {
          AppMethodBeat.o(212555);
          return;
        }
      }
      Object localObject4 = (MultiProcessMMKV)com.tencent.mm.al.c.iNQ.getSlot();
      localv1 = v.NPH;
      Object localObject2;
      if (v.gAg())
      {
        localv1 = v.NPH;
        if (v.gAj() != 0L)
        {
          localv1 = v.NPH;
          localObject2 = v.NPH;
          v.a(localv1, "", v.gAj());
        }
      }
      localv1 = v.NPH;
      v.MK(l4);
      localv1 = v.NPH;
      v.gAh();
      if (((MultiProcessMMKV)localObject4).decodeInt(String.valueOf(l4), 0) == 1) {}
      long l2;
      int n;
      int i2;
      Object localObject3;
      int i;
      for (int k = 0;; k = 1)
      {
        l2 = 0L;
        n = 0;
        i2 = ag.gBq();
        localObject3 = this.gZs;
        i = paramInt2;
        try
        {
          localObject2 = com.tencent.mm.al.ag.ban().MM(l4);
          if ((localObject2 != null) || (l4 >= 0L)) {
            break label1229;
          }
          localObject2 = com.tencent.mm.al.ag.bap().MM(l4);
          if (localObject2 != null) {
            break;
          }
          AppMethodBeat.o(212555);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(212555);
          return;
        }
      }
      int i3 = af.G((z)localObject2);
      Object localObject1;
      long l1;
      int i1;
      int m;
      int j;
      if (((z)localObject2).gAt())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((z)localObject2).field_msgId, ((z)localObject2).field_content);
        l1 = l2;
        if (localObject1 != null)
        {
          l1 = l2;
          if (!Util.isNullOrNil((List)((u)localObject1).iAd))
          {
            localObject1 = (com.tencent.mm.ag.v)((u)localObject1).iAd.get(0);
            l1 = l2;
            if (!Util.isNullOrNil(((com.tencent.mm.ag.v)localObject1).url)) {
              l1 = Util.getLong(Uri.parse(((com.tencent.mm.ag.v)localObject1).url).getQueryParameter("mid"), 0L);
            }
          }
        }
        localObject1 = ((z)localObject2).field_talker;
        p.g(localObject1, "info.field_talker");
        i1 = 0;
        m = n;
        j = i;
        i = i1;
      }
      label397:
      Object localObject5;
      for (;;)
      {
        String str = String.valueOf(l4);
        ((MultiProcessMMKV)localObject4).encode(str, 1);
        localObject5 = v.NPH;
        ((MultiProcessMMKV)localObject4).encode(v.biQ(str), l3);
        localObject5 = v.NPH;
        localObject5 = v.biS(str);
        v localv2 = v.NPH;
        ((MultiProcessMMKV)localObject4).encode((String)localObject5, ((MultiProcessMMKV)localObject4).decodeInt(v.biS(str), 0) + 1);
        localObject5 = v.NPH;
        localObject5 = v.biT(str);
        localv2 = v.NPH;
        ((MultiProcessMMKV)localObject4).encode((String)localObject5, Math.min(((MultiProcessMMKV)localObject4).decodeInt(v.biT(str), paramInt1), paramInt1));
        str = com.tencent.mm.pluginsdk.ui.tools.z.bfG((String)localObject3);
        if (k == 1)
        {
          localObject3 = com.tencent.mm.pluginsdk.c.JSr;
          boolean bool = com.tencent.mm.pluginsdk.c.aTI().getBoolean("biz_time_preload_at_biz_box_expose", false);
          Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
          if (bool) {
            com.tencent.mm.pluginsdk.c.JSr.glN();
          }
        }
        localObject3 = com.tencent.mm.plugin.biz.b.a.pfl;
        localObject4 = com.tencent.mm.plugin.biz.b.a.a((z)localObject2);
        r.NPl.ajP(2);
        if ((!r.uft) && (r.gzQ())) {
          break label1027;
        }
        Log.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + r.uft + ", canvasPreloadOpen=" + r.gzQ());
        label644:
        localObject5 = com.tencent.mm.plugin.report.service.h.CyF;
        n = (int)(l3 / 1000L);
        i1 = paramInt1;
        if (localObject4 == null) {
          break label1194;
        }
        localObject3 = (String)((o)localObject4).first;
        label679:
        if (localObject4 == null) {
          break label1200;
        }
        localObject4 = (String)((o)localObject4).second;
        label694:
        ((com.tencent.mm.plugin.report.service.h)localObject5).a(18218, new Object[] { Integer.valueOf(n), localObject1, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(i1), str, Integer.valueOf(j), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(m), Integer.valueOf(i2), localObject3, localObject4, Integer.valueOf(i3), Integer.valueOf(i) });
        Log.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCountReport %d, currentTime %d, msgId=" + ((z)localObject2).field_msgId, new Object[] { localObject1, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramInt1), Integer.valueOf(j), Long.valueOf(l3) });
        AppMethodBeat.o(212555);
        return;
        if (!((z)localObject2).gAx()) {
          break;
        }
        localObject1 = ag.I((z)localObject2);
        m = ag.f((z)localObject2);
        localObject3 = ag.H((z)localObject2);
        j = com.tencent.mm.al.ag.bap().ctM();
        Log.v("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose dyeing template bizUsername = " + (String)localObject1 + ", msgType = " + m);
        i = 0;
        l1 = l2;
      }
      if (((z)localObject2).gAu())
      {
        localObject1 = ((z)localObject2).NQn;
        if (localObject1 == null) {
          break label1255;
        }
        j = ((ege)localObject1).style;
        break label1232;
        label1027:
        r.uft = true;
        localObject3 = com.tencent.mm.plugin.webcanvas.l.IAx;
        com.tencent.mm.plugin.webcanvas.l.LV(14L);
        localObject3 = com.tencent.mm.plugin.biz.b.c.pfv;
        i1 = com.tencent.mm.plugin.biz.b.c.cks().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
        if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
          break label1260;
        }
        if (WeChatEnvironment.hasDebugger())
        {
          break label1260;
          label1080:
          localObject3 = com.tencent.mm.plugin.biz.b.c.pfv;
          if (n == 0) {
            break label1178;
          }
          l2 = 0L;
          label1093:
          if (!com.tencent.mm.plugin.biz.b.c.a(i1, l2, "biz_canvas_card_expose_preload_last_time", 11L)) {
            break label1184;
          }
          localObject3 = com.tencent.f.h.RTc;
          localObject5 = (Runnable)new r.f(i1);
          if ((System.currentTimeMillis() - PluginBiz.startTime > 20000L) || (BuildInfo.DEBUG)) {
            break label1266;
          }
          if (!BuildInfo.IS_FLAVOR_RED) {
            break label1186;
          }
          break label1266;
        }
      }
      for (;;)
      {
        ((i)localObject3).o((Runnable)localObject5, l2);
        break label644;
        n = 0;
        break label1080;
        label1178:
        l2 = 600000L;
        break label1093;
        label1184:
        break label644;
        label1186:
        l2 = 10000L;
        continue;
        label1194:
        localObject3 = null;
        break label679;
        label1200:
        localObject4 = null;
        break label694;
        m = 0;
        localObject1 = "";
        j = i;
        i = m;
        m = n;
        l1 = l2;
        break label397;
        label1229:
        break;
        for (;;)
        {
          label1232:
          localObject1 = "";
          m = i;
          i = j;
          j = m;
          m = n;
          l1 = l2;
          break;
          label1255:
          j = 0;
        }
        label1260:
        n = 1;
        break label1080;
        label1266:
        l2 = 0L;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(212556);
      v.a(v.NPH, this.gZs, this.prP, this.NPI);
      AppMethodBeat.o(212556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */