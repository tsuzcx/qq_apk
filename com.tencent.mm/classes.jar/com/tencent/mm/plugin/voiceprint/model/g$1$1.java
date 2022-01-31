package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class g$1$1
  implements f
{
  g$1$1(g.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.pLp.pLo.dmL.onSceneEnd(paramInt1, paramInt2, "", this.pLp.pLo);
      return;
    }
    this.pLp.pLo.a(this.pLp.pLo.edc, this.pLp.pLo.dmL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g.1.1
 * JD-Core Version:    0.7.0.1
 */