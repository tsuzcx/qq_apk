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
  private static final int INTENT_SENDER_ACTIVITY;
  private static final String TAG = "Tinker.AMSIntrcptHndlr";
  private static final int[] TRANSLUCENT_ATTR_ID = { 16842840 };
  private final Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 27) {}
    for (;;)
    {
      try
      {
        i = ((Integer)ShareReflectUtil.findField(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
        INTENT_SENDER_ACTIVITY = i;
        return;
      }
      finally
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
  
  private Object handleGetIntentSender(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int j = 0;
    int i = 0;
    if (i < paramArrayOfObject.length) {
      if (!(paramArrayOfObject[i] instanceof Intent[])) {}
    }
    for (;;)
    {
      if ((i != -1) && (((Integer)paramArrayOfObject[0]).intValue() == INTENT_SENDER_ACTIVITY))
      {
        Intent[] arrayOfIntent = (Intent[])paramArrayOfObject[i];
        i = j;
        for (;;)
        {
          if (i < arrayOfIntent.length)
          {
            Intent localIntent = new Intent(arrayOfIntent[i]);
            processActivityIntent(localIntent);
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
  
  private Object handleStartActivities(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int j = 0;
    int i = 0;
    if (i < paramArrayOfObject.length) {
      if (!(paramArrayOfObject[i] instanceof Intent[])) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        Intent[] arrayOfIntent = (Intent[])paramArrayOfObject[i];
        i = j;
        for (;;)
        {
          if (i < arrayOfIntent.length)
          {
            Intent localIntent = new Intent(arrayOfIntent[i]);
            processActivityIntent(localIntent);
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
  
  private Object handleStartActivity(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
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
        processActivityIntent(localIntent);
        paramArrayOfObject[i] = localIntent;
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      i += 1;
      break;
      i = -1;
    }
  }
  
  private boolean hasTransparentTheme(ActivityInfo paramActivityInfo)
  {
    boolean bool2 = false;
    int i = paramActivityInfo.getThemeResource();
    Object localObject1 = this.mContext.getResources().newTheme();
    ((Resources.Theme)localObject1).applyStyle(i, true);
    paramActivityInfo = null;
    try
    {
      localObject1 = ((Resources.Theme)localObject1).obtainStyledAttributes(TRANSLUCENT_ATTR_ID);
      paramActivityInfo = (ActivityInfo)localObject1;
      boolean bool1 = ((TypedArray)localObject1).getBoolean(0, false);
      bool2 = bool1;
      if (localObject1 != null)
      {
        ((TypedArray)localObject1).recycle();
        bool2 = bool1;
      }
    }
    finally
    {
      while (paramActivityInfo == null) {}
      paramActivityInfo.recycle();
    }
    return bool2;
    return false;
  }
  
  private void processActivityIntent(Intent paramIntent)
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
      if (IncrementComponentManager.isIncrementActivity((String)localObject1))
      {
        ActivityInfo localActivityInfo = IncrementComponentManager.queryActivityInfo((String)localObject1);
        boolean bool = hasTransparentTheme(localActivityInfo);
        storeAndReplaceOriginalComponentName(paramIntent, (String)localObject2, (String)localObject1, ActivityStubManager.assignStub((String)localObject1, localActivityInfo.launchMode, bool));
      }
      return;
      localObject2 = this.mContext.getPackageManager().resolveActivity(paramIntent, 0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = IncrementComponentManager.resolveIntent(paramIntent);
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
  
  private void storeAndReplaceOriginalComponentName(Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new ComponentName(paramString1, paramString2);
    ShareIntentUtil.fixIntentClassLoader(paramIntent, this.mContext.getClassLoader());
    paramIntent.putExtra("tinker_iek_old_component", paramString2);
    paramIntent.setComponent(new ComponentName(paramString1, paramString3));
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    if ("startActivity".equals(str)) {
      return handleStartActivity(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("startActivities".equals(str)) {
      return handleStartActivities(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("startActivityAndWait".equals(str)) {
      return handleStartActivity(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("startActivityWithConfig".equals(str)) {
      return handleStartActivity(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("startActivityAsUser".equals(str)) {
      return handleStartActivity(paramObject, paramMethod, paramArrayOfObject);
    }
    if ("getIntentSender".equals(str)) {
      return handleGetIntentSender(paramObject, paramMethod, paramArrayOfObject);
    }
    return paramMethod.invoke(paramObject, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler
 * JD-Core Version:    0.7.0.1
 */