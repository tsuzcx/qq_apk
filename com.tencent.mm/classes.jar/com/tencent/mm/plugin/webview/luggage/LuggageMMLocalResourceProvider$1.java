package com.tencent.mm.plugin.webview.luggage;

import java.io.PipedOutputStream;

final class LuggageMMLocalResourceProvider$1
  implements Runnable
{
  LuggageMMLocalResourceProvider$1(LuggageMMLocalResourceProvider paramLuggageMMLocalResourceProvider, LuggageMMLocalResourceProvider.GetLocalResourceInfoTask paramGetLocalResourceInfoTask, PipedOutputStream paramPipedOutputStream) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: new 34	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 23	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:rbw	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$GetLocalResourceInfoTask;
    //   8: getfield 40	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$GetLocalResourceInfoTask:path	Ljava/lang/String;
    //   11: invokespecial 43	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 25	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:rbx	Ljava/io/PipedOutputStream;
    //   20: invokestatic 47	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   23: aload_1
    //   24: invokevirtual 50	java/io/FileInputStream:close	()V
    //   27: aload_0
    //   28: getfield 25	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:rbx	Ljava/io/PipedOutputStream;
    //   31: invokevirtual 53	java/io/PipedOutputStream:close	()V
    //   34: return
    //   35: astore_1
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull +7 -> 46
    //   42: aload_1
    //   43: invokevirtual 50	java/io/FileInputStream:close	()V
    //   46: aload_0
    //   47: getfield 25	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:rbx	Ljava/io/PipedOutputStream;
    //   50: invokevirtual 53	java/io/PipedOutputStream:close	()V
    //   53: return
    //   54: astore_1
    //   55: return
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 50	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: getfield 25	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:rbx	Ljava/io/PipedOutputStream;
    //   71: invokevirtual 53	java/io/PipedOutputStream:close	()V
    //   74: aload_1
    //   75: athrow
    //   76: astore_2
    //   77: goto -3 -> 74
    //   80: astore_2
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: astore_2
    //   87: goto -28 -> 59
    //   90: astore_2
    //   91: goto -53 -> 38
    //   94: astore_1
    //   95: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	1
    //   14	10	1	localFileInputStream	java.io.FileInputStream
    //   35	1	1	localException1	java.lang.Exception
    //   37	6	1	localObject1	Object
    //   54	1	1	localException2	java.lang.Exception
    //   56	26	1	localObject2	Object
    //   84	1	1	localObject3	Object
    //   94	1	1	localException3	java.lang.Exception
    //   58	6	2	localObject4	Object
    //   76	1	2	localException4	java.lang.Exception
    //   80	4	2	localObject5	Object
    //   86	1	2	localObject6	Object
    //   90	1	2	localException5	java.lang.Exception
    //   82	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	35	java/lang/Exception
    //   42	46	54	java/lang/Exception
    //   46	53	54	java/lang/Exception
    //   0	15	56	finally
    //   63	67	76	java/lang/Exception
    //   67	74	76	java/lang/Exception
    //   15	23	80	finally
    //   15	23	90	java/lang/Exception
    //   23	34	94	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.1
 * JD-Core Version:    0.7.0.1
 */