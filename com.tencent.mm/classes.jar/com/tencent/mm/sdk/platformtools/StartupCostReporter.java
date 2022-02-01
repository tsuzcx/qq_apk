package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.app.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressLint({"NewApi"})
public final class StartupCostReporter
{
  private static final Application.ActivityLifecycleCallbacks ACTIVITY_LIFECYCLE_CALLBACKS;
  private static final Application[] APPLICATION;
  private static final String CURRENT_PROCESS_NAME;
  private static final boolean[] HAS_MET_FIRST_UI;
  private static final int IDKEY_ID = 1557;
  private static final int IDKEY_KEY_APPBRAND_COLD_STARTUP_COST_TIMEOUT = 38;
  private static final int IDKEY_KEY_APPBRAND_WARM_STARTUP_COST_TIMEOUT = 39;
  private static final int IDKEY_KEY_CONCERNED_PROCESS_REPORT_COUNT = 31;
  private static final int IDKEY_KEY_INSTALL_FAILURE = 40;
  private static final int IDKEY_KEY_MM_COLD_STARTUP_COST_TIMEOUT = 32;
  private static final int IDKEY_KEY_MM_WARM_STARTUP_COST_TIMEOUT = 33;
  private static final int IDKEY_KEY_REPORT_COUNT = 30;
  private static final int IDKEY_KEY_TOOLSMP_COLD_STARTUP_COST_TIMEOUT = 36;
  private static final int IDKEY_KEY_TOOLSMP_WARM_STARTUP_COST_TIMEOUT = 37;
  private static final int IDKEY_KEY_TOOLS_COLD_STARTUP_COST_TIMEOUT = 34;
  private static final int IDKEY_KEY_TOOLS_WARM_STARTUP_COST_TIMEOUT = 35;
  private static final Set<String> IGNORED_ACTIVITIES;
  private static final Instrumentation[] INSTRUMENTATION;
  private static final String INTENT_KEY_CREATE_TS = "scr_key_create_timestamp";
  private static final boolean[] IS_COLD_START;
  private static final boolean[] IS_INSTALLED;
  private static final int KVSTAT_ID = 21381;
  private static final int KVSTAT_TYPEID_FIRST_UI_SHOWN_COLD = -268435455;
  private static final int KVSTAT_TYPEID_FIRST_UI_SHOWN_WARM = -268435454;
  private static final PeriodRecorder REPORT_PERIOD_LIMIT;
  private static final long[] STARTUP_BEGIN_TS;
  private static final String TAG = "MicroMsg.StartupCostReporter";
  
