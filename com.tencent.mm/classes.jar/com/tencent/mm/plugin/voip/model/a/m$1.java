package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dyz;

final class m$1
  implements com.tencent.mm.al.f
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115255);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((dyz)this.CeY.eyh()).GeI != this.CeY.Cbq.CaI.roomId)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        AppMethodBeat.o(115255);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.CeY.Cbq.CaI.Chg.CbS = 11;
        this.CeY.Cbq.CaI.Chg.CbU = paramInt2;
        this.CeY.Cbq.CaI.Chg.CbT = paramInt2;
        this.CeY.Cbq.CaI.Chg.Cck = 3;
        if (paramInt1 == 1) {}
        for (this.CeY.Cbq.CaI.Chg.Cce = 8;; this.CeY.Cbq.CaI.Chg.Cce = 99)
        {
          this.CeY.Cbq.J(1, -9004, "");
          AppMethodBeat.o(115255);
          return;
        }
      }
      this.CeY.Cbq.CaL.n(paramn);
      AppMethodBeat.o(115255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */