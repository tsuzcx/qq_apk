package com.tencent.ttpic.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteUtil
{
  public static byte[] mBytes = new byte[4];
  
  public static byte[] getByteBuffer()
  {
    return mBytes;
  }
  
  public static int readInt()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(mBytes);
    localByteBuffer.order(ByteOrder.nativeOrder());
    return localByteBuffer.getInt();
  }
  
  public static int readInt(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    return paramArrayOfByte.getInt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.ByteUtil
 * JD-Core Version:    0.7.0.1
 */