package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.view.View;
import com.davemorrissey.labs.subscaleview.view.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.WxImageView;

final class f$6$1
  implements Runnable
{
  f$6$1(f.6 param6, View paramView, String paramString) {}
  
  public final void run()
  {
    boolean bool2 = true;
    AppMethodBeat.i(32140);
    f.6 local6 = this.zLB;
    WxImageView localWxImageView = (WxImageView)this.val$view;
    String str = this.zLB.hXK;
    Object localObject = this.zLA;
    int i = this.zLB.zLz;
    if ((f.b(local6.zLv) != null) && (localWxImageView != null) && (!bo.isNullOrNil(str)))
    {
      int j = f.k(local6.zLv);
      boolean bool1;
      if (f.l(local6.zLv) == null)
      {
        bool1 = true;
        if ((f.l(local6.zLv) == null) || (!f.l(local6.zLv).isRecycled())) {
          break label235;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((i != f.k(local6.zLv)) || (f.l(local6.zLv) == null) || (f.l(local6.zLv).isRecycled())) {
          break label278;
        }
        localObject = f.l(local6.zLv);
        if (localObject != null) {
          break label241;
        }
        localObject = new NullPointerException("Bitmap must not be null");
        AppMethodBeat.o(32140);
        throw ((Throwable)localObject);
        bool1 = false;
        break;
        label235:
        bool2 = false;
      }
      label241:
      localObject = new a((Bitmap)localObject);
    }
    for (;;)
    {
      f.b(local6.zLv).a(localWxImageView, str, (a)localObject);
      AppMethodBeat.o(32140);
      return;
      label278:
      if (!bo.isNullOrNil((String)localObject)) {
        localObject = a.Y((String)localObject);
      } else {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.6.1
 * JD-Core Version:    0.7.0.1
 */