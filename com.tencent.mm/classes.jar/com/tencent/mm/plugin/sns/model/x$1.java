package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.ac;

final class x$1
  implements Runnable
{
  x$1(x paramx, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95661);
    ac.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.fur);
    c.zU(this.fur);
    p.aBy().zW(this.fur);
    AppMethodBeat.o(95661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x.1
 * JD-Core Version:    0.7.0.1
 */