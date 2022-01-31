package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

final class d$a$1
  implements Runnable
{
  d$a$1(d.a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if (this.pXb.pWZ.pWR != null)
    {
      this.pXb.pWZ.pWR.setBackgroundDrawable(new BitmapDrawable(this.pXa));
      this.pXb.pWZ.pWR.getBackground().setAlpha(128);
    }
    d.a(this.pXb.pWZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */