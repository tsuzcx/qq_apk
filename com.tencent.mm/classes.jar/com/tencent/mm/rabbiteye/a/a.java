package com.tencent.mm.rabbiteye.a;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum a
{
  private a UOD;
  private boolean b;
  String c;
  public boolean e;
  
  static
  {
    AppMethodBeat.i(231818);
    UOB = new a("INSTANCE");
    UOC = new a[] { UOB };
    AppMethodBeat.o(231818);
  }
  
  private a()
  {
    AppMethodBeat.i(231810);
    this.b = false;
    this.c = "default";
    this.UOD = new a((byte)0);
    this.e = false;
    AppMethodBeat.o(231810);
  }
  
  public static String Vs()
  {
    AppMethodBeat.i(231813);
    System.currentTimeMillis();
    try
    {
      Object localObject3 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject3).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject3 = ((Class)localObject3).getDeclaredField("mActivities");
      ((Field)localObject3).setAccessible(true);
      if (Build.VERSION.SDK_INT < 19) {}
      for (localObject1 = (HashMap)((Field)localObject3).get(localObject1);; localObject1 = (ArrayMap)((Field)localObject3).get(localObject1))
      {
        int i = ((Map)localObject1).size();
        if (i > 0) {
          break;
        }
        return null;
      }
      localObject3 = ((Map)localObject1).values().iterator();
      Class localClass;
      boolean bool;
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((Iterator)localObject3).next();
        localClass = localObject1.getClass();
        Field localField = localClass.getDeclaredField("paused");
        localField.setAccessible(true);
        bool = localField.getBoolean(localObject1);
      } while (bool);
      localObject3 = localClass.getDeclaredField("activity");
      ((Field)localObject3).setAccessible(true);
      localObject1 = ((Activity)((Field)localObject3).get(localObject1)).getClass().getName();
      return localObject1;
    }
    catch (Exception localException)
    {
      return null;
    }
    finally
    {
      System.currentTimeMillis();
      AppMethodBeat.o(231813);
    }
  }
  
  private static boolean a()
  {
    AppMethodBeat.i(231815);
    try
    {
      Object localObject2 = Class.forName("android.app.ActivityThread");
      Object localObject1 = ((Class)localObject2).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
      localObject2 = ((Class)localObject2).getDeclaredField("mActivities");
      ((Field)localObject2).setAccessible(true);
      if (Build.VERSION.SDK_INT < 19) {}
      for (localObject1 = (HashMap)((Field)localObject2).get(localObject1);; localObject1 = (ArrayMap)((Field)localObject2).get(localObject1))
      {
        int i = ((Map)localObject1).size();
        if (i > 0) {
          break;
        }
        AppMethodBeat.o(231815);
        return false;
      }
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Object localObject3 = localObject2.getClass();
        localObject3 = ((Class)localObject3).getDeclaredField("paused");
        ((Field)localObject3).setAccessible(true);
        boolean bool = ((Field)localObject3).getBoolean(localObject2);
        if (!bool)
        {
          AppMethodBeat.o(231815);
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(231815);
    }
    return false;
  }
  
  public static boolean hpQ()
  {
    AppMethodBeat.i(231814);
    boolean bool = a();
    AppMethodBeat.o(231814);
    return bool;
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
  {
    private a()
    {
      AppMethodBeat.i(231781);
      AppMethodBeat.o(231781);
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(231784);
      a.a(a.this, paramActivity);
      a.a(a.this);
      AppMethodBeat.o(231784);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(231786);
      if (a.Vs() == null) {
        a.b(a.this);
      }
      AppMethodBeat.o(231786);
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory() {}
    
    public final void onTrimMemory(int paramInt)
    {
      AppMethodBeat.i(231798);
      if ((paramInt == 20) && (a.c(a.this)))
      {
        a locala = a.this;
        a.d(locala);
        a.b(locala);
      }
      AppMethodBeat.o(231798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.a.a
 * JD-Core Version:    0.7.0.1
 */