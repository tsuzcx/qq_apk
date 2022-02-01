package com.tencent.mm.storage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  Long admT;
  String name;
  
  public a(String paramString, Long paramLong)
  {
    this.name = paramString;
    this.admT = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248724);
    String str = "RecentForwardBean{name='" + this.name + '\'' + ", time='" + this.admT + '\'' + '}';
    AppMethodBeat.o(248724);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.c.a
 * JD-Core Version:    0.7.0.1
 */