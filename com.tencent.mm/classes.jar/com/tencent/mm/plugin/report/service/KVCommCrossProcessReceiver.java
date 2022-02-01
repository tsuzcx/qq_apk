package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static MMHandler OzK;
  private static int OzL;
  private static volatile long OzM;
  private static volatile int OzN;
  private static BroadCastData OzO;
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
    OzK = local1;
    local1.setLogging(false);
    className = "";
    OzL = 10000;
    OzM = 10000L;
    OzN = -1;
    OzO = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.hPN), Long.valueOf(paramKVReportDataInfo.beV), Boolean.valueOf(paramKVReportDataInfo.OzE), Boolean.valueOf(paramKVReportDataInfo.OzZ) });
    synchronized (lock)
    {
      OzO.OzA.add(paramKVReportDataInfo);
      if ((OzM == 0L) || (gNQ()))
      {
        OzK.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (OzK.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    OzK.sendEmptyMessageDelayed(1, OzM);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.ID), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.OzE) });
    if (c.aht((int)paramStIDKeyDataInfo.ID))
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "exception:%s", new Object[] { Util.stackTraceToString(new Exception("The IDKey has not applied yet, check your code, IDKey:(" + paramStIDKeyDataInfo.ID + "," + paramStIDKeyDataInfo.key + ")")) });
      paramStIDKeyDataInfo.ID = 1566L;
      paramStIDKeyDataInfo.key = 1L;
      paramStIDKeyDataInfo.value = 1L;
    }
    synchronized (lock)
    {
      OzO.OzB.add(paramStIDKeyDataInfo);
      if ((OzM == 0L) || (gNQ()))
      {
        OzK.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (OzK.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    OzK.sendEmptyMessageDelayed(1, OzM);
    AppMethodBeat.o(143824);
  }
  
  public static void ahu(int paramInt)
  {
    OzN = paramInt;
  }
  
  public static void bo(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    Log.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (c.aht((int)((IDKey)paramArrayList.get(i)).GetID()))
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
      BroadCastData localBroadCastData = OzO;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.OzC.add(paramArrayList);
      if ((OzM == 0L) || (gNQ()))
      {
        OzK.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (OzK.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    OzK.sendEmptyMessageDelayed(1, OzM);
    AppMethodBeat.o(143825);
  }
  
  public static void gNO()
  {
    if (100L < 0L) {
      return;
    }
    OzM = 100L;
  }
  
  public static int gNP()
  {
    return OzN;
  }
  
  private static boolean gNQ()
  {
    AppMethodBeat.i(143826);
    if (OzN <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (OzO == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = OzO.OzB.size();
      int j = OzO.OzC.size();
      int k = OzO.OzA.size();
      int m = OzN;
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
  
  public static void gNR()
  {
    AppMethodBeat.i(143827);
    if (OzK == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    OzK.removeMessages(1);
    MMHandler localMMHandler = OzK;
    localMMHandler.handleMessage(localMMHandler.obtainMessage(1));
    AppMethodBeat.o(143827);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(143822);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(143822);
      return;
    }
    OzK.post(new KVCommCrossProcessReceiver.2(this, paramIntent));
    AppMethodBeat.o(143822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver
 * JD-Core Version:    0.7.0.1
 */