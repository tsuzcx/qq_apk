package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.aj;

final class HomeUI$22
  implements Runnable
{
  HomeUI$22(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(163262);
    if (bc.ajM())
    {
      bc.aCg();
      aj localaj = c.ajA();
      if (localaj != null) {
        localaj.fuc();
      }
    }
    AppMethodBeat.o(163262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.22
 * JD-Core Version:    0.7.0.1
 */