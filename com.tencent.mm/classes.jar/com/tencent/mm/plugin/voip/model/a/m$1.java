package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.cgc;

final class m$1
  implements f
{
  m$1(m paramm) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    a.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    try
    {
      if (((cgc)this.pUt.bRC()).sST != this.pUt.pQA.pQe.lpD)
      {
        a.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
        return;
      }
    }
    catch (Exception paramString)
    {
      if (paramInt1 != 0)
      {
        a.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
        this.pUt.pQA.pQe.pWi.pQU = 11;
        this.pUt.pQA.pQe.pWi.pQW = paramInt2;
        this.pUt.pQA.pQe.pWi.pQV = paramInt2;
        this.pUt.pQA.pQe.pWi.pRm = 3;
        if (paramInt1 == 1) {}
        for (this.pUt.pQA.pQe.pWi.pRg = 8;; this.pUt.pQA.pQe.pWi.pRg = 99)
        {
          this.pUt.pQA.s(1, -9004, "");
          return;
        }
      }
      this.pUt.pQA.pQh.o(paramm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m.1
 * JD-Core Version:    0.7.0.1
 */