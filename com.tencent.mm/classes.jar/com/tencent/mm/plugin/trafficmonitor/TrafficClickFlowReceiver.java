package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static c AiO;
  private static String AiP;
  private static Map<Long, b> AiQ;
  private static List<c> AiR;
  private static List<b> AiS;
  private static List<a> AiT;
  private static int AiV;
  private static c AiW;
  private static boolean jND;
  private int AiU = 0;
  
  static
  {
    AppMethodBeat.i(123919);
    AiO = new c();
    AiQ = Collections.synchronizedMap(new HashMap());
    AiR = Collections.synchronizedList(new ArrayList());
    AiS = Collections.synchronizedList(new ArrayList());
    AiT = Collections.synchronizedList(new ArrayList());
    AiV = 0;
    jND = false;
    AiW = new c();
    c.a(new m()
    {
      public final void a(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123904);
        TrafficClickFlowReceiver.L(13, paramAnonymousLong);
        AppMethodBeat.o(123904);
      }
      
      public final void b(long paramAnonymousLong, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(123903);
        TrafficClickFlowReceiver.L(13, paramAnonymousLong);
        AppMethodBeat.o(123903);
      }
      
      public final void j(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123908);
        TrafficClickFlowReceiver.L(11, paramAnonymousLong);
        AppMethodBeat.o(123908);
      }
      
      public final void onTaskPaused(long paramAnonymousLong)
      {
        AppMethodBeat.i(123906);
        TrafficClickFlowReceiver.L(13, paramAnonymousLong);
        AppMethodBeat.o(123906);
      }
      
      public final void onTaskRemoved(long paramAnonymousLong)
      {
        AppMethodBeat.i(123905);
        TrafficClickFlowReceiver.L(13, paramAnonymousLong);
        AppMethodBeat.o(123905);
      }
      
      public final void onTaskStarted(long paramAnonymousLong, String paramAnonymousString)
      {
        AppMethodBeat.i(123902);
        TrafficClickFlowReceiver.L(11, paramAnonymousLong);
        AppMethodBeat.o(123902);
      }
      
      public final void qN(long paramAnonymousLong)
      {
        AppMethodBeat.i(123907);
        TrafficClickFlowReceiver.L(12, paramAnonymousLong);
        AppMethodBeat.o(123907);
      }
      
      public final void qO(long paramAnonymousLong) {}
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
        if (i < AiR.size())
        {
          localc1 = (c)AiR.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            c localc2 = new c();
            localc2.AiX = localc1.AiX;
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
            localc1.AiX = AiP;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = AiR.size();
            AppMethodBeat.o(123916);
            return paramInt;
          }
          localc1 = new c();
          localc1.AiX = AiP;
          localc1.startTime = AiO.startTime;
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
  
  protected static void eeR()
  {
    AppMethodBeat.i(123917);
    if (AiR == null)
    {
      AppMethodBeat.o(123917);
      return;
    }
    AiR.clear();
    AppMethodBeat.o(123917);
  }
  
  protected static boolean yF(long paramLong)
  {
    AppMethodBeat.i(123913);
    ac.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { AiS.toString() });
    int i = 0;
    while (i < AiS.size())
    {
      if (((b)AiS.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(123913);
        return true;
      }
      i += 1;
    }
    ac.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { AiQ.toString() });
    if (AiQ.size() > 0)
    {
      AppMethodBeat.o(123913);
      return true;
    }
    AppMethodBeat.o(123913);
    return false;
  }
  
  protected static boolean yG(long paramLong)
  {
    AppMethodBeat.i(123914);
    if (AiS == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ac.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { AiS.toString() });
    int i = 0;
    Object localObject;
    while (i < AiS.size())
    {
      localObject = (b)AiS.get(i);
      if ((((b)localObject).endTime > paramLong) && (!yH(((b)localObject).startTime)))
      {
        AppMethodBeat.o(123914);
        return false;
      }
      i += 1;
    }
    if (AiQ == null)
    {
      AppMethodBeat.o(123914);
      return true;
    }
    ac.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { AiQ.toString() });
    if (AiQ.size() > 0)
    {
      localObject = AiQ.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!yH(((b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(123914);
          return false;
        }
      }
    }
    AppMethodBeat.o(123914);
    return true;
  }
  
  private static boolean yH(long paramLong)
  {
    AppMethodBeat.i(123915);
    if (AiT == null)
    {
      AppMethodBeat.o(123915);
      return false;
    }
    ac.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { AiT.toString() });
    int i = 0;
    while (i < AiT.size())
    {
      if (Math.abs(paramLong - ((a)AiT.get(i)).time) < 10000L)
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
      paramContext = new a();
      paramContext.AiX = ((String)localObject);
      paramContext.time = System.currentTimeMillis();
      AiT.add(paramContext);
      ac.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject });
      AppMethodBeat.o(123912);
      return;
    }
    if (i == 1) {
      AiP = (String)localObject;
    }
    for (;;)
    {
      this.AiU = i;
      AppMethodBeat.o(123912);
      return;
      if (i == 3)
      {
        if (jND)
        {
          paramContext = new c();
          paramContext.AiX = "Background";
          paramContext.startTime = AiO.startTime;
          paramContext.endTime = System.currentTimeMillis();
          AiR.add(paramContext);
          jND = false;
        }
        AiP = (String)localObject;
        if (localObject != AiO.AiX)
        {
          AiO.AiX = ((String)localObject);
          AiO.startTime = System.currentTimeMillis();
        }
      }
      else if (i == 4)
      {
        AiO.endTime = System.currentTimeMillis();
        if (AiO.AiX != null) {
          AiR.add(AiO);
        }
        AiO = new c();
        boolean bool1 = bs.iY(ai.getContext());
        boolean bool2 = q.ir(ai.getContext());
        if ((!bool1) || (!bool2))
        {
          AiO.startTime = System.currentTimeMillis();
          AiP = "Background";
          jND = true;
          ac.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
      }
      else if ((i == 5) && (AiR.contains(localObject)))
      {
        AiP = "Background";
      }
    }
  }
  
  static final class a
  {
    public String AiX;
    public long time;
    
    public final String toString()
    {
      AppMethodBeat.i(123909);
      String str = "ClickObject{ui='" + this.AiX + '\'' + ", time=" + this.time + '}';
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
    public String AiX;
    public long endTime;
    public long startTime;
    
    public final String toString()
    {
      AppMethodBeat.i(123911);
      String str = "UIObject{ui='" + this.AiX + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
      AppMethodBeat.o(123911);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */