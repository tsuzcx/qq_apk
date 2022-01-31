package com.tencent.mm.plugin.u.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.hf.b;

final class c$4
  implements Runnable
{
  c$4(c.a parama, hf paramhf) {}
  
  public final void run()
  {
    AppMethodBeat.i(80760);
    if ((this.pPz == null) || (this.pPB == null) || (this.pPB.cwo == null))
    {
      AppMethodBeat.o(80760);
      return;
    }
    if (this.pPB.cwo.ret == 1)
    {
      this.pPz.kn(true);
      AppMethodBeat.o(80760);
      return;
    }
    if (this.pPB.cwo.ret == 2) {
      this.pPz.kn(false);
    }
    AppMethodBeat.o(80760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c.4
 * JD-Core Version:    0.7.0.1
 */