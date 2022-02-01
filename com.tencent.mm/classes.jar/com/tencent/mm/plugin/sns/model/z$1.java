package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelavatar.e;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.sdk.platformtools.Log;

final class z$1
  implements Runnable
{
  z$1(z paramz, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(95661);
    Log.i("MicroMsg.NetSceneSnsTimeLine", "checkUpdate avatar:" + this.lzC);
    d.LA(this.lzC);
    q.bFG().LC(this.lzC);
    AppMethodBeat.o(95661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.z.1
 * JD-Core Version:    0.7.0.1
 */