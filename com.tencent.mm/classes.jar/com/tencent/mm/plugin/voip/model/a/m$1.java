package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.dtf;

final class m$1
  implements g
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115255);
    d.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((dtf)this.AFY.ekw()).Exf != this.AFY.ACr.ABJ.roomId)
      {
        d.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        AppMethodBeat.o(115255);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        d.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.AFY.ACr.ABJ.AIf.ACR = 11;
        this.AFY.ACr.ABJ.AIf.ACT = paramInt2;
        this.AFY.ACr.ABJ.AIf.ACS = paramInt2;
        this.AFY.ACr.ABJ.AIf.ADj = 3;
        if (paramInt1 == 1) {}
        for (this.AFY.ACr.ABJ.AIf.ADd = 8;; this.AFY.ACr.ABJ.AIf.ADd = 99)
        {
          this.AFY.ACr.H(1, -9004, "");
          AppMethodBeat.o(115255);
          return;
        }
      }
      this.AFY.ACr.ABM.n(paramn);
      AppMethodBeat.o(115255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */