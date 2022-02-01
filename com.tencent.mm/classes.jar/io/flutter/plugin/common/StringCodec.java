package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class StringCodec
  implements MessageCodec<String>
{
  public static final StringCodec INSTANCE;
  private static final Charset UTF8;
  
  static
  {
    AppMethodBeat.i(9849);
    UTF8 = Charset.forName("UTF8");
    INSTANCE = new StringCodec();
    AppMethodBeat.o(9849);
  }
  
  public final String decodeMessage(ByteBuffer paramByteBuffer)
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
      paramByteBuffer = new String(paramByteBuffer, i, j, UTF8);
      AppMethodBeat.o(9846);
      return paramByteBuffer;
      arrayOfByte = new byte[j];
      paramByteBuffer.get(arrayOfByte);
      i = 0;
    }
  }
  
  public final ByteBuffer encodeMessage(String paramString)
  {
    AppMethodBeat.i(9845);
    if (paramString == null)
    {
      AppMethodBeat.o(9845);
      return null;
    }
    paramString = paramString.getBytes(UTF8);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString.length);
    localByteBuffer.put(paramString);
    AppMethodBeat.o(9845);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.StringCodec
 * JD-Core Version:    0.7.0.1
 */