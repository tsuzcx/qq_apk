package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.ui.d;

final class f$3$2
  implements Runnable
{
  f$3$2(f.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(53943);
    if (f.l(this.oTP.oTN) == e.oVS)
    {
      com.tencent.mm.plugin.voip.b.cLD().Ef(this.oTP.oTN.oTv);
      if (f.k(this.oTP.oTN) != null) {
        f.k(this.oTP.oTN).bIX();
      }
    }
    AppMethodBeat.o(53943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.3.2
 * JD-Core Version:    0.7.0.1
 */