package com.tencent.mm.vending.base;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class Vending$c<_Index>
{
  Vending.a<_Index> QZl;
  Vending.i QZm;
  
  private Vending$c()
  {
    AppMethodBeat.i(177472);
    this.QZl = new Vending.a((byte)0);
    AppMethodBeat.o(177472);
  }
  
  public final void reset()
  {
    this.QZl.object = null;
    this.QZm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c
 * JD-Core Version:    0.7.0.1
 */