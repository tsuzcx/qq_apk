package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dni;

final class k$1
  implements g
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(115249);
    c.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramn.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (dni)this.zni.dVk();
      if ((paramString.EDV == 0) || (paramString.EDW == 0))
      {
        c.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.EDW);
        AppMethodBeat.o(115249);
        return;
      }
      if (this.zni.zjH.ziE != 1)
      {
        c.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.zni.zjH.ziE);
        AppMethodBeat.o(115249);
        return;
      }
      this.zni.zjH.ziE = 2;
      this.zni.zjH.ziG = paramString.EDR;
      this.zni.zjH.ziZ.a(paramString);
      AppMethodBeat.o(115249);
      return;
    }
    catch (Exception paramString)
    {
      this.zni.zjH.ziE = 0;
      AppMethodBeat.o(115249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */