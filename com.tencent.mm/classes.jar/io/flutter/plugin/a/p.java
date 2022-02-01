package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class p
  implements i<String>
{
  private static final Charset RAF;
  public static final p SSt;
  
  static
  {
    AppMethodBeat.i(9849);
    RAF = Charset.forName("UTF8");
    SSt = new p();
    AppMethodBeat.o(9849);
  }
  
  public static String P(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9846);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(9846);
      return null;
    }
    int j = paramByteBuffer.remaining();
    byte[] arrayOfByte;
    int i;
    if (paramByteBuffer.hasArray())
    {
      arrayOfByte = paramByteBuffer.array();
      i = paramByteBuffer.arrayOffset();
    }
    for (paramByteBuffer = arrayOfByte;; paramByteBuffer = arrayOfByte)
    {
      paramByteBuffer = new String(paramByteBuffer, i, j, RAF);
      AppMethodBeat.o(9846);
      return paramByteBuffer;
      arrayOfByte = new byte[j];
      paramByteBuffer.get(arrayOfByte);
      i = 0;
    }
  }
  
  public static ByteBuffer btr(String paramString)
  {
    AppMethodBeat.i(9845);
    if (paramString == null)
    {
      AppMethodBeat.o(9845);
      return null;
    }
    paramString = paramString.getBytes(RAF);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString.length);
    localByteBuffer.put(paramString);
    AppMethodBeat.o(9845);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.plugin.a.p
 * JD-Core Version:    0.7.0.1
 */