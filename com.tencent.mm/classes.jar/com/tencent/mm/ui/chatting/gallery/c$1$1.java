package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class c$1$1
  implements l.a
{
  c$1$1(c.1 param1) {}
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31960);
    if (paramInt1 == paramInt2)
    {
      ab.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(this.zJY.fkH.field_msgId) });
      k.aq(this.zJY.zJW.zNB, 8);
    }
    try
    {
      Bitmap localBitmap1 = x.wy(this.zJY.hZn);
      if (localBitmap1 != null)
      {
        this.zJY.zJW.zNF.setEnableHorLongBmpMode(false);
        n.x(this.zJY.zJW.zNF, localBitmap1.getWidth(), localBitmap1.getHeight());
        this.zJY.zJW.zNF.cb(localBitmap1.getWidth(), localBitmap1.getHeight());
        this.zJY.zJW.zNF.setImageBitmap(localBitmap1);
        this.zJY.zJW.zNF.invalidate();
      }
      AppMethodBeat.o(31960);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        ab.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { this.zJY.hZn });
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Bitmap localBitmap2 = x.wx(this.zJY.hZn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.1.1
 * JD-Core Version:    0.7.0.1
 */