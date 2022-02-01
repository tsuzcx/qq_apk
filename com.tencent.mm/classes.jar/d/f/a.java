package d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"})
public final class a
{
  public static final byte[] V(InputStream paramInputStream)
  {
    AppMethodBeat.i(129280);
    k.h(paramInputStream, "$this$readBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, paramInputStream.available()));
    h(paramInputStream, (OutputStream)localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    k.g(paramInputStream, "buffer.toByteArray()");
    AppMethodBeat.o(129280);
    return paramInputStream;
  }
  
  public static long g(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(129278);
    k.h(paramInputStream, "$this$copyTo");
    k.h(paramOutputStream, "out");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.f.a
 * JD-Core Version:    0.7.0.1
 */