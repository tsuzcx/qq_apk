package com.tencent.mm.plugin.profile.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gb;

final class k$a
{
  private final gb BfE;
  
  private k$a()
  {
    AppMethodBeat.i(231870);
    this.BfE = new gb();
    AppMethodBeat.o(231870);
  }
  
  final void er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231871);
    gb localgb = this.BfE;
    localgb.eIs = paramInt1;
    localgb.eIt = paramInt2;
    localgb.bfK();
    AppMethodBeat.o(231871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.a
 * JD-Core Version:    0.7.0.1
 */