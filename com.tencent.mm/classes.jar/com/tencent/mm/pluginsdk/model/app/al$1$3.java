package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ak.c;
import com.tencent.mm.j.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class al$1$3
  implements aj.a
{
  al$1$3(al.1 param1, d paramd) {}
  
  public final void bw(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 4) && (paramInt2 == 102))
    {
      au.DS().O(new al.1.3.1(this));
      return;
    }
    new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), Long.valueOf(this.rVa.rUZ.startTime), Long.valueOf(bk.UY()), Integer.valueOf(c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(this.eiR.field_fileLength), this.eiR.field_transInfo, "", "", "", "", "", "", "", this.eiR.dlG })).QX();
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.rVa.rUZ.d(this.eiR);
    }
    this.rVa.rUZ.dmL.onSceneEnd(paramInt1, paramInt2, "", this.rVa.rUZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.1.3
 * JD-Core Version:    0.7.0.1
 */