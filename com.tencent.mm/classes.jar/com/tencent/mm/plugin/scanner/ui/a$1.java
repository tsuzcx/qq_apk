package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ui.base.preference.f;

final class a$1
  implements Runnable
{
  a$1(a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    a.a(this.nHX).setImageBitmap(this.ara);
    a.a(this.nHX).setVisibility(0);
    if (a.b(this.nHX) != null) {
      a.b(this.nHX).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.a.1
 * JD-Core Version:    0.7.0.1
 */