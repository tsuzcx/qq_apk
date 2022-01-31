package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.al;
import java.util.TimerTask;

final class f$3
  extends TimerTask
{
  f$3(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(53944);
    if ((this.oTN.getTotalTime() >= 45000L) && (f.l(this.oTN) != e.oVS)) {
      al.d(new f.3.1(this));
    }
    if (f.l(this.oTN) == e.oVS)
    {
      f.m(this.oTN);
      al.d(new f.3.2(this));
    }
    AppMethodBeat.o(53944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.3
 * JD-Core Version:    0.7.0.1
 */