package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class f$6
  implements av.a
{
  private Bitmap kJz = null;
  private boolean vvx = false;
  
  f$6(f paramf, String paramString, int paramInt) {}
  
  public final boolean JS()
  {
    if ((f.b(this.vvu) == null) || (TextUtils.isEmpty(this.gAy))) {
      return false;
    }
    try
    {
      if (f.e(this.vvu).containsKey(this.gAy))
      {
        int i = ((Integer)f.e(this.vvu).get(this.gAy)).intValue();
        Object localObject = (WeakReference)f.i(this.vvu).get(i);
        if (localObject != null)
        {
          localObject = (View)((WeakReference)localObject).get();
          if ((localObject != null) && ((localObject instanceof WxImageView)))
          {
            String str = (String)f.j(this.vvu).get(i);
            this.vvx = true;
            f.c(this.vvu).post(new f.6.1(this, (View)localObject, str));
            return true;
          }
        }
      }
      this.kJz = f.b(this.vvu).loadImage(this.gAy);
      return true;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
      this.kJz = null;
    }
    return false;
  }
  
  public final boolean JT()
  {
    f.d(this.vvu);
    if (!this.vvx) {
      if (f.e(this.vvu).containsKey(this.gAy))
      {
        i = ((Integer)f.e(this.vvu).get(this.gAy)).intValue();
        if (f.f(this.vvu)) {
          break label158;
        }
        f.g(this.vvu).put(i, this.kJz);
      }
    }
    Bitmap localBitmap;
    int j;
    for (;;)
    {
      this.vvu.s(this.gAy, this.kJz);
      this.vvu.b(this.gHv, this.kJz);
      localBitmap = this.kJz;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        break;
      }
      j = 0;
      y.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
      this.kJz = null;
      f.h(this.vvu);
      return false;
      label158:
      f.a(this.vvu, i, this.kJz);
    }
    if (Build.VERSION.SDK_INT >= 12) {}
    for (int i = localBitmap.getByteCount();; i = localBitmap.getRowBytes() * localBitmap.getHeight())
    {
      j = i;
      if (i >= 0) {
        break;
      }
      throw new IllegalStateException("Negative size: " + localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.6
 * JD-Core Version:    0.7.0.1
 */