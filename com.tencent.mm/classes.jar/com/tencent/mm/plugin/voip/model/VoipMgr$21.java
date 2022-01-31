package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.c;
import com.tencent.mm.plugin.voip.ui.b;

final class VoipMgr$21
  implements Runnable
{
  VoipMgr$21(VoipMgr paramVoipMgr, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(4482);
    if (VoipMgr.q(this.tyo) != null) {
      VoipMgr.q(this.tyo).gl(this.caF, VoipMgr.a(this.tyo).mState);
    }
    AppMethodBeat.o(4482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.21
 * JD-Core Version:    0.7.0.1
 */