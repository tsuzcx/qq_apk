package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.ae;

final class t$1
  implements Runnable
{
  t$1(t paramt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95618);
    ae.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + this.fOj);
    c.Dv(this.fOj);
    p.aEP().Dx(this.fOj);
    AppMethodBeat.o(95618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t.1
 * JD-Core Version:    0.7.0.1
 */