package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class StreamUtils
{
  public static long skipForBufferStream(InputStream paramInputStream, long paramLong)
  {
    AppMethodBeat.i(114157);
    if ((paramInputStream == null) || (paramLong <= 0L))
    {
      AppMethodBeat.o(114157);
      return 0L;
    }
    long l2 = paramLong;
    long l1 = 0L;
    long l3;
    long l4;
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
    if (l4 > 0L)
    {
      AppMethodBeat.o(114157);
      return paramLong;
    }
    AppMethodBeat.o(114157);
    return paramLong - l3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.StreamUtils
 * JD-Core Version:    0.7.0.1
 */