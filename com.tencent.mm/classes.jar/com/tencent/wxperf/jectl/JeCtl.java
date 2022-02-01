package com.tencent.wxperf.jectl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;

public class JeCtl
{
  private static boolean initialized;
  
  static
  {
    AppMethodBeat.i(216710);
    initialized = false;
    try
    {
      System.loadLibrary("wxperf-jectl");
      initNative();
      initialized = true;
      AppMethodBeat.o(216710);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.printStack(6, "Wxperf.JeCtl", localThrowable);
      AppMethodBeat.o(216710);
    }
  }
  
  private static native int compactNative();
  
  private static native String getVersionNative();
  
  private static native void initNative();
  
  private static native int preAllocRetainNative(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  /* Error */
  public static String version()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 53
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 19	com/tencent/wxperf/jectl/JeCtl:initialized	Z
    //   11: ifne +23 -> 34
    //   14: ldc 35
    //   16: ldc 55
    //   18: invokestatic 59	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 61
    //   23: astore_0
    //   24: ldc 53
    //   26: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: invokestatic 63	com/tencent/wxperf/jectl/JeCtl:getVersionNative	()Ljava/lang/String;
    //   37: astore_0
    //   38: ldc 53
    //   40: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -14 -> 29
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	15	0	str	String
    //   46	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	46	finally
    //   24	29	46	finally
    //   34	43	46	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxperf.jectl.JeCtl
 * JD-Core Version:    0.7.0.1
 */