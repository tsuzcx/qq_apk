package com.tencent.mm.vending.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class Vending$c<_Index>
{
  Vending.a<_Index> YzB;
  Vending.i YzC;
  
  private Vending$c()
  {
    AppMethodBeat.i(177472);
    this.YzB = new Vending.a((byte)0);
    AppMethodBeat.o(177472);
  }
  
  public final void reset()
  {
    this.YzB.object = null;
    this.YzC = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c
 * JD-Core Version:    0.7.0.1
 */