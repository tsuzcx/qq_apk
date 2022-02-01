package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Chunk
{
  public final int bufferSize;
  public final long size;
  public final long start;
  
  public Chunk(int paramInt, long paramLong1, long paramLong2)
  {
    this.bufferSize = paramInt;
    this.start = paramLong1;
    this.size = paramLong2;
  }
  
  public boolean contains(long paramLong)
  {
    AppMethodBeat.i(76524);
    if (isEndless())
    {
      if (paramLong >= this.start)
      {
        AppMethodBeat.o(76524);
        return true;
      }
      AppMethodBeat.o(76524);
      return false;
    }
    if ((paramLong >= this.start) && (paramLong <= this.start + this.size))
    {
      AppMethodBeat.o(76524);
      return true;
    }
    AppMethodBeat.o(76524);
    return false;
  }
  
  public boolean isEndless()
  {
    return this.size == -1L;
  }
  
  public String toString()
  {
    AppMethodBeat.i(76525);
    String str = "Chunk{bufferSize=" + this.bufferSize + ", start=" + this.start + ", size=" + this.size + '}';
    AppMethodBeat.o(76525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Chunk
 * JD-Core Version:    0.7.0.1
 */