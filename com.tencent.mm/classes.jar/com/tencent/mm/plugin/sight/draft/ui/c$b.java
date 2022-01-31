package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class c$b
  implements Runnable
{
  String key;
  Bitmap nfX;
  WeakReference<c> qVp;
  
  public final void run()
  {
    AppMethodBeat.i(25023);
    c localc = (c)this.qVp.get();
    if (localc != null) {
      localc.r(this.key, this.nfX);
    }
    AppMethodBeat.o(25023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c.b
 * JD-Core Version:    0.7.0.1
 */