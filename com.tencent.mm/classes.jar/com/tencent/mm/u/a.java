package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.api.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bg;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements r, com.tencent.mm.plugin.messenger.foundation.a.h, f
{
  public static long cDA;
  public static boolean cqf;
  private static long fXd;
  public static final e fXe;
  public static boolean fXf;
  private static final q fXg;
  public static final a fXh;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    fXh = locala;
    cqf = true;
    fXe = new e((f)locala);
    fXg = (q)new com.tencent.mm.s.a();
    AppMethodBeat.o(114115);
  }
  
  public static boolean adM()
  {
    AppMethodBeat.i(114111);
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    long l = locale.agA().YH(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!fXf) && (System.currentTimeMillis() - cDA < 15000L)) {
        break label181;
      }
      bool2 = true;
      label63:
      ac.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + fXf);
      if (!bool1) {
        break label186;
      }
      l = SystemClock.uptimeMillis();
      label121:
      fXd = l;
      if (0L != fXd)
      {
        l = SystemClock.uptimeMillis();
        if (l - fXd < 1800000L) {
          break label191;
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1021L, 0L, 1L, true);
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
      if (l - fXd >= 1200000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1021L, 1L, 1L, true);
      } else if (l - fXd >= 600000L) {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1021L, 2L, 1L, true);
      }
    }
    label247:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void adN()
  {
    AppMethodBeat.i(114114);
    ac.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bg.GYN;
    localObject1 = ((Iterable)bg.fbr()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.api.h localh = (com.tencent.mm.api.h)((Iterator)localObject1).next();
      ac.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localh });
      if (localh.Js() != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.fXt;
        localObject2 = com.tencent.mm.v.a.lI(localh.Js());
        if (localObject2 != null) {
          fXe.a(localh.Js(), localh, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = bg.GYN;
    bg.fbs();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    k.h(paramd, "task");
    ac.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.fXo.Jt() + " op:" + paramInt + " status:" + paramd.fXo.getStatus());
    paramd.fXp.a(fXe, fXg, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(cu paramcu, Map<String, String> paramMap)
  {
    AppMethodBeat.i(114112);
    k.h(paramcu, "addMsg");
    k.h(paramMap, "values");
    int i = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    ac.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcu.CreateTime), Integer.valueOf(i) });
    fXf = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramcu, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = bs.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = bs.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = bs.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = bs.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = bs.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 3);
    paramMap = z.a(locala.fXi.DPV);
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
      ac.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      com.tencent.mm.api.h localh = new com.tencent.mm.api.h();
      localh.he(j);
      localh.dL(str1);
      localh.setCmdId(i);
      if (str2 == null) {
        k.fOy();
      }
      localh.dM(str2);
      localh.aZ(l2);
      localh.setRetryInterval(k);
      localh.hf(m);
      localh.hg(n);
      localh.hh(i1);
      localh.hi(i2);
      localh.dN(str3);
      localh.JA();
      localh.a(locala.fXi);
      localh.dO(paramMap);
      paramMap = new pp();
      paramMap.EfY = l3;
      if (!bs.isNullOrNil((String)localObject)) {
        paramMap.EfZ = new com.tencent.mm.bw.b(Base64.decode((String)localObject, 0));
      }
      localh.a(paramMap);
      localh.bc(l4);
      localh.bb(l5);
      localh.JB();
      localh.hj(i3);
      paramMap = bg.GYN;
      paramMap = localh.Jt();
      k.g(paramMap, "item.functionMsgId");
      paramMap = bg.aOg(paramMap);
      if (paramMap != null) {
        ac.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.v.a.fXt;
        localObject = com.tencent.mm.v.a.lI(localh.Js());
        if (localObject != null) {
          ((com.tencent.mm.v.b)localObject).a(fXe, fXg, bg.GYN, localh, paramMap, paramcu.CreateTime);
        }
        ac.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(114112);
        return;
        ac.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { localh.Jt() });
      }
      paramMap = "";
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
  static final class a
  {
    final cu fXi;
    final Map<String, String> values;
    
    public a(cu paramcu, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.fXi = paramcu;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */