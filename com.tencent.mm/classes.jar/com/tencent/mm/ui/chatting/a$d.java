package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$d
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(30259);
    zvq = new d("Samll", 0, 1);
    zvr = new d("Full", 1, 2);
    zvs = new d("Complete", 2, 3);
    zvt = new d[] { zvq, zvr, zvs };
    AppMethodBeat.o(30259);
  }
  
  private a$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.d
 * JD-Core Version:    0.7.0.1
 */