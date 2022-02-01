package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class f
{
  private static f YAT;
  ThreadLocal<Stack<c>> YAU;
  
  static
  {
    AppMethodBeat.i(177492);
    YAT = null;
    YAT = new f();
    AppMethodBeat.o(177492);
  }
  
  private f()
  {
    AppMethodBeat.i(177491);
    this.YAU = new ThreadLocal();
    AppMethodBeat.o(177491);
  }
  
  public static f ieM()
  {
    return YAT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.g.f
 * JD-Core Version:    0.7.0.1
 */