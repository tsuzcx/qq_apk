package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class e$1$1
  implements f
{
  e$1$1(e.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      this.pLh.pLg.dmL.onSceneEnd(paramInt1, paramInt2, "", this.pLh.pLg);
      return;
    }
    this.pLh.pLg.a(this.pLh.pLg.edc, this.pLh.pLg.dmL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e.1.1
 * JD-Core Version:    0.7.0.1
 */