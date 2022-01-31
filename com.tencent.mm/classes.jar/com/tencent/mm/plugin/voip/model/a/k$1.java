package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cfw;

final class k$1
  implements f
{
  k$1(k paramk) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      paramString = (cfw)this.pUr.bRC();
      if ((paramString.tVc == 0) || (paramString.tVd == 0))
      {
        a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + paramString.tVd);
        return;
      }
      if (this.pUr.pQA.pPJ != 1)
      {
        a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + this.pUr.pQA.pPJ);
        return;
      }
    }
    catch (Exception paramString)
    {
      this.pUr.pQA.pPJ = 0;
      return;
    }
    this.pUr.pQA.pPJ = 2;
    this.pUr.pQA.pPL = paramString.tUY;
    paramm = this.pUr.pQA.pQe;
    if (paramm.pVQ != 0L)
    {
      a.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
      return;
    }
    paramm.pVQ = paramString.tUY;
    paramm.field_SpeedTestSvrParaArray = a.a(paramString);
    paramm.StartSpeedTest(paramString.tUY, paramString.tVd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k.1
 * JD-Core Version:    0.7.0.1
 */