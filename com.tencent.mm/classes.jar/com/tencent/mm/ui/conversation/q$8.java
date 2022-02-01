package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.jd;
import com.tencent.mm.sdk.event.EventCenter;

final class q$8
  implements Runnable
{
  q$8(q paramq) {}
  
  public final void run()
  {
    AppMethodBeat.i(38730);
    jd localjd = new jd();
    localjd.fGs.data = "MAIN_UI_EVENT_UPDATE_VIEW";
    EventCenter.instance.publish(localjd);
    AppMethodBeat.o(38730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.q.8
 * JD-Core Version:    0.7.0.1
 */