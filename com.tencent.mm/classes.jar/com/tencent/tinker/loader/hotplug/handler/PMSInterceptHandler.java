package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PMSInterceptHandler
  implements ServiceBinderInterceptor.BinderInvocationHandler
{
  private static final String TAG = "Tinker.PMSIntrcptHndlr";
  
  private Object handleGetActivityInfo(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Class[] arrayOfClass = paramMethod.getExceptionTypes();
    for (;;)
    {
      int i;
      try
      {
        paramObject = paramMethod.invoke(paramObject, paramArrayOfObject);
        if (paramObject == null) {
          break label206;
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
        ShareTinkerLog.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", new Object[] { paramMethod });
        return null;
        paramMethod = paramObject;
        continue;
      }
      catch (Throwable paramObject)
      {
        ShareTinkerLog.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", new Object[] { paramObject });
        return null;
      }
      if (i < paramArrayOfObject.length)
      {
        if ((paramArrayOfObject[i] instanceof ComponentName))
        {
          ShareTinkerLog.i("Tinker.PMSIntrcptHndlr", "locate componentName field of " + paramMethod.getName() + " done at idx: " + i, new Object[0]);
          paramObject = (ComponentName)paramArrayOfObject[i];
          if (paramObject != null) {
            return IncrementComponentManager.queryActivityInfo(paramObject.getClassName());
          }
          ShareTinkerLog.w("Tinker.PMSIntrcptHndlr", "failed to locate componentName field of " + paramMethod.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
          return null;
        }
      }
      else
      {
        paramObject = null;
        continue;
        label206:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  private Object handleResolveIntent(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
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
        ShareTinkerLog.w("Tinker.PMSIntrcptHndlr", "failed to resolve activity in base package, try again in patch package.", new Object[0]);
        i = 0;
        if (i < paramArrayOfObject.length)
        {
          if (!(paramArrayOfObject[i] instanceof Intent)) {
            break label217;
          }
          ShareTinkerLog.i("Tinker.PMSIntrcptHndlr", "locate intent field of " + paramMethod.getName() + " done at idx: " + i, new Object[0]);
          paramObject = (Intent)paramArrayOfObject[i];
          if (paramObject != null) {
            return IncrementComponentManager.resolveIntent(paramObject);
          }
          ShareTinkerLog.w("Tinker.PMSIntrcptHndlr", "failed to locate intent field of " + paramMethod.getName() + ", notice any crashes or mistakes after resolve works.", new Object[0]);
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
          ShareTinkerLog.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", new Object[] { paramMethod });
          return null;
        }
        paramMethod = paramObject;
        continue;
      }
      catch (Throwable paramObject)
      {
        ShareTinkerLog.e("Tinker.PMSIntrcptHndlr", "unexpected exception.", new Object[] { paramObject });
        return null;
      }
      paramObject = null;
      continue;
      label217:
      i += 1;
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    if ("getActivityInfo".equals(str)) {
      return handleGetActivityInfo(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("resolveIntent".equals(str)) {
      return handleResolveIntent(paramObject, paramMethod, paramArrayOfObject);
    }
    return paramMethod.invoke(paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler
 * JD-Core Version:    0.7.0.1
 */