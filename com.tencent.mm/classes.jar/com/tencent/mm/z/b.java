package com.tencent.mm.z;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a;

public final class b
  implements Cloneable
{
  private static Paint gfa;
  private float cEY;
  public int mColor;
  private Path vU;
  private float vx;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    gfa = localPaint;
    localPaint.setAntiAlias(true);
    gfa.setStyle(Paint.Style.STROKE);
    gfa.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.cEY = 1.0F;
    this.vx = a.bY(5.0F);
    this.vU = paramPath;
    this.cEY = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    gfa.setColor(this.mColor);
    gfa.setStrokeWidth(this.vx * this.cEY);
    if (!this.vU.isEmpty()) {
      paramCanvas.drawPath(this.vU, gfa);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */