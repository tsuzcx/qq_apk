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
import com.tencent.mm.ck.a.a;

public class MMProgressLoading
  extends View
{
  private int luE;
  private int max;
  private Paint paint;
  private int progress;
  private int rHF;
  
  public MMProgressLoading(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198355);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(198355);
  }
  
  public MMProgressLoading(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198356);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(198356);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(198357);
    this.paint = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ProgressLoading, paramInt, 0);
      this.luE = paramContext.getColor(1, getResources().getColor(2131099844));
      this.max = paramContext.getInt(0, 100);
      this.progress = paramContext.getInt(3, 0);
      this.rHF = paramContext.getInt(2, -90);
      paramContext.recycle();
    }
    AppMethodBeat.o(198357);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(198358);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(getWidth() / 2 * 0.175D);
    int k = i - j / 2 - 1;
    int m = getResources().getColor(2131099830);
    this.paint.setStrokeWidth(j);
    this.paint.setColor(m);
    this.paint.setAlpha(127);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, k, this.paint);
    this.paint.setStrokeWidth(j);
    this.paint.setColor(this.luE);
    this.paint.setAlpha(51);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, k, this.paint);
    this.paint.setStrokeWidth(j);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.paint.setColor(this.luE);
    RectF localRectF = new RectF(i - k, i - k, i + k, i + k);
    i = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.rHF, i, false, this.paint);
    AppMethodBeat.o(198358);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(198359);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
    AppMethodBeat.o(198359);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.loading.MMProgressLoading
 * JD-Core Version:    0.7.0.1
 */