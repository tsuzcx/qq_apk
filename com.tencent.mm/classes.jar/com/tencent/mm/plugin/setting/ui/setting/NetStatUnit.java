package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class NetStatUnit
  extends View
{
  protected static long max;
  private long CZg;
  private long total;
  
  public NetStatUnit(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetStatUnit(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetStatUnit(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static void IJ(long paramLong)
  {
    paramLong = (paramLong / 1572864L + 1L) * 1572864L;
    if (94371840L > paramLong) {
      if (3145728L >= paramLong) {
        break label48;
      }
    }
    for (;;)
    {
      if (paramLong > max) {
        max = paramLong;
      }
      return;
      paramLong = 94371840L;
      break;
      label48:
      paramLong = 3145728L;
    }
  }
  
  public final void al(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(173792);
    this.CZg = paramLong1;
    this.total = paramLong2;
    if (paramLong1 > 94371840L) {
      this.CZg = 94371840L;
    }
    if (paramLong2 > 94371840L) {
      this.total = 94371840L;
    }
    if (paramLong1 > paramLong2) {}
    for (;;)
    {
      IJ(paramLong1);
      AppMethodBeat.o(173792);
      return;
      paramLong1 = paramLong2;
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(73901);
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    Rect localRect1 = new Rect();
    getDrawingRect(localRect1);
    float f1 = localRect1.height() * (float)this.total / (float)max;
    float f2 = localRect1.width();
    Rect localRect2 = new Rect(localRect1.left, (int)(localRect1.bottom - f1), (int)(f2 * 0.6F + localRect1.left), localRect1.bottom);
    localPaint.setColor(-7829368);
    paramCanvas.drawRect(localRect2, localPaint);
    f1 = localRect1.height() * (float)this.CZg / (float)max;
    f2 = localRect1.width();
    localRect1 = new Rect(localRect1.left, (int)(localRect1.bottom - f1), (int)(f2 * 0.6F + localRect1.left), localRect1.bottom);
    localPaint.setColor(-16711936);
    paramCanvas.drawRect(localRect1, localPaint);
    AppMethodBeat.o(73901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.NetStatUnit
 * JD-Core Version:    0.7.0.1
 */