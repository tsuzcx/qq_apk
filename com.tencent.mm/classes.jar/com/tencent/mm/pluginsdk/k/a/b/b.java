package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b
  extends IOException
{
  private final long Ral;
  private final long contentLength;
  
  public b()
  {
    this(0L, 0L);
  }
  
  public b(long paramLong1, long paramLong2)
  {
    super(String.format("contentLength: %d, requestRange:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    AppMethodBeat.i(152008);
    this.contentLength = paramLong1;
    this.Ral = paramLong2;
    AppMethodBeat.o(152008);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(152009);
    String str = "FileSizeOutOfRangeException{contentLength=" + this.contentLength + ", requestRange=" + this.Ral + '}';
    AppMethodBeat.o(152009);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.b.b
 * JD-Core Version:    0.7.0.1
 */