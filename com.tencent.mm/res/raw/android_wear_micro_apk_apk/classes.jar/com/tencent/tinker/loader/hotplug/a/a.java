package com.tencent.tinker.loader.hotplug.a;

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
import android.os.Parcelable;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.hotplug.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class a
  implements com.tencent.tinker.loader.hotplug.b.h
{
  private static final int[] alw = { 16842840 };
  private static final int alx;
  private final Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 27) {}
    for (;;)
    {
      try
      {
        i = ((Integer)com.tencent.tinker.loader.a.h.a(ActivityManager.class, "INTENT_SENDER_ACTIVITY").get(null)).intValue();
        alx = i;
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i = 2;
        continue;
      }
      int i = 2;
    }
  }
  
  public a(Context paramContext)
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
  
  private Object a(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
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
        j(localIntent);
        paramArrayOfObject[i] = localIntent;
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      i += 1;
      break;
      i = -1;
    }
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
      localObject2 = ((Resources.Theme)localObject2).obtainStyledAttributes(alw);
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
    int j = 0;
    int i = 0;
    if (i < paramArrayOfObject.length) {
      if (!(paramArrayOfObject[i] instanceof Intent[])) {}
    }
    for (;;)
    {
      if ((i != -1) && (((Integer)paramArrayOfObject[0]).intValue() == alx))
      {
        Intent[] arrayOfIntent = (Intent[])paramArrayOfObject[i];
        i = j;
        for (;;)
        {
          if (i < arrayOfIntent.length)
          {
            Intent localIntent = new Intent(arrayOfIntent[i]);
            j(localIntent);
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
  
  private void j(Intent paramIntent)
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
      if (c.aa((String)localObject1))
      {
        Object localObject3 = c.ab((String)localObject1);
        boolean bool = a((ActivityInfo)localObject3);
        localObject3 = com.tencent.tinker.loader.hotplug.a.a((String)localObject1, ((ActivityInfo)localObject3).launchMode, bool);
        localObject1 = new ComponentName((String)localObject2, (String)localObject1);
        e.a(paramIntent, this.mContext.getClassLoader());
        paramIntent.putExtra("tinker_iek_old_component", (Parcelable)localObject1);
        paramIntent.setComponent(new ComponentName((String)localObject2, (String)localObject3));
      }
      return;
      localObject2 = this.mContext.getPackageManager().resolveActivity(paramIntent, 0);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = c.i(paramIntent);
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
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    int j = 0;
    Object localObject = paramMethod.getName();
    if ("startActivity".equals(localObject)) {
      return a(paramObject, paramMethod, paramArrayOfObject);
    }
    int i;
    if ("startActivities".equals(localObject))
    {
      i = 0;
      if (i >= paramArrayOfObject.length) {
        break label215;
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
            j(localIntent);
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
        return a(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("startActivityWithConfig".equals(localObject)) {
        return a(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("startActivityAsUser".equals(localObject)) {
        return a(paramObject, paramMethod, paramArrayOfObject);
      }
      if ("getIntentSender".equals(localObject)) {
        return b(paramObject, paramMethod, paramArrayOfObject);
      }
      return paramMethod.invoke(paramObject, paramArrayOfObject);
      label215:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.a.a
 * JD-Core Version:    0.7.0.1
 */