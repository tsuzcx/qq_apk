package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class f$5
  implements Runnable
{
  f$5(f paramf, int paramInt) {}
  
  public final void run()
  {
    if (f.b(this.vvu) == null) {
      y.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = f.b(this.vvu).Hx(this.kX);
    } while (localBitmap == null);
    f.c(this.vvu).post(new f.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.5
 * JD-Core Version:    0.7.0.1
 */