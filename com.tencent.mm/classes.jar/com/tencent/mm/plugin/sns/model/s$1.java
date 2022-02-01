package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.ac;

final class s$1
  implements Runnable
{
  s$1(s params, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95618);
    ac.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + this.fur);
    c.zU(this.fur);
    p.aBy().zW(this.fur);
    AppMethodBeat.o(95618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.1
 * JD-Core Version:    0.7.0.1
 */