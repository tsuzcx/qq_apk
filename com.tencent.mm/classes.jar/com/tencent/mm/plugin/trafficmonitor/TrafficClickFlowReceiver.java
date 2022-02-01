package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TrafficClickFlowReceiver
  extends BroadcastReceiver
{
  private static boolean jnr;
  private static c yUZ;
  private static String yVa;
  private static Map<Long, b> yVb;
  private static List<c> yVc;
  private static List<b> yVd;
  private static List<TrafficClickFlowReceiver.a> yVe;
  private static int yVg;
  private static c yVh;
  private int yVf = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    yUZ = new c();
    yVb = Collections.synchronizedMap(new HashMap());
    yVc = Collections.synchronizedList(new ArrayList());
    yVd = Collections.synchronizedList(new ArrayList());
    yVe = Collections.synchronizedList(new ArrayList());
    yVg = 0;
    jnr = false;
    yVh = new c();
    c.a(new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.M(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
      
      public final void mZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(123907);
        TrafficClickFlowReceiver.M(12, paramAnonymousLong);
        AppMethodBeat.o(123907);
      }
      
      public final void na(long paramAnonymousLong) {}
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.M(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
    });
    AppMethodBeat.o(123919);
  }
  
  protected static int a(int paramInt, long paramLong, List<c> paramList)
  {
    AppMethodBeat.i(123916);
    int j = 1;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      try
      {
        c localc1;
        if (i < yVc.size())
        {
          localc1 = (c)yVc.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.yVi = localc1.yVi;
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
            localc1 = new c();
            localc1.yVi = yVa;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = yVc.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.yVi = yVa;
          localc1.startTime = yUZ.startTime;
          localc1.endTime = System.currentTimeMillis();
          paramList.add(localc1);
          continue;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        AppMethodBeat.o(123916);
        return -1;
      }
    }
  }
  
  protected static void dQs()
  {
    AppMethodBeat.i(123917);
    if (yVc == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    yVc.clear();
    AppMethodBeat.o(123917);
  }
  
  protected static boolean uc(long paramLong)
  {
    AppMethodBeat.i(123913);
    ad.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { yVd.toString() });
    int i = 0;
    while (i < yVd.size())
    {
      if (((b)yVd.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    ad.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { yVb.toString() });
    if (yVb.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean ud(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (yVd == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ad.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { yVd.toString() });
    int i = 0;
    Object localObject;
    while (i < yVd.size())
    {
      localObject = (b)yVd.get(i);
      if ((((b)localObject).endTime > paramLong) && (!ue(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (yVb == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ad.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { yVb.toString() });
    if (yVb.size() > 0)
    {
      localObject = yVb.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!ue(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean ue(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (yVe == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    ad.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { yVe.toString() });
    int i = 0;
    while (i < yVe.size())
    {
      if (Math.abs(paramLong - ((TrafficClickFlowReceiver.a)yVe.get(i)).time) < 10000L)
      {
        AppMethodBeat.o(123915);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(123915);
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(123912);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")))
    {
      AppMethodBeat.o(123912);
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
      paramContext.yVi = ((String)localObject);
      paramContext.time = System.currentTimeMillis();
      yVe.add(paramContext);
      ad.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject });
      AppMethodBeat.o(123912);
      return;
    }
    if (i == 1) {
      yVa = (String)localObject;
    }
    for (;;)
    {
      this.yVf = i;
      AppMethodBeat.o(123912);
      return;
      if (i == 3)
      {
        if (jnr)
        {
          paramContext = new c();
          paramContext.yVi = "Background";
          paramContext.startTime = yUZ.startTime;
          paramContext.endTime = System.currentTimeMillis();
          yVc.add(paramContext);
          jnr = false;
        }
        yVa = (String)localObject;
        if (localObject != yUZ.yVi)
        {
          yUZ.yVi = ((String)localObject);
          yUZ.startTime = System.currentTimeMillis();
        }
      }
      else if (i == 4)
      {
        yUZ.endTime = System.currentTimeMillis();
        if (yUZ.yVi != null) {
          yVc.add(yUZ);
        }
        yUZ = new c();
        boolean bool1 = bt.iN(aj.getContext());
        boolean bool2 = q.ig(aj.getContext());
        if ((!bool1) || (!bool2))
        {
          yUZ.startTime = System.currentTimeMillis();
          yVa = "Background";
          jnr = true;
          ad.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
      }
      else if ((i == 5) && (yVc.contains(localObject)))
      {
        yVa = "Background";
      }
    }
  }
  
  static final class b
  {
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123910);
      String str = "DownLoadObject{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123910);
      return str;
    }
  }
  
  static final class c
  {
    public long endTime;
    public long startTime;
    public String yVi;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.yVi + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */