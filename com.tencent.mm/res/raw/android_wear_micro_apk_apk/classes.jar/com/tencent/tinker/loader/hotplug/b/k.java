package com.tencent.tinker.loader.hotplug.b;

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
import android.util.Log;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.h;
import com.tencent.tinker.loader.hotplug.c;
import java.lang.reflect.Field;

public final class k
  extends Instrumentation
{
  private final Instrumentation alP;
  private final Object alQ;
  private final Field alR;
  
  private k(Instrumentation paramInstrumentation, Object paramObject, Field paramField)
  {
    this.alP = paramInstrumentation;
    this.alQ = paramObject;
    this.alR = paramField;
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
  
  public static k L(Context paramContext)
  {
    try
    {
      paramContext = h.b(paramContext, null);
      Field localField = h.a(paramContext, "mInstrumentation");
      Instrumentation localInstrumentation = (Instrumentation)localField.get(paramContext);
      if ((localInstrumentation instanceof k)) {
        return (k)localInstrumentation;
      }
      paramContext = new k(localInstrumentation, paramContext, localField);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new TinkerRuntimeException("see next stacktrace", paramContext);
    }
  }
  
  private static void a(Activity paramActivity, ActivityInfo paramActivityInfo)
  {
    paramActivity.setRequestedOrientation(paramActivityInfo.screenOrientation);
    paramActivity.setTheme(paramActivityInfo.theme);
    try
    {
      h.a(paramActivity, "mActivityInfo").set(paramActivity, paramActivityInfo);
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
    e.a(paramIntent, paramClassLoader);
    paramClassLoader = (ComponentName)paramIntent.getParcelableExtra("tinker_iek_old_component");
    if (paramClassLoader == null)
    {
      Log.w("Tinker.Instrumentation", "oldComponent was null, start " + paramIntent.getComponent() + " next.");
      return false;
    }
    String str = paramClassLoader.getClassName();
    if (c.ab(str) == null)
    {
      Log.e("Tinker.Instrumentation", "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: " + str);
      return false;
    }
    paramIntent.setComponent(paramClassLoader);
    paramIntent.removeExtra("tinker_iek_old_component");
    return true;
  }
  
  public final void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = c.ab(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        a(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public final void callActivityOnCreate(Activity paramActivity, Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = c.ab(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        a(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
  }
  
  public final void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity != null) {
      a(paramActivity.getClass().getClassLoader(), paramIntent);
    }
    super.callActivityOnNewIntent(paramActivity, paramIntent);
  }
  
  public final Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    a(paramContext.getClassLoader(), paramIntent);
    return super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
  }
  
  public final Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    if (a(paramClassLoader, paramIntent)) {
      return super.newActivity(paramClassLoader, paramIntent.getComponent().getClassName(), paramIntent);
    }
    return super.newActivity(paramClassLoader, paramString, paramIntent);
  }
  
  public final void og()
  {
    this.alR.set(this.alQ, this.alP);
  }
  
  public final void ok()
  {
    if ((this.alR.get(this.alQ) instanceof k))
    {
      Log.w("Tinker.Instrumentation", "already installed, skip rest logic.");
      return;
    }
    this.alR.set(this.alQ, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.k
 * JD-Core Version:    0.7.0.1
 */