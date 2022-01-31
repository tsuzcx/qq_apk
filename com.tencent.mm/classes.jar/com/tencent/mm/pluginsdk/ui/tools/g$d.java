package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public final class g$d
  extends Drawable
{
  static final Paint smF = new Paint(6);
  final Rect Aq = new Rect();
  WeakReference<Bitmap> smG = new WeakReference(null);
  private boolean smH = false;
  private boolean smI = false;
  
  public static void b(ImageView paramImageView, Bitmap paramBitmap)
  {
    boolean bool2 = true;
    d locald;
    if ((paramImageView.getDrawable() instanceof d))
    {
      locald = (d)paramImageView.getDrawable();
      locald.smG = new WeakReference(paramBitmap);
      if (paramImageView.getScaleType() != ImageView.ScaleType.FIT_XY) {
        break label93;
      }
      bool1 = true;
      label46:
      locald.smH = bool1;
      if (paramImageView.getScaleType() != ImageView.ScaleType.CENTER_CROP) {
        break label98;
      }
    }
    label93:
    label98:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.smI = bool1;
      paramImageView.setImageDrawable(locald);
      paramImageView.postInvalidate();
      return;
      locald = new d();
      break;
      bool1 = false;
      break label46;
    }
  }
  
  public static void g(ImageView paramImageView)
  {
    b(paramImageView, null);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = (Bitmap)this.smG.get();
    if ((localBitmap == null) || (localBitmap.isRecycled())) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      return;
      copyBounds(this.Aq);
      paramCanvas.drawBitmap(localBitmap, null, this.Aq, smF);
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.d
 * JD-Core Version:    0.7.0.1
 */