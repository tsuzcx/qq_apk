package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
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
  private static c Nfp;
  private static String Nfq;
  private static Map<Long, b> Nfr;
  private static List<c> Nfs;
  private static List<b> Nft;
  private static List<a> Nfu;
  private static int Nfw;
  private static c Nfx;
  private static boolean ojz;
  private int Nfv = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    Nfp = new c();
    Nfr = Collections.synchronizedMap(new HashMap());
    Nfs = Collections.synchronizedList(new ArrayList());
    Nft = Collections.synchronizedList(new ArrayList());
    Nfu = Collections.synchronizedList(new ArrayList());
    Nfw = 0;
    ojz = false;
    Nfx = new c();
    c.a(new m()
    {
      public final void Hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void Hq(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.P(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void Hr(long paramAnonymousLong) {}
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(243998);
        TrafficClickFlowReceiver.P(12, paramAnonymousLong1);
        AppMethodBeat.o(243998);
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
      
      public final void m(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.P(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void n(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.P(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
    });
    AppMethodBeat.o(123919);
  }
  
  protected static boolean Sf(long paramLong)
  {
    AppMethodBeat.i(123913);
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { Nft.toString() });
    int i = 0;
    while (i < Nft.size())
    {
      if (((b)Nft.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    Log.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { Nfr.toString() });
    if (Nfr.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean Sg(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (Nft == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { Nft.toString() });
    int i = 0;
    Object localObject;
    while (i < Nft.size())
    {
      localObject = (b)Nft.get(i);
      if ((((b)localObject).endTime > paramLong) && (!Sh(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (Nfr == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    Log.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { Nfr.toString() });
    if (Nfr.size() > 0)
    {
      localObject = Nfr.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!Sh(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean Sh(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (Nfu == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    Log.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { Nfu.toString() });
    int i = 0;
    while (i < Nfu.size())
    {
      if (Math.abs(paramLong - ((a)Nfu.get(i)).time) < 10000L)
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
        if (i < Nfs.size())
        {
          localc1 = (c)Nfs.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.Nfz = localc1.Nfz;
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
            localc1.Nfz = Nfq;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = Nfs.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.Nfz = Nfq;
          localc1.startTime = Nfp.startTime;
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
  
  protected static void gsj()
  {
    AppMethodBeat.i(123917);
    if (Nfs == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    Nfs.clear();
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
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243991);
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
          ((TrafficClickFlowReceiver.a)localObject1).Nfz = ((String)localObject2);
          ((TrafficClickFlowReceiver.a)localObject1).time = System.currentTimeMillis();
          TrafficClickFlowReceiver.Nfu.add(localObject1);
          Log.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject2 });
          AppMethodBeat.o(243991);
          return;
        }
        TrafficClickFlowReceiver.gA((String)localObject2, i);
        TrafficClickFlowReceiver.a(TrafficClickFlowReceiver.this, i);
        AppMethodBeat.o(243991);
      }
    });
    AppMethodBeat.o(123912);
  }
  
  static final class a
  {
    public String Nfz;
    public long time;
    
    public final String toString()
    {
      AppMethodBeat.i(123909);
      String str = "ClickObject{ui='" + this.Nfz + '\'' + ", time=" + this.time + '}';
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
    public String Nfz;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.Nfz + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */