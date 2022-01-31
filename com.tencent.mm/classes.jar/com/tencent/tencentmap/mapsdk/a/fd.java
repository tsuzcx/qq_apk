package com.tencent.tencentmap.mapsdk.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class fd
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    fb.a.a().b().execute(new fe(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      label46:
      return arrayOfBoolean[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      break label46;
    }
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: new 61	java/net/Socket
    //   8: dup
    //   9: invokespecial 63	java/net/Socket:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: new 65	java/net/InetSocketAddress
    //   19: dup
    //   20: aload_0
    //   21: bipush 80
    //   23: invokespecial 68	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   26: sipush 5000
    //   29: invokevirtual 72	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   32: aload 6
    //   34: invokevirtual 75	java/net/Socket:isConnected	()Z
    //   37: istore 5
    //   39: iload 5
    //   41: ifeq +5 -> 46
    //   44: iconst_1
    //   45: istore_3
    //   46: aload 6
    //   48: invokevirtual 78	java/net/Socket:close	()V
    //   51: iload_3
    //   52: ireturn
    //   53: astore_0
    //   54: aconst_null
    //   55: astore 6
    //   57: iload 4
    //   59: istore_3
    //   60: aload 6
    //   62: ifnull -11 -> 51
    //   65: aload 6
    //   67: invokevirtual 78	java/net/Socket:close	()V
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_0
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +8 -> 89
    //   84: aload 6
    //   86: invokevirtual 78	java/net/Socket:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: iload_3
    //   93: ireturn
    //   94: astore 6
    //   96: goto -7 -> 89
    //   99: astore_0
    //   100: goto -21 -> 79
    //   103: astore_0
    //   104: goto -47 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   0	107	1	paramInt1	int
    //   0	107	2	paramInt2	int
    //   4	89	3	bool1	boolean
    //   1	57	4	bool2	boolean
    //   37	3	5	bool3	boolean
    //   12	73	6	localSocket	java.net.Socket
    //   94	1	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   5	14	53	java/lang/Throwable
    //   65	70	72	java/lang/Throwable
    //   5	14	75	finally
    //   46	51	91	java/lang/Throwable
    //   84	89	94	java/lang/Throwable
    //   14	39	99	finally
    //   14	39	103	java/lang/Throwable
  }
  
  public static boolean b()
  {
    return a(a, 80, 5000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fd
 * JD-Core Version:    0.7.0.1
 */