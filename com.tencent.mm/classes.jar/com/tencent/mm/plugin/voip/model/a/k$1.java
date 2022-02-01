package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dsz;

final class k$1
  implements g
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115249);
    d.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (dsz)this.AFW.ekw();
      if ((paramString.Gbi == 0) || (paramString.Gbj == 0))
      {
        d.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.Gbj);
        AppMethodBeat.o(115249);
        return;
      }
      if (this.AFW.ACr.ABo != 1)
      {
        d.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.AFW.ACr.ABo);
        AppMethodBeat.o(115249);
        return;
      }
      this.AFW.ACr.ABo = 2;
      this.AFW.ACr.ABq = paramString.Gbe;
      this.AFW.ACr.ABJ.a(paramString);
      AppMethodBeat.o(115249);
      return;
    }
    catch (Exception paramString)
    {
      this.AFW.ACr.ABo = 0;
      AppMethodBeat.o(115249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */