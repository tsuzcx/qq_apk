package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

final class d$b$1
  implements Runnable
{
  d$b$1(d.b paramb, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if (this.pXc.pWZ.pWS != null)
    {
      this.pXc.pWZ.pWS.setBackgroundDrawable(new BitmapDrawable(this.pXa));
      this.pXc.pWZ.pWS.getBackground().setAlpha(230);
      this.pXc.pWZ.pWS.getBackground().setFilterBitmap(true);
    }
    d.b(this.pXc.pWZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.b.1
 * JD-Core Version:    0.7.0.1
 */