  static
  {
    AppMethodBeat.i(215454);
    CURRENT_PROCESS_NAME = d.cQi;
    REPORT_PERIOD_LIMIT = new PeriodRecorder("StartupCostReporter_kvstat", TimeUnit.HOURS.toMillis(1L), true, true);
    IGNORED_ACTIVITIES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "com.tencent.mm.splash.SplashHackActivity", "com.tencent.mm.app.WeChatSplashActivity" })));
    IS_INSTALLED = new boolean[] { false };
    STARTUP_BEGIN_TS = new long[] { -1L };
    HAS_MET_FIRST_UI = new boolean[] { false };
    APPLICATION = new Application[] { null };
    INSTRUMENTATION = new Instrumentation[] { null };
    IS_COLD_START = new boolean[] { false };
    ACTIVITY_LIFECYCLE_CALLBACKS = new Application.ActivityLifecycleCallbacks()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle arg2)
      {
        AppMethodBeat.i(215442);
        synchronized (StartupCostReporter.HAS_MET_FIRST_UI)
        {
          if (StartupCostReporter.HAS_MET_FIRST_UI[0] != 0)
          {
            AppMethodBeat.o(215442);
            return;
          }
          paramAnonymousActivity = paramAnonymousActivity.getIntent();
          if (paramAnonymousActivity != null) {
            paramAnonymousActivity.putExtra("scr_key_create_timestamp", System.currentTimeMillis());
          }
          AppMethodBeat.o(215442);
          return;
        }
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(final Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(215443);
        synchronized (StartupCostReporter.HAS_MET_FIRST_UI)
        {
          if (StartupCostReporter.HAS_MET_FIRST_UI[0] != 0)
          {
            AppMethodBeat.o(215443);
            return;
          }
          if (paramAnonymousActivity == null)
          {
            AppMethodBeat.o(215443);
            return;
          }
        }
        ??? = paramAnonymousActivity.getWindow();
        if (??? == null)
        {
          AppMethodBeat.o(215443);
          return;
        }
        ??? = ((Window)???).getDecorView();
        if (??? == null)
        {
          AppMethodBeat.o(215443);
          return;
        }
        ((View)???).addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          public void onViewAttachedToWindow(View paramAnonymous2View)
          {
            AppMethodBeat.i(215441);
            this.val$view.removeOnAttachStateChangeListener(this);
            StartupCostReporter.access$100(paramAnonymousActivity);
            AppMethodBeat.o(215441);
          }
          
          public void onViewDetachedFromWindow(View paramAnonymous2View) {}
        });
        AppMethodBeat.o(215443);
      }
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    };
    AppMethodBeat.o(215454);
  }
  
  private StartupCostReporter()
  {
    AppMethodBeat.i(215452);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(215452);
    throw localUnsupportedOperationException;
  }
  
  private static boolean currentProcessWillShowForegroundUI()
  {
    AppMethodBeat.i(215448);
    Object localObject = getApplication();
    if (localObject == null)
    {
      AppMethodBeat.o(215448);
      return false;
    }
    localObject = ((ActivityManager)((Application)localObject).getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(215448);
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((localRunningAppProcessInfo.uid == Process.myUid()) && (localRunningAppProcessInfo.pid == Process.myPid()) && (localRunningAppProcessInfo.importance == 100))
      {
        AppMethodBeat.o(215448);
        return true;
      }
    }
    AppMethodBeat.o(215448);
    return false;
  }
  
  private static void doCostReportOnDemand(int paramInt, long paramLong)
  {
    AppMethodBeat.i(215450);
    int i;
    ArrayList localArrayList;
    if (paramInt == -268435455)
    {
      i = 1;
      localArrayList = new ArrayList();
      localArrayList.add(new IDKey(1557, 30, 1));
      if (!MMApplicationContext.isMainProcess()) {
        break label153;
      }
      localArrayList.add(new IDKey(1557, 31, 1));
      if (i == 0) {
        break label118;
      }
      if (paramLong > 5000L)
      {
        localArrayList.add(new IDKey(1557, 32, 1));
        doFreqLimitedKVStatNumReport(paramInt, paramLong);
      }
    }
    label153:
    for (;;)
    {
      x.f(localArrayList);
      AppMethodBeat.o(215450);
      return;
      i = 0;
      break;
      label118:
      if (paramLong > 2000L)
      {
        localArrayList.add(new IDKey(1557, 33, 1));
        doFreqLimitedKVStatNumReport(paramInt, paramLong);
        continue;
        if (MMApplicationContext.isToolsProcess())
        {
          localArrayList.add(new IDKey(1557, 31, 1));
          if (i != 0)
          {
            if (paramLong > 5000L)
            {
              localArrayList.add(new IDKey(1557, 34, 1));
              doFreqLimitedKVStatNumReport(paramInt, paramLong);
            }
          }
          else if (paramLong > 2000L)
          {
            localArrayList.add(new IDKey(1557, 35, 1));
            doFreqLimitedKVStatNumReport(paramInt, paramLong);
          }
        }
        else if (MMApplicationContext.isToolsMpProcess())
        {
          localArrayList.add(new IDKey(1557, 31, 1));
          if (i != 0)
          {
            if (paramLong > 5000L)
            {
              localArrayList.add(new IDKey(1557, 36, 1));
              doFreqLimitedKVStatNumReport(paramInt, paramLong);
            }
          }
          else if (paramLong > 2000L)
          {
            localArrayList.add(new IDKey(1557, 37, 1));
            doFreqLimitedKVStatNumReport(paramInt, paramLong);
          }
        }
        else if (MMApplicationContext.isAppBrandProcess())
        {
          localArrayList.add(new IDKey(1557, 31, 1));
          if (i != 0)
          {
            if (paramLong > 5000L)
            {
              localArrayList.add(new IDKey(1557, 38, 1));
              doFreqLimitedKVStatNumReport(paramInt, paramLong);
            }
          }
          else if (paramLong > 2000L)
          {
            localArrayList.add(new IDKey(1557, 39, 1));
            doFreqLimitedKVStatNumReport(paramInt, paramLong);
          }
        }
      }
    }
  }
  
  private static void doFreqLimitedKVStatNumReport(int paramInt, long paramLong)
  {
    AppMethodBeat.i(215451);
    long l = paramInt & 0xFFFFFFFF;
    if (REPORT_PERIOD_LIMIT.isExpired("rpt_" + CURRENT_PROCESS_NAME + "_" + l))
    {
      x.a(21381, new Object[] { Long.valueOf(l), d.cQi, Long.valueOf(paramLong) });
      x.a("MicroMsg.StartupCostReporter", "[+] doKVStatNumReport, content: %s,%s,%s", new Object[] { Long.valueOf(l), CURRENT_PROCESS_NAME, Long.valueOf(paramLong) });
      AppMethodBeat.o(215451);
      return;
    }
    x.a("MicroMsg.StartupCostReporter", "[+] Hit report freq limit, skip reporting this time. content: %s,%s,%s", new Object[] { Long.valueOf(l), CURRENT_PROCESS_NAME, Long.valueOf(paramLong) });
    AppMethodBeat.o(215451);
  }
  
  private static Application getApplication()
  {
    synchronized (APPLICATION)
    {
      Application localApplication = APPLICATION[0];
      return localApplication;
    }
  }
  
  private static long getCostMsFromStartupBegin()
  {
    AppMethodBeat.i(215447);
    synchronized (STARTUP_BEGIN_TS)
    {
      long l1 = STARTUP_BEGIN_TS[0];
      if (l1 != -1L)
      {
        long l2 = System.currentTimeMillis();
        AppMethodBeat.o(215447);
        return l2 - l1;
      }
      AppMethodBeat.o(215447);
      return -1L;
    }
  }
  
  private static Instrumentation getInstrumentation(boolean paramBoolean)
  {
    AppMethodBeat.i(215445);
    synchronized (INSTRUMENTATION)
    {
      Object localObject1 = INSTRUMENTATION[0];
      if ((localObject1 == null) || (paramBoolean)) {}
      try
      {
        localObject1 = Class.forName("android.app.ActivityThread");
        Object localObject3 = ((Class)localObject1).getDeclaredMethod("currentActivityThread", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        localObject3 = ((Method)localObject3).invoke(null, new Object[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getInstrumentation", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        INSTRUMENTATION[0] = ((Instrumentation)((Method)localObject1).invoke(localObject3, new Object[0]));
        localObject1 = INSTRUMENTATION[0];
        AppMethodBeat.o(215445);
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          x.a("MicroMsg.StartupCostReporter", localThrowable, "[-] Fail to get instrumentation.", new Object[0]);
          INSTRUMENTATION[0] = null;
        }
      }
    }
  }
  
  public static void install(Application paramApplication)
  {
    AppMethodBeat.i(215444);
    synchronized (IS_INSTALLED)
    {
      if (isInstalled())
      {
        AppMethodBeat.o(215444);
        return;
      }
      try
      {
        setApplication(paramApplication);
        paramApplication.registerActivityLifecycleCallbacks(ACTIVITY_LIFECYCLE_CALLBACKS);
        IS_INSTALLED[0] = true;
        if ((IS_INSTALLED[0] == 0) && (REPORT_PERIOD_LIMIT.isExpired("idkey_install_failure_rpt"))) {
          x.WF();
        }
        AppMethodBeat.o(215444);
        return;
      }
      catch (Throwable paramApplication)
      {
        for (;;)
        {
          x.a("MicroMsg.StartupCostReporter", paramApplication, "[-] [%s] installed failed.", new Object[] { CURRENT_PROCESS_NAME });
          IS_INSTALLED[0] = false;
        }
      }
    }
  }
  
  private static boolean isCurrentProcessColdStartBefore()
  {
    synchronized (IS_COLD_START)
    {
      int i = IS_COLD_START[0];
      return i;
    }
  }
  
  private static boolean isInstalled()
  {
    synchronized (IS_INSTALLED)
    {
      int i = IS_INSTALLED[0];
      return i;
    }
  }
  
  private static void markCurrentProcessColdStart()
  {
    synchronized (IS_COLD_START)
    {
      IS_COLD_START[0] = true;
      return;
    }
  }
  
  public static void markStartupBegin()
  {
    AppMethodBeat.i(215446);
    if (!isInstalled())
    {
      AppMethodBeat.o(215446);
      return;
    }
    synchronized (STARTUP_BEGIN_TS)
    {
      STARTUP_BEGIN_TS[0] = System.currentTimeMillis();
      if (currentProcessWillShowForegroundUI()) {
        markCurrentProcessColdStart();
      }
      AppMethodBeat.o(215446);
      return;
    }
  }
  
  private static void reportDurationToFirstUIShown(Activity arg0)
  {
    AppMethodBeat.i(215449);
    if (!isInstalled())
    {
      AppMethodBeat.o(215449);
      return;
    }
    String str = ???.getClass().getName();
    if (IGNORED_ACTIVITIES.contains(str))
    {
      x.b("MicroMsg.StartupCostReporter", "[!] [%s] [%s] Ignored activity, skip this time.", new Object[] { CURRENT_PROCESS_NAME, str });
      AppMethodBeat.o(215449);
      return;
    }
    Intent localIntent = ???.getIntent();
    if (localIntent == null)
    {
      AppMethodBeat.o(215449);
      return;
    }
    for (;;)
    {
      synchronized (HAS_MET_FIRST_UI)
      {
        if (HAS_MET_FIRST_UI[0] != 0)
        {
          AppMethodBeat.o(215449);
          return;
        }
        boolean bool = isCurrentProcessColdStartBefore();
        l = localIntent.getLongExtra("scr_key_create_timestamp", -1L);
        localIntent.removeExtra("scr_key_create_timestamp");
        if (bool)
        {
          l = getCostMsFromStartupBegin();
          if (l < 0L)
          {
            x.b("MicroMsg.StartupCostReporter", "[!] [%s] Cost should not less than 0.", new Object[] { CURRENT_PROCESS_NAME });
            HAS_MET_FIRST_UI[0] = true;
            AppMethodBeat.o(215449);
          }
        }
        else
        {
          if (l < 0L) {
            break label291;
          }
          l = System.currentTimeMillis() - l;
          continue;
        }
        if (bool)
        {
          x.a("MicroMsg.StartupCostReporter", "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, cold-startup, cost: %s ms.", new Object[] { CURRENT_PROCESS_NAME, str, Long.valueOf(l) });
          doCostReportOnDemand(-268435455, l);
        }
      }
      x.a("MicroMsg.StartupCostReporter", "[+] [UI-Startup] [%s] First ui [%s] was shown, report now, warm-startup, cost: %s ms.", new Object[] { CURRENT_PROCESS_NAME, localObject, Long.valueOf(l) });
      doCostReportOnDemand(-268435454, l);
      continue;
      label291:
      long l = -1L;
    }
  }
  
  private static void setApplication(Application paramApplication)
  {
    synchronized (APPLICATION)
    {
      APPLICATION[0] = paramApplication;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.StartupCostReporter
 * JD-Core Version:    0.7.0.1
 */