package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
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
  private static c TRZ;
  private static String TSa;
  private static Map<Long, b> TSb;
  private static List<c> TSc;
  private static List<b> TSd;
  private static List<a> TSe;
  private static int TSg;
  private static c TSh;
  private static boolean rnb;
  private int TSf = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    TRZ = new c();
    TSb = Collections.synchronizedMap(new HashMap());
    TSc = Collections.synchronizedList(new ArrayList());
    TSd = Collections.synchronizedList(new ArrayList());
    TSe = Collections.synchronizedList(new ArrayList());
    TSg = 0;
    rnb = false;
    TSh = new c();
    c.a(new m()
    {
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(260726);
        TrafficClickFlowReceiver.T(12, paramAnonymousLong1);
        AppMethodBeat.o(260726);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.T(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void c(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.T(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void jF(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.T(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void jG(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.T(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void jH(long paramAnonymousLong) {}
      
      public final void v(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.T(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void w(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.T(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
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
        if (i < TSc.size())
        {
          localc1 = (c)TSc.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.TSi = localc1.TSi;
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
            localc1.TSi = TSa;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = TSc.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.TSi = TSa;
          localc1.startTime = TRZ.startTime;
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
  
  protected static void hPn()
  {
    AppMethodBeat.i(123917);
    if (TSc == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    TSc.clear();
    AppMethodBeat.o(123917);
  }
  
  protected static boolean ws(long paramLong)
  {
    AppMethodBeat.i(123913);
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { TSd.toString() });
    int i = 0;
    while (i < TSd.size())
    {
      if (((b)TSd.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { TSb.toString() });
    if (TSb.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean wt(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (TSd == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { TSd.toString() });
    int i = 0;
    Object localObject;
    while (i < TSd.size())
    {
      localObject = (b)TSd.get(i);
      if ((((b)localObject).endTime > paramLong) && (!wu(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (TSb == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { TSb.toString() });
    if (TSb.size() > 0)
    {
      localObject = TSb.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!wu(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean wu(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (TSe == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    Log.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { TSe.toString() });
    int i = 0;
    while (i < TSe.size())
    {
      if (Math.abs(paramLong - ((a)TSe.get(i)).time) < 10000L)
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
    h.ahAA.bm(new TrafficClickFlowReceiver..ExternalSyntheticLambda0(this, paramIntent));
    AppMethodBeat.o(123912);
  }
  
  static final class a
  {
    public String TSi;
    public long time;
    
    public final String toString()
    {
      AppMethodBeat.i(123909);
      String str = "ClickObject{ui='" + this.TSi + '\'' + ", time=" + this.time + '}';
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
    public String TSi;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.TSi + '\'' + ", duration=" + (this.endTime - this.startTime) + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */