package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$d
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(34109);
    Jxh = new d("Samll", 0, 1);
    Jxi = new d("Full", 1, 2);
    Jxj = new d("Complete", 2, 3);
    Jxk = new d[] { Jxh, Jxi, Jxj };
    AppMethodBeat.o(34109);
  }
  
  private a$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.d
 * JD-Core Version:    0.7.0.1
 */