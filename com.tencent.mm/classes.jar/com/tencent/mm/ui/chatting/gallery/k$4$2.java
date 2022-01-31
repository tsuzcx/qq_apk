package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.plugin.report.service.h;

final class k$4$2
  implements Runnable
{
  k$4$2(k.4 param4, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    h localh = h.nFQ;
    int j = this.vxC.vxz.vxx;
    if (this.ogw <= 0) {}
    for (int i = this.vxC.vxz.oHM * 1000;; i = this.ogw)
    {
      localh.f(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.gFM), Integer.valueOf(1), this.vxC.vxz.bRO, Integer.valueOf(this.vxC.vxz.vxy), this.vxC.vxz.fileId, Long.valueOf(this.vxC.vxz.createTime) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.4.2
 * JD-Core Version:    0.7.0.1
 */