package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class c$1$1
  implements l.a
{
  c$1$1(c.1 param1) {}
  
  public final void eT(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      y.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(this.vtX.dUy.field_msgId) });
      k.X(this.vtX.vtV.vxr, 8);
    }
    try
    {
      Bitmap localBitmap1 = x.ph(this.vtX.gBs);
      if (localBitmap1 != null)
      {
        this.vtX.vtV.vxv.setEnableHorLongBmpMode(false);
        com.tencent.mm.sdk.platformtools.k.o(this.vtX.vtV.vxv, localBitmap1.getWidth(), localBitmap1.getHeight());
        this.vtX.vtV.vxv.fs(localBitmap1.getWidth(), localBitmap1.getHeight());
        this.vtX.vtV.vxv.setImageBitmap(localBitmap1);
        this.vtX.vtV.vxv.invalidate();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        y.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { this.vtX.gBs });
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Bitmap localBitmap2 = x.pg(this.vtX.gBs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.1.1
 * JD-Core Version:    0.7.0.1
 */