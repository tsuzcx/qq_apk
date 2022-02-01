package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;

final class f$1
  implements h
{
  f$1(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(115233);
    paramString = this.UDc.UzB.UyU.UFN;
    paramString.wS((int)(System.currentTimeMillis() - paramString.UAR));
    if ((paramInt1 != 0) && (paramInt2 == 231))
    {
      g.Loge(f.a(this.UDc), "Voip heartbeat Failed, type:" + paramp.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
      this.UDc.UzB.UyU.UFN.UAh = 111;
      this.UDc.UzB.UyU.UFN.UAi = paramInt2;
      this.UDc.UzB.UyU.UFN.UAz = 2;
      this.UDc.UzB.S(1, -9004, "");
      AppMethodBeat.o(115233);
      return;
    }
    AppMethodBeat.o(115233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f.1
 * JD-Core Version:    0.7.0.1
 */