package com.tencent.mm.z;

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
  private static Paint hog;
  private float dhh;
  public int mColor;
  private float mStrokeWidth;
  private Path xT;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    hog = localPaint;
    localPaint.setAntiAlias(true);
    hog.setStyle(Paint.Style.STROKE);
    hog.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.dhh = 1.0F;
    this.mStrokeWidth = a.ao(5.0F);
    this.xT = paramPath;
    this.dhh = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    hog.setColor(this.mColor);
    hog.setStrokeWidth(this.mStrokeWidth * this.dhh);
    if (!this.xT.isEmpty()) {
      paramCanvas.drawPath(this.xT, hog);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */