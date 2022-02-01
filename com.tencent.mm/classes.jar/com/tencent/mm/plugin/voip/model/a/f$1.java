package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;

final class f$1
  implements com.tencent.mm.ak.f
{
  f$1(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115233);
    if ((paramInt1 != 0) && (paramInt2 == 231))
    {
      com.tencent.mm.plugin.voip.b.f.Loge(this.Cws.TAG, "Voip heartbeat Failed, type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
      this.Cws.CsR.Csj.CyH.Ctt = 111;
      this.Cws.CsR.Csj.CyH.Ctu = paramInt2;
      this.Cws.CsR.Csj.CyH.CtL = 2;
      this.Cws.CsR.J(1, -9004, "");
      AppMethodBeat.o(115233);
      return;
    }
    AppMethodBeat.o(115233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f.1
 * JD-Core Version:    0.7.0.1
 */