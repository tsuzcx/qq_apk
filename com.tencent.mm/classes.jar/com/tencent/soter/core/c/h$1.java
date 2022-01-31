package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements h.a
{
  private boolean Bmt = false;
  
  public final boolean dVn()
  {
    return this.Bmt;
  }
  
  public final void dVo()
  {
    AppMethodBeat.i(73039);
    d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
    this.Bmt = true;
    AppMethodBeat.o(73039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.c.h.1
 * JD-Core Version:    0.7.0.1
 */