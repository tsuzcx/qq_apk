package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;

final class f$1
  implements com.tencent.mm.ai.f
{
  f$1(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4713);
    if ((paramInt1 != 0) && (paramInt2 == 231))
    {
      a.Loge(this.tzO.TAG, "Voip heartbeat Failed, type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
      this.tzO.tvE.tvj.tBN.twb = 111;
      this.tzO.tvE.tvj.tBN.twc = paramInt2;
      this.tzO.tvE.tvj.tBN.twt = 2;
      this.tzO.tvE.y(1, -9004, "");
      AppMethodBeat.o(4713);
      return;
    }
    AppMethodBeat.o(4713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f.1
 * JD-Core Version:    0.7.0.1
 */