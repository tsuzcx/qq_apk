package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class f
{
  private static f agvq;
  ThreadLocal<Stack<c>> agvr;
  
  static
  {
    AppMethodBeat.i(177492);
    agvq = null;
    agvq = new f();
    AppMethodBeat.o(177492);
  }
  
  private f()
  {
    AppMethodBeat.i(177491);
    this.agvr = new ThreadLocal();
    AppMethodBeat.o(177491);
  }
  
  public static f jJT()
  {
    return agvq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */