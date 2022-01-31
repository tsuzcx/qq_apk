package com.tencent.mm.ui.voicesearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.storage.ad;

final class b$7
  implements Runnable
{
  b$7(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(35333);
    if (b.b(this.ABH).isHidden())
    {
      b.b(this.ABH).NH();
      if (b.c(this.ABH))
      {
        f localf = new f(this.ABI, 3);
        aw.Rc().a(localf, 0);
        b.d(this.ABH);
        AppMethodBeat.o(35333);
      }
    }
    else
    {
      b.b(this.ABH).NG();
    }
    AppMethodBeat.o(35333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.7
 * JD-Core Version:    0.7.0.1
 */