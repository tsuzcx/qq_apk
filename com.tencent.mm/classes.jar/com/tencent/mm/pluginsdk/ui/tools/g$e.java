package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;

final class g$e
  implements Runnable
{
  ImageView bNu;
  Bitmap kJz;
  
  private g$e(g paramg) {}
  
  public final void run()
  {
    if (this.bNu != null)
    {
      if ((this.kJz == null) || (!this.kJz.isRecycled())) {
        break label53;
      }
      g.d.g(this.bNu);
    }
    for (;;)
    {
      this.bNu = null;
      this.kJz = null;
      this.smn.smj.bO(this);
      return;
      label53:
      g.d.b(this.bNu, this.kJz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.e
 * JD-Core Version:    0.7.0.1
 */