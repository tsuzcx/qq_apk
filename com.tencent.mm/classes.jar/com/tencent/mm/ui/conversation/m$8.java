package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.sdk.b.a;

final class m$8
  implements Runnable
{
  m$8(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(34603);
    gp localgp = new gp();
    localgp.cvB.data = "MAIN_UI_EVENT_UPDATE_VIEW";
    a.ymk.l(localgp);
    AppMethodBeat.o(34603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.8
 * JD-Core Version:    0.7.0.1
 */