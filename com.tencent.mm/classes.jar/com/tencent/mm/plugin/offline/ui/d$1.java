package com.tencent.mm.plugin.offline.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.tg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;

final class d$1
  implements Runnable
{
  d$1(d paramd, tg paramtg, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(43500);
    if (g.RG())
    {
      if (this.pmy.cJH.cJJ)
      {
        k.bYF();
        i locali = k.bYI();
        int i = this.pmy.cJH.cJK;
        locali.eX(i, i);
        AppMethodBeat.o(43500);
        return;
      }
      k.bYF();
      k.bYI().jV(this.pmz);
    }
    AppMethodBeat.o(43500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d.1
 * JD-Core Version:    0.7.0.1
 */