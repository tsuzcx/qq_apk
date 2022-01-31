package com.tencent.mm.pluginsdk.g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b
  extends IOException
{
  private final long bad;
  private final long vOb;
  
  public b()
  {
    this(0L, 0L);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    super(String.format("contentLength: %d, requestRange:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    AppMethodBeat.i(79564);
    this.bad = paramLong1;
    this.vOb = paramLong2;
    AppMethodBeat.o(79564);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79565);
    String str = "FileSizeOutOfRangeException{contentLength=" + this.bad + ", requestRange=" + this.vOb + '}';
    AppMethodBeat.o(79565);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.b.b
 * JD-Core Version:    0.7.0.1
 */