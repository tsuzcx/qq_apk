package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_Unicode$CharsetRecog_UTF_32_BE
  extends CharsetRecog_Unicode.CharsetRecog_UTF_32
{
  int getChar(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  String getName()
  {
    return "UTF-32BE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32_BE
 * JD-Core Version:    0.7.0.1
 */