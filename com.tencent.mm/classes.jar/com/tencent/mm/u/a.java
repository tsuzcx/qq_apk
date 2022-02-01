package com.tencent.mm.u;

import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.api.r;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bn;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/engine/FunctionMsgEngine;", "Lcom/tencent/mm/api/IFunctionMsgEngine;", "Lcom/tencent/mm/engine/ITimerCallback;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IFunctionMsgService;", "()V", "TAG", "", "isInit", "", "isNeedCheckSoon", "lastContinueSync", "", "mDispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "mLastCheckTime", "mTimer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "afterSyncDoCmd", "", "beforeSyncDoCmd", "checkFromDb", "finishSyncDoCmd", "isNeedCheckTimer", "onInit", "onReceive", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "onTaskExpired", "op", "", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "parseAddMsg", "Lcom/tencent/mm/api/FunctionMsgItem;", "functionMsg", "Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "reportException", "isContinueSync", "FunctionMsg", "plugin-functionmsg_release"})
public final class a
  implements r, i, f
{
  public static boolean cBE;
  public static long cPp;
  private static long gsZ;
  public static final e gta;
  public static boolean gtb;
  private static final q gtc;
  public static final a gtd;
  
  static
  {
    AppMethodBeat.i(114115);
    a locala = new a();
    gtd = locala;
    cBE = true;
    gta = new e((f)locala);
    gtc = (q)new com.tencent.mm.s.a();
    AppMethodBeat.o(114115);
  }
  
  public static boolean agG()
  {
    AppMethodBeat.i(114111);
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
    p.g(locale, "MMKernel.storage()");
    long l = locale.ajA().aby(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!gtb) && (System.currentTimeMillis() - cPp < 15000L)) {
        break label181;
      }
      bool2 = true;
      label63:
      ae.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + gtb);
      if (!bool1) {
        break label186;
      }
      l = SystemClock.uptimeMillis();
      label121:
      gsZ = l;
      if (0L != gsZ)
      {
        l = SystemClock.uptimeMillis();
        if (l - gsZ < 1800000L) {
          break label191;
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1021L, 0L, 1L, true);
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
      if (l - gsZ >= 1200000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1021L, 1L, 1L, true);
      } else if (l - gsZ >= 600000L) {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1021L, 2L, 1L, true);
      }
    }
    label247:
    AppMethodBeat.o(114111);
    return false;
  }
  
  public static void agH()
  {
    AppMethodBeat.i(114114);
    ae.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
    Object localObject1 = bn.JgJ;
    localObject1 = ((Iterable)bn.fvu()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      h localh = (h)((Iterator)localObject1).next();
      ae.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { localh });
      if (localh.KZ() != -1)
      {
        Object localObject2 = com.tencent.mm.v.a.gtp;
        localObject2 = com.tencent.mm.v.a.mk(localh.KZ());
        if (localObject2 != null) {
          gta.a(localh.KZ(), localh, (com.tencent.mm.v.b)localObject2);
        }
      }
    }
    localObject1 = bn.JgJ;
    bn.fvv();
    AppMethodBeat.o(114114);
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(114113);
    p.h(paramd, "task");
    ae.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.gtk.La() + " op:" + paramInt + " status:" + paramd.gtk.getStatus());
    paramd.gtl.a(gta, gtc, paramd);
    AppMethodBeat.o(114113);
  }
  
  public final void a(cv paramcv, Map<String, String> paramMap)
  {
    AppMethodBeat.i(114112);
    p.h(paramcv, "addMsg");
    p.h(paramMap, "values");
    int i = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    ae.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcv.CreateTime), Integer.valueOf(i) });
    gtb = true;
    long l1 = System.currentTimeMillis();
    a locala = new a(paramcv, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = bu.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = bu.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = bu.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = bu.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = bu.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 3);
    paramMap = z.a(locala.gte.FNI);
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
      ae.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      h localh = new h();
      localh.hm(j);
      localh.eL(str1);
      localh.setCmdId(i);
      if (str2 == null) {
        p.gkB();
      }
      localh.eM(str2);
      localh.aZ(l2);
      localh.setRetryInterval(k);
      localh.hn(m);
      localh.ho(n);
      localh.hp(i1);
      localh.hq(i2);
      localh.eN(str3);
      localh.Lh();
      localh.a(locala.gte);
      localh.eO(paramMap);
      paramMap = new qw();
      paramMap.GeW = l3;
      if (!bu.isNullOrNil((String)localObject)) {
        paramMap.GeX = new com.tencent.mm.bw.b(Base64.decode((String)localObject, 0));
      }
      localh.a(paramMap);
      localh.bc(l4);
      localh.bb(l5);
      localh.Li();
      localh.hr(i3);
      paramMap = bn.JgJ;
      paramMap = localh.La();
      p.g(paramMap, "item.functionMsgId");
      paramMap = bn.aVy(paramMap);
      if (paramMap != null) {
        ae.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.v.a.gtp;
        localObject = com.tencent.mm.v.a.mk(localh.KZ());
        if (localObject != null) {
          ((com.tencent.mm.v.b)localObject).a(gta, gtc, bn.JgJ, localh, paramMap, paramcv.CreateTime);
        }
        ae.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        AppMethodBeat.o(114112);
        return;
        ae.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { localh.La() });
      }
      paramMap = "";
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/engine/FunctionMsgEngine$FunctionMsg;", "", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "values", "", "", "(Lcom/tencent/mm/protocal/protobuf/AddMsg;Ljava/util/Map;)V", "getAddMsg", "()Lcom/tencent/mm/protocal/protobuf/AddMsg;", "getValues", "()Ljava/util/Map;", "plugin-functionmsg_release"})
  static final class a
  {
    final cv gte;
    final Map<String, String> values;
    
    public a(cv paramcv, Map<String, String> paramMap)
    {
      AppMethodBeat.i(114110);
      this.gte = paramcv;
      this.values = paramMap;
      AppMethodBeat.o(114110);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.u.a
 * JD-Core Version:    0.7.0.1
 */