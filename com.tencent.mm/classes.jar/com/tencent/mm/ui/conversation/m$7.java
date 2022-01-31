package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

final class m$7
  implements Runnable
{
  m$7(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(34602);
    if (!ah.dsM())
    {
      ah.pI(true);
      al.p(new m.7.1(this), 100L);
    }
    g.Cy(8);
    AppMethodBeat.o(34602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.7
 * JD-Core Version:    0.7.0.1
 */