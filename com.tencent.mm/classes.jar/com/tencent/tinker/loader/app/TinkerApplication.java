package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.tinker.anno.Keep;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class TinkerApplication
  extends Application
{
  private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
  private static final TinkerApplication[] SELF_HOLDER = { null };
  private static final String TINKER_LOADER_METHOD = "tryLoad";
  private final String delegateClassName;
  private final String loaderClassName;
  protected ClassLoader mCurrentClassLoader = null;
  private Handler mInlineFence = null;
  private final int tinkerFlags;
  private final boolean tinkerLoadVerifyFlag;
  protected Intent tinkerResultIntent;
  private final boolean useDelegateLastClassLoader;
  private boolean useSafeMode;
  
  protected TinkerApplication(int paramInt)
  {
    this(paramInt, "com.tencent.tinker.entry.DefaultApplicationLike", TinkerLoader.class.getName(), false, false);
  }
  
  protected TinkerApplication(int paramInt, String paramString)
  {
    this(paramInt, paramString, TinkerLoader.class.getName(), false, false);
  }
  
  protected TinkerApplication(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (SELF_HOLDER)
    {
      SELF_HOLDER[0] = this;
      this.tinkerFlags = paramInt;
      this.delegateClassName = paramString1;
      this.loaderClassName = paramString2;
      this.tinkerLoadVerifyFlag = paramBoolean1;
      this.useDelegateLastClassLoader = paramBoolean2;
      return;
    }
  }
  
  private Handler createInlineFence(Application paramApplication, int paramInt, String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Intent paramIntent)
  {
    try
    {
      paramApplication = Class.forName(paramString, false, this.mCurrentClassLoader).getConstructor(new Class[] { Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class }).newInstance(new Object[] { paramApplication, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramIntent });
      paramString = Class.forName("com.tencent.tinker.entry.TinkerApplicationInlineFence", false, this.mCurrentClassLoader).getConstructor(new Class[] { Class.forName("com.tencent.tinker.entry.ApplicationLike", false, this.mCurrentClassLoader) });
      paramString.setAccessible(true);
      paramApplication = (Handler)paramString.newInstance(new Object[] { paramApplication });
      return paramApplication;
    }
    catch (Throwable paramApplication)
    {
      throw new TinkerRuntimeException("createInlineFence failed", paramApplication);
    }
  }
  
  public static TinkerApplication getInstance()
  {
    synchronized (SELF_HOLDER)
    {
      if (SELF_HOLDER[0] == null) {
        throw new IllegalStateException("TinkerApplication is not initialized.");
      }
    }
    TinkerApplication localTinkerApplication = SELF_HOLDER[0];
    return localTinkerApplication;
  }
  
  private void loadTinker()
  {
    try
    {
      Class localClass = Class.forName(this.loaderClassName, false, TinkerApplication.class.getClassLoader());
      this.tinkerResultIntent = ((Intent)localClass.getMethod("tryLoad", new Class[] { TinkerApplication.class }).invoke(localClass.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[] { this }));
      return;
    }
    catch (Throwable localThrowable)
    {
      this.tinkerResultIntent = new Intent();
      ShareIntentUtil.setIntentReturnCode(this.tinkerResultIntent, -20);
      this.tinkerResultIntent.putExtra("intent_patch_exception", localThrowable);
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = System.currentTimeMillis();
    Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
    onBaseContextAttached(paramContext, l1, l2);
  }
  
  public AssetManager getAssets()
  {
    AssetManager localAssetManager = super.getAssets();
    if (this.mInlineFence == null) {
      return localAssetManager;
    }
    return TinkerInlineFenceAction.callGetAssets(this.mInlineFence, localAssetManager);
  }
  
  public Context getBaseContext()
  {
    Context localContext = super.getBaseContext();
    if (this.mInlineFence == null) {
      return localContext;
    }
    return TinkerInlineFenceAction.callGetBaseContext(this.mInlineFence, localContext);
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader = super.getClassLoader();
    if (this.mInlineFence == null) {
      return localClassLoader;
    }
    return TinkerInlineFenceAction.callGetClassLoader(this.mInlineFence, localClassLoader);
  }
  
  public Resources getResources()
  {
    Resources localResources = super.getResources();
    if (this.mInlineFence == null) {
      return localResources;
    }
    return TinkerInlineFenceAction.callGetResources(this.mInlineFence, localResources);
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject = super.getSystemService(paramString);
    if (this.mInlineFence == null) {
      return localObject;
    }
    return TinkerInlineFenceAction.callGetSystemService(this.mInlineFence, paramString, localObject);
  }
  
  public int getTinkerFlags()
  {
    return this.tinkerFlags;
  }
  
  public boolean isTinkerLoadVerifyFlag()
  {
    return this.tinkerLoadVerifyFlag;
  }
  
  public boolean isUseDelegateLastClassLoader()
  {
    return this.useDelegateLastClassLoader;
  }
  
  @Keep
  public int mzNightModeUseOf()
  {
    if (this.mInlineFence == null) {
      return 1;
    }
    return TinkerInlineFenceAction.callMZNightModeUseOf(this.mInlineFence);
  }
  
  protected void onBaseContextAttached(Context paramContext, long paramLong1, long paramLong2)
  {
    try
    {
      loadTinker();
      this.mCurrentClassLoader = paramContext.getClassLoader();
      this.mInlineFence = createInlineFence(this, this.tinkerFlags, this.delegateClassName, this.tinkerLoadVerifyFlag, paramLong1, paramLong2, this.tinkerResultIntent);
      TinkerInlineFenceAction.callOnBaseContextAttached(this.mInlineFence, paramContext);
      if (this.useSafeMode) {
        ShareTinkerInternals.setSafeModeCount(this, 0);
      }
      return;
    }
    catch (TinkerRuntimeException paramContext)
    {
      throw paramContext;
    }
    catch (Throwable paramContext)
    {
      throw new TinkerRuntimeException(paramContext.getMessage(), paramContext);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mInlineFence == null) {
      return;
    }
    TinkerInlineFenceAction.callOnConfigurationChanged(this.mInlineFence, paramConfiguration);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mInlineFence == null) {
      return;
    }
    TinkerInlineFenceAction.callOnCreate(this.mInlineFence);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.mInlineFence == null) {
      return;
    }
    TinkerInlineFenceAction.callOnLowMemory(this.mInlineFence);
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.mInlineFence == null) {
      return;
    }
    TinkerInlineFenceAction.callOnTerminate(this.mInlineFence);
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.mInlineFence == null) {
      return;
    }
    TinkerInlineFenceAction.callOnTrimMemory(this.mInlineFence, paramInt);
  }
  
  public void setUseSafeMode(boolean paramBoolean)
  {
    this.useSafeMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.TinkerApplication
 * JD-Core Version:    0.7.0.1
 */