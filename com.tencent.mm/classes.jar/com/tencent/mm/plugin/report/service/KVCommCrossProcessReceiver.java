package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver
  extends BroadcastReceiver
{
  private static String className;
  private static Object lock = new Object();
  private static ah nFl;
  private static int nFm;
  private static volatile long nFn;
  private static volatile int nFo;
  private static BroadCastData nFp;
  
  static
  {
    HandlerThread localHandlerThread = e.aap("kv_report");
    localHandlerThread.start();
    nFl = new ah(localHandlerThread.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 1) {
          KVCommCrossProcessReceiver.access$000();
        }
      }
    };
    className = "";
    nFm = 10000;
    nFn = 10000L;
    nFo = -1;
    nFp = new BroadCastData();
  }
  
  public static void M(ArrayList<IDKey> paramArrayList)
  {
    y.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(false) });
    do
    {
      synchronized (lock)
      {
        BroadCastData localBroadCastData = nFp;
        paramArrayList = new GroupIDKeyDataInfo(paramArrayList);
        localBroadCastData.nFe.add(paramArrayList);
        if ((nFn == 0L) || (bwS()))
        {
          bwR();
          return;
        }
      }
    } while (nFl.hasMessages(1));
    nFl.sendEmptyMessageDelayed(1, nFn);
  }
  
  public static void a(KVReportDataInfo paramKVReportDataInfo)
  {
    y.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, type:%d, isImportant: %b,isReportNow: %b", new Object[] { Long.valueOf(paramKVReportDataInfo.nFC), Long.valueOf(paramKVReportDataInfo.bGn), Boolean.valueOf(paramKVReportDataInfo.nFg), Boolean.valueOf(paramKVReportDataInfo.nFD) });
    do
    {
      synchronized (lock)
      {
        nFp.nFc.add(paramKVReportDataInfo);
        if (nFn == 0L)
        {
          bwR();
          return;
        }
      }
    } while (nFl.hasMessages(1));
    nFl.sendEmptyMessageDelayed(1, nFn);
  }
  
  public static void a(StIDKeyDataInfo paramStIDKeyDataInfo)
  {
    y.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", new Object[] { Long.valueOf(paramStIDKeyDataInfo.nGh), Long.valueOf(paramStIDKeyDataInfo.key), Long.valueOf(paramStIDKeyDataInfo.value), Boolean.valueOf(paramStIDKeyDataInfo.nFg) });
    do
    {
      synchronized (lock)
      {
        nFp.nFd.add(paramStIDKeyDataInfo);
        if ((nFn == 0L) || (bwS()))
        {
          bwR();
          return;
        }
      }
    } while (nFl.hasMessages(1));
    nFl.sendEmptyMessageDelayed(1, nFn);
  }
  
  public static void bwP()
  {
    if (100L < 0L) {
      return;
    }
    nFn = 100L;
  }
  
  public static void bwQ()
  {
    nFo = 1000;
  }
  
  private static void bwR()
  {
    Object localObject5;
    Object localObject6;
    synchronized (lock)
    {
      Object localObject2 = new BroadCastData(nFp);
      localObject5 = nFp;
      ((BroadCastData)localObject5).nFc.clear();
      ((BroadCastData)localObject5).nFd.clear();
      ((BroadCastData)localObject5).nFe.clear();
      localObject6 = ((BroadCastData)localObject2).nFe;
      localObject5 = ((BroadCastData)localObject2).nFd;
      ??? = ((BroadCastData)localObject2).nFc;
      if ((!l.bn(ae.getContext())) && (ae.cra())) {
        break label226;
      }
      y.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
      localObject2 = ((ArrayList)localObject6).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject6 = (GroupIDKeyDataInfo)((Iterator)localObject2).next();
        f.d(((GroupIDKeyDataInfo)localObject6).nFf, ((GroupIDKeyDataInfo)localObject6).nFg);
      }
    }
    Object localObject4 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (StIDKeyDataInfo)((Iterator)localObject4).next();
      f.c((int)((StIDKeyDataInfo)localObject5).nGh, (int)((StIDKeyDataInfo)localObject5).key, (int)((StIDKeyDataInfo)localObject5).value, ((StIDKeyDataInfo)localObject5).nFg);
    }
    ??? = ((ArrayList)???).iterator();
    label226:
    Intent localIntent;
    while (((Iterator)???).hasNext())
    {
      localObject4 = (KVReportDataInfo)((Iterator)???).next();
      f.a((int)((KVReportDataInfo)localObject4).nFC, (int)((KVReportDataInfo)localObject4).bGn, ((KVReportDataInfo)localObject4).value, ((KVReportDataInfo)localObject4).nFD, ((KVReportDataInfo)localObject4).nFg);
      continue;
      localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
      localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
      localIntent.putExtra("type", 1);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("BUNDLE_IDKEYGROUP", (Parcelable)localObject4);
      localIntent.putExtra("INTENT_IDKEYGROUP", localBundle);
      y.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", new Object[] { Integer.valueOf(((ArrayList)???).size()), Integer.valueOf(((ArrayList)localObject5).size()), Integer.valueOf(((ArrayList)localObject6).size()) });
    }
    try
    {
      ae.getContext().sendBroadcast(localIntent);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.ReportManagerKvCheck", localException, "sendBroadcastMessageDirectly", new Object[0]);
    }
  }
  
  private static boolean bwS()
  {
    if (nFo <= 0) {}
    for (;;)
    {
      return false;
      if (nFp != null) {
        try
        {
          int i = nFp.nFd.size();
          int j = nFp.nFe.size();
          int k = nFp.nFc.size();
          int m = nFo;
          if (i + j + k >= m) {
            return true;
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", new Object[] { localException });
        }
      }
    }
    return false;
  }
  
  public static void bwT()
  {
    if ((l.bn(ae.getContext())) || (!ae.cra()))
    {
      y.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
    localIntent.setComponent(new ComponentName(ae.getPackageName(), getClassName()));
    localIntent.putExtra("type", 2);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public static void bwU()
  {
    if (nFl == null) {
      return;
    }
    nFl.removeMessages(1);
    nFl.handleMessage(nFl.obtainMessage(1));
  }
  
  private static String getClassName()
  {
    if (bk.bl(className)) {
      className = ae.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
    }
    return className;
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    if (paramIntent == null)
    {
      y.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
      return;
    }
    nFl.post(new Runnable()
    {
      public final void run()
      {
        y.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        KVCommCrossProcessReceiver.a(KVCommCrossProcessReceiver.this, paramIntent);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver
 * JD-Core Version:    0.7.0.1
 */