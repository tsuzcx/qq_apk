package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  int count;
  String name;
  
  public b$a(String paramString, int paramInt)
  {
    this.name = paramString;
    this.count = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138543);
    String str = this.name + "=" + this.count;
    AppMethodBeat.o(138543);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.b.a
 * JD-Core Version:    0.7.0.1
 */