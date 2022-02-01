package com.tencent.mm.ui.base.preference;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public final class e
{
  Bitmap bitmap = null;
  int resId = -1;
  
  public final void l(ImageView paramImageView)
  {
    AppMethodBeat.i(142536);
    if (paramImageView == null)
    {
      AppMethodBeat.o(142536);
      return;
    }
    if (this.resId != -1) {
      paramImageView.setImageDrawable(a.l(paramImageView.getContext(), this.resId));
    }
    if (this.bitmap != null) {
      paramImageView.setImageBitmap(this.bitmap);
    }
    AppMethodBeat.o(142536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.e
 * JD-Core Version:    0.7.0.1
 */