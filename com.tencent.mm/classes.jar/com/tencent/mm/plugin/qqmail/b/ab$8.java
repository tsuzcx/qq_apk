package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.g;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.y;

final class ab$8
  implements g
{
  ab$8(ab paramab, ab.a parama) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    y.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 >= paramInt2)
    {
      y.i("MicroMsg.ShareModeMailAppService", "finish send");
      if (this.nfj != null) {
        this.nfj.btD();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.8
 * JD-Core Version:    0.7.0.1
 */