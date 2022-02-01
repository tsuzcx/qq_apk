package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor
  extends Interceptor<Handler.Callback>
{
  private static Field sMCallbackField = null;
  private final MessageHandler mMessageHandler;
  private final Handler mTarget;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:sMCallbackField	Ljava/lang/reflect/Field;
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:sMCallbackField	Ljava/lang/reflect/Field;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +13 -> 25
    //   15: ldc 25
    //   17: ldc 27
    //   19: invokestatic 33	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   22: putstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:sMCallbackField	Ljava/lang/reflect/Field;
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: ldc 2
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    //   35: astore_0
    //   36: goto -11 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	2	0	localField	Field
    //   29	5	0	localObject	Object
    //   35	1	0	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   7	11	29	finally
    //   15	25	29	finally
    //   25	28	29	finally
    //   30	33	29	finally
    //   15	25	35	java/lang/Throwable
  }
  
  public HandlerMessageInterceptor(Handler paramHandler, MessageHandler paramMessageHandler)
  {
    this.mTarget = paramHandler;
    this.mMessageHandler = paramMessageHandler;
  }
  
  protected Handler.Callback decorate(Handler.Callback paramCallback)
  {
    if ((paramCallback != null) && (Interceptor.ITinkerHotplugProxy.class.isAssignableFrom(paramCallback.getClass()))) {
      return paramCallback;
    }
    return new CallbackWrapper(this.mMessageHandler, paramCallback);
  }
  
  protected Handler.Callback fetchTarget()
  {
    return (Handler.Callback)sMCallbackField.get(this.mTarget);
  }
  
  protected void inject(Handler.Callback paramCallback)
  {
    sMCallbackField.set(this.mTarget, paramCallback);
  }
  
  static class CallbackWrapper
    implements Handler.Callback, Interceptor.ITinkerHotplugProxy
  {
    private volatile boolean mIsInHandleMethod;
    private final HandlerMessageInterceptor.MessageHandler mMessageHandler;
    private final Handler.Callback mOrigCallback;
    
    CallbackWrapper(HandlerMessageInterceptor.MessageHandler paramMessageHandler, Handler.Callback paramCallback)
    {
      this.mMessageHandler = paramMessageHandler;
      this.mOrigCallback = paramCallback;
      this.mIsInHandleMethod = false;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      boolean bool = true;
      if (this.mIsInHandleMethod) {
        return false;
      }
      this.mIsInHandleMethod = true;
      if (this.mMessageHandler.handleMessage(paramMessage)) {}
      for (;;)
      {
        this.mIsInHandleMethod = false;
        return bool;
        if (this.mOrigCallback != null) {
          bool = this.mOrigCallback.handleMessage(paramMessage);
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static abstract interface MessageHandler
  {
    public abstract boolean handleMessage(Message paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor
 * JD-Core Version:    0.7.0.1
 */