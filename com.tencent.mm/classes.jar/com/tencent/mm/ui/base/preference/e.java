package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.cb.a;

public final class e
{
  Bitmap bitmap = null;
  int kCB = -1;
  
  public final void h(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      if (this.kCB != -1) {
        paramImageView.setImageDrawable(a.g(paramImageView.getContext(), this.kCB));
      }
    } while (this.bitmap == null);
    paramImageView.setImageBitmap(this.bitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.e
 * JD-Core Version:    0.7.0.1
 */