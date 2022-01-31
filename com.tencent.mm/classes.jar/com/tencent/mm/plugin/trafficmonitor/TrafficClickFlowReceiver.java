package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrafficClickFlowReceiver
  extends BroadcastReceiver
{
  private static boolean fWI;
  private static TrafficClickFlowReceiver.c pJU = new TrafficClickFlowReceiver.c();
  private static String pJV;
  private static TrafficClickFlowReceiver.b pJW = new TrafficClickFlowReceiver.b();
  private static List<TrafficClickFlowReceiver.c> pJX = Collections.synchronizedList(new ArrayList());
  private static List<TrafficClickFlowReceiver.b> pJY = Collections.synchronizedList(new ArrayList());
  private static List<TrafficClickFlowReceiver.a> pJZ = Collections.synchronizedList(new ArrayList());
  private static int pKb = 0;
  private static b pKc;
  private static int pKd;
  private int pKa = 0;
  
  static
  {
    fWI = false;
    pKd = 0;
    pKc = new b();
    b.a(new TrafficClickFlowReceiver.1());
  }
  
  protected static long P(long paramLong1, long paramLong2)
  {
    long l1 = 0L;
    int i = 0;
    int j = 1;
    if (i < pJY.size())
    {
      TrafficClickFlowReceiver.b localb = (TrafficClickFlowReceiver.b)pJY.get(i);
      int k = j;
      l2 = l1;
      if (localb.endTime > paramLong1)
      {
        if (j == 0) {
          break label100;
        }
        l2 = l1 + localb.endTime - Math.max(localb.startTime, paramLong1);
      }
      for (k = 0;; k = j)
      {
        i += 1;
        j = k;
        l1 = l2;
        break;
        label100:
        l2 = l1 + localb.endTime - localb.startTime;
      }
    }
    long l2 = l1;
    if (pKd > 0) {
      l2 = l1 + (paramLong2 - Math.max(pJW.startTime, paramLong1));
    }
    return l2;
  }
  
  protected static int a(int paramInt, long paramLong, List<TrafficClickFlowReceiver.c> paramList)
  {
    int j = 1;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      try
      {
        TrafficClickFlowReceiver.c localc1;
        if (i < pJX.size())
        {
          localc1 = (TrafficClickFlowReceiver.c)pJX.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            TrafficClickFlowReceiver.c localc2 = new TrafficClickFlowReceiver.c();
            localc2.pKe = localc1.pKe;
            localc2.startTime = paramLong;
            localc2.endTime = localc1.endTime;
            paramList.add(localc2);
            paramInt = 0;
          }
          else
          {
            paramList.add(localc1);
          }
        }
        else
        {
          if (paramList.size() == 0)
          {
            localc1 = new TrafficClickFlowReceiver.c();
            localc1.pKe = pJV;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            return pJX.size();
          }
          localc1 = new TrafficClickFlowReceiver.c();
          localc1.pKe = pJV;
          localc1.startTime = pJU.startTime;
          localc1.endTime = System.currentTimeMillis();
          paramList.add(localc1);
          continue;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        return -1;
      }
    }
  }
  
  protected static void bOR()
  {
    if (pJX == null) {
      return;
    }
    pJX.clear();
  }
  
  protected static boolean gH(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1;
    if (pJY == null) {
      bool1 = true;
    }
    label92:
    do
    {
      return bool1;
      y.i("MicroMsg.TrafficClickFlow", "downLoadObjects : %s", new Object[] { pJY.toString() });
      int i = 0;
      for (;;)
      {
        if (i >= pJY.size()) {
          break label92;
        }
        TrafficClickFlowReceiver.b localb = (TrafficClickFlowReceiver.b)pJY.get(i);
        if (localb.endTime > paramLong)
        {
          bool1 = bool2;
          if (!gI(localb.startTime)) {
            break;
          }
        }
        i += 1;
      }
      if (pKd <= 0) {
        break;
      }
      bool1 = bool2;
    } while (!gI(pJW.startTime));
    return true;
  }
  
  private static boolean gI(long paramLong)
  {
    if (pJZ == null) {}
    for (;;)
    {
      return false;
      y.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { pJZ.toString() });
      int i = 0;
      while (i < pJZ.size())
      {
        if (Math.abs(paramLong - ((TrafficClickFlowReceiver.a)pJZ.get(i)).time) < 1500L) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS"))) {
      return;
    }
    Object localObject = paramIntent.getStringExtra("ui");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "null";
    }
    localObject = paramContext;
    if (paramContext.contains(".")) {
      localObject = paramContext.substring(paramContext.lastIndexOf(".") + 1);
    }
    int i = paramIntent.getIntExtra("opCode", 0);
    if (i == 10)
    {
      paramContext = new TrafficClickFlowReceiver.a();
      paramContext.pKe = ((String)localObject);
      paramContext.time = System.currentTimeMillis();
      pJZ.add(paramContext);
      return;
    }
    if (i == 1) {
      pJV = (String)localObject;
    }
    for (;;)
    {
      this.pKa = i;
      return;
      if (i == 3)
      {
        if (fWI)
        {
          paramContext = new TrafficClickFlowReceiver.c();
          paramContext.pKe = "Background";
          paramContext.startTime = pJU.startTime;
          paramContext.endTime = System.currentTimeMillis();
          pJX.add(paramContext);
          fWI = false;
        }
        pJV = (String)localObject;
        if (localObject != pJU.pKe)
        {
          pJU.pKe = ((String)localObject);
          pJU.startTime = System.currentTimeMillis();
        }
      }
      else if (i == 4)
      {
        pJU.endTime = System.currentTimeMillis();
        if (pJU.pKe != null) {
          pJX.add(pJU);
        }
        pJU = new TrafficClickFlowReceiver.c();
        boolean bool1 = bk.fT(ae.getContext());
        boolean bool2 = l.fr(ae.getContext());
        if ((!bool1) || (!bool2))
        {
          pJU.startTime = System.currentTimeMillis();
          pJV = "Background";
          fWI = true;
          y.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
      }
      else if ((i == 5) && (pJX.contains(localObject)))
      {
        pJV = "Background";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */