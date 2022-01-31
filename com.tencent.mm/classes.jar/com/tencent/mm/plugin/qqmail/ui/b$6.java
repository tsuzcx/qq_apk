package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.qqmail.b.ah;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class b$6
  implements g
{
  b$6(b paramb, String paramString1, String paramString2) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    y.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 < paramInt2)
    {
      y.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[] { this.dlh, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramm = (com.tencent.mm.plugin.qqmail.b.ai)this.nhJ.nhC.get(this.dlh);
      if (paramm != null)
      {
        paramm.state = 1;
        com.tencent.mm.sdk.platformtools.ai.d(new b.6.1(this, paramm));
      }
    }
    while (paramInt1 < paramInt2) {
      return;
    }
    com.tencent.mm.plugin.qqmail.b.ai localai = (com.tencent.mm.plugin.qqmail.b.ai)this.nhJ.nhC.get(this.dlh);
    paramm = ((u)paramm).bty().ndn;
    this.nhJ.nhE.put(this.dlh, paramm);
    this.nhJ.nhF.put(this.dlh, this.bjS);
    this.nhJ.nhD.remove(this.dlh);
    y.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[] { this.dlh, paramm });
    if (localai != null)
    {
      localai.state = 2;
      localai.nfr = paramm;
      com.tencent.mm.sdk.platformtools.ai.d(new b.6.2(this, localai));
    }
    b.a(this.nhJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.6
 * JD-Core Version:    0.7.0.1
 */