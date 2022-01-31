package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(70228);
    ab.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.qTo), bo.dtY().toString() });
    b.a(this.qTn, this.qTo);
    AppMethodBeat.o(70228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.3
 * JD-Core Version:    0.7.0.1
 */