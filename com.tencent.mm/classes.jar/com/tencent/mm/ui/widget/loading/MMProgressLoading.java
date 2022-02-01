package com.tencent.mm.ui.widget.loading;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.k;

public class MMProgressLoading
  extends View
{
  private int max;
  private Paint paint;
  private int progress;
  private int progressColor;
  private int startAngle;
  
  public MMProgressLoading(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251527);
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(251527);
  }
  
  public MMProgressLoading(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251531);
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(251531);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(251536);
    this.paint = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.ProgressLoading, paramInt, 0);
      this.progressColor = paramContext.getColor(a.k.ProgressLoading_loadProgressColor, getResources().getColor(a.c.White));
      this.max = paramContext.getInt(a.k.ProgressLoading_loadMax, 100);
      this.progress = paramContext.getInt(a.k.ProgressLoading_loadprogress, 0);
      this.startAngle = paramContext.getInt(a.k.ProgressLoading_loadStartAngle, -90);
      paramContext.recycle();
    }
    AppMethodBeat.o(251536);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(251540);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(getWidth() / 2 * 0.175D);
    int k = i - j / 2 - 1;
    int m = getResources().getColor(a.c.UN_BG_0);
    this.paint.setStrokeWidth(j);
    this.paint.setColor(m);
    this.paint.setAlpha(127);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, k, this.paint);
    this.paint.setStrokeWidth(j);
    this.paint.setColor(this.progressColor);
    this.paint.setAlpha(51);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, k, this.paint);
    this.paint.setStrokeWidth(j);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.paint.setColor(this.progressColor);
    RectF localRectF = new RectF(i - k, i - k, i + k, i + k);
    i = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.startAngle, i, false, this.paint);
    AppMethodBeat.o(251540);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(251546);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
    AppMethodBeat.o(251546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.loading.MMProgressLoading
 * JD-Core Version:    0.7.0.1
 */