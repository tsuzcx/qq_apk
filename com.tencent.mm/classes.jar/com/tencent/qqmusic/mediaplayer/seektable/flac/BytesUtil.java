package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BytesUtil
{
  public static int from(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114273);
    if (paramArrayOfByte.length > 4)
    {
      paramArrayOfByte = new RuntimeException("bytes can't be greater than 32 bit!");
      AppMethodBeat.o(114273);
      throw paramArrayOfByte;
    }
    int i;
    int j;
    if (paramArrayOfByte.length == 3)
    {
      i = paramArrayOfByte[0];
      j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      AppMethodBeat.o(114273);
      return (i & 0xFF) << 16 | (j & 0xFF) << 8 | k & 0xFF;
    }
    if (paramArrayOfByte.length == 2)
    {
      i = paramArrayOfByte[0];
      j = paramArrayOfByte[1];
      AppMethodBeat.o(114273);
      return (i & 0xFF) << 8 | j & 0xF;
    }
    if (paramArrayOfByte.length == 1)
    {
      i = paramArrayOfByte[0];
      AppMethodBeat.o(114273);
      return i & 0xFF;
    }
    paramArrayOfByte = new RuntimeException("bytes must be greater than 8 bit!");
    AppMethodBeat.o(114273);
    throw paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.BytesUtil
 * JD-Core Version:    0.7.0.1
 */