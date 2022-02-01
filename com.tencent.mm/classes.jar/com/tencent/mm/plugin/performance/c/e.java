package com.tencent.mm.plugin.performance.c;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.f.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private int xah;
  private long xai;
  
  public static int Ja()
  {
    AppMethodBeat.i(215481);
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
            i = bu.aSB(((Matcher)localObject2).group());
            AppMethodBeat.o(215481);
            return i;
          }
        }
        i += 1;
      }
      ae.w("MicroMsg.ThreadWatchDog", "[getProcessThreadCount] Wrong!", new Object[] { localObject1[24] });
      i = bu.aSB(localObject1[24].trim());
      AppMethodBeat.o(215481);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(215481);
    }
    return 0;
  }
  
  private static String aq(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(215479);
    long l = System.currentTimeMillis();
    Object localObject1 = com.tencent.matrix.f.a.Jb();
    a.d[] arrayOfd = new a.d[3];
    Object localObject2 = ((List)localObject1).iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        arrayOfd[i] = ((a.d)((Iterator)localObject2).next());
        i += 1;
        if (i < 3) {}
      }
      else
      {
        String str3 = localObject1.toString();
        ae.d("MicroMsg.ThreadWatchDog", "content %s", new Object[] { str3 });
        com.tencent.mm.plugin.report.e locale = com.tencent.mm.plugin.report.e.ywz;
        String str4 = String.format("ThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), str3 });
        label158:
        label177:
        String str1;
        label193:
        Object localObject3;
        label212:
        int j;
        label232:
        String str2;
        label248:
        Object localObject4;
        if (arrayOfd[0] != null)
        {
          localObject1 = arrayOfd[0].name;
          if (arrayOfd[0] == null) {
            break label457;
          }
          localObject2 = Integer.valueOf(arrayOfd[0].getSize());
          if ((arrayOfd[0] == null) || (!arrayOfd[0].Jd())) {
            break label464;
          }
          i = 1;
          if (arrayOfd[1] == null) {
            break label469;
          }
          str1 = arrayOfd[1].name;
          if (arrayOfd[1] == null) {
            break label476;
          }
          localObject3 = Integer.valueOf(arrayOfd[1].getSize());
          if ((arrayOfd[1] == null) || (!arrayOfd[1].Jd())) {
            break label483;
          }
          j = 1;
          if (arrayOfd[2] == null) {
            break label489;
          }
          str2 = arrayOfd[2].name;
          if (arrayOfd[2] == null) {
            break label496;
          }
          localObject4 = Integer.valueOf(arrayOfd[2].getSize());
          label267:
          if ((arrayOfd[2] == null) || (!arrayOfd[2].Jd())) {
            break label503;
          }
        }
        label457:
        label464:
        label469:
        label476:
        label483:
        label489:
        label496:
        label503:
        for (int k = 1;; k = 0)
        {
          locale.f(16470, new Object[] { str4, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), localObject1, localObject2, Integer.valueOf(i), str1, localObject3, Integer.valueOf(j), str2, localObject4, Integer.valueOf(k), ak.getProcessName() });
          localObject1 = new ArrayList();
          paramInt2 = 0;
          while (paramInt2 < 3)
          {
            if ((arrayOfd[paramInt2] != null) && (arrayOfd[paramInt2].getSize() > 20)) {
              ((List)localObject1).add(arrayOfd[paramInt2].name);
            }
            paramInt2 += 1;
          }
          localObject1 = "null";
          break;
          localObject2 = "0";
          break label158;
          i = 0;
          break label177;
          str1 = "null";
          break label193;
          localObject3 = "0";
          break label212;
          j = 0;
          break label232;
          str2 = "null";
          break label248;
          localObject4 = "0";
          break label267;
        }
        if (1 == paramInt1) {
          PthreadHookLogic.dBX();
        }
        eR((List)localObject1);
        ae.i("MicroMsg.ThreadWatchDog", "onOverThread: dump costs %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(215479);
        return str3;
      }
    }
  }
  
  private static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(215482);
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
    AppMethodBeat.o(215482);
    throw paramInputStream;
    localBufferedReader.close();
    paramInputStream = localStringBuilder.toString();
    AppMethodBeat.o(215482);
    return paramInputStream;
  }
  
  public static int dCw()
  {
    AppMethodBeat.i(215484);
    ThreadGroup localThreadGroup = Looper.getMainLooper().getThread().getThreadGroup();
    int i = localThreadGroup.enumerate(new Thread[localThreadGroup.activeCount() * 2]);
    AppMethodBeat.o(215484);
    return i;
  }
  
  private static void eR(List<String> paramList)
  {
    AppMethodBeat.i(215480);
    if ((j.IS_FLAVOR_RED) || (bv.fpR()) || (bv.fpT()) || (((b)g.ab(b.class)).a(b.a.qLd, false))) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ThreadWatchDog", "enable auto trigger? %s", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      AppMethodBeat.o(215480);
      return;
    }
    if (paramList.isEmpty())
    {
      ae.w("MicroMsg.ThreadWatchDog", "threadNames is empty, just return");
      AppMethodBeat.o(215480);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((String)localIterator.next()).replace("[", "\\[").replace("]", "\\]").replace("?", ".*");
      paramList = str;
      if (str.length() > 1)
      {
        paramList = str;
        if (str.endsWith("J")) {
          paramList = str.substring(0, str.length() - 1);
        }
      }
      localStringBuilder.append(paramList).append(";");
    }
    paramList = "<cmd>\n\t<diagnostic>\n\t\t<PthreadHook\n\t\t\tenable='1'\n\t\t\tmultiprocess='0'\n\t\t\tduration='1'\n\t\t\thook='.*\\.so$'\n\t\t\tthread='" + localStringBuilder.toString() + "'/>\n\t</diagnostic>\n</cmd>";
    com.tencent.mm.plugin.performance.a.a.wWa.aA(bx.M(paramList, "cmd"));
    AppMethodBeat.o(215480);
  }
  
  public static int eS(List<e.a> paramList)
  {
    AppMethodBeat.i(215485);
    Object localObject2 = new HashMap();
    Object localObject1 = Looper.getMainLooper().getThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[((ThreadGroup)localObject1).activeCount() * 2];
    int k = ((ThreadGroup)localObject1).enumerate(arrayOfThread);
    int j = 0;
    int i = 0;
    label143:
    if (j < k)
    {
      localObject1 = arrayOfThread[j].getName();
      if (bu.isNullOrNil((String)localObject1)) {
        break label269;
      }
      localObject1 = ((String)localObject1).replaceAll("[0-9]\\d*", "?");
      if (!((String)localObject1).contains("Binder:")) {
        break label266;
      }
      localObject1 = "Binder:?_?";
      label101:
      if (((Map)localObject2).containsKey(localObject1))
      {
        ((Map)localObject2).put(localObject1, Integer.valueOf(((Integer)((Map)localObject2).get(localObject1)).intValue() + 1));
        i += 1;
      }
    }
    label266:
    label269:
    for (;;)
    {
      j += 1;
      break;
      ((Map)localObject2).put(localObject1, Integer.valueOf(1));
      break label143;
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        paramList.add(new e.a((String)((Map.Entry)localObject2).getKey(), ((Integer)((Map.Entry)localObject2).getValue()).intValue()));
      }
      Collections.sort(paramList, new e.2());
      AppMethodBeat.o(215485);
      return i;
      break label101;
    }
  }
  
  private static String getStringFromFile(String paramString)
  {
    AppMethodBeat.i(215483);
    Object localObject1 = new k(paramString);
    paramString = null;
    try
    {
      localObject1 = o.ai((k)localObject1);
      paramString = (String)localObject1;
      String str = convertStreamToString((InputStream)localObject1);
      if (localObject1 != null) {
        ((InputStream)localObject1).close();
      }
      AppMethodBeat.o(215483);
      return str;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(215483);
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
    AppMethodBeat.i(215478);
    int i;
    long l;
    if (SystemClock.uptimeMillis() - this.xai >= 10000L)
    {
      this.xai = SystemClock.uptimeMillis();
      i = 1;
      if (i == 0) {
        break label552;
      }
      l = SystemClock.uptimeMillis();
      i = -1;
      if (!ak.coh()) {
        break label209;
      }
      i = 100;
    }
    for (;;)
    {
      label453:
      if (i != -1)
      {
        final int j;
        final int k;
        try
        {
          paramActivity = new LinkedList();
          j = Ja();
          k = eS(paramActivity);
          if (j <= 500) {
            break label240;
          }
          ae.i("MicroMsg.ThreadWatchDog", "trigger Over 500");
          paramActivity = aq(1, k, j);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 1, 1L, true);
          paramActivity = new RuntimeException("MicroMsg.ThreadWatchDog" + String.format("\nThreadOver[%s:%s]: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), paramActivity }));
          AppMethodBeat.o(215478);
          throw paramActivity;
        }
        finally
        {
          ae.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
          AppMethodBeat.o(215478);
        }
        i = 0;
        break;
        label209:
        if ((ak.foC()) || (ak.foD()))
        {
          i = 120;
        }
        else if (ak.isAppBrandProcess())
        {
          i = 140;
          continue;
          label240:
          if (j > 300)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i, 1L, true);
            if (j - this.xah >= 50)
            {
              this.xah = j;
              h.MqF.aO(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(215475);
                  ae.i("MicroMsg.ThreadWatchDog", "trigger Over 300");
                  e.ha(k, j);
                  AppMethodBeat.o(215475);
                }
              });
            }
            if (k <= 500) {
              break label453;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 4, 1L, true);
          }
          for (;;)
          {
            ae.w("MicroMsg.ThreadWatchDog", "[wang][%s:%s]:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(j), paramActivity.toString() });
            ae.i("MicroMsg.ThreadWatchDog", "[wang] Cost:%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l) });
            AppMethodBeat.o(215478);
            return;
            if (j > 200)
            {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 2, 1L, true);
              break;
            }
            if (j > 150)
            {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 3, 1L, true);
              break;
            }
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 8, 1L, true);
            break;
            if (k > 300) {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 5, 1L, true);
            } else if (k > 200) {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 6, 1L, true);
            } else if (k > 150) {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 7, 1L, true);
            } else {
              com.tencent.mm.plugin.report.e.ywz.idkeyStat(960L, i + 9, 1L, true);
            }
          }
        }
      }
    }
    label552:
    AppMethodBeat.o(215478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.e
 * JD-Core Version:    0.7.0.1
 */