package com.tencent.mm.plugin.sns.f;

import android.os.CancellationSignal.OnCancelListener;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nl;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.c.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.support.OperationCanceledException;
import java.util.ArrayList;

public final class a
{
  private static long Qks = 10080L;
  
  public static void a(android.os.CancellationSignal paramCancellationSignal, long paramLong)
  {
    AppMethodBeat.i(306320);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("SnsMMKV");
    if (localMultiProcessMMKV.getBoolean("SnsMMKVSnsUI", false))
    {
      Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit in SnsUI, exit clean.");
      AppMethodBeat.o(306320);
      return;
    }
    long l3 = SystemClock.uptimeMillis();
    long l4 = System.currentTimeMillis();
    long l2 = al.hgB().hlb();
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baF();
    long l5 = new u(com.tencent.mm.kernel.h.baE().cachePath + "SnsMicroMsg.db").length();
    Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbSize. originSnsDbCount:%s, originSnsDbSize:%s MB", new Object[] { Long.valueOf(l2), Long.valueOf(l5 / 1024L / 1024L) });
    localMultiProcessMMKV.encode("SnsMMKVCleanDbCount", l2);
    localObject = new nl();
    ((nl)localObject).jfa = l2;
    ((nl)localObject).jfc = l5;
    ((nl)localObject).jfk = 1;
    ((nl)localObject).bMH();
    localObject = localMultiProcessMMKV.getString("SnsMMKVCleanDbReport", "");
    if (!Util.isNullOrNil((String)localObject))
    {
      al.hgF().hkT();
      com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 115);
      localObject = new nl((String)localObject);
      ((nl)localObject).jeZ = 5;
      ((nl)localObject).jfb = (((nl)localObject).jfa - l2);
      ((nl)localObject).jfd = (((nl)localObject).jfc - l5);
      ((nl)localObject).bMH();
      localMultiProcessMMKV.encode("SnsMMKVCleanDbFailTime", localMultiProcessMMKV.getInt("SnsMMKVCleanDbFailTime", 0) + 1);
      localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
      Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit lastTime error exit. %s", new Object[] { ((nl)localObject).aIE() });
    }
    if (Util.getInt(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfE, "1"), 1) <= 0)
    {
      Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit cleanDbSwitch not enable.");
      AppMethodBeat.o(306320);
      return;
    }
    long l1 = Util.getLong(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfG, "1000"), 0L);
    int i;
    if (l1 > 0L)
    {
      i = localMultiProcessMMKV.getInt("SnsMMKVCleanDbSQLREPORTTIME", 0);
      if (i < l1)
      {
        Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit count:%s not enable.", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(306320);
        return;
      }
    }
    long l6 = Util.getLong(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfH, "10000"), 10000L);
    l1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfJ, -1L);
    if (l1 >= 0L) {
      Log.i("MicroMsg.SnsCleanStorageManager", "use clicfgTimeLimit:%d min", new Object[] { Long.valueOf(l1) });
    }
    for (;;)
    {
      paramLong = l1;
      if (l1 < 0L)
      {
        l1 = Util.getLong(((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zfI, Long.toString(Qks)), Qks);
        paramLong = l1;
        if (l1 >= 0L) {}
      }
      for (l1 = Qks;; l1 = paramLong)
      {
        com.tencent.wcdb.support.CancellationSignal localCancellationSignal = new com.tencent.wcdb.support.CancellationSignal();
        if ((paramCancellationSignal != null) && (paramCancellationSignal.isCanceled()))
        {
          Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbExpire cancel.");
          localCancellationSignal.cancel();
          AppMethodBeat.o(306320);
          return;
        }
        paramCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
        {
          public final void onCancel()
          {
            AppMethodBeat.i(306312);
            Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbExpire cancel.");
            a.this.cancel();
            AppMethodBeat.o(306312);
          }
        });
        Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit start.");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 111);
        boolean bool2 = localMultiProcessMMKV.getBoolean("SnsMMKVCleanDbIsFirstTime", true);
        int j = localMultiProcessMMKV.getInt("SnsMMKVCleanDbFailTime", 0);
        localObject = new nl();
        ((nl)localObject).jfa = l2;
        ((nl)localObject).jfc = l5;
        ((nl)localObject).jfg = l1;
        if (bool2) {}
        for (i = 1;; i = 0)
        {
          ((nl)localObject).jfh = i;
          ((nl)localObject).jfi = l4;
          ((nl)localObject).jfk = 0;
          ((nl)localObject).jfl = j;
          localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", ((nl)localObject).aIE());
          paramLong = (System.currentTimeMillis() - 60L * l1 * 1000L) / 1000L;
          if ((paramCancellationSignal == null) || (!paramCancellationSignal.isCanceled())) {
            break;
          }
          Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbExpire cancel.");
          com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 113);
          ((nl)localObject).jeZ = 2;
          ((nl)localObject).jfe = (SystemClock.uptimeMillis() - l3);
          ((nl)localObject).bMH();
          localMultiProcessMMKV.encode("SnsMMKVCleanDbFailTime", j + 1);
          localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
          AppMethodBeat.o(306320);
          return;
        }
        try
        {
          al.hgB().a(paramLong, l6, localCancellationSignal);
          i = 0;
        }
        catch (OperationCanceledException paramCancellationSignal)
        {
          for (;;)
          {
            Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbExpire delete cancel, e:%s.", new Object[] { paramCancellationSignal });
            com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 117);
            ((nl)localObject).jeZ = 6;
            localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", ((nl)localObject).aIE());
            i = 1;
          }
        }
        catch (Exception paramCancellationSignal)
        {
          Log.e("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit calcDbExpire delete failed, e:%s.", new Object[] { paramCancellationSignal });
          com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 114);
          al.hgF().hkT();
          ((nl)localObject).jeZ = 3;
          ((nl)localObject).jfe = (SystemClock.uptimeMillis() - l3);
          ((nl)localObject).bMH();
          localMultiProcessMMKV.encode("SnsMMKVCleanDbFailTime", j + 1);
          localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
          AppMethodBeat.o(306320);
          return;
        }
        if (i == 0)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(150, 112);
          ((nl)localObject).jeZ = 1;
          localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", ((nl)localObject).aIE());
          Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit delete db finish.");
        }
        al.hgF().hkT();
        l6 = al.hgB().hlb();
        paramCancellationSignal = new StringBuilder();
        com.tencent.mm.kernel.h.baF();
        long l7 = new u(com.tencent.mm.kernel.h.baE().cachePath + "SnsMicroMsg.db").length();
        localMultiProcessMMKV.encode("SnsMMKVCleanDbCount", l6);
        l3 = SystemClock.uptimeMillis() - l3;
        paramLong = localMultiProcessMMKV.getLong("SnsMMKVCleanDbLastCleanTime", 0L);
        if (paramLong > 0L) {}
        for (paramLong = l4 - paramLong;; paramLong = 0L)
        {
          boolean bool1;
          if (i == 0)
          {
            bool1 = true;
            Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTablesByTimeLimit finish, isFinish:%s, limit:%s min, SnsDbCount[%s, %s, diff:%s], SnsDbSize[%s, %s, diff:%s kb], costTime:%s ms, timeSinceLastClean:%s s, startTime:%s ms", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l6), Long.valueOf(l2 - l6), Long.valueOf(l5 / 1024L), Long.valueOf(l7 / 1024L), Long.valueOf((l5 - l7) / 1024L), Long.valueOf(l3), Long.valueOf(paramLong / 1000L), Long.valueOf(l4) });
            paramCancellationSignal = new ArrayList();
            if (l2 > 0L) {
              break label1513;
            }
            l1 = 1L;
            label1125:
            paramCancellationSignal.add(new IDKey(150L, 121L, l1));
            if (l2 - l6 > 0L) {
              break label1520;
            }
            l1 = 1L;
            label1158:
            paramCancellationSignal.add(new IDKey(150L, 122L, l1));
            if (l5 / 1024L > 0L) {
              break label1530;
            }
            l1 = 1L;
            label1192:
            paramCancellationSignal.add(new IDKey(150L, 123L, l1));
            if ((l5 - l7) / 1024L > 0L) {
              break label1541;
            }
            l1 = 1L;
            label1229:
            paramCancellationSignal.add(new IDKey(150L, 124L, l1));
            if (l3 > 0L) {
              break label1555;
            }
            l1 = 1L;
            label1259:
            paramCancellationSignal.add(new IDKey(150L, 126L, l1));
            com.tencent.mm.plugin.report.service.h.OAn.b(paramCancellationSignal, false);
            ((nl)localObject).jfb = (l2 - l6);
            ((nl)localObject).jfd = (l5 - l7);
            ((nl)localObject).jfe = l3;
            ((nl)localObject).jfj = paramLong;
            ((nl)localObject).bMH();
            localMultiProcessMMKV.encode("SnsMMKVCleanDbReport", "");
            if (i == 0) {
              break label1562;
            }
            localMultiProcessMMKV.encode("SnsMMKVCleanDbFailTime", j + 1);
          }
          for (;;)
          {
            localMultiProcessMMKV.encode("SnsMMKVCleanDbLastCleanTime", l4);
            AppMethodBeat.o(306320);
            return;
            bool1 = false;
            break;
            label1513:
            l1 = l2;
            break label1125;
            label1520:
            l1 = l2 - l6;
            break label1158;
            label1530:
            l1 = l5 / 1024L;
            break label1192;
            label1541:
            l1 = (l5 - l7) / 1024L;
            break label1229;
            label1555:
            l1 = l3;
            break label1259;
            label1562:
            localMultiProcessMMKV.encode("SnsMMKVCleanDbFailTime", 0);
            if (bool2) {
              localMultiProcessMMKV.encode("SnsMMKVCleanDbIsFirstTime", false);
            }
          }
        }
      }
      l1 = paramLong;
    }
  }
  
  public static void hek()
  {
    AppMethodBeat.i(306322);
    Log.i("MicroMsg.SnsCleanStorageManager", "cleanSnsTables.");
    MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", true);
    localw = al.hgB();
    long l4 = System.currentTimeMillis();
    l2 = 0L;
    l1 = l2;
    try
    {
      long l3 = localw.QYR.beginTransaction(-1L);
      l1 = l3;
      l2 = l3;
      localw.QYR.execSQL("SnsInfo", "DROP TABLE SnsInfo");
      l1 = l3;
      l2 = l3;
      localw.QYR.execSQL("SnsInfo", w.SQL_CREATE[0]);
      localw.QYR.endTransaction(l3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l2 = l1;
        Log.e("MicroMsg.SnsInfoStorage", "drop table Error :" + localException.getMessage());
        localw.QYR.endTransaction(l1);
      }
    }
    finally
    {
      localw.QYR.endTransaction(l2);
      AppMethodBeat.o(306322);
    }
    Log.i("MicroMsg.SnsInfoStorage", "deleteTable cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l4) });
    al.hgF().hkT();
    q.Qkn.a(2, z.bAM(), true, 0);
    AppMethodBeat.o(306322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.a
 * JD-Core Version:    0.7.0.1
 */