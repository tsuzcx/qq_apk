package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class m$3
  implements Runnable
{
  m$3(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(4438);
    try
    {
      m.q(this.tvV);
      AppMethodBeat.o(4438);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Voip.VoipDeviceHandler", "start record error: %s", new Object[] { localException.getMessage() });
      this.tvV.kJJ = 1;
      this.tvV.ttm.Hh(this.tvV.kJJ);
      AppMethodBeat.o(4438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m.3
 * JD-Core Version:    0.7.0.1
 */