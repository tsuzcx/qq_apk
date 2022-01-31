package com.tencent.mm.plugin.performance.b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.f.a;
import com.tencent.matrix.f.a.2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private long ptb;
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(111086);
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
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
          break label61;
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
    label61:
    AppMethodBeat.o(111086);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(111086);
    return paramInputStream;
  }
  
  public static int cw(List<b.a> paramList)
  {
    AppMethodBeat.i(138544);
    Object localObject1 = new HashMap();
    Object localObject3 = Looper.getMainLooper().getThread().getThreadGroup();
    Object localObject2 = new Thread[((ThreadGroup)localObject3).activeCount() * 2];
    int k = ((ThreadGroup)localObject3).enumerate((Thread[])localObject2);
    int j = 0;
    int i = 0;
    if (j < k)
    {
      localObject3 = localObject2[j].getName();
      if (bo.isNullOrNil((String)localObject3)) {
        break label246;
      }
      localObject3 = ((String)localObject3).replaceAll("-?[0-9]\\d*", "?");
      if (((Map)localObject1).containsKey(localObject3))
      {
        ((Map)localObject1).put(localObject3, Integer.valueOf(((Integer)((Map)localObject1).get(localObject3)).intValue() + 1));
        label124:
        i += 1;
      }
    }
    label246:
    for (;;)
    {
      j += 1;
      break;
      ((Map)localObject1).put(localObject3, Integer.valueOf(1));
      break label124;
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramList.add(new b.a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()));
      }
      Collections.sort(paramList, new b.1());
      AppMethodBeat.o(138544);
      return i;
    }
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(111087);
    paramString = new File(paramString);
    FileInputStream localFileInputStream;
    try
    {
      localFileInputStream = new FileInputStream(paramString);
      if (localFileInputStream == null) {
        break label50;
      }
    }
    finally
    {
      try
      {
        paramString = convertStreamToString(localFileInputStream);
        localFileInputStream.close();
        AppMethodBeat.o(111087);
        return paramString;
      }
      finally {}
      paramString = finally;
      localFileInputStream = null;
    }
    localFileInputStream.close();
    label50:
    AppMethodBeat.o(111087);
    throw paramString;
  }
  
  public static int zq()
  {
    AppMethodBeat.i(111085);
    Object localObject1 = String.format("/proc/%s/status", new Object[] { Integer.valueOf(Process.myPid()) });
    try
    {
      localObject1 = getStringFromFile((String)localObject1).trim().split("\n");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((String)localObject2).startsWith("Threads"))
        {
          localObject2 = Pattern.compile("\\d+").matcher((CharSequence)localObject2);
          if (((Matcher)localObject2).find())
          {
            i = bo.apV(((Matcher)localObject2).group());
            AppMethodBeat.o(111085);
            return i;
          }
        }
        i += 1;
      }
      ab.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = bo.apV(localObject1[24].trim());
      AppMethodBeat.o(111085);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(111085);
    }
    return 0;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(111084);
    int i;
    long l;
    if (SystemClock.uptimeMillis() - this.ptb >= 10000L)
    {
      this.ptb = SystemClock.uptimeMillis();
      i = 1;
      if (i == 0) {
        break label512;
      }
      l = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      LinkedList localLinkedList;
      int j;
      try
      {
        localLinkedList = new LinkedList();
        i = zq();
        j = cw(localLinkedList);
        if (i <= 500) {
          break label244;
        }
        if (!com.tencent.matrix.b.isInstalled()) {
          break label519;
        }
        paramActivity = (a)com.tencent.matrix.b.yD().z(a.class);
        if (paramActivity == null) {
          break label519;
        }
        Object localObject = new HashMap();
        a.a(new a.2(paramActivity, (Map)localObject), null);
        paramActivity = localObject.toString();
        localObject = paramActivity;
        if (paramActivity == null) {
          localObject = localLinkedList.toString();
        }
        e.qrI.idkeyStat(960L, 101L, 1L, true);
        paramActivity = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localObject }));
        AppMethodBeat.o(111084);
        throw paramActivity;
      }
      finally
      {
        ab.d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(111084);
      }
      i = 0;
      break;
      label244:
      if (i > 300)
      {
        e.qrI.kvStat(16470, String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localLinkedList.toString() }));
        e.qrI.idkeyStat(960L, 100L, 1L, true);
        if (j <= 500) {
          break label440;
        }
        e.qrI.idkeyStat(960L, 104L, 1L, true);
      }
      for (;;)
      {
        ab.w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i), localLinkedList.toString() });
        ab.d("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(111084);
        return;
        if (i > 200)
        {
          e.qrI.idkeyStat(960L, 102L, 1L, true);
          break;
        }
        if (i <= 150) {
          break;
        }
        e.qrI.idkeyStat(960L, 103L, 1L, true);
        break;
        label440:
        if (j > 300) {
          e.qrI.idkeyStat(960L, 105L, 1L, true);
        } else if (j > 200) {
          e.qrI.idkeyStat(960L, 106L, 1L, true);
        } else if (j > 150) {
          e.qrI.idkeyStat(960L, 107L, 1L, true);
        }
      }
      label512:
      AppMethodBeat.o(111084);
      return;
      label519:
      paramActivity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.b
 * JD-Core Version:    0.7.0.1
 */