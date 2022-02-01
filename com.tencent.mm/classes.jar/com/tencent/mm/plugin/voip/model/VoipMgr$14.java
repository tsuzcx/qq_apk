package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.a;

final class VoipMgr$14
  implements Runnable
{
  VoipMgr$14(VoipMgr paramVoipMgr, int[] paramArrayOfInt, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(192022);
    if (VoipMgr.e(this.zlq) != null) {
      VoipMgr.e(this.zlq).E(this.zii);
    }
    if (VoipMgr.q(this.zlq) != null) {
      VoipMgr.q(this.zlq);
    }
    AppMethodBeat.o(192022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.14
 * JD-Core Version:    0.7.0.1
 */