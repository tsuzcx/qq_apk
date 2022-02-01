package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"})
public final class a
{
  public static final byte[] U(InputStream paramInputStream)
  {
    AppMethodBeat.i(129280);
    p.h(paramInputStream, "$this$readBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, paramInputStream.available()));
    f(paramInputStream, (OutputStream)localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    p.g(paramInputStream, "buffer.toByteArray()");
    AppMethodBeat.o(129280);
    return paramInputStream;
  }
  
  public static long e(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(129278);
    p.h(paramInputStream, "$this$copyTo");
    p.h(paramOutputStream, "out");
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    for (int i = paramInputStream.read(arrayOfByte); i >= 0; i = paramInputStream.read(arrayOfByte))
    {
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    AppMethodBeat.o(129278);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.f.a
 * JD-Core Version:    0.7.0.1
 */