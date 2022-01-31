package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ctn;

final class m$1
  implements f
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(4735);
    a.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((ctn)this.tzV.cOt()).wQP != this.tzV.tvE.tvj.nMZ)
      {
        a.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        AppMethodBeat.o(4735);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        a.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.tzV.tvE.tvj.tBN.twb = 11;
        this.tzV.tvE.tvj.tBN.twd = paramInt2;
        this.tzV.tvE.tvj.tBN.twc = paramInt2;
        this.tzV.tvE.tvj.tBN.twt = 3;
        if (paramInt1 == 1) {}
        for (this.tzV.tvE.tvj.tBN.twn = 8;; this.tzV.tvE.tvj.tBN.twn = 99)
        {
          this.tzV.tvE.y(1, -9004, "");
          AppMethodBeat.o(4735);
          return;
        }
      }
      this.tzV.tvE.tvm.o(paramm);
      AppMethodBeat.o(4735);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */