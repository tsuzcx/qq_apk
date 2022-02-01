package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.in;
import com.tencent.mm.sdk.event.EventCenter;

final class p$8
  implements Runnable
{
  p$8(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(38730);
    in localin = new in();
    localin.dNg.data = "MAIN_UI_EVENT_UPDATE_VIEW";
    EventCenter.instance.publish(localin);
    AppMethodBeat.o(38730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.p.8
 * JD-Core Version:    0.7.0.1
 */