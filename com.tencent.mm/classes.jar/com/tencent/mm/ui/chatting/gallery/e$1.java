package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

final class e$1
  implements b
{
  e$1(e parame, String paramString, int paramInt, k paramk, bi parambi) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(32085);
    ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.errMsg });
    AppMethodBeat.o(32085);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(32086);
    ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.errMsg });
    int i = paramc.errCode;
    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportLoadError errCode: %d", new Object[] { Integer.valueOf(i) });
    if (i == 4) {
      h.qsU.j(896L, 2L, 1L);
    }
    for (;;)
    {
      e.a(this.zLj, this.zLi, this.zJW, this.lU);
      if (paramc.errCode == 4) {
        e.dKe();
      }
      AppMethodBeat.o(32086);
      return;
      if (i == 5) {
        h.qsU.j(896L, 3L, 1L);
      }
    }
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(32087);
    ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramc.errCode), paramc.errMsg });
    e.a(this.fkH, this.zJW);
    AppMethodBeat.o(32087);
  }
  
  public final void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(32084);
    f localf;
    if ((paramBitmap != null) && (this.zLj.zLb != null))
    {
      ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.zLi });
      localf = this.zLj.zLb;
      if (this.lU <= 0) {
        break label78;
      }
    }
    label78:
    for (int i = this.lU;; i = this.zJW.mPosition)
    {
      localf.c(i, paramBitmap);
      e.a(this.zJW);
      AppMethodBeat.o(32084);
      return;
    }
  }
  
  public final void lF()
  {
    AppMethodBeat.i(32083);
    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
    AppMethodBeat.o(32083);
  }
  
  public final void lG() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e.1
 * JD-Core Version:    0.7.0.1
 */