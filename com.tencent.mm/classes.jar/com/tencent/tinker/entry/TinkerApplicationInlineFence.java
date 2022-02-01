package com.tencent.tinker.entry;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.tinker.anno.Keep;

@Keep
public final class TinkerApplicationInlineFence
  extends Handler
{
  private final ApplicationLike mAppLike;
  
  public TinkerApplicationInlineFence(ApplicationLike paramApplicationLike)
  {
    this.mAppLike = paramApplicationLike;
  }
  
  private static void dummyThrowExceptionMethod()
  {
    if (TinkerApplicationInlineFence.class.isPrimitive()) {
      throw new RuntimeException();
    }
  }
  
  private void handleMessageImpl(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new IllegalStateException("Should not be here.");
    case 1: 
      this.mAppLike.onBaseContextAttached((Context)paramMessage.obj);
      return;
    case 2: 
      this.mAppLike.onCreate();
      return;
    case 3: 
      this.mAppLike.onConfigurationChanged((Configuration)paramMessage.obj);
      return;
    case 4: 
      this.mAppLike.onTrimMemory(((Integer)paramMessage.obj).intValue());
      return;
    case 5: 
      this.mAppLike.onLowMemory();
      return;
    case 6: 
      this.mAppLike.onTerminate();
      return;
    case 7: 
      paramMessage.obj = this.mAppLike.getClassLoader((ClassLoader)paramMessage.obj);
      return;
    case 8: 
      paramMessage.obj = this.mAppLike.getBaseContext((Context)paramMessage.obj);
      return;
    case 9: 
      paramMessage.obj = this.mAppLike.getAssets((AssetManager)paramMessage.obj);
      return;
    case 10: 
      paramMessage.obj = this.mAppLike.getResources((Resources)paramMessage.obj);
      return;
    case 11: 
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      paramMessage.obj = this.mAppLike.getSystemService((String)arrayOfObject[0], arrayOfObject[1]);
      return;
    }
    paramMessage.obj = Integer.valueOf(this.mAppLike.mzNightModeUseOf());
  }
  
  private void handleMessage_$noinline$(Message paramMessage)
  {
    try
    {
      dummyThrowExceptionMethod();
      return;
    }
    finally
    {
      handleMessageImpl(paramMessage);
    }
  }
  
  public final void dispatchMessage(Message paramMessage) {}
  
  public final void handleMessage(Message paramMessage)
  {
    handleMessage_$noinline$(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.entry.TinkerApplicationInlineFence
 * JD-Core Version:    0.7.0.1
 */