package com.tencent.mm.plugin.sns.ui.widget.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

final class OverScrollLinearout$1
  implements Runnable
{
  OverScrollLinearout$1(OverScrollLinearout paramOverScrollLinearout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    AppMethodBeat.i(220162);
    ae.w("OverScrollLinearout", "the onScrollChanged: l is " + this.AVs + ", t is " + this.ggJ + ", old l is " + this.AVt + ", oldt is " + this.AVu);
    ua localua = new ua();
    localua.dJA.scrollX = this.AVs;
    localua.dJA.scrollY = this.ggJ;
    localua.dJA.dJC = this.AVt;
    localua.dJA.dJB = this.AVu;
    a.IvT.l(localua);
    AppMethodBeat.o(220162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout.1
 * JD-Core Version:    0.7.0.1
 */