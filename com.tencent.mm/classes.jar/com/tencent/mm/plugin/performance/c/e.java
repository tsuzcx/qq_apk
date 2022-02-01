package com.tencent.mm.plugin.performance.c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.f.a;
import com.tencent.matrix.f.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private int wKw;
  private long wKx;
  
  public static int IS()
  {
    AppMethodBeat.i(211808);
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
            i = bt.aRe(((Matcher)localObject2).group());
            AppMethodBeat.o(211808);
            return i;
          }
        }
        i += 1;
      }
      ad.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = bt.aRe(localObject1[24].trim());
      AppMethodBeat.o(211808);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(211808);
    }
    return 0;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(211809);
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
    AppMethodBeat.o(211809);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(211809);
    return paramInputStream;
  }
  
  public static int dzf()
  {
    AppMethodBeat.i(211811);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(211811);
    return i;
  }
  
  public static int eK(List<e.a> paramList)
  {
    AppMethodBeat.i(211812);
    Object localObject2 = new HashMap();
    Object localObject1 = Looper.getMainLooper().getThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
    int k = ((ThreadGroup)localObject1).enumerate(arrayOfThread);
    int j = 0;
    int i = 0;
    label138:
    if (j < k)
    {
      localObject1 = arrayOfThread[j].getName();
      if (bt.isNullOrNil((String)localObject1)) {
        break label263;
      }
      localObject1 = ((String)localObject1).replaceAll("[0-9]\\d*", "?");
      if (!((String)localObject1).contains("Binder:")) {
        break label260;
      }
      localObject1 = "Binder:?_?";
      label96:
      if (((Map)localObject2).containsKey(localObject1))
      {
        ((Map)localObject2).put(localObject1, Integer.valueOf(((Integer)((Map)localObject2).get(localObject1)).intValue() + 1));
        i += 1;
      }
    }
    label260:
    label263:
    for (;;)
    {
      j += 1;
      break;
      ((Map)localObject2).put(localObject1, Integer.valueOf(1));
      break label138;
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramList.add(new e.a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()));
      }
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(211812);
      return i;
      break label96;
    }
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(211810);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString);
    paramString = null;
    try
    {
      localObject1 = i.ai((com.tencent.mm.vfs.e)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(211810);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(211810);
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(211807);
    int i;
    long l;
    if (SystemClock.uptimeMillis() - this.wKx >= 10000L)
    {
      this.wKx = SystemClock.uptimeMillis();
      i = 1;
      if (i == 0) {
        break label1237;
      }
      l = SystemClock.uptimeMillis();
      if (!aj.cmR()) {
        break label581;
      }
      i = 100;
      label48:
      if (i == -1) {
        break label1237;
      }
    }
    Object localObject4;
    int n;
    int i1;
    Object localObject1;
    int j;
    label102:
    Object localObject5;
    Object localObject6;
    label230:
    label249:
    String str1;
    label265:
    Object localObject2;
    label284:
    int k;
    label304:
    String str2;
    label320:
    label339:
    int m;
    for (;;)
    {
      try
      {
        localObject4 = new LinkedList();
        n = IS();
        i1 = eK((List)localObject4);
        if (n <= 500) {
          break label619;
        }
        paramActivity = a.IT();
        localObject4 = new a.d[3];
        localObject1 = paramActivity.iterator();
        j = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject4[j] = ((a.d)((Iterator)localObject1).next());
          j += 1;
          if (j < 3) {
            break label1247;
          }
        }
        localObject5 = paramActivity.toString();
        ad.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { localObject5 });
        localObject6 = com.tencent.mm.plugin.report.e.ygI;
        String str3 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), localObject5 });
        if (localObject4[0] == null) {
          break label612;
        }
        paramActivity = localObject4[0].name;
        if (localObject4[0] == null) {
          break label1255;
        }
        localObject1 = Integer.valueOf(localObject4[0].getSize());
        if ((localObject4[0] == null) || (!localObject4[0].IV())) {
          break label1263;
        }
        j = 1;
        if (localObject4[1] == null) {
          break label1268;
        }
        str1 = localObject4[1].name;
        if (localObject4[1] == null) {
          break label1276;
        }
        localObject2 = Integer.valueOf(localObject4[1].getSize());
        if ((localObject4[1] == null) || (!localObject4[1].IV())) {
          break label1284;
        }
        k = 1;
        if (localObject4[2] == null) {
          break label1290;
        }
        str2 = localObject4[2].name;
        if (localObject4[2] == null) {
          break label1298;
        }
        localObject3 = Integer.valueOf(localObject4[2].getSize());
        if ((localObject4[2] == null) || (!localObject4[2].IV())) {
          break label1306;
        }
        m = 1;
        label359:
        ((com.tencent.mm.plugin.report.e)localObject6).f(16470, new Object[] { str3, Integer.valueOf(1), Integer.valueOf(i1), Integer.valueOf(n), paramActivity, localObject1, Integer.valueOf(j), str1, localObject2, Integer.valueOf(k), str2, localObject3, Integer.valueOf(m), aj.getProcessName() });
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 1, 1L, true);
        paramActivity = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), localObject5 }));
        AppMethodBeat.o(211807);
        throw paramActivity;
      }
      finally
      {
        ad.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(211807);
      }
      i = 0;
      break;
      label581:
      if ((aj.fkI()) || (aj.fkJ()))
      {
        i = 120;
        break label48;
      }
      if (!aj.isAppBrandProcess()) {
        break label1250;
      }
      i = 140;
      break label48;
      label612:
      paramActivity = "null";
    }
    label619:
    if (n > 300)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i, 1L, true);
      if (n - this.wKw >= 50)
      {
        this.wKw = n;
        localObject3 = new e.a[3];
        paramActivity = ((LinkedList)localObject4).iterator();
        j = 0;
        if (paramActivity.hasNext())
        {
          localObject3[j] = ((e.a)paramActivity.next());
          j += 1;
          if (j < 3) {
            break label1244;
          }
        }
        ad.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { localObject4 });
        localObject5 = com.tencent.mm.plugin.report.e.ygI;
        localObject6 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), ((LinkedList)localObject4).toString() });
        if (localObject3[0] == null) {
          break label1060;
        }
        paramActivity = localObject3[0].name;
        if (localObject3[0] == null) {
          break label1312;
        }
        localObject1 = Integer.valueOf(localObject3[0].count);
        if (localObject3[1] == null) {
          break label1320;
        }
        str1 = localObject3[1].name;
        if (localObject3[1] == null) {
          break label1328;
        }
        localObject2 = Integer.valueOf(localObject3[1].count);
        if (localObject3[2] == null) {
          break label1336;
        }
        str2 = localObject3[2].name;
        if (localObject3[2] == null) {
          break label1344;
        }
      }
    }
    label672:
    label811:
    label830:
    label846:
    for (Object localObject3 = Integer.valueOf(localObject3[2].count);; localObject3 = "0")
    {
      ((com.tencent.mm.plugin.report.e)localObject5).f(16470, new Object[] { localObject6, Integer.valueOf(2), Integer.valueOf(i1), Integer.valueOf(n), paramActivity, localObject1, Integer.valueOf(1), str1, localObject2, Integer.valueOf(1), str2, localObject3, Integer.valueOf(1), aj.getProcessName() });
      if (i1 > 500) {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 4, 1L, true);
      }
      for (;;)
      {
        ad.w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), ((LinkedList)localObject4).toString() });
        ad.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(211807);
        return;
        paramActivity = "null";
        break;
        if (n > 200)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 2, 1L, true);
          break label970;
        }
        if (n > 150)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 3, 1L, true);
          break label970;
        }
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 8, 1L, true);
        break label970;
        if (i1 > 300) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 5, 1L, true);
        } else if (i1 > 200) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 6, 1L, true);
        } else if (i1 > 150) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 7, 1L, true);
        } else {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(960L, i + 9, 1L, true);
        }
      }
      label1237:
      AppMethodBeat.o(211807);
      return;
      label1244:
      break label672;
      label1247:
      break label102;
      label1250:
      i = -1;
      break;
      label1255:
      localObject1 = "0";
      break label230;
      label1263:
      j = 0;
      break label249;
      label1268:
      str1 = "null";
      break label265;
      label1276:
      localObject2 = "0";
      break label284;
      k = 0;
      break label304;
      str2 = "null";
      break label320;
      localObject3 = "0";
      break label339;
      m = 0;
      break label359;
      localObject1 = "0";
      break label795;
      str1 = "null";
      break label811;
      localObject2 = "0";
      break label830;
      str2 = "null";
      break label846;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.e
 * JD-Core Version:    0.7.0.1
 */