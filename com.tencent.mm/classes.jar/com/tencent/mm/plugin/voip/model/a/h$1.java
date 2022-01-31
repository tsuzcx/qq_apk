package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cfo;

final class h$1
  implements f
{
  h$1(h paramh) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.pUo.pQA.mStatus);
    if (paramInt2 != 0)
    {
      a.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:" + paramInt2);
      return;
    }
    paramString = (cfo)this.pUo.bRC();
    a.Logi("MicroMsg.Voip.Redirect", "room " + paramString.sST + " member " + paramString.tAN + " key " + paramString.sSU + " relay addr cnt " + paramString.tUM + " RedirectThreshold " + paramString.tUR + " RedirectDecision " + paramString.tUS);
    paramm = new cec();
    cec localcec1 = new cec();
    cec localcec2 = new cec();
    paramm.tSS = paramString.tUM;
    paramm.tST = paramString.tUN;
    localcec1.tSS = paramString.tUO;
    localcec1.tST = paramString.tUP;
    localcec2.tSS = paramString.tUQ;
    localcec2.tST = paramString.tTx;
    this.pUo.pQA.pQe.a(paramm, localcec1, localcec2, paramString.tUR, paramString.tUS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h.1
 * JD-Core Version:    0.7.0.1
 */