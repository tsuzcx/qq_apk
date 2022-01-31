package com.tencent.mm.pluginsdk.g.a.b;

import java.io.IOException;

public final class b
  extends IOException
{
  private final long ceJ;
  private final long rXj;
  
  public b()
  {
    this(0L, 0L);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    super(String.format("contentLength: %d, requestRange:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    this.ceJ = paramLong1;
    this.rXj = paramLong2;
  }
  
  public final String toString()
  {
    return "FileSizeOutOfRangeException{contentLength=" + this.ceJ + ", requestRange=" + this.rXj + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.b.b
 * JD-Core Version:    0.7.0.1
 */