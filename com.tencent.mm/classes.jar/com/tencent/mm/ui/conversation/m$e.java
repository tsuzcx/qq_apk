package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$e
{
  final int op;
  
  static
  {
    AppMethodBeat.i(234224);
    QgE = new e("ASC", 0, 1);
    QgF = new e("DESC", 1, -1);
    QgG = new e[] { QgE, QgF };
    AppMethodBeat.o(234224);
  }
  
  private m$e(int paramInt)
  {
    this.op = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.e
 * JD-Core Version:    0.7.0.1
 */