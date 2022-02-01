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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock;
  private static ap yhq;
  private static int yhr;
  private static volatile long yhs;
  private static volatile int yht;
  private static BroadCastData yhu;
  
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
    yhq = local1;
    local1.setLogging(false);
    className = "";
    yhr = 10000;
    yhs = 10000L;
    yht = -1;
    yhu = new BroadCastData();
    lock = new Object();
    AppMethodBeat.o(143830);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    AppMethodBeat.i(143823);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b, ignoreFreqLimit", new Object[] { Long.valueOf(paramKVReportDataInfo.dxZ), Long.valueOf(paramKVReportDataInfo.dle), Boolean.valueOf(paramKVReportDataInfo.yhl), Boolean.valueOf(paramKVReportDataInfo.yhD) });
    synchronized (lock)
    {
      yhu.yhh.add(paramKVReportDataInfo);
      if ((yhs == 0L) || (dKk()))
      {
        yhq.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143823);
        return;
      }
    }
    if (yhq.hasMessages(1))
    {
      AppMethodBeat.o(143823);
      return;
    }
    yhq.sendEmptyMessageDelayed(1, yhs);
    AppMethodBeat.o(143823);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    AppMethodBeat.i(143824);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.pQX), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.yhl) });
    synchronized (lock)
    {
      yhu.yhi.add(paramStIDKeyDataInfo);
      if ((yhs == 0L) || (dKk()))
      {
        yhq.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143824);
        return;
      }
    }
    if (yhq.hasMessages(1))
    {
      AppMethodBeat.o(143824);
      return;
    }
    yhq.sendEmptyMessageDelayed(1, yhs);
    AppMethodBeat.o(143824);
  }
  
  public static void au(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(143825);
    ad.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.FALSE });
    synchronized (lock)
    {
      BroadCastData localBroadCastData = yhu;
      paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
      localBroadCastData.yhj.add(paramArrayList);
      if ((yhs == 0L) || (dKk()))
      {
        yhq.obtainMessage(1).sendToTarget();
        AppMethodBeat.o(143825);
        return;
      }
    }
    if (yhq.hasMessages(1))
    {
      AppMethodBeat.o(143825);
      return;
    }
    yhq.sendEmptyMessageDelayed(1, yhs);
    AppMethodBeat.o(143825);
  }
  
  public static void dKi()
  {
    if (100L < 0L) {
      return;
    }
    yhs = 100L;
  }
  
  public static void dKj()
  {
    yht = 1000;
  }
  
  private static boolean dKk()
  {
    AppMethodBeat.i(143826);
    if (yht <= 0)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    if (yhu == null)
    {
      AppMethodBeat.o(143826);
      return false;
    }
    try
    {
      int i = yhu.yhi.size();
      int j = yhu.yhj.size();
      int k = yhu.yhh.size();
      int m = yht;
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
  
  public static void dKl()
  {
    AppMethodBeat.i(143827);
    if (yhq == null)
    {
      AppMethodBeat.o(143827);
      return;
    }
    yhq.removeMessages(1);
    ap localap = yhq;
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
    yhq.post(new Runnable()
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