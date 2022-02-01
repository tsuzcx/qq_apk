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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static MMHandler Cye;
  private static int Cyf;
  private static volatile long Cyg;
  private static volatile int Cyh;
  private static BroadCastData Cyi;
  private static String className;
  private static Object lock;
  
  static
  {
    AppMethodBeat.i(143830);
    MMHandler local1 = new MMHandler("kv_report")
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
    Cye = local1;
    local1.setLogging(false);
    className = "";
    Cyf = 10000;
    Cyg = 10000L;
    Cyh = -1;
    Cyi = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.dQR), Long.valueOf(paramKVReportDataInfo.dDw), Boolean.valueOf(paramKVReportDataInfo.CxY), Boolean.valueOf(paramKVReportDataInfo.Cyr) });
    synchronized (lock)
    {
      Cyi.CxU.add(paramKVReportDataInfo);
      if ((Cyg == 0L) || (eOC()))
      {
        Cye.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (Cye.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    Cye.sendEmptyMessageDelayed(1, Cyg);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.oIi), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.CxY) });
    if (c.Wj((int)paramStIDKeyDataInfo.oIi))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramStIDKeyDataInfo.oIi + "," + paramStIDKeyDataInfo.key + ")")) });
      paramStIDKeyDataInfo.oIi = 1566L;
      paramStIDKeyDataInfo.key = 1L;
      paramStIDKeyDataInfo.value = 1L;
    }
    synchronized (lock)
    {
      Cyi.CxV.add(paramStIDKeyDataInfo);
      if ((Cyg == 0L) || (eOC()))
      {
        Cye.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (Cye.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    Cye.sendEmptyMessageDelayed(1, Cyg);
    AppMethodBeat.o(143824);
  }
  
  public static void aM(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (c.Wj((int)((IDKey)paramArrayList.get(i)).GetID()))
      {
        Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code. IDKey:(" + ((IDKey)paramArrayList.get(i)).GetID() + "," + ((IDKey)paramArrayList.get(i)).GetKey() + ")")) });
        ((IDKey)paramArrayList.get(i)).SetID(1566);
        ((IDKey)paramArrayList.get(i)).SetKey(1);
        ((IDKey)paramArrayList.get(i)).SetValue(1L);
      }
      i += 1;
    }
    synchronized (lock)
    {
      BroadCastData localBroadCastData = Cyi;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.CxW.add(paramArrayList);
      if ((Cyg == 0L) || (eOC()))
      {
        Cye.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (Cye.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    Cye.sendEmptyMessageDelayed(1, Cyg);
    AppMethodBeat.o(143825);
  }
  
  public static void eOA()
  {
    if (100L < 0L) {
      return;
    }
    Cyg = 100L;
  }
  
  public static void eOB()
  {
    Cyh = 1000;
  }
  
  private static boolean eOC()
  {
    AppMethodBeat.i(143826);
    if (Cyh <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (Cyi == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = Cyi.CxV.size();
      int j = Cyi.CxW.size();
      int k = Cyi.CxU.size();
      int m = Cyh;
      if (i + j + k >= m)
      {
        AppMethodBeat.o(143826);
        return true;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      AppMethodBeat.o(143826);
    }
    return false;
  }
  
  public static void eOD()
  {
    AppMethodBeat.i(143827);
    if (Cye == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    Cye.removeMessages(1);
    MMHandler localMMHandler = Cye;
    localMMHandler.handleMessage(localMMHandler.obtainMessage(1));
    AppMethodBeat.o(143827);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(143822);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(143822);
      return;
    }
    Cye.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143820);
        Log.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
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