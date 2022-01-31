package com.tencent.mm.plugin.webview.luggage;

final class LuggageMMLocalResourceProvider$1$1
  implements Runnable
{
  LuggageMMLocalResourceProvider$1$1(LuggageMMLocalResourceProvider.1 param1) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 23
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 31	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: getfield 17	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1$1:uRi	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1;
    //   13: getfield 35	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:uRf	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$GetLocalResourceInfoTask;
    //   16: getfield 41	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$GetLocalResourceInfoTask:path	Ljava/lang/String;
    //   19: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: aload_0
    //   25: getfield 17	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1$1:uRi	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1;
    //   28: getfield 48	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:uRg	Ljava/io/PipedOutputStream;
    //   31: invokestatic 54	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   34: aload_1
    //   35: invokevirtual 57	java/io/FileInputStream:close	()V
    //   38: aload_0
    //   39: getfield 17	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1$1:uRi	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1;
    //   42: getfield 48	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:uRg	Ljava/io/PipedOutputStream;
    //   45: invokevirtual 60	java/io/PipedOutputStream:close	()V
    //   48: ldc 23
    //   50: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: astore_1
    //   55: ldc 23
    //   57: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 57	java/io/FileInputStream:close	()V
    //   72: aload_0
    //   73: getfield 17	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1$1:uRi	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1;
    //   76: getfield 48	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:uRg	Ljava/io/PipedOutputStream;
    //   79: invokevirtual 60	java/io/PipedOutputStream:close	()V
    //   82: ldc 23
    //   84: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: astore_1
    //   89: ldc 23
    //   91: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 57	java/io/FileInputStream:close	()V
    //   106: aload_0
    //   107: getfield 17	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1$1:uRi	Lcom/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1;
    //   110: getfield 48	com/tencent/mm/plugin/webview/luggage/LuggageMMLocalResourceProvider$1:uRg	Ljava/io/PipedOutputStream;
    //   113: invokevirtual 60	java/io/PipedOutputStream:close	()V
    //   116: ldc 23
    //   118: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_1
    //   122: athrow
    //   123: astore_2
    //   124: goto -8 -> 116
    //   127: astore_2
    //   128: aload_1
    //   129: astore_3
    //   130: aload_2
    //   131: astore_1
    //   132: aload_3
    //   133: astore_2
    //   134: goto -36 -> 98
    //   137: astore_2
    //   138: goto -74 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	1
    //   22	13	1	localFileInputStream	java.io.FileInputStream
    //   54	1	1	localException1	java.lang.Exception
    //   61	1	1	localException2	java.lang.Exception
    //   63	6	1	localObject1	Object
    //   88	1	1	localException3	java.lang.Exception
    //   95	34	1	localObject2	Object
    //   131	1	1	localObject3	Object
    //   97	6	2	localObject4	Object
    //   123	1	2	localException4	java.lang.Exception
    //   127	4	2	localObject5	Object
    //   133	1	2	localObject6	Object
    //   137	1	2	localException5	java.lang.Exception
    //   129	4	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   34	48	54	java/lang/Exception
    //   5	23	61	java/lang/Exception
    //   68	72	88	java/lang/Exception
    //   72	82	88	java/lang/Exception
    //   5	23	95	finally
    //   102	106	123	java/lang/Exception
    //   106	116	123	java/lang/Exception
    //   23	34	127	finally
    //   23	34	137	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider.1.1
 * JD-Core Version:    0.7.0.1
 */