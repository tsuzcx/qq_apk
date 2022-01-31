package com.tencent.mm.plugin.normsg;

import android.support.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Keep
public class CProxyStub
  implements InvocationHandler
{
  @Keep
  private final long mNativePtr;
  
  private CProxyStub(long paramLong)
  {
    try
    {
      this.mNativePtr = paramLong;
      return;
    }
    finally {}
  }
  
  private native void nativeFinalize();
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 23	com/tencent/mm/plugin/normsg/CProxyStub:nativeFinalize	()V
    //   6: aload_0
    //   7: monitorexit
    //   8: aload_0
    //   9: invokespecial 25	java/lang/Object:finalize	()V
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    //   18: astore_1
    //   19: aload_0
    //   20: invokespecial 25	java/lang/Object:finalize	()V
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: invokespecial 25	java/lang/Object:finalize	()V
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	CProxyStub
    //   13	4	1	localObject1	Object
    //   18	1	1	localThrowable	java.lang.Throwable
    //   24	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	13	finally
    //   14	16	13	finally
    //   0	2	18	java/lang/Throwable
    //   16	18	18	java/lang/Throwable
    //   0	2	24	finally
    //   16	18	24	finally
  }
  
  public native Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.CProxyStub
 * JD-Core Version:    0.7.0.1
 */