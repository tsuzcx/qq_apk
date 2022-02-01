package com.tencent.mm.plugin.performance.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
{
  int count;
  String name;
  
  public e$a(String paramString, int paramInt)
  {
    this.name = paramString;
    this.count = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211806);
    String str = this.name + "=" + this.count;
    AppMethodBeat.o(211806);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.c.e.a
 * JD-Core Version:    0.7.0.1
 */