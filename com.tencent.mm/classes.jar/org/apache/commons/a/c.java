package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
  public static final char DIR_SEPARATOR;
  public static final String LINE_SEPARATOR;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 13
    //   4: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 24	java/io/File:separatorChar	C
    //   10: putstatic 26	org/apache/commons/a/c:DIR_SEPARATOR	C
    //   13: new 28	org/apache/commons/a/a/b
    //   16: dup
    //   17: iconst_0
    //   18: invokespecial 32	org/apache/commons/a/a/b:<init>	(B)V
    //   21: astore_3
    //   22: new 34	java/io/PrintWriter
    //   25: dup
    //   26: aload_3
    //   27: invokespecial 37	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   30: astore 4
    //   32: aload 4
    //   34: invokevirtual 40	java/io/PrintWriter:println	()V
    //   37: aload_3
    //   38: invokevirtual 44	org/apache/commons/a/a/b:toString	()Ljava/lang/String;
    //   41: putstatic 46	org/apache/commons/a/c:LINE_SEPARATOR	Ljava/lang/String;
    //   44: aload 4
    //   46: invokevirtual 49	java/io/PrintWriter:close	()V
    //   49: aload_3
    //   50: invokevirtual 50	org/apache/commons/a/a/b:close	()V
    //   53: ldc 13
    //   55: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_1
    //   60: ldc 13
    //   62: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_1
    //   66: athrow
    //   67: astore_0
    //   68: aload_1
    //   69: ifnull +50 -> 119
    //   72: aload 4
    //   74: invokevirtual 49	java/io/PrintWriter:close	()V
    //   77: ldc 13
    //   79: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_1
    //   85: ldc 13
    //   87: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: athrow
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +42 -> 136
    //   97: aload_3
    //   98: invokevirtual 50	org/apache/commons/a/a/b:close	()V
    //   101: ldc 13
    //   103: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: athrow
    //   108: astore 4
    //   110: aload_1
    //   111: aload 4
    //   113: invokevirtual 57	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   116: goto -39 -> 77
    //   119: aload 4
    //   121: invokevirtual 49	java/io/PrintWriter:close	()V
    //   124: goto -47 -> 77
    //   127: astore_2
    //   128: aload_1
    //   129: aload_2
    //   130: invokevirtual 57	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   133: goto -32 -> 101
    //   136: aload_3
    //   137: invokevirtual 50	org/apache/commons/a/a/b:close	()V
    //   140: goto -39 -> 101
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_1
    //   146: goto -78 -> 68
    //   149: astore_0
    //   150: aload_2
    //   151: astore_1
    //   152: goto -59 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	16	0	localObject1	Object
    //   92	15	0	localObject2	Object
    //   143	1	0	localObject3	Object
    //   149	1	0	localObject4	Object
    //   59	10	1	localThrowable1	java.lang.Throwable
    //   84	45	1	localThrowable2	java.lang.Throwable
    //   145	7	1	localThrowable3	java.lang.Throwable
    //   1	1	2	localObject5	Object
    //   127	24	2	localThrowable4	java.lang.Throwable
    //   21	116	3	localb	org.apache.commons.a.a.b
    //   30	43	4	localPrintWriter	java.io.PrintWriter
    //   108	12	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   32	44	59	java/lang/Throwable
    //   60	67	67	finally
    //   22	32	84	java/lang/Throwable
    //   44	49	84	java/lang/Throwable
    //   77	84	84	java/lang/Throwable
    //   110	116	84	java/lang/Throwable
    //   119	124	84	java/lang/Throwable
    //   85	92	92	finally
    //   72	77	108	java/lang/Throwable
    //   97	101	127	java/lang/Throwable
    //   32	44	143	finally
    //   22	32	149	finally
    //   44	49	149	finally
    //   72	77	149	finally
    //   77	84	149	finally
    //   110	116	149	finally
    //   119	124	149	finally
  }
  
  @Deprecated
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(151732);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(151732);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(151732);
    }
  }
  
  @Deprecated
  public static void closeQuietly(InputStream paramInputStream)
  {
    AppMethodBeat.i(151730);
    closeQuietly(paramInputStream);
    AppMethodBeat.o(151730);
  }
  
  @Deprecated
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(151731);
    closeQuietly(paramOutputStream);
    AppMethodBeat.o(151731);
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(151733);
    long l = e(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
    {
      AppMethodBeat.o(151733);
      return -1;
    }
    int i = (int)l;
    AppMethodBeat.o(151733);
    return i;
  }
  
  private static long e(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(151734);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(151734);
    return l;
  }
  
  /* Error */
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 101	org/apache/commons/a/a/a
    //   8: dup
    //   9: invokespecial 103	org/apache/commons/a/a/a:<init>	()V
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_1
    //   15: aload_0
    //   16: aload_2
    //   17: invokestatic 105	org/apache/commons/a/c:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   20: pop
    //   21: aload_2
    //   22: invokevirtual 108	org/apache/commons/a/a/a:toByteArray	()[B
    //   25: astore_0
    //   26: aload_2
    //   27: invokevirtual 109	org/apache/commons/a/a/a:close	()V
    //   30: ldc 99
    //   32: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: areturn
    //   37: astore_1
    //   38: ldc 99
    //   40: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_1
    //   44: athrow
    //   45: astore_0
    //   46: aload_1
    //   47: ifnull +23 -> 70
    //   50: aload_2
    //   51: invokevirtual 109	org/apache/commons/a/a/a:close	()V
    //   54: ldc 99
    //   56: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: athrow
    //   61: astore_2
    //   62: aload_1
    //   63: aload_2
    //   64: invokevirtual 57	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   67: goto -13 -> 54
    //   70: aload_2
    //   71: invokevirtual 109	org/apache/commons/a/a/a:close	()V
    //   74: goto -20 -> 54
    //   77: astore_0
    //   78: goto -32 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramInputStream	InputStream
    //   14	1	1	localObject	Object
    //   37	26	1	localThrowable1	java.lang.Throwable
    //   12	39	2	locala	org.apache.commons.a.a.a
    //   61	10	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	26	37	java/lang/Throwable
    //   38	45	45	finally
    //   50	54	61	java/lang/Throwable
    //   15	26	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.a.c
 * JD-Core Version:    0.7.0.1
 */