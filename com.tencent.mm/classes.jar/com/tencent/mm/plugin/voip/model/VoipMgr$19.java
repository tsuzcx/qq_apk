package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipMgr$19
  implements Runnable
{
  VoipMgr$19(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(4480);
    ab.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.c(this.tyo));
    if (VoipMgr.c(this.tyo) != null) {
      VoipMgr.c(this.tyo).cPz();
    }
    AppMethodBeat.o(4480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.19
 * JD-Core Version:    0.7.0.1
 */