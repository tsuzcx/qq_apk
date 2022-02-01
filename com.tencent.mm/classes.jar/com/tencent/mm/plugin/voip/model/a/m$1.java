package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.eux;

final class m$1
  implements i
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(115255);
    e.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramq.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((eux)this.Han.fIJ()).LsZ != this.Han.GWA.GVV.roomId)
      {
        e.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        AppMethodBeat.o(115255);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        e.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramq.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.Han.GWA.GVV.Hcw.GXc = 11;
        this.Han.GWA.GVV.Hcw.GXe = paramInt2;
        this.Han.GWA.GVV.Hcw.GXd = paramInt2;
        this.Han.GWA.GVV.Hcw.GXu = 3;
        if (paramInt1 == 1) {}
        for (this.Han.GWA.GVV.Hcw.GXo = 8;; this.Han.GWA.GVV.Hcw.GXo = 99)
        {
          this.Han.GWA.K(1, -9004, "");
          AppMethodBeat.o(115255);
          return;
        }
      }
      this.Han.GWA.GVY.p(paramq);
      AppMethodBeat.o(115255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */