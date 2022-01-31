package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor
  extends Interceptor<Handler.Callback>
{
  private static Field wXV = null;
  private final Handler wXT;
  private final MessageHandler wXU;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:wXV	Ljava/lang/reflect/Field;
    //   4: ldc 2
    //   6: monitorenter
    //   7: getstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:wXV	Ljava/lang/reflect/Field;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +13 -> 25
    //   15: ldc 25
    //   17: ldc 27
    //   19: invokestatic 33	com/tencent/tinker/loader/shareutil/ShareReflectUtil:d	(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   22: putstatic 23	com/tencent/tinker/loader/hotplug/interceptor/HandlerMessageInterceptor:wXV	Ljava/lang/reflect/Field;
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
    this.wXT = paramHandler;
    this.wXU = paramMessageHandler;
  }
  
  private static class CallbackWrapper
    implements Handler.Callback, Interceptor.ITinkerHotplugProxy
  {
    private final HandlerMessageInterceptor.MessageHandler wXU;
    private final Handler.Callback wXW;
    private volatile boolean wXX;
    
    CallbackWrapper(HandlerMessageInterceptor.MessageHandler paramMessageHandler, Handler.Callback paramCallback)
    {
      this.wXU = paramMessageHandler;
      this.wXW = paramCallback;
      this.wXX = false;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      if (this.wXX) {
        return false;
      }
      this.wXX = true;
      this.wXU.handleMessage(paramMessage);
      if (this.wXW != null) {}
      for (boolean bool = this.wXW.handleMessage(paramMessage);; bool = false)
      {
        this.wXX = false;
        return bool;
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