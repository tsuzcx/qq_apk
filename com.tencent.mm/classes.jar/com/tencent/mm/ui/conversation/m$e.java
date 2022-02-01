package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$e
{
  final int op;
  
  static
  {
    AppMethodBeat.i(196880);
    IFX = new e("ASC", 0, 1);
    IFY = new e("DESC", 1, -1);
    IFZ = new e[] { IFX, IFY };
    AppMethodBeat.o(196880);
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