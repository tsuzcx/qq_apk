package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;

final class i$1
  implements f
{
  i$1(i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4723);
    a.Logd(this.tzR.TAG, "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    AppMethodBeat.o(4723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i.1
 * JD-Core Version:    0.7.0.1
 */