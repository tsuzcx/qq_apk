package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.cb.a;

final class ba$8
  implements SnsHeader.b
{
  ba$8(ba paramba) {}
  
  public final void M(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int j = a.fromDPToPix(ba.a(this.piF), 65);
      int i = j;
      if (j > paramBitmap.getHeight()) {
        i = paramBitmap.getHeight();
      }
      i = com.tencent.mm.ui.ak.Y(Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), i))[0];
      if (this.piF.kcm != null) {
        this.piF.kcm.setBackgroundColor(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.8
 * JD-Core Version:    0.7.0.1
 */