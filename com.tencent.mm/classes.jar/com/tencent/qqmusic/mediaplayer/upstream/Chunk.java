package com.tencent.qqmusic.mediaplayer.upstream;

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
    if (isEndless()) {
      if (paramLong < this.start) {}
    }
    while ((paramLong >= this.start) && (paramLong <= this.start + this.size))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean isEndless()
  {
    return this.size == -1L;
  }
  
  public String toString()
  {
    return "Chunk{bufferSize=" + this.bufferSize + ", start=" + this.start + ", size=" + this.size + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.Chunk
 * JD-Core Version:    0.7.0.1
 */