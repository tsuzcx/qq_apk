package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.a.k;
import com.tencent.tinker.loader.hotplug.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class TinkerApplication
  extends Application
{
  private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
  private static final int TINKER_DISABLE = 0;
  private static final String TINKER_LOADER_METHOD = "tryLoad";
  private ApplicationLike applicationLike = null;
  private long applicationStartElapsedTime;
  private long applicationStartMillisTime;
  private final String delegateClassName;
  private final String loaderClassName;
  private final int tinkerFlags;
  private final boolean tinkerLoadVerifyFlag;
  private Intent tinkerResultIntent;
  private boolean useSafeMode;
  
  protected TinkerApplication(int paramInt)
  {
    this(paramInt, "com.tencent.tinker.loader.app.DefaultApplicationLike", TinkerLoader.class.getName(), false);
  }
  
  protected TinkerApplication(int paramInt, String paramString)
  {
    this(paramInt, paramString, TinkerLoader.class.getName(), false);
  }
  
  protected TinkerApplication(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.tinkerFlags = paramInt;
    this.delegateClassName = paramString1;
    this.loaderClassName = paramString2;
    this.tinkerLoadVerifyFlag = paramBoolean;
  }
  
  private ApplicationLike createDelegate()
  {
    try
    {
      ApplicationLike localApplicationLike = (ApplicationLike)Class.forName(this.delegateClassName, false, getClassLoader()).getConstructor(new Class[] { Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class }).newInstance(new Object[] { this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag), Long.valueOf(this.applicationStartElapsedTime), Long.valueOf(this.applicationStartMillisTime), this.tinkerResultIntent });
      return localApplicationLike;
    }
    catch (Throwable localThrowable)
    {
      throw new TinkerRuntimeException("createDelegate failed", localThrowable);
    }
  }
  
  private void ensureDelegate()
  {
    try
    {
      if (this.applicationLike == null) {
        this.applicationLike = createDelegate();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void loadTinker()
  {
    try
    {
      Class localClass = Class.forName(this.loaderClassName, false, getClassLoader());
      this.tinkerResultIntent = ((Intent)localClass.getMethod("tryLoad", new Class[] { TinkerApplication.class }).invoke(localClass.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[] { this }));
      return;
    }
    catch (Throwable localThrowable)
    {
      this.tinkerResultIntent = new Intent();
      com.tencent.tinker.loader.a.e.a(this.tinkerResultIntent, -20);
      this.tinkerResultIntent.putExtra("intent_patch_exception", localThrowable);
    }
  }
  
  private void onBaseContextAttached(Context paramContext)
  {
    this.applicationStartElapsedTime = SystemClock.elapsedRealtime();
    this.applicationStartMillisTime = System.currentTimeMillis();
    loadTinker();
    ensureDelegate();
    this.applicationLike.onBaseContextAttached(paramContext);
    if (this.useSafeMode)
    {
      paramContext = k.T(this);
      getSharedPreferences("tinker_own_config_" + paramContext, 0).edit().putInt("safe_mode_count", 0).commit();
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
    onBaseContextAttached(paramContext);
  }
  
  public AssetManager getAssets()
  {
    AssetManager localAssetManager2 = super.getAssets();
    AssetManager localAssetManager1 = localAssetManager2;
    if (this.applicationLike != null) {
      localAssetManager1 = this.applicationLike.getAssets(localAssetManager2);
    }
    return localAssetManager1;
  }
  
  public Context getBaseContext()
  {
    Context localContext2 = super.getBaseContext();
    Context localContext1 = localContext2;
    if (this.applicationLike != null) {
      localContext1 = this.applicationLike.getBaseContext(localContext2);
    }
    return localContext1;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader2 = super.getClassLoader();
    ClassLoader localClassLoader1 = localClassLoader2;
    if (this.applicationLike != null) {
      localClassLoader1 = this.applicationLike.getClassLoader(localClassLoader2);
    }
    return localClassLoader1;
  }
  
  public Resources getResources()
  {
    Resources localResources2 = super.getResources();
    Resources localResources1 = localResources2;
    if (this.applicationLike != null) {
      localResources1 = this.applicationLike.getResources(localResources2);
    }
    return localResources1;
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if (this.applicationLike != null) {
      localObject1 = this.applicationLike.getSystemService(paramString, localObject2);
    }
    return localObject1;
  }
  
  public int getTinkerFlags()
  {
    return this.tinkerFlags;
  }
  
  public boolean isTinkerLoadVerifyFlag()
  {
    return this.tinkerLoadVerifyFlag;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.applicationLike != null) {
      this.applicationLike.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    ensureDelegate();
    try
    {
      b.of();
      this.applicationLike.onCreate();
      return;
    }
    catch (com.tencent.tinker.loader.hotplug.e locale)
    {
      throw new TinkerRuntimeException("failed to make sure that ComponentHotplug logic is fine.", locale);
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.applicationLike != null) {
      this.applicationLike.onLowMemory();
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.applicationLike != null) {
      this.applicationLike.onTerminate();
    }
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.applicationLike != null) {
      this.applicationLike.onTrimMemory(paramInt);
    }
  }
  
  public void setUseSafeMode(boolean paramBoolean)
  {
    this.useSafeMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.TinkerApplication
 * JD-Core Version:    0.7.0.1
 */