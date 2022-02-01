package com.tencent.mm.ui.widget.progress;

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
import com.tencent.mm.ui.at;

public class RoundProgressBtn
  extends View
{
  private float GoD;
  private int QVg;
  private int QVh;
  private int QVi;
  private int QVj;
  private int luE;
  private int max;
  private Paint paint;
  private int progress;
  private int rHF;
  private float xzK;
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159685);
    this.QVh = 0;
    this.QVi = 0;
    this.QVj = at.aH(getContext(), 2131165277);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(159685);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159686);
    this.QVh = 0;
    this.QVi = 0;
    this.QVj = at.aH(getContext(), 2131165277);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(159686);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(159687);
    this.paint = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RoundProgressBtn, paramInt, 0);
      this.QVg = paramContext.getColor(4, getContext().getResources().getColor(2131101011));
      this.xzK = paramContext.getDimension(5, 0.0F);
      this.luE = paramContext.getColor(2, getContext().getResources().getColor(2131101414));
      this.GoD = paramContext.getDimension(3, this.xzK);
      this.max = paramContext.getInt(0, 100);
      this.progress = paramContext.getInt(1, 0);
      this.rHF = paramContext.getInt(6, -90);
      paramContext.recycle();
    }
    AppMethodBeat.o(159687);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(159688);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.xzK == 0.0F) {
      this.xzK = ((int)(getWidth() / 2 * 0.167D));
    }
    this.GoD = this.xzK;
    this.QVh = ((int)this.xzK);
    this.QVi = ((int)(i * 0.667F));
    int j = (int)(i - this.xzK / 2.0F);
    this.paint.setStrokeWidth(this.xzK);
    this.paint.setColor(this.QVg);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.GoD);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.paint.setColor(this.luE);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.rHF, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(i - this.xzK * 1.5F, i - this.QVi / 2, i - this.xzK * 0.5F, this.QVi / 2 + i, this.paint);
    float f1 = i;
    float f2 = this.QVh;
    float f3 = i - this.QVi / 2;
    float f4 = i;
    paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.QVh * 1.5F + f4, this.QVi / 2 + i, this.paint);
    AppMethodBeat.o(159688);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(159689);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
    AppMethodBeat.o(159689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */