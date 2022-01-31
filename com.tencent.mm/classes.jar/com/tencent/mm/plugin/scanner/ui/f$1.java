package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;

final class f$1
  implements Runnable
{
  f$1(f paramf, Bitmap paramBitmap) {}
  
  public final void run()
  {
    f.a(this.nJJ).setImageBitmap(this.ara);
    f.a(this.nJJ).setBackgroundColor(0);
    if (f.b(this.nJJ) != null) {
      f.b(this.nJJ).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.f.1
 * JD-Core Version:    0.7.0.1
 */