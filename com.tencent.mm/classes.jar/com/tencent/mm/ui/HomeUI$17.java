package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.sdk.event.EventCenter;

final class HomeUI$17
  implements Runnable
{
  HomeUI$17(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(232569);
    EventCenter.instance.publish(new bn());
    AppMethodBeat.o(232569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.17
 * JD-Core Version:    0.7.0.1
 */