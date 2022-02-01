package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static MMHandler Izd;
  private static int Ize;
  private static volatile long Izf;
  private static volatile int Izg;
  private static BroadCastData Izh;
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
    Izd = local1;
    local1.setLogging(false);
    className = "";
    Ize = 10000;
    Izf = 10000L;
    Izg = -1;
    Izh = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.fKh), Long.valueOf(paramKVReportDataInfo.fwf), Boolean.valueOf(paramKVReportDataInfo.IyX), Boolean.valueOf(paramKVReportDataInfo.Izq) });
    synchronized (lock)
    {
      Izh.IyT.add(paramKVReportDataInfo);
      if ((Izf == 0L) || (fBx()))
      {
        Izd.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (Izd.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    Izd.sendEmptyMessageDelayed(1, Izf);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.rJY), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.IyX) });
    if (c.acY((int)paramStIDKeyDataInfo.rJY))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramStIDKeyDataInfo.rJY + "," + paramStIDKeyDataInfo.key + ")")) });
      paramStIDKeyDataInfo.rJY = 1566L;
      paramStIDKeyDataInfo.key = 1L;
      paramStIDKeyDataInfo.value = 1L;
    }
    synchronized (lock)
    {
      Izh.IyU.add(paramStIDKeyDataInfo);
      if ((Izf == 0L) || (fBx()))
      {
        Izd.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (Izd.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    Izd.sendEmptyMessageDelayed(1, Izf);
    AppMethodBeat.o(143824);
  }
  
  public static void aU(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (c.acY((int)((IDKey)paramArrayList.get(i)).GetID()))
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
      BroadCastData localBroadCastData = Izh;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.IyV.add(paramArrayList);
      if ((Izf == 0L) || (fBx()))
      {
        Izd.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (Izd.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    Izd.sendEmptyMessageDelayed(1, Izf);
    AppMethodBeat.o(143825);
  }
  
  public static void fBv()
  {
    if (100L < 0L) {
      return;
    }
    Izf = 100L;
  }
  
  public static void fBw()
  {
    Izg = 1000;
  }
  
  private static boolean fBx()
  {
    AppMethodBeat.i(143826);
    if (Izg <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (Izh == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = Izh.IyU.size();
      int j = Izh.IyV.size();
      int k = Izh.IyT.size();
      int m = Izg;
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
  
  public static void fBy()
  {
    AppMethodBeat.i(143827);
    if (Izd == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    Izd.removeMessages(1);
    MMHandler localMMHandler = Izd;
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
    Izd.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver
 * JD-Core Version:    0.7.0.1
 */