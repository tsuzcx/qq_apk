package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;

final class m$12
  implements Runnable
{
  m$12(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(24487);
    if (!aw.RG())
    {
      AppMethodBeat.o(24487);
      return;
    }
    aw.aaz();
    bo.q(c.YQ(), "Sk", 604800000L);
    AppMethodBeat.o(24487);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24488);
    String str = super.toString() + "|onAccountPostReset";
    AppMethodBeat.o(24488);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.12
 * JD-Core Version:    0.7.0.1
 */