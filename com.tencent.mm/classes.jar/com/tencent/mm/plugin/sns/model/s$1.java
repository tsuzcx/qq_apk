package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.p;
import com.tencent.mm.sdk.platformtools.ad;

final class s$1
  implements Runnable
{
  s$1(s params, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95618);
    ad.i("MicroMsg.NetSceneSnsPreTimeLine", "checkUpdate avatar:" + this.fqK);
    c.vO(this.fqK);
    p.auH().vQ(this.fqK);
    AppMethodBeat.o(95618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s.1
 * JD-Core Version:    0.7.0.1
 */