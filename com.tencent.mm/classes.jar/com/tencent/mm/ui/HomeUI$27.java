package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class HomeUI$27
  implements Runnable
{
  HomeUI$27(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(226532);
    if (bh.aHB())
    {
      bh.beI();
      ao localao = c.aHp();
      if (localao != null) {
        localao.hxT();
      }
    }
    AppMethodBeat.o(226532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.27
 * JD-Core Version:    0.7.0.1
 */