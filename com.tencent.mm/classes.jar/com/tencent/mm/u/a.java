package com.tencent.mm.u;

import a.f.b.j;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ba;
import java.util.Iterator;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements com.tencent.mm.api.m, com.tencent.mm.plugin.messenger.foundation.a.h, f
{
  public static boolean bRB;
  public static long bUI;
  private static long eyE;
  public static final e eyF;
  public static boolean eyG;
  private static final com.tencent.mm.api.l eyH;
  public static final a eyI;
  
  static
  {
    AppMethodBeat.i(35463);
    a locala = new a();
    eyI = locala;
    bRB = true;
    eyF = new e((f)locala);
    eyH = (com.tencent.mm.api.l)new com.tencent.mm.s.a();
    AppMethodBeat.o(35463);
  }
  
  public static void Pl()
  {
    AppMethodBeat.i(141042);
    ab.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = ba.yOa;
    localObject1 = ((Iterable)ba.dxI()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.api.f localf = (com.tencent.mm.api.f)((Iterator)localObject1).next();
      ab.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localf });
      if (localf.Ac() != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.eyU;
        localObject2 = com.tencent.mm.v.a.jl(localf.Ac());
        if (localObject2 != null) {
          eyF.a(localf.Ac(), localf, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = ba.yOa;
    ba.dxJ();
    AppMethodBeat.o(141042);
  }
  
  public static void cq(boolean paramBoolean)
  {
    AppMethodBeat.i(141041);
    if (paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      eyE = l;
      if (0L == eyE) {
        break label120;
      }
      l = SystemClock.uptimeMillis();
      if (l - eyE < 1800000L) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1021L, 0L, 1L, true);
      AppMethodBeat.o(141041);
      return;
    }
    if (l - eyE >= 1200000L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1021L, 1L, 1L, true);
      AppMethodBeat.o(141041);
      return;
    }
    if (l - eyE >= 600000L) {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(1021L, 2L, 1L, true);
    }
    label120:
    AppMethodBeat.o(141041);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(35462);
    j.q(paramd, "task");
    ab.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.eyP.Ad() + " op:" + paramInt + " status:" + paramd.eyP.getStatus());
    paramd.eyQ.a(eyF, eyH, paramd);
    AppMethodBeat.o(35462);
  }
  
  public final void a(cm paramcm, Map<String, String> paramMap)
  {
    AppMethodBeat.i(35461);
    j.q(paramcm, "addMsg");
    j.q(paramMap, "values");
    int i = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    ab.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcm.CreateTime), Integer.valueOf(i) });
    eyG = true;
    long l1 = System.currentTimeMillis();
    a.a locala = new a.a(paramcm, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = bo.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = bo.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = bo.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = bo.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = bo.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 0);
    paramMap = aa.a(locala.eyJ.woR);
    j.p(paramMap, "content");
    int i4 = a.l.m.a((CharSequence)paramMap, "<addmsg>", 0, false, 6);
    int i5 = a.l.m.a((CharSequence)paramMap, "</addmsg>", 0, false, 6) + 9;
    if ((i5 > i4) && (i5 != -1) && (i4 != -1))
    {
      paramMap = paramMap.substring(i4, i5);
      j.p(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      ab.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      com.tencent.mm.api.f localf = new com.tencent.mm.api.f();
      localf.fU(j);
      localf.cW(str1);
      localf.setCmdId(i);
      if (str2 == null) {
        j.ebi();
      }
      localf.cX(str2);
      localf.aC(l2);
      localf.setRetryInterval(k);
      localf.fV(m);
      localf.fW(n);
      localf.fX(i1);
      localf.fY(i2);
      localf.cY(str3);
      localf.Aj();
      localf.a(locala.eyJ);
      localf.cZ(paramMap);
      paramMap = new nf();
      paramMap.wCc = l3;
      if (!bo.isNullOrNil((String)localObject)) {
        paramMap.wCd = new com.tencent.mm.bv.b(Base64.decode((String)localObject, 0));
      }
      localf.a(paramMap);
      localf.aF(l4);
      localf.aE(l5);
      localf.Ak();
      localf.fZ(i3);
      paramMap = ba.yOa;
      paramMap = localf.Ad();
      j.p(paramMap, "item.functionMsgId");
      paramMap = ba.asf(paramMap);
      if (paramMap != null) {
        ab.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.v.a.eyU;
        localObject = com.tencent.mm.v.a.jl(localf.Ac());
        if (localObject != null) {
          ((com.tencent.mm.v.b)localObject).a(eyF, eyH, ba.yOa, localf, paramMap, paramcm.CreateTime);
        }
        ab.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(35461);
        return;
        ab.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { localf.Ad() });
      }
      paramMap = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */