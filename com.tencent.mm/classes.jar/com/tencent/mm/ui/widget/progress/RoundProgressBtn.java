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
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.k;
import com.tencent.mm.ui.ap;

public class RoundProgressBtn
  extends View
{
  private Paint gaZ;
  private int max;
  private float pGY;
  private int progress;
  private int progressColor;
  private int roundColor;
  private int startAngle;
  private float wpF;
  private int wpG = 0;
  private int wpH = 0;
  private int wpI = ap.ab(getContext(), a.d.Edge_0_5A);
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.gaZ = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.RoundProgressBtn, paramInt, 0);
      this.roundColor = paramContext.getColor(a.k.RoundProgressBtn_roundColor, getContext().getResources().getColor(a.c.round_wheel_color));
      this.wpF = paramContext.getDimension(a.k.RoundProgressBtn_roundwidth, 0.0F);
      this.progressColor = paramContext.getColor(a.k.RoundProgressBtn_progressColor, getContext().getResources().getColor(a.c.wechat_green));
      this.pGY = paramContext.getDimension(a.k.RoundProgressBtn_progressWidth, this.wpF);
      this.max = paramContext.getInt(a.k.RoundProgressBtn_max, 100);
      this.progress = paramContext.getInt(a.k.RoundProgressBtn_progress, 0);
      this.startAngle = paramContext.getInt(a.k.RoundProgressBtn_startAngle, -90);
      paramContext.recycle();
    }
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.wpF == 0.0F) {
      this.wpF = ((int)(getWidth() / 2 * 0.167D));
    }
    this.pGY = this.wpF;
    this.wpG = ((int)this.wpF);
    this.wpH = ((int)(i * 0.667F));
    int j = (int)(i - this.wpF / 2.0F);
    this.gaZ.setStrokeWidth(this.wpF);
    this.gaZ.setColor(this.roundColor);
    this.gaZ.setAntiAlias(true);
    this.gaZ.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.gaZ);
    this.gaZ.setStrokeWidth(this.pGY);
    this.gaZ.setColor(this.progressColor);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.startAngle, j, false, this.gaZ);
    this.gaZ.setStrokeWidth(0.0F);
    this.gaZ.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(i - this.wpF * 1.5F, i - this.wpH / 2, i - this.wpF * 0.5F, this.wpH / 2 + i, this.gaZ);
    float f1 = i;
    float f2 = this.wpG;
    float f3 = i - this.wpH / 2;
    float f4 = i;
    paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.wpG * 1.5F + f4, this.wpH / 2 + i, this.gaZ);
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */