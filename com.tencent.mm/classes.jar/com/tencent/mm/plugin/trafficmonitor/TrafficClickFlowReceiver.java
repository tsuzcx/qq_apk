package com.tencent.mm.plugin.trafficmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.o;
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
  private static boolean hqi;
  private static TrafficClickFlowReceiver.c toi;
  private static String toj;
  private static Map<Long, TrafficClickFlowReceiver.b> tok;
  private static List<TrafficClickFlowReceiver.c> tol;
  private static List<TrafficClickFlowReceiver.b> tom;
  private static List<TrafficClickFlowReceiver.a> ton;
  private static int toq;
  private static c tor;
  private int too = 0;
  
  static
  {
    AppMethodBeat.i(114777);
    toi = new TrafficClickFlowReceiver.c();
    tok = Collections.synchronizedMap(new HashMap());
    tol = Collections.synchronizedList(new ArrayList());
    tom = Collections.synchronizedList(new ArrayList());
    ton = Collections.synchronizedList(new ArrayList());
    toq = 0;
    hqi = false;
    tor = new c();
    c.a(new TrafficClickFlowReceiver.1());
    AppMethodBeat.o(114777);
  }
  
  protected static int a(int paramInt, long paramLong, List<TrafficClickFlowReceiver.c> paramList)
  {
    AppMethodBeat.i(114774);
    int j = 1;
    int i = paramInt;
    paramInt = j;
    for (;;)
    {
      try
      {
        TrafficClickFlowReceiver.c localc1;
        if (i < tol.size())
        {
          localc1 = (TrafficClickFlowReceiver.c)tol.get(i);
          if ((paramInt != 0) && (localc1.endTime > paramLong))
          {
            TrafficClickFlowReceiver.c localc2 = new TrafficClickFlowReceiver.c();
            localc2.tos = localc1.tos;
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
            localc1.tos = toj;
            localc1.startTime = paramLong;
            localc1.endTime = System.currentTimeMillis();
            paramList.add(localc1);
            paramInt = tol.size();
            AppMethodBeat.o(114774);
            return paramInt;
          }
          localc1 = new TrafficClickFlowReceiver.c();
          localc1.tos = toj;
          localc1.startTime = toi.startTime;
          localc1.endTime = System.currentTimeMillis();
          paramList.add(localc1);
          continue;
        }
        i += 1;
      }
      catch (Exception paramList)
      {
        AppMethodBeat.o(114774);
        return -1;
      }
    }
  }
  
  protected static void cKN()
  {
    AppMethodBeat.i(114775);
    if (tol == null)
    {
      AppMethodBeat.o(114775);
      return;
    }
    tol.clear();
    AppMethodBeat.o(114775);
  }
  
  protected static boolean nb(long paramLong)
  {
    AppMethodBeat.i(114771);
    ab.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects downLoadObjects : %s", new Object[] { tom.toString() });
    int i = 0;
    while (i < tom.size())
    {
      if (((TrafficClickFlowReceiver.b)tom.get(i)).endTime > paramLong)
      {
        AppMethodBeat.o(114771);
        return true;
      }
      i += 1;
    }
    ab.i("MicroMsg.TrafficClickFlow", "hasDownloadObjects currentDownloadMap : %s", new Object[] { tok.toString() });
    if (tok.size() > 0)
    {
      AppMethodBeat.o(114771);
      return true;
    }
    AppMethodBeat.o(114771);
    return false;
  }
  
  protected static boolean nc(long paramLong)
  {
    AppMethodBeat.i(114772);
    if (tom == null)
    {
      AppMethodBeat.o(114772);
      return true;
    }
    ab.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal downLoadObjects : %s", new Object[] { tom.toString() });
    int i = 0;
    Object localObject;
    while (i < tom.size())
    {
      localObject = (TrafficClickFlowReceiver.b)tom.get(i);
      if ((((TrafficClickFlowReceiver.b)localObject).endTime > paramLong) && (!nd(((TrafficClickFlowReceiver.b)localObject).startTime)))
      {
        AppMethodBeat.o(114772);
        return false;
      }
      i += 1;
    }
    if (tok == null)
    {
      AppMethodBeat.o(114772);
      return true;
    }
    ab.i("MicroMsg.TrafficClickFlow", "isDownloadFileNormal currentDownloadMap : %s", new Object[] { tok.toString() });
    if (tok.size() > 0)
    {
      localObject = tok.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!nd(((TrafficClickFlowReceiver.b)((Map.Entry)((Iterator)localObject).next()).getValue()).startTime))
        {
          AppMethodBeat.o(114772);
          return false;
        }
      }
    }
    AppMethodBeat.o(114772);
    return true;
  }
  
  private static boolean nd(long paramLong)
  {
    AppMethodBeat.i(114773);
    if (ton == null)
    {
      AppMethodBeat.o(114773);
      return false;
    }
    ab.i("MicroMsg.TrafficClickFlow", "clickObjects : %s", new Object[] { ton.toString() });
    int i = 0;
    while (i < ton.size())
    {
      if (Math.abs(paramLong - ((TrafficClickFlowReceiver.a)ton.get(i)).time) < 10000L)
      {
        AppMethodBeat.o(114773);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(114773);
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(114770);
    if ((paramIntent == null) || (!paramIntent.getAction().equals("com.tencent.mm.Intent.ACTION_NET_STATS")))
    {
      AppMethodBeat.o(114770);
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
      paramContext.tos = ((String)localObject);
      paramContext.time = System.currentTimeMillis();
      ton.add(paramContext);
      ab.i("MicroMsg.TrafficClickFlow", "onReceive Click : %s", new Object[] { localObject });
      AppMethodBeat.o(114770);
      return;
    }
    if (i == 1) {
      toj = (String)localObject;
    }
    for (;;)
    {
      this.too = i;
      AppMethodBeat.o(114770);
      return;
      if (i == 3)
      {
        if (hqi)
        {
          paramContext = new TrafficClickFlowReceiver.c();
          paramContext.tos = "Background";
          paramContext.startTime = toi.startTime;
          paramContext.endTime = System.currentTimeMillis();
          tol.add(paramContext);
          hqi = false;
        }
        toj = (String)localObject;
        if (localObject != toi.tos)
        {
          toi.tos = ((String)localObject);
          toi.startTime = System.currentTimeMillis();
        }
      }
      else if (i == 4)
      {
        toi.endTime = System.currentTimeMillis();
        if (toi.tos != null) {
          tol.add(toi);
        }
        toi = new TrafficClickFlowReceiver.c();
        boolean bool1 = bo.hj(ah.getContext());
        boolean bool2 = o.gE(ah.getContext());
        if ((!bool1) || (!bool2))
        {
          toi.startTime = System.currentTimeMillis();
          toj = "Background";
          hqi = true;
          ab.i("MicroMsg.TrafficClickFlow", "come to background isTopApp : %b, isScreenOn : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        }
      }
      else if ((i == 5) && (tol.contains(localObject)))
      {
        toj = "Background";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.TrafficClickFlowReceiver
 * JD-Core Version:    0.7.0.1
 */