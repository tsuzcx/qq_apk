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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static ao wTG;
  private static int wTH;
  private static volatile long wTI;
  private static volatile int wTJ;
  private static BroadCastData wTK;
  
  static
  {
    AppMethodBeat.i(143830);
    ao local1 = new ao("kv_report")
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
    wTG = local1;
    local1.setLogging(false);
    className = "";
    wTH = 10000;
    wTI = 10000L;
    wTJ = -1;
    wTK = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    ac.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.dml), Long.valueOf(paramKVReportDataInfo.cZM), Boolean.valueOf(paramKVReportDataInfo.wTB), Boolean.valueOf(paramKVReportDataInfo.wTX) });
    synchronized (lock)
    {
      wTK.wTx.add(paramKVReportDataInfo);
      if ((wTI == 0L) || (dyM()))
      {
        wTG.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (wTG.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    wTG.sendEmptyMessageDelayed(1, wTI);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    ac.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.pnx), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.wTB) });
    synchronized (lock)
    {
      wTK.wTy.add(paramStIDKeyDataInfo);
      if ((wTI == 0L) || (dyM()))
      {
        wTG.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (wTG.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    wTG.sendEmptyMessageDelayed(1, wTI);
    AppMethodBeat.o(143824);
  }
  
  public static void aw(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    ac.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = wTK;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.wTz.add(paramArrayList);
      if ((wTI == 0L) || (dyM()))
      {
        wTG.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (wTG.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    wTG.sendEmptyMessageDelayed(1, wTI);
    AppMethodBeat.o(143825);
  }
  
  public static void dyK()
  {
    if (100L < 0L) {
      return;
    }
    wTI = 100L;
  }
  
  public static void dyL()
  {
    wTJ = 1000;
  }
  
  private static boolean dyM()
  {
    AppMethodBeat.i(143826);
    if (wTJ <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (wTK == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = wTK.wTy.size();
      int j = wTK.wTz.size();
      int k = wTK.wTx.size();
      int m = wTJ;
      if (i + j + k >= m)
      {
        AppMethodBeat.o(143826);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      AppMethodBeat.o(143826);
    }
    return false;
  }
  
  public static void dyN()
  {
    AppMethodBeat.i(143827);
    if (wTG == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    wTG.removeMessages(1);
    ao localao = wTG;
    localao.handleMessage(localao.obtainMessage(1));
    AppMethodBeat.o(143827);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(143822);
    if (paramIntent == null)
    {
      ac.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(143822);
      return;
    }
    wTG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143820);
        ac.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
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