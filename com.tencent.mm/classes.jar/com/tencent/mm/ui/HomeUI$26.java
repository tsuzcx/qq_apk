package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class HomeUI$26
  implements Runnable
{
  HomeUI$26(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(232575);
    if (bg.aAc())
    {
      bg.aVF();
      ao localao = c.azQ();
      if (localao != null) {
        localao.gBI();
      }
    }
    AppMethodBeat.o(232575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.26
 * JD-Core Version:    0.7.0.1
 */