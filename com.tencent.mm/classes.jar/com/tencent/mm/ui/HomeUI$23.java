package com.tencent.mm.ui;

import android.os.Debug;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.blink.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;

final class HomeUI$23
  implements FirstScreenFrameLayout.a
{
  HomeUI$23(HomeUI paramHomeUI) {}
  
  public final void ako()
  {
    AppMethodBeat.i(33201);
    long l;
    if (HomeUI.aau())
    {
      HomeUI.aav();
      l = Debug.getNativeHeapAllocatedSize();
      if (l > 209715200L)
      {
        if (l >= 419430400L) {
          break label104;
        }
        h.CyF.n(959L, 190L, 1L);
      }
    }
    for (;;)
    {
      if (com.tencent.mm.blink.a.aka())
      {
        com.tencent.mm.blink.a.nO(6);
        com.tencent.mm.blink.a.akb();
        com.tencent.mm.blink.a.CM("First Screen");
        g.hdG().Oc(500L).d(new com.tencent.mm.vending.c.a() {});
      }
      b.ake().aki();
      AppMethodBeat.o(33201);
      return;
      label104:
      if (l < 629145600L) {
        h.CyF.n(959L, 191L, 1L);
      } else if (l < 838860800L) {
        h.CyF.n(959L, 192L, 1L);
      } else {
        h.CyF.n(959L, 193L, 1L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.23
 * JD-Core Version:    0.7.0.1
 */