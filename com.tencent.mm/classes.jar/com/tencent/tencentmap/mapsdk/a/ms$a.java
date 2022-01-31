package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class ms$a
  extends View
{
  public ms$a(ms paramms, Context paramContext)
  {
    super(paramContext);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    ms.a(this.a, paramCanvas, getHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(Math.min(Math.round(ms.b(this.a) + 12.0F * ms.c(this.a)), ms.d(this.a) / 2), Math.round(ms.e(this.a) * ms.c(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ms.a
 * JD-Core Version:    0.7.0.1
 */