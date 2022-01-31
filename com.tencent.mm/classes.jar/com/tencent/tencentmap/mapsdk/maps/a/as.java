package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class as
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    AppMethodBeat.i(147243);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    aq.a.a().b().execute(new at(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      label51:
      int i = arrayOfBoolean[0];
      AppMethodBeat.o(147243);
      return i;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label51;
    }
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore_3
    //   10: new 71	java/net/Socket
    //   13: dup
    //   14: invokespecial 73	java/net/Socket:<init>	()V
    //   17: astore 6
    //   19: aload 6
    //   21: new 75	java/net/InetSocketAddress
    //   24: dup
    //   25: aload_0
    //   26: bipush 80
    //   28: invokespecial 78	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   31: sipush 5000
    //   34: invokevirtual 82	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   37: aload 6
    //   39: invokevirtual 85	java/net/Socket:isConnected	()Z
    //   42: istore 5
    //   44: iload 5
    //   46: ifeq +5 -> 51
    //   49: iconst_1
    //   50: istore_3
    //   51: aload 6
    //   53: invokevirtual 88	java/net/Socket:close	()V
    //   56: ldc 69
    //   58: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_3
    //   62: ireturn
    //   63: astore_0
    //   64: aconst_null
    //   65: astore 6
    //   67: iload 4
    //   69: istore_3
    //   70: aload 6
    //   72: ifnull -16 -> 56
    //   75: aload 6
    //   77: invokevirtual 88	java/net/Socket:close	()V
    //   80: iload 4
    //   82: istore_3
    //   83: goto -27 -> 56
    //   86: astore_0
    //   87: iload 4
    //   89: istore_3
    //   90: goto -34 -> 56
    //   93: astore_0
    //   94: aconst_null
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +8 -> 107
    //   102: aload 6
    //   104: invokevirtual 88	java/net/Socket:close	()V
    //   107: ldc 69
    //   109: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: goto -59 -> 56
    //   118: astore 6
    //   120: goto -13 -> 107
    //   123: astore_0
    //   124: goto -27 -> 97
    //   127: astore_0
    //   128: goto -61 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   0	131	1	paramInt1	int
    //   0	131	2	paramInt2	int
    //   9	81	3	bool1	boolean
    //   6	82	4	bool2	boolean
    //   42	3	5	bool3	boolean
    //   17	86	6	localSocket	java.net.Socket
    //   118	1	6	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   10	19	63	java/lang/Throwable
    //   75	80	86	java/lang/Throwable
    //   10	19	93	finally
    //   51	56	114	java/lang/Throwable
    //   102	107	118	java/lang/Throwable
    //   19	44	123	finally
    //   19	44	127	java/lang/Throwable
  }
  
  public static boolean b()
  {
    AppMethodBeat.i(147244);
    boolean bool = a(a, 80, 5000);
    AppMethodBeat.o(147244);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.as
 * JD-Core Version:    0.7.0.1
 */