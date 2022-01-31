package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static ak qsn;
  private static int qso;
  private static volatile long qsp;
  private static volatile int qsq;
  private static BroadCastData qsr;
  
  static
  {
    AppMethodBeat.i(72717);
    HandlerThread localHandlerThread = d.aqu("kv_report");
    localHandlerThread.start();
    qsn = new ak(localHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(72703);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1) {
          KVCommCrossProcessReceiver.access$000();
        }
        AppMethodBeat.o(72703);
      }
    };
    className = "";
    qso = 10000;
    qsp = 10000L;
    qsq = -1;
    qsr = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(72717);
  }
  
  public static void O(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(72711);
    ab.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = qsr;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.qsg.add(paramArrayList);
      if ((qsp == 0L) || (chL()))
      {
        qsn.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(72711);
        return;
      }
    }
    if (qsn.hasMessages(1))
    {
      AppMethodBeat.o(72711);
      return;
    }
    qsn.sendEmptyMessageDelayed(1, qsp);
    AppMethodBeat.o(72711);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(72709);
    ab.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.qsF), Long.valueOf(paramKVReportDataInfo.cnw), Boolean.valueOf(paramKVReportDataInfo.qsi), Boolean.valueOf(paramKVReportDataInfo.qsG) });
    synchronized (lock)
    {
      qsr.qse.add(paramKVReportDataInfo);
      if ((qsp == 0L) || (chL()))
      {
        qsn.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(72709);
        return;
      }
    }
    if (qsn.hasMessages(1))
    {
      AppMethodBeat.o(72709);
      return;
    }
    qsn.sendEmptyMessageDelayed(1, qsp);
    AppMethodBeat.o(72709);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(72710);
    ab.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.ltw), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.qsi) });
    synchronized (lock)
    {
      qsr.qsf.add(paramStIDKeyDataInfo);
      if ((qsp == 0L) || (chL()))
      {
        qsn.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(72710);
        return;
      }
    }
    if (qsn.hasMessages(1))
    {
      AppMethodBeat.o(72710);
      return;
    }
    qsn.sendEmptyMessageDelayed(1, qsp);
    AppMethodBeat.o(72710);
  }
  
  public static void chJ()
  {
    if (100L < 0L) {
      return;
    }
    qsp = 100L;
  }
  
  public static void chK()
  {
    qsq = 1000;
  }
  
  private static boolean chL()
  {
    AppMethodBeat.i(72712);
    if (qsq <= 0)
    {
      AppMethodBeat.o(72712);
      return false;
    }
    if (qsr == null)
    {
      AppMethodBeat.o(72712);
      return false;
    }
    try
    {
      int i = qsr.qsf.size();
      int j = qsr.qsg.size();
      int k = qsr.qse.size();
      int m = qsq;
      if (i + j + k >= m)
      {
        AppMethodBeat.o(72712);
        return true;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      AppMethodBeat.o(72712);
    }
    return false;
  }
  
  public static void chM()
  {
    AppMethodBeat.i(72713);
    if ((l.bR(ah.getContext())) || (!ah.dsZ()))
    {
      ab.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
      AppMethodBeat.o(72713);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
    localIntent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
    localIntent.putExtra("type", 2);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(72713);
  }
  
  public static void chN()
  {
    AppMethodBeat.i(72714);
    if (qsn == null)
    {
      AppMethodBeat.o(72714);
      return;
    }
    qsn.removeMessages(1);
    ak localak = qsn;
    localak.handleMessage(localak.obtainMessage(1));
    AppMethodBeat.o(72714);
  }
  
  private static String getClassName()
  {
    AppMethodBeat.i(72708);
    if (bo.isNullOrNil(className)) {
      className = ah.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
    }
    String str = className;
    AppMethodBeat.o(72708);
    return str;
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(72706);
    if (paramIntent == null)
    {
      ab.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(72706);
      return;
    }
    qsn.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(72704);
        ab.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, paramIntent);
        AppMethodBeat.o(72704);
      }
    });
    AppMethodBeat.o(72706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver
 * JD-Core Version:    0.7.0.1
 */