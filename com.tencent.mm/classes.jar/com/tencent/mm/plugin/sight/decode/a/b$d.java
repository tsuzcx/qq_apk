package com.tencent.mm.plugin.sight.decode.a;

import android.view.View;
import java.lang.ref.WeakReference;

final class b$d
  implements Runnable
{
  private b$d(b paramb) {}
  
  public final void run()
  {
    if (b.k(this.oeY).get() == null) {
      return;
    }
    ((View)b.k(this.oeY).get()).startAnimation(b.l(this.oeY));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.d
 * JD-Core Version:    0.7.0.1
 */