package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static aq yxh;
  private static int yxi;
  private static volatile long yxj;
  private static volatile int yxk;
  private static BroadCastData yxl;
  
  static
  {
    AppMethodBeat.i(143830);
    aq local1 = new aq("kv_report")
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
    yxh = local1;
    local1.setLogging(false);
    className = "";
    yxi = 10000;
    yxj = 10000L;
    yxk = -1;
    yxl = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    ae.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.dze), Long.valueOf(paramKVReportDataInfo.dmg), Boolean.valueOf(paramKVReportDataInfo.yxc), Boolean.valueOf(paramKVReportDataInfo.yxu) });
    synchronized (lock)
    {
      yxl.ywY.add(paramKVReportDataInfo);
      if ((yxj == 0L) || (dNC()))
      {
        yxh.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (yxh.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    yxh.sendEmptyMessageDelayed(1, yxj);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    ae.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.pXC), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.yxc) });
    synchronized (lock)
    {
      yxl.ywZ.add(paramStIDKeyDataInfo);
      if ((yxj == 0L) || (dNC()))
      {
        yxh.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (yxh.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    yxh.sendEmptyMessageDelayed(1, yxj);
    AppMethodBeat.o(143824);
  }
  
  public static void av(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    ae.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = yxl;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.yxa.add(paramArrayList);
      if ((yxj == 0L) || (dNC()))
      {
        yxh.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (yxh.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    yxh.sendEmptyMessageDelayed(1, yxj);
    AppMethodBeat.o(143825);
  }
  
  public static void dNA()
  {
    if (100L < 0L) {
      return;
    }
    yxj = 100L;
  }
  
  public static void dNB()
  {
    yxk = 1000;
  }
  
  private static boolean dNC()
  {
    AppMethodBeat.i(143826);
    if (yxk <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (yxl == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = yxl.ywZ.size();
      int j = yxl.yxa.size();
      int k = yxl.ywY.size();
      int m = yxk;
      if (i + j + k >= m)
      {
        AppMethodBeat.o(143826);
        return true;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
      AppMethodBeat.o(143826);
    }
    return false;
  }
  
  public static void dND()
  {
    AppMethodBeat.i(143827);
    if (yxh == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    yxh.removeMessages(1);
    aq localaq = yxh;
    localaq.handleMessage(localaq.obtainMessage(1));
    AppMethodBeat.o(143827);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(143822);
    if (paramIntent == null)
    {
      ae.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      AppMethodBeat.o(143822);
      return;
    }
    yxh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143820);
        ae.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
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