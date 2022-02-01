package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p$e
{
  final int op;
  
  static
  {
    AppMethodBeat.i(256775);
    afrm = new e("ASC", 0, 1);
    afrn = new e("DESC", 1, -1);
    afro = new e[] { afrm, afrn };
    AppMethodBeat.o(256775);
  }
  
  private p$e(int paramInt)
  {
    this.op = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.e
 * JD-Core Version:    0.7.0.1
 */