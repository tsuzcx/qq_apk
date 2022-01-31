package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a;

final class VoipMgr$13
  implements Runnable
{
  VoipMgr$13(VoipMgr paramVoipMgr, int[] paramArrayOfInt, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(140151);
    if (VoipMgr.c(this.tyo) != null) {
      VoipMgr.c(this.tyo).B(this.tyu);
    }
    if (VoipMgr.q(this.tyo) != null) {
      VoipMgr.q(this.tyo);
    }
    AppMethodBeat.o(140151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.13
 * JD-Core Version:    0.7.0.1
 */