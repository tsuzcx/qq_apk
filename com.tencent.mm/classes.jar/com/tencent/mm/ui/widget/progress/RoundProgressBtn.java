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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.al;

public class RoundProgressBtn
  extends View
{
  private int AKf;
  private int AKg;
  private int AKh;
  private int AKi;
  private int huJ;
  private int lMs;
  private int max;
  private float nkS;
  private Paint paint;
  private int progress;
  private float tks;
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112959);
    this.AKg = 0;
    this.AKh = 0;
    this.AKi = al.ap(getContext(), 2131427579);
    a(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(112959);
  }
  
  public RoundProgressBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112960);
    this.AKg = 0;
    this.AKh = 0;
    this.AKi = al.ap(getContext(), 2131427579);
    a(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(112960);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(112961);
    this.paint = new Paint();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.RoundProgressBtn, paramInt, 0);
      this.AKf = paramContext.getColor(3, getContext().getResources().getColor(2131690404));
      this.nkS = paramContext.getDimension(4, 0.0F);
      this.huJ = paramContext.getColor(2, getContext().getResources().getColor(2131690701));
      this.tks = paramContext.getDimension(5, this.nkS);
      this.max = paramContext.getInt(1, 100);
      this.progress = paramContext.getInt(0, 0);
      this.lMs = paramContext.getInt(6, -90);
      paramContext.recycle();
    }
    AppMethodBeat.o(112961);
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112962);
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    if (this.nkS == 0.0F) {
      this.nkS = ((int)(getWidth() / 2 * 0.167D));
    }
    this.tks = this.nkS;
    this.AKg = ((int)this.nkS);
    this.AKh = ((int)(i * 0.667F));
    int j = (int)(i - this.nkS / 2.0F);
    this.paint.setStrokeWidth(this.nkS);
    this.paint.setColor(this.AKf);
    this.paint.setAntiAlias(true);
    this.paint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawCircle(i, i, j, this.paint);
    this.paint.setStrokeWidth(this.tks);
    this.paint.setColor(this.huJ);
    RectF localRectF = new RectF(i - j, i - j, i + j, j + i);
    j = this.progress * 360 / this.max;
    paramCanvas.drawArc(localRectF, this.lMs, j, false, this.paint);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(i - this.nkS * 1.5F, i - this.AKh / 2, i - this.nkS * 0.5F, this.AKh / 2 + i, this.paint);
    float f1 = i;
    float f2 = this.AKg;
    float f3 = i - this.AKh / 2;
    float f4 = i;
    paramCanvas.drawRect(f2 * 0.5F + f1, f3, this.AKg * 1.5F + f4, this.AKh / 2 + i, this.paint);
    AppMethodBeat.o(112962);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(112963);
    this.progress = Math.max(0, paramInt);
    this.progress = Math.min(paramInt, this.max);
    invalidate();
    AppMethodBeat.o(112963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.progress.RoundProgressBtn
 * JD-Core Version:    0.7.0.1
 */