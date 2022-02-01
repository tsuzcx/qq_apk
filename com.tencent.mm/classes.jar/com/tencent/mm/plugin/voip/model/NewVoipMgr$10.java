package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class NewVoipMgr$10
  implements Runnable
{
  NewVoipMgr$10(NewVoipMgr paramNewVoipMgr, int[] paramArrayOfInt, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(191905);
    if (NewVoipMgr.a(this.zic) != null)
    {
      com.tencent.mm.plugin.voip.video.h localh = NewVoipMgr.a(this.zic).zzR;
      if (localh != null) {
        localh.dXf();
      }
    }
    if (NewVoipMgr.o(this.zic) != null) {
      NewVoipMgr.o(this.zic);
    }
    AppMethodBeat.o(191905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr.10
 * JD-Core Version:    0.7.0.1
 */