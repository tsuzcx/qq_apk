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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.k;
import com.tencent.mm.ui.bd;

public class RoundProgressBtn
  extends View
{
  private float Itq;
  private float TNY;
  private boolean aglr;
  private int agls;
  private int aglt;
  private int aglu;
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
    this.agls = 0;
    this.aglt = 0;
    this.aglu = bd.bs(getContext(), a.d.Edge_0_5_A);
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(159685);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159686);
    this.agls = 0;
    this.aglt = 0;
    this.aglu = bd.bs(getContext(), a.d.Edge_0_5_A);
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
      this.Itq = paramContext.getDimension(a.k.RoundProgressBtn_roundwidth, 0.0F);
      this.progressColor = paramContext.getColor(a.k.RoundProgressBtn_progressColor, getContext().getResources().getColor(a.c.wechat_green));
      this.TNY = paramContext.getDimension(a.k.RoundProgressBtn_progressWidth, this.Itq);
      this.max = paramContext.getInt(a.k.RoundProgressBtn_max, 100);
      this.progress = paramContext.getInt(a.k.RoundProgressBtn_progress, 0);
      this.startAngle = paramContext.getInt(a.k.RoundProgressBtn_startAngle, -90);
      this.aglr = paramContext.getBoolean(a.k.RoundProgressBtn_hasPause, true);
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
    if (this.Itq == 0.0F) {
      this.Itq = ((int)(getWidth() / 2 * 0.167D));
    }
    this.TNY = this.Itq;
    this.agls = ((int)this.Itq);
    this.aglt = ((int)(i * 0.667F));
    int j = (int)(i - this.Itq / 2.0F);
    this.paint.setStrokeWidth(this.Itq);
    this.paint.setColor(this.roundColor);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.TNY);
    this.paint.setStrokeCap(Paint.Cap.ROUND);
    this.paint.setColor(this.progressColor);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.startAngle, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    if (this.aglr)
    {
      paramCanvas.drawRect(i - this.Itq * 1.5F, i - this.aglt / 2, i - this.Itq * 0.5F, this.aglt / 2 + i, this.paint);
      float f1 = i;
      float f2 = this.agls;
      float f3 = i - this.aglt / 2;
      float f4 = i;
      paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.agls * 1.5F + f4, this.aglt / 2 + i, this.paint);
    }
    AppMethodBeat.o(159688);
  }
  
  public void setHasPause(boolean paramBoolean)
  {
    AppMethodBeat.i(252477);
    this.aglr = paramBoolean;
    invalidate();
    AppMethodBeat.o(252477);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(159689);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
    AppMethodBeat.o(159689);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.progressColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */