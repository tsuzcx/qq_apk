package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b;

final class VoipMgr$20
  implements Runnable
{
  VoipMgr$20(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(4481);
    b.cLC().tyR.stopRing();
    if (VoipMgr.e(this.tyo))
    {
      b.cLC().HA(0);
      AppMethodBeat.o(4481);
      return;
    }
    b.cLC().HA(1);
    AppMethodBeat.o(4481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.20
 * JD-Core Version:    0.7.0.1
 */