package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.sdk.platformtools.ad;

final class AdLandingPagesProxy$2
  implements a.b
{
  AdLandingPagesProxy$2(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void failed(long paramLong)
  {
    AppMethodBeat.i(95214);
    this.wDc.CLIENT_CALL("failed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95214);
  }
  
  public final void paused(long paramLong)
  {
    AppMethodBeat.i(95211);
    this.wDc.CLIENT_CALL("paused", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95211);
  }
  
  public final void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95210);
    ad.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramInt) });
    this.wDc.CLIENT_CALL("progress", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(95210);
  }
  
  public final void resumed(long paramLong)
  {
    AppMethodBeat.i(95215);
    this.wDc.CLIENT_CALL("resumed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95215);
  }
  
  public final void stopped(long paramLong)
  {
    AppMethodBeat.i(95212);
    this.wDc.CLIENT_CALL("stopped", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95212);
  }
  
  public final void succeed(long paramLong)
  {
    AppMethodBeat.i(95213);
    this.wDc.CLIENT_CALL("succeed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(95213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.2
 * JD-Core Version:    0.7.0.1
 */