package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class b$4
  implements Runnable
{
  public b$4(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(213199);
    ad.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[] { Double.valueOf(this.ySc), bt.flS().toString() });
    b.a(this.ySb, this.ySc);
    AppMethodBeat.o(213199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.4
 * JD-Core Version:    0.7.0.1
 */