package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PMSInterceptHandler
  implements ServiceBinderInterceptor.BinderInvocationHandler
{
  private static Object d(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    for (;;)
    {
      int i;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
        if (paramObject == null) {
          break label141;
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
        paramObject = paramMethod;
        throw paramObject;
        continue;
        return null;
      }
      catch (Throwable paramObject)
      {
        return null;
      }
      if (i < paramArrayOfObject.length)
      {
        if ((paramArrayOfObject[i] instanceof ComponentName))
        {
          new StringBuilder("locate componentName field of ").append(paramMethod.getName()).append(" done at idx: ").append(i);
          paramObject = (ComponentName)paramArrayOfObject[i];
          if (paramObject != null) {
            return IncrementComponentManager.awY(paramObject.getClassName());
          }
          new StringBuilder("failed to locate componentName field of ").append(paramMethod.getName()).append(", notice any crashes or mistakes after resolve works.");
          return null;
        }
      }
      else
      {
        paramObject = null;
        continue;
        label141:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  private static Object e(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    for (;;)
    {
      int i;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
        if (paramObject == null) {
          break label138;
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
        paramObject = paramMethod;
        throw paramObject;
        continue;
        return null;
      }
      catch (Throwable paramObject)
      {
        return null;
      }
      if (i < paramArrayOfObject.length)
      {
        if ((paramArrayOfObject[i] instanceof Intent))
        {
          new StringBuilder("locate intent field of ").append(paramMethod.getName()).append(" done at idx: ").append(i);
          paramObject = (Intent)paramArrayOfObject[i];
          if (paramObject != null) {
            return IncrementComponentManager.ba(paramObject);
          }
          new StringBuilder("failed to locate intent field of ").append(paramMethod.getName()).append(", notice any crashes or mistakes after resolve works.");
          return null;
        }
      }
      else
      {
        paramObject = null;
        continue;
        label138:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    if ("getActivityInfo".equals(str)) {
      return d(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("resolveIntent".equals(str)) {
      return e(paramObject, paramMethod, paramArrayOfObject);
    }
    return paramMethod.invoke(paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler
 * JD-Core Version:    0.7.0.1
 */