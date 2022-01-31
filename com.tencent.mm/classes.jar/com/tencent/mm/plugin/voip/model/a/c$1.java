package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;

final class c$1
  implements f
{
  c$1(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4701);
    a.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    AppMethodBeat.o(4701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c.1
 * JD-Core Version:    0.7.0.1
 */