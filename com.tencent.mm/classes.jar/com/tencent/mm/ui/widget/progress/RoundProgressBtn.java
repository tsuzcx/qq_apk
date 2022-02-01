package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.ui.ao;

public class RoundProgressBtn
  extends View
{
  private int HKV;
  private int HKW;
  private int HKX;
  private int HKY;
  private int jsX;
  private int max;
  private Paint paint;
  private int pdd;
  private int progress;
  private float rQO;
  private float yQX;
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159685);
    this.HKW = 0;
    this.HKX = 0;
    this.HKY = ao.ap(getContext(), 2131165274);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(159685);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159686);
    this.HKW = 0;
    this.HKX = 0;
    this.HKY = ao.ap(getContext(), 2131165274);
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
      this.HKV = paramContext.getColor(4, getContext().getResources().getColor(2131100813));
      this.rQO = paramContext.getDimension(5, 0.0F);
      this.jsX = paramContext.getColor(2, getContext().getResources().getColor(2131101171));
      this.yQX = paramContext.getDimension(3, this.rQO);
      this.max = paramContext.getInt(0, 100);
      this.progress = paramContext.getInt(1, 0);
      this.pdd = paramContext.getInt(6, -90);
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
    if (this.rQO == 0.0F) {
      this.rQO = ((int)(getWidth() / 2 * 0.167D));
    }
    this.yQX = this.rQO;
    this.HKW = ((int)this.rQO);
    this.HKX = ((int)(i * 0.667F));
    int j = (int)(i - this.rQO / 2.0F);
    this.paint.setStrokeWidth(this.rQO);
    this.paint.setColor(this.HKV);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.yQX);
    this.paint.setColor(this.jsX);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.pdd, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(i - this.rQO * 1.5F, i - this.HKX / 2, i - this.rQO * 0.5F, this.HKX / 2 + i, this.paint);
    float f1 = i;
    float f2 = this.HKW;
    float f3 = i - this.HKX / 2;
    float f4 = i;
    paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.HKW * 1.5F + f4, this.HKX / 2 + i, this.paint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */