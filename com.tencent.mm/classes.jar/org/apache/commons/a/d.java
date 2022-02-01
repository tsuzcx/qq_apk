package org.apache.commons.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public final class d
{
  public static final String Kdb;
  public static final char Kks;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: sipush 10310
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 23	java/io/File:separatorChar	C
    //   11: putstatic 25	org/apache/commons/a/d:Kks	C
    //   14: new 27	org/apache/commons/a/a/b
    //   17: dup
    //   18: iconst_0
    //   19: invokespecial 31	org/apache/commons/a/a/b:<init>	(B)V
    //   22: astore_3
    //   23: new 33	java/io/PrintWriter
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 36	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 39	java/io/PrintWriter:println	()V
    //   38: aload_3
    //   39: invokevirtual 43	org/apache/commons/a/a/b:toString	()Ljava/lang/String;
    //   42: putstatic 45	org/apache/commons/a/d:Kdb	Ljava/lang/String;
    //   45: aload 4
    //   47: invokevirtual 48	java/io/PrintWriter:close	()V
    //   50: aload_3
    //   51: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   54: sipush 10310
    //   57: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: astore_1
    //   62: sipush 10310
    //   65: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_1
    //   69: athrow
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull +53 -> 125
    //   75: aload 4
    //   77: invokevirtual 48	java/io/PrintWriter:close	()V
    //   80: sipush 10310
    //   83: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: athrow
    //   88: astore_1
    //   89: sipush 10310
    //   92: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: aload_1
    //   99: ifnull +43 -> 142
    //   102: aload_3
    //   103: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   106: sipush 10310
    //   109: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: aload_0
    //   113: athrow
    //   114: astore 4
    //   116: aload_1
    //   117: aload 4
    //   119: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   122: goto -42 -> 80
    //   125: aload 4
    //   127: invokevirtual 48	java/io/PrintWriter:close	()V
    //   130: goto -50 -> 80
    //   133: astore_2
    //   134: aload_1
    //   135: aload_2
    //   136: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   139: goto -33 -> 106
    //   142: aload_3
    //   143: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   146: goto -40 -> 106
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_1
    //   152: goto -81 -> 71
    //   155: astore_0
    //   156: aload_2
    //   157: astore_1
    //   158: goto -60 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   70	17	0	localObject1	Object
    //   97	16	0	localObject2	Object
    //   149	1	0	localObject3	Object
    //   155	1	0	localObject4	Object
    //   61	11	1	localThrowable1	java.lang.Throwable
    //   88	47	1	localThrowable2	java.lang.Throwable
    //   151	7	1	localThrowable3	java.lang.Throwable
    //   1	1	2	localObject5	Object
    //   133	24	2	localThrowable4	java.lang.Throwable
    //   22	121	3	localb	org.apache.commons.a.a.b
    //   31	45	4	localPrintWriter	java.io.PrintWriter
    //   114	12	4	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   33	45	61	java/lang/Throwable
    //   62	70	70	finally
    //   23	33	88	java/lang/Throwable
    //   45	50	88	java/lang/Throwable
    //   80	88	88	java/lang/Throwable
    //   116	122	88	java/lang/Throwable
    //   125	130	88	java/lang/Throwable
    //   89	97	97	finally
    //   75	80	114	java/lang/Throwable
    //   102	106	133	java/lang/Throwable
    //   33	45	149	finally
    //   23	33	155	finally
    //   45	50	155	finally
    //   75	80	155	finally
    //   80	88	155	finally
    //   116	122	155	finally
    //   125	130	155	finally
  }
  
  @Deprecated
  public static void X(InputStream paramInputStream)
  {
    AppMethodBeat.i(10304);
    closeQuietly(paramInputStream);
    AppMethodBeat.o(10304);
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(186841);
    byte[] arrayOfByte = new byte[paramInt];
    for (long l = 0L;; l += paramInt)
    {
      paramInt = paramInputStream.read(arrayOfByte);
      if (-1 == paramInt) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, paramInt);
    }
    AppMethodBeat.o(186841);
    return l;
  }
  
  private static long a(Reader paramReader, Writer paramWriter, char[] paramArrayOfChar)
  {
    AppMethodBeat.i(178790);
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(paramArrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(paramArrayOfChar, 0, i);
    }
    AppMethodBeat.o(178790);
    return l;
  }
  
  /* Error */
  public static String a(InputStream paramInputStream, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: ldc 94
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 27	org/apache/commons/a/a/b
    //   8: dup
    //   9: invokespecial 96	org/apache/commons/a/a/b:<init>	()V
    //   12: astore_3
    //   13: aconst_null
    //   14: astore_2
    //   15: new 98	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 103	org/apache/commons/a/a:a	(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;
    //   24: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   27: aload_3
    //   28: sipush 4096
    //   31: newarray char
    //   33: invokestatic 108	org/apache/commons/a/d:a	(Ljava/io/Reader;Ljava/io/Writer;[C)J
    //   36: pop2
    //   37: aload_3
    //   38: invokevirtual 43	org/apache/commons/a/a/b:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: aload_3
    //   43: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   46: ldc 94
    //   48: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: areturn
    //   53: astore_1
    //   54: ldc 94
    //   56: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_1
    //   60: athrow
    //   61: astore_0
    //   62: aload_1
    //   63: ifnull +23 -> 86
    //   66: aload_3
    //   67: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   70: ldc 94
    //   72: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_0
    //   76: athrow
    //   77: astore_2
    //   78: aload_1
    //   79: aload_2
    //   80: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   83: goto -13 -> 70
    //   86: aload_3
    //   87: invokevirtual 49	org/apache/commons/a/a/b:close	()V
    //   90: goto -20 -> 70
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: goto -34 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramInputStream	InputStream
    //   0	99	1	paramCharset	java.nio.charset.Charset
    //   14	1	2	localObject	Object
    //   77	18	2	localThrowable	java.lang.Throwable
    //   12	75	3	localb	org.apache.commons.a.a.b
    // Exception table:
    //   from	to	target	type
    //   15	42	53	java/lang/Throwable
    //   54	61	61	finally
    //   66	70	77	java/lang/Throwable
    //   15	42	93	finally
  }
  
  @Deprecated
  public static void a(Reader paramReader)
  {
    AppMethodBeat.i(186840);
    closeQuietly(paramReader);
    AppMethodBeat.o(186840);
  }
  
  public static void a(URLConnection paramURLConnection)
  {
    AppMethodBeat.i(186839);
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
    AppMethodBeat.o(186839);
  }
  
  public static int c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(10308);
    long l = d(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
    {
      AppMethodBeat.o(10308);
      return -1;
    }
    int i = (int)l;
    AppMethodBeat.o(10308);
    return i;
  }
  
  @Deprecated
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(10306);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(10306);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(10306);
    }
  }
  
  private static long d(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(186842);
    long l = a(paramInputStream, paramOutputStream, 4096);
    AppMethodBeat.o(186842);
    return l;
  }
  
  @Deprecated
  public static void e(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(10305);
    closeQuietly(paramOutputStream);
    AppMethodBeat.o(10305);
  }
  
  /* Error */
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: sipush 10307
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 139	org/apache/commons/a/a/a
    //   9: dup
    //   10: invokespecial 140	org/apache/commons/a/a/a:<init>	()V
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_0
    //   17: aload_2
    //   18: invokestatic 142	org/apache/commons/a/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   21: pop
    //   22: aload_2
    //   23: invokevirtual 145	org/apache/commons/a/a/a:toByteArray	()[B
    //   26: astore_0
    //   27: aload_2
    //   28: invokevirtual 146	org/apache/commons/a/a/a:close	()V
    //   31: sipush 10307
    //   34: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: sipush 10307
    //   43: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_1
    //   47: athrow
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +24 -> 74
    //   53: aload_2
    //   54: invokevirtual 146	org/apache/commons/a/a/a:close	()V
    //   57: sipush 10307
    //   60: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_2
    //   66: aload_1
    //   67: aload_2
    //   68: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   71: goto -14 -> 57
    //   74: aload_2
    //   75: invokevirtual 146	org/apache/commons/a/a/a:close	()V
    //   78: goto -21 -> 57
    //   81: astore_0
    //   82: goto -33 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramInputStream	InputStream
    //   15	1	1	localObject	Object
    //   39	28	1	localThrowable1	java.lang.Throwable
    //   13	41	2	locala	org.apache.commons.a.a.a
    //   65	10	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   16	27	39	java/lang/Throwable
    //   40	48	48	finally
    //   53	57	65	java/lang/Throwable
    //   16	27	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.a.d
 * JD-Core Version:    0.7.0.1
 */