package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.b;
import com.tencent.mm.ce.e;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class HomeUI$2
  implements Runnable
{
  HomeUI$2(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(33176);
    HomeUI.k(this.adBf);
    HomeUI.l(this.adBf);
    if ((aw.isDarkMode()) && (!aw.aXp()))
    {
      e.iRO();
      if (aw.aXo()) {
        HomeUI.m(this.adBf);
      }
    }
    HomeUI.n(this.adBf);
    if (b.iRq())
    {
      h.baE().ban().set(at.a.acQy, Boolean.FALSE);
      b.Kn(true);
    }
    AppMethodBeat.o(33176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.2
 * JD-Core Version:    0.7.0.1
 */