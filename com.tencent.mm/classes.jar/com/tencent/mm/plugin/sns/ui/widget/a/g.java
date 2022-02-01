package com.tencent.mm.plugin.sns.ui.widget.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public abstract class g
{
  float cHQ = 1.0F;
  private float mAlpha = 1.0F;
  protected Paint mPaint = null;
  Point xZe = new Point();
  float xZf = 0.0F;
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.xZf, this.xZe.x, this.xZe.y);
    paramCanvas.scale(this.cHQ, this.cHQ, this.xZe.x, this.xZe.y);
    m(paramCanvas);
    paramCanvas.restore();
  }
  
  public void g(Point paramPoint)
  {
    this.xZe = paramPoint;
  }
  
  protected abstract void m(Canvas paramCanvas);
  
  public final void setAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    this.mPaint.setAlpha((int)(this.mAlpha * 255.0F));
  }
  
  public final void setPaint(Paint paramPaint)
  {
    this.mPaint = paramPaint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */