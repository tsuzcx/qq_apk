package com.tencent.mm.v;

import android.util.Base64;
import com.tencent.mm.api.k;
import com.tencent.mm.api.l;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.Map;

public final class a
  implements l, h, f
{
  private static long bty;
  private static boolean dBn;
  private static final e dBo;
  private static boolean dBp;
  private static final k dBq = (k)new com.tencent.mm.s.a();
  public static final a dBr;
  
  static
  {
    a locala = new a();
    dBr = locala;
    dBn = true;
    dBo = new e((f)locala);
  }
  
  public final void Bw()
  {
    if (dBn)
    {
      y.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] begin!");
      Object localObject1 = ba.uBO;
      localObject1 = ((Iterable)ba.cve()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        com.tencent.mm.api.e locale = (com.tencent.mm.api.e)((Iterator)localObject1).next();
        y.i("FunctionMsg.FunctionMsgEngine", "[checkFromDb] item:%s", new Object[] { locale });
        if (locale.rN() != -1)
        {
          Object localObject2 = com.tencent.mm.w.a.dBD;
          localObject2 = com.tencent.mm.w.a.gW(locale.rN());
          if (localObject2 != null) {
            dBo.a(locale.rN(), locale, (com.tencent.mm.w.b)localObject2);
          }
        }
      }
      localObject1 = ba.uBO;
      ba.cvf();
      dBn = false;
    }
    y.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + dBn);
  }
  
  public final void Bx()
  {
    Object localObject = com.tencent.mm.kernel.g.DP();
    a.d.b.g.j(localObject, "MMKernel.storage()");
    long l = ((com.tencent.mm.kernel.e)localObject).Dz().Fm(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!dBp) && (System.currentTimeMillis() - bty < 15000L)) {
        break label204;
      }
      bool2 = true;
      label60:
      y.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + dBp);
      if ((bool1) || (!bool2)) {
        break label210;
      }
    }
    label204:
    label210:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = dBo;
        l = System.currentTimeMillis();
        ((e)localObject).dBB.loop();
        y.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        bty = System.currentTimeMillis();
        dBp = false;
        y.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label60;
    }
  }
  
  public final void a(int paramInt, d paramd)
  {
    a.d.b.g.k(paramd, "task");
    y.i("FunctionMsg.FunctionMsgEngine", "[onTaskExpired] id:" + paramd.dBy.rO() + " op:" + paramInt + " status:" + paramd.dBy.getStatus());
    paramd.dBz.a(dBo, dBq, paramd);
  }
  
  public final void a(cd paramcd, Map<String, String> paramMap)
  {
    a.d.b.g.k(paramcd, "addMsg");
    a.d.b.g.k(paramMap, "values");
    int i = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    y.i("FunctionMsg.FunctionMsgEngine", "[onReceive], addMsg.createTime: %s op:%s", new Object[] { Integer.valueOf(paramcd.mPL), Integer.valueOf(i) });
    dBp = true;
    long l1 = System.currentTimeMillis();
    a.a locala = new a.a(paramcd, paramMap);
    paramMap = locala.values;
    String str1 = (String)paramMap.get(".sysmsg.functionmsg.cgi");
    i = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.cmdid"), 0);
    String str2 = (String)paramMap.get(".sysmsg.functionmsg.functionmsgid");
    long l2 = bk.getLong((String)paramMap.get(".sysmsg.functionmsg.version"), 0L);
    int j = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.op"), 0);
    int k = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.retryinterval"), 0);
    int m = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.reportid"), 0);
    int n = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.successkey"), 0);
    int i1 = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.failkey"), 0);
    int i2 = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.finalfailkey"), 0);
    String str3 = (String)paramMap.get(".sysmsg.functionmsg.custombuff");
    long l3 = bk.getLong((String)paramMap.get(".sysmsg.functionmsg.businessid"), 0L);
    Object localObject = (String)paramMap.get(".sysmsg.functionmsg.businessbuff");
    long l4 = bk.getLong((String)paramMap.get(".sysmsg.functionmsg.actiontime"), 0L);
    long l5 = bk.getLong((String)paramMap.get(".sysmsg.functionmsg.delaytime"), 0L);
    int i3 = bk.getInt((String)paramMap.get(".sysmsg.functionmsg.retrycount"), 0);
    paramMap = aa.a(locala.dBs.svH);
    a.d.b.g.j(paramMap, "content");
    int i4 = a.h.e.b((CharSequence)paramMap, "<addmsg>", 0, 6);
    int i5 = a.h.e.b((CharSequence)paramMap, "</addmsg>", 0, 6) + 9;
    if ((i5 > i4) && (i5 != -1) && (i4 != -1))
    {
      paramMap = paramMap.substring(i4, i5);
      a.d.b.g.j(paramMap, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    for (;;)
    {
      y.i("FunctionMsg.FunctionMsgEngine", "parseAddMsg,op:%s cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s businessid:%s businessbuff:%s actiontime:%s delaytime:%s retryCount:%s", new Object[] { Integer.valueOf(j), str1, Integer.valueOf(i), str2, Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str3, Long.valueOf(l3), localObject, Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(i3) });
      com.tencent.mm.api.e locale = new com.tencent.mm.api.e();
      locale.eh(j);
      locale.bU(str1);
      locale.setCmdId(i);
      if (str2 == null) {
        a.d.b.g.cUk();
      }
      locale.bV(str2);
      locale.af(l2);
      locale.setRetryInterval(k);
      locale.ei(m);
      locale.ej(n);
      locale.ek(i1);
      locale.el(i2);
      locale.bW(str3);
      locale.rV();
      locale.a(locala.dBs);
      locale.bX(paramMap);
      paramMap = new kt();
      paramMap.sFI = l3;
      if (!bk.bl((String)localObject)) {
        paramMap.sFJ = new com.tencent.mm.bv.b(Base64.decode((String)localObject, 0));
      }
      locale.a(paramMap);
      locale.ai(l4);
      locale.ah(l5);
      locale.rW();
      locale.em(i3);
      paramMap = ba.uBO;
      paramMap = locale.rO();
      a.d.b.g.j(paramMap, "item.functionMsgId");
      paramMap = ba.abV(paramMap);
      if (paramMap != null) {
        y.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], old functionMsgItem:%s", new Object[] { paramMap });
      }
      for (;;)
      {
        localObject = com.tencent.mm.w.a.dBD;
        localObject = com.tencent.mm.w.a.gW(locale.rN());
        if (localObject != null) {
          ((com.tencent.mm.w.b)localObject).a(dBo, dBq, ba.uBO, locale, paramMap, paramcd.mPL);
        }
        y.i("FunctionMsg.FunctionMsgEngine", "[onReceive] cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
        return;
        y.i("FunctionMsg.FunctionMsgEngine", "[handleFunctionMsgItem], has not exist! id:%s", new Object[] { locale.rO() });
      }
      paramMap = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.a
 * JD-Core Version:    0.7.0.1
 */