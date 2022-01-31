package com.tencent.mm.ui.chatting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.chatting.viewitems.an.d;

final class a$4
  implements t.a
{
  a$4(a parama) {}
  
  public final void a(t.a.a parama)
  {
    AppMethodBeat.i(31099);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parama != null)
    {
      bool1 = bool2;
      if (parama.fXE != 3) {
        if ((parama.fXE != 2) && (parama.fXE != -1))
        {
          bool1 = bool2;
          if (parama.fXE != 1) {}
        }
        else
        {
          bool1 = an.d.b(parama);
        }
      }
    }
    if (!bool1) {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(31098);
          a.4.this.zDD.dHc();
          AppMethodBeat.o(31098);
        }
      });
    }
    AppMethodBeat.o(31099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.4
 * JD-Core Version:    0.7.0.1
 */