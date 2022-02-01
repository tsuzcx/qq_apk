package com.tencent.mm.v;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.api.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bm;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements r, i, f
{
  public static boolean cAX;
  public static long cOF;
  public static final e gqA;
  public static boolean gqB;
  private static final q gqC;
  public static final a gqD;
  private static long gqz;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    gqD = locala;
    cAX = true;
    gqA = new e((f)locala);
    gqC = (q)new com.tencent.mm.t.a();
    AppMethodBeat.o(114115);
  }
  
  public static boolean ags()
  {
    AppMethodBeat.i(114111);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajl().aaQ(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!gqB) && (System.currentTimeMillis() - cOF < 15000L)) {
        break label181;
      }
      bool2 = true;
      label63:
      ad.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + gqB);
      if (!bool1) {
        break label186;
      }
      l = SystemClock.uptimeMillis();
      label121:
      gqz = l;
      if (0L != gqz)
      {
        l = SystemClock.uptimeMillis();
        if (l - gqz < 1800000L) {
          break label191;
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1021L, 0L, 1L, true);
      }
    }
    for (;;)
    {
      if ((bool1) || (!bool2)) {
        break label247;
      }
      AppMethodBeat.o(114111);
      return true;
      bool1 = false;
      break;
      label181:
      bool2 = false;
      break label63;
      label186:
      l = 0L;
      break label121;
      label191:
      if (l - gqz >= 1200000L) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1021L, 1L, 1L, true);
      } else if (l - gqz >= 600000L) {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1021L, 2L, 1L, true);
      }
    }
    label247:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void agt()
  {
    AppMethodBeat.i(114114);
    ad.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bm.IMc;
    localObject1 = ((Iterable)bm.fru()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      h localh = (h)((Iterator)localObject1).next();
      ad.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localh });
      if (localh.KR() != -1)
      {
        Object localObject2 = com.tencent.mm.w.a.gqP;
        localObject2 = com.tencent.mm.w.a.mh(localh.KR());
        if (localObject2 != null) {
          gqA.a(localh.KR(), localh, (com.tencent.mm.w.b)localObject2);
        }
      }
    }
    localObject1 = bm.IMc;
    bm.frv();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    p.h(paramd, "task");
    ad.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.gqK.KS() + " op:" + paramInt + " status:" + paramd.gqK.getStatus());
    paramd.gqL.a(gqA, gqC, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(cv paramcv, Map<String, String> paramMap)
  {
    AppMethodBeat.i(114112);
    p.h(paramcv, "addMsg");
    p.h(paramMap, "values");
    int i = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    ad.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcv.CreateTime), Integer.valueOf(i) });
    gqB = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramcv, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = bt.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = bt.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = bt.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = bt.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 3);
    paramMap = z.a(locala.gqE.Fvk);
    p.g(paramMap, "content");
    int i4 = n.a((CharSequence)paramMap, "<addmsg>", 0, false, 6);
    int i5 = n.a((CharSequence)paramMap, "</addmsg>", 0, false, 6) + 9;
    if ((i5 > i4) && (i5 != -1) && (i4 != -1))
    {
      paramMap = paramMap.substring(i4, i5);
      p.g(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      ad.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      h localh = new h();
      localh.hl(j);
      localh.eG(str1);
      localh.setCmdId(i);
      if (str2 == null) {
        p.gfZ();
      }
      localh.eH(str2);
      localh.aZ(l2);
      localh.setRetryInterval(k);
      localh.hm(m);
      localh.hn(n);
      localh.ho(i1);
      localh.hp(i2);
      localh.eI(str3);
      localh.KZ();
      localh.a(locala.gqE);
      localh.eJ(paramMap);
      paramMap = new qu();
      paramMap.FMx = l3;
      if (!bt.isNullOrNil((String)localObject)) {
        paramMap.FMy = new com.tencent.mm.bx.b(Base64.decode((String)localObject, 0));
      }
      localh.a(paramMap);
      localh.bc(l4);
      localh.bb(l5);
      localh.La();
      localh.hq(i3);
      paramMap = bm.IMc;
      paramMap = localh.KS();
      p.g(paramMap, "item.functionMsgId");
      paramMap = bm.aTX(paramMap);
      if (paramMap != null) {
        ad.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.w.a.gqP;
        localObject = com.tencent.mm.w.a.mh(localh.KR());
        if (localObject != null) {
          ((com.tencent.mm.w.b)localObject).a(gqA, gqC, bm.IMc, localh, paramMap, paramcv.CreateTime);
        }
        ad.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(114112);
        return;
        ad.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { localh.KS() });
      }
      paramMap = "";
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
  static final class a
  {
    final cv gqE;
    final Map<String, String> values;
    
    public a(cv paramcv, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.gqE = paramcv;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.a
 * JD-Core Version:    0.7.0.1
 */