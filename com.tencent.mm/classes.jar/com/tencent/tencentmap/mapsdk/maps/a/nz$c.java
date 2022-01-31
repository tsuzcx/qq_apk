package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

class nz$c
  extends nz.b
{
  private final PrintStream a;
  
  nz$c(PrintStream paramPrintStream)
  {
    super(null);
    this.a = paramPrintStream;
  }
  
  Object a()
  {
    return this.a;
  }
  
  void a(Object paramObject)
  {
    AppMethodBeat.i(149583);
    this.a.println(paramObject);
    AppMethodBeat.o(149583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nz.c
 * JD-Core Version:    0.7.0.1
 */