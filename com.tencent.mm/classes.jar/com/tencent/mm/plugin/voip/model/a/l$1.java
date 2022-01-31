package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.voip.a.a;

final class l$1
  implements f
{
  l$1(l paraml) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    a.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + paramm.getType() + " errType:" + paramInt1 + " errCode:" + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.l.1
 * JD-Core Version:    0.7.0.1
 */