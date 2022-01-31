package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

final class c$15
  implements Runnable
{
  c$15(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(31207);
    if (this.zEm.caz == null)
    {
      AppMethodBeat.o(31207);
      return;
    }
    boolean bool = ((h)this.zEm.caz.ay(h.class)).isInEditMode();
    if ((this.zEm.muT) && (!bool)) {
      e.d(this.zEm.zsO);
    }
    AppMethodBeat.o(31207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.15
 * JD-Core Version:    0.7.0.1
 */