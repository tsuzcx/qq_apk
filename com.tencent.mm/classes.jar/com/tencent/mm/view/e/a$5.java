package com.tencent.mm.view.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileyPanelViewPager;

final class a$5
  implements Runnable
{
  a$5(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(63027);
    if ((a.c(this.AUz) == null) || (a.d(this.AUz) == null) || (a.d(this.AUz).avU(this.lgI) == null))
    {
      AppMethodBeat.o(63027);
      return;
    }
    a.a(this.AUz, a.d(this.AUz).avU(this.lgI).jpL);
    a.c(this.AUz).setCurrentItem(a.e(this.AUz));
    a.d(this.AUz).AVa = 0;
    AppMethodBeat.o(63027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.e.a.5
 * JD-Core Version:    0.7.0.1
 */