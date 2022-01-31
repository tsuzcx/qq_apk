package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

final class e$1
  implements b
{
  e$1(e parame, String paramString, int paramInt, k paramk, bi parambi) {}
  
  public final void a(c paramc)
  {
    y.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.aox });
  }
  
  public final void b(c paramc)
  {
    y.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.aox });
    int i = paramc.errCode;
    y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(i) });
    if (i == 4) {
      h.nFQ.h(896L, 2L, 1L);
    }
    for (;;)
    {
      e.a(this.vvi, this.vvh, this.vtV, this.kX);
      if (paramc.errCode == 4) {
        e.cGa();
      }
      return;
      if (i == 5) {
        h.nFQ.h(896L, 3L, 1L);
      }
    }
  }
  
  public final void c(c paramc)
  {
    y.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.aox });
    e.a(this.dUy, this.vtV);
  }
  
  public final void f(Bitmap paramBitmap)
  {
    f localf;
    if ((paramBitmap != null) && (this.vvi.vva != null))
    {
      y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.vvh });
      localf = this.vvi.vva;
      if (this.kX <= 0) {
        break label66;
      }
    }
    label66:
    for (int i = this.kX;; i = this.vtV.mPosition)
    {
      localf.b(i, paramBitmap);
      e.a(this.vtV);
      return;
    }
  }
  
  public final void jL()
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
  }
  
  public final void jM() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e.1
 * JD-Core Version:    0.7.0.1
 */