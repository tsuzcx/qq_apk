package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.model.b.r;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "hasFinderLiveRedDot", "", "isFinderLiveDigestShow", "", "()Z", "setFinderLiveDigestShow", "(Z)V", "isMainCellHideReportOpen", "Ljava/lang/Boolean;", "lastExposeId", "", "getLastExposeId", "()J", "setLastExposeId", "(J)V", "lastExposeMsgId", "lastRedDotUserName", "mBizNotifyMsgPriorityShowSwitch", "getMBizNotifyMsgPriorityShowSwitch", "()I", "setMBizNotifyMsgPriorityShowSwitch", "(I)V", "mMaxNotifyMsgExposureCount", "getMMaxNotifyMsgExposureCount", "setMMaxNotifyMsgExposureCount", "mMaxNotifyMsgExposureTime", "getMMaxNotifyMsgExposureTime", "setMMaxNotifyMsgExposureTime", "mMaxNotifyMsgWithinUnreadCount", "getMMaxNotifyMsgWithinUnreadCount", "setMMaxNotifyMsgWithinUnreadCount", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "officialAccountShow", "getOfficialAccountShow", "setOfficialAccountShow", "isNotifyMsgShowFirst", "notifyInfoMsgId", "unReadCount", "postDoReportMainCellHide", "", "desc", "pos", "msgId", "reportMainCellExpose", "conv", "Lcom/tencent/mm/storage/Conversation;", "reportMainCellHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "currentTime", "HasExposeKey", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class v
{
  static volatile boolean Vdq;
  private static Boolean Vds;
  static long Vdt;
  private static String Vdu;
  static int Vdv;
  static long Vdw;
  static int Vdx;
  static int Vdy;
  public static final v Vdz;
  private static boolean YCn;
  private static int YCo;
  private static final MultiProcessMMKV cQO;
  private static long sBA;
  
  static
  {
    AppMethodBeat.i(206326);
    Vdz = new v();
    cQO = MultiProcessMMKV.getSingleMMKV("brandService");
    Vdt = -1L;
    YCo = 1;
    Vdv = -1;
    Vdw = -1L;
    Vdx = -1;
    Vdy = -1;
    AppMethodBeat.o(206326);
  }
  
  public static void Ut(long paramLong)
  {
    sBA = paramLong;
  }
  
  public static void a(final String paramString, final int paramInt, az paramaz)
  {
    AppMethodBeat.i(206321);
    if (paramaz == null)
    {
      AppMethodBeat.o(206321);
      return;
    }
    final int i = paramaz.apz();
    com.tencent.e.h.ZvG.d((Runnable)new a(paramaz, paramInt, paramString, i), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(206321);
  }
  
  static void aV(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(206325);
    String str = String.valueOf(paramLong1);
    paramLong1 = com.tencent.mm.ao.c.lEh.decodeLong(bvk(str), 0L);
    if ((paramLong1 > 0L) && (paramLong2 - paramLong1 > 0L))
    {
      paramLong1 = com.tencent.mm.ao.c.lEh.decodeLong(bvl(str), 0L) + paramLong2 - paramLong1;
      ((MultiProcessMMKV)com.tencent.mm.ao.c.lEh.getSlotForWrite()).encode(bvl(str), paramLong1);
      Log.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(paramLong1)));
    }
    AppMethodBeat.o(206325);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    return cQO;
  }
  
  public static String bvk(String paramString)
  {
    AppMethodBeat.i(206315);
    p.k(paramString, "$this$LastExposeTimeKey");
    paramString = "lstExpTime_" + paramString + '}';
    AppMethodBeat.o(206315);
    return paramString;
  }
  
  public static String bvl(String paramString)
  {
    AppMethodBeat.i(206316);
    p.k(paramString, "$this$TotalExposeTimeKey");
    paramString = "totalExpTime_" + paramString + '}';
    AppMethodBeat.o(206316);
    return paramString;
  }
  
  public static String bvm(String paramString)
  {
    AppMethodBeat.i(206317);
    p.k(paramString, "$this$TotalExposeCountKey");
    paramString = "totalExpCount_" + paramString + '}';
    AppMethodBeat.o(206317);
    return paramString;
  }
  
  public static String bvn(String paramString)
  {
    AppMethodBeat.i(206318);
    p.k(paramString, "$this$MinExposeIndexKey");
    paramString = "minExpIndex_" + paramString + '}';
    AppMethodBeat.o(206318);
    return paramString;
  }
  
  public static String bvo(String paramString)
  {
    AppMethodBeat.i(206319);
    p.k(paramString, "$this$HasExposeKey");
    paramString = "hasExpose_" + paramString + '}';
    AppMethodBeat.o(206319);
    return paramString;
  }
  
  public static void bvp(String paramString)
  {
    AppMethodBeat.i(206322);
    com.tencent.e.h.ZvG.d((Runnable)new v.b(paramString), "MicroMsg.BizMainCellExposeHelper");
    AppMethodBeat.o(206322);
  }
  
  private static void e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(206323);
    if (!Vdq)
    {
      AppMethodBeat.o(206323);
      return;
    }
    Vdq = false;
    Object localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
    com.tencent.mm.pluginsdk.model.b.hgo();
    long l3 = System.currentTimeMillis();
    Object localObject2;
    if (YCn)
    {
      localObject1 = Vdu;
      if (localObject1 == null)
      {
        AppMethodBeat.o(206323);
        return;
      }
      localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
      localObject2 = com.tencent.mm.pluginsdk.model.b.bpq((String)localObject1);
      paramLong = com.tencent.mm.ao.c.lEh.decodeLong(bvk((String)localObject1), 0L);
      com.tencent.mm.plugin.report.service.h.IzE.a(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt1), ab.aXb(paramString), Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(paramLong), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(YCo), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", localObject2 });
      AppMethodBeat.o(206323);
      return;
    }
    if (paramLong != 0L) {}
    for (long l1 = paramLong; l1 == 0L; l1 = cQO.decodeLong("BizLastMsgId"))
    {
      AppMethodBeat.o(206323);
      return;
    }
    long l2 = 0L;
    int j = 0;
    int i = 0;
    int k = 0;
    int m = ag.hxB();
    localObject1 = "";
    label905:
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.ao.af.bjB().Uw(l1);
        if ((localObject2 != null) || (l1 >= 0L)) {
          break label905;
        }
        localObject2 = com.tencent.mm.ao.af.bjD().Uw(l1);
        if (localObject2 == null)
        {
          AppMethodBeat.o(206323);
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(206323);
        return;
      }
      int n = af.L((z)localObject2);
      if (((z)localObject2).hwA())
      {
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(((z)localObject2).field_msgId, ((z)localObject2).field_content);
        paramLong = l2;
        j = i;
        if (localObject1 != null)
        {
          paramLong = l2;
          j = i;
          if (!Util.isNullOrNil((List)((u)localObject1).lpz))
          {
            localObject1 = (com.tencent.mm.aj.v)((u)localObject1).lpz.get(0);
            paramLong = l2;
            j = i;
            if (!Util.isNullOrNil(((com.tencent.mm.aj.v)localObject1).url))
            {
              localObject1 = Uri.parse(((com.tencent.mm.aj.v)localObject1).url);
              paramLong = Util.getLong(((Uri)localObject1).getQueryParameter("mid"), 0L);
              j = Util.getInt(((Uri)localObject1).getQueryParameter("idx"), 0);
            }
          }
        }
        localObject1 = ((z)localObject2).field_talker;
        p.j(localObject1, "info.field_talker");
        i = 0;
      }
      for (;;)
      {
        l1 = com.tencent.mm.ao.c.lEh.decodeLong(bvk(String.valueOf(l1)), 0L);
        aV(((z)localObject2).field_msgId, l3);
        com.tencent.mm.plugin.report.service.h.IzE.a(18218, new Object[] { Integer.valueOf((int)(l3 / 1000L)), localObject1, Long.valueOf(paramLong), Integer.valueOf(0), Integer.valueOf(paramInt1), ab.aXb(paramString), Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(l1), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(k), Integer.valueOf(m), "", "", Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), "", "", "", "" });
        Log.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", new Object[] { localObject1, Long.valueOf(paramLong), Long.valueOf(l1) });
        AppMethodBeat.o(206323);
        return;
        if (((z)localObject2).hwE())
        {
          localObject1 = ag.N((z)localObject2);
          k = ag.f((z)localObject2);
          i = 0;
          paramLong = l2;
        }
        else if (((z)localObject2).hwB())
        {
          Object localObject3 = ac.VeT;
          localObject3 = ac.J((z)localObject2);
          i = ((ci)localObject3).style;
          paramLong = ((ci)localObject3).lqo;
          j = ((ci)localObject3).idx;
        }
        else
        {
          i = 0;
          paramLong = l2;
        }
      }
    }
  }
  
  public static boolean hAS()
  {
    return YCn;
  }
  
  public static long hwk()
  {
    return sBA;
  }
  
  public static boolean hwl()
  {
    return Vdq;
  }
  
  public static void hwm()
  {
    Vdq = true;
  }
  
  public static boolean hwo()
  {
    AppMethodBeat.i(206320);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(206320);
      return true;
    }
    Boolean localBoolean;
    if (Vds != null)
    {
      localBoolean = Vds;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(206320);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAB, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Vds = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + Vds);
      localBoolean = Vds;
      if (localBoolean == null) {
        p.iCn();
      }
      bool = localBoolean.booleanValue();
      AppMethodBeat.o(206320);
      return bool;
    }
  }
  
  public static void kp(boolean paramBoolean)
  {
    YCn = paramBoolean;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(az paramaz, int paramInt1, String paramString, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(205755);
      Object localObject1 = v.Vdz;
      if (v.hwl())
      {
        localObject1 = v.Vdz;
        if (p.h(v.hwp(), this.VdA.apB()))
        {
          AppMethodBeat.o(205755);
          return;
        }
      }
      localObject1 = v.Vdz;
      v.bvq(this.VdA.apB());
      localObject1 = v.Vdz;
      v.hwm();
      long l3 = System.currentTimeMillis();
      Object localObject3;
      Object localObject4;
      Object localObject5;
      int i;
      label191:
      int j;
      int m;
      Object localObject6;
      long l1;
      if (this.VdA.rp(128))
      {
        localObject1 = v.Vdz;
        v.kp(true);
        localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
        localObject1 = com.tencent.mm.pluginsdk.model.b.bpq(this.VdA.apB());
        localObject3 = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.nj(this.VdA.apB(), (String)localObject1);
        localObject3 = com.tencent.mm.pluginsdk.model.b.QTJ;
        if (com.tencent.mm.pluginsdk.model.b.QTG == null)
        {
          localObject3 = com.tencent.mm.pluginsdk.model.b.hgp();
          if (localObject3 != null) {}
        }
        else
        {
          localObject3 = this.VdA.apB();
          localObject4 = com.tencent.mm.ao.c.lEh;
          localObject5 = v.Vdz;
          p.j(localObject3, "bizUsername");
          if (((com.tencent.mm.ao.c)localObject4).decodeInt(v.bvo((String)localObject3), 0) != 1) {
            break label559;
          }
          i = 0;
          localObject4 = (MultiProcessMMKV)com.tencent.mm.ao.c.lEh.getSlotForWrite();
          localObject5 = v.Vdz;
          ((MultiProcessMMKV)localObject4).encode(v.bvo((String)localObject3), 1);
          localObject5 = v.Vdz;
          ((MultiProcessMMKV)localObject4).encode(v.bvk((String)localObject3), l3);
          localObject4 = v.Vdz;
          if (!this.VdA.rp(256)) {
            break label564;
          }
        }
        label559:
        label564:
        for (j = 1;; j = 0)
        {
          v.asO(j);
          localObject4 = com.tencent.mm.plugin.report.service.h.IzE;
          j = (int)(l3 / 1000L);
          k = paramInt;
          localObject5 = ab.aXb(paramString);
          m = i;
          localObject6 = v.Vdz;
          ((com.tencent.mm.plugin.report.service.h)localObject4).a(18218, new Object[] { Integer.valueOf(j), localObject3, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), localObject5, Integer.valueOf(m), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(v.hBk()), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", localObject1 });
          AppMethodBeat.o(205755);
          return;
          l1 = kotlin.k.i.be(MMKVSlotManager.decodeLong$default(com.tencent.mm.pluginsdk.model.b.QTq, com.tencent.mm.pluginsdk.model.b.bpn((String)localObject3), 0L, 2, null), 10L) * 1000L / 2L;
          Log.d("MicroMsg.BizFinderLiveLogic", "startCheckMaiCellRedDot interval=".concat(String.valueOf(l1)));
          localObject3 = new MTimerHandler("updateMainCellFinderLiveRedDotTimer", (MTimerHandler.CallBack)b.r.QUo, true);
          com.tencent.mm.pluginsdk.model.b.QTG = (MTimerHandler)localObject3;
          ((MTimerHandler)localObject3).startTimer(500L, l1);
          break;
          i = 1;
          break label191;
        }
      }
      localObject1 = v.Vdz;
      v.kp(false);
      localObject1 = v.Vdz;
      long l2 = v.bcJ().decodeLong("BizLastMsgId");
      if (l2 == 0L)
      {
        AppMethodBeat.o(205755);
        return;
      }
      localObject1 = v.Vdz;
      if (v.hwl())
      {
        localObject1 = v.Vdz;
        if (l2 == v.hwq())
        {
          AppMethodBeat.o(205755);
          return;
        }
      }
      Object localObject10 = (MultiProcessMMKV)com.tencent.mm.ao.c.lEh.getSlotForWrite();
      localObject1 = v.Vdz;
      if (v.hwl())
      {
        localObject1 = v.Vdz;
        if (v.hwq() != 0L)
        {
          localObject1 = v.Vdz;
          localObject3 = v.Vdz;
          v.a((v)localObject1, "", v.hwq());
        }
      }
      localObject1 = v.Vdz;
      v.Uu(l2);
      localObject1 = v.Vdz;
      v.hwm();
      String str = String.valueOf(l2);
      if (com.tencent.mm.ao.c.lEh.decodeInt(str, 0) == 1) {}
      int n;
      int i3;
      int i1;
      for (int k = 0;; k = 1)
      {
        l1 = 0L;
        n = 0;
        localObject4 = "";
        localObject3 = "";
        m = 0;
        i3 = ag.hxB();
        localObject6 = paramString;
        i1 = i;
        i = 0;
        try
        {
          localObject5 = com.tencent.mm.ao.af.bjB().Uw(l2);
          if ((localObject5 != null) || (l2 >= 0L)) {
            break label1995;
          }
          localObject5 = com.tencent.mm.ao.af.bjD().Uw(l2);
          if (localObject5 != null) {
            break;
          }
          AppMethodBeat.o(205755);
          return;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", new Object[] { localException.getMessage() });
          AppMethodBeat.o(205755);
          return;
        }
      }
      int i4 = af.L((z)localObject5);
      Object localObject2;
      label968:
      label986:
      Object localObject7;
      Object localObject9;
      if (((z)localObject5).hwA())
      {
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(((z)localObject5).field_msgId, ((z)localObject5).field_content);
        if ((localObject2 != null) && (!Util.isNullOrNil((List)((u)localObject2).lpz)))
        {
          localObject2 = (com.tencent.mm.aj.v)((u)localObject2).lpz.get(0);
          if (!Util.isNullOrNil(((com.tencent.mm.aj.v)localObject2).url))
          {
            localObject2 = Uri.parse(((com.tencent.mm.aj.v)localObject2).url);
            l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
            j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
            localObject2 = ((z)localObject5).field_talker;
            p.j(localObject2, "info.field_talker");
            break label1998;
          }
        }
      }
      else
      {
        Object localObject8;
        label1236:
        int i2;
        for (;;)
        {
          ((MultiProcessMMKV)localObject10).encode(str, 1);
          localObject7 = v.Vdz;
          ((MultiProcessMMKV)localObject10).encode(v.bvk(str), l3);
          localObject7 = v.Vdz;
          localObject7 = v.bvm(str);
          localObject8 = com.tencent.mm.ao.c.lEh;
          localObject9 = v.Vdz;
          ((MultiProcessMMKV)localObject10).encode((String)localObject7, ((com.tencent.mm.ao.c)localObject8).decodeInt(v.bvm(str), 0) + 1);
          localObject7 = v.Vdz;
          localObject7 = v.bvn(str);
          localObject8 = com.tencent.mm.ao.c.lEh;
          localObject9 = v.Vdz;
          ((MultiProcessMMKV)localObject10).encode((String)localObject7, Math.min(((com.tencent.mm.ao.c)localObject8).decodeInt(v.bvn(str), paramInt), paramInt));
          localObject8 = ab.aXb((String)localObject6);
          if (k == 1)
          {
            localObject6 = com.tencent.mm.pluginsdk.c.QRw;
            boolean bool = com.tencent.mm.pluginsdk.c.bcJ().getBoolean("biz_time_preload_at_biz_box_expose", false);
            Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
            if (bool) {
              com.tencent.mm.pluginsdk.c.QRw.hfE();
            }
          }
          localObject6 = com.tencent.mm.plugin.biz.b.a.shp;
          localObject7 = com.tencent.mm.plugin.biz.b.a.a((z)localObject5);
          r.VcW.ask(2);
          if ((!r.xVQ) && (r.hvU())) {
            break label1788;
          }
          Log.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + r.xVQ + ", canvasPreloadOpen=" + r.hvU());
          localObject6 = v.Vdz;
          localObject9 = v.bcJ().decodeString("BizLastRecCardId", "");
          localObject10 = com.tencent.mm.plugin.report.service.h.IzE;
          i1 = (int)(l3 / 1000L);
          i2 = paramInt;
          if (localObject7 == null) {
            break label1955;
          }
          localObject6 = (String)((o)localObject7).Mx;
          label1289:
          if (localObject7 == null) {
            break label1961;
          }
          localObject7 = (String)((o)localObject7).My;
          label1304:
          ((com.tencent.mm.plugin.report.service.h)localObject10).a(18218, new Object[] { Integer.valueOf(i1), localObject2, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(i2), localObject8, Integer.valueOf(j), Integer.valueOf(0), Long.valueOf(l3), Long.valueOf(l3), Integer.valueOf(0), Integer.valueOf(m), Integer.valueOf(i3), localObject6, localObject7, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(n), ab.aXb((String)localObject4), ab.aXb((String)localObject3), localObject9, "" });
          Log.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCountReport %d, currentTime %d, msgId=" + ((z)localObject5).field_msgId + ", lastRecCardId=" + (String)localObject9, new Object[] { localObject2, Long.valueOf(l1), Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(j), Long.valueOf(l3) });
          localObject2 = v.Vdz;
          v.Ut(l3);
          AppMethodBeat.o(205755);
          return;
          if (!((z)localObject5).hwE()) {
            break;
          }
          localObject2 = ag.N((z)localObject5);
          m = ag.f((z)localObject5);
          localObject6 = ag.M((z)localObject5);
          j = com.tencent.mm.ao.af.bjD().cHo();
          Log.v("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose dyeing template bizUsername = " + (String)localObject2 + ", msgType = " + m);
          i = 0;
          localObject3 = "";
          localObject4 = "";
        }
        if (((z)localObject5).hwB())
        {
          localObject2 = ac.VeT;
          localObject2 = ac.J((z)localObject5);
          n = ((ci)localObject2).style;
          l2 = ((ci)localObject2).lqo;
          i2 = ((ci)localObject2).idx;
          localObject7 = ((ci)localObject2).VHs;
          localObject8 = ((ci)localObject2).extData;
          localObject9 = ((ci)localObject2).fOX;
          localObject2 = localObject9;
          i = n;
          localObject3 = localObject8;
          localObject4 = localObject7;
          j = i2;
          l1 = l2;
          if (localObject9 != null) {
            break label1998;
          }
          localObject2 = "";
          i = n;
          localObject3 = localObject8;
          localObject4 = localObject7;
          j = i2;
          l1 = l2;
          break label1998;
          label1788:
          r.xVQ = true;
          localObject6 = com.tencent.mm.plugin.webcanvas.l.PuB;
          com.tencent.mm.plugin.webcanvas.l.Tt(14L);
          localObject6 = com.tencent.mm.plugin.biz.b.c.shz;
          i2 = com.tencent.mm.plugin.biz.b.c.cxK().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {
            break label2007;
          }
          if (WeChatEnvironment.hasDebugger())
          {
            break label2007;
            label1841:
            localObject6 = com.tencent.mm.plugin.biz.b.c.shz;
            if (i1 == 0) {
              break label1939;
            }
            l2 = 0L;
            label1854:
            if (!com.tencent.mm.plugin.biz.b.c.a(i2, l2, "biz_canvas_card_expose_preload_last_time", 11L)) {
              break label1945;
            }
            localObject6 = com.tencent.e.h.ZvG;
            localObject9 = (Runnable)new r.f(i2);
            if ((System.currentTimeMillis() - PluginBiz.startTime > 20000L) || (BuildInfo.DEBUG)) {
              break label2013;
            }
            if (!BuildInfo.IS_FLAVOR_RED) {
              break label1947;
            }
            break label2013;
          }
        }
      }
      for (;;)
      {
        ((com.tencent.e.i)localObject6).o((Runnable)localObject9, l2);
        break label1236;
        i1 = 0;
        break label1841;
        label1939:
        l2 = 600000L;
        break label1854;
        label1945:
        break label1236;
        label1947:
        l2 = 10000L;
        continue;
        label1955:
        localObject6 = null;
        break label1289;
        label1961:
        localObject7 = null;
        break label1304;
        i = 0;
        localObject2 = "";
        localObject3 = "";
        localObject4 = "";
        j = i1;
        break label986;
        j = 0;
        l1 = 0L;
        break label968;
        label1995:
        break;
        label1998:
        n = j;
        j = i1;
        break label986;
        label2007:
        i1 = 1;
        break label1841;
        label2013:
        l2 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.v
 * JD-Core Version:    0.7.0.1
 */