package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.api.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bs;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements t, com.tencent.mm.plugin.messenger.foundation.a.i, f
{
  public static long dfO;
  private static long heJ;
  public static final e heK;
  public static boolean heL;
  private static final s heM;
  public static final a heN;
  public static boolean isInit;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    heN = locala;
    isInit = true;
    heK = new e((f)locala);
    heM = (s)new com.tencent.mm.r.a();
    AppMethodBeat.o(114115);
  }
  
  public static boolean awF()
  {
    AppMethodBeat.i(114111);
    com.tencent.mm.kernel.e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    long l = locale.azQ().akg(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!heL) && (System.currentTimeMillis() - dfO < 15000L)) {
        break label181;
      }
      bool2 = true;
      label63:
      Log.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + heL);
      if (!bool1) {
        break label186;
      }
      l = SystemClock.uptimeMillis();
      label121:
      heJ = l;
      if (0L != heJ)
      {
        l = SystemClock.uptimeMillis();
        if (l - heJ < 1800000L) {
          break label191;
        }
        h.CyF.idkeyStat(1021L, 0L, 1L, true);
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
      if (l - heJ >= 1200000L) {
        h.CyF.idkeyStat(1021L, 1L, 1L, true);
      } else if (l - heJ >= 600000L) {
        h.CyF.idkeyStat(1021L, 2L, 1L, true);
      }
    }
    label247:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void awG()
  {
    AppMethodBeat.i(114114);
    Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bs.OqA;
    localObject1 = ((Iterable)bs.gDb()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.api.i locali = (com.tencent.mm.api.i)((Iterator)localObject1).next();
      Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { locali });
      if (locali.Vj() != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.heZ;
        localObject2 = com.tencent.mm.v.a.pu(locali.Vj());
        if (localObject2 != null) {
          heK.a(locali.Vj(), locali, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = bs.OqA;
    bs.gDc();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    p.h(paramd, "task");
    Log.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.heU.Vk() + " op:" + paramInt + " status:" + paramd.heU.getStatus());
    paramd.heV.a(heK, heM, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(de paramde, Map<String, String> paramMap)
  {
    AppMethodBeat.i(114112);
    p.h(paramde, "addMsg");
    p.h(paramMap, "values");
    int i = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramde.CreateTime), Integer.valueOf(i) });
    heL = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramde, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = Util.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 3);
    paramMap = z.a(locala.heO.KHn);
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
      Log.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      com.tencent.mm.api.i locali = new com.tencent.mm.api.i();
      locali.iG(j);
      locali.fx(str1);
      locali.setCmdId(i);
      if (str2 == null) {
        p.hyc();
      }
      locali.fy(str2);
      locali.bo(l2);
      locali.setRetryInterval(k);
      locali.iH(m);
      locali.iI(n);
      locali.iJ(i1);
      locali.iK(i2);
      locali.fz(str3);
      locali.Vr();
      locali.a(locala.heO);
      locali.fA(paramMap);
      paramMap = new rx();
      paramMap.KZn = l3;
      if (!Util.isNullOrNil((String)localObject)) {
        paramMap.KZo = new com.tencent.mm.bw.b(Base64.decode((String)localObject, 0));
      }
      locali.a(paramMap);
      locali.br(l4);
      locali.bq(l5);
      locali.Vs();
      locali.iL(i3);
      paramMap = bs.OqA;
      paramMap = locali.Vk();
      p.g(paramMap, "item.functionMsgId");
      paramMap = bs.bkw(paramMap);
      if (paramMap != null) {
        Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.v.a.heZ;
        localObject = com.tencent.mm.v.a.pu(locali.Vj());
        if (localObject != null) {
          ((com.tencent.mm.v.b)localObject).a(heK, heM, bs.OqA, locali, paramMap, paramde.CreateTime);
        }
        Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(114112);
        return;
        Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { locali.Vk() });
      }
      paramMap = "";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
  static final class a
  {
    final de heO;
    final Map<String, String> values;
    
    public a(de paramde, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.heO = paramde;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */