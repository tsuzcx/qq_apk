package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface MessageCodec<T>
{
  public abstract T decodeMessage(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer encodeMessage(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.common.MessageCodec
 * JD-Core Version:    0.7.0.1
 */