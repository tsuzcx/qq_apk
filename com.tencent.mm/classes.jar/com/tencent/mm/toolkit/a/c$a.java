package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  static
  {
    AppMethodBeat.i(189804);
    FEK = new a("LOW", 0);
    FEL = new a("NORMAL", 1);
    FEM = new a("HIGH", 2);
    FEN = new a("IMMEDIATE", 3);
    FEO = new a[] { FEK, FEL, FEM, FEN };
    AppMethodBeat.o(189804);
  }
  
  private c$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c.a
 * JD-Core Version:    0.7.0.1
 */