package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class f
{
  private static f Jrd;
  ThreadLocal<Stack<c>> Jre;
  
  static
  {
    AppMethodBeat.i(177492);
    Jrd = null;
    Jrd = new f();
    AppMethodBeat.o(177492);
  }
  
  private f()
  {
    AppMethodBeat.i(177491);
    this.Jre = new ThreadLocal();
    AppMethodBeat.o(177491);
  }
  
  public static f fxr()
  {
    return Jrd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */