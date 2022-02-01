package com.tencent.qqmusic.mediaplayer.seektable.flac;

public class Id3Util
{
  public static int synchsafe(int paramInt)
  {
    int j = 127;
    int i = paramInt;
    for (paramInt = j; (0x7FFFFFFF ^ paramInt) > 0; paramInt = (paramInt + 1 << 8) - 1) {
      i = ((paramInt ^ 0xFFFFFFFF) & i) << 1 | i & paramInt;
    }
    return i;
  }
  
  public static int unsynchsafe(int paramInt)
  {
    int j = 0;
    int i = 2130706432;
    while (i > 0)
    {
      j = j >> 1 | paramInt & i;
      i >>= 8;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.flac.Id3Util
 * JD-Core Version:    0.7.0.1
 */