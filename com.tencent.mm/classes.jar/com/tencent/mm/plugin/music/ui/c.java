package com.tencent.mm.plugin.music.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.music.a.a;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends Drawable
{
  private Paint gaZ;
  private RectF iTa;
  private Drawable mCn;
  float mCo;
  private int mCp = a.ab(ae.getContext(), a.b.Edge_2A);
  
  public c(Drawable paramDrawable)
  {
    this.mCn = paramDrawable;
    this.gaZ = new Paint(1);
    this.gaZ.setColor(ae.getResources().getColor(a.a.light_bg_color));
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.mCn;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.mCo, f1 * 0.5F + localRect.left, localRect.top + f2 * 0.5F);
    paramCanvas.drawOval(this.iTa, this.gaZ);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.mCp;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.mCp;
  }
  
  public final int getOpacity()
  {
    if (this.mCn != null) {
      return this.mCn.getOpacity();
    }
    return -2;
  }
  
  public final void setAlpha(int paramInt)
  {
    if (this.mCn != null) {
      this.mCn.setAlpha(paramInt);
    }
    this.gaZ.setAlpha(paramInt);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mCn != null) {
      this.mCn.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.iTa = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    this.gaZ.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.c
 * JD-Core Version:    0.7.0.1
 */