package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ak.c;
import com.tencent.mm.j.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ai$1$1
  implements aj.a
{
  ai$1$1(ai.1 param1, d paramd) {}
  
  public final void bw(int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(this.rUS.rUR.startTime), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(this.eiR.field_fileLength), this.eiR.field_transInfo, "", "", "", "", "", "", "", this.eiR.dlG })).QX();
    this.rUS.rUR.dmL.onSceneEnd(paramInt1, paramInt2, "", this.rUS.rUR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai.1.1
 * JD-Core Version:    0.7.0.1
 */