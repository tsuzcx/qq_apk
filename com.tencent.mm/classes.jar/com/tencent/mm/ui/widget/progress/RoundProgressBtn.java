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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.k;
import com.tencent.mm.ui.aw;

public class RoundProgressBtn
  extends View
{
  private float CDP;
  private float Nbp;
  private boolean Ytc;
  private int Ytd;
  private int Yte;
  private int Ytf;
  private int max;
  private Paint paint;
  private int progress;
  private int progressColor;
  private int roundColor;
  private int startAngle;
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159685);
    this.Ytd = 0;
    this.Yte = 0;
    this.Ytf = aw.aZ(getContext(), a.d.Edge_0_5_A);
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(159685);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159686);
    this.Ytd = 0;
    this.Yte = 0;
    this.Ytf = aw.aZ(getContext(), a.d.Edge_0_5_A);
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(159686);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(159687);
    this.paint = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.RoundProgressBtn, paramInt, 0);
      this.roundColor = paramContext.getColor(a.k.RoundProgressBtn_roundColor, getContext().getResources().getColor(a.c.round_wheel_color));
      this.CDP = paramContext.getDimension(a.k.RoundProgressBtn_roundwidth, 0.0F);
      this.progressColor = paramContext.getColor(a.k.RoundProgressBtn_progressColor, getContext().getResources().getColor(a.c.wechat_green));
      this.Nbp = paramContext.getDimension(a.k.RoundProgressBtn_progressWidth, this.CDP);
      this.max = paramContext.getInt(a.k.RoundProgressBtn_max, 100);
      this.progress = paramContext.getInt(a.k.RoundProgressBtn_progress, 0);
      this.startAngle = paramContext.getInt(a.k.RoundProgressBtn_startAngle, -90);
      this.Ytc = paramContext.getBoolean(a.k.RoundProgressBtn_hasPause, true);
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
    if (this.CDP == 0.0F) {
      this.CDP = ((int)(getWidth() / 2 * 0.167D));
    }
    this.Nbp = this.CDP;
    this.Ytd = ((int)this.CDP);
    this.Yte = ((int)(i * 0.667F));
    int j = (int)(i - this.CDP / 2.0F);
    this.paint.setStrokeWidth(this.CDP);
    this.paint.setColor(this.roundColor);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.Nbp);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.paint.setColor(this.progressColor);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.startAngle, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    if (this.Ytc)
    {
      paramCanvas.drawRect(i - this.CDP * 1.5F, i - this.Yte / 2, i - this.CDP * 0.5F, this.Yte / 2 + i, this.paint);
      float f1 = i;
      float f2 = this.Ytd;
      float f3 = i - this.Yte / 2;
      float f4 = i;
      paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.Ytd * 1.5F + f4, this.Yte / 2 + i, this.paint);
    }
    AppMethodBeat.o(159688);
  }
  
  public void setHasPause(boolean paramBoolean)
  {
    AppMethodBeat.i(250551);
    this.Ytc = paramBoolean;
    invalidate();
    AppMethodBeat.o(250551);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */