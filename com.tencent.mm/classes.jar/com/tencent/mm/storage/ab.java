package com.tencent.mm.storage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.an;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dkp;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Map;
import kotlin.f;

public final class ab
{
  private static String NQL = null;
  private static long NQM = 0L;
  public static int NQN = 0;
  public static int NQO = 1;
  public static long NQP = 180L;
  public static long NQQ = 60L;
  public static boolean NQR = false;
  private static boolean NQS = false;
  public static long NQT = 0L;
  public static long NQU = 0L;
  public static int NQV = 0;
  private static Boolean NQW = null;
  private static Boolean NQX = null;
  private static Boolean NQY = null;
  private static int dEb = 0;
  
  public static void AK(boolean paramBoolean)
  {
    NQR = paramBoolean;
  }
  
  public static void DU(int paramInt)
  {
    dEb = paramInt;
  }
  
  public static void E(z paramz)
  {
    AppMethodBeat.i(124670);
    while (com.tencent.mm.al.ag.ban().ML(paramz.field_orderFlag) != null) {
      paramz.field_orderFlag += 1L;
    }
    AppMethodBeat.o(124670);
  }
  
  public static long Na(long paramLong)
  {
    return (0xFF000000 & paramLong) >> 24;
  }
  
  public static boolean Nb(long paramLong)
  {
    AppMethodBeat.i(124675);
    if (com.tencent.mm.al.ag.ban().MR(paramLong) <= 0)
    {
      AppMethodBeat.o(124675);
      return false;
    }
    if (com.tencent.mm.al.ag.ban().gAo() <= com.tencent.mm.al.ag.ban().gAS()) {
      com.tencent.mm.al.ag.ban().gAT();
    }
    com.tencent.mm.al.ag.ban().MQ(paramLong);
    AppMethodBeat.o(124675);
    return true;
  }
  
  public static void Nc(long paramLong)
  {
    AppMethodBeat.i(124679);
    NQM = paramLong;
    MMApplicationContext.getDefaultPreference().edit().putLong("biz_time_line_last_notify_msg_id", paramLong).apply();
    AppMethodBeat.o(124679);
  }
  
  public static z X(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(212361);
    if (!g.aAc())
    {
      AppMethodBeat.o(212361);
      return null;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately no need to insert");
      AppMethodBeat.o(212361);
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
          AppMethodBeat.o(212361);
          return null;
        }
      }
      else
      {
        AppMethodBeat.o(212361);
        return null;
      }
    }
    paramMap = com.tencent.mm.al.ag.ban().gAM();
    paramString = bT((Map)localObject);
    af.a(paramString, (Map)localObject);
    if (!af.b(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately wrapper illegal");
      af.a(paramString, paramString.MOD, 3);
      AppMethodBeat.o(212361);
      return null;
    }
    int j = paramString.pos;
    long l4 = paramString.weight;
    if ((j < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately data invalid pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
      af.a(paramString, paramString.MOD, 4);
      AppMethodBeat.o(212361);
      return null;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately pos %d, weight %d", new Object[] { Integer.valueOf(j), Long.valueOf(l4) });
    if (af.g(paramString))
    {
      af.a(paramString, paramString.MOD, 5);
      AppMethodBeat.o(212361);
      return null;
    }
    long l3 = com.tencent.mm.al.ag.ban().gAo();
    if (paramString.style != 103)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString.NfY.NfT.UserName);
      if ((localObject != null) && (c.oR(((ax)localObject).field_type)))
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately %s is contact", new Object[] { paramString.NfY.NfT.UserName });
        af.a(paramString, paramString.MOD, 6);
        AppMethodBeat.o(212361);
        return null;
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1149L, 1L, 1L, false);
    localObject = new z();
    ((z)localObject).field_msgId = com.tencent.mm.al.ag.ban().gAW();
    ((z)localObject).field_msgSvrId = 0L;
    ((z)localObject).field_type = 620757041;
    ((z)localObject).field_talker = paramString.NfY.NfT.UserName;
    ((z)localObject).field_talkerId = 0;
    long l1;
    label490:
    label497:
    long l2;
    if (paramString.Ngb == 1)
    {
      i = 1;
      if (i == 0) {
        break label732;
      }
      if (Math.abs(paramString.MOC * 1000L - bp.aVP()) > 86400000L) {
        break label724;
      }
      l1 = paramString.MOC * 1000L;
      ((z)localObject).field_createTime = l1;
      ((z)localObject).nc(1);
      ((z)localObject).field_status = 3;
      af.a((z)localObject, paramString);
      ((z)localObject).c(paramString);
      l2 = 0L;
      l1 = l2;
      if (paramMap != null)
      {
        if (l4 < 0L) {
          break label750;
        }
        l1 = Math.min(l4, Na(paramMap.field_orderFlag));
      }
      label553:
      l2 = aE(l3, ((z)localObject).field_createTime / 1000L);
      if (l2 < 4294967296L) {
        break label813;
      }
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately serialNumber is too big %d", new Object[] { Long.valueOf(l2) });
      l3 = com.tencent.mm.al.ag.ban().gAT();
      l2 = aE(l3, ((z)localObject).field_createTime / 1000L);
    }
    label813:
    for (;;)
    {
      ((z)localObject).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      E((z)localObject);
      boolean bool = com.tencent.mm.al.ag.ban().B((z)localObject);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] insertTlRecCardImmediately result: %b, username: %s", new Object[] { Boolean.valueOf(bool), paramString.NfY.NfT.UserName });
      j = paramString.MOD;
      if (bool) {}
      for (i = 0;; i = 7)
      {
        af.a(paramString, j, i);
        AppMethodBeat.o(212361);
        return localObject;
        i = 0;
        break;
        label724:
        l1 = bp.aVP();
        break label490;
        label732:
        ((z)localObject).field_createTime = (com.tencent.mm.al.ag.ban().gAO() + 1000L);
        break label497;
        label750:
        if (j == 0)
        {
          l1 = Na(paramMap.field_orderFlag);
          break label553;
        }
        paramMap = com.tencent.mm.al.ag.ban().ajV(j - 1);
        if (paramMap == null)
        {
          Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "insertTlRecCardImmediately lastTimeLineInfo is null");
          l1 = l2;
          break label553;
        }
        l1 = Na(paramMap.field_orderFlag);
        break label553;
      }
    }
  }
  
  public static long aE(long paramLong1, long paramLong2)
  {
    long l2 = -1L;
    AppMethodBeat.i(124677);
    String str = (String)g.aAh().azQ().get(ar.a.OgJ, "");
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
      g.aAh().azQ().set(ar.a.OgJ, str);
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber set groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
    for (paramLong1 = l1;; paramLong1 = l1)
    {
      AppMethodBeat.o(124677);
      return paramLong1;
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "getSerialNumber groupStartTime %s,createTime %d", new Object[] { str, Long.valueOf(paramLong2) });
    }
  }
  
  public static long aF(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212364);
    z localz = com.tencent.mm.al.ag.ban().MU(paramLong1);
    if (localz == null)
    {
      AppMethodBeat.o(212364);
      return 604800L;
    }
    paramLong1 = localz.field_createTime / 1000L;
    AppMethodBeat.o(212364);
    return paramLong2 - (paramLong1 - 604800L);
  }
  
  public static void aV(ca paramca)
  {
    AppMethodBeat.i(124662);
    if (paramca == null)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (m.HF(paramca.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    if (com.tencent.mm.model.ab.Eq(paramca.field_talker))
    {
      AppMethodBeat.o(124662);
      return;
    }
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramca.field_talker);
    if ((localas != null) && (c.oR(localas.field_type)) && (!localas.gBM()))
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
    Object localObject2 = bp.Ky(paramca.fqK);
    if (localObject2 != null)
    {
      m = ((bp.b)localObject2).iEp;
      k = ((bp.b)localObject2).serviceType;
      j = ((bp.b)localObject2).iEq;
      l1 = ((bp.b)localObject2).iEu;
      if ((((bp.b)localObject2).iEv & 0x8) != 0L) {
        bool1 = true;
      }
      i = n;
      if ((((bp.b)localObject2).iEv & 0x10) != 0L) {
        i = 1;
      }
      bool2 = bool1;
      if ((((bp.b)localObject2).iEv & 0x4) != 0L)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramca.field_talker, Long.valueOf(((bp.b)localObject2).iEv) });
        AppMethodBeat.o(124662);
        return;
      }
    }
    if (k != 0)
    {
      AppMethodBeat.o(124662);
      return;
    }
    if ((localObject2 != null) && ((((bp.b)localObject2).iEv & 0x40) != 0L) && (localas != null) && (c.oR(localas.field_type)))
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
      com.tencent.mm.pluginsdk.c.JSn = true;
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
        if (!paramca.gAt()) {
          break;
        }
        if (paramca.gAt()) {}
        for (localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);; localObject1 = null)
        {
          if ((localObject1 == null) || (Util.isNullOrNil(((u)localObject1).iAd))) {
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
    if ((localObject2 != null) && ((((bp.b)localObject2).iEv & 0x2) != 0L))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg not allow to insert,talker %s bizFlag = %d", new Object[] { paramca.field_talker, Long.valueOf(((bp.b)localObject2).iEv) });
      AppMethodBeat.o(124662);
      return;
    }
    com.tencent.mm.pluginsdk.c.JSn = true;
    localObject2 = com.tencent.mm.al.ag.ban().R(paramca.field_msgId, "msgId");
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
      ((z)localObject1).nc(paramca.fqJ);
      ((z)localObject1).BB(paramca.fqK);
      ((z)localObject1).field_bizClientMsgId = paramca.field_bizClientMsgId;
      if (i != 0) {
        ((z)localObject1).iF(1);
      }
      if ((localas == null) || (!localas.arE())) {
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
      long l3 = com.tencent.mm.al.ag.ban().gAo();
      long l4 = aE(l3, ((z)localObject1).field_createTime / 1000L);
      long l2 = l4;
      if (l4 >= 4294967296L)
      {
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg serialNumber is too big %d", new Object[] { Long.valueOf(l4) });
        l3 = com.tencent.mm.al.ag.ban().gAT();
        l2 = aE(l3, ((z)localObject1).field_createTime / 1000L);
      }
      ((z)localObject1).field_orderFlag = (l1 << 24 & 0xFF000000 | l3 << 32 | l2);
      E((z)localObject1);
      ((z)localObject1).field_isExpand = bool2;
      com.tencent.mm.al.ag.ban().B((z)localObject1);
      if (!NQS)
      {
        NQS = true;
        com.tencent.f.h.RTc.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124659);
            aa localaa = com.tencent.mm.al.ag.ban();
            long l = System.currentTimeMillis();
            int j = localaa.cZm();
            int i;
            if (j <= 2000)
            {
              if ((Log.getLogLevel() > 0) || (j < 500))
              {
                i = 0;
                if (i == 0) {
                  break label168;
                }
              }
            }
            else
            {
              String str = String.format("DELETE FROM %s WHERE %s IN ( SELECT %s FROM %s ORDER BY %s LIMIT %d )", new Object[] { "BizTimeLineInfo", "orderFlag", "orderFlag", "BizTimeLineInfo", "orderFlag", Integer.valueOf(100) });
              localaa.iFy.execSQL("BizTimeLineInfo", str);
              Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData delete cost: %d, count: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(j) });
            }
            for (;;)
            {
              ab.TT();
              AppMethodBeat.o(124659);
              return;
              if (MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizTimeLineDeleteOldData", 0) == 1)
              {
                i = 1;
                break;
              }
              i = 0;
              break;
              label168:
              Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTooOldData count: %d", new Object[] { Integer.valueOf(j) });
            }
          }
        }, 1000L, "BizTimeLineInfoStorageThread");
      }
      paramca = ad.NRn;
      if (ad.gBk())
      {
        paramca = ad.NRn;
        ad.aka(NQN);
      }
      paramca = y.NPP;
      y.a(y.b.NPT);
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg groupId %d, serialNumber %d,orderFlag %d", new Object[] { Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(((z)localObject1).field_orderFlag) });
      AppMethodBeat.o(124662);
      return;
      localObject1 = localObject2;
      break;
    }
    label1027:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg updateBySvrId");
    com.tencent.mm.al.ag.ban().C((z)localObject1);
    AppMethodBeat.o(124662);
  }
  
  public static void aW(ca paramca)
  {
    AppMethodBeat.i(124676);
    if (paramca == null)
    {
      AppMethodBeat.o(124676);
      return;
    }
    com.tencent.mm.al.ag.ban().MX(paramca.field_msgId);
    AppMethodBeat.o(124676);
  }
  
  public static boolean bD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(212366);
    if (!gBd())
    {
      AppMethodBeat.o(212366);
      return paramBoolean;
    }
    if (paramBoolean)
    {
      AppMethodBeat.o(212366);
      return true;
    }
    if (paramInt > 0)
    {
      AppMethodBeat.o(212366);
      return false;
    }
    long l = System.currentTimeMillis();
    paramInt = com.tencent.mm.model.p.aTG();
    if (l - NQT < paramInt * 1000)
    {
      AppMethodBeat.o(212366);
      return true;
    }
    AppMethodBeat.o(212366);
    return false;
  }
  
  private static ege bT(Map<String, String> paramMap)
  {
    int j = 0;
    AppMethodBeat.i(124669);
    ege localege = new ege();
    localege.NfY = new efz();
    localege.NfY.Lug = ((String)paramMap.get(".sysmsg.BizAccountRecommend.Title"));
    localege.NfY.KWx = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.AppMsgRecReason"));
    localege.NfY.NfT = new egb();
    localege.NfY.NfT.KQY = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.BrandIconUrl"));
    localege.NfY.NfT.UserName = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName"));
    localege.NfY.NfT.oUJ = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.NickName"));
    localege.NfY.NfT.NfV = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.RecommendReason"));
    localege.NfY.NfT.keb = ((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.Signature"));
    Object localObject2 = new egd();
    Object localObject3 = new anx();
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
        ((anx)localObject3).KWr.add(localObject1);
        i += 1;
        break;
      }
    }
    label296:
    ((anx)localObject3).KWs = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.ShowNegativeFeedbackReason"), 1);
    ((egd)localObject2).NfX = ((anx)localObject3);
    localege.NfY.NfU = ((egd)localObject2);
    i = j;
    if (i < 2)
    {
      localObject2 = new ega();
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i == 0) {}
      for (localObject1 = "";; localObject1 = Integer.valueOf(1))
      {
        localObject1 = localObject1;
        ((ega)localObject2).Title = ((String)paramMap.get((String)localObject1 + ".AppMsg.Title"));
        if (Util.isNullOrNil(((ega)localObject2).Title)) {
          break label923;
        }
        ((ega)localObject2).KSh = ((String)paramMap.get((String)localObject1 + ".AppMsg.Digest"));
        ((ega)localObject2).KSj = ((String)paramMap.get((String)localObject1 + ".AppMsg.ContentUrl"));
        ((ega)localObject2).KSl = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl"));
        ((ega)localObject2).KSm = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_1_1"));
        ((ega)localObject2).KSn = ((String)paramMap.get((String)localObject1 + ".AppMsg.CoverImgUrl_235_1"));
        ((ega)localObject2).iAb = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.ItemShowType"), -1);
        ((ega)localObject2).KSu = ((String)paramMap.get((String)localObject1 + ".AppMsg.VideoId"));
        ((ega)localObject2).KSv = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoWidth"), -1);
        ((ega)localObject2).KSw = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoHeight"), -1);
        ((ega)localObject2).KSx = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VideoDuration"), -1);
        ((ega)localObject2).CreateTime = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.CreateTime"), -1);
        ((ega)localObject2).KWt = ((String)paramMap.get((String)localObject1 + ".AppMsg.VoicePlayUrl"));
        ((ega)localObject2).KWu = Util.getInt((String)paramMap.get((String)localObject1 + ".AppMsg.VoiceDuration"), -1);
        localege.NfY.KWy.add(localObject2);
        i += 1;
        break;
      }
    }
    label923:
    localege.pos = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
    localege.weight = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
    localege.MOC = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), -1L);
    localege.Ngd = ((String)paramMap.get(".sysmsg.BizAccountRecommend.CardId"));
    localege.style = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    localege.dSJ = ((String)paramMap.get(".sysmsg.BizAccountRecommend.ExtraData"));
    localege.MOD = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    AppMethodBeat.o(124669);
    return localege;
  }
  
  public static void biZ(String paramString)
  {
    AppMethodBeat.i(212360);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard no need to insert");
      AppMethodBeat.o(212360);
      return;
    }
    int i = paramString.indexOf("<sysmsg");
    if (i != -1)
    {
      localObject1 = XmlParser.parseXml(paramString.substring(i), "sysmsg", null);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.BizTimeLineInfoStorageLogic", "XmlParser values is null, msgContent %s", new Object[] { paramString });
        AppMethodBeat.o(212360);
      }
    }
    else
    {
      AppMethodBeat.o(212360);
      return;
    }
    if (af.bU((Map)localObject1))
    {
      af.bW((Map)localObject1);
      AppMethodBeat.o(212360);
      return;
    }
    paramString = bT((Map)localObject1);
    af.a(paramString, (Map)localObject1);
    Object localObject1 = com.tencent.mm.al.ag.ban().gAM();
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is null");
      af.a(paramString, paramString.MOD, 1);
      AppMethodBeat.o(212360);
      return;
    }
    Object localObject2 = MultiProcessMMKV.getSingleMMKV("brandService");
    if (paramString.MOD != 2)
    {
      if (((z)localObject1).field_status == 4)
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard lastTimeLineInfo is exposed");
        af.a(paramString, paramString.MOD, 2);
        AppMethodBeat.o(212360);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
      g.aAf();
      ((MultiProcessMMKV)localObject2).encode(com.tencent.mm.kernel.a.ayV(), "");
    }
    if (!af.b(paramString, null))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard wrapper illegal");
      af.a(paramString, paramString.MOD, 3);
      AppMethodBeat.o(212360);
      return;
    }
    i = paramString.pos;
    long l4 = paramString.weight;
    if ((i < 0) && (l4 < 0L))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard data invalid pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
      af.a(paramString, paramString.MOD, 4);
      AppMethodBeat.o(212360);
      return;
    }
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard pos %d, weight %d", new Object[] { Integer.valueOf(i), Long.valueOf(l4) });
    if (af.g(paramString))
    {
      af.a(paramString, paramString.MOD, 5);
      AppMethodBeat.o(212360);
      return;
    }
    long l3 = com.tencent.mm.al.ag.ban().gAS();
    if (paramString.style != 103)
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString.NfY.NfT.UserName);
      if ((localObject2 != null) && (c.oR(((ax)localObject2).field_type)))
      {
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard %s is contact", new Object[] { paramString.NfY.NfT.UserName });
        af.a(paramString, paramString.MOD, 6);
        AppMethodBeat.o(212360);
        return;
      }
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1149L, 1L, 1L, false);
    long l2 = com.tencent.mm.al.ag.ban().gAO();
    localObject2 = new z();
    ((z)localObject2).field_msgId = com.tencent.mm.al.ag.ban().gAW();
    ((z)localObject2).field_msgSvrId = 0L;
    ((z)localObject2).field_type = 620757041;
    ((z)localObject2).field_talker = paramString.NfY.NfT.UserName;
    ((z)localObject2).field_talkerId = 0;
    ((z)localObject2).field_createTime = (l2 - 1000L);
    ((z)localObject2).nc(1);
    ((z)localObject2).field_status = 3;
    af.a((z)localObject2, paramString);
    ((z)localObject2).c(paramString);
    long l1 = 0L;
    if (l4 >= 0L)
    {
      l1 = Math.min(l4, 255L);
      if (paramString.MOD != 2) {
        break label751;
      }
      l2 = aF(l3, ((z)localObject2).field_createTime / 1000L);
    }
    for (;;)
    {
      if (paramString.MOD == 2)
      {
        if (l3 <= 10L)
        {
          AppMethodBeat.o(212360);
          return;
          if (i == 0)
          {
            l1 = Na(((z)localObject1).field_orderFlag);
            ((z)localObject2).field_createTime = (l2 + 1000L);
            break;
          }
          localObject1 = com.tencent.mm.al.ag.ban().ajV(i - 1);
          if (localObject1 == null)
          {
            Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertTlRecCard lastTimeLineInfo is null");
            break;
          }
          l1 = Na(((z)localObject1).field_orderFlag);
          ((z)localObject1).field_createTime -= 1000L;
          break;
          label751:
          l2 = aE(l3, ((z)localObject2).field_createTime / 1000L);
          continue;
        }
        l3 -= 1L;
        ((z)localObject2).field_hasShow = 1;
        ((z)localObject2).field_status = 4;
        ((z)localObject2).iF(2);
      }
    }
    for (;;)
    {
      ((z)localObject2).field_orderFlag = (l2 | l3 << 32 | l1 << 24 & 0xFF000000);
      E((z)localObject2);
      localObject1 = com.tencent.mm.al.ag.ban();
      boolean bool;
      int j;
      if (paramString.MOD != 2)
      {
        bool = true;
        bool = ((aa)localObject1).b((z)localObject2, bool);
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] doInsertTlRecCard result: %b, username: %s, redDotFlag=%d ", new Object[] { Boolean.valueOf(bool), paramString.NfY.NfT.UserName, Integer.valueOf(paramString.MOD) });
        j = paramString.MOD;
        if (!bool) {
          break label922;
        }
      }
      label922:
      for (i = 0;; i = 7)
      {
        af.a(paramString, j, i);
        AppMethodBeat.o(212360);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public static void bja(String paramString)
  {
    NQL = paramString;
  }
  
  public static void c(final Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(124666);
    if ((parama == null) || (parama.heO == null) || (parama.heO.KHn == null))
    {
      Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify data invalid");
      AppMethodBeat.o(124666);
      return;
    }
    if (!g.aAc())
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "onBizRecommendNotify acc not ready");
      AppMethodBeat.o(124666);
      return;
    }
    int j = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Style"), -1);
    Object localObject1 = (com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify IBrandService null");
      AppMethodBeat.o(124666);
      return;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)localObject1).CT(j))
    {
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify style = %s not support", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(124666);
      return;
    }
    int i = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1);
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify redDot = %s", new Object[] { Integer.valueOf(i) });
    parama = com.tencent.mm.platformtools.z.a(parama.heO.KHn);
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
      g.aAf();
      ((MultiProcessMMKV)localObject1).encode(com.tencent.mm.kernel.a.ayV(), parama);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1149L, 0L, 1L, false);
      l = Util.getLong((String)paramMap.get(".sysmsg.BizAccountRecommend.RecID"), 0L);
      str1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.BizAccount.UserName");
      k = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Pos"), -1);
      m = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.Weight"), -1);
      n = Util.getInt((String)paramMap.get(".sysmsg.BizAccountRecommend.UseServerTime"), 0);
      localObject1 = (String)paramMap.get(".sysmsg.BizAccountRecommend.CardId");
      localObject2 = (String)paramMap.get(".sysmsg.BizAccountRecommend.ExpType");
      i = 0;
      if (i >= 2) {
        break label664;
      }
      localObject3 = new StringBuilder().append(".sysmsg.BizAccountRecommend.BizAccount");
      if (i != 0) {
        break label656;
      }
    }
    label656:
    for (parama = "";; parama = Integer.valueOf(1))
    {
      String str2 = parama;
      localObject3 = (String)paramMap.get(str2 + ".AppMsg.Title");
      if (Util.isNullOrNil((String)localObject3)) {
        break label664;
      }
      parama = (String)paramMap.get(str2 + ".UserName");
      str2 = (String)paramMap.get(str2 + ".AppMsg.ContentUrl");
      localObject3 = com.tencent.mm.pluginsdk.ui.tools.z.bfG((String)localObject3);
      str2 = com.tencent.mm.pluginsdk.ui.tools.z.bfG(str2);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify bizUserName %s", new Object[] { parama });
      com.tencent.mm.plugin.report.service.h.CyF.a(18106, new Object[] { parama, Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(m), localObject3, str2 });
      i += 1;
      break label369;
      if (i == 1)
      {
        com.tencent.f.h.RTc.b(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(124656);
            ab.X(this.kNw, paramMap);
            Object localObject = ad.NRn;
            if (ad.gBk())
            {
              localObject = ad.NRn;
              ad.aka(ab.NQN);
            }
            localObject = y.NPP;
            y.a(y.b.NPT);
            AppMethodBeat.o(124656);
          }
        }, "BizInsertTlRecCardThreadImmediately");
        break;
      }
      if (i != 2) {
        break;
      }
      localObject1 = ac.NRc;
      ac.bjb(parama);
      parama = ac.NRc;
      ac.Nd(3L);
      break;
    }
    label664:
    Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "[TRACE_BIZRECCARD] onBizRecommendNotify userName %s, recId %d", new Object[] { str1, Long.valueOf(l) });
    if (j == 101)
    {
      paramMap = com.tencent.mm.plugin.webcanvas.l.IAx;
      com.tencent.mm.plugin.webcanvas.l.LV(83L);
      paramMap = s.NPC;
      s.a(k, m, n, 3, j, l, (String)localObject1, (String)localObject2, "");
    }
    AppMethodBeat.o(124666);
  }
  
  public static boolean clc()
  {
    AppMethodBeat.i(124680);
    if (NQW != null)
    {
      bool = NQW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTo, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      NQW = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isBizTimeLineOpen open %b", new Object[] { NQW });
      bool = NQW.booleanValue();
      AppMethodBeat.o(124680);
      return bool;
    }
  }
  
  public static void e(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(212363);
    if (Util.isEqual(paramca.field_talker, NQL))
    {
      Log.v("MicroMsg.BizTimeLineInfoStorageLogic", "doInsertBizTimeLineMsg is currentTalker %s, just return.", new Object[] { NQL });
      AppMethodBeat.o(212363);
      return;
    }
    z localz2 = com.tencent.mm.al.ag.bap().R(paramca.field_msgSvrId, "msgSvrId");
    z localz1;
    if (localz2 == null)
    {
      localz1 = new z();
      if (!paramBoolean) {
        break label188;
      }
    }
    label188:
    for (localz1.field_msgId = com.tencent.mm.al.ag.bap().gBo();; localz1.field_msgId = paramca.field_msgId)
    {
      localz1.field_msgSvrId = paramca.field_msgSvrId;
      localz1.field_content = paramca.field_content;
      localz1.field_type = paramca.getType();
      localz1.field_talker = paramca.field_talker;
      localz1.field_talkerId = paramca.field_talkerId;
      localz1.field_createTime = paramca.field_createTime;
      localz1.field_imgPath = paramca.field_imgPath;
      localz1.nc(paramca.fqJ);
      localz1.BB(paramca.fqK);
      localz1.field_status = paramca.field_status;
      if (localz2 != null) {
        break label199;
      }
      com.tencent.mm.al.ag.bap().B(localz1);
      AppMethodBeat.o(212363);
      return;
      localz1 = localz2;
      break;
    }
    label199:
    com.tencent.mm.al.ag.bap().C(localz1);
    AppMethodBeat.o(212363);
  }
  
  public static void gAX()
  {
    AppMethodBeat.i(124667);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(212359);
        ab.gAY();
        Object localObject2 = r.NPl;
        if (r.gzL())
        {
          Object localObject1;
          Object localObject3;
          if (r.gzL())
          {
            if (!ab.gBb())
            {
              if (!r.gzN()) {
                break label310;
              }
              localObject1 = com.tencent.mm.al.ag.ban();
              localObject3 = String.format("DELETE FROM %s WHERE type = %d and isRead = 1 and createTime < %d", new Object[] { "BizTimeLineInfo", Integer.valueOf(637534257), Long.valueOf(bp.aVP() - 86400000L) });
              Log.d("MicroMsg.BizTimeLineInfoStorage", "deleteExposedAdMsgByType ret:%b, sql=%s", new Object[] { Boolean.valueOf(((aa)localObject1).iFy.execSQL("BizTimeLineInfo", (String)localObject3)), localObject3 });
              localObject3 = new aa.a();
              ((aa.a)localObject3).NQE = aa.b.NQH;
              ((aa)localObject1).a((aa.a)localObject3);
            }
            localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(29L);
            localObject1 = r.gzI().decodeString(r.biG("biz_ad_card_data"));
            if (r.cg(r.biI((String)localObject1))) {
              break label459;
            }
            Log.w("MicroMsg.BizCardLogic", "insertAd ad data invalid");
            if (!Util.isNullOrNil((String)localObject1))
            {
              r.gzI().encode(r.biG("biz_ad_card_data"), "");
              localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
              com.tencent.mm.plugin.webcanvas.l.LV(102L);
            }
            localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
            com.tencent.mm.plugin.webcanvas.l.LV(30L);
            localObject1 = r.gzX();
            if (localObject1 != null)
            {
              if (r.cg(((z)localObject1).gAE())) {
                break label320;
              }
              com.tencent.mm.al.ag.ban().MX(((z)localObject1).field_msgId);
              Log.i("MicroMsg.BizCardLogic", "insertAd delete invalid ad aid=" + ((z)localObject1).gAG());
            }
          }
          for (;;)
          {
            if (r.gzN())
            {
              ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).P("wxa06c02b5c00ff39b", "bizBoxClick", null);
              AppMethodBeat.o(212359);
              return;
              label310:
              com.tencent.mm.al.ag.ban().ajX(1);
              break;
              label320:
              localObject2 = r.NPl;
              long l1 = r.MJ(((z)localObject1).field_orderFlag);
              if ((((z)localObject1).field_orderFlag != l1) && (l1 > 0L))
              {
                ((z)localObject1).field_orderFlag = l1;
                localObject2 = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(36L);
                r.NPl.z((z)localObject1);
                boolean bool = com.tencent.mm.al.ag.ban().c((z)localObject1, true);
                Log.i("MicroMsg.BizCardLogic", "insertAd updateById result: " + bool + ", msgId:" + ((z)localObject1).field_msgId + " orderFlag:" + ((z)localObject1).field_orderFlag + " aid: " + ((z)localObject1).gAG());
                continue;
                label459:
                localObject3 = com.tencent.mm.al.ag.ban();
                kotlin.g.b.p.g(localObject3, "SubCoreBiz.getBizTimeLineInfoStorage()");
                z localz = ((aa)localObject3).gAM();
                if (localz == null)
                {
                  Log.i("MicroMsg.BizCardLogic", "insertAd lastTimeLineInfo is null");
                }
                else
                {
                  localObject3 = com.tencent.mm.plugin.webcanvas.l.IAx;
                  com.tencent.mm.plugin.webcanvas.l.LV(31L);
                  com.tencent.mm.plugin.report.service.h.CyF.a(20636, new Object[] { "", "", Integer.valueOf(4) });
                  localObject3 = com.tencent.mm.al.ag.ban();
                  kotlin.g.b.p.g(localObject3, "SubCoreBiz.getBizTimeLineInfoStorage()");
                  l1 = ((aa)localObject3).gAS();
                  localObject3 = new z();
                  ((z)localObject3).field_content = ((String)localObject1);
                  ((z)localObject3).field_type = 637534257;
                  if ((((Boolean)r.NPb.getValue()).booleanValue()) && (r.gzJ() != 1) && (com.tencent.mm.al.ag.ban().MZ(l1 << 32) != null))
                  {
                    Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a recCard", new Object[] { Long.valueOf(l1) });
                    com.tencent.mm.plugin.report.service.h.CyF.a(20636, new Object[] { ((z)localObject3).gAG(), ((z)localObject3).getTraceId(), Integer.valueOf(1) });
                    localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(34L);
                  }
                  else
                  {
                    int j = 0;
                    int i = j;
                    if (!ab.gBb())
                    {
                      i = j;
                      if (r.gzX() != null)
                      {
                        localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                        com.tencent.mm.plugin.webcanvas.l.LV(37L);
                        com.tencent.mm.al.ag.ban().ajX(0);
                        i = 1;
                      }
                    }
                    if (r.gzJ() <= 0)
                    {
                      localObject1 = com.tencent.mm.al.ag.bao();
                      localObject4 = Calendar.getInstance();
                      kotlin.g.b.p.g(localObject4, "Calendar.getInstance()");
                      ((Calendar)localObject4).setTimeInMillis(System.currentTimeMillis());
                      ((Calendar)localObject4).set(11, 0);
                      ((Calendar)localObject4).set(13, 0);
                      ((Calendar)localObject4).set(12, 0);
                      ((Calendar)localObject4).set(14, 0);
                      long l2 = ((Calendar)localObject4).getTimeInMillis();
                      localObject4 = "SELECT count(*) FROM BizAdInfo where exposeTime > ".concat(String.valueOf(l2));
                      localObject1 = ((q)localObject1).iFy.rawQuery((String)localObject4, null);
                      j = 0;
                      if (((Cursor)localObject1).moveToFirst()) {
                        j = ((Cursor)localObject1).getInt(0);
                      }
                      ((Cursor)localObject1).close();
                      Log.d("MicroMsg.BizAdInfoStorage", "getAdCardCount count=" + j + ", beginTime=" + l2);
                      int k = r.NOT;
                      if (1 > k) {}
                      for (;;)
                      {
                        r.NOT = r.gzI().decodeInt("biz_card_max_ad_count", 1);
                        k = r.NOT;
                        if ((1 > k) || (10 < k)) {
                          r.NOT = 1;
                        }
                        do
                        {
                          if (j < r.NOT) {
                            break label1112;
                          }
                          Log.i("MicroMsg.BizCardLogic", "insertAd too much ad count=".concat(String.valueOf(j)));
                          localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                          com.tencent.mm.plugin.webcanvas.l.LV(32L);
                          com.tencent.mm.plugin.report.service.h.CyF.a(20636, new Object[] { ((z)localObject3).gAG(), ((z)localObject3).getTraceId(), Integer.valueOf(3) });
                          break;
                        } while (10 >= k);
                      }
                    }
                    Log.i("MicroMsg.BizCardLogic", "insertAd delete all ad msg");
                    localObject1 = com.tencent.mm.al.ag.ban();
                    Object localObject4 = String.format("DELETE FROM %s WHERE %s = %d", new Object[] { "BizTimeLineInfo", "type", Integer.valueOf(637534257) });
                    Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", new Object[] { Integer.valueOf(637534257), Boolean.valueOf(((aa)localObject1).iFy.execSQL("BizTimeLineInfo", (String)localObject4)) });
                    localObject4 = new aa.a();
                    ((aa.a)localObject4).NQE = aa.b.NQH;
                    ((aa)localObject1).a((aa.a)localObject4);
                    label1112:
                    localObject1 = com.tencent.mm.al.ag.ban();
                    localObject4 = "SELECT * FROM BizTimeLineInfo where type=637534257 and orderFlag > ".concat(String.valueOf(l1 << 32));
                    localObject4 = ((aa)localObject1).iFy.rawQuery((String)localObject4, null);
                    localObject1 = null;
                    if (((Cursor)localObject4).moveToFirst())
                    {
                      localObject1 = new z();
                      ((z)localObject1).convertFrom((Cursor)localObject4);
                    }
                    ((Cursor)localObject4).close();
                    if (localObject1 != null)
                    {
                      Log.i("MicroMsg.BizCardLogic", "insertAd groupId %d already has a adCard", new Object[] { Long.valueOf(l1) });
                      com.tencent.mm.plugin.report.service.h.CyF.a(20636, new Object[] { ((z)localObject3).gAG(), ((z)localObject3).getTraceId(), Integer.valueOf(2) });
                      localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                      com.tencent.mm.plugin.webcanvas.l.LV(33L);
                    }
                    else
                    {
                      ((z)localObject3).field_msgId = com.tencent.mm.al.ag.ban().gAW();
                      ((z)localObject3).field_msgSvrId = 0L;
                      ((z)localObject3).field_talker = "";
                      ((z)localObject3).field_talkerId = 0;
                      ((z)localObject3).field_hasShow = 1;
                      ((z)localObject3).field_createTime = bp.aVP();
                      if (localz.gAv()) {}
                      for (l1 = localz.fqM;; l1 = localz.field_createTime)
                      {
                        ((z)localObject3).yw(l1);
                        ((z)localObject3).nc(1);
                        ((z)localObject3).field_status = 3;
                        ((z)localObject3).field_orderFlag = r.MJ(0L);
                        if (((z)localObject3).field_orderFlag <= 0L) {
                          break;
                        }
                        r.gzI().encode(r.biG("biz_ad_card_data"), "");
                        ((r)localObject2).z((z)localObject3);
                        bool = com.tencent.mm.al.ag.ban().B((z)localObject3);
                        Log.i("MicroMsg.BizCardLogic", "insertAd result: " + bool + ", msgId:" + ((z)localObject3).field_msgId + " orderFlag:" + ((z)localObject3).field_orderFlag + " aid: " + ((z)localObject3).gAG());
                        com.tencent.mm.plugin.report.service.h.CyF.a(20636, new Object[] { ((z)localObject3).gAG(), ((z)localObject3).getTraceId(), Integer.valueOf(0) });
                        localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                        com.tencent.mm.plugin.webcanvas.l.LV(35L);
                        if (i == 0)
                        {
                          localObject1 = com.tencent.mm.plugin.webcanvas.l.IAx;
                          com.tencent.mm.plugin.webcanvas.l.LV(38L);
                        }
                        if (!bool) {
                          break;
                        }
                        com.tencent.mm.al.ag.bao().biF(((z)localObject3).gAG());
                        break;
                      }
                    }
                  }
                }
              }
            }
          }
          r.eXq();
        }
        AppMethodBeat.o(212359);
      }
    }, "BizInsertTlRecCardThread");
    ac localac = ac.NRc;
    ac.gBh();
    AppMethodBeat.o(124667);
  }
  
  public static void gAY()
  {
    AppMethodBeat.i(124668);
    if (!g.aAc())
    {
      AppMethodBeat.o(124668);
      return;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
    StringBuilder localStringBuilder = new StringBuilder("BizLatestRecommendCardInfo");
    g.aAf();
    biZ(localMultiProcessMMKV.decodeString(com.tencent.mm.kernel.a.ayV()));
    AppMethodBeat.o(124668);
  }
  
  public static void gAZ()
  {
    AppMethodBeat.i(212362);
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(124660);
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTK, 1) == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1378L, 1L, 1L, false);
            Object localObject = com.tencent.mm.al.ag.ban();
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
            ((aa)localObject).iFy.execSQL("BizTimeLineInfo", "delete from BizTimeLineInfo");
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
            localObject = com.tencent.mm.al.ag.bap();
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable start");
            ((ae)localObject).iFy.execSQL("BizTimeLineSingleMsgInfo", "delete from BizTimeLineSingleMsgInfo");
            Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteTable end");
          }
          AppMethodBeat.o(124660);
          return;
        }
      }
    }, "BizTimeLineInfoStorageThread");
    AppMethodBeat.o(212362);
  }
  
  public static void gBa()
  {
    AppMethodBeat.i(124678);
    if (!clc())
    {
      AppMethodBeat.o(124678);
      return;
    }
    bw localbw = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST();
    az localaz = localbw.bjY("officialaccounts");
    if (localaz == null) {
      localaz = new az("officialaccounts");
    }
    label388:
    label815:
    label1072:
    label1093:
    for (boolean bool = true;; bool = false)
    {
      int i = 0;
      Object localObject3 = com.tencent.mm.al.ag.bap().gAM();
      Object localObject2 = com.tencent.mm.al.ag.ban().gAM();
      long l2 = com.tencent.mm.al.ag.ban().gAO();
      int j;
      Object localObject1;
      if (localObject3 != null)
      {
        l1 = ((z)localObject3).field_createTime;
        if (localObject2 != null) {
          i = com.tencent.mm.al.ag.ban().MW(((z)localObject2).field_orderFlag);
        }
        j = com.tencent.mm.al.ag.bap().ctM();
        if (j <= 0) {
          break label234;
        }
        if (l1 <= l2) {
          break label214;
        }
        localaz.oU(16);
        localaz.nt(j);
        localObject1 = localObject3;
      }
      for (;;)
      {
        if ((localObject1 != null) && (localObject1.field_msgId != 0L)) {
          break label254;
        }
        Log.w("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell BizTimeLineInfo is null");
        localaz.gCr();
        if (!bool) {
          localbw.a(localaz, localaz.field_username);
        }
        AppMethodBeat.o(124678);
        return;
        l1 = 0L;
        break;
        label214:
        localaz.oT(16);
        localaz.nt(i);
        localObject1 = localObject2;
        continue;
        label234:
        localaz.oT(16);
        localaz.nt(i);
        localObject1 = localObject2;
      }
      label254:
      if ((localObject1 == localObject2) && (localObject1.field_placeTop == 1))
      {
        localaz.oT(32);
        if (localObject1 == localObject3)
        {
          l3 = localObject1.field_msgId;
          if (NQM == 0L) {
            NQM = MMApplicationContext.getDefaultPreference().getLong("biz_time_line_last_notify_msg_id", -1L);
          }
          if (l3 != NQM) {
            break label1049;
          }
          localaz.oU(64);
        }
        localObject2 = new ca();
        ((ca)localObject2).setContent(localObject1.field_content);
        ((ca)localObject2).Cy(localObject1.field_talker);
        ((ca)localObject2).setStatus(localObject1.field_status);
        if (!localObject1.gAv()) {
          break label1059;
        }
        ((ca)localObject2).setCreateTime(localObject1.fqM);
        ((ca)localObject2).setMsgId(localObject1.field_msgId);
        ((ca)localObject2).setType(localObject1.field_type);
        ((ca)localObject2).BB(localObject1.fqK);
        ((ca)localObject2).Cz(localObject1.field_imgPath);
        long l3 = Math.min(cl.aWz(), localaz.field_conversationTime);
        l1 = Math.max(l1, l2);
        localaz.aX((ca)localObject2);
        localaz.setContent(((eo)localObject2).field_talker + ":" + ((eo)localObject2).field_content);
        localaz.Cl(Integer.toString(((ca)localObject2).getType()));
        bw.b localb = localbw.Xh();
        if (localb != null)
        {
          localObject3 = new PString();
          PString localPString = new PString();
          PInt localPInt = new PInt();
          ((ca)localObject2).Cy("officialaccounts");
          ((ca)localObject2).setContent(localaz.field_content);
          localb.a((ca)localObject2, (PString)localObject3, localPString, localPInt, true);
          if (localObject1.gAu())
          {
            j = 0;
            localObject2 = localObject1.gAD();
            i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((ege)localObject2).style == 1001)
              {
                i = j;
                if (((ege)localObject2).Ngc != null)
                {
                  i = j;
                  if (!Util.isNullOrNil(((ege)localObject2).Ngc.Lui))
                  {
                    ((PString)localObject3).value = ((ege)localObject2).Ngc.Lui;
                    i = 1;
                  }
                }
              }
            }
            if ((i != 0) || (localObject2 == null) || (((ege)localObject2).NfY == null) || (Util.isNullOrNil(((ege)localObject2).NfY.Lug))) {
              break label1072;
            }
            ((PString)localObject3).value = ((ege)localObject2).NfY.Lug;
            if (((((ege)localObject2).style == 101) || (((ege)localObject2).style == 102) || (((ege)localObject2).style == 103)) && (((ege)localObject2).Nga != null) && (!Util.isNullOrNil(((ege)localObject2).Nga.Lui))) {
              ((PString)localObject3).value = ((ege)localObject2).Nga.Lui;
            }
          }
          label767:
          if (localObject1.gAv()) {
            ((PString)localObject3).value = MMApplicationContext.getResources().getString(2131756723);
          }
          if (localObject1.gAw())
          {
            if (localObject1.NQo == null) {
              break label1093;
            }
            localObject2 = localObject1.NQo.iAq;
            ((PString)localObject3).value = ((String)localObject2);
          }
          if ((localObject1.isText()) || (localObject1.gAz()) || (localObject1.gAx()))
          {
            localObject2 = ag.H(localObject1);
            if (!Util.isNullOrNil((String)localObject2)) {
              ((PString)localObject3).value = ((String)localObject2);
            }
          }
          localaz.Cm(((PString)localObject3).value);
          localaz.Cn(localPString.value);
          localaz.nw(localPInt.value);
        }
        localaz.yA(Math.max(l3, l1));
        if (!bool) {
          break label1124;
        }
      }
      label331:
      label1124:
      for (long l1 = localbw.e(localaz);; l1 = localbw.a(localaz, localaz.field_username))
      {
        localObject2 = MultiProcessMMKV.getSingleMMKV("brandService");
        if (localObject2 != null)
        {
          ((MultiProcessMMKV)localObject2).encode("BizLastMsgId", localObject1.field_msgId);
          ((MultiProcessMMKV)localObject2).encode("BizLastMsgTime", localObject1.field_createTime);
        }
        Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "doUpdateBizMainCell ret %d, shouldOfInsert %b, time %d, unread %d, msgId %d, talker:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(localaz.field_conversationTime), Integer.valueOf(localaz.field_unReadCount), Long.valueOf(localObject1.field_msgId), localObject1.field_talker });
        AppMethodBeat.o(124678);
        return;
        localaz.oU(32);
        break;
        localaz.oT(64);
        break label331;
        ((ca)localObject2).setCreateTime(localObject1.field_createTime);
        break label388;
        if (i != 0) {
          break label767;
        }
        ((PString)localObject3).value = MMApplicationContext.getResources().getString(2131756724);
        break label767;
        localObject2 = com.tencent.mm.plugin.biz.b.b.pfn;
        localObject1.NQo = com.tencent.mm.plugin.biz.b.b.ahh(localObject1.field_content);
        localObject2 = localObject1.NQo.iAq;
        break label815;
      }
    }
  }
  
  public static boolean gBb()
  {
    AppMethodBeat.i(212365);
    long l = System.currentTimeMillis();
    int i = gBc();
    if ((NQT != 0L) && (NQU != 0L) && (l - NQT < i * 1000))
    {
      AppMethodBeat.o(212365);
      return true;
    }
    AppMethodBeat.o(212365);
    return false;
  }
  
  public static int gBc()
  {
    AppMethodBeat.i(212367);
    if (NQV != 0)
    {
      i = NQV;
      AppMethodBeat.o(212367);
      return i;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTv, 180);
    NQV = i;
    AppMethodBeat.o(212367);
    return i;
  }
  
  public static boolean gBd()
  {
    AppMethodBeat.i(212368);
    boolean bool1;
    if (NQX != null)
    {
      bool1 = NQX.booleanValue();
      AppMethodBeat.o(212368);
      return bool1;
    }
    Object localObject = MultiProcessMMKV.getSingleMMKV("brandService");
    int i;
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger()))
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
      i = 1;
      label61:
      i = ((MultiProcessMMKV)localObject).decodeInt("BizTimeLineOpenStatus", i);
      if (i != 1) {
        break label107;
      }
    }
    for (NQX = Boolean.TRUE;; NQX = Boolean.FALSE)
    {
      bool1 = NQX.booleanValue();
      AppMethodBeat.o(212368);
      return bool1;
      i = 0;
      break;
      label102:
      i = -1;
      break label61;
      label107:
      if (i != 0) {
        break label120;
      }
    }
    label120:
    boolean bool3;
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTp, 0) == 1)
    {
      bool1 = true;
      label144:
      localObject = com.tencent.mm.model.p.iCa;
      bool3 = p.a.aTK();
      if ((!bool1) || (!bool3)) {
        break label204;
      }
    }
    label204:
    for (boolean bool2 = true;; bool2 = false)
    {
      NQX = Boolean.valueOf(bool2);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isRecFeedsOpen localOpen %b, svrOpen %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      break;
      bool1 = false;
      break label144;
    }
  }
  
  public static boolean gBe()
  {
    AppMethodBeat.i(176159);
    if (NQY != null)
    {
      bool = NQY.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTQ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      NQY = Boolean.valueOf(bool);
      Log.i("MicroMsg.BizTimeLineInfoStorageLogic", "isShowBizTimeLineTime %b", new Object[] { NQY });
      bool = NQY.booleanValue();
      AppMethodBeat.o(176159);
      return bool;
    }
  }
  
  public static int getSessionId()
  {
    return dEb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.ab
 * JD-Core Version:    0.7.0.1
 */