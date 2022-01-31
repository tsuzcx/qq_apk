package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class o$b
  extends Drawable
{
  boolean mmZ = false;
  private Drawable mna;
  private Drawable mnb;
  
  public o$b(o paramo, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this.mna = paramDrawable1;
    this.mnb = paramDrawable2;
    this.mmZ = false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (this.mmZ) {}
    for (Drawable localDrawable = this.mna;; localDrawable = this.mnb)
    {
      if (!getBounds().equals(localDrawable.getBounds())) {
        localDrawable.setBounds(getBounds());
      }
      localDrawable.draw(paramCanvas);
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    this.mna.setAlpha(paramInt);
    this.mnb.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mna.setColorFilter(paramColorFilter);
    this.mnb.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.o.b
 * JD-Core Version:    0.7.0.1
 */