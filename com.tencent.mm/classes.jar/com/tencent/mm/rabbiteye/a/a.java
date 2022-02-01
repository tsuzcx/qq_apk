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
  private a NBa;
  private boolean b;
  String c;
  public boolean e;
  
  static
  {
    AppMethodBeat.i(186314);
    NAY = new a("INSTANCE");
    NAZ = new a[] { NAY };
    AppMethodBeat.o(186314);
  }
  
  private a()
  {
    AppMethodBeat.i(186309);
    this.b = false;
    this.c = "default";
    this.NBa = new a((byte)0);
    this.e = false;
    AppMethodBeat.o(186309);
  }
  
  public static String RF()
  {
    AppMethodBeat.i(186310);
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
      AppMethodBeat.o(186310);
    }
  }
  
  private static boolean a()
  {
    AppMethodBeat.i(186312);
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
        return false;
      }
      localObject1 = ((Map)localObject1).values().iterator();
      boolean bool;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = ((Iterator)localObject1).next();
        Object localObject4 = localObject3.getClass();
        localObject4 = ((Class)localObject4).getDeclaredField("paused");
        ((Field)localObject4).setAccessible(true);
        bool = ((Field)localObject4).getBoolean(localObject3);
      } while (bool);
      return true;
    }
    catch (Exception localException)
    {
      return false;
    }
    finally
    {
      AppMethodBeat.o(186312);
    }
  }
  
  public static boolean gus()
  {
    AppMethodBeat.i(186311);
    boolean bool = a();
    AppMethodBeat.o(186311);
    return bool;
  }
  
  final class a
    implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
  {
    private a()
    {
      AppMethodBeat.i(186303);
      AppMethodBeat.o(186303);
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity) {}
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity) {}
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(186304);
      a.a(a.this, paramActivity);
      a.a(a.this);
      AppMethodBeat.o(186304);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(186305);
      if (a.RF() == null) {
        a.b(a.this);
      }
      AppMethodBeat.o(186305);
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration) {}
    
    public final void onLowMemory() {}
    
    public final void onTrimMemory(int paramInt)
    {
      AppMethodBeat.i(186306);
      if ((paramInt == 20) && (a.c(a.this)))
      {
        a locala = a.this;
        a.d(locala);
        a.b(locala);
      }
      AppMethodBeat.o(186306);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.a.a
 * JD-Core Version:    0.7.0.1
 */