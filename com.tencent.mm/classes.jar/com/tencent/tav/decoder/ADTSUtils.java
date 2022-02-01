package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class ADTSUtils
{
  public static ByteBuffer getADTSCodecSpecificData(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(189788);
    paramInt2 = getFreqIndex(paramInt2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.put(0, (byte)(paramInt1 << 3 | paramInt2 >> 1));
    localByteBuffer.put(1, (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3));
    localByteBuffer.flip();
    AppMethodBeat.o(189788);
    return localByteBuffer;
  }
  
  public static int getFreqIndex(int paramInt)
  {
    switch (paramInt)
    {
    case 16000: 
    default: 
      return 8;
    case 96000: 
      return 0;
    case 88200: 
      return 1;
    case 64000: 
      return 2;
    case 48000: 
      return 3;
    case 44100: 
      return 4;
    case 32000: 
      return 5;
    case 24000: 
      return 6;
    case 22050: 
      return 7;
    case 12000: 
      return 9;
    case 11025: 
      return 10;
    case 8000: 
      return 11;
    }
    return 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.ADTSUtils
 * JD-Core Version:    0.7.0.1
 */