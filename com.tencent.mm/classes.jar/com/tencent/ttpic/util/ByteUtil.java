package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(83825);
    ByteBuffer localByteBuffer = ByteBuffer.wrap(mBytes);
    localByteBuffer.order(ByteOrder.nativeOrder());
    int i = localByteBuffer.getInt();
    AppMethodBeat.o(83825);
    return i;
  }
  
  public static int readInt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(83826);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(83826);
      return 0;
    }
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.order(ByteOrder.nativeOrder());
    int i = paramArrayOfByte.getInt();
    AppMethodBeat.o(83826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.ByteUtil
 * JD-Core Version:    0.7.0.1
 */