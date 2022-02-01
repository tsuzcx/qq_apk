package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ad;
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
  private static String BAA;
  private static Map<Long, b> BAB;
  private static List<c> BAC;
  private static List<b> BAD;
  private static List<a> BAE;
  private static int BAG;
  private static c BAH;
  private static c BAz;
  private static boolean khO;
  private int BAF = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    BAz = new c();
    BAB = Collections.synchronizedMap(new HashMap());
    BAC = Collections.synchronizedList(new ArrayList());
    BAD = Collections.synchronizedList(new ArrayList());
    BAE = Collections.synchronizedList(new ArrayList());
    BAG = 0;
    khO = false;
    BAH = new c();
    c.a(new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.N(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(213370);
        TrafficClickFlowReceiver.N(12, paramAnonymousLong1);
        AppMethodBeat.o(213370);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.N(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.N(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.N(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
      
      public final void sL(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.N(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void sM(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.N(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void sN(long paramAnonymousLong) {}
    });
    AppMethodBeat.o(123919);
  }
  
  protected static boolean Bd(long paramLong)
  {
    AppMethodBeat.i(123913);
    ad.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { BAD.toString() });
    int i = 0;
    while (i < BAD.size())
    {
      if (((b)BAD.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    ad.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { BAB.toString() });
    if (BAB.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean Be(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (BAD == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ad.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { BAD.toString() });
    int i = 0;
    Object localObject;
    while (i < BAD.size())
    {
      localObject = (b)BAD.get(i);
      if ((((b)localObject).endTime > paramLong) && (!Bf(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (BAB == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ad.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { BAB.toString() });
    if (BAB.size() > 0)
    {
      localObject = BAB.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!Bf(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean Bf(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (BAE == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    ad.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { BAE.toString() });
    int i = 0;
    while (i < BAE.size())
    {
      if (Math.abs(paramLong - ((a)BAE.get(i)).time) < 10000L)
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
        if (i < BAC.size())
        {
          localc1 = (c)BAC.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.BAJ = localc1.BAJ;
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
            localc1.BAJ = BAA;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = BAC.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.BAJ = BAA;
          localc1.startTime = BAz.startTime;
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
  
  protected static void eri()
  {
    AppMethodBeat.i(123917);
    if (BAC == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    BAC.clear();
    AppMethodBeat.o(123917);
  }
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    AppMethodBeat.i(123912);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")))
    {
      AppMethodBeat.o(123912);
      return;
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213371);
        Object localObject2 = paramIntent.getStringExtra("ui");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        localObject2 = localObject1;
        if (((String)localObject1).contains(".")) {
          localObject2 = ((String)localObject1).substring(((String)localObject1).lastIndexOf(".") + 1);
        }
        int i = paramIntent.getIntExtra("opCode", 0);
        if (i == 10)
        {
          localObject1 = new TrafficClickFlowReceiver.a();
          ((TrafficClickFlowReceiver.a)localObject1).BAJ = ((String)localObject2);
          ((TrafficClickFlowReceiver.a)localObject1).time = System.currentTimeMillis();
          TrafficClickFlowReceiver.baY().add(localObject1);
          ad.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject2 });
          AppMethodBeat.o(213371);
          return;
        }
        TrafficClickFlowReceiver.fj((String)localObject2, i);
        TrafficClickFlowReceiver.a(TrafficClickFlowReceiver.this, i);
        AppMethodBeat.o(213371);
      }
    });
    AppMethodBeat.o(123912);
  }
  
  static final class a
  {
    public String BAJ;
    public long time;
    
    public final String toString()
    {
      AppMethodBeat.i(123909);
      String str = "ClickObject{ui='" + this.BAJ + '\'' + ", time=" + this.time + '}';
      AppMethodBeat.o(123909);
      return str;
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
    public String BAJ;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.BAJ + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */