package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class HomeUI$22
  implements Runnable
{
  HomeUI$22(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(29368);
    if (aw.RG())
    {
      aw.aaz();
      z localz = c.Ru();
      if (localz != null) {
        localz.dww();
      }
    }
    AppMethodBeat.o(29368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.22
 * JD-Core Version:    0.7.0.1
 */