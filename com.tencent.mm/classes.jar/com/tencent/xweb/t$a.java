package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum t$a
{
  int value;
  
  static
  {
    AppMethodBeat.i(3836);
    BDV = new a("SMALLEST", 0, 50);
    BDW = new a("SMALLER", 1, 75);
    BDX = new a("NORMAL", 2, 100);
    BDY = new a("LARGER", 3, 150);
    BDZ = new a("LARGEST", 4, 200);
    BEa = new a[] { BDV, BDW, BDX, BDY, BDZ };
    AppMethodBeat.o(3836);
  }
  
  private t$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.t.a
 * JD-Core Version:    0.7.0.1
 */