package com.tencent.tinker.loader.hotplug.handler;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.hotplug.ActivityStubManager;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AMSInterceptHandler
  implements ServiceBinderInterceptor.BinderInvocationHandler
{
  private static final int[] Buv = { 16842840 };
  private static final int Buw;
  private final Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 27) {}
    for (;;)
    {
      try
      {
        i = ((Integer)ShareReflectUtil.g(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
        Buw = i;
        return;
      }
      catch (Throwable localThrowable)
      {
        i = 2;
        continue;
      }
      int i = 2;
    }
  }
  
  public AMSInterceptHandler(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == null) {
        break;
      }
      paramContext = localContext;
    }
    this.mContext = paramContext;
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new ComponentName(paramString1, paramString2);
    ShareIntentUtil.a(paramIntent, this.mContext.getClassLoader());
    paramIntent.putExtra("tinker_iek_old_component", paramString2);
    paramIntent.setComponent(new ComponentName(paramString1, paramString3));
  }
  
  private boolean a(ActivityInfo paramActivityInfo)
  {
    boolean bool2 = false;
    int i = paramActivityInfo.getThemeResource();
    Object localObject2 = this.mContext.getResources().newTheme();
    ((Resources.Theme)localObject2).applyStyle(i, true);
    Object localObject1 = null;
    paramActivityInfo = null;
    try
    {
      localObject2 = ((Resources.Theme)localObject2).obtainStyledAttributes(Buv);
      paramActivityInfo = (ActivityInfo)localObject2;
      localObject1 = localObject2;
      boolean bool1 = ((TypedArray)localObject2).getBoolean(0, false);
      bool2 = bool1;
      if (localObject2 != null)
      {
        ((TypedArray)localObject2).recycle();
        bool2 = bool1;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    finally
    {
      if (localThrowable == null) {
        break label99;
      }
      localThrowable.recycle();
    }
    return bool2;
  }
  
  private Object b(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int i = 0;
    if (i < paramArrayOfObject.length) {
      if (!(paramArrayOfObject[i] instanceof Intent)) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        Intent localIntent = new Intent((Intent)paramArrayOfObject[i]);
        bb(localIntent);
        paramArrayOfObject[i] = localIntent;
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      i += 1;
      break;
      i = -1;
    }
  }
  
  private void bb(Intent paramIntent)
  {
    Object localObject2;
    Object localObject1;
    if (paramIntent.getComponent() != null)
    {
      localObject2 = paramIntent.getComponent().getPackageName();
      localObject1 = paramIntent.getComponent().getClassName();
    }
    for (;;)
    {
      if (IncrementComponentManager.awX((String)localObject1))
      {
        ActivityInfo localActivityInfo = IncrementComponentManager.awY((String)localObject1);
        boolean bool = a(localActivityInfo);
        a(paramIntent, (String)localObject2, (String)localObject1, ActivityStubManager.y((String)localObject1, localActivityInfo.launchMode, bool));
      }
      return;
      localObject2 = this.mContext.getPackageManager().resolveActivity(paramIntent, 0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = IncrementComponentManager.ba(paramIntent);
      }
      if ((localObject1 != null) && (((ResolveInfo)localObject1).filter != null) && (((ResolveInfo)localObject1).filter.hasCategory("android.intent.category.DEFAULT")))
      {
        localObject2 = ((ResolveInfo)localObject1).activityInfo.packageName;
        localObject1 = ((ResolveInfo)localObject1).activityInfo.name;
      }
      else
      {
        localObject1 = null;
        localObject2 = null;
      }
    }
  }
  
  private Object c(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int j = 0;
    int i = 0;
    if (i < paramArrayOfObject.length) {
      if (!(paramArrayOfObject[i] instanceof Intent[])) {}
    }
    for (;;)
    {
      if ((i != -1) && (((Integer)paramArrayOfObject[0]).intValue() == Buw))
      {
        Intent[] arrayOfIntent = (Intent[])paramArrayOfObject[i];
        i = j;
        for (;;)
        {
          if (i < arrayOfIntent.length)
          {
            Intent localIntent = new Intent(arrayOfIntent[i]);
            bb(localIntent);
            arrayOfIntent[i] = localIntent;
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      i = -1;
    }
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int j = 0;
    Object localObject = paramMethod.getName();
    if ("startActivity".equals(localObject)) {
      return b(paramObject, paramMethod, paramArrayOfObject);
    }
    int i;
    if ("startActivities".equals(localObject))
    {
      i = 0;
      if (i >= paramArrayOfObject.length) {
        break label218;
      }
      if (!(paramArrayOfObject[i] instanceof Intent[])) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localObject = (Intent[])paramArrayOfObject[i];
        i = j;
        for (;;)
        {
          if (i < localObject.length)
          {
            Intent localIntent = new Intent(localObject[i]);
            bb(localIntent);
            localObject[i] = localIntent;
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      if ("startActivityAndWait".equals(localObject)) {
        return b(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("startActivityWithConfig".equals(localObject)) {
        return b(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("startActivityAsUser".equals(localObject)) {
        return b(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("getIntentSender".equals(localObject)) {
        return c(paramObject, paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      label218:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler
 * JD-Core Version:    0.7.0.1
 */