package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$a
{
  private long size;
  private int version;
  
  public b$a(b paramb, int paramInt, long paramLong)
  {
    this.version = paramInt;
    this.size = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212527);
    String str = "\"" + this.version + "\":" + this.size;
    AppMethodBeat.o(212527);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.b.b.a
 * JD-Core Version:    0.7.0.1
 */