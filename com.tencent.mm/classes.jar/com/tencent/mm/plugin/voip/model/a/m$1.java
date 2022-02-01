package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.eaq;

final class m$1
  implements com.tencent.mm.ak.f
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115255);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((eaq)this.Cwz.eBP()).Gxq != this.Cwz.CsR.Csj.roomId)
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
        this.Cwz.CsR.Csj.CyH.Ctt = 11;
        this.Cwz.CsR.Csj.CyH.Ctv = paramInt2;
        this.Cwz.CsR.Csj.CyH.Ctu = paramInt2;
        this.Cwz.CsR.Csj.CyH.CtL = 3;
        if (paramInt1 == 1) {}
        for (this.Cwz.CsR.Csj.CyH.CtF = 8;; this.Cwz.CsR.Csj.CyH.CtF = 99)
        {
          this.Cwz.CsR.J(1, -9004, "");
          AppMethodBeat.o(115255);
          return;
        }
      }
      this.Cwz.CsR.Csm.n(paramn);
      AppMethodBeat.o(115255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */