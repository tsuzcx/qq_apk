package com.tencent.mm.s;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.api.v;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "isSyncing", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "checkLoop", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "source", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements v, k, f
{
  public static boolean isInit;
  public static final a mpG;
  public static volatile boolean mpH;
  private static long mpI;
  private static final e mpJ;
  private static long mpK;
  private static boolean mpL;
  private static final u mpM;
  
  static
  {
    AppMethodBeat.i(114115);
    mpG = new a();
    isInit = true;
    mpJ = new e((f)mpG);
    mpM = (u)new com.tencent.mm.o.a();
    AppMethodBeat.o(114115);
  }
  
  public static void aWZ()
  {
    AppMethodBeat.i(231405);
    Log.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(231405);
  }
  
  public static boolean aXa()
  {
    AppMethodBeat.i(114111);
    if (!mpH)
    {
      long l = com.tencent.mm.kernel.h.baE().ban().amW(8196);
      boolean bool1;
      boolean bool2;
      if ((0x7 & l) != 0L)
      {
        bool1 = true;
        if ((!mpL) && (System.currentTimeMillis() - mpK < 15000L)) {
          break label254;
        }
        bool2 = true;
        label59:
        Log.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + mpL);
        if (!bool1) {
          break label260;
        }
        l = SystemClock.uptimeMillis();
        label118:
        mpI = l;
        if (0L != mpI)
        {
          l = SystemClock.uptimeMillis();
          if (l - mpI < 1800000L) {
            break label265;
          }
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1021L, 0L, 1L, true);
        }
        label158:
        if ((bool1) || (!bool2)) {
          break label321;
        }
      }
      label260:
      label265:
      label321:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label326;
        }
        e locale = mpJ;
        l = System.currentTimeMillis();
        locale.mpX.aEa();
        Log.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        mpK = System.currentTimeMillis();
        mpL = false;
        Log.i("FunctionMsg.FunctionMsgEngine", "[checkLoop] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        AppMethodBeat.o(114111);
        return true;
        bool1 = false;
        break;
        label254:
        bool2 = false;
        break label59;
        l = 0L;
        break label118;
        if (l - mpI >= 1200000L)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1021L, 1L, 1L, true);
          break label158;
        }
        if (l - mpI < 600000L) {
          break label158;
        }
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1021L, 2L, 1L, true);
        break label158;
      }
    }
    label326:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void aXb()
  {
    AppMethodBeat.i(114114);
    Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bu.adkj;
    localObject1 = bu.jbo();
    s.checkNotNull(localObject1);
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      j localj = (j)((Iterator)localObject1).next();
      Log.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localj });
      if (localj.field_opCode != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.mqa;
        localObject2 = com.tencent.mm.v.a.rS(localj.field_opCode);
        if (localObject2 != null) {
          mpJ.a(localj.field_opCode, localj, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = bu.adkj;
    bu.jbp();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    s.u(paramd, "task");
    Log.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.mpT.field_functionmsgid + " op:" + paramInt + " status:" + paramd.mpT.field_status);
    paramd.mpU.a(mpJ, mpM, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(dl paramdl, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(231439);
    s.u(paramdl, "addMsg");
    s.u(paramMap, "values");
    s.u(paramString, "source");
    int i = Util.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramdl.CreateTime), Integer.valueOf(i) });
    mpL = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramdl, paramMap);
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
    paramMap = w.a(locala.mpN.YFG);
    if ((paramMap != null) && (paramMap.length() > 0))
    {
      int i4 = n.a((CharSequence)paramMap, "<addmsg>", 0, false, 6);
      int i5 = n.a((CharSequence)paramMap, "</addmsg>", 0, false, 6) + 9;
      if ((i5 > i4) && (i5 != -1) && (i4 != -1))
      {
        paramMap = paramMap.substring(i4, i5);
        s.s(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    for (;;)
    {
      Log.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      j localj = new j();
      localj.field_opCode = j;
      if (!Util.isNullOrNil(str1)) {
        localj.field_cgi = str1;
      }
      localj.field_cmdid = i;
      s.checkNotNull(str2);
      if (!Util.isNullOrNil(str2)) {
        localj.field_functionmsgid = str2;
      }
      localj.field_version = l2;
      localj.field_retryinterval = k;
      localj.field_reportid = m;
      localj.field_successkey = n;
      localj.field_failkey = i1;
      localj.field_finalfailkey = i2;
      localj.hL(str3);
      localj.field_status = -1;
      localj.a(locala.mpN);
      if (paramMap != null) {
        localj.field_defaultContent = paramMap;
      }
      paramMap = new tb();
      paramMap.YYv = l3;
      if (!Util.isNullOrNil((String)localObject)) {
        paramMap.YYw = new com.tencent.mm.bx.b(Base64.decode((String)localObject, 0));
      }
      localj.field_businessInfo = paramMap;
      localj.field_actionTime = l4;
      localj.field_delayTime = l5;
      localj.field_retryCount = 0;
      localj.field_retryCountLimit = i3;
      paramMap = bu.adkj;
      paramMap = localj.field_functionmsgid;
      s.s(paramMap, "item.functionMsgId");
      localObject = bu.byo(paramMap);
      if (localObject == null) {}
      for (paramMap = null;; paramMap = ah.aiuX)
      {
        if (paramMap == null) {
          Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s source=%s", new Object[] { localj.field_functionmsgid, paramString });
        }
        paramMap = com.tencent.mm.v.a.mqa;
        paramMap = com.tencent.mm.v.a.rS(localj.field_opCode);
        if (paramMap != null) {
          paramMap.a(mpJ, mpM, bu.adkj, localj, (j)localObject, paramdl.CreateTime);
        }
        boolean bool = aXa();
        Log.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms checkResult=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), Boolean.valueOf(bool) });
        AppMethodBeat.o(231439);
        return;
        Log.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s source=%s", new Object[] { localObject, paramString });
      }
      paramMap = "";
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final dl mpN;
    final Map<String, String> values;
    
    public a(dl paramdl, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.mpN = paramdl;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.s.a
 * JD-Core Version:    0.7.0.1
 */