package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.c;

final class HomeUI$2
  implements Runnable
{
  HomeUI$2(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33176);
    HomeUI.k(this.VWJ);
    HomeUI.l(this.VWJ);
    if ((ar.isDarkMode()) && (!ar.aEl()))
    {
      c.hrA();
      if (ar.aEk()) {
        HomeUI.m(this.VWJ);
      }
    }
    AppMethodBeat.o(33176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.2
 * JD-Core Version:    0.7.0.1
 */