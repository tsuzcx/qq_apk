package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.ae;

final class y$1
  implements Runnable
{
  y$1(y paramy, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95661);
    ae.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.fOj);
    c.Dv(this.fOj);
    p.aEP().Dx(this.fOj);
    AppMethodBeat.o(95661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y.1
 * JD-Core Version:    0.7.0.1
 */