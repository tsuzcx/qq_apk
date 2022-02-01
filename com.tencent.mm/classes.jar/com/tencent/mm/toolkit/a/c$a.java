package com.tencent.mm.toolkit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c$a
{
  static
  {
    AppMethodBeat.i(220781);
    VOU = new a("LOW", 0);
    VOV = new a("NORMAL", 1);
    VOW = new a("HIGH", 2);
    VOX = new a("IMMEDIATE", 3);
    VOY = new a[] { VOU, VOV, VOW, VOX };
    AppMethodBeat.o(220781);
  }
  
  private c$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c.a
 * JD-Core Version:    0.7.0.1
 */