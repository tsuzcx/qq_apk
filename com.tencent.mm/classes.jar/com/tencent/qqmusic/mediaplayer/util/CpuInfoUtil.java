package com.tencent.qqmusic.mediaplayer.util;

public class CpuInfoUtil
{
  private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
  private static final String TAG = "CpuInfoUtil";
  private static OutputCpuThread mCurrThread = null;
  
  public static void outputCpuHZToLog() {}
  
  public static void outputThreadInfoToLog() {}
  
  public static void startProcessInfoOutput() {}
  
  public static void stopProcessInfoOutput()
  {
    try
    {
      mCurrThread = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class OutputCpuThread
    extends Thread
  {
    public boolean isStop = false;
    
    public OutputCpuThread(String paramString)
    {
      super();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: ldc 23
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokespecial 31	java/lang/Thread:run	()V
      //   9: new 33	java/lang/StringBuilder
      //   12: dup
      //   13: invokespecial 35	java/lang/StringBuilder:<init>	()V
      //   16: astore 5
      //   18: invokestatic 41	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   21: ldc 43
      //   23: invokevirtual 47	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
      //   26: astore_2
      //   27: new 49	java/io/BufferedReader
      //   30: dup
      //   31: new 51	java/io/InputStreamReader
      //   34: dup
      //   35: aload_2
      //   36: invokevirtual 57	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   39: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   42: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   45: astore 7
      //   47: iconst_0
      //   48: istore_1
      //   49: aload_2
      //   50: astore 4
      //   52: aload 7
      //   54: astore_3
      //   55: aload 7
      //   57: invokevirtual 67	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   60: astore 6
      //   62: aload 6
      //   64: ifnull +116 -> 180
      //   67: aload_2
      //   68: astore 4
      //   70: aload 7
      //   72: astore_3
      //   73: aload_0
      //   74: getfield 15	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil$OutputCpuThread:isStop	Z
      //   77: ifne +103 -> 180
      //   80: iload_1
      //   81: iconst_1
      //   82: iadd
      //   83: istore_1
      //   84: aload_2
      //   85: astore 4
      //   87: aload 7
      //   89: astore_3
      //   90: aload 5
      //   92: aload 6
      //   94: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: ldc 73
      //   99: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: pop
      //   103: iload_1
      //   104: bipush 15
      //   106: if_icmple +241 -> 347
      //   109: aload_2
      //   110: astore 4
      //   112: aload 7
      //   114: astore_3
      //   115: ldc 75
      //   117: aload 5
      //   119: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   122: invokestatic 84	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   125: aload_2
      //   126: astore 4
      //   128: aload 7
      //   130: astore_3
      //   131: aload 5
      //   133: iconst_0
      //   134: aload 5
      //   136: invokevirtual 88	java/lang/StringBuilder:length	()I
      //   139: iconst_1
      //   140: isub
      //   141: invokevirtual 92	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
      //   144: pop
      //   145: aload_2
      //   146: astore 4
      //   148: aload 7
      //   150: astore_3
      //   151: ldc2_w 93
      //   154: invokestatic 98	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil$OutputCpuThread:sleep	(J)V
      //   157: iconst_0
      //   158: istore_1
      //   159: goto -110 -> 49
      //   162: astore 6
      //   164: aload_2
      //   165: astore 4
      //   167: aload 7
      //   169: astore_3
      //   170: ldc 75
      //   172: aload 6
      //   174: invokestatic 102	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   177: goto -128 -> 49
      //   180: aload 7
      //   182: invokevirtual 105	java/io/BufferedReader:close	()V
      //   185: aload_2
      //   186: ifnull +117 -> 303
      //   189: aload_2
      //   190: invokevirtual 108	java/lang/Process:destroy	()V
      //   193: ldc 23
      //   195: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   198: return
      //   199: astore_3
      //   200: ldc 75
      //   202: aload_3
      //   203: invokestatic 102	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   206: goto -21 -> 185
      //   209: astore 6
      //   211: aconst_null
      //   212: astore 5
      //   214: aconst_null
      //   215: astore_2
      //   216: aload 5
      //   218: astore 4
      //   220: aload_2
      //   221: astore_3
      //   222: ldc 75
      //   224: aload 6
      //   226: invokestatic 102	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   229: aload_2
      //   230: ifnull +7 -> 237
      //   233: aload_2
      //   234: invokevirtual 105	java/io/BufferedReader:close	()V
      //   237: aload 5
      //   239: ifnull +64 -> 303
      //   242: aload 5
      //   244: invokevirtual 108	java/lang/Process:destroy	()V
      //   247: ldc 23
      //   249: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   252: return
      //   253: astore_2
      //   254: ldc 75
      //   256: aload_2
      //   257: invokestatic 102	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   260: goto -23 -> 237
      //   263: astore 5
      //   265: aconst_null
      //   266: astore_2
      //   267: aconst_null
      //   268: astore_3
      //   269: aload_3
      //   270: ifnull +7 -> 277
      //   273: aload_3
      //   274: invokevirtual 105	java/io/BufferedReader:close	()V
      //   277: aload_2
      //   278: ifnull +7 -> 285
      //   281: aload_2
      //   282: invokevirtual 108	java/lang/Process:destroy	()V
      //   285: ldc 23
      //   287: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   290: aload 5
      //   292: athrow
      //   293: astore_3
      //   294: ldc 75
      //   296: aload_3
      //   297: invokestatic 102	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   300: goto -23 -> 277
      //   303: ldc 23
      //   305: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   308: return
      //   309: astore 5
      //   311: aconst_null
      //   312: astore_3
      //   313: goto -44 -> 269
      //   316: astore 5
      //   318: aload 4
      //   320: astore_2
      //   321: goto -52 -> 269
      //   324: astore 6
      //   326: aconst_null
      //   327: astore_3
      //   328: aload_2
      //   329: astore 5
      //   331: aload_3
      //   332: astore_2
      //   333: goto -117 -> 216
      //   336: astore 6
      //   338: aload_2
      //   339: astore 5
      //   341: aload 7
      //   343: astore_2
      //   344: goto -128 -> 216
      //   347: goto -298 -> 49
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	350	0	this	OutputCpuThread
      //   48	111	1	i	int
      //   26	208	2	localProcess1	java.lang.Process
      //   253	4	2	localIOException1	java.io.IOException
      //   266	78	2	localObject1	Object
      //   54	116	3	localBufferedReader1	java.io.BufferedReader
      //   199	4	3	localIOException2	java.io.IOException
      //   221	53	3	localProcess2	java.lang.Process
      //   293	4	3	localIOException3	java.io.IOException
      //   312	20	3	localObject2	Object
      //   50	269	4	localObject3	Object
      //   16	227	5	localStringBuilder	java.lang.StringBuilder
      //   263	28	5	localObject4	Object
      //   309	1	5	localObject5	Object
      //   316	1	5	localObject6	Object
      //   329	11	5	localObject7	Object
      //   60	33	6	str	String
      //   162	11	6	localException1	java.lang.Exception
      //   209	16	6	localException2	java.lang.Exception
      //   324	1	6	localException3	java.lang.Exception
      //   336	1	6	localException4	java.lang.Exception
      //   45	297	7	localBufferedReader2	java.io.BufferedReader
      // Exception table:
      //   from	to	target	type
      //   115	125	162	java/lang/Exception
      //   131	145	162	java/lang/Exception
      //   151	157	162	java/lang/Exception
      //   180	185	199	java/io/IOException
      //   18	27	209	java/lang/Exception
      //   233	237	253	java/io/IOException
      //   18	27	263	finally
      //   273	277	293	java/io/IOException
      //   27	47	309	finally
      //   55	62	316	finally
      //   73	80	316	finally
      //   90	103	316	finally
      //   115	125	316	finally
      //   131	145	316	finally
      //   151	157	316	finally
      //   170	177	316	finally
      //   222	229	316	finally
      //   27	47	324	java/lang/Exception
      //   55	62	336	java/lang/Exception
      //   73	80	336	java/lang/Exception
      //   90	103	336	java/lang/Exception
      //   170	177	336	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.CpuInfoUtil
 * JD-Core Version:    0.7.0.1
 */