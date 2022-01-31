package com.tencent.mm.z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.mm.cj.a;

public final class b
  implements Cloneable
{
  private static Paint dHJ;
  public int mColor;
  private float mScale = 1.0F;
  private float na = a.aR(5.0F);
  private Path nw;
  
  static
  {
    Paint localPaint = new Paint();
    dHJ = localPaint;
    localPaint.setAntiAlias(true);
    dHJ.setStyle(Paint.Style.STROKE);
    dHJ.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    this.nw = paramPath;
    this.mScale = paramFloat;
    this.mColor = paramInt;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    dHJ.setColor(this.mColor);
    dHJ.setStrokeWidth(this.na * this.mScale);
    if (!this.nw.isEmpty()) {
      paramCanvas.drawPath(this.nw, dHJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */