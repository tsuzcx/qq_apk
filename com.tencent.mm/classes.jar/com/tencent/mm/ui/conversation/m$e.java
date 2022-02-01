package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$e
{
  final int op;
  
  static
  {
    AppMethodBeat.i(188131);
    KTx = new e("ASC", 0, 1);
    KTy = new e("DESC", 1, -1);
    KTz = new e[] { KTx, KTy };
    AppMethodBeat.o(188131);
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