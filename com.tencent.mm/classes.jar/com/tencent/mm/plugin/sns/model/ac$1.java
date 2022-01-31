package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.sc.b;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.sdk.platformtools.ab;

final class ac$1
  implements Runnable
{
  ac$1(ac paramac, sc paramsc, bby parambby, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(36371);
    ab.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.rfX.cIt.result) });
    if (this.rfX.cIt.result >= 0)
    {
      ac.a(this.rfZ);
      this.rfZ.a(this.rfY, this.hye);
      AppMethodBeat.o(36371);
      return;
    }
    this.rfZ.onError();
    AppMethodBeat.o(36371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac.1
 * JD-Core Version:    0.7.0.1
 */