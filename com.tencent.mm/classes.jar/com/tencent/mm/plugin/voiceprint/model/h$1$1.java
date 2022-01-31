package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;

final class h$1$1
  implements f
{
  h$1$1(h.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(26095);
    ab.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.trn.trm.callback.onSceneEnd(paramInt1, paramInt2, "", this.trn.trm);
      AppMethodBeat.o(26095);
      return;
    }
    this.trn.trm.doScene(this.trn.trm.dispatcher(), this.trn.trm.callback);
    AppMethodBeat.o(26095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.h.1.1
 * JD-Core Version:    0.7.0.1
 */