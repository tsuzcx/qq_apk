package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bs;
import com.tencent.mm.sdk.event.EventCenter;

final class HomeUI$17
  implements Runnable
{
  HomeUI$17(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(202657);
    EventCenter.instance.publish(new bs());
    AppMethodBeat.o(202657);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.17
 * JD-Core Version:    0.7.0.1
 */