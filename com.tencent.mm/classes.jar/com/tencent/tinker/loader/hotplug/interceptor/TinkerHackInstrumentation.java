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
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

public class TinkerHackInstrumentation
  extends Instrumentation
{
  private static final String TAG = "Tinker.Instrumentation";
  private final Object mActivityThread;
  private final Field mInstrumentationField;
  private final Instrumentation mOriginal;
  
  private TinkerHackInstrumentation(Instrumentation paramInstrumentation, Object paramObject, Field paramField)
  {
    this.mOriginal = paramInstrumentation;
    this.mActivityThread = paramObject;
    this.mInstrumentationField = paramField;
    try
    {
      copyAllFields(paramInstrumentation);
      return;
    }
    catch (Throwable paramInstrumentation)
    {
      throw new TinkerRuntimeException(paramInstrumentation.getMessage(), paramInstrumentation);
    }
  }
  
  private void copyAllFields(Instrumentation paramInstrumentation)
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
  
  public static TinkerHackInstrumentation create(Context paramContext)
  {
    try
    {
      paramContext = ShareReflectUtil.getActivityThread(paramContext, null);
      Field localField = ShareReflectUtil.findField(paramContext, "mInstrumentation");
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
  
  private void fixActivityParams(Activity paramActivity, ActivityInfo paramActivityInfo)
  {
    paramActivity.setRequestedOrientation(paramActivityInfo.screenOrientation);
    paramActivity.setTheme(paramActivityInfo.theme);
    try
    {
      ShareReflectUtil.findField(paramActivity, "mActivityInfo").set(paramActivity, paramActivityInfo);
      return;
    }
    catch (Throwable paramActivity)
    {
      throw new TinkerRuntimeException("see next stacktrace.", paramActivity);
    }
  }
  
  private boolean processIntent(ClassLoader paramClassLoader, Intent paramIntent)
  {
    if (paramIntent == null) {
      return false;
    }
    ShareIntentUtil.fixIntentClassLoader(paramIntent, paramClassLoader);
    paramClassLoader = (ComponentName)paramIntent.getParcelableExtra("tinker_iek_old_component");
    if (paramClassLoader == null)
    {
      ShareTinkerLog.w("Tinker.Instrumentation", "oldComponent was null, start " + paramIntent.getComponent() + " next.", new Object[0]);
      return false;
    }
    String str = paramClassLoader.getClassName();
    if (IncrementComponentManager.queryActivityInfo(str) == null)
    {
      ShareTinkerLog.e("Tinker.Instrumentation", "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: ".concat(String.valueOf(str)), new Object[0]);
      return false;
    }
    paramIntent.setComponent(paramClassLoader);
    paramIntent.removeExtra("tinker_iek_old_component");
    return true;
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = IncrementComponentManager.queryActivityInfo(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        fixActivityParams(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public void callActivityOnCreate(Activity paramActivity, Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    if (paramActivity != null)
    {
      ActivityInfo localActivityInfo = IncrementComponentManager.queryActivityInfo(paramActivity.getClass().getName());
      if (localActivityInfo != null) {
        fixActivityParams(paramActivity, localActivityInfo);
      }
    }
    super.callActivityOnCreate(paramActivity, paramBundle, paramPersistableBundle);
  }
  
  public void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity != null) {
      processIntent(paramActivity.getClass().getClassLoader(), paramIntent);
    }
    super.callActivityOnNewIntent(paramActivity, paramIntent);
  }
  
  public void install()
  {
    if ((this.mInstrumentationField.get(this.mActivityThread) instanceof TinkerHackInstrumentation))
    {
      ShareTinkerLog.w("Tinker.Instrumentation", "already installed, skip rest logic.", new Object[0]);
      return;
    }
    this.mInstrumentationField.set(this.mActivityThread, this);
  }
  
  public Activity newActivity(Class<?> paramClass, Context paramContext, IBinder paramIBinder, Application paramApplication, Intent paramIntent, ActivityInfo paramActivityInfo, CharSequence paramCharSequence, Activity paramActivity, String paramString, Object paramObject)
  {
    processIntent(paramContext.getClassLoader(), paramIntent);
    return super.newActivity(paramClass, paramContext, paramIBinder, paramApplication, paramIntent, paramActivityInfo, paramCharSequence, paramActivity, paramString, paramObject);
  }
  
  public Activity newActivity(ClassLoader paramClassLoader, String paramString, Intent paramIntent)
  {
    if (processIntent(paramClassLoader, paramIntent)) {
      return super.newActivity(paramClassLoader, paramIntent.getComponent().getClassName(), paramIntent);
    }
    return super.newActivity(paramClassLoader, paramString, paramIntent);
  }
  
  public void uninstall()
  {
    this.mInstrumentationField.set(this.mActivityThread, this.mOriginal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.TinkerHackInstrumentation
 * JD-Core Version:    0.7.0.1
 */