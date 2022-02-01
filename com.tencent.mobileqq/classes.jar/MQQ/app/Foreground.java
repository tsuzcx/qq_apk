package mqq.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Foreground
  implements Handler.Callback
{
  private static final int DELAY_BROADCAST = 100;
  public static final String EVENT_TIME = "event_time";
  public static final int FROM_OTHER = 0;
  public static final int FROM_PAUSE_BEFORE_CALL_SUPER = 4;
  public static final int FROM_RESUME_BEFORE_CALL_SUPER = 3;
  public static final int FROM_START_BEFORE_CALL_SUPER = 1;
  public static final int FROM_STOP_BEFORE_CALL_SUPER = 2;
  private static final int MSG_BACK = 0;
  private static final int MSG_FORE = 1;
  public static final String TAG = "ApplicationLife";
  private static Foreground.ForegroundActivityLifecycleCallbacks sCallbacks;
  private static Context sContext;
  public static AtomicInteger sCountActivity = new AtomicInteger(0);
  public static AtomicInteger sCountResume = new AtomicInteger(0);
  private static Handler sHandler;
  private static String sProcessName;
  private static WeakReference<Activity> sTopActivity;
  
  public static void addActivityLifeCallback(QActivityLifecycleCallbacks paramQActivityLifecycleCallbacks)
  {
    try
    {
      if (sCallbacks != null) {
        sCallbacks.addActivityLifecycleCallbacks(paramQActivityLifecycleCallbacks);
      }
      return;
    }
    finally
    {
      paramQActivityLifecycleCallbacks = finally;
      throw paramQActivityLifecycleCallbacks;
    }
  }
  
  public static int getActivityCount()
  {
    return sCountActivity.get();
  }
  
  public static int getActivityCountFromLifecycle(int paramInt)
  {
    if (paramInt == 2) {
      return sCountActivity.get() - 1;
    }
    if (paramInt == 1) {
      return sCountActivity.get() + 1;
    }
    return sCountActivity.get();
  }
  
  public static int getResumeActivityCount()
  {
    return sCountResume.get();
  }
  
  public static int getResumeActivityCountFromLifecycle(int paramInt)
  {
    if (paramInt == 4) {
      return sCountResume.get() - 1;
    }
    if (paramInt == 3) {
      return sCountResume.get() + 1;
    }
    return sCountResume.get();
  }
  
  public static Activity getTopActivity()
  {
    WeakReference localWeakReference = sTopActivity;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public static void init(Context paramContext, Looper paramLooper, String paramString)
  {
    if (sHandler == null) {
      try
      {
        if (sHandler == null)
        {
          sContext = paramContext;
          sProcessName = paramString;
          sHandler = new Handler(paramLooper, new Foreground());
        }
      }
      finally {}
    }
    if (sCallbacks == null)
    {
      sCallbacks = new Foreground.ForegroundActivityLifecycleCallbacks();
      ((Application)paramContext).registerActivityLifecycleCallbacks(sCallbacks);
    }
  }
  
  public static boolean isCurrentProcessForeground()
  {
    return getActivityCount() > 0;
  }
  
  private static void onCreate(Activity paramActivity) {}
  
  private static void onDestroy(Activity paramActivity) {}
  
  private static void onPause(AppRuntime paramAppRuntime)
  {
    if ((sCountResume.decrementAndGet() <= 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackgroundPause = true;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext()) {
        ((AppRuntime)localIterator.next()).isBackgroundPause = paramAppRuntime.isBackgroundPause;
      }
      paramAppRuntime.onProcPause();
    }
  }
  
  private static void onResume(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.equals(getTopActivity()))) {
      sTopActivity = new WeakReference(paramActivity);
    }
    if ((sCountResume.incrementAndGet() > 0) && (paramAppRuntime != null))
    {
      paramAppRuntime.isBackgroundPause = false;
      paramActivity = paramAppRuntime.subRuntimeMap.values().iterator();
      while (paramActivity.hasNext()) {
        ((AppRuntime)paramActivity.next()).isBackgroundPause = paramAppRuntime.isBackgroundPause;
      }
      paramAppRuntime.onProcResume();
    }
  }
  
  private static void onStart(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    sTopActivity = new WeakReference(paramActivity);
    sCountActivity.incrementAndGet();
    if ((getActivityCount() == 1) || (getActivityCount() == 2))
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramAppRuntime);
      sCallbacks.onProcessForeground();
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
    }
  }
  
  private static void onStop(AppRuntime paramAppRuntime)
  {
    QLog.d("ApplicationLife", 1, new Object[] { "[process] onStop: invoked. ", " sCountActivity: ", Integer.valueOf(getActivityCount()) });
    if (sCountActivity.decrementAndGet() == 0)
    {
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(l & 0xFFFFFFFF), paramAppRuntime);
      sHandler.sendMessageDelayed(paramAppRuntime, 100L);
      sCallbacks.onProcessBackground();
      QLog.d("ApplicationLife", 1, new Object[] { "[process] onStop: invoked. send MSG_BACK", " sCountActivity: ", Integer.valueOf(getActivityCount()) });
    }
  }
  
  public static void removeActivityLifeCallback(QActivityLifecycleCallbacks paramQActivityLifecycleCallbacks)
  {
    try
    {
      if (sCallbacks != null) {
        sCallbacks.removeActivityLifecycleCallbacks(paramQActivityLifecycleCallbacks);
      }
      return;
    }
    finally
    {
      paramQActivityLifecycleCallbacks = finally;
      throw paramQActivityLifecycleCallbacks;
    }
  }
  
  public static void setReady()
  {
    if (getActivityCount() > 0)
    {
      l = SystemClock.uptimeMillis();
      localMessage = sHandler.obtainMessage(1, (int)(l >>> 32), (int)(0xFFFFFFFF & l), null);
      sHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    long l = SystemClock.uptimeMillis();
    Message localMessage = sHandler.obtainMessage(0, (int)(l >>> 32), (int)(0xFFFFFFFF & l), null);
    sHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public static void updateRuntimeState(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      int i = getResumeActivityCount();
      boolean bool2 = true;
      boolean bool1;
      if (i <= 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramAppRuntime.isBackgroundPause = bool1;
      if (getActivityCount() <= 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramAppRuntime.isBackgroundStop = bool1;
      Iterator localIterator = paramAppRuntime.subRuntimeMap.values().iterator();
      while (localIterator.hasNext())
      {
        AppRuntime localAppRuntime = (AppRuntime)localIterator.next();
        localAppRuntime.isBackgroundPause = paramAppRuntime.isBackgroundPause;
        localAppRuntime.isBackgroundStop = paramAppRuntime.isBackgroundStop;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppRuntime localAppRuntime = (AppRuntime)paramMessage.obj;
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", ");
      localStringBuilder.append(sProcessName);
      localStringBuilder.append(", ");
      localStringBuilder.append(l);
      localStringBuilder.append(", ");
      localStringBuilder.append(getActivityCount());
      localStringBuilder.append(", rt = ");
      localStringBuilder.append(localAppRuntime);
      QLog.i("mqq", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      if (getActivityCount() > 0)
      {
        if ((localAppRuntime != null) && (localAppRuntime.isBackgroundStop))
        {
          localAppRuntime.onRunningForeground();
          paramMessage = localAppRuntime.subRuntimeMap.values().iterator();
          while (paramMessage.hasNext()) {
            ((AppRuntime)paramMessage.next()).onRunningForeground();
          }
        }
        paramMessage = new Intent("com.tencent.process.starting");
        paramMessage.putExtra("runningProcessName", sProcessName);
        paramMessage.putExtra("runningtime", l);
        paramMessage.putExtra("event_time", System.currentTimeMillis());
        sContext.sendBroadcast(paramMessage);
        QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. send starting", " sProcessName: ", sProcessName });
      }
    }
    QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. ", " sCountActivity: ", Integer.valueOf(getActivityCount()) });
    if (getActivityCount() == 0) {
      if (localAppRuntime != null)
      {
        localAppRuntime.onRunningBackground();
        paramMessage = localAppRuntime.subRuntimeMap.values().iterator();
        while (paramMessage.hasNext()) {
          ((AppRuntime)paramMessage.next()).onRunningBackground();
        }
      }
    }
    try
    {
      paramMessage = new Intent("com.tencent.process.stopping");
      paramMessage.putExtra("runningProcessName", sProcessName);
      paramMessage.putExtra("runningtime", l);
      paramMessage.putExtra("event_time", System.currentTimeMillis());
      sContext.sendBroadcast(paramMessage);
      QLog.d("ApplicationLife", 1, new Object[] { "[process] handleMessage: invoked. send stopping", " sProcessName: ", sProcessName });
      return true;
    }
    catch (Exception paramMessage) {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.Foreground
 * JD-Core Version:    0.7.0.1
 */