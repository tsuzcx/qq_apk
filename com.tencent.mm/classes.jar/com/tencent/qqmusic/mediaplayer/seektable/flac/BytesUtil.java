package com.tencent.qqmusic.mediaplayer.seektable.flac;

public class BytesUtil
{
  public static int from(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 4) {
      throw new RuntimeException("bytes can't be greater than 32 bit!");
    }
    if (paramArrayOfByte.length == 3) {
      return (paramArrayOfByte[0] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[2] & 0xFF;
    }
    if (paramArrayOfByte.length == 2) {
      return (paramArrayOfByte[0] & 0xFF) << 8 | paramArrayOfByte[1] & 0xF;
    }
    if (paramArrayOfByte.length == 1) {
      return paramArrayOfByte[0] & 0xFF;
    }
    throw new RuntimeException("bytes must be greater than 8 bit!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.BytesUtil
 * JD-Core Version:    0.7.0.1
 */