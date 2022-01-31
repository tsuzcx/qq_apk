package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public abstract class TinkerApplication
  extends Application
{
  private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
  private static final int TINKER_DISABLE = 0;
  private static final String TINKER_LOADER_METHOD = "tryLoad";
  private Method appLikeGetAssets = null;
  private Method appLikeGetBaseContext = null;
  private Method appLikeGetClassLoader = null;
  private Method appLikeGetResources = null;
  private Method appLikeGetSystemService = null;
  private Method appLikeOnBaseContextAttached = null;
  private Method appLikeOnConfigurationChanged = null;
  private Method appLikeOnCreate = null;
  private Method appLikeOnLowMemory = null;
  private Method appLikeOnTerminate = null;
  private Method appLikeOnTrimMemory = null;
  private Object applicationLike = null;
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
    this(paramInt, "com.tencent.tinker.entry.DefaultApplicationLike", TinkerLoader.class.getName(), false);
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
  
  private Object createDelegate()
  {
    try
    {
      Object localObject = Class.forName(this.delegateClassName, false, getClassLoader()).getConstructor(new Class[] { Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class }).newInstance(new Object[] { this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag), Long.valueOf(this.applicationStartElapsedTime), Long.valueOf(this.applicationStartMillisTime), this.tinkerResultIntent });
      return localObject;
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
  
  private AssetManager invokeAppLikeGetAssets(Object paramObject, AssetManager paramAssetManager)
  {
    try
    {
      if (this.appLikeGetAssets == null) {
        this.appLikeGetAssets = ShareReflectUtil.b(this.applicationLike, "getAssets", new Class[] { AssetManager.class });
      }
      paramObject = (AssetManager)this.appLikeGetAssets.invoke(paramObject, new Object[] { paramAssetManager });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke getAssets of appLike.", paramObject);
    }
  }
  
  private Object invokeAppLikeGetBaseContext(Object paramObject, Context paramContext)
  {
    try
    {
      if (this.appLikeGetBaseContext == null) {
        this.appLikeGetBaseContext = ShareReflectUtil.b(this.applicationLike, "getBaseContext", new Class[] { Context.class });
      }
      paramObject = this.appLikeGetBaseContext.invoke(paramObject, new Object[] { paramContext });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke getBaseContext of appLike.", paramObject);
    }
  }
  
  private ClassLoader invokeAppLikeGetClassLoader(Object paramObject, ClassLoader paramClassLoader)
  {
    try
    {
      if (this.appLikeGetClassLoader == null) {
        this.appLikeGetClassLoader = ShareReflectUtil.b(this.applicationLike, "getClassLoader", new Class[] { ClassLoader.class });
      }
      paramObject = (ClassLoader)this.appLikeGetClassLoader.invoke(paramObject, new Object[] { paramClassLoader });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke getClassLoader of appLike.", paramObject);
    }
  }
  
  private Resources invokeAppLikeGetResources(Object paramObject, Resources paramResources)
  {
    try
    {
      if (this.appLikeGetResources == null) {
        this.appLikeGetResources = ShareReflectUtil.b(this.applicationLike, "getResources", new Class[] { Resources.class });
      }
      paramObject = (Resources)this.appLikeGetResources.invoke(paramObject, new Object[] { paramResources });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke getResources of appLike.", paramObject);
    }
  }
  
  private Object invokeAppLikeGetSystemService(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      if (this.appLikeGetSystemService == null) {
        this.appLikeGetSystemService = ShareReflectUtil.b(this.applicationLike, "getSystemService", new Class[] { String.class, Object.class });
      }
      paramObject1 = this.appLikeGetSystemService.invoke(paramObject1, new Object[] { paramString, paramObject2 });
      return paramObject1;
    }
    catch (Throwable paramObject1)
    {
      throw new TinkerRuntimeException("fail to invoke getSystemService of appLike.", paramObject1);
    }
  }
  
  private void invokeAppLikeOnBaseContextAttached(Object paramObject, Context paramContext)
  {
    try
    {
      if (this.appLikeOnBaseContextAttached == null) {
        this.appLikeOnBaseContextAttached = ShareReflectUtil.b(this.applicationLike, "onBaseContextAttached", new Class[] { Context.class });
      }
      this.appLikeOnBaseContextAttached.invoke(paramObject, new Object[] { paramContext });
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onBaseContextAttached of appLike.", paramObject);
    }
  }
  
  private void invokeAppLikeOnConfigurationChanged(Object paramObject, Configuration paramConfiguration)
  {
    try
    {
      if (this.appLikeOnConfigurationChanged == null) {
        this.appLikeOnConfigurationChanged = ShareReflectUtil.b(this.applicationLike, "onConfigurationChanged", new Class[] { Configuration.class });
      }
      this.appLikeOnConfigurationChanged.invoke(paramObject, new Object[] { paramConfiguration });
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onConfigurationChanged of appLike.", paramObject);
    }
  }
  
  private void invokeAppLikeOnCreate(Object paramObject)
  {
    try
    {
      if (this.appLikeOnCreate == null) {
        this.appLikeOnCreate = ShareReflectUtil.b(this.applicationLike, "onCreate", new Class[0]);
      }
      this.appLikeOnCreate.invoke(paramObject, new Object[0]);
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onCreate of appLike.", paramObject);
    }
  }
  
  private void invokeAppLikeOnLowMemory(Object paramObject)
  {
    try
    {
      if (this.appLikeOnLowMemory == null) {
        this.appLikeOnLowMemory = ShareReflectUtil.b(this.applicationLike, "onLowMemory", new Class[0]);
      }
      this.appLikeOnLowMemory.invoke(paramObject, new Object[0]);
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onLowMemory of appLike.", paramObject);
    }
  }
  
  private void invokeAppLikeOnTerminate(Object paramObject)
  {
    try
    {
      if (this.appLikeOnTerminate == null) {
        this.appLikeOnTerminate = ShareReflectUtil.b(this.applicationLike, "onTerminate", new Class[0]);
      }
      this.appLikeOnTerminate.invoke(paramObject, new Object[0]);
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onTerminate of appLike.", paramObject);
    }
  }
  
  private void invokeAppLikeOnTrimMemory(Object paramObject, int paramInt)
  {
    try
    {
      if (this.appLikeOnTrimMemory == null) {
        this.appLikeOnTrimMemory = ShareReflectUtil.b(this.applicationLike, "onTrimMemory", new Class[] { Integer.TYPE });
      }
      this.appLikeOnTrimMemory.invoke(paramObject, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Throwable paramObject)
    {
      throw new TinkerRuntimeException("fail to invoke onTrimMemory of appLike.", paramObject);
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
      ShareIntentUtil.b(this.tinkerResultIntent, -20);
      this.tinkerResultIntent.putExtra("intent_patch_exception", localThrowable);
    }
  }
  
  private void onBaseContextAttached(Context paramContext)
  {
    try
    {
      this.applicationStartElapsedTime = SystemClock.elapsedRealtime();
      this.applicationStartMillisTime = System.currentTimeMillis();
      loadTinker();
      ensureDelegate();
      invokeAppLikeOnBaseContextAttached(this.applicationLike, paramContext);
      if (this.useSafeMode) {
        ShareTinkerInternals.aG(this, 0);
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
      localAssetManager1 = invokeAppLikeGetAssets(this.applicationLike, localAssetManager2);
    }
    return localAssetManager1;
  }
  
  public Context getBaseContext()
  {
    Context localContext2 = super.getBaseContext();
    Context localContext1 = localContext2;
    if (this.applicationLike != null) {
      localContext1 = (Context)invokeAppLikeGetBaseContext(this.applicationLike, localContext2);
    }
    return localContext1;
  }
  
  public ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader2 = super.getClassLoader();
    ClassLoader localClassLoader1 = localClassLoader2;
    if (this.applicationLike != null) {
      localClassLoader1 = invokeAppLikeGetClassLoader(this.applicationLike, localClassLoader2);
    }
    return localClassLoader1;
  }
  
  public Resources getResources()
  {
    Resources localResources2 = super.getResources();
    Resources localResources1 = localResources2;
    if (this.applicationLike != null) {
      localResources1 = invokeAppLikeGetResources(this.applicationLike, localResources2);
    }
    return localResources1;
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if (this.applicationLike != null) {
      localObject1 = invokeAppLikeGetSystemService(this.applicationLike, paramString, localObject2);
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
      invokeAppLikeOnConfigurationChanged(this.applicationLike, paramConfiguration);
    }
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 337	android/app/Application:onCreate	()V
    //   4: aload_0
    //   5: invokespecial 273	com/tencent/tinker/loader/app/TinkerApplication:ensureDelegate	()V
    //   8: invokestatic 342	com/tencent/tinker/loader/hotplug/ComponentHotplug:dWA	()V
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 61	com/tencent/tinker/loader/app/TinkerApplication:applicationLike	Ljava/lang/Object;
    //   16: invokespecial 344	com/tencent/tinker/loader/app/TinkerApplication:invokeAppLikeOnCreate	(Ljava/lang/Object;)V
    //   19: return
    //   20: astore_1
    //   21: new 147	com/tencent/tinker/loader/TinkerRuntimeException
    //   24: dup
    //   25: ldc_w 346
    //   28: aload_1
    //   29: invokespecial 152	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   32: athrow
    //   33: astore_1
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: new 147	com/tencent/tinker/loader/TinkerRuntimeException
    //   40: dup
    //   41: aload_1
    //   42: invokevirtual 286	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   45: aload_1
    //   46: invokespecial 152	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	TinkerApplication
    //   20	9	1	localUnsupportedEnvironmentException	com.tencent.tinker.loader.hotplug.UnsupportedEnvironmentException
    //   33	2	1	localTinkerRuntimeException	TinkerRuntimeException
    //   36	10	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	11	20	com/tencent/tinker/loader/hotplug/UnsupportedEnvironmentException
    //   4	8	33	com/tencent/tinker/loader/TinkerRuntimeException
    //   8	11	33	com/tencent/tinker/loader/TinkerRuntimeException
    //   11	19	33	com/tencent/tinker/loader/TinkerRuntimeException
    //   21	33	33	com/tencent/tinker/loader/TinkerRuntimeException
    //   4	8	36	java/lang/Throwable
    //   8	11	36	java/lang/Throwable
    //   11	19	36	java/lang/Throwable
    //   21	33	36	java/lang/Throwable
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.applicationLike != null) {
      invokeAppLikeOnLowMemory(this.applicationLike);
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.applicationLike != null) {
      invokeAppLikeOnTerminate(this.applicationLike);
    }
  }
  
  @TargetApi(14)
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    if (this.applicationLike != null) {
      invokeAppLikeOnTrimMemory(this.applicationLike, paramInt);
    }
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