package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class AdLandingPagesProxy$2
  implements a.b
{
  AdLandingPagesProxy$2(AdLandingPagesProxy paramAdLandingPagesProxy) {}
  
  public final void failed(long paramLong)
  {
    AppMethodBeat.i(35916);
    this.rcM.CLIENT_CALL("failed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35916);
  }
  
  public final void paused(long paramLong)
  {
    AppMethodBeat.i(35913);
    this.rcM.CLIENT_CALL("paused", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35913);
  }
  
  public final void progress(long paramLong, int paramInt)
  {
    AppMethodBeat.i(35912);
    ab.v("AdLandingPagesProxy", "progress %d", new Object[] { Integer.valueOf(paramInt) });
    this.rcM.CLIENT_CALL("progress", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    AppMethodBeat.o(35912);
  }
  
  public final void resumed(long paramLong)
  {
    AppMethodBeat.i(35917);
    this.rcM.CLIENT_CALL("resumed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35917);
  }
  
  public final void stopped(long paramLong)
  {
    AppMethodBeat.i(35914);
    this.rcM.CLIENT_CALL("stopped", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35914);
  }
  
  public final void succeed(long paramLong)
  {
    AppMethodBeat.i(35915);
    this.rcM.CLIENT_CALL("succeed", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(35915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.2
 * JD-Core Version:    0.7.0.1
 */