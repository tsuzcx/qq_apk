package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.al;

final class d$1
  implements Runnable
{
  d$1(d paramd, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26754);
    d.b(this.vyy).a(this.fEQ, d.a(this.vyy));
    if ((d.c(this.vyy)) || (this.qac != -50006)) {
      aw.RO().o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(26753);
          d.b(d.1.this.vyy).b(d.d(d.1.this.vyy), d.a(d.1.this.vyy));
          AppMethodBeat.o(26753);
        }
      }, 80L);
    }
    AppMethodBeat.o(26754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d.1
 * JD-Core Version:    0.7.0.1
 */