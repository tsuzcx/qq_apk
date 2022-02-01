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

public final class b
  implements Application.ActivityLifecycleCallbacks
{
  private long uuy;
  
  public static int HM()
  {
    AppMethodBeat.i(193456);
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
            i = bt.aGh(((Matcher)localObject2).group());
            AppMethodBeat.o(193456);
            return i;
          }
        }
        i += 1;
      }
      ad.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = bt.aGh(localObject1[24].trim());
      AppMethodBeat.o(193456);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(193456);
    }
    return 0;
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(193457);
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
    AppMethodBeat.o(193457);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(193457);
    return paramInputStream;
  }
  
  public static int daV()
  {
    AppMethodBeat.i(193459);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(193459);
    return i;
  }
  
  public static int et(List<b.a> paramList)
  {
    AppMethodBeat.i(193460);
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
        paramList.add(new b.a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()));
      }
      Collections.sort(paramList, new Comparator() {});
      AppMethodBeat.o(193460);
      return i;
      break label96;
    }
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(193458);
    Object localObject1 = new com.tencent.mm.vfs.e(paramString);
    paramString = null;
    try
    {
      localObject1 = i.ah((com.tencent.mm.vfs.e)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(193458);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(193458);
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
    AppMethodBeat.i(193455);
    int i;
    long l;
    if (SystemClock.uptimeMillis() - this.uuy >= 10000L)
    {
      this.uuy = SystemClock.uptimeMillis();
      i = 1;
      if (i == 0) {
        break label1232;
      }
      l = SystemClock.uptimeMillis();
      if (!aj.cbe()) {
        break label581;
      }
      i = 100;
      label48:
      if (i == -1) {
        break label1232;
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
        n = HM();
        i1 = et((List)localObject4);
        if (n <= 500) {
          break label632;
        }
        paramActivity = a.HN();
        localObject4 = new a.d[3];
        localObject1 = paramActivity.iterator();
        j = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject4[j] = ((a.d)((Iterator)localObject1).next());
          j += 1;
          if (j < 3) {
            break label1242;
          }
        }
        localObject5 = paramActivity.toString();
        ad.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { localObject5 });
        localObject6 = com.tencent.mm.plugin.report.e.vIY;
        String str3 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), localObject5 });
        if (localObject4[0] == null) {
          break label625;
        }
        paramActivity = localObject4[0].name;
        if (localObject4[0] == null) {
          break label1250;
        }
        localObject1 = Integer.valueOf(localObject4[0].getSize());
        if ((localObject4[0] == null) || (!localObject4[0].HP())) {
          break label1258;
        }
        j = 1;
        if (localObject4[1] == null) {
          break label1263;
        }
        str1 = localObject4[1].name;
        if (localObject4[1] == null) {
          break label1271;
        }
        localObject2 = Integer.valueOf(localObject4[1].getSize());
        if ((localObject4[1] == null) || (!localObject4[1].HP())) {
          break label1279;
        }
        k = 1;
        if (localObject4[2] == null) {
          break label1285;
        }
        str2 = localObject4[2].name;
        if (localObject4[2] == null) {
          break label1293;
        }
        localObject3 = Integer.valueOf(localObject4[2].getSize());
        if ((localObject4[2] == null) || (!localObject4[2].HP())) {
          break label1301;
        }
        m = 1;
        label359:
        ((com.tencent.mm.plugin.report.e)localObject6).f(16470, new Object[] { str3, Integer.valueOf(1), Integer.valueOf(i1), Integer.valueOf(n), paramActivity, localObject1, Integer.valueOf(j), str1, localObject2, Integer.valueOf(k), str2, localObject3, Integer.valueOf(m), aj.getProcessName() });
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 1, 1L, true);
        paramActivity = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), localObject5 }));
        AppMethodBeat.o(193455);
        throw paramActivity;
      }
      finally
      {
        ad.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(193455);
      }
      i = 0;
      break;
      label581:
      if ((aj.eFJ()) || (aj.eFK()))
      {
        i = 120;
        break label48;
      }
      if (aj.isAppBrandProcess())
      {
        i = 140;
        break label48;
      }
      if (!aj.eFH()) {
        break label1245;
      }
      i = 160;
      break label48;
      label625:
      paramActivity = "null";
    }
    label632:
    if (n > 300)
    {
      localObject3 = new b.a[3];
      paramActivity = ((LinkedList)localObject4).iterator();
      j = 0;
      if (paramActivity.hasNext())
      {
        localObject3[j] = ((b.a)paramActivity.next());
        j += 1;
        if (j < 3) {
          break label1239;
        }
      }
      ad.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { localObject4 });
      localObject5 = com.tencent.mm.plugin.report.e.vIY;
      localObject6 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), ((LinkedList)localObject4).toString() });
      if (localObject3[0] != null)
      {
        paramActivity = localObject3[0].name;
        if (localObject3[0] == null) {
          break label1307;
        }
        localObject1 = Integer.valueOf(localObject3[0].count);
        if (localObject3[1] == null) {
          break label1315;
        }
        str1 = localObject3[1].name;
        if (localObject3[1] == null) {
          break label1323;
        }
        localObject2 = Integer.valueOf(localObject3[1].count);
        if (localObject3[2] == null) {
          break label1331;
        }
        str2 = localObject3[2].name;
        if (localObject3[2] == null) {
          break label1339;
        }
      }
    }
    label654:
    label793:
    label812:
    label828:
    for (Object localObject3 = Integer.valueOf(localObject3[2].count);; localObject3 = "0")
    {
      ((com.tencent.mm.plugin.report.e)localObject5).f(16470, new Object[] { localObject6, Integer.valueOf(2), Integer.valueOf(i1), Integer.valueOf(n), paramActivity, localObject1, Integer.valueOf(1), str1, localObject2, Integer.valueOf(1), str2, localObject3, Integer.valueOf(1), aj.getProcessName() });
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i, 1L, true);
      label965:
      if (i1 > 500) {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 4, 1L, true);
      }
      for (;;)
      {
        ad.w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), ((LinkedList)localObject4).toString() });
        ad.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
        AppMethodBeat.o(193455);
        return;
        paramActivity = "null";
        break;
        if (n > 200)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 2, 1L, true);
          break label965;
        }
        if (n > 150)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 3, 1L, true);
          break label965;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 8, 1L, true);
        break label965;
        if (i1 > 300) {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 5, 1L, true);
        } else if (i1 > 200) {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 6, 1L, true);
        } else if (i1 > 150) {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 7, 1L, true);
        } else {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(960L, i + 9, 1L, true);
        }
      }
      label1232:
      AppMethodBeat.o(193455);
      return;
      label1239:
      break label654;
      label1242:
      break label102;
      label1245:
      i = -1;
      break;
      label1250:
      localObject1 = "0";
      break label230;
      label1258:
      j = 0;
      break label249;
      label1263:
      str1 = "null";
      break label265;
      label1271:
      localObject2 = "0";
      break label284;
      label1279:
      k = 0;
      break label304;
      str2 = "null";
      break label320;
      localObject3 = "0";
      break label339;
      m = 0;
      break label359;
      localObject1 = "0";
      break label777;
      str1 = "null";
      break label793;
      localObject2 = "0";
      break label812;
      str2 = "null";
      break label828;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.b
 * JD-Core Version:    0.7.0.1
 */