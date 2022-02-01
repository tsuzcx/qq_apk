package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class BinaryCodec
  implements MessageCodec<ByteBuffer>
{
  public static final BinaryCodec INSTANCE;
  
  static
  {
    AppMethodBeat.i(189826);
    INSTANCE = new BinaryCodec();
    AppMethodBeat.o(189826);
  }
  
  public final ByteBuffer decodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
  
  public final ByteBuffer encodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryCodec
 * JD-Core Version:    0.7.0.1
 */