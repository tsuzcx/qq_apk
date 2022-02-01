package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.apache.commons.b.a.b;

public final class d
{
  public static final char ajUN;
  public static final String ajUO;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: sipush 10310
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 21	java/io/File:separatorChar	C
    //   9: putstatic 23	org/apache/commons/b/d:ajUN	C
    //   12: new 25	org/apache/commons/b/a/b
    //   15: dup
    //   16: iconst_0
    //   17: invokespecial 29	org/apache/commons/b/a/b:<init>	(B)V
    //   20: astore_0
    //   21: new 31	java/io/PrintWriter
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 34	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 37	java/io/PrintWriter:println	()V
    //   34: aload_0
    //   35: invokevirtual 41	org/apache/commons/b/a/b:toString	()Ljava/lang/String;
    //   38: putstatic 43	org/apache/commons/b/d:ajUO	Ljava/lang/String;
    //   41: aload_3
    //   42: invokevirtual 46	java/io/PrintWriter:close	()V
    //   45: aload_0
    //   46: invokevirtual 47	org/apache/commons/b/a/b:close	()V
    //   49: sipush 10310
    //   52: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: astore_1
    //   57: sipush 10310
    //   60: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_2
    //   66: aload_1
    //   67: ifnull +50 -> 117
    //   70: aload_3
    //   71: invokevirtual 46	java/io/PrintWriter:close	()V
    //   74: sipush 10310
    //   77: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_2
    //   81: athrow
    //   82: astore_1
    //   83: sipush 10310
    //   86: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull +40 -> 133
    //   96: aload_0
    //   97: invokevirtual 47	org/apache/commons/b/a/b:close	()V
    //   100: sipush 10310
    //   103: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_3
    //   109: aload_1
    //   110: aload_3
    //   111: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   114: goto -40 -> 74
    //   117: aload_3
    //   118: invokevirtual 46	java/io/PrintWriter:close	()V
    //   121: goto -47 -> 74
    //   124: astore_0
    //   125: aload_1
    //   126: aload_0
    //   127: invokevirtual 56	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   130: goto -30 -> 100
    //   133: aload_0
    //   134: invokevirtual 47	org/apache/commons/b/a/b:close	()V
    //   137: goto -37 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	77	0	localb	b
    //   124	10	0	localThrowable1	Throwable
    //   56	11	1	localObject1	Object
    //   82	44	1	localObject2	Object
    //   65	16	2	localObject3	Object
    //   91	16	2	localObject4	Object
    //   29	42	3	localPrintWriter	java.io.PrintWriter
    //   108	10	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   30	41	56	finally
    //   57	65	65	finally
    //   21	30	82	finally
    //   41	45	82	finally
    //   74	82	82	finally
    //   109	114	82	finally
    //   117	121	82	finally
    //   83	91	91	finally
    //   70	74	108	finally
    //   96	100	124	finally
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
  
  public static String a(InputStream paramInputStream, Charset paramCharset)
  {
    AppMethodBeat.i(178789);
    b localb = new b();
    try
    {
      a(new InputStreamReader(paramInputStream, a.b(paramCharset)), localb, new char[4096]);
      paramInputStream = localb.toString();
      localb.close();
      AppMethodBeat.o(178789);
      return paramInputStream;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(178789);
        throw paramInputStream;
      }
      finally {}
    }
    for (;;)
    {
      try
      {
        localb.close();
        AppMethodBeat.o(178789);
        throw paramCharset;
      }
      finally
      {
        paramInputStream.addSuppressed(localThrowable);
      }
      localThrowable.close();
    }
  }
  
  public static void a(URLConnection paramURLConnection)
  {
    AppMethodBeat.i(187165);
    if ((paramURLConnection instanceof HttpURLConnection)) {
      ((HttpURLConnection)paramURLConnection).disconnect();
    }
    AppMethodBeat.o(187165);
  }
  
  @Deprecated
  public static void ai(InputStream paramInputStream)
  {
    AppMethodBeat.i(10304);
    closeQuietly(paramInputStream);
    AppMethodBeat.o(10304);
  }
  
  public static long b(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    AppMethodBeat.i(187197);
    byte[] arrayOfByte = new byte[paramInt];
    for (long l = 0L;; l += paramInt)
    {
      paramInt = paramInputStream.read(arrayOfByte);
      if (-1 == paramInt) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, paramInt);
    }
    AppMethodBeat.o(187197);
    return l;
  }
  
  @Deprecated
  public static void b(Reader paramReader)
  {
    AppMethodBeat.i(187169);
    closeQuietly(paramReader);
    AppMethodBeat.o(187169);
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
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(10308);
    long l = f(paramInputStream, paramOutputStream);
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
  public static void e(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(10305);
    closeQuietly(paramOutputStream);
    AppMethodBeat.o(10305);
  }
  
  private static long f(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(187198);
    long l = b(paramInputStream, paramOutputStream, 4096);
    AppMethodBeat.o(187198);
    return l;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(10307);
    org.apache.commons.b.a.a locala = new org.apache.commons.b.a.a();
    try
    {
      copy(paramInputStream, locala);
      paramInputStream = locala.toByteArray();
      locala.close();
      AppMethodBeat.o(10307);
      return paramInputStream;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(10307);
        throw paramInputStream;
      }
      finally {}
    }
    for (;;)
    {
      try
      {
        locala.close();
        AppMethodBeat.o(10307);
        throw localObject;
      }
      finally
      {
        paramInputStream.addSuppressed(localThrowable);
      }
      localThrowable.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.b.d
 * JD-Core Version:    0.7.0.1
 */