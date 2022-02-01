package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.m.h;
import kotlin.m.k;

@Metadata(d1={""}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class d
{
  private static long a(Reader paramReader, Writer paramWriter)
  {
    AppMethodBeat.i(129250);
    s.u(paramReader, "$this$copyTo");
    s.u(paramWriter, "out");
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
    AppMethodBeat.i(191244);
    s.u(paramReader, "$this$readText");
    StringWriter localStringWriter = new StringWriter();
    b(paramReader, (Writer)localStringWriter);
    paramReader = localStringWriter.toString();
    s.s(paramReader, "buffer.toString()");
    AppMethodBeat.o(191244);
    return paramReader;
  }
  
  public static final void a(Reader paramReader, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(129249);
    s.u(paramReader, "$this$forEachLine");
    s.u(paramb, "action");
    paramReader = (Closeable)new BufferedReader(paramReader, 8192);
    try
    {
      Object localObject1 = (BufferedReader)paramReader;
      s.u(localObject1, "$this$lineSequence");
      localObject1 = k.a((h)new c((BufferedReader)localObject1)).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramb.invoke(((Iterator)localObject1).next());
      }
      return;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(129249);
        throw paramb;
      }
      finally
      {
        b.a(paramReader, paramb);
        AppMethodBeat.o(129249);
      }
      paramb = ah.aiuX;
      b.a(paramReader, null);
      AppMethodBeat.o(129249);
    }
  }
  
  public static final byte[] e(URL paramURL)
  {
    AppMethodBeat.i(129251);
    s.u(paramURL, "$this$readBytes");
    paramURL = (Closeable)paramURL.openStream();
    try
    {
      Object localObject1 = (InputStream)paramURL;
      s.s(localObject1, "it");
      localObject1 = a.ag((InputStream)localObject1);
      b.a(paramURL, null);
      AppMethodBeat.o(129251);
      return localObject1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(129251);
        throw localThrowable;
      }
      finally
      {
        b.a(paramURL, localThrowable);
        AppMethodBeat.o(129251);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.f.d
 * JD-Core Version:    0.7.0.1
 */