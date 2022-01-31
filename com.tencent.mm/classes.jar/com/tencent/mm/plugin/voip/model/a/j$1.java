package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;

final class j$1
  implements f
{
  j$1(j paramj) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + paramInt1 + " errCode=" + paramInt2 + " errMsg=" + paramString);
    this.pUq.pQA.bPS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.j.1
 * JD-Core Version:    0.7.0.1
 */