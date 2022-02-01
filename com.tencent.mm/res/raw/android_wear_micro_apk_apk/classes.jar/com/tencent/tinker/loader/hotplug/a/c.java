package com.tencent.tinker.loader.hotplug.a;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import com.tencent.tinker.loader.hotplug.b.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class c
  implements h
{
  private static Object c(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    for (;;)
    {
      int i;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
        if (paramObject == null) {
          break label184;
        }
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        paramMethod = paramObject.getTargetException();
        if ((arrayOfClass == null) || (arrayOfClass.length <= 0)) {
          continue;
        }
        if (paramMethod == null) {
          continue;
        }
        throw paramMethod;
        paramMethod = paramObject;
        continue;
        if (paramMethod == null) {
          continue;
        }
        Log.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", paramMethod);
        return null;
        paramMethod = paramObject;
        continue;
      }
      catch (Throwable paramObject)
      {
        Log.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", paramObject);
        return null;
      }
      if (i < paramArrayOfObject.length)
      {
        if ((paramArrayOfObject[i] instanceof ComponentName))
        {
          Log.i("Tinker.PMSIntrcptHndlr", "locate componentName field of " + paramMethod.getName() + " done at idx: " + i);
          paramObject = (ComponentName)paramArrayOfObject[i];
          if (paramObject != null) {
            return com.tencent.tinker.loader.hotplug.c.af(paramObject.getClassName());
          }
          Log.w("Tinker.PMSIntrcptHndlr", "failed to locate componentName field of " + paramMethod.getName() + ", notice any crashes or mistakes after resolve works.");
          return null;
        }
      }
      else
      {
        paramObject = null;
        continue;
        label184:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  private static Object d(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    for (;;)
    {
      int i;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
        if (paramObject != null) {
          return paramObject;
        }
        Log.w("Tinker.PMSIntrcptHndlr", "failed to resolve activity in base package, try again in patch package.");
        i = 0;
        if (i < paramArrayOfObject.length)
        {
          if (!(paramArrayOfObject[i] instanceof Intent)) {
            break label191;
          }
          Log.i("Tinker.PMSIntrcptHndlr", "locate intent field of " + paramMethod.getName() + " done at idx: " + i);
          paramObject = (Intent)paramArrayOfObject[i];
          if (paramObject != null) {
            return com.tencent.tinker.loader.hotplug.c.k(paramObject);
          }
          Log.w("Tinker.PMSIntrcptHndlr", "failed to locate intent field of " + paramMethod.getName() + ", notice any crashes or mistakes after resolve works.");
          return null;
        }
      }
      catch (InvocationTargetException paramObject)
      {
        paramMethod = paramObject.getTargetException();
        if ((arrayOfClass != null) && (arrayOfClass.length > 0))
        {
          if (paramMethod != null) {
            throw paramMethod;
          }
          paramMethod = paramObject;
          continue;
        }
        if (paramMethod != null)
        {
          Log.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", paramMethod);
          return null;
        }
        paramMethod = paramObject;
        continue;
      }
      catch (Throwable paramObject)
      {
        Log.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", paramObject);
        return null;
      }
      paramObject = null;
      continue;
      label191:
      i += 1;
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    if ("getActivityInfo".equals(str)) {
      return c(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("resolveIntent".equals(str)) {
      return d(paramObject, paramMethod, paramArrayOfObject);
    }
    return paramMethod.invoke(paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.a.c
 * JD-Core Version:    0.7.0.1
 */