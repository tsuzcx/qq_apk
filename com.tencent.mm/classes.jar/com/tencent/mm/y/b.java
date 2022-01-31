package com.tencent.mm.y;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.a;

public final class b
  implements Cloneable
{
  private static Paint eFo;
  public int mColor;
  private float mScale;
  private float nX;
  private Path ou;
  
  static
  {
    AppMethodBeat.i(116272);
    Paint localPaint = new Paint();
    eFo = localPaint;
    localPaint.setAntiAlias(true);
    eFo.setStyle(Paint.Style.STROKE);
    eFo.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(116272);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(116270);
    this.mScale = 1.0F;
    this.nX = a.bC(5.0F);
    this.ou = paramPath;
    this.mScale = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(116270);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116271);
    eFo.setColor(this.mColor);
    eFo.setStrokeWidth(this.nX * this.mScale);
    if (!this.ou.isEmpty()) {
      paramCanvas.drawPath(this.ou, eFo);
    }
    AppMethodBeat.o(116271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */