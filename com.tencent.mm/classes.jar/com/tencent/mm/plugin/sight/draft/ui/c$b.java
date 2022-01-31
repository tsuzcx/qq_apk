package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

final class c$b
  implements Runnable
{
  Bitmap kJz;
  String key;
  WeakReference<c> oha;
  
  public final void run()
  {
    c localc = (c)this.oha.get();
    if (localc != null) {
      localc.p(this.key, this.kJz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.c.b
 * JD-Core Version:    0.7.0.1
 */