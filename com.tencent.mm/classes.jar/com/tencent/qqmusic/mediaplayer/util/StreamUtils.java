package com.tencent.qqmusic.mediaplayer.util;

import java.io.InputStream;

public class StreamUtils
{
  public static long skipForBufferStream(InputStream paramInputStream, long paramLong)
  {
    long l1;
    if ((paramInputStream == null) || (paramLong <= 0L)) {
      l1 = 0L;
    }
    long l3;
    long l4;
    do
    {
      return l1;
      long l2 = paramLong;
      l1 = 0L;
      do
      {
        l3 = l2 - l1;
        l4 = paramInputStream.skip(l3);
        if (l4 <= 0L) {
          break;
        }
        l2 = l3;
        l1 = l4;
      } while (l4 < l3);
      l1 = paramLong;
    } while (l4 > 0L);
    return paramLong - l3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.StreamUtils
 * JD-Core Version:    0.7.0.1
 */