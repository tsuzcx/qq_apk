package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;

public final class TinkerInlineFenceAction
{
  public static final int ACTION_GET_ASSETS = 9;
  public static final int ACTION_GET_BASE_CONTEXT = 8;
  public static final int ACTION_GET_CLASSLOADER = 7;
  public static final int ACTION_GET_RESOURCES = 10;
  public static final int ACTION_GET_SYSTEM_SERVICE = 11;
  public static final int ACTION_MZ_NIGHTMODE_USE_OF = 12;
  public static final int ACTION_ON_BASE_CONTEXT_ATTACHED = 1;
  public static final int ACTION_ON_CONFIGURATION_CHANGED = 3;
  public static final int ACTION_ON_CREATE = 2;
  public static final int ACTION_ON_LOW_MEMORY = 5;
  public static final int ACTION_ON_TERMINATE = 6;
  public static final int ACTION_ON_TRIM_MEMORY = 4;
  
  static AssetManager callGetAssets(Handler paramHandler, AssetManager paramAssetManager)
  {
    paramAssetManager = Message.obtain(paramHandler, 9, paramAssetManager);
    paramHandler.handleMessage(paramAssetManager);
    return (AssetManager)paramAssetManager.obj;
  }
  
  static Context callGetBaseContext(Handler paramHandler, Context paramContext)
  {
    paramContext = Message.obtain(paramHandler, 8, paramContext);
    paramHandler.handleMessage(paramContext);
    return (Context)paramContext.obj;
  }
  
  static ClassLoader callGetClassLoader(Handler paramHandler, ClassLoader paramClassLoader)
  {
    paramClassLoader = Message.obtain(paramHandler, 7, paramClassLoader);
    paramHandler.handleMessage(paramClassLoader);
    return (ClassLoader)paramClassLoader.obj;
  }
  
  static Resources callGetResources(Handler paramHandler, Resources paramResources)
  {
    paramResources = Message.obtain(paramHandler, 10, paramResources);
    paramHandler.handleMessage(paramResources);
    return (Resources)paramResources.obj;
  }
  
  static Object callGetSystemService(Handler paramHandler, String paramString, Object paramObject)
  {
    paramString = Message.obtain(paramHandler, 11, new Object[] { paramString, paramObject });
    paramHandler.handleMessage(paramString);
    return paramString.obj;
  }
  
  static int callMZNightModeUseOf(Handler paramHandler)
  {
    Message localMessage = Message.obtain(paramHandler, 12);
    paramHandler.handleMessage(localMessage);
    return ((Integer)localMessage.obj).intValue();
  }
  
  static void callOnBaseContextAttached(Handler paramHandler, Context paramContext)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 1, paramContext));
  }
  
  static void callOnConfigurationChanged(Handler paramHandler, Configuration paramConfiguration)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 3, paramConfiguration));
  }
  
  static void callOnCreate(Handler paramHandler)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 2));
  }
  
  static void callOnLowMemory(Handler paramHandler)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 5));
  }
  
  static void callOnTerminate(Handler paramHandler)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 6));
  }
  
  static void callOnTrimMemory(Handler paramHandler, int paramInt)
  {
    paramHandler.handleMessage(Message.obtain(paramHandler, 4, Integer.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.TinkerInlineFenceAction
 * JD-Core Version:    0.7.0.1
 */