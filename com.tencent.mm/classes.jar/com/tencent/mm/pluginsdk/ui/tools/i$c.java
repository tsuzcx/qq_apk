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

public final class i$c
  extends Drawable
{
  static final Paint DFl;
  WeakReference<Bitmap> DFm;
  private boolean DFn;
  private boolean DFo;
  final Rect Iw;
  
  static
  {
    AppMethodBeat.i(152408);
    DFl = new Paint(6);
    AppMethodBeat.o(152408);
  }
  
  public i$c()
  {
    AppMethodBeat.i(152404);
    this.Iw = new Rect();
    this.DFm = new WeakReference(null);
    this.DFn = false;
    this.DFo = false;
    AppMethodBeat.o(152404);
  }
  
  public static void c(ImageView paramImageView, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(152405);
    c localc;
    if ((paramImageView.getDrawable() instanceof c))
    {
      localc = (c)paramImageView.getDrawable();
      localc.DFm = new WeakReference(paramBitmap);
      if (paramImageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
        break label103;
      }
      bool1 = true;
      label51:
      localc.DFn = bool1;
      if (paramImageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
        break label108;
      }
    }
    label103:
    label108:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.DFo = bool1;
      paramImageView.setImageDrawable(localc);
      paramImageView.postInvalidate();
      AppMethodBeat.o(152405);
      return;
      localc = new c();
      break;
      bool1 = false;
      break label51;
    }
  }
  
  public static void l(ImageView paramImageView)
  {
    AppMethodBeat.i(152406);
    c(paramImageView, null);
    AppMethodBeat.o(152406);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(152407);
    Bitmap localBitmap = (Bitmap)this.DFm.get();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {}
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(152407);
      return;
      copyBounds(this.Iw);
      paramCanvas.drawBitmap(localBitmap, null, this.Iw, DFl);
    }
    AppMethodBeat.o(152407);
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.i.c
 * JD-Core Version:    0.7.0.1
 */