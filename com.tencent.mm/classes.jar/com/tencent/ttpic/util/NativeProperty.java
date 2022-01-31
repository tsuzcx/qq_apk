package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;

public class NativeProperty
{
  private static final int ARM_FEATURE_ARMv7 = 1;
  private static final int ARM_FEATURE_NEON = 4;
  private static final int FAMILY_ARM = 1;
  private static final int FAMILY_ARM64 = 4;
  private static int cpuFamily;
  private static int cpuFeature;
  
  static
  {
    AppMethodBeat.i(83937);
    cpuFamily = 1;
    try
    {
      System.loadLibrary("pitu_tools");
      String str = getSystemProperty("ro.product.cpu.abi");
      if ((str == null) || (str.equals("x86")))
      {
        cpuFeature = 5;
        AppMethodBeat.o(83937);
        return;
      }
      cpuFeature = nGetCpuInfo();
      AppMethodBeat.o(83937);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      LogUtils.e(localUnsatisfiedLinkError);
      AppMethodBeat.o(83937);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      LogUtils.e(localRuntimeException);
      AppMethodBeat.o(83937);
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(localException);
      AppMethodBeat.o(83937);
    }
  }
  
  public static int cpuFeature()
  {
    return cpuFeature;
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 74
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 76	java/io/BufferedReader
    //   10: dup
    //   11: new 78	java/io/InputStreamReader
    //   14: dup
    //   15: invokestatic 84	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   18: ldc 86
    //   20: aload_0
    //   21: invokestatic 90	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   24: invokevirtual 93	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 97	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   30: invokevirtual 103	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   33: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   36: sipush 1024
    //   39: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   49: astore_2
    //   50: aload_1
    //   51: astore_0
    //   52: aload_1
    //   53: invokevirtual 116	java/io/BufferedReader:close	()V
    //   56: aload_1
    //   57: invokevirtual 116	java/io/BufferedReader:close	()V
    //   60: ldc 74
    //   62: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_2
    //   66: areturn
    //   67: astore_0
    //   68: aload_0
    //   69: invokestatic 67	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   72: goto -12 -> 60
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: aload_2
    //   81: invokestatic 67	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 116	java/io/BufferedReader:close	()V
    //   92: ldc 74
    //   94: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokestatic 67	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   104: goto -12 -> 92
    //   107: astore_0
    //   108: aload_2
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 116	java/io/BufferedReader:close	()V
    //   118: ldc 74
    //   120: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: athrow
    //   125: astore_1
    //   126: aload_1
    //   127: invokestatic 67	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/Throwable;)V
    //   130: goto -12 -> 118
    //   133: astore_2
    //   134: aload_0
    //   135: astore_1
    //   136: aload_2
    //   137: astore_0
    //   138: goto -28 -> 110
    //   141: astore_2
    //   142: goto -64 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   42	73	1	localObject1	Object
    //   125	2	1	localIOException1	java.io.IOException
    //   135	1	1	str1	String
    //   1	65	2	str2	String
    //   75	34	2	localIOException2	java.io.IOException
    //   133	4	2	localObject2	Object
    //   141	1	2	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   56	60	67	java/io/IOException
    //   7	43	75	java/io/IOException
    //   88	92	99	java/io/IOException
    //   7	43	107	finally
    //   114	118	125	java/io/IOException
    //   45	50	133	finally
    //   52	56	133	finally
    //   80	84	133	finally
    //   45	50	141	java/io/IOException
    //   52	56	141	java/io/IOException
  }
  
  public static boolean hasNeonFeature()
  {
    return (1 == cpuFamily) && ((cpuFeature & 0x4) != 0);
  }
  
  public static boolean isArmV7Feature()
  {
    return ((1 == cpuFamily) && ((cpuFeature & 0x1) != 0)) || (4 == cpuFamily);
  }
  
  private static native int nGetCpuInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.NativeProperty
 * JD-Core Version:    0.7.0.1
 */