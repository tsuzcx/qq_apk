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
    AssetManager localAssetManager = null;
    try
    {
      paramAssetManager = Message.obtain(paramHandler, 9, paramAssetManager);
      localAssetManager = paramAssetManager;
      paramHandler.handleMessage(paramAssetManager);
      localAssetManager = paramAssetManager;
      paramHandler = (AssetManager)paramAssetManager.obj;
      return paramHandler;
    }
    finally
    {
      localAssetManager.recycle();
    }
  }
  
  static Context callGetBaseContext(Handler paramHandler, Context paramContext)
  {
    Context localContext = null;
    try
    {
      paramContext = Message.obtain(paramHandler, 8, paramContext);
      localContext = paramContext;
      paramHandler.handleMessage(paramContext);
      localContext = paramContext;
      paramHandler = (Context)paramContext.obj;
      return paramHandler;
    }
    finally
    {
      localContext.recycle();
    }
  }
  
  static ClassLoader callGetClassLoader(Handler paramHandler, ClassLoader paramClassLoader)
  {
    ClassLoader localClassLoader = null;
    try
    {
      paramClassLoader = Message.obtain(paramHandler, 7, paramClassLoader);
      localClassLoader = paramClassLoader;
      paramHandler.handleMessage(paramClassLoader);
      localClassLoader = paramClassLoader;
      paramHandler = (ClassLoader)paramClassLoader.obj;
      return paramHandler;
    }
    finally
    {
      localClassLoader.recycle();
    }
  }
  
  static Resources callGetResources(Handler paramHandler, Resources paramResources)
  {
    Resources localResources = null;
    try
    {
      paramResources = Message.obtain(paramHandler, 10, paramResources);
      localResources = paramResources;
      paramHandler.handleMessage(paramResources);
      localResources = paramResources;
      paramHandler = (Resources)paramResources.obj;
      return paramHandler;
    }
    finally
    {
      localResources.recycle();
    }
  }
  
  static Object callGetSystemService(Handler paramHandler, String paramString, Object paramObject)
  {
    String str = null;
    try
    {
      paramString = Message.obtain(paramHandler, 11, new Object[] { paramString, paramObject });
      str = paramString;
      paramHandler.handleMessage(paramString);
      str = paramString;
      paramHandler = paramString.obj;
      return paramHandler;
    }
    finally
    {
      str.recycle();
    }
  }
  
  static int callMZNightModeUseOf(Handler paramHandler)
  {
    Object localObject = null;
    try
    {
      Message localMessage = Message.obtain(paramHandler, 12);
      localObject = localMessage;
      paramHandler.handleMessage(localMessage);
      localObject = localMessage;
      int i = ((Integer)localMessage.obj).intValue();
      return i;
    }
    finally
    {
      localObject.recycle();
    }
  }
  
  static void callOnBaseContextAttached(Handler paramHandler, Context paramContext)
  {
    Context localContext = null;
    try
    {
      paramContext = Message.obtain(paramHandler, 1, paramContext);
      localContext = paramContext;
      paramHandler.handleMessage(paramContext);
      return;
    }
    finally
    {
      localContext.recycle();
    }
  }
  
  static void callOnConfigurationChanged(Handler paramHandler, Configuration paramConfiguration)
  {
    Configuration localConfiguration = null;
    try
    {
      paramConfiguration = Message.obtain(paramHandler, 3, paramConfiguration);
      localConfiguration = paramConfiguration;
      paramHandler.handleMessage(paramConfiguration);
      return;
    }
    finally
    {
      localConfiguration.recycle();
    }
  }
  
  static void callOnCreate(Handler paramHandler)
  {
    Object localObject = null;
    try
    {
      Message localMessage = Message.obtain(paramHandler, 2);
      localObject = localMessage;
      paramHandler.handleMessage(localMessage);
      return;
    }
    finally
    {
      localObject.recycle();
    }
  }
  
  static void callOnLowMemory(Handler paramHandler)
  {
    Object localObject = null;
    try
    {
      Message localMessage = Message.obtain(paramHandler, 5);
      localObject = localMessage;
      paramHandler.handleMessage(localMessage);
      return;
    }
    finally
    {
      localObject.recycle();
    }
  }
  
  static void callOnTerminate(Handler paramHandler)
  {
    Object localObject = null;
    try
    {
      Message localMessage = Message.obtain(paramHandler, 6);
      localObject = localMessage;
      paramHandler.handleMessage(localMessage);
      return;
    }
    finally
    {
      localObject.recycle();
    }
  }
  
  static void callOnTrimMemory(Handler paramHandler, int paramInt)
  {
    Object localObject = null;
    try
    {
      Message localMessage = Message.obtain(paramHandler, 4, Integer.valueOf(paramInt));
      localObject = localMessage;
      paramHandler.handleMessage(localMessage);
      return;
    }
    finally
    {
      localObject.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.loader.app.TinkerInlineFenceAction
 * JD-Core Version:    0.7.0.1
 */