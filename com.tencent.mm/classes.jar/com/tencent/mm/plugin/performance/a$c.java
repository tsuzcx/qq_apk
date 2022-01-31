package com.tencent.mm.plugin.performance;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$c
{
  long bQI;
  String name;
  long psh;
  int tid;
  
  public final String toString()
  {
    AppMethodBeat.i(111023);
    String str = String.format("%s(%s) diff:%s", new Object[] { this.name, Integer.valueOf(this.tid), Long.valueOf(this.psh) });
    AppMethodBeat.o(111023);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.c
 * JD-Core Version:    0.7.0.1
 */