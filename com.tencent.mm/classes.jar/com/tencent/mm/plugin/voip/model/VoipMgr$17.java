package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class VoipMgr$17
  implements Runnable
{
  VoipMgr$17(VoipMgr paramVoipMgr) {}
  
  public final void run()
  {
    AppMethodBeat.i(192027);
    VoipMgr.a(this.zlq, bt.GC());
    ad.i("MicroMsg.Voip.VoipMgr", "device happened shake in time,%s", new Object[] { Long.valueOf(VoipMgr.h(this.zlq)) });
    AppMethodBeat.o(192027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.17
 * JD-Core Version:    0.7.0.1
 */