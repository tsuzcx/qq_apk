package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class f
{
  private static f HQI;
  ThreadLocal<Stack<c>> HQJ;
  
  static
  {
    AppMethodBeat.i(177492);
    HQI = null;
    HQI = new f();
    AppMethodBeat.o(177492);
  }
  
  private f()
  {
    AppMethodBeat.i(177491);
    this.HQJ = new ThreadLocal();
    AppMethodBeat.o(177491);
  }
  
  public static f fhp()
  {
    return HQI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */