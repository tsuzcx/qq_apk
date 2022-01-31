package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.protocal.c.cfe;
import com.tencent.mm.protocal.c.gd;

final class e$1
  implements f
{
  e$1(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm != null))
    {
      paramString = (cfe)this.pUl.bRC();
      if ((paramString.tFx.sze == 0) && (!b.bPx().pTq.bRp())) {
        b.bPx().a(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.e.1
 * JD-Core Version:    0.7.0.1
 */