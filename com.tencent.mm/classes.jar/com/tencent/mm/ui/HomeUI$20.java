package com.tencent.mm.ui;

import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;

final class HomeUI$20
  implements FirstScreenFrameLayout.a
{
  HomeUI$20(HomeUI paramHomeUI) {}
  
  public final void aKi()
  {
    AppMethodBeat.i(33201);
    long l;
    if (HomeUI.jjd())
    {
      HomeUI.daN();
      l = Debug.getNativeHeapAllocatedSize();
      if (l > 209715200L)
      {
        if (l >= 419430400L) {
          break label104;
        }
        h.OAn.p(959L, 190L, 1L);
      }
    }
    for (;;)
    {
      if (a.aJU())
      {
        a.qd(6);
        a.aJV();
        a.Ch("First Screen");
        g.jJU().AA(500L).d(new HomeUI.20.1(this));
      }
      b.aJY().aKc();
      AppMethodBeat.o(33201);
      return;
      label104:
      if (l < 629145600L) {
        h.OAn.p(959L, 191L, 1L);
      } else if (l < 838860800L) {
        h.OAn.p(959L, 192L, 1L);
      } else {
        h.OAn.p(959L, 193L, 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.20
 * JD-Core Version:    0.7.0.1
 */