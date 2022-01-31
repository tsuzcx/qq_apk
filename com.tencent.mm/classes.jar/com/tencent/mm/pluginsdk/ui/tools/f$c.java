package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class f$c
  extends Drawable
{
  static final Paint wfa;
  final Rect Bc;
  WeakReference<Bitmap> wfb;
  private boolean wfc;
  private boolean wfd;
  
  static
  {
    AppMethodBeat.i(79939);
    wfa = new Paint(6);
    AppMethodBeat.o(79939);
  }
  
  public f$c()
  {
    AppMethodBeat.i(79935);
    this.Bc = new Rect();
    this.wfb = new WeakReference(null);
    this.wfc = false;
    this.wfd = false;
    AppMethodBeat.o(79935);
  }
  
  public static void d(ImageView paramImageView, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(79936);
    c localc;
    if ((paramImageView.getDrawable() instanceof c))
    {
      localc = (c)paramImageView.getDrawable();
      localc.wfb = new WeakReference(paramBitmap);
      if (paramImageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
        break label103;
      }
      bool1 = true;
      label51:
      localc.wfc = bool1;
      if (paramImageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
        break label108;
      }
    }
    label103:
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.wfd = bool1;
      paramImageView.setImageDrawable(localc);
      paramImageView.postInvalidate();
      AppMethodBeat.o(79936);
      return;
      localc = new c();
      break;
      bool1 = false;
      break label51;
    }
  }
  
  public static void l(ImageView paramImageView)
  {
    AppMethodBeat.i(79937);
    d(paramImageView, null);
    AppMethodBeat.o(79937);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(79938);
    Bitmap localBitmap = (Bitmap)this.wfb.get();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {}
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(79938);
      return;
      copyBounds(this.Bc);
      paramCanvas.drawBitmap(localBitmap, null, this.Bc, wfa);
    }
    AppMethodBeat.o(79938);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f.c
 * JD-Core Version:    0.7.0.1
 */