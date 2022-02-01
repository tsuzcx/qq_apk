package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.Debug;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor
{
  private static final String ACTIVITY_CLASSNAME;
  private static final int MONITOR_TRIGGER_INTERVAL_MILLIS = 10000;
  private static final int RECONFIRM_CHECK_COUNT = 3;
  private static final String TAG = "MicroMsg.ListenerInstanceMonitor";
  private static volatile Class sClass_DoNotCheckLeakForActivities;
  private static volatile boolean sIsMonitorRunning;
  private static final Object sLock;
  private static Field sMContextField;
  private static final byte[] sMapGuard;
  private static final Map<Object, Set<HeldUIInfo>> sMarkedInstanceToHeldObjMap;
  private static volatile Method sMehtod_value;
  private static final Runnable sMonitorTask;
  private static MMHandler sMonitorThreadHandler;
  
  static
  {
    AppMethodBeat.i(125253);
    sMarkedInstanceToHeldObjMap = new WeakHashMap();
    sMapGuard = new byte[0];
    sMContextField = null;
    sMonitorThreadHandler = null;
    sIsMonitorRunning = false;
    ACTIVITY_CLASSNAME = Activity.class.getName();
    sMonitorTask = new Runnable()
    {
      private void doMonitorWorks()
      {
        AppMethodBeat.i(243612);
        synchronized (ListenerInstanceMonitor.sMapGuard)
        {
          if (ListenerInstanceMonitor.sMarkedInstanceToHeldObjMap.isEmpty())
          {
            Log.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: no listener or cb was added, skip rest logic.");
            AppMethodBeat.o(243612);
            return;
          }
          if (Debug.isDebuggerConnected())
          {
            Log.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.");
            AppMethodBeat.o(243612);
            return;
          }
        }
        Log.d("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: triggering gc...");
        try
        {
          Runtime.getRuntime().gc();
          Thread.sleep(100L);
          Runtime.getRuntime().runFinalization();
          for (;;)
          {
            Iterator localIterator2;
            Object localObject4;
            Object localObject5;
            Activity localActivity;
            synchronized (ListenerInstanceMonitor.sMapGuard)
            {
              Iterator localIterator1 = ListenerInstanceMonitor.sMarkedInstanceToHeldObjMap.entrySet().iterator();
              if (!localIterator1.hasNext()) {
                break;
              }
              localIterator2 = ((Set)((Map.Entry)localIterator1.next()).getValue()).iterator();
              if (!localIterator2.hasNext()) {
                continue;
              }
              localObject4 = (ListenerInstanceMonitor.HeldUIInfo)localIterator2.next();
              localObject5 = ((ListenerInstanceMonitor.HeldUIInfo)localObject4).sentinel.get();
              localActivity = (Activity)((ListenerInstanceMonitor.HeldUIInfo)localObject4).heldUIRef.get();
              if (localActivity == null)
              {
                Log.i("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: Ok, ui [%s] was recycled.", new Object[] { ((ListenerInstanceMonitor.HeldUIInfo)localObject4).heldUIClazz.getName() });
                localIterator2.remove();
              }
            }
            if ((isUIActuallyDestroyed(localActivity)) && (localObject5 == null)) {
              if (((ListenerInstanceMonitor.HeldUIInfo)localObject4).checkedCount > 3)
              {
                localIterator2.remove();
                if (WeChatEnvironment.hasDebugger()) {
                  break label390;
                }
                if (!WeChatEnvironment.isMonkeyEnv()) {
                  break label395;
                }
                break label390;
                localObject4 = new ListenerInstanceMonitor.ListenerLeakedException(((ListenerInstanceMonitor.HeldUIInfo)localObject4).describe(), ((ListenerInstanceMonitor.HeldUIInfo)localObject4).stacktrace);
                if (i != 0)
                {
                  AppMethodBeat.o(243612);
                  throw ((Throwable)localObject4);
                }
                Log.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", (Throwable)localObject4, "", new Object[0]);
              }
              else
              {
                ((ListenerInstanceMonitor.HeldUIInfo)localObject4).checkedCount += 1;
                Log.w("MicroMsg.ListenerInstanceMonitor", "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.", new Object[] { ((ListenerInstanceMonitor.HeldUIInfo)localObject4).heldUIClazz.getName(), Integer.valueOf(((ListenerInstanceMonitor.HeldUIInfo)localObject4).checkedCount) });
              }
            }
          }
          AppMethodBeat.o(243612);
          return;
        }
        finally
        {
          for (;;)
          {
            continue;
            label390:
            int i = 1;
            continue;
            label395:
            i = 0;
          }
        }
      }
      
      private boolean isUIActuallyDestroyed(Activity paramAnonymousActivity)
      {
        boolean bool1 = false;
        AppMethodBeat.i(243617);
        boolean bool2 = paramAnonymousActivity.isDestroyed();
        if (!bool2)
        {
          AppMethodBeat.o(243617);
          return false;
        }
        paramAnonymousActivity = Looper.getMainLooper().getThread().getStackTrace();
        int j = paramAnonymousActivity.length;
        int i = 0;
        if (i < j)
        {
          Object localObject = paramAnonymousActivity[i];
          if ((!ListenerInstanceMonitor.ACTIVITY_CLASSNAME.equals(localObject.getClassName())) || (!"performDestroy".equals(localObject.getMethodName()))) {}
        }
        for (;;)
        {
          AppMethodBeat.o(243617);
          return bool1;
          i += 1;
          break;
          bool1 = bool2;
        }
      }
      
      public void run()
      {
        AppMethodBeat.i(125239);
        synchronized (ListenerInstanceMonitor.sMonitorTask)
        {
          if (!ListenerInstanceMonitor.sIsMonitorRunning)
          {
            AppMethodBeat.o(125239);
            return;
          }
          doMonitorWorks();
        }
        synchronized (ListenerInstanceMonitor.sMonitorTask)
        {
          if (ListenerInstanceMonitor.sIsMonitorRunning) {
            ListenerInstanceMonitor.sMonitorThreadHandler.postDelayed(this, 10000L);
          }
          AppMethodBeat.o(125239);
          return;
          localObject1 = finally;
          AppMethodBeat.o(125239);
          throw localObject1;
        }
      }
    };
    if ((WeChatEnvironment.hasDebugger()) || (WeChatEnvironment.isMonkeyEnv())) {
      if (!MMApplicationContext.isMMProcess()) {}
    }
    for (;;)
    {
      try
      {
        Field localField = View.class.getDeclaredField("mContext");
        sMContextField = localField;
        localField.setAccessible(true);
        startMonitor();
        sClass_DoNotCheckLeakForActivities = null;
        sMehtod_value = null;
        sLock = new Object();
        AppMethodBeat.o(125253);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "init failed, keep disabled.", new Object[0]);
        continue;
      }
      Log.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
      continue;
      Log.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
    }
  }
  
  private static void addHeldObjInfo(Object paramObject, Activity paramActivity, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125251);
    Class localClass = null;
    int i;
    try
    {
      if (sClass_DoNotCheckLeakForActivities == null) {}
      for (;;)
      {
        int j;
        synchronized (sLock)
        {
          if (sClass_DoNotCheckLeakForActivities == null)
          {
            ??? = Class.forName("com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities");
            sClass_DoNotCheckLeakForActivities = (Class)???;
            sMehtod_value = ((Class)???).getDeclaredMethod("value", new Class[0]);
          }
          if (paramObject.getClass().isAnnotationPresent(sClass_DoNotCheckLeakForActivities))
          {
            ??? = paramObject.getClass().getAnnotation(sClass_DoNotCheckLeakForActivities);
            if (??? != null)
            {
              localClass = paramActivity.getClass();
              ??? = (Class[])sMehtod_value.invoke(???, new Object[0]);
              if ((??? == null) || (???.length <= 0)) {
                break label354;
              }
              j = ???.length;
              i = 0;
              if (i >= j) {
                break label380;
              }
              if (localClass.equals(???[i])) {
                break label354;
              }
              i += 1;
            }
          }
        }
        synchronized (sMapGuard)
        {
          do
          {
            localSet = (Set)sMarkedInstanceToHeldObjMap.get(paramObject);
            localObject2 = localSet;
            if (localSet == null)
            {
              localObject2 = new HashSet();
              sMarkedInstanceToHeldObjMap.put(paramObject, localObject2);
            }
            ((Set)localObject2).add(new HeldUIInfo(paramActivity, paramField, paramThrowable));
            AppMethodBeat.o(125251);
            return;
            ??? = paramObject.getClass().getDeclaredMethods();
            j = ???.length;
            i = 0;
            localObject2 = localSet;
            if (i >= j) {
              break;
            }
            localObject2 = ???[i];
            if (!((Method)localObject2).isAnnotationPresent(sClass_DoNotCheckLeakForActivities)) {
              break label371;
            }
            localObject2 = ((Method)localObject2).getAnnotation(sClass_DoNotCheckLeakForActivities);
            break;
          } while (i == 0);
          Log.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", new Object[] { paramActivity, paramObject });
          AppMethodBeat.o(125251);
          return;
          i = 1;
        }
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", localThrowable, "addHeldObjInfo", new Object[0]);
    }
    for (;;)
    {
      Set localSet;
      Object localObject2;
      label354:
      label371:
      i += 1;
      continue;
      label380:
      i = 0;
    }
  }
  
  public static void markInstanceRegistered(Object paramObject)
  {
    AppMethodBeat.i(125248);
    if (paramObject == null)
    {
      AppMethodBeat.o(125248);
      return;
    }
    Throwable localThrowable = new Throwable();
    Class localClass1 = paramObject.getClass();
    if (!Object.class.equals(localClass1))
    {
      if (Activity.class.isAssignableFrom(localClass1)) {
        processHeldActivity(paramObject, null, localThrowable);
      }
      for (;;)
      {
        localClass1 = localClass1.getSuperclass();
        break;
        if (!View.class.isAssignableFrom(localClass1)) {
          break label81;
        }
        processHeldView(paramObject, null, localThrowable);
      }
      label81:
      Field[] arrayOfField = localClass1.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      label93:
      Field localField;
      Class localClass2;
      if (i < j)
      {
        localField = arrayOfField[i];
        localClass2 = localField.getType();
        if (!Activity.class.isAssignableFrom(localClass2)) {
          break label136;
        }
        processHeldActivity(paramObject, localField, localThrowable);
      }
      for (;;)
      {
        i += 1;
        break label93;
        break;
        label136:
        if (View.class.isAssignableFrom(localClass2)) {
          processHeldView(paramObject, localField, localThrowable);
        }
      }
    }
    AppMethodBeat.o(125248);
  }
  
  public static void markInstanceUnregistered(Object paramObject)
  {
    AppMethodBeat.i(125252);
    if (paramObject == null)
    {
      AppMethodBeat.o(125252);
      return;
    }
    synchronized (sMapGuard)
    {
      sMarkedInstanceToHeldObjMap.remove(paramObject);
      AppMethodBeat.o(125252);
      return;
    }
  }
  
  private static void processHeldActivity(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125249);
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof Activity)) {
        localObject = (Activity)paramObject;
      }
    }
    for (;;)
    {
      addHeldObjInfo(paramObject, (Activity)localObject, paramField, paramThrowable);
      AppMethodBeat.o(125249);
      return;
      AppMethodBeat.o(125249);
      return;
      if (!paramField.isAccessible()) {
        paramField.setAccessible(true);
      }
      try
      {
        Activity localActivity = (Activity)paramField.get(paramObject);
        localObject = localActivity;
        if (localActivity == null) {}
      }
      finally
      {
        AppMethodBeat.o(125249);
      }
    }
  }
  
  private static void processHeldView(Object paramObject, Field paramField, Throwable paramThrowable)
  {
    AppMethodBeat.i(125250);
    Object localObject;
    if (paramField == null) {
      if ((paramObject instanceof View)) {
        localObject = (View)paramObject;
      }
    }
    for (;;)
    {
      try
      {
        localObject = sMContextField.get(localObject);
        if ((localObject instanceof Activity)) {
          addHeldObjInfo(paramObject, (Activity)localObject, paramField, paramThrowable);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(125250);
      }
      AppMethodBeat.o(125250);
      return;
      if (sMContextField == null)
      {
        AppMethodBeat.o(125250);
        return;
      }
      if (!paramField.isAccessible()) {
        paramField.setAccessible(true);
      }
      try
      {
        View localView = (View)paramField.get(paramObject);
        localObject = localView;
        if (localView != null) {}
      }
      finally
      {
        AppMethodBeat.o(125250);
        return;
      }
    }
  }
  
  public static void startMonitor()
  {
    AppMethodBeat.i(125247);
    synchronized (sMonitorTask)
    {
      if (!sIsMonitorRunning)
      {
        MMHandler localMMHandler = new MMHandler("ListenerInstanceMonitor");
        sMonitorThreadHandler = localMMHandler;
        localMMHandler.setLogging(false);
        sMonitorThreadHandler.postDelayed(sMonitorTask, 10000L);
        sIsMonitorRunning = true;
      }
      AppMethodBeat.o(125247);
      return;
    }
  }
  
  public static void stopMonitor()
  {
    AppMethodBeat.i(243461);
    synchronized (sMonitorTask)
    {
      if (sIsMonitorRunning)
      {
        sMonitorThreadHandler.removeCallbacks(sMonitorTask);
        sMonitorThreadHandler.quit();
        sMonitorThreadHandler = null;
        sIsMonitorRunning = false;
      }
      AppMethodBeat.o(243461);
      return;
    }
  }
  
  static class HeldUIInfo
  {
    int checkedCount;
    Class<?> heldUIClazz;
    WeakReference<Activity> heldUIRef;
    Field holderField;
    final WeakReference<Object> sentinel;
    Throwable stacktrace;
    
    HeldUIInfo(Activity paramActivity, Field paramField, Throwable paramThrowable)
    {
      AppMethodBeat.i(125240);
      this.sentinel = new WeakReference(new Object());
      this.heldUIRef = new WeakReference(paramActivity);
      this.heldUIClazz = paramActivity.getClass();
      this.holderField = paramField;
      this.stacktrace = paramThrowable;
      this.checkedCount = 0;
      AppMethodBeat.o(125240);
    }
    
    private String getHolderFieldDesc()
    {
      AppMethodBeat.i(125243);
      if (this.holderField == null)
      {
        AppMethodBeat.o(125243);
        return "#null#";
      }
      Object localObject = this.holderField.getDeclaringClass();
      if (!((Class)localObject).isAnonymousClass())
      {
        localObject = "field " + this.holderField.getName() + " defined in " + ((Class)localObject).getName();
        AppMethodBeat.o(125243);
        return localObject;
      }
      Type localType = ((Class)localObject).getGenericSuperclass();
      if (Object.class.equals(localType)) {
        localObject = localObject.getGenericInterfaces()[0];
      }
      for (;;)
      {
        localObject = "field " + this.holderField.getName() + " define in anonymous class of " + localObject.toString().replace('<', '#').replace('>', '#');
        AppMethodBeat.o(125243);
        return localObject;
        if (localType != null) {
          localObject = localType;
        }
      }
    }
    
    private String getStackTraceString()
    {
      AppMethodBeat.i(125242);
      Object localObject1 = new StringWriter();
      try
      {
        PrintWriter localPrintWriter = new PrintWriter((Writer)localObject1);
        Util.qualityClose(localPrintWriter);
      }
      finally
      {
        try
        {
          this.stacktrace.printStackTrace(localPrintWriter);
          Util.qualityClose(localPrintWriter);
          localObject1 = ((StringWriter)localObject1).toString();
          AppMethodBeat.o(125242);
          return localObject1;
        }
        finally {}
        localObject2 = finally;
        localPrintWriter = null;
      }
      AppMethodBeat.o(125242);
      throw localObject2;
    }
    
    public String describe()
    {
      AppMethodBeat.i(243662);
      if (this.heldUIRef.get() == null)
      {
        if (this.holderField != null)
        {
          str = "ui of class [" + this.heldUIClazz.getName() + "] held by\n [" + getHolderFieldDesc() + "] is recycled";
          AppMethodBeat.o(243662);
          return str;
        }
        str = "ui of class [" + this.heldUIClazz.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
        AppMethodBeat.o(243662);
        return str;
      }
      if (this.holderField != null)
      {
        str = "ui of class [" + this.heldUIClazz.getName() + "] held by\n [" + getHolderFieldDesc() + "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
        AppMethodBeat.o(243662);
        return str;
      }
      String str = "ui of class [" + this.heldUIClazz.getName() + "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
      AppMethodBeat.o(243662);
      return str;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(125245);
      if ((paramObject == null) || (!(paramObject instanceof HeldUIInfo)))
      {
        AppMethodBeat.o(125245);
        return false;
      }
      paramObject = (HeldUIInfo)paramObject;
      Object localObject1 = this.heldUIRef.get();
      Object localObject2 = paramObject.heldUIRef.get();
      boolean bool1;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(125245);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = localObject1.equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.holderField;
      localObject2 = paramObject.holderField;
      if ((localObject1 == null) && (localObject2 == null)) {
        bool1 = true;
      }
      while (!bool1)
      {
        AppMethodBeat.o(125245);
        return false;
        if ((localObject1 != null) && (localObject2 != null)) {
          bool1 = ((Field)localObject1).equals(localObject2);
        } else {
          bool1 = false;
        }
      }
      localObject1 = this.stacktrace;
      paramObject = paramObject.stacktrace;
      if ((localObject1 == null) && (paramObject == null)) {
        bool1 = bool2;
      }
      for (;;)
      {
        AppMethodBeat.o(125245);
        return bool1;
        if ((localObject1 != null) && (paramObject != null)) {
          bool1 = localObject1.equals(paramObject);
        } else {
          bool1 = false;
        }
      }
    }
    
    public int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(125244);
      Object localObject = this.heldUIRef.get();
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        if (this.holderField == null) {
          break label73;
        }
      }
      label73:
      for (int j = this.holderField.hashCode();; j = 0)
      {
        if (this.stacktrace != null) {
          k = this.stacktrace.hashCode();
        }
        AppMethodBeat.o(125244);
        return i + j + k;
        i = 0;
        break;
      }
    }
    
    public String toString()
    {
      AppMethodBeat.i(125241);
      String str = getHolderFieldDesc() + "@" + getStackTraceString().replace('\n', '|');
      AppMethodBeat.o(125241);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor
 * JD-Core Version:    0.7.0.1
 */