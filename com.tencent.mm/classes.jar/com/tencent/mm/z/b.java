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
  private static Paint gBr;
  private float cQN;
  public int mColor;
  private Path xN;
  private float xq;
  
  static
  {
    AppMethodBeat.i(9248);
    Paint localPaint = new Paint();
    gBr = localPaint;
    localPaint.setAntiAlias(true);
    gBr.setStyle(Paint.Style.STROKE);
    gBr.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9248);
  }
  
  public b(Path paramPath, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(9246);
    this.cQN = 1.0F;
    this.xq = a.cb(5.0F);
    this.xN = paramPath;
    this.cQN = paramFloat;
    this.mColor = paramInt;
    AppMethodBeat.o(9246);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9247);
    gBr.setColor(this.mColor);
    gBr.setStrokeWidth(this.xq * this.cQN);
    if (!this.xN.isEmpty()) {
      paramCanvas.drawPath(this.xN, gBr);
    }
    AppMethodBeat.o(9247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */