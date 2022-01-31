package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.view.View;
import com.davemorrissey.labs.subscaleview.view.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.WxImageView;

final class f$6$1
  implements Runnable
{
  f$6$1(f.6 param6, View paramView, String paramString) {}
  
  public final void run()
  {
    boolean bool2 = true;
    f.6 local6 = this.vvz;
    WxImageView localWxImageView = (WxImageView)this.val$view;
    String str = this.vvz.gAy;
    Object localObject = this.vvy;
    int i = this.vvz.gHv;
    if ((f.b(local6.vvu) != null) && (localWxImageView != null) && (!bk.bl(str)))
    {
      int j = f.k(local6.vvu);
      boolean bool1;
      if (f.l(local6.vvu) == null)
      {
        bool1 = true;
        if ((f.l(local6.vvu) == null) || (!f.l(local6.vvu).isRecycled())) {
          break label219;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((i != f.k(local6.vvu)) || (f.l(local6.vvu) == null) || (f.l(local6.vvu).isRecycled())) {
          break label256;
        }
        localObject = f.l(local6.vvu);
        if (localObject != null) {
          break label225;
        }
        throw new NullPointerException("Bitmap must not be null");
        bool1 = false;
        break;
        label219:
        bool2 = false;
      }
      label225:
      localObject = new a((Bitmap)localObject);
    }
    for (;;)
    {
      f.b(local6.vvu).a(localWxImageView, str, (a)localObject);
      return;
      label256:
      if (!bk.bl((String)localObject)) {
        localObject = a.U((String)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.6.1
 * JD-Core Version:    0.7.0.1
 */