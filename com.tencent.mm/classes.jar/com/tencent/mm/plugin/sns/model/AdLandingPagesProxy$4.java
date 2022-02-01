package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.sdk.platformtools.Log;

final class AdLandingPagesProxy$4
  implements a.b
{
  AdLandingPagesProxy$4(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void failed(long paramLong)
  {
    AppMethodBeat.i(309464);
    this.Qqp.CLIENT_CALL("failed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309464);
  }
  
  public final void paused(long paramLong)
  {
    AppMethodBeat.i(309453);
    this.Qqp.CLIENT_CALL("paused", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309453);
  }
  
  public final void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(309451);
    Log.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramInt) });
    this.Qqp.CLIENT_CALL("progress", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(309451);
  }
  
  public final void resumed(long paramLong)
  {
    AppMethodBeat.i(309467);
    this.Qqp.CLIENT_CALL("resumed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309467);
  }
  
  public final void start(long paramLong)
  {
    AppMethodBeat.i(309444);
    this.Qqp.CLIENT_CALL("start", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309444);
  }
  
  public final void stopped(long paramLong)
  {
    AppMethodBeat.i(309457);
    this.Qqp.CLIENT_CALL("stopped", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309457);
  }
  
  public final void succeed(long paramLong)
  {
    AppMethodBeat.i(309461);
    this.Qqp.CLIENT_CALL("succeed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(309461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.4
 * JD-Core Version:    0.7.0.1
 */