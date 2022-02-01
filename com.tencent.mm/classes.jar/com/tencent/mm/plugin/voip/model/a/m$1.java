package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.gbu;

final class m$1
  implements h
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(115255);
    g.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramp.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    paramString = this.UDj.UzB.UyU.UFN;
    paramString.wS((int)(System.currentTimeMillis() - paramString.UAQ));
    try
    {
      if (((gbu)this.UDj.hYX()).Zvz != this.UDj.UzB.UyU.roomId)
      {
        g.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        AppMethodBeat.o(115255);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        g.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramp.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.UDj.UzB.UyU.UFN.UAh = 11;
        this.UDj.UzB.UyU.UFN.UAj = paramInt2;
        this.UDj.UzB.UyU.UFN.UAi = paramInt2;
        this.UDj.UzB.UyU.UFN.UAz = 3;
        if (paramInt1 == 1) {}
        for (this.UDj.UzB.UyU.UFN.UAt = 8;; this.UDj.UzB.UyU.UFN.UAt = 99)
        {
          this.UDj.UzB.S(1, -9004, "");
          AppMethodBeat.o(115255);
          return;
        }
      }
      this.UDj.UzB.UyX.p(paramp);
      AppMethodBeat.o(115255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */