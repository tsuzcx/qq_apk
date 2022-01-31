package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class k$4
  implements f.a
{
  k$4(k paramk) {}
  
  public final int cv(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.vxz.oHM), Integer.valueOf(paramInt2), Integer.valueOf(this.vxz.vxx), Integer.valueOf(this.vxz.vxy), this.vxz.bRO });
    au.DS().O(new k.4.2(this, paramInt2, paramInt1));
    return 0;
  }
  
  public final void cw(int paramInt1, int paramInt2) {}
  
  public final void kA()
  {
    if (this.vxz.vuf != null) {
      this.vxz.vuf.vtP.cGB();
    }
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramInt1 + " extra: " + paramInt2);
    if (this.vxz.vuf != null) {
      this.vxz.vuf.vtP.fy(paramInt1, paramInt2);
    }
    h.nFQ.f(12084, new Object[] { Integer.valueOf(this.vxz.vxx), Integer.valueOf(this.vxz.oHM * 1000), Integer.valueOf(0), Integer.valueOf(4), this.vxz.bRO, Integer.valueOf(this.vxz.vxy), this.vxz.fileId, Long.valueOf(this.vxz.createTime) });
  }
  
  public final void ug()
  {
    ai.d(new k.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.4
 * JD-Core Version:    0.7.0.1
 */