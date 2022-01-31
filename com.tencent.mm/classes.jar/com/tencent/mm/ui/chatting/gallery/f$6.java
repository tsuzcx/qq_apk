package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class f$6
  implements az.a
{
  private Bitmap nfX = null;
  private boolean zLy = false;
  
  f$6(f paramf, String paramString, int paramInt) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(32142);
    if ((f.b(this.zLv) == null) || (TextUtils.isEmpty(this.hXK)))
    {
      AppMethodBeat.o(32142);
      return false;
    }
    try
    {
      if (f.e(this.zLv).containsKey(this.hXK))
      {
        int i = ((Integer)f.e(this.zLv).get(this.hXK)).intValue();
        Object localObject = (WeakReference)f.i(this.zLv).get(i);
        if (localObject != null)
        {
          localObject = (View)((WeakReference)localObject).get();
          if ((localObject != null) && ((localObject instanceof WxImageView)))
          {
            String str = (String)f.j(this.zLv).get(i);
            this.zLy = true;
            f.c(this.zLv).post(new f.6.1(this, (View)localObject, str));
            AppMethodBeat.o(32142);
            return true;
          }
        }
      }
      this.nfX = f.b(this.zLv).loadImage(this.hXK);
      AppMethodBeat.o(32142);
      return true;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
      this.nfX = null;
      AppMethodBeat.o(32142);
    }
    return false;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(32141);
    f.d(this.zLv);
    if (!this.zLy) {
      if (f.e(this.zLv).containsKey(this.hXK))
      {
        i = ((Integer)f.e(this.zLv).get(this.hXK)).intValue();
        if (f.f(this.zLv)) {
          break label170;
        }
        f.g(this.zLv).put(i, this.nfX);
      }
    }
    Object localObject;
    int j;
    for (;;)
    {
      this.zLv.u(this.hXK, this.nfX);
      this.zLv.c(this.zLz, this.nfX);
      localObject = this.nfX;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        break;
      }
      j = 0;
      ab.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
      this.nfX = null;
      f.h(this.zLv);
      AppMethodBeat.o(32141);
      return false;
      label170:
      f.a(this.zLv, i, this.nfX);
    }
    if (Build.VERSION.SDK_INT >= 12) {}
    for (int i = ((Bitmap)localObject).getByteCount();; i = ((Bitmap)localObject).getRowBytes() * ((Bitmap)localObject).getHeight())
    {
      j = i;
      if (i >= 0) {
        break;
      }
      localObject = new IllegalStateException("Negative size: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(32141);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.6
 * JD-Core Version:    0.7.0.1
 */