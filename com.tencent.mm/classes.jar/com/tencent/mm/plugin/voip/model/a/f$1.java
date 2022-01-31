package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.v2protocal;

final class f$1
  implements com.tencent.mm.ah.f
{
  f$1(f paramf) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 != 0) && (paramInt2 == 231))
    {
      a.Loge(this.pUm.TAG, "Voip heartbeat Failed, type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
      this.pUm.pQA.pQe.pWi.pQU = 111;
      this.pUm.pQA.pQe.pWi.pQV = paramInt2;
      this.pUm.pQA.pQe.pWi.pRm = 2;
      this.pUm.pQA.s(1, -9004, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.f.1
 * JD-Core Version:    0.7.0.1
 */