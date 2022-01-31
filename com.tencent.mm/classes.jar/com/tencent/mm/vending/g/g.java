package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class g
{
  private static g AOV;
  ThreadLocal<Stack<c>> b;
  
  static
  {
    AppMethodBeat.i(126070);
    AOV = null;
    AOV = new g();
    AppMethodBeat.o(126070);
  }
  
  private g()
  {
    AppMethodBeat.i(126069);
    this.b = new ThreadLocal();
    AppMethodBeat.o(126069);
  }
  
  public static g dQt()
  {
    return AOV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.g
 * JD-Core Version:    0.7.0.1
 */