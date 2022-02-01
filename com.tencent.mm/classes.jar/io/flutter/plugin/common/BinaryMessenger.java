package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface BinaryMessenger
{
  public abstract void send(String paramString, ByteBuffer paramByteBuffer);
  
  public abstract void send(String paramString, ByteBuffer paramByteBuffer, BinaryReply paramBinaryReply);
  
  public abstract void setMessageHandler(String paramString, BinaryMessageHandler paramBinaryMessageHandler);
  
  public static abstract interface BinaryMessageHandler
  {
    public abstract void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply);
  }
  
  public static abstract interface BinaryReply
  {
    public abstract void reply(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.common.BinaryMessenger
 * JD-Core Version:    0.7.0.1
 */