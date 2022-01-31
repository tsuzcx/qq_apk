package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoipMgr$3
  implements Runnable
{
  VoipMgr$3(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(4459);
    VoipMgr.c(this.tyo, VoipMgr.k(this.tyo));
    VoipMgr.s(this.tyo).postDelayed(this, 5000L);
    AppMethodBeat.o(4459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.3
 * JD-Core Version:    0.7.0.1
 */