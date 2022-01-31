package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class e
{
  Bitmap bitmap = null;
  int resId = -1;
  
  public final void m(ImageView paramImageView)
  {
    AppMethodBeat.i(107159);
    if (paramImageView == null)
    {
      AppMethodBeat.o(107159);
      return;
    }
    if (this.resId != -1) {
      paramImageView.setImageDrawable(a.k(paramImageView.getContext(), this.resId));
    }
    if (this.bitmap != null) {
      paramImageView.setImageBitmap(this.bitmap);
    }
    AppMethodBeat.o(107159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.e
 * JD-Core Version:    0.7.0.1
 */