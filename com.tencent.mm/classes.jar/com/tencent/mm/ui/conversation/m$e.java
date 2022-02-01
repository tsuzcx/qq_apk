package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$e
{
  final int op;
  
  static
  {
    AppMethodBeat.i(194729);
    Kxd = new e("ASC", 0, 1);
    Kxe = new e("DESC", 1, -1);
    Kxf = new e[] { Kxd, Kxe };
    AppMethodBeat.o(194729);
  }
  
  private m$e(int paramInt)
  {
    this.op = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.e
 * JD-Core Version:    0.7.0.1
 */