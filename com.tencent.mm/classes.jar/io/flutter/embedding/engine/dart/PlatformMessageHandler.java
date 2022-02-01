package io.flutter.embedding.engine.dart;

public abstract interface PlatformMessageHandler
{
  public abstract void handleMessageFromDart(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.PlatformMessageHandler
 * JD-Core Version:    0.7.0.1
 */