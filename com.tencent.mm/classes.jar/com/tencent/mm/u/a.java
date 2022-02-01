package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.api.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements r, com.tencent.mm.plugin.messenger.foundation.a.h, f
{
  public static long cGs;
  public static boolean csX;
  private static long fTj;
  public static final e fTk;
  public static boolean fTl;
  private static final q fTm;
  public static final a fTn;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    fTn = locala;
    csX = true;
    fTk = new e((f)locala);
    fTm = (q)new com.tencent.mm.s.a();
    AppMethodBeat.o(114115);
  }
  
  public static boolean acG()
  {
    AppMethodBeat.i(114111);
    com.tencent.mm.kernel.e locale = g.afB();
    k.g(locale, "MMKernel.storage()");
    long l = locale.afk().Wx(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!fTl) && (System.currentTimeMillis() - cGs < 15000L)) {
        break label181;
      }
      bool2 = true;
      label63:
      ad.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + fTl);
      if (!bool1) {
        break label186;
      }
      l = SystemClock.uptimeMillis();
      label121:
      fTj = l;
      if (0L != fTj)
      {
        l = SystemClock.uptimeMillis();
        if (l - fTj < 1800000L) {
          break label191;
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1021L, 0L, 1L, true);
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
      if (l - fTj >= 1200000L) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1021L, 1L, 1L, true);
      } else if (l - fTj >= 600000L) {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1021L, 2L, 1L, true);
      }
    }
    label247:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void acH()
  {
    AppMethodBeat.i(114114);
    ad.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bd.FzL;
    localObject1 = ((Iterable)bd.eLN()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.api.h localh = (com.tencent.mm.api.h)((Iterator)localObject1).next();
      ad.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localh });
      if (localh.JJ() != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.fTz;
        localObject2 = com.tencent.mm.v.a.lM(localh.JJ());
        if (localObject2 != null) {
          fTk.a(localh.JJ(), localh, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = bd.FzL;
    bd.eLO();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    k.h(paramd, "task");
    ad.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.fTu.JK() + " op:" + paramInt + " status:" + paramd.fTu.getStatus());
    paramd.fTv.a(fTk, fTm, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(cs paramcs, Map<String, String> paramMap)
  {
    AppMethodBeat.i(114112);
    k.h(paramcs, "addMsg");
    k.h(paramMap, "values");
    int i = bt.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    ad.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcs.CreateTime), Integer.valueOf(i) });
    fTl = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramcs, paramMap);
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
    paramMap = z.a(locala.fTo.Cxz);
    k.g(paramMap, "content");
    int i4 = n.a((CharSequence)paramMap, "<addmsg>", 0, false, 6);
    int i5 = n.a((CharSequence)paramMap, "</addmsg>", 0, false, 6) + 9;
    if ((i5 > i4) && (i5 != -1) && (i4 != -1))
    {
      paramMap = paramMap.substring(i4, i5);
      k.g(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      ad.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      com.tencent.mm.api.h localh = new com.tencent.mm.api.h();
      localh.hv(j);
      localh.dW(str1);
      localh.setCmdId(i);
      if (str2 == null) {
        k.fvU();
      }
      localh.dX(str2);
      localh.bd(l2);
      localh.setRetryInterval(k);
      localh.hw(m);
      localh.hx(n);
      localh.hy(i1);
      localh.hz(i2);
      localh.dY(str3);
      localh.JQ();
      localh.a(locala.fTo);
      localh.dZ(paramMap);
      paramMap = new pi();
      paramMap.CNw = l3;
      if (!bt.isNullOrNil((String)localObject)) {
        paramMap.CNx = new com.tencent.mm.bx.b(Base64.decode((String)localObject, 0));
      }
      localh.a(paramMap);
      localh.setActionTime(l4);
      localh.bf(l5);
      localh.JR();
      localh.hA(i3);
      paramMap = bd.FzL;
      paramMap = localh.JK();
      k.g(paramMap, "item.functionMsgId");
      paramMap = bd.aIK(paramMap);
      if (paramMap != null) {
        ad.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.v.a.fTz;
        localObject = com.tencent.mm.v.a.lM(localh.JJ());
        if (localObject != null) {
          ((com.tencent.mm.v.b)localObject).a(fTk, fTm, bd.FzL, localh, paramMap, paramcs.CreateTime);
        }
        ad.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(114112);
        return;
        ad.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { localh.JK() });
      }
      paramMap = "";
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
  static final class a
  {
    final cs fTo;
    final Map<String, String> values;
    
    public a(cs paramcs, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.fTo = paramcs;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */