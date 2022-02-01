package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.gbo;

final class k$1
  implements h
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(115249);
    g.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramp.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (gbo)this.UDh.hYX();
      if ((paramString.abZR == 0) || (paramString.abZS == 0))
      {
        g.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.abZS);
        AppMethodBeat.o(115249);
        return;
      }
      if (this.UDh.UzB.Uyz != 1)
      {
        g.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.UDh.UzB.Uyz);
        AppMethodBeat.o(115249);
        return;
      }
      this.UDh.UzB.Uyz = 2;
      this.UDh.UzB.UyB = paramString.abZN;
      this.UDh.UzB.UyU.a(paramString);
      AppMethodBeat.o(115249);
      return;
    }
    catch (Exception paramString)
    {
      this.UDh.UzB.Uyz = 0;
      AppMethodBeat.o(115249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */