package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.c;

public class TabIconView
  extends ImageView
{
  private Paint gaZ;
  private Bitmap uRi;
  private Bitmap uRj;
  private Bitmap uRk;
  private Rect uRl;
  private Rect uRm;
  private Rect uRn;
  private int uRo = 0;
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TabIconView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void f(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uRi = c.EY(paramInt1);
      this.uRj = c.EY(paramInt3);
    }
    for (this.uRk = c.EY(paramInt2);; this.uRk = c.EX(paramInt2))
    {
      this.uRl = new Rect(0, 0, this.uRi.getWidth(), this.uRi.getHeight());
      this.uRm = new Rect(0, 0, this.uRj.getWidth(), this.uRj.getHeight());
      this.uRn = new Rect(0, 0, this.uRk.getWidth(), this.uRk.getHeight());
      this.gaZ = new Paint(1);
      return;
      this.uRi = c.EX(paramInt1);
      this.uRj = c.EX(paramInt3);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.gaZ == null) {
      return;
    }
    if (this.uRo < 128)
    {
      this.gaZ.setAlpha(255 - this.uRo * 2);
      paramCanvas.drawBitmap(this.uRj, null, this.uRm, this.gaZ);
      this.gaZ.setAlpha(this.uRo * 2);
      paramCanvas.drawBitmap(this.uRk, null, this.uRn, this.gaZ);
      return;
    }
    this.gaZ.setAlpha(255 - this.uRo * 2);
    paramCanvas.drawBitmap(this.uRk, null, this.uRn, this.gaZ);
    this.gaZ.setAlpha(this.uRo * 2);
    paramCanvas.drawBitmap(this.uRi, null, this.uRl, this.gaZ);
  }
  
  public void setFocusAlpha(int paramInt)
  {
    this.uRo = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.TabIconView
 * JD-Core Version:    0.7.0.1
 */