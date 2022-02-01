package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a;
import com.tencent.mm.sdk.platformtools.ad;

final class VoipMgr$20
  implements Runnable
{
  VoipMgr$20(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(192030);
    ad.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(this.zlq));
    if (VoipMgr.e(this.zlq) != null)
    {
      VoipMgr.e(this.zlq).dWU();
      VoipMgr.p(this.zlq);
    }
    AppMethodBeat.o(192030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.20
 * JD-Core Version:    0.7.0.1
 */