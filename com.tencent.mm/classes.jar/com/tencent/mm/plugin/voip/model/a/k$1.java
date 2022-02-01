package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ffc;

final class k$1
  implements i
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(115249);
    e.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramq.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (ffc)this.NQv.gAY();
      if ((paramString.UFH == 0) || (paramString.UFI == 0))
      {
        e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.UFI);
        AppMethodBeat.o(115249);
        return;
      }
      if (this.NQv.NMN.NLN != 1)
      {
        e.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.NQv.NMN.NLN);
        AppMethodBeat.o(115249);
        return;
      }
      this.NQv.NMN.NLN = 2;
      this.NQv.NMN.NLP = paramString.UFD;
      this.NQv.NMN.NMi.a(paramString);
      AppMethodBeat.o(115249);
      return;
    }
    catch (Exception paramString)
    {
      this.NQv.NMN.NLN = 0;
      AppMethodBeat.o(115249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */