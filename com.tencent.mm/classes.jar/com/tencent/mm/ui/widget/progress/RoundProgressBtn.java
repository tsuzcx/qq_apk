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
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.ao;

public class RoundProgressBtn
  extends View
{
  private float AeM;
  private int Jls;
  private int Jlt;
  private int Jlu;
  private int Jlv;
  private int jTr;
  private int max;
  private int pGo;
  private Paint paint;
  private int progress;
  private float sYF;
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159685);
    this.Jlt = 0;
    this.Jlu = 0;
    this.Jlv = ao.av(getContext(), 2131165274);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(159685);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159686);
    this.Jlt = 0;
    this.Jlu = 0;
    this.Jlv = ao.av(getContext(), 2131165274);
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
      this.Jls = paramContext.getColor(4, getContext().getResources().getColor(2131100813));
      this.sYF = paramContext.getDimension(5, 0.0F);
      this.jTr = paramContext.getColor(2, getContext().getResources().getColor(2131101171));
      this.AeM = paramContext.getDimension(3, this.sYF);
      this.max = paramContext.getInt(0, 100);
      this.progress = paramContext.getInt(1, 0);
      this.pGo = paramContext.getInt(6, -90);
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
    if (this.sYF == 0.0F) {
      this.sYF = ((int)(getWidth() / 2 * 0.167D));
    }
    this.AeM = this.sYF;
    this.Jlt = ((int)this.sYF);
    this.Jlu = ((int)(i * 0.667F));
    int j = (int)(i - this.sYF / 2.0F);
    this.paint.setStrokeWidth(this.sYF);
    this.paint.setColor(this.Jls);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.AeM);
    this.paint.setColor(this.jTr);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.pGo, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(i - this.sYF * 1.5F, i - this.Jlu / 2, i - this.sYF * 0.5F, this.Jlu / 2 + i, this.paint);
    float f1 = i;
    float f2 = this.Jlt;
    float f3 = i - this.Jlu / 2;
    float f4 = i;
    paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.Jlt * 1.5F + f4, this.Jlu / 2 + i, this.paint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */