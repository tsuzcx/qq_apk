package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;

final class y$1
  implements Runnable
{
  y$1(y paramy, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(145248);
    ab.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.efI);
    b.qT(this.efI);
    o.adi().qV(this.efI);
    AppMethodBeat.o(145248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.y.1
 * JD-Core Version:    0.7.0.1
 */