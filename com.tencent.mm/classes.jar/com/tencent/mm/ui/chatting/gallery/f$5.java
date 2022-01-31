package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class f$5
  implements Runnable
{
  f$5(f paramf, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32139);
    if (f.b(this.zLv) == null)
    {
      ab.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
      AppMethodBeat.o(32139);
      return;
    }
    Bitmap localBitmap = f.b(this.zLv).Qe(this.lU);
    if (localBitmap == null)
    {
      AppMethodBeat.o(32139);
      return;
    }
    f.c(this.zLv).post(new f.5.1(this, localBitmap));
    AppMethodBeat.o(32139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f.5
 * JD-Core Version:    0.7.0.1
 */