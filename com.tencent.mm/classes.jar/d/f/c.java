package d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.io.Reader;
import java.io.Writer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class c
{
  public static final long a(Reader paramReader, Writer paramWriter)
  {
    AppMethodBeat.i(129250);
    p.h(paramReader, "$this$copyTo");
    p.h(paramWriter, "out");
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
  
  /* Error */
  public static final byte[] e(java.net.URL paramURL)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 78
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 80
    //   10: invokestatic 56	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 86	java/net/URL:openStream	()Ljava/io/InputStream;
    //   17: checkcast 88	java/io/Closeable
    //   20: astore_2
    //   21: aload_2
    //   22: checkcast 90	java/io/InputStream
    //   25: astore_0
    //   26: aload_0
    //   27: ldc 92
    //   29: invokestatic 95	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokestatic 101	d/f/a:X	(Ljava/io/InputStream;)[B
    //   36: astore_0
    //   37: aload_2
    //   38: aconst_null
    //   39: invokestatic 106	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   42: ldc 78
    //   44: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: areturn
    //   49: astore_1
    //   50: ldc 78
    //   52: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_0
    //   58: aload_2
    //   59: aload_1
    //   60: invokestatic 106	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   63: ldc 78
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
 * Qualified Name:     d.f.c
 * JD-Core Version:    0.7.0.1
 */