package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ae;
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
  private static c BRX;
  private static String BRY;
  private static Map<Long, b> BRZ;
  private static List<c> BSa;
  private static List<b> BSb;
  private static List<a> BSc;
  private static int BSe;
  private static c BSf;
  private static boolean kle;
  private int BSd = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    BRX = new c();
    BRZ = Collections.synchronizedMap(new HashMap());
    BSa = Collections.synchronizedList(new ArrayList());
    BSb = Collections.synchronizedList(new ArrayList());
    BSc = Collections.synchronizedList(new ArrayList());
    BSe = 0;
    kle = false;
    BSf = new c();
    c.a(new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void a(long paramAnonymousLong1, String paramAnonymousString, long paramAnonymousLong2, long paramAnonymousLong3)
      {
        AppMethodBeat.i(211557);
        TrafficClickFlowReceiver.M(12, paramAnonymousLong1);
        AppMethodBeat.o(211557);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.M(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void k(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.M(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
      
      public final void sY(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void sZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.M(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void ta(long paramAnonymousLong) {}
    });
    AppMethodBeat.o(123919);
  }
  
  protected static boolean BB(long paramLong)
  {
    AppMethodBeat.i(123913);
    ae.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { BSb.toString() });
    int i = 0;
    while (i < BSb.size())
    {
      if (((b)BSb.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    ae.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { BRZ.toString() });
    if (BRZ.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean BC(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (BSb == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ae.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { BSb.toString() });
    int i = 0;
    Object localObject;
    while (i < BSb.size())
    {
      localObject = (b)BSb.get(i);
      if ((((b)localObject).endTime > paramLong) && (!BD(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (BRZ == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ae.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { BRZ.toString() });
    if (BRZ.size() > 0)
    {
      localObject = BRZ.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!BD(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean BD(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (BSc == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    ae.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { BSc.toString() });
    int i = 0;
    while (i < BSc.size())
    {
      if (Math.abs(paramLong - ((a)BSc.get(i)).time) < 10000L)
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
        if (i < BSa.size())
        {
          localc1 = (c)BSa.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.BSh = localc1.BSh;
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
            localc1.BSh = BRY;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = BSa.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.BSh = BRY;
          localc1.startTime = BRX.startTime;
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
  
  protected static void euP()
  {
    AppMethodBeat.i(123917);
    if (BSa == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    BSa.clear();
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
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211558);
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
          ((TrafficClickFlowReceiver.a)localObject1).BSh = ((String)localObject2);
          ((TrafficClickFlowReceiver.a)localObject1).time = System.currentTimeMillis();
          TrafficClickFlowReceiver.bbx().add(localObject1);
          ae.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject2 });
          AppMethodBeat.o(211558);
          return;
        }
        TrafficClickFlowReceiver.fs((String)localObject2, i);
        TrafficClickFlowReceiver.a(TrafficClickFlowReceiver.this, i);
        AppMethodBeat.o(211558);
      }
    });
    AppMethodBeat.o(123912);
  }
  
  static final class a
  {
    public String BSh;
    public long time;
    
    public final String toString()
    {
      AppMethodBeat.i(123909);
      String str = "ClickObject{ui='" + this.BSh + '\'' + ", time=" + this.time + '}';
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
    public String BSh;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.BSh + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */