package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;
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
  private static c GsD;
  private static String GsE;
  private static Map<Long, TrafficClickFlowReceiver.b> GsF;
  private static List<c> GsG;
  private static List<TrafficClickFlowReceiver.b> GsH;
  private static List<TrafficClickFlowReceiver.a> GsI;
  private static int GsK;
  private static c GsL;
  private static boolean loP;
  private int GsJ = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    GsD = new c();
    GsF = Collections.synchronizedMap(new HashMap());
    GsG = Collections.synchronizedList(new ArrayList());
    GsH = Collections.synchronizedList(new ArrayList());
    GsI = Collections.synchronizedList(new ArrayList());
    GsK = 0;
    loP = false;
    GsL = new c();
    c.a(new m()
    {
      public final void Bd(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void Be(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void Bf(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(194288);
        TrafficClickFlowReceiver.P(12, paramAnonymousLong1);
        AppMethodBeat.o(194288);
      }
      
      public final void b(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.P(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void l(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.P(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
    });
    AppMethodBeat.o(123919);
  }
  
  protected static boolean KI(long paramLong)
  {
    AppMethodBeat.i(123913);
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { GsH.toString() });
    int i = 0;
    while (i < GsH.size())
    {
      if (((TrafficClickFlowReceiver.b)GsH.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { GsF.toString() });
    if (GsF.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean KJ(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (GsH == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { GsH.toString() });
    int i = 0;
    Object localObject;
    while (i < GsH.size())
    {
      localObject = (TrafficClickFlowReceiver.b)GsH.get(i);
      if ((((TrafficClickFlowReceiver.b)localObject).endTime > paramLong) && (!KK(((TrafficClickFlowReceiver.b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (GsF == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { GsF.toString() });
    if (GsF.size() > 0)
    {
      localObject = GsF.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!KK(((TrafficClickFlowReceiver.b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean KK(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (GsI == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    Log.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { GsI.toString() });
    int i = 0;
    while (i < GsI.size())
    {
      if (Math.abs(paramLong - ((TrafficClickFlowReceiver.a)GsI.get(i)).time) < 10000L)
      {
        AppMethodBeat.o(123915);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(123915);
    return false;
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
        if (i < GsG.size())
        {
          localc1 = (c)GsG.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.GsN = localc1.GsN;
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
            localc1.GsN = GsE;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = GsG.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.GsN = GsE;
          localc1.startTime = GsD.startTime;
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
  
  protected static void fAi()
  {
    AppMethodBeat.i(123917);
    if (GsG == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    GsG.clear();
    AppMethodBeat.o(123917);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(123912);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")))
    {
      AppMethodBeat.o(123912);
      return;
    }
    h.RTc.aX(new TrafficClickFlowReceiver.2(this, paramIntent));
    AppMethodBeat.o(123912);
  }
  
  static final class c
  {
    public String GsN;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.GsN + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */