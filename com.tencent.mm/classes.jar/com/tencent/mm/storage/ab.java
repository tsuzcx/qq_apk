package com.tencent.mm.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.u;
import com.tencent.mm.an.h.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.an;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.p;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webcanvas.l;
import com.tencent.mm.pluginsdk.model.b.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.eqc;
import com.tencent.mm.protocal.protobuf.eqd;
import com.tencent.mm.protocal.protobuf.eqf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;

public final class ab
{
  private static String VeI = null;
  private static long VeJ = 0L;
  public static boolean VeK;
  public static long VeL = 0L;
  public static long VeM = 0L;
  public static int VeN = 0;
  private static Boolean VeO = null;
  private static Boolean VeP = null;
  private static int fwM = 0;
  private static boolean lvz;
  
  static
  {
    VeK = false;
    lvz = false;
  }
  
  public static void ES(boolean paramBoolean)
  {
    VeK = paramBoolean;
  }
  
  public static void Ht(int paramInt)
  {
    fwM = paramInt;
  }
  
  public static void I(z paramz)
  {
    AppMethodBeat.i(124670);
    while (com.tencent.mm.ao.af.bjB().Uv(paramz.field_orderFlag) != null) {
      paramz.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static long UL(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean UM(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (com.tencent.mm.ao.af.bjB().UC(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (com.tencent.mm.ao.af.bjB().hwv() <= com.tencent.mm.ao.af.bjB().hxb()) {
      com.tencent.mm.ao.af.bjB().hxc();
    }
    com.tencent.mm.ao.af.bjB().UB(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void UN(long paramLong)
  {
    AppMethodBeat.i(124679);
    VeJ = paramLong;
    MMApplicationContext.getDefaultPreference().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
  
  public static long aW(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuZ, "");
    long l1 = l2;
    if (!Util.isNullOrNil(str))
    {
      String[] arrayOfString = str.split(":");
      l1 = l2;
      if (arrayOfString.length == 2)
      {
        l1 = l2;
        if (Util.getLong(arrayOfString[0], -1L) == paramLong1) {
          l1 = paramLong2 - Util.getLong(arrayOfString[1], -1L);
        }
      }
    }
    if (l1 < 0L)
    {
      l1 = 604800L;
      str = paramLong1 + ":" + (paramLong2 - 604800L);
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuZ, str);
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static long aX(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(208209);
    z localz = com.tencent.mm.ao.af.bjB().UF(paramLong1);
    if (localz == null)
    {
      AppMethodBeat.o(208209);
      return 604800L;
    }
    paramLong1 = localz.field_createTime / 1000L;
    AppMethodBeat.o(208209);
    return paramLong2 - (paramLong1 - 604800L);
  }
  
  public static z aa(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(208191);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(208191);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
      AppMethodBeat.o(208191);
      return null;
    }
    Object localObject = paramMap;
    int i;
    if (paramMap == null)
    {
      i = paramString.indexOf("<sysmsg");
      if (i != -1)
      {
        paramMap = XmlParser.parseXml(paramString.substring(i), "sysmsg", null);
        localObject = paramMap;
        if (paramMap == null)
        {
          Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
          AppMethodBeat.o(208191);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(208191);
        return null;
      }
    }
    paramMap = com.tencent.mm.ao.af.bjB().hwU();
    paramString = ca((Map)localObject);
    af.a(paramString, (Map)localObject);
    if (!af.b(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
      af.a(paramString, paramString.Uax, 3);
      AppMethodBeat.o(208191);
      return null;
    }
    int j = paramString.pos;
    long l4 = paramString.weight;
    if ((j < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
      af.a(paramString, paramString.Uax, 4);
      AppMethodBeat.o(208191);
      return null;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
    if (af.g(paramString))
    {
      af.a(paramString, paramString.Uax, 5);
      AppMethodBeat.o(208191);
      return null;
    }
    long l3 = com.tencent.mm.ao.af.bjB().hwv();
    if (af.asy(paramString.style))
    {
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString.UsD.Usy.UserName);
      if ((localObject != null) && (d.rk(((ax)localObject).field_type)))
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", new Object[] { paramString.UsD.Usy.UserName });
        af.a(paramString, paramString.Uax, 6);
        AppMethodBeat.o(208191);
        return null;
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 1L, 1L, false);
    localObject = new z();
    ((z)localObject).field_msgId = com.tencent.mm.ao.af.bjB().hxf();
    ((z)localObject).field_msgSvrId = 0L;
    ((z)localObject).field_type = 620757041;
    ((z)localObject).field_talker = paramString.UsD.Usy.UserName;
    ((z)localObject).field_talkerId = 0;
    long l1;
    label494:
    label501:
    long l2;
    if (paramString.UsG == 1)
    {
      i = 1;
      if (i == 0) {
        break label736;
      }
      if (Math.abs(paramString.Uaw * 1000L - bq.beS()) > 86400000L) {
        break label728;
      }
      l1 = paramString.Uaw * 1000L;
      ((z)localObject).field_createTime = l1;
      ((z)localObject).pp(1);
      ((z)localObject).field_status = 3;
      af.a((z)localObject, paramString);
      ((z)localObject).c(paramString);
      l2 = 0L;
      l1 = l2;
      if (paramMap != null)
      {
        if (l4 < 0L) {
          break label754;
        }
        l1 = Math.min(l4, UL(paramMap.field_orderFlag));
      }
      label557:
      l2 = aW(l3, ((z)localObject).field_createTime / 1000L);
      if (l2 < 4294967296L) {
        break label817;
      }
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l2) });
      l3 = com.tencent.mm.ao.af.bjB().hxc();
      l2 = aW(l3, ((z)localObject).field_createTime / 1000L);
    }
    label817:
    for (;;)
    {
      ((z)localObject).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      I((z)localObject);
      boolean bool = com.tencent.mm.ao.af.bjB().F((z)localObject);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s", new Object[] { Boolean.valueOf(bool), paramString.UsD.Usy.UserName });
      j = paramString.Uax;
      if (bool) {}
      for (i = 0;; i = 7)
      {
        af.a(paramString, j, i);
        AppMethodBeat.o(208191);
        return localObject;
        i = 0;
        break;
        label728:
        l1 = bq.beS();
        break label494;
        label736:
        ((z)localObject).field_createTime = (com.tencent.mm.ao.af.bjB().hwW() + 1000L);
        break label501;
        label754:
        if (j == 0)
        {
          l1 = UL(paramMap.field_orderFlag);
          break label557;
        }
        paramMap = com.tencent.mm.ao.af.bjB().asp(j - 1);
        if (paramMap == null)
        {
          Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
          l1 = l2;
          break label557;
        }
        l1 = UL(paramMap.field_orderFlag);
        break label557;
      }
    }
  }
  
  public static boolean bQ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(208234);
    if (!hxn())
    {
      AppMethodBeat.o(208234);
      return paramBoolean;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(208234);
      return true;
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(208234);
      return false;
    }
    long l = System.currentTimeMillis();
    paramInt = p.bcH();
    if (l - VeL < paramInt * 1000)
    {
      AppMethodBeat.o(208234);
      return true;
    }
    AppMethodBeat.o(208234);
    return false;
  }
  
  public static void bo(ca paramca)
  {
    AppMethodBeat.i(124662);
    if (paramca == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.OS(paramca.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (com.tencent.mm.model.ab.Lj(paramca.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramca.field_talker);
    if ((localas != null) && (d.rk(localas.field_type)) && (!localas.hxX()))
    {
      AppMethodBeat.o(124662);
      return;
    }
    int m = 0;
    int k = -1;
    int j = 0;
    long l1 = 0L;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    int n = 0;
    Object localObject2 = bq.RR(paramca.hxy);
    if (localObject2 != null)
    {
      m = ((bq.b)localObject2).luq;
      k = ((bq.b)localObject2).serviceType;
      j = ((bq.b)localObject2).lur;
      l1 = ((bq.b)localObject2).luv;
      if ((((bq.b)localObject2).luw & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bq.b)localObject2).luw & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bq.b)localObject2).luw & 0x4) != 0L)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramca.field_talker, Long.valueOf(((bq.b)localObject2).luw) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bq.b)localObject2).luw & 0x40) != 0L) && (localas != null) && (d.rk(localas.field_type)))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((paramca.getType() == 34) || (paramca.getType() == 3))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(paramca.getType()) });
      bool1 = false;
    }
    Object localObject1;
    for (;;)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b, msgId=%d, svrId=%d", new Object[] { paramca.field_talker, Boolean.valueOf(bool1), Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
      if (bool1) {
        break label541;
      }
      com.tencent.mm.pluginsdk.c.QRs = true;
      e(paramca, false);
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (paramca.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!paramca.hwA()) {
          break;
        }
        if (paramca.hwA()) {}
        for (localObject1 = ((a)com.tencent.mm.kernel.h.ae(a.class)).b(paramca.field_msgId, paramca.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).lpz))) {
            break label535;
          }
          bool1 = true;
          break;
        }
        label535:
        bool1 = false;
      }
    }
    label541:
    if ((localObject2 != null) && ((((bq.b)localObject2).luw & 0x2) != 0L))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramca.field_talker, Long.valueOf(((bq.b)localObject2).luw) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.c.QRs = true;
    localObject2 = com.tencent.mm.ao.af.bjB().ad(paramca.field_msgId, "msgId");
    if (localObject2 == null)
    {
      localObject1 = new z();
      ((z)localObject1).field_msgId = paramca.field_msgId;
      ((z)localObject1).field_msgSvrId = paramca.field_msgSvrId;
      ((z)localObject1).field_content = paramca.field_content;
      ((z)localObject1).field_type = paramca.getType();
      ((z)localObject1).field_talker = paramca.field_talker;
      ((z)localObject1).field_talkerId = paramca.field_talkerId;
      ((z)localObject1).field_createTime = paramca.field_createTime;
      ((z)localObject1).field_imgPath = paramca.field_imgPath;
      ((z)localObject1).pp(paramca.hxx);
      ((z)localObject1).Ip(paramca.hxy);
      ((z)localObject1).field_bizClientMsgId = paramca.field_bizClientMsgId;
      if (i != 0) {
        ((z)localObject1).jR(1);
      }
      if ((localas == null) || (!localas.ayn())) {
        break label1018;
      }
    }
    label1018:
    for (((z)localObject1).field_placeTop = 1;; ((z)localObject1).field_placeTop = 0)
    {
      if (localObject2 != null) {
        break label1027;
      }
      ((z)localObject1).field_status = paramca.field_status;
      ((z)localObject1).field_hasShow = 0;
      long l3 = com.tencent.mm.ao.af.bjB().hwv();
      long l4 = aW(l3, ((z)localObject1).field_createTime / 1000L);
      long l2 = l4;
      if (l4 >= 4294967296L)
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.ao.af.bjB().hxc();
        l2 = aW(l3, ((z)localObject1).field_createTime / 1000L);
      }
      ((z)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      I((z)localObject1);
      ((z)localObject1).field_isExpand = bool2;
      com.tencent.mm.ao.af.bjB().F((z)localObject1);
      if (!lvz)
      {
        lvz = true;
        com.tencent.e.h.ZvG.a(new ab.3(), 1000L, "BizTimeLineInfoStorageThread");
      }
      paramca = ad.Vfe;
      if (ad.hxv())
      {
        paramca = ad.Vfe;
        ad.a(0, null, 0L);
      }
      paramca = y.VdH;
      y.a(y.b.VdL);
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((z)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
    }
    label1027:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg updateBySvrId");
    com.tencent.mm.ao.af.bjB().G((z)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void bp(ca paramca)
  {
    AppMethodBeat.i(124676);
    if (paramca == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    com.tencent.mm.ao.af.bjB().UI(paramca.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static void bvu(String paramString)
  {
    AppMethodBeat.i(208190);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(208190);
      return;
    }
    int i = paramString.indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = XmlParser.parseXml(paramString.substring(i), "sysmsg", null);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
        AppMethodBeat.o(208190);
      }
    }
    else
    {
      AppMethodBeat.o(208190);
      return;
    }
    if (af.cb((Map)localObject1))
    {
      af.cd((Map)localObject1);
      AppMethodBeat.o(208190);
      return;
    }
    paramString = ca((Map)localObject1);
    af.a(paramString, (Map)localObject1);
    Object localObject1 = com.tencent.mm.ao.af.bjB().hwU();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      af.a(paramString, paramString.Uax, 1);
      AppMethodBeat.o(208190);
      return;
    }
    Object localObject2 = MultiProcessMMKV.getSingleMMKV("brandService");
    if (paramString.Uax != 2)
    {
      if (((z)localObject1).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
        af.a(paramString, paramString.Uax, 2);
        AppMethodBeat.o(208190);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
      com.tencent.mm.kernel.h.aHE();
      ((MultiProcessMMKV)localObject2).encode(com.tencent.mm.kernel.b.aGq(), "");
    }
    if (!af.b(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      af.a(paramString, paramString.Uax, 3);
      AppMethodBeat.o(208190);
      return;
    }
    i = paramString.pos;
    long l4 = paramString.weight;
    if ((i < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
      af.a(paramString, paramString.Uax, 4);
      AppMethodBeat.o(208190);
      return;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
    if (af.g(paramString))
    {
      af.a(paramString, paramString.Uax, 5);
      AppMethodBeat.o(208190);
      return;
    }
    long l3 = com.tencent.mm.ao.af.bjB().hxb();
    if (af.asy(paramString.style))
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString.UsD.Usy.UserName);
      if ((localObject2 != null) && (d.rk(((ax)localObject2).field_type)))
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { paramString.UsD.Usy.UserName });
        af.a(paramString, paramString.Uax, 6);
        AppMethodBeat.o(208190);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 1L, 1L, false);
    long l2 = com.tencent.mm.ao.af.bjB().hwW();
    localObject2 = new z();
    ((z)localObject2).field_msgId = com.tencent.mm.ao.af.bjB().hxf();
    ((z)localObject2).field_msgSvrId = 0L;
    ((z)localObject2).field_type = 620757041;
    ((z)localObject2).field_talker = paramString.UsD.Usy.UserName;
    ((z)localObject2).field_talkerId = 0;
    ((z)localObject2).field_createTime = (l2 - 1000L);
    ((z)localObject2).pp(1);
    ((z)localObject2).field_status = 3;
    af.a((z)localObject2, paramString);
    ((z)localObject2).c(paramString);
    long l1 = 0L;
    if (l4 >= 0L)
    {
      l1 = Math.min(l4, 255L);
      if (paramString.Uax != 2) {
        break label752;
      }
      l2 = aX(l3, ((z)localObject2).field_createTime / 1000L);
    }
    for (;;)
    {
      if (paramString.Uax == 2)
      {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(208190);
          return;
          if (i == 0)
          {
            l1 = UL(((z)localObject1).field_orderFlag);
            ((z)localObject2).field_createTime = (l2 + 1000L);
            break;
          }
          localObject1 = com.tencent.mm.ao.af.bjB().asp(i - 1);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
            break;
          }
          l1 = UL(((z)localObject1).field_orderFlag);
          ((z)localObject1).field_createTime -= 1000L;
          break;
          label752:
          l2 = aW(l3, ((z)localObject2).field_createTime / 1000L);
          continue;
        }
        l3 -= 1L;
        ((z)localObject2).field_hasShow = 1;
        ((z)localObject2).field_status = 4;
        ((z)localObject2).jR(2);
      }
    }
    for (;;)
    {
      ((z)localObject2).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      I((z)localObject2);
      localObject1 = com.tencent.mm.ao.af.bjB();
      boolean bool;
      int j;
      if (paramString.Uax != 2)
      {
        bool = true;
        bool = ((aa)localObject1).c((z)localObject2, bool);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s, redDotFlag=%d ", new Object[] { Boolean.valueOf(bool), paramString.UsD.Usy.UserName, Integer.valueOf(paramString.Uax) });
        j = paramString.Uax;
        if (!bool) {
          break label923;
        }
      }
      label923:
      for (i = 0;; i = 7)
      {
        af.a(paramString, j, i);
        AppMethodBeat.o(208190);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public static void bvv(String paramString)
  {
    VeI = paramString;
  }
  
  public static void c(final Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.jQG == null) || (parama.jQG.RIF == null))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    int j = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    Object localObject1 = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.c)localObject1).Gz(j))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(124666);
      return;
    }
    int i = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", new Object[] { Integer.valueOf(i) });
    parama = com.tencent.mm.platformtools.z.a(parama.jQG.RIF);
    localObject1 = MultiProcessMMKV.getSingleMMKV("brandService");
    Object localObject2;
    long l;
    String str1;
    int k;
    int m;
    int n;
    label369:
    Object localObject3;
    if (i == 0)
    {
      localObject2 = new StringBuilder("BizLatestRecommendCardInfo");
      com.tencent.mm.kernel.h.aHE();
      ((MultiProcessMMKV)localObject1).encode(com.tencent.mm.kernel.b.aGq(), parama);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1149L, 0L, 1L, false);
      l = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
      str1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
      k = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
      m = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
      n = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
      localObject1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.CardId");
      localObject2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.ExpType");
      i = 0;
      if (i >= 2) {
        break label663;
      }
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i != 0) {
        break label655;
      }
    }
    label655:
    for (parama = "";; parama = Integer.valueOf(1))
    {
      String str2 = parama;
      localObject3 = (String)paramMap.get(str2 + ".AppMsg.Title");
      if (Util.isNullOrNil((String)localObject3)) {
        break label663;
      }
      parama = (String)paramMap.get(str2 + ".UserName");
      str2 = (String)paramMap.get(str2 + ".AppMsg.ContentUrl");
      localObject3 = com.tencent.mm.pluginsdk.ui.tools.ab.aXb((String)localObject3);
      str2 = com.tencent.mm.pluginsdk.ui.tools.ab.aXb(str2);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.h.IzE.a(18106, new Object[] { parama, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject3, str2 });
      i += 1;
      break label369;
      if (i == 1)
      {
        com.tencent.e.h.ZvG.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124656);
            ab.aa(this.nHw, paramMap);
            Object localObject = ad.Vfe;
            if (ad.hxv())
            {
              localObject = ad.Vfe;
              ad.a(0, null, 0L);
            }
            localObject = y.VdH;
            y.a(y.b.VdL);
            AppMethodBeat.o(124656);
          }
        }, "BizInsertTlRecCardThreadImmediately");
        break;
      }
      if (i != 2) {
        break;
      }
      localObject1 = ac.VeT;
      ac.bvw(parama);
      parama = ac.VeT;
      ac.UO(3L);
      break;
    }
    label663:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { str1, Long.valueOf(l) });
    if (j == 101)
    {
      paramMap = l.PuB;
      l.Tt(83L);
      paramMap = s.Vdo;
      s.a(k, m, n, 3, j, l, (String)localObject1, (String)localObject2, "");
    }
    AppMethodBeat.o(124666);
  }
  
  private static eqg ca(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    eqg localeqg = new eqg();
    localeqg.UsD = new eqb();
    localeqg.UsD.SwE = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localeqg.UsD.RXL = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localeqg.UsD.Usy = new eqd();
    localeqg.UsD.Usy.RRW = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localeqg.UsD.Usy.UserName = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localeqg.UsD.Usy.rWI = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localeqg.UsD.Usy.UsA = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localeqg.UsD.Usy.mVB = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new eqf();
    Object localObject3 = new aoy();
    int i = 0;
    Object localObject1;
    if (i < 20)
    {
      StringBuilder localStringBuilder = new StringBuilder(".sysmsg.BizAccountRecommend.BizAccount.NegativeFeedbackReason");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(i))
      {
        localObject1 = (String)paramMap.get(localObject1);
        if (Util.isNullOrNil((String)localObject1)) {
          break label295;
        }
        ((aoy)localObject3).RXF.add(localObject1);
        i += 1;
        break;
      }
    }
    label295:
    ((aoy)localObject3).RXG = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((eqf)localObject2).UsC = ((aoy)localObject3);
    localeqg.UsD.Usz = ((eqf)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new eqc();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((eqc)localObject2).fwr = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (Util.isNullOrNil(((eqc)localObject2).fwr)) {
          break label921;
        }
        ((eqc)localObject2).RTi = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((eqc)localObject2).RTk = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((eqc)localObject2).RTm = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((eqc)localObject2).RTn = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((eqc)localObject2).RTo = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((eqc)localObject2).lpx = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((eqc)localObject2).RTv = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((eqc)localObject2).RTw = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((eqc)localObject2).RTx = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((eqc)localObject2).RTy = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((eqc)localObject2).CreateTime = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((eqc)localObject2).RXH = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        ((eqc)localObject2).RXI = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VoiceDuration"), -1);
        localeqg.UsD.RXM.add(localObject2);
        i += 1;
        break;
      }
    }
    label921:
    localeqg.pos = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localeqg.weight = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localeqg.Uaw = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localeqg.UsI = ((String)paramMap.get(".sysmsg.BizAccountRecommend.CardId"));
    localeqg.style = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    localeqg.fMh = ((String)paramMap.get(".sysmsg.BizAccountRecommend.ExtraData"));
    localeqg.Uax = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    AppMethodBeat.o(124669);
    return localeqg;
  }
  
  public static void e(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(208199);
    if (Util.isEqual(paramca.field_talker, VeI))
    {
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { VeI });
      AppMethodBeat.o(208199);
      return;
    }
    z localz2 = com.tencent.mm.ao.af.bjD().ad(paramca.field_msgSvrId, "msgSvrId");
    z localz1;
    if (localz2 == null)
    {
      localz1 = new z();
      if (!paramBoolean) {
        break label188;
      }
    }
    label188:
    for (localz1.field_msgId = com.tencent.mm.ao.af.bjD().hxz();; localz1.field_msgId = paramca.field_msgId)
    {
      localz1.field_msgSvrId = paramca.field_msgSvrId;
      localz1.field_content = paramca.field_content;
      localz1.field_type = paramca.getType();
      localz1.field_talker = paramca.field_talker;
      localz1.field_talkerId = paramca.field_talkerId;
      localz1.field_createTime = paramca.field_createTime;
      localz1.field_imgPath = paramca.field_imgPath;
      localz1.pp(paramca.hxx);
      localz1.Ip(paramca.hxy);
      localz1.field_status = paramca.field_status;
      if (localz2 != null) {
        break label199;
      }
      com.tencent.mm.ao.af.bjD().F(localz1);
      AppMethodBeat.o(208199);
      return;
      localz1 = localz2;
      break;
    }
    label199:
    com.tencent.mm.ao.af.bjD().G(localz1);
    AppMethodBeat.o(208199);
  }
  
  public static int getSessionId()
  {
    return fwM;
  }
  
  public static void hxg()
  {
    AppMethodBeat.i(124667);
    com.tencent.e.h.ZvG.d(new ab.2(), "BizInsertTlRecCardThread");
    ac localac = ac.VeT;
    ac.hxr();
    AppMethodBeat.o(124667);
  }
  
  public static void hxh()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(124668);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
    StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.h.aHE();
    bvu(localMultiProcessMMKV.decodeString(com.tencent.mm.kernel.b.aGq()));
    AppMethodBeat.o(124668);
  }
  
  public static void hxi()
  {
    AppMethodBeat.i(208196);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAr, 1) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1378L, 1L, 1L, false);
        com.tencent.mm.ao.af.bjB().hxa();
        com.tencent.mm.ao.af.bjD().hxa();
      }
      AppMethodBeat.o(208196);
      return;
    }
  }
  
  public static void hxj()
  {
    AppMethodBeat.i(124678);
    bw localbw = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR();
    az localaz = localbw.bwx("officialaccounts");
    if (localaz == null) {
      localaz = new az("officialaccounts");
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject3 = com.tencent.mm.ao.af.bjD().hwU();
      Object localObject2 = com.tencent.mm.ao.af.bjB().hwU();
      z localz = com.tencent.mm.ao.af.bjB().hwV();
      long l1;
      if (localz != null)
      {
        l1 = localz.field_createTime;
        if (localObject3 == null) {
          break label211;
        }
      }
      long l3;
      Object localObject4;
      Object localObject5;
      label211:
      for (long l2 = ((z)localObject3).field_createTime;; l2 = 0L)
      {
        localObject1 = com.tencent.mm.pluginsdk.model.b.XW(Math.max(l1, l2));
        localaz.ro(256);
        localaz.ro(128);
        if (!((b.e)localObject1).sTm) {
          break label368;
        }
        l3 = com.tencent.mm.pluginsdk.model.b.hgq();
        localObject4 = com.tencent.mm.pluginsdk.model.b.hgp();
        localObject5 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG((String)localObject4);
        if ((localObject5 != null) && (((as)localObject5).hxX())) {
          break label217;
        }
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "ct not BizContact");
        i = 0;
        if (i == 0) {
          break label368;
        }
        AppMethodBeat.o(124678);
        return;
        l1 = 0L;
        break;
      }
      label217:
      Object localObject6 = com.tencent.mm.model.aa.PJ((String)localObject4);
      localObject6 = MMApplicationContext.getContext().getString(b.f.biz_live_digest, new Object[] { localObject6 });
      localaz.EB(l3);
      localaz.Ja((String)localObject6);
      localaz.Jb((String)localObject4);
      localaz.rn(128);
      if (((b.e)localObject1).fUV) {
        localaz.rn(256);
      }
      if ((localObject5 != null) && (((as)localObject5).ayn()))
      {
        i = 1;
        label304:
        if (i == 0) {
          break label340;
        }
        localaz.rn(32);
        label315:
        if (!bool2) {
          break label350;
        }
        localbw.e(localaz);
      }
      for (;;)
      {
        i = 1;
        break;
        i = 0;
        break label304;
        label340:
        localaz.ro(32);
        break label315;
        label350:
        localbw.a(localaz, localaz.field_username);
      }
      label368:
      Object localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
      com.tencent.mm.pluginsdk.model.b.hgl();
      if (localObject2 != null) {}
      for (int i = com.tencent.mm.ao.af.bjB().UH(((z)localObject2).field_orderFlag);; i = 0)
      {
        int j = com.tencent.mm.ao.af.bjD().cHo();
        boolean bool1;
        if (j > 0) {
          if (l2 <= l1)
          {
            if (localObject3 == null) {
              break label833;
            }
            localObject1 = v.Vdz;
            l3 = ((z)localObject3).field_msgId;
            if (v.Vdy == -1) {
              v.Vdy = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAP, 0);
            }
            if (v.Vdy == 0)
            {
              Log.i("MicroMsg.BizMainCellExposeHelper", "isNotifyMsgShowFirst  mBizNotifyMsgPriorityShowSwitch == 0");
              bool1 = false;
              if (!bool1) {
                break label833;
              }
            }
          }
          else
          {
            localaz.ro(16);
            localaz.pH(j);
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          if ((localObject1 != null) && (((z)localObject1).field_msgId != 0L)) {
            break label873;
          }
          Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
          localaz.hyE();
          if (!bool2) {
            localbw.a(localaz, localaz.field_username);
          }
          AppMethodBeat.o(124678);
          return;
          localObject1 = String.valueOf(l3);
          long l4 = com.tencent.mm.ao.c.lEh.decodeLong(v.bvl((String)localObject1), 0L) / 1000L;
          int k = com.tencent.mm.ao.c.lEh.decodeInt(v.bvm((String)localObject1), 0);
          if (v.Vdv == -1) {
            v.Vdv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAN, 0);
          }
          if (v.Vdw == -1L) {
            v.Vdw = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAM, 0L);
          }
          if (v.Vdx == -1) {
            v.Vdx = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAO, 0);
          }
          long l5 = hxk();
          if ((k <= v.Vdv) && (l4 <= v.Vdw) && (i <= v.Vdx) && (l3 != l5)) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.BizMainCellExposeHelper", "isNotifyMsgShowFirst totalExposeTime:" + l4 + "   " + v.Vdw + "   totalExposeCount:" + k + "  " + v.Vdv + "   unReadCount:" + i + "   " + v.Vdx + "   msgIdKey:" + (String)localObject1 + "  lastClickedNotifyMsgId:" + l5 + "  result:" + bool1);
            break;
          }
          label833:
          localaz.rn(16);
          localaz.pH(i);
          localObject1 = localObject2;
          continue;
          localaz.rn(16);
          localaz.pH(i);
          localObject1 = localObject2;
        }
        label873:
        if ((localObject1 == localObject2) && (((z)localObject1).field_placeTop == 1))
        {
          localaz.rn(32);
          if (localObject1 == localObject3)
          {
            if (((z)localObject1).field_msgId != hxk()) {
              break label1673;
            }
            localaz.ro(64);
          }
          localObject2 = new ca();
          ((ca)localObject2).setContent(((z)localObject1).field_content);
          ((ca)localObject2).Jm(((z)localObject1).field_talker);
          ((ca)localObject2).setStatus(((z)localObject1).field_status);
          if (!((z)localObject1).hwC()) {
            break label1683;
          }
          ((ca)localObject2).setCreateTime(((an)localObject1).hxA);
          ((ca)localObject2).setMsgId(((z)localObject1).field_msgId);
          ((ca)localObject2).setType(((z)localObject1).field_type);
          ((ca)localObject2).Ip(((an)localObject1).hxy);
          ((ca)localObject2).Jn(((z)localObject1).field_imgPath);
          l3 = Math.min(cm.bfD(), localaz.field_conversationTime);
          l1 = Math.max(l2, l1);
          localaz.bq((ca)localObject2);
          localaz.setContent(((et)localObject2).field_talker + ":" + ((et)localObject2).field_content);
          localaz.IZ(Integer.toString(((ca)localObject2).getType()));
          localObject6 = localbw.abK();
          if (localObject6 != null)
          {
            localObject3 = new PString();
            localObject4 = new PString();
            localObject5 = new PInt();
            ((ca)localObject2).Jm("officialaccounts");
            ((ca)localObject2).setContent(localaz.field_content);
            ((bw.b)localObject6).a((ca)localObject2, (PString)localObject3, (PString)localObject4, (PInt)localObject5, true);
            if (((z)localObject1).hwB())
            {
              j = 0;
              localObject2 = ((z)localObject1).hwL();
              i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((eqg)localObject2).style == 1001)
                {
                  i = j;
                  if (((eqg)localObject2).UsH != null)
                  {
                    i = j;
                    if (!Util.isNullOrNil(((eqg)localObject2).UsH.SwG))
                    {
                      ((PString)localObject3).value = ((eqg)localObject2).UsH.SwG;
                      i = 1;
                    }
                  }
                }
              }
              if ((i != 0) || (localObject2 == null) || (((eqg)localObject2).UsD == null) || (Util.isNullOrNil(((eqg)localObject2).UsD.SwE))) {
                break label1696;
              }
              ((PString)localObject3).value = ((eqg)localObject2).UsD.SwE;
              if (((((eqg)localObject2).style == 101) || (((eqg)localObject2).style == 102) || (((eqg)localObject2).style == 103)) && (((eqg)localObject2).UsF != null) && (!Util.isNullOrNil(((eqg)localObject2).UsF.SwG))) {
                ((PString)localObject3).value = ((eqg)localObject2).UsF.SwG;
              }
            }
            if (((z)localObject1).hwC()) {
              ((PString)localObject3).value = MMApplicationContext.getResources().getString(b.f.biz_msg_ad_card);
            }
            if (((z)localObject1).hwD())
            {
              if (((z)localObject1).Vej == null) {
                break label1717;
              }
              localObject2 = ((z)localObject1).Vej.lpM;
              label1407:
              ((PString)localObject3).value = ((String)localObject2);
            }
            if ((((z)localObject1).hwH()) || (((z)localObject1).hwG()) || (((z)localObject1).hwE()))
            {
              localObject2 = ag.M((z)localObject1);
              if (!Util.isNullOrNil((String)localObject2)) {
                ((PString)localObject3).value = ((String)localObject2);
              }
            }
            localaz.Ja(((PString)localObject3).value);
            localaz.Jb(((PString)localObject4).value);
            localaz.pK(((PInt)localObject5).value);
          }
          localaz.EB(Math.max(l3, l1));
          if (!bool2) {
            break label1748;
          }
          l1 = localbw.e(localaz);
          label1518:
          localObject2 = MultiProcessMMKV.getSingleMMKV("brandService");
          if (localObject2 != null)
          {
            ((MultiProcessMMKV)localObject2).encode("BizLastMsgId", ((z)localObject1).field_msgId);
            ((MultiProcessMMKV)localObject2).encode("BizLastMsgTime", ((z)localObject1).field_createTime);
            if ((localz == null) || (!localz.hwB())) {
              break label1768;
            }
            ((MultiProcessMMKV)localObject2).encode("BizLastRecCardId", localz.field_recommendCardId);
          }
        }
        for (;;)
        {
          label922:
          label979:
          Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d, unread %d, msgId %d, talker:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), Long.valueOf(localaz.field_conversationTime), Integer.valueOf(localaz.field_unReadCount), Long.valueOf(((z)localObject1).field_msgId), ((z)localObject1).field_talker });
          label1359:
          AppMethodBeat.o(124678);
          return;
          localaz.ro(32);
          break;
          label1673:
          localaz.rn(64);
          break label922;
          label1683:
          ((ca)localObject2).setCreateTime(((z)localObject1).field_createTime);
          break label979;
          label1696:
          if (i != 0) {
            break label1359;
          }
          ((PString)localObject3).value = MMApplicationContext.getResources().getString(b.f.biz_msg_rec_card);
          break label1359;
          label1717:
          localObject2 = com.tencent.mm.plugin.biz.b.b.shr;
          ((z)localObject1).Vej = com.tencent.mm.plugin.biz.b.b.aoN(((z)localObject1).field_content);
          localObject2 = ((z)localObject1).Vej.lpM;
          break label1407;
          label1748:
          l1 = localbw.a(localaz, localaz.field_username);
          break label1518;
          label1768:
          ((MultiProcessMMKV)localObject2).removeValueForKey("BizLastRecCardId");
        }
      }
    }
  }
  
  private static long hxk()
  {
    AppMethodBeat.i(208221);
    if (VeJ == 0L) {
      VeJ = MMApplicationContext.getDefaultPreference().getLong("biz_time_line_last_notify_msg_id", -1L);
    }
    long l = VeJ;
    AppMethodBeat.o(208221);
    return l;
  }
  
  public static boolean hxl()
  {
    AppMethodBeat.i(208228);
    long l = System.currentTimeMillis();
    int i = hxm();
    if ((VeL != 0L) && (VeM != 0L) && (l - VeL < i * 1000))
    {
      AppMethodBeat.o(208228);
      return true;
    }
    AppMethodBeat.o(208228);
    return false;
  }
  
  public static int hxm()
  {
    AppMethodBeat.i(208238);
    if (VeN != 0)
    {
      i = VeN;
      AppMethodBeat.o(208238);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzW, 180);
    VeN = i;
    AppMethodBeat.o(208238);
    return i;
  }
  
  public static boolean hxn()
  {
    AppMethodBeat.i(208243);
    boolean bool;
    if (VeO != null)
    {
      bool = VeO.booleanValue();
      AppMethodBeat.o(208243);
      return bool;
    }
    Object localObject = MultiProcessMMKV.getSingleMMKV("brandService");
    int i;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      i = 1;
      if (i == 0) {
        break label100;
      }
      i = 1;
      label60:
      i = ((MultiProcessMMKV)localObject).decodeInt("BizTimeLineOpenStatus", i);
      if (i != 1) {
        break label105;
      }
      VeO = Boolean.TRUE;
    }
    for (;;)
    {
      bool = VeO.booleanValue();
      AppMethodBeat.o(208243);
      return bool;
      i = 0;
      break;
      label100:
      i = -1;
      break label60;
      label105:
      if (i == 0)
      {
        VeO = Boolean.FALSE;
      }
      else
      {
        localObject = p.lrH;
        bool = p.a.bcL();
        VeO = Boolean.valueOf(bool);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isRecFeedsOpen svrOpen %b", new Object[] { Boolean.valueOf(bool) });
      }
    }
  }
  
  public static boolean hxo()
  {
    AppMethodBeat.i(176159);
    if (VeP != null)
    {
      bool = VeP.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vAw, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      VeP = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { VeP });
      bool = VeP.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */