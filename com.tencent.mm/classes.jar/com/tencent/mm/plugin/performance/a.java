package com.tencent.mm.plugin.performance;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  public static final a psb;
  private boolean bSe;
  boolean bVD;
  Handler handler;
  private long mLastTime;
  HandlerThread oNc;
  private a.a prZ;
  private long psa;
  private volatile boolean psc;
  private HashMap<String, Long> psd;
  private HashMap<Integer, Long> pse;
  
  static
  {
    AppMethodBeat.i(111038);
    psb = new a();
    AppMethodBeat.o(111038);
  }
  
  private a()
  {
    AppMethodBeat.i(111024);
    this.oNc = new HandlerThread("PowerTest");
    this.prZ = new a.a(this);
    this.psc = false;
    this.bSe = false;
    this.psd = new HashMap();
    this.pse = new HashMap();
    AppMethodBeat.o(111024);
  }
  
  private static Set<a.c> Bl(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(111030);
    HashSet localHashSet = new HashSet();
    String str = String.format("/proc/%s/task/", new Object[] { Integer.valueOf(paramInt) });
    Object localObject1 = new File(str);
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 == null)
      {
        AppMethodBeat.o(111030);
        return localHashSet;
      }
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        try
        {
          localObject2 = getStringFromFile(str + ((File)localObject2).getName() + "/stat");
          if (localObject2 != null)
          {
            localObject2 = ((String)localObject2).replaceAll("\n", "").split(" ");
            a.c localc = new a.c((byte)0);
            localc.tid = bo.apV(localObject2[0]);
            localc.name = localObject2[1].replace("(", "").replace(")", "");
            if (localc.tid == paramInt) {
              localc.name = "main";
            }
            if (bo.isNullOrNil(localc.name)) {
              localc.name = ("unKnow-" + localc.tid);
            }
            localc.bQI = fc(localc.tid, paramInt);
            localHashSet.add(localc);
          }
        }
        catch (Exception localException)
        {
          label260:
          break label260;
        }
        i += 1;
      }
    }
    else
    {
      AppMethodBeat.o(111030);
      return localHashSet;
    }
  }
  
  private List<a.c> a(int paramInt, a.b paramb, List<a.c> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(111028);
    Object localObject1 = new LinkedList();
    Object localObject2 = Bl(paramInt).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a.c localc = (a.c)((Iterator)localObject2).next();
      String str = paramInt + "#" + localc.tid;
      if (!paramBoolean)
      {
        this.psd.put(str, Long.valueOf(localc.bQI));
      }
      else
      {
        if (this.psd.containsKey(str)) {}
        for (long l = ((Long)this.psd.get(str)).longValue();; l = 0L)
        {
          if ((l == 0L) && (localc.bQI > 0L)) {
            ab.w("MicroMsg.PowerTest", "[dumpThread] new Thread? %s", new Object[] { localc });
          }
          localc.psh = (localc.bQI - l);
          if (localc.psh <= 0L) {
            break;
          }
          paramb.psi += localc.psh;
          ((List)localObject1).add(localc);
          break;
        }
      }
    }
    Collections.sort((List)localObject1, new a.1(this));
    localObject1 = ((List)localObject1).iterator();
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.c)((Iterator)localObject1).next();
      if (((float)((a.c)localObject2).psh >= (float)paramb.psi * 0.1F) && (paramInt < 12)) {
        paramList.add(localObject2);
      }
      paramInt += 1;
    }
    AppMethodBeat.o(111028);
    return paramList;
  }
  
  private static void a(long paramLong1, long paramLong2, long paramLong3, HashMap<a.b, List<a.c>> paramHashMap)
  {
    AppMethodBeat.i(151783);
    StringBuilder localStringBuilder = new StringBuilder(" \n");
    localStringBuilder.append("********************************* PowerTest ******************************\n");
    localStringBuilder.append(String.format("during:%smin < %smin", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong3) })).append("    diff:").append(paramLong1).append(String.format("    average:%s/min", new Object[] { Long.valueOf(paramLong1 / paramLong2) })).append("\n");
    localStringBuilder.append("*****************************微信各进程耗电信息*****************************\n");
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramHashMap.next();
      Object localObject2 = (a.b)((Map.Entry)localObject1).getKey();
      if (((a.b)localObject2).psi > 0L)
      {
        localStringBuilder.append("| *").append(((a.b)localObject2).toString()).append("\n");
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a.c)((Iterator)localObject1).next();
          localStringBuilder.append("|    -> ").append(((a.c)localObject2).toString()).append("\n");
        }
      }
    }
    localStringBuilder.append("********************************************************************\n");
    ab.i("MicroMsg.PowerTest", localStringBuilder.toString());
    AppMethodBeat.o(151783);
  }
  
  private void a(Set<a.b> paramSet, boolean paramBoolean)
  {
    AppMethodBeat.i(111027);
    Iterator localIterator = f(paramSet).iterator();
    while (localIterator.hasNext())
    {
      a.b localb = (a.b)localIterator.next();
      if (paramBoolean)
      {
        if (this.pse.containsKey(Integer.valueOf(localb.pid))) {}
        for (long l = ((Long)this.pse.get(Integer.valueOf(localb.pid))).longValue();; l = 0L)
        {
          localb.psh = (localb.bQI - l);
          paramSet.add(localb);
          break;
        }
      }
      this.pse.put(Integer.valueOf(localb.pid), Long.valueOf(localb.bQI));
    }
    AppMethodBeat.o(111027);
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(111032);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      try
      {
        for (;;)
        {
          paramInputStream = localBufferedReader.readLine();
          if (paramInputStream == null) {
            break;
          }
          localStringBuilder.append(paramInputStream).append('\n');
        }
        if (localBufferedReader == null) {
          break label65;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        BufferedReader localBufferedReader = null;
      }
    }
    localBufferedReader.close();
    label65:
    AppMethodBeat.o(111032);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(111032);
    return paramInputStream;
  }
  
  private static Set<a.b> f(Set<a.b> paramSet)
  {
    int i = 0;
    AppMethodBeat.i(111029);
    Object localObject1 = new File("/proc/");
    if (((File)localObject1).isDirectory())
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 == null)
      {
        AppMethodBeat.o(111029);
        return paramSet;
      }
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        try
        {
          String str = getStringFromFile("/proc/" + localObject2.getName() + "/stat");
          if (str != null)
          {
            String[] arrayOfString = str.replaceAll("\n", "").split(" ");
            a.b localb = new a.b((byte)0);
            localb.pid = bo.apV(arrayOfString[0]);
            localb.name = arrayOfString[1].replace("(", "").replace(")", "");
            if ((localb.name.contains("ncent.mm")) || (localb.name.contains(".mm:")))
            {
              localb.bQI = fc(0, localb.pid);
              paramSet.add(localb);
              ab.i("MicroMsg.PowerTest", "[getAllSelfProcess] file:%s content:%s", new Object[] { localObject2.getName(), str });
            }
          }
        }
        catch (Exception localException)
        {
          label233:
          break label233;
        }
        i += 1;
      }
    }
    else
    {
      AppMethodBeat.o(111029);
      return paramSet;
    }
  }
  
  private static long fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111031);
    Object localObject;
    if (paramInt1 == 0) {
      localObject = String.format("/proc/%s/stat", new Object[] { Integer.valueOf(paramInt2) });
    }
    try
    {
      for (;;)
      {
        localObject = getStringFromFile((String)localObject);
        if (localObject != null) {
          break;
        }
        AppMethodBeat.o(111031);
        return -1L;
        localObject = String.format("/proc/%s/task/%s/stat", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      }
      localObject = ((String)localObject).split(" ");
      long l1 = bo.apW(localObject[13]);
      long l2 = bo.apW(localObject[14]);
      long l3 = bo.apW(localObject[15]);
      long l4 = bo.apW(localObject[16]);
      AppMethodBeat.o(111031);
      return l4 + (l1 + l2 + l3);
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111031);
    }
    return -1L;
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(111033);
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label52;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        AppMethodBeat.o(111033);
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label52:
    AppMethodBeat.o(111033);
    throw paramString;
  }
  
  public final void jY(boolean paramBoolean)
  {
    AppMethodBeat.i(151782);
    if ((!this.bVD) || (this.handler == null))
    {
      AppMethodBeat.o(151782);
      return;
    }
    ab.i("MicroMsg.PowerTest", "onAppForeground isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      this.psc = false;
      this.prZ.psg = false;
      this.handler.removeCallbacks(this.prZ);
      this.handler.postDelayed(this.prZ, 120000L);
    }
    this.bSe = paramBoolean;
    AppMethodBeat.o(151782);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(111025);
    if (this.bSe)
    {
      AppMethodBeat.o(111025);
      return;
    }
    ab.i("MicroMsg.PowerTest", "come back Foreground! isHasRunAtBackground:%s", new Object[] { Boolean.valueOf(this.psc) });
    this.handler.removeCallbacks(this.prZ);
    if ((this.psc) && (!this.prZ.psg))
    {
      this.prZ.psg = true;
      this.handler.post(this.prZ);
    }
    AppMethodBeat.o(111025);
  }
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a
 * JD-Core Version:    0.7.0.1
 */