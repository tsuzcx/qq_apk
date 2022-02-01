package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;

final class m$12
  implements Runnable
{
  m$12(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(28159);
    if (!bg.aAc())
    {
      AppMethodBeat.o(28159);
      return;
    }
    bg.aVF();
    Util.deleteOutOfDateFile(c.aTe(), "Sk", 604800000L);
    AppMethodBeat.o(28159);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(28160);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(28160);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.12
 * JD-Core Version:    0.7.0.1
 */