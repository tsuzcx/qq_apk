package com.tencent.mm.ui;

import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;

final class HomeUI$23
  implements FirstScreenFrameLayout.a
{
  HomeUI$23(HomeUI paramHomeUI) {}
  
  public final void aqk()
  {
    AppMethodBeat.i(33201);
    long l;
    if (HomeUI.hGS())
    {
      HomeUI.cxV();
      l = Debug.getNativeHeapAllocatedSize();
      if (l > 209715200L)
      {
        if (l >= 419430400L) {
          break label104;
        }
        h.IzE.p(959L, 190L, 1L);
      }
    }
    for (;;)
    {
      if (a.apW())
      {
        a.qd(6);
        a.apX();
        a.JB("First Screen");
        g.ieN().Wo(500L).d(new HomeUI.23.1(this));
      }
      b.aqa().aqe();
      AppMethodBeat.o(33201);
      return;
      label104:
      if (l < 629145600L) {
        h.IzE.p(959L, 191L, 1L);
      } else if (l < 838860800L) {
        h.IzE.p(959L, 192L, 1L);
      } else {
        h.IzE.p(959L, 193L, 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.23
 * JD-Core Version:    0.7.0.1
 */