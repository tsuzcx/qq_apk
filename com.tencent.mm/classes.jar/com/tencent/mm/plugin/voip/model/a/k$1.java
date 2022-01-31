package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.cth;

final class k$1
  implements f
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4729);
    a.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (cth)this.tzT.cOt();
      if ((paramString.yct == 0) || (paramString.ycu == 0))
      {
        a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.ycu);
        AppMethodBeat.o(4729);
        return;
      }
      if (this.tzT.tvE.tuO != 1)
      {
        a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.tzT.tvE.tuO);
        AppMethodBeat.o(4729);
        return;
      }
      this.tzT.tvE.tuO = 2;
      this.tzT.tvE.tuQ = paramString.ycp;
      paramm = this.tzT.tvE.tvj;
      if (paramm.tBv != 0L)
      {
        a.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
        AppMethodBeat.o(4729);
        return;
      }
    }
    catch (Exception paramString)
    {
      this.tzT.tvE.tuO = 0;
      AppMethodBeat.o(4729);
      return;
    }
    paramm.tBv = paramString.ycp;
    paramm.field_SpeedTestSvrParaArray = a.a(paramString);
    paramm.StartSpeedTest(paramString.ycp, paramString.ycu);
    AppMethodBeat.o(4729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */