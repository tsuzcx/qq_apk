package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.sdk.b.a;

final class c$11
  implements Runnable
{
  c$11(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(31203);
    pu localpu = new pu();
    if (c.c(this.zEm) != null)
    {
      localpu.cGn.userName = c.c(this.zEm).field_username;
      a.ymk.l(localpu);
    }
    AppMethodBeat.o(31203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.11
 * JD-Core Version:    0.7.0.1
 */