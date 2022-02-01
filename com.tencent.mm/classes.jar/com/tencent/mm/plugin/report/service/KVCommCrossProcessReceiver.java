package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static ap vJC;
  private static int vJD;
  private static volatile long vJE;
  private static volatile int vJF;
  private static BroadCastData vJG;
  
  static
  {
    AppMethodBeat.i(143830);
    ap local1 = new ap("kv_report")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(143819);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1) {
          KVCommCrossProcessReceiver.access$000();
        }
        AppMethodBeat.o(143819);
      }
    };
    vJC = local1;
    local1.setLogging(false);
    className = "";
    vJD = 10000;
    vJE = 10000L;
    vJF = -1;
    vJG = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.doC), Long.valueOf(paramKVReportDataInfo.dcn), Boolean.valueOf(paramKVReportDataInfo.vJx), Boolean.valueOf(paramKVReportDataInfo.vJT) });
    synchronized (lock)
    {
      vJG.vJt.add(paramKVReportDataInfo);
      if ((vJE == 0L) || (dkJ()))
      {
        vJC.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (vJC.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    vJC.sendEmptyMessageDelayed(1, vJE);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.oJZ), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.vJx) });
    synchronized (lock)
    {
      vJG.vJu.add(paramStIDKeyDataInfo);
      if ((vJE == 0L) || (dkJ()))
      {
        vJC.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (vJC.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    vJC.sendEmptyMessageDelayed(1, vJE);
    AppMethodBeat.o(143824);
  }
  
  public static void ak(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = vJG;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.vJv.add(paramArrayList);
      if ((vJE == 0L) || (dkJ()))
      {
        vJC.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (vJC.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    vJC.sendEmptyMessageDelayed(1, vJE);
    AppMethodBeat.o(143825);
  }
  
  public static void dkH()
  {
    if (100L < 0L) {
      return;
    }
    vJE = 100L;
  }
  
  public static void dkI()
  {
    vJF = 1000;
  }
  
  private static boolean dkJ()
  {
    AppMethodBeat.i(143826);
    if (vJF <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (vJG == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = vJG.vJu.size();
      int j = vJG.vJv.size();
      int k = vJG.vJt.size();
      int m = vJF;
      if (i + j + k >= m)
      {
        AppMethodBeat.o(143826);
        return true;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      AppMethodBeat.o(143826);
    }
    return false;
  }
  
  public static void dkK()
  {
    AppMethodBeat.i(143827);
    if (vJC == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    vJC.removeMessages(1);
    ap localap = vJC;
    localap.handleMessage(localap.obtainMessage(1));
    AppMethodBeat.o(143827);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(143822);
    if (paramIntent == null)
    {
      ad.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(143822);
      return;
    }
    vJC.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143820);
        ad.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, paramIntent);
        AppMethodBeat.o(143820);
      }
    });
    AppMethodBeat.o(143822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver
 * JD-Core Version:    0.7.0.1
 */