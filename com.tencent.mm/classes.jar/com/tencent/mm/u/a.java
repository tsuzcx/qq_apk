package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.api.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bs;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "isSyncing", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "checkLoop", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "source", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements t, k, f
{
  public static boolean isInit;
  private static long jQA;
  private static final e jQB;
  private static long jQC;
  private static boolean jQD;
  private static final s jQE;
  public static final a jQF;
  public static volatile boolean jQz;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    jQF = locala;
    isInit = true;
    jQB = new e((f)locala);
    jQE = (s)new com.tencent.mm.r.a();
    AppMethodBeat.o(114115);
  }
  
  public static void aDW()
  {
    AppMethodBeat.i(258431);
    Log.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(258431);
  }
  
  public static boolean aDX()
  {
    AppMethodBeat.i(114111);
    if (!jQz)
    {
      Object localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      long l = ((com.tencent.mm.kernel.f)localObject).aHp().ahV(8196);
      boolean bool1;
      boolean bool2;
      if ((0x7 & l) != 0L)
      {
        bool1 = true;
        if ((!jQD) && (System.currentTimeMillis() - jQC < 15000L)) {
          break label265;
        }
        bool2 = true;
        label70:
        Log.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + jQD);
        if (!bool1) {
          break label271;
        }
        l = SystemClock.uptimeMillis();
        label129:
        jQA = l;
        if (0L != jQA)
        {
          l = SystemClock.uptimeMillis();
          if (l - jQA < 1800000L) {
            break label276;
          }
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1021L, 0L, 1L, true);
        }
        label169:
        if ((bool1) || (!bool2)) {
          break label332;
        }
      }
      label265:
      label271:
      label276:
      label332:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label337;
        }
        localObject = jQB;
        l = System.currentTimeMillis();
        ((e)localObject).jQP.acb();
        Log.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        jQC = System.currentTimeMillis();
        jQD = false;
        Log.i("FunctionMsg.FunctionMsgEngine", "[checkLoop] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(114111);
        return true;
        bool1 = false;
        break;
        bool2 = false;
        break label70;
        l = 0L;
        break label129;
        if (l - jQA >= 1200000L)
        {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1021L, 1L, 1L, true);
          break label169;
        }
        if (l - jQA < 600000L) {
          break label169;
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1021L, 2L, 1L, true);
        break label169;
      }
    }
    label337:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void aDY()
  {
    AppMethodBeat.i(114114);
    Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bs.VGw;
    localObject1 = ((Iterable)bs.hzo()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      i locali = (i)((Iterator)localObject1).next();
      Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { locali });
      if (locali.ZB() != -1)
      {
        Object localObject2 = com.tencent.mm.w.a.jQR;
        localObject2 = com.tencent.mm.w.a.rR(locali.ZB());
        if (localObject2 != null) {
          jQB.a(locali.ZB(), locali, (com.tencent.mm.w.b)localObject2);
        }
      }
    }
    localObject1 = bs.VGw;
    bs.hzp();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    p.k(paramd, "task");
    Log.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.jQM.ZD() + " op:" + paramInt + " status:" + paramd.jQM.getStatus());
    paramd.jQN.a(jQB, jQE, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(db paramdb, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(258434);
    p.k(paramdb, "addMsg");
    p.k(paramMap, "values");
    p.k(paramString, "source");
    int i = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramdb.CreateTime), Integer.valueOf(i) });
    jQD = true;
    long l1 = System.currentTimeMillis();
    a.a locala = new a.a(paramdb, paramMap);
    paramMap = locala.values;
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str4 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 3);
    paramMap = z.a(locala.jQG.RIF);
    if ((paramMap != null) && (paramMap.length() > 0))
    {
      int i4 = n.a((CharSequence)paramMap, "<addmsg>", 0, false, 6);
      int i5 = n.a((CharSequence)paramMap, "</addmsg>", 0, false, 6) + 9;
      if ((i5 > i4) && (i5 != -1) && (i4 != -1))
      {
        paramMap = paramMap.substring(i4, i5);
        p.j(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    for (;;)
    {
      Log.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str2, Integer.valueOf(i), str3, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, Long.valueOf(l3), str1, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      i locali = new i();
      locali.jS(j);
      locali.gi(str2);
      locali.setCmdId(i);
      if (str3 == null) {
        p.iCn();
      }
      locali.gj(str3);
      locali.bB(l2);
      locali.setRetryInterval(k);
      locali.jT(m);
      locali.jU(n);
      locali.jV(i1);
      locali.jW(i2);
      locali.gk(str4);
      locali.ZK();
      locali.a(locala.jQG);
      locali.gl(paramMap);
      paramMap = new rq();
      paramMap.Saw = l3;
      if (!Util.isNullOrNil(str1)) {
        paramMap.Sax = new com.tencent.mm.cd.b(Base64.decode(str1, 0));
      }
      locali.a(paramMap);
      locali.bE(l4);
      locali.bD(l5);
      locali.ZL();
      locali.jX(i3);
      paramMap = bs.VGw;
      paramMap = locali.ZD();
      p.j(paramMap, "item.functionMsgId");
      paramMap = bs.bwV(paramMap);
      if (paramMap != null) {
        Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s source=%s", new Object[] { paramMap, paramString });
      }
      for (;;)
      {
        paramString = com.tencent.mm.w.a.jQR;
        paramString = com.tencent.mm.w.a.rR(locali.ZB());
        if (paramString != null) {
          paramString.a(jQB, jQE, bs.VGw, locali, paramMap, paramdb.CreateTime);
        }
        boolean bool = aDX();
        Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms checkResult=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Boolean.valueOf(bool) });
        AppMethodBeat.o(258434);
        return;
        Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s source=%s", new Object[] { locali.ZD(), paramString });
      }
      paramMap = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */