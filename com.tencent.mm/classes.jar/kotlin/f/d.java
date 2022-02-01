package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class d
{
  private static long a(Reader paramReader, Writer paramWriter)
  {
    AppMethodBeat.i(129250);
    p.k(paramReader, "$this$copyTo");
    p.k(paramWriter, "out");
    long l = 0L;
    char[] arrayOfChar = new char[8192];
    for (int i = paramReader.read(arrayOfChar); i >= 0; i = paramReader.read(arrayOfChar))
    {
      paramWriter.write(arrayOfChar, 0, i);
      l += i;
    }
    AppMethodBeat.o(129250);
    return l;
  }
  
  public static final String a(Reader paramReader)
  {
    AppMethodBeat.i(216989);
    p.k(paramReader, "$this$readText");
    StringWriter localStringWriter = new StringWriter();
    b(paramReader, (Writer)localStringWriter);
    paramReader = localStringWriter.toString();
    p.j(paramReader, "buffer.toString()");
    AppMethodBeat.o(216989);
    return paramReader;
  }
  
  /* Error */
  public static final void a(Reader paramReader, kotlin.g.a.b<? super String, kotlin.x> paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 99
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 101
    //   10: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc 102
    //   16: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: new 104	java/io/BufferedReader
    //   22: dup
    //   23: aload_0
    //   24: sipush 8192
    //   27: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   30: checkcast 109	java/io/Closeable
    //   33: astore_3
    //   34: aload_3
    //   35: checkcast 104	java/io/BufferedReader
    //   38: astore_0
    //   39: aload_0
    //   40: ldc 111
    //   42: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   45: new 113	kotlin/f/c
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 116	kotlin/f/c:<init>	(Ljava/io/BufferedReader;)V
    //   53: checkcast 118	kotlin/m/h
    //   56: invokestatic 123	kotlin/m/i:a	(Lkotlin/m/h;)Lkotlin/m/h;
    //   59: invokeinterface 127 1 0
    //   64: astore_0
    //   65: aload_0
    //   66: invokeinterface 133 1 0
    //   71: ifeq +40 -> 111
    //   74: aload_1
    //   75: aload_0
    //   76: invokeinterface 137 1 0
    //   81: invokeinterface 143 2 0
    //   86: pop
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: ldc 99
    //   93: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: athrow
    //   98: astore_0
    //   99: aload_3
    //   100: aload_1
    //   101: invokestatic 148	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   104: ldc 99
    //   106: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: athrow
    //   111: getstatic 154	kotlin/x:aazN	Lkotlin/x;
    //   114: astore_0
    //   115: aload_3
    //   116: aconst_null
    //   117: invokestatic 148	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   120: ldc 99
    //   122: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: return
    //   126: astore_0
    //   127: aload_2
    //   128: astore_1
    //   129: goto -30 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramReader	Reader
    //   0	132	1	paramb	kotlin.g.a.b<? super String, kotlin.x>
    //   1	127	2	localObject	Object
    //   33	83	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   34	65	90	java/lang/Throwable
    //   65	87	90	java/lang/Throwable
    //   111	115	90	java/lang/Throwable
    //   91	98	98	finally
    //   34	65	126	finally
    //   65	87	126	finally
    //   111	115	126	finally
  }
  
  /* Error */
  public static final byte[] e(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 162
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 164
    //   10: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 170	java/net/URL:openStream	()Ljava/io/InputStream;
    //   17: checkcast 109	java/io/Closeable
    //   20: astore_2
    //   21: aload_2
    //   22: checkcast 172	java/io/InputStream
    //   25: astore_0
    //   26: aload_0
    //   27: ldc 174
    //   29: invokestatic 95	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokestatic 180	kotlin/f/a:S	(Ljava/io/InputStream;)[B
    //   36: astore_0
    //   37: aload_2
    //   38: aconst_null
    //   39: invokestatic 148	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   42: ldc 162
    //   44: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: ldc 162
    //   52: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_0
    //   58: aload_2
    //   59: aload_1
    //   60: invokestatic 148	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   63: ldc 162
    //   65: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: goto -13 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramURL	java.net.URL
    //   1	1	1	localObject	Object
    //   49	11	1	localThrowable	java.lang.Throwable
    //   20	39	2	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   21	37	49	java/lang/Throwable
    //   50	57	57	finally
    //   21	37	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.f.d
 * JD-Core Version:    0.7.0.1
 */