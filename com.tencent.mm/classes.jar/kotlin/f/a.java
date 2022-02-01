package kotlin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class a
{
  public static final byte[] ag(InputStream paramInputStream)
  {
    AppMethodBeat.i(129280);
    s.u(paramInputStream, "$this$readBytes");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, paramInputStream.available()));
    j(paramInputStream, (OutputStream)localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    s.s(paramInputStream, "buffer.toByteArray()");
    AppMethodBeat.o(129280);
    return paramInputStream;
  }
  
  public static long i(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(129278);
    s.u(paramInputStream, "$this$copyTo");
    s.u(paramOutputStream, "out");
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
 * Qualified Name:     kotlin.f.a
 * JD-Core Version:    0.7.0.1
 */