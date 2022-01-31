package com.tencent.mm.plugin.normsg;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(10251);
    try
    {
      this.mNativePtr = paramLong;
      return;
    }
    finally
    {
      AppMethodBeat.o(10251);
    }
  }
  
  private native void nativeFinalize();
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: sipush 10252
    //   3: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 32	com/tencent/mm/plugin/normsg/CProxyStub:nativeFinalize	()V
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_0
    //   15: invokespecial 34	java/lang/Object:finalize	()V
    //   18: sipush 10252
    //   21: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: sipush 10252
    //   31: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_0
    //   38: invokespecial 34	java/lang/Object:finalize	()V
    //   41: sipush 10252
    //   44: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: invokespecial 34	java/lang/Object:finalize	()V
    //   53: sipush 10252
    //   56: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	CProxyStub
    //   25	10	1	localObject1	Object
    //   36	1	1	localThrowable	java.lang.Throwable
    //   48	12	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	14	25	finally
    //   26	28	25	finally
    //   6	8	36	java/lang/Throwable
    //   28	36	36	java/lang/Throwable
    //   6	8	48	finally
    //   28	36	48	finally
  }
  
  public native Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.CProxyStub
 * JD-Core Version:    0.7.0.1
 */