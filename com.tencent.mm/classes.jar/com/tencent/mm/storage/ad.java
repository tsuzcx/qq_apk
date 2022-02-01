package com.tencent.mm.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.ap;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.message.m;
import com.tencent.mm.message.u;
import com.tencent.mm.model.br;
import com.tencent.mm.model.br.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.p;
import com.tencent.mm.model.p.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.biz.b.f;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webcanvas.j;
import com.tencent.mm.pluginsdk.model.c.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.fle;
import com.tencent.mm.protocal.protobuf.flf;
import com.tencent.mm.protocal.protobuf.flg;
import com.tencent.mm.protocal.protobuf.fli;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ad
{
  private static String acGe = null;
  private static long acGf = 0L;
  public static boolean acGg;
  public static long acGh = 0L;
  public static long acGi = 0L;
  public static int acGj = 0;
  private static Boolean acGk = null;
  private static Boolean acGl = null;
  private static int hBm = 0;
  private static boolean omW;
  
  static
  {
    acGg = false;
    omW = false;
  }
  
  public static void H(ab paramab)
  {
    AppMethodBeat.i(124670);
    while (com.tencent.mm.an.af.bHl().yF(paramab.field_orderFlag) != null) {
      paramab.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static void HV(int paramInt)
  {
    hBm = paramInt;
  }
  
  public static void KC(boolean paramBoolean)
  {
    acGg = paramBoolean;
  }
  
  public static ab a(String paramString, Map<String, String> paramMap, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248570);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(248570);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
      AppMethodBeat.o(248570);
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
          AppMethodBeat.o(248570);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(248570);
        return null;
      }
    }
    paramMap = com.tencent.mm.an.af.bHl().iYx();
    paramString = cy((Map)localObject);
    ah.a(paramString, (Map)localObject);
    if (!ah.c(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
      ah.a(paramString, paramString.abrz, 3);
      AppMethodBeat.o(248570);
      return null;
    }
    int j = paramString.pos;
    long l4 = paramString.weight;
    if ((j < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
      ah.a(paramString, paramString.abrz, 4);
      AppMethodBeat.o(248570);
      return null;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
    if ((ah.e(paramString)) && (!BuildInfo.DEBUG))
    {
      ah.a(paramString, paramString.abrz, 5);
      AppMethodBeat.o(248570);
      return null;
    }
    if (paramBoolean) {}
    for (long l2 = com.tencent.mm.an.af.bHl().iYD(); ah.ayN(paramString.style); l2 = com.tencent.mm.an.af.bHl().iYa())
    {
      localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString.abLK.abLF.UserName);
      if ((localObject == null) || (!d.rs(((az)localObject).field_type))) {
        break;
      }
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", new Object[] { paramString.abLK.abLF.UserName });
      ah.a(paramString, paramString.abrz, 6);
      AppMethodBeat.o(248570);
      return null;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 1L, 1L, false);
    localObject = new ab();
    ((ab)localObject).field_msgId = com.tencent.mm.an.af.bHl().iYH();
    ((ab)localObject).field_msgSvrId = 0L;
    ((ab)localObject).field_type = 620757041;
    ((ab)localObject).field_talker = paramString.abLK.abLF.UserName;
    ((ab)localObject).field_talkerId = 0;
    long l1;
    label518:
    label525:
    long l3;
    if (paramString.abLN == 1)
    {
      i = 1;
      if (i == 0) {
        break label832;
      }
      if (Math.abs(paramString.abry * 1000L - br.bCJ()) > 86400000L) {
        break label824;
      }
      l1 = paramString.abry * 1000L;
      ((ab)localObject).field_createTime = l1;
      ((ab)localObject).po(1);
      ((ab)localObject).field_status = 3;
      ah.a((ab)localObject, paramString);
      ((ab)localObject).b(paramString);
      l3 = 0L;
      l1 = l3;
      if (paramMap != null)
      {
        if (l4 < 0L) {
          break label850;
        }
        l1 = Math.min(l4, yU(paramMap.field_orderFlag));
      }
      label581:
      l3 = l1;
      if (paramBoolean)
      {
        l3 = l1;
        if (paramInt >= 0)
        {
          l3 = l1;
          if (paramInt < 256) {
            l3 = Math.min(paramInt, l1);
          }
        }
      }
      l4 = bH(l2, ((ab)localObject).field_createTime / 1000L);
      l1 = l4;
      if (l4 >= 4294967296L)
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l2 = com.tencent.mm.an.af.bHl().iYE();
        l1 = bH(l2, ((ab)localObject).field_createTime / 1000L);
      }
      ((ab)localObject).field_orderFlag = (l1 | 0xFF000000 & l3 << 24 | l2 << 32);
      H((ab)localObject);
      boolean bool = com.tencent.mm.an.af.bHl().E((ab)localObject);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s, msgId %d, weight %d, isInTimeLine=%b", new Object[] { Boolean.valueOf(bool), paramString.abLK.abLF.UserName, Long.valueOf(((ab)localObject).field_msgId), Long.valueOf(((ab)localObject).iYb()), Boolean.valueOf(paramBoolean) });
      i = paramString.abrz;
      if (!bool) {
        break label909;
      }
    }
    label909:
    for (paramInt = 0;; paramInt = 7)
    {
      ah.a(paramString, i, paramInt);
      AppMethodBeat.o(248570);
      return localObject;
      i = 0;
      break;
      label824:
      l1 = br.bCJ();
      break label518;
      label832:
      ((ab)localObject).field_createTime = (com.tencent.mm.an.af.bHl().iYz() + 1000L);
      break label525;
      label850:
      if (j == 0)
      {
        l1 = yU(paramMap.field_orderFlag);
        break label581;
      }
      paramMap = com.tencent.mm.an.af.bHl().ayB(j - 1);
      if (paramMap == null)
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
        l1 = l3;
        break label581;
      }
      l1 = yU(paramMap.field_orderFlag);
      break label581;
    }
  }
  
  public static ab aj(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(248557);
    paramString = a(paramString, paramMap, 255, false);
    AppMethodBeat.o(248557);
    return paramString;
  }
  
  public static void bE(cc paramcc)
  {
    AppMethodBeat.i(124662);
    if (paramcc == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.Hh(paramcc.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (au.bwE(paramcc.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramcc.field_talker);
    if ((localau != null) && (d.rs(localau.field_type)) && (!localau.iZC()))
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
    Object localObject2 = br.JP(paramcc.jUr);
    if (localObject2 != null)
    {
      m = ((br.b)localObject2).olP;
      k = ((br.b)localObject2).serviceType;
      j = ((br.b)localObject2).olQ;
      l1 = ((br.b)localObject2).olU;
      if ((((br.b)localObject2).olV & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((br.b)localObject2).olV & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((br.b)localObject2).olV & 0x4) != 0L)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramcc.field_talker, Long.valueOf(((br.b)localObject2).olV) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((br.b)localObject2).olV & 0x40) != 0L) && (localau != null) && (d.rs(localau.field_type)))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "not fans msg should not be is contact");
      AppMethodBeat.o(124662);
      return;
    }
    if ((paramcc.getType() == 34) || (paramcc.getType() == 3))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "alvinluo doInsertBizTimeLineMsg msg: %d not timeline", new Object[] { Integer.valueOf(paramcc.getType()) });
      bool1 = false;
    }
    Object localObject1;
    for (;;)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg %s, isTimeLine %b, msgId=%d, svrId=%d", new Object[] { paramcc.field_talker, Boolean.valueOf(bool1), Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
      if (bool1) {
        break label540;
      }
      com.tencent.mm.pluginsdk.c.XNo = true;
      e(paramcc, false);
      AppMethodBeat.o(124662);
      return;
      if ((m != 3) && (j != 9) && (j != 15) && (j != 17)) {
        break;
      }
      if (paramcc.getType() == 1)
      {
        bool1 = true;
      }
      else
      {
        if (!paramcc.iYe()) {
          break;
        }
        if (paramcc.iYe()) {}
        for (localObject1 = ((a)com.tencent.mm.kernel.h.ax(a.class)).c(paramcc.field_msgId, paramcc.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).nUC))) {
            break label534;
          }
          bool1 = true;
          break;
        }
        label534:
        bool1 = false;
      }
    }
    label540:
    if ((localObject2 != null) && ((((br.b)localObject2).olV & 0x2) != 0L))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramcc.field_talker, Long.valueOf(((br.b)localObject2).olV) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.c.XNo = true;
    localObject2 = com.tencent.mm.an.af.bHl().aq(paramcc.field_msgId, "msgId");
    if (localObject2 == null)
    {
      localObject1 = new ab();
      ((ab)localObject1).field_msgId = paramcc.field_msgId;
      ((ab)localObject1).field_msgSvrId = paramcc.field_msgSvrId;
      ((ab)localObject1).field_content = paramcc.field_content;
      ((ab)localObject1).field_type = paramcc.getType();
      ((ab)localObject1).field_talker = paramcc.field_talker;
      ((ab)localObject1).field_talkerId = paramcc.field_talkerId;
      ((ab)localObject1).field_createTime = paramcc.getCreateTime();
      ((ab)localObject1).field_imgPath = paramcc.field_imgPath;
      ((ab)localObject1).po(paramcc.jUq);
      ((ab)localObject1).AU(paramcc.jUr);
      ((ab)localObject1).field_bizClientMsgId = paramcc.field_bizClientMsgId;
      if (i != 0) {
        ((ab)localObject1).nH(1);
      }
      if ((localau == null) || (!localau.aSQ())) {
        break label995;
      }
    }
    label995:
    for (((ab)localObject1).field_placeTop = 1;; ((ab)localObject1).field_placeTop = 0)
    {
      if (localObject2 != null) {
        break label1004;
      }
      ((ab)localObject1).field_status = paramcc.field_status;
      ((ab)localObject1).field_hasShow = 0;
      long l3 = com.tencent.mm.an.af.bHl().iYa();
      long l4 = bH(l3, ((ab)localObject1).field_createTime / 1000L);
      long l2 = l4;
      if (l4 >= 4294967296L)
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.an.af.bHl().iYE();
        l2 = bH(l3, ((ab)localObject1).field_createTime / 1000L);
      }
      ((ab)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      H((ab)localObject1);
      ((ab)localObject1).field_isExpand = bool2;
      com.tencent.mm.an.af.bHl().E((ab)localObject1);
      if (!omW)
      {
        omW = true;
        com.tencent.threadpool.h.ahAA.a(new ad.3(), 1000L, "BizTimeLineInfoStorageThread");
      }
      paramcc = af.acGt;
      af.ayG(0);
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((ab)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
    }
    label1004:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg updateBySvrId");
    com.tencent.mm.an.af.bHl().F((ab)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void bF(cc paramcc)
  {
    AppMethodBeat.i(124676);
    if (paramcc == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    com.tencent.mm.an.af.bHl().yQ(paramcc.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static long bH(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWI, "");
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
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acWI, str);
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static long bI(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(248623);
    ab localab = com.tencent.mm.an.af.bHl().yN(paramLong1);
    if (localab == null)
    {
      AppMethodBeat.o(248623);
      return 604800L;
    }
    paramLong1 = localab.field_createTime / 1000L;
    AppMethodBeat.o(248623);
    return paramLong2 - (paramLong1 - 604800L);
  }
  
  public static void bvC(String paramString)
  {
    AppMethodBeat.i(248541);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(248541);
      return;
    }
    int i = paramString.indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = XmlParser.parseXml(paramString.substring(i), "sysmsg", null);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
        AppMethodBeat.o(248541);
      }
    }
    else
    {
      AppMethodBeat.o(248541);
      return;
    }
    if (ah.cz((Map)localObject1))
    {
      ah.cB((Map)localObject1);
      AppMethodBeat.o(248541);
      return;
    }
    paramString = cy((Map)localObject1);
    ah.a(paramString, (Map)localObject1);
    Object localObject2 = com.tencent.mm.an.af.bHl().iYx();
    if (localObject2 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      ah.a(paramString, paramString.abrz, 1);
      AppMethodBeat.o(248541);
      return;
    }
    MultiProcessMMKV.getSingleMMKV("brandService");
    if (paramString.abrz != 2)
    {
      if (((ab)localObject2).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
        ah.a(paramString, paramString.abrz, 2);
        AppMethodBeat.o(248541);
        return;
      }
      bvD("");
    }
    if (!ah.c(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      ah.a(paramString, paramString.abrz, 3);
      AppMethodBeat.o(248541);
      return;
    }
    i = paramString.pos;
    long l4 = paramString.weight;
    if ((i < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
      ah.a(paramString, paramString.abrz, 4);
      AppMethodBeat.o(248541);
      return;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
    if (ah.e(paramString))
    {
      ah.a(paramString, paramString.abrz, 5);
      AppMethodBeat.o(248541);
      return;
    }
    long l3 = com.tencent.mm.an.af.bHl().iYD();
    if (ah.ayN(paramString.style))
    {
      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString.abLK.abLF.UserName);
      if ((localObject1 != null) && (d.rs(((az)localObject1).field_type)))
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { paramString.abLK.abLF.UserName });
        ah.a(paramString, paramString.abrz, 6);
        AppMethodBeat.o(248541);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 1L, 1L, false);
    long l2 = com.tencent.mm.an.af.bHl().iYz();
    Object localObject1 = new ab();
    ((ab)localObject1).field_msgId = com.tencent.mm.an.af.bHl().iYH();
    ((ab)localObject1).field_msgSvrId = 0L;
    ((ab)localObject1).field_type = 620757041;
    ((ab)localObject1).field_talker = paramString.abLK.abLF.UserName;
    ((ab)localObject1).field_talkerId = 0;
    ((ab)localObject1).field_createTime = (l2 - 1000L);
    ((ab)localObject1).po(1);
    ((ab)localObject1).field_status = 3;
    ah.a((ab)localObject1, paramString);
    ((ab)localObject1).b(paramString);
    long l1 = 0L;
    if (l4 >= 0L)
    {
      l1 = Math.min(l4, 255L);
      if (paramString.abrz != 2) {
        break label720;
      }
      l2 = bI(l3, ((ab)localObject1).field_createTime / 1000L);
    }
    for (;;)
    {
      if (paramString.abrz == 2)
      {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(248541);
          return;
          if (i == 0)
          {
            l1 = yU(((ab)localObject2).field_orderFlag);
            ((ab)localObject1).field_createTime = (l2 + 1000L);
            break;
          }
          localObject2 = com.tencent.mm.an.af.bHl().ayB(i - 1);
          if (localObject2 == null)
          {
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
            break;
          }
          l1 = yU(((ab)localObject2).field_orderFlag);
          ((ab)localObject2).field_createTime -= 1000L;
          break;
          label720:
          l2 = bH(l3, ((ab)localObject1).field_createTime / 1000L);
          continue;
        }
        l3 -= 1L;
        ((ab)localObject1).field_hasShow = 1;
        ((ab)localObject1).field_status = 4;
        ((ab)localObject1).nH(2);
      }
    }
    for (;;)
    {
      ((ab)localObject1).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      H((ab)localObject1);
      localObject2 = com.tencent.mm.an.af.bHl();
      boolean bool;
      int j;
      if (paramString.abrz != 2)
      {
        bool = true;
        bool = ((ac)localObject2).c((ab)localObject1, bool);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s, redDotFlag=%d, msgId %d", new Object[] { Boolean.valueOf(bool), paramString.abLK.abLF.UserName, Integer.valueOf(paramString.abrz), Long.valueOf(((ab)localObject1).field_msgId) });
        j = paramString.abrz;
        if (!bool) {
          break label902;
        }
      }
      label902:
      for (i = 0;; i = 7)
      {
        ah.a(paramString, j, i);
        AppMethodBeat.o(248541);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public static void bvD(String paramString)
  {
    AppMethodBeat.i(248545);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
    StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.h.baC();
    localMultiProcessMMKV.encode(com.tencent.mm.kernel.b.aZs(), paramString);
    AppMethodBeat.o(248545);
  }
  
  public static void bvE(String paramString)
  {
    acGe = paramString;
  }
  
  public static void c(Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.mpN == null) || (parama.mpN.YFG == null))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    int j = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    Object localObject1 = (com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.api.c)localObject1).GY(j))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(124666);
      return;
    }
    int i = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", new Object[] { Integer.valueOf(i) });
    parama = w.a(parama.mpN.YFG);
    MultiProcessMMKV.getSingleMMKV("brandService");
    long l;
    String str2;
    int k;
    int m;
    int n;
    String str1;
    label338:
    Object localObject2;
    if (i == 0)
    {
      bvD(parama);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1149L, 0L, 1L, false);
      l = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
      str2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
      k = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
      m = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
      n = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
      localObject1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.CardId");
      str1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.ExpType");
      i = 0;
      if (i >= 2) {
        break label633;
      }
      localObject2 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i != 0) {
        break label625;
      }
    }
    label625:
    for (parama = "";; parama = Integer.valueOf(1))
    {
      String str3 = parama;
      localObject2 = (String)paramMap.get(str3 + ".AppMsg.Title");
      if (Util.isNullOrNil((String)localObject2)) {
        break label633;
      }
      parama = (String)paramMap.get(str3 + ".UserName");
      str3 = (String)paramMap.get(str3 + ".AppMsg.ContentUrl");
      localObject2 = com.tencent.mm.pluginsdk.ui.tools.aa.aUC((String)localObject2);
      str3 = com.tencent.mm.pluginsdk.ui.tools.aa.aUC(str3);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.h.OAn.b(18106, new Object[] { parama, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject2, str3 });
      i += 1;
      break label338;
      if (i == 1)
      {
        com.tencent.threadpool.h.ahAA.g(new ad.1(parama, paramMap), "BizInsertTlRecCardThreadImmediately");
        break;
      }
      if (i != 2) {
        break;
      }
      localObject1 = ae.acGm;
      ae.bvF(parama);
      parama = ae.acGm;
      ae.yX(3L);
      break;
    }
    label633:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { str2, Long.valueOf(l) });
    if (j == 101)
    {
      paramMap = j.WkY;
      j.xC(83L);
      paramMap = s.acEH;
      s.a(k, m, n, 3, j, l, (String)localObject1, str1, "");
    }
    AppMethodBeat.o(124666);
  }
  
  private static flj cy(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    flj localflj = new flj();
    localflj.abLK = new fle();
    localflj.abLK.Zxn = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localflj.abLK.YVH = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localflj.abLK.abLF = new flg();
    localflj.abLK.abLF.YPo = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localflj.abLK.abLF.UserName = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localflj.abLK.abLF.vhX = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localflj.abLK.abLF.abLH = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localflj.abLK.abLF.pSi = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new fli();
    Object localObject3 = new asr();
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
          break label296;
        }
        ((asr)localObject3).YVA.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((asr)localObject3).YVB = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((fli)localObject2).abLJ = ((asr)localObject3);
    localflj.abLK.abLG = ((fli)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new flf();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((flf)localObject2).hAP = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (Util.isNullOrNil(((flf)localObject2).hAP)) {
          break label923;
        }
        ((flf)localObject2).YQI = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((flf)localObject2).YQK = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((flf)localObject2).YQM = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((flf)localObject2).YQN = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((flf)localObject2).YQO = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((flf)localObject2).nUA = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((flf)localObject2).YQV = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((flf)localObject2).YQW = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((flf)localObject2).YQX = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((flf)localObject2).YQY = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((flf)localObject2).CreateTime = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((flf)localObject2).YVC = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        ((flf)localObject2).YVD = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VoiceDuration"), -1);
        localflj.abLK.YVI.add(localObject2);
        i += 1;
        break;
      }
    }
    label923:
    localflj.pos = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localflj.weight = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localflj.abry = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localflj.abLP = ((String)paramMap.get(".sysmsg.BizAccountRecommend.CardId"));
    localflj.style = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    localflj.hRR = ((String)paramMap.get(".sysmsg.BizAccountRecommend.ExtraData"));
    localflj.abrz = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    AppMethodBeat.o(124669);
    return localflj;
  }
  
  public static boolean cz(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248668);
    if (!iYS())
    {
      AppMethodBeat.o(248668);
      return paramBoolean;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(248668);
      return true;
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(248668);
      return false;
    }
    long l = System.currentTimeMillis();
    paramInt = p.bAq();
    if (l - acGh < paramInt * 1000)
    {
      AppMethodBeat.o(248668);
      return true;
    }
    AppMethodBeat.o(248668);
    return false;
  }
  
  public static void e(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(248601);
    if (Util.isEqual(paramcc.field_talker, acGe))
    {
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { acGe });
      AppMethodBeat.o(248601);
      return;
    }
    ab localab2 = com.tencent.mm.an.af.bHo().aq(paramcc.field_msgSvrId, "msgSvrId");
    ab localab1;
    if (localab2 == null)
    {
      localab1 = new ab();
      if (!paramBoolean) {
        break label188;
      }
    }
    label188:
    for (localab1.field_msgId = com.tencent.mm.an.af.bHo().iZc();; localab1.field_msgId = paramcc.field_msgId)
    {
      localab1.field_msgSvrId = paramcc.field_msgSvrId;
      localab1.field_content = paramcc.field_content;
      localab1.field_type = paramcc.getType();
      localab1.field_talker = paramcc.field_talker;
      localab1.field_talkerId = paramcc.field_talkerId;
      localab1.field_createTime = paramcc.getCreateTime();
      localab1.field_imgPath = paramcc.field_imgPath;
      localab1.po(paramcc.jUq);
      localab1.AU(paramcc.jUr);
      localab1.field_status = paramcc.field_status;
      if (localab2 != null) {
        break label199;
      }
      com.tencent.mm.an.af.bHo().E(localab1);
      AppMethodBeat.o(248601);
      return;
      localab1 = localab2;
      break;
    }
    label199:
    com.tencent.mm.an.af.bHo().F(localab1);
    AppMethodBeat.o(248601);
  }
  
  public static int getSessionId()
  {
    return hBm;
  }
  
  public static void iYK()
  {
    AppMethodBeat.i(124667);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(248451);
        ad.iYL();
        Object localObject1 = r.acDM;
        if (r.iXl())
        {
          r.a((r)localObject1, false, 3);
          if (r.iXp())
          {
            r.pF("bizBoxClick", null);
            AppMethodBeat.o(248451);
            return;
          }
          if (r.iXl())
          {
            localObject1 = com.tencent.mm.an.af.bHl().nT(637534257, 1);
            if (localObject1 != null)
            {
              Object localObject2 = (Iterable)localObject1;
              localObject1 = (Collection)new ArrayList();
              localObject2 = ((Iterable)localObject2).iterator();
              label146:
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                if (Math.abs(((ab)localObject3).field_createTime - System.currentTimeMillis()) < 86400000L) {}
                for (int i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label146;
                  }
                  ((Collection)localObject1).add(localObject3);
                  break;
                }
              }
              localObject1 = (List)localObject1;
              localObject2 = r.acDM;
              r.mG((List)localObject1);
            }
          }
        }
        AppMethodBeat.o(248451);
      }
    }, "BizInsertTlRecCardThread");
    ae localae = ae.acGm;
    ae.iYW();
    AppMethodBeat.o(124667);
  }
  
  public static void iYL()
  {
    AppMethodBeat.i(124668);
    if (!com.tencent.mm.kernel.h.baz())
    {
      AppMethodBeat.o(124668);
      return;
    }
    bvC(iYM());
    AppMethodBeat.o(124668);
  }
  
  public static String iYM()
  {
    AppMethodBeat.i(248551);
    Object localObject = MultiProcessMMKV.getSingleMMKV("brandService");
    StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
    com.tencent.mm.kernel.h.baC();
    localObject = ((MultiProcessMMKV)localObject).decodeString(com.tencent.mm.kernel.b.aZs());
    AppMethodBeat.o(248551);
    return localObject;
  }
  
  public static void iYN()
  {
    AppMethodBeat.i(248592);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOi, 1) == 1) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1378L, 1L, 1L, false);
      Object localObject = v.acEJ;
      localObject = com.tencent.mm.pluginsdk.ui.tools.aa.aUC(v.iXP());
      v localv = v.acEJ;
      int j = v.iXW();
      localv = v.acEJ;
      int k = v.iXV();
      com.tencent.mm.plugin.report.service.h.OAn.b(23601, new Object[] { localObject, Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0)
      {
        com.tencent.mm.an.af.bHl().bSr();
        com.tencent.mm.an.af.bHo().bSr();
      }
      AppMethodBeat.o(248592);
      return;
    }
  }
  
  public static void iYO()
  {
    AppMethodBeat.i(124678);
    by localby = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
    bb localbb = localby.bxM("officialaccounts");
    if (localbb == null) {
      localbb = new bb("officialaccounts");
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      int j = 0;
      Object localObject2 = com.tencent.mm.an.af.bHo().omV.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null);
      Object localObject1;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new ab();
        ((ab)localObject1).convertFrom((Cursor)localObject2);
      }
      for (;;)
      {
        ((Cursor)localObject2).close();
        Object localObject3 = com.tencent.mm.an.af.bHl().iYx();
        ab localab = com.tencent.mm.an.af.bHl().iYy();
        long l1;
        if (localab != null)
        {
          l1 = localab.field_createTime;
          if (localObject1 == null) {
            break label251;
          }
        }
        long l3;
        Object localObject4;
        Object localObject5;
        label251:
        for (long l2 = ((ab)localObject1).field_createTime;; l2 = 0L)
        {
          localObject2 = com.tencent.mm.pluginsdk.model.c.ya(Math.max(l1, l2));
          localbb.rw(256);
          localbb.rw(128);
          if (!((c.c)localObject2).vYC) {
            break label408;
          }
          l3 = com.tencent.mm.pluginsdk.model.c.iHt();
          localObject4 = com.tencent.mm.pluginsdk.model.c.iHs();
          localObject5 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject4);
          if ((localObject5 != null) && (((au)localObject5).iZC())) {
            break label257;
          }
          Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "ct not BizContact");
          i = 0;
          if (i == 0) {
            break label408;
          }
          AppMethodBeat.o(124678);
          return;
          l1 = 0L;
          break;
        }
        label257:
        Object localObject6 = com.tencent.mm.model.aa.getDisplayName((String)localObject4);
        localObject6 = MMApplicationContext.getContext().getString(b.f.biz_live_digest, new Object[] { localObject6 });
        localbb.gR(l3);
        localbb.BF((String)localObject6);
        localbb.BG((String)localObject4);
        localbb.rv(128);
        if (((c.c)localObject2).iaS) {
          localbb.rv(256);
        }
        if ((localObject5 != null) && (((au)localObject5).aSQ()))
        {
          i = 1;
          label344:
          if (i == 0) {
            break label380;
          }
          localbb.rv(32);
          label355:
          if (!bool2) {
            break label390;
          }
          localby.h(localbb);
        }
        for (;;)
        {
          i = 1;
          break;
          i = 0;
          break label344;
          label380:
          localbb.rw(32);
          break label355;
          label390:
          localby.c(localbb, localbb.field_username);
        }
        label408:
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.iHn();
        int i = j;
        if (localObject3 != null) {
          i = com.tencent.mm.an.af.bHl().yP(((ab)localObject3).field_orderFlag);
        }
        j = com.tencent.mm.an.af.bHo().dkF();
        boolean bool1;
        if (j > 0) {
          if (l2 <= l1)
          {
            if (localObject1 == null) {
              break label875;
            }
            localObject2 = v.acEJ;
            l3 = ((ab)localObject1).field_msgId;
            if (v.acET == -1) {
              v.acET = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOD, 0);
            }
            if (v.acET == 0)
            {
              Log.i("MicroMsg.BizMainCellExposeHelper", "isNotifyMsgShowFirst  mBizNotifyMsgPriorityShowSwitch == 0");
              bool1 = false;
              if (!bool1) {
                break label875;
              }
            }
          }
          else
          {
            localbb.rw(16);
            localbb.pG(j);
            localObject2 = localObject1;
          }
        }
        for (;;)
        {
          if ((localObject2 != null) && (((ab)localObject2).field_msgId != 0L)) {
            break label915;
          }
          Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
          localbb.jaJ();
          if (!bool2) {
            localby.c(localbb, localbb.field_username);
          }
          AppMethodBeat.o(124678);
          return;
          localObject2 = String.valueOf(l3);
          long l4 = com.tencent.mm.an.c.ovO.decodeLong(v.bvt((String)localObject2), 0L) / 1000L;
          int k = com.tencent.mm.an.c.ovO.decodeInt(v.bvu((String)localObject2), 0);
          if (v.acEQ == -1) {
            v.acEQ = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOB, 0);
          }
          if (v.acER == -1L) {
            v.acER = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOA, 0L);
          }
          if (v.acES == -1) {
            v.acES = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOC, 0);
          }
          long l5 = iYP();
          if ((k <= v.acEQ) && (l4 <= v.acER) && (i <= v.acES) && (l3 != l5)) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.BizMainCellExposeHelper", "isNotifyMsgShowFirst totalExposeTime:" + l4 + "   " + v.acER + "   totalExposeCount:" + k + "  " + v.acEQ + "   unReadCount:" + i + "   " + v.acES + "   msgIdKey:" + (String)localObject2 + "  lastClickedNotifyMsgId:" + l5 + "  result:" + bool1);
            break;
          }
          label875:
          localbb.rv(16);
          localbb.pG(i);
          localObject2 = localObject3;
          continue;
          localbb.rv(16);
          localbb.pG(i);
          localObject2 = localObject3;
        }
        label915:
        if ((localObject2 == localObject3) && (((ab)localObject2).field_placeTop == 1))
        {
          localbb.rv(32);
          if (localObject2 == localObject1)
          {
            if (((ab)localObject2).field_msgId != iYP()) {
              break label1722;
            }
            localbb.rw(64);
          }
          label964:
          localObject1 = new cc();
          ((cc)localObject1).setContent(((ab)localObject2).field_content);
          ((cc)localObject1).BS(((ab)localObject2).field_talker);
          ((cc)localObject1).setStatus(((ab)localObject2).field_status);
          if (!((ab)localObject2).iYg()) {
            break label1732;
          }
          ((cc)localObject1).setCreateTime(((ap)localObject2).jUt);
          label1021:
          ((cc)localObject1).setMsgId(((ab)localObject2).field_msgId);
          ((cc)localObject1).setType(((ab)localObject2).field_type);
          ((cc)localObject1).AU(((ap)localObject2).jUr);
          ((cc)localObject1).BT(((ab)localObject2).field_imgPath);
          l3 = Math.min(cn.bDv(), localbb.field_conversationTime);
          l1 = Math.max(l2, l1);
          localbb.bG((cc)localObject1);
          localbb.setContent(((fi)localObject1).field_talker + ":" + ((fi)localObject1).field_content);
          localbb.BE(Integer.toString(((cc)localObject1).getType()));
          localObject6 = localby.aDH();
          if (localObject6 != null)
          {
            localObject3 = new PString();
            localObject4 = new PString();
            localObject5 = new PInt();
            ((cc)localObject1).BS("officialaccounts");
            ((cc)localObject1).setContent(localbb.field_content);
            ((by.b)localObject6).a((cc)localObject1, (PString)localObject3, (PString)localObject4, (PInt)localObject5, true);
            if (((ab)localObject2).iYf())
            {
              j = 0;
              localObject1 = ((ab)localObject2).iYp();
              i = j;
              if (localObject1 != null)
              {
                i = j;
                if (((flj)localObject1).style == 1001)
                {
                  i = j;
                  if (((flj)localObject1).abLO != null)
                  {
                    i = j;
                    if (!Util.isNullOrNil(((flj)localObject1).abLO.Zxp))
                    {
                      ((PString)localObject3).value = ((flj)localObject1).abLO.Zxp;
                      i = 1;
                    }
                  }
                }
              }
              if ((i != 0) || (localObject1 == null) || (((flj)localObject1).abLK == null) || (Util.isNullOrNil(((flj)localObject1).abLK.Zxn))) {
                break label1745;
              }
              ((PString)localObject3).value = ((flj)localObject1).abLK.Zxn;
              if (((((flj)localObject1).style == 101) || (((flj)localObject1).style == 102) || (((flj)localObject1).style == 103)) && (((flj)localObject1).abLM != null) && (!Util.isNullOrNil(((flj)localObject1).abLM.Zxp))) {
                ((PString)localObject3).value = ((flj)localObject1).abLM.Zxp;
              }
              label1402:
              ((PString)localObject4).value = null;
            }
            if (((ab)localObject2).iYg()) {
              ((PString)localObject3).value = MMApplicationContext.getResources().getString(b.f.biz_msg_ad_card);
            }
            if (((ab)localObject2).iYh())
            {
              if (((ab)localObject2).acFE == null) {
                break label1766;
              }
              localObject1 = ((ab)localObject2).acFE.nUO;
              label1456:
              ((PString)localObject3).value = ((String)localObject1);
            }
            if ((((ab)localObject2).iYl()) || (((ab)localObject2).iYk()) || (((ab)localObject2).iYi()))
            {
              localObject1 = ai.L((ab)localObject2);
              if (!Util.isNullOrNil((String)localObject1)) {
                ((PString)localObject3).value = ((String)localObject1);
              }
            }
            localbb.BF(((PString)localObject3).value);
            localbb.BG(((PString)localObject4).value);
            localbb.pJ(((PInt)localObject5).value);
          }
          localbb.gR(Math.max(l3, l1));
          if (!bool2) {
            break label1797;
          }
          l1 = localby.h(localbb);
          label1567:
          localObject1 = MultiProcessMMKV.getSingleMMKV("brandService");
          if (localObject1 != null)
          {
            ((MultiProcessMMKV)localObject1).encode("BizLastMsgId", ((ab)localObject2).field_msgId);
            ((MultiProcessMMKV)localObject1).encode("BizLastMsgTime", ((ab)localObject2).field_createTime);
            if ((localab == null) || (!localab.iYf())) {
              break label1817;
            }
            ((MultiProcessMMKV)localObject1).encode("BizLastRecCardId", localab.field_recommendCardId);
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d, unread %d, msgId %d, talker:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool2), Long.valueOf(localbb.field_conversationTime), Integer.valueOf(localbb.field_unReadCount), Long.valueOf(((ab)localObject2).field_msgId), ((ab)localObject2).field_talker });
          AppMethodBeat.o(124678);
          return;
          localbb.rw(32);
          break;
          label1722:
          localbb.rv(64);
          break label964;
          label1732:
          ((cc)localObject1).setCreateTime(((ab)localObject2).field_createTime);
          break label1021;
          label1745:
          if (i != 0) {
            break label1402;
          }
          ((PString)localObject3).value = MMApplicationContext.getResources().getString(b.f.biz_msg_rec_card);
          break label1402;
          label1766:
          localObject1 = com.tencent.mm.plugin.biz.b.b.vto;
          ((ab)localObject2).acFE = com.tencent.mm.plugin.biz.b.b.aij(((ab)localObject2).field_content);
          localObject1 = ((ab)localObject2).acFE.nUO;
          break label1456;
          label1797:
          l1 = localby.c(localbb, localbb.field_username);
          break label1567;
          label1817:
          ((MultiProcessMMKV)localObject1).removeValueForKey("BizLastRecCardId");
        }
        localObject1 = null;
      }
    }
  }
  
  private static long iYP()
  {
    AppMethodBeat.i(248652);
    if (acGf == 0L) {
      acGf = MMApplicationContext.getDefaultPreference().getLong("biz_time_line_last_notify_msg_id", -1L);
    }
    long l = acGf;
    AppMethodBeat.o(248652);
    return l;
  }
  
  public static boolean iYQ()
  {
    AppMethodBeat.i(248661);
    long l = System.currentTimeMillis();
    int i = iYR();
    if ((acGh != 0L) && (acGi != 0L) && (l - acGh < i * 1000))
    {
      AppMethodBeat.o(248661);
      return true;
    }
    AppMethodBeat.o(248661);
    return false;
  }
  
  public static int iYR()
  {
    AppMethodBeat.i(248671);
    if (acGj != 0)
    {
      i = acGj;
      AppMethodBeat.o(248671);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yNF, 180);
    acGj = i;
    AppMethodBeat.o(248671);
    return i;
  }
  
  public static boolean iYS()
  {
    AppMethodBeat.i(248672);
    if (acGk != null)
    {
      bool = acGk.booleanValue();
      AppMethodBeat.o(248672);
      return bool;
    }
    iYT();
    boolean bool = acGk.booleanValue();
    AppMethodBeat.o(248672);
    return bool;
  }
  
  public static void iYT()
  {
    AppMethodBeat.i(248676);
    Object localObject = MultiProcessMMKV.getSingleMMKV("brandService");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      i = 1;
      if (i == 0) {
        break label71;
      }
    }
    label71:
    for (int i = 1;; i = -1)
    {
      i = ((MultiProcessMMKV)localObject).decodeInt("BizTimeLineOpenStatus", i);
      if (i != 1) {
        break label76;
      }
      acGk = Boolean.TRUE;
      AppMethodBeat.o(248676);
      return;
      i = 0;
      break;
    }
    label76:
    if (i == 0)
    {
      acGk = Boolean.FALSE;
      AppMethodBeat.o(248676);
      return;
    }
    localObject = p.ojc;
    boolean bool = p.a.bAA();
    acGk = Boolean.valueOf(bool);
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isRecFeedsOpen svrOpen %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(248676);
  }
  
  public static boolean iYU()
  {
    AppMethodBeat.i(176159);
    if (acGl != null)
    {
      bool = acGl.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yOm, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      acGl = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { acGl });
      bool = acGl.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static long yU(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean yV(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (com.tencent.mm.an.af.bHl().yM(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (com.tencent.mm.an.af.bHl().iYa() <= com.tencent.mm.an.af.bHl().iYD()) {
      com.tencent.mm.an.af.bHl().iYE();
    }
    com.tencent.mm.an.af.bHl().yL(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void yW(long paramLong)
  {
    AppMethodBeat.i(124679);
    acGf = paramLong;
    MMApplicationContext.getDefaultPreference().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ad
 * JD-Core Version:    0.7.0.1
 */