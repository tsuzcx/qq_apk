package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;

final class aj$4
  implements bk.a
{
  aj$4(aj paramaj) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(31698);
    if (parame == null)
    {
      AppMethodBeat.o(31698);
      return;
    }
    parame.stopSignalling();
    AppMethodBeat.o(31698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.aj.4
 * JD-Core Version:    0.7.0.1
 */