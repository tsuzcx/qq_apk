package com.tencent.tinker.loader.hotplug.interceptor;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class TinkerHackInstrumentation
  extends Instrumentation
{
  public final Instrumentation BuL;
  public final Object BuM;
  public final Field BuN;
  
  private TinkerHackInstrumentation(Instrumentation paramInstrumentation, Object paramObject, Field paramField)
  {
    this.BuL = paramInstrumentation;
    this.BuM = paramObject;
    this.BuN = paramField;
    try
    {
      a(paramInstrumentation);
      return;
    }
    catch (Throwable paramInstrumentation)
    {
      throw new TinkerRuntimeException(paramInstrumentation.getMessage(), paramInstrumentation);
    }
  }
  
  private static void a(Activity paramActivity, ActivityInfo paramActivityInfo)
  {
    paramActivity.setRequestedOrientation(paramActivityInfo.screenOrientation);
    paramActivity.setTheme(paramActivityInfo.theme);
    try
    {
      ShareReflectUtil.b(paramActivity, "mActivityInfo").set(paramActivity, paramActivityInfo);
      return;
    }
    catch (Throwable paramActivity)
    {
      throw new TinkerRuntimeException("see next stacktrace.", paramActivity);
    }
  }
  
  private void a(Instrumentation paramInstrumentation)
  {
    Field[] arrayOfField = Instrumentation.class.getDeclaredFields();
    int i = 0;
    while (i < arrayOfField.length)
    {
      arrayOfField[i].setAccessible(true);
      Object localObject = arrayOfField[i].get(paramInstrumentation);
      arrayOfField[i].set(this, localObject);
      i += 1;
    }
  }
  
  private static boolean a(ClassLoader paramClassLoader, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    ShareIntentUtil.a(paramIntent, paramClassLoader);
    paramClassLoader = (ComponentName)paramIntent.getParcelableExtra("tinker_iek_old_component");
    if (paramClassLoader == null)
    {
      new StringBuilder("oldComponent was null, start ").append(paramIntent.getComponent()).append(" next.");
      return false;
    }
    if (IncrementComponentManager.awY(paramClassLoader.getClassName()) == null) {
      return false;
    }
    paramIntent.setComponent(paramClassLoader);
    paramIntent.removeExtra("tinker_iek_old_component");
    return true;
  }
  
  public static TinkerHackInstrumentation jx(Context paramContext)
  {
    try
    {
      paramContext = ShareReflectUtil.d(paramContext, null);
      Field localField = ShareReflectUtil.b(paramContext, "mInstrumentation");
      Instrumentation localInstrumentation = (Instrumentation)localField.get(paramContext);
      if ((localInstrumentation instanceof TinkerHackInstrumentation)) {
        return (TinkerHackInstrumentation)localInstrumentation;
      }
      paramContext = new TinkerHackInstrumentation(localInstrumentation, paramContext, localField);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new TinkerRuntimeException("see next stacktrace", paramContext);
    }
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = IncrementComponentManager.awY(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        a(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = IncrementComponentManager.awY(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        a(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
  }
  
  public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity != null) {
      a(paramActivity.getClass().getClassLoader(), paramIntent);
    }
    super.callActivityOnNewIntent(paramActivity, paramIntent);
  }
  
  public final void dWC()
  {
    if (!(this.BuN.get(this.BuM) instanceof TinkerHackInstrumentation)) {
      this.BuN.set(this.BuM, this);
    }
  }
  
  public Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    a(paramContext.getClassLoader(), paramIntent);
    return super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    if (a(paramClassLoader, paramIntent)) {
      return super.newActivity(paramClassLoader, paramIntent.getComponent().getClassName(), paramIntent);
    }
    return super.newActivity(paramClassLoader, paramString, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation
 * JD-Core Version:    0.7.0.1
 */