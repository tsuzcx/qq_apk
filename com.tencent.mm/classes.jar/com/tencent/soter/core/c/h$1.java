package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements h.a
{
  private boolean Zss = false;
  
  public final boolean ioU()
  {
    return this.Zss;
  }
  
  public final void ioV()
  {
    AppMethodBeat.i(88666);
    d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
    this.Zss = true;
    AppMethodBeat.o(88666);
  }
  
  public final void reset()
  {
    this.Zss = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.core.c.h.1
 * JD-Core Version:    0.7.0.1
 */