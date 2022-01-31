package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.sdk.platformtools.ab;

final class t$1
  implements Runnable
{
  t$1(t paramt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(145247);
    ab.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + this.efI);
    b.qT(this.efI);
    o.adi().qV(this.efI);
    AppMethodBeat.o(145247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t.1
 * JD-Core Version:    0.7.0.1
 */