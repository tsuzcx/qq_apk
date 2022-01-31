package com.tencent.mm.view.footer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SelectColorBar
  extends View
{
  public static final int[] ATm = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private Paint ARc;
  private final float ASW;
  private SelectColorBar.a ATO;
  private int ATP;
  private Rect[] ATi;
  private boolean ATq;
  private Paint eFo;
  
  public SelectColorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(116439);
    this.ASW = getResources().getDimension(2131428420);
    this.ATP = -1;
    this.ATq = true;
    this.ARc = new Paint(1);
    this.ARc.setColor(-16711936);
    this.ATi = new Rect[ATm.length];
    this.eFo = new Paint(1);
    this.eFo.setStyle(Paint.Style.FILL);
    this.eFo.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(116439);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(116442);
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116442);
      return true;
      do
      {
        i += 1;
        if (i >= this.ATi.length) {
          break;
        }
      } while (!this.ATi[i].contains(k, m));
      this.ATP = i;
      continue;
      do
      {
        j += 1;
        if ((this.ATi == null) || (j >= this.ATi.length)) {
          break;
        }
      } while ((!this.ATi[j].contains(k, m)) || (j != this.ATP) || (this.ATO == null));
      this.ATO.RE(ATm[j]);
      requestLayout();
      postInvalidate();
    }
  }
  
  public int getCurColor()
  {
    if (this.ATP == -1) {
      return ATm[2];
    }
    return ATm[this.ATP];
  }
  
  protected int getDetailHeight()
  {
    AppMethodBeat.i(116444);
    int i = (int)getResources().getDimension(2131428235);
    AppMethodBeat.o(116444);
    return i;
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.ASW);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116443);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    float f4 = getResources().getDimension(2131428313);
    float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f4 * ATm.length) / (ATm.length - 1);
    float f2 = getPaddingLeftAndRight() / 2 + f4 + 5.0F;
    float f6 = 1.0F * getDetailHeight() / 2.0F;
    int i = 0;
    if (i < ATm.length)
    {
      float f3 = 0.0F;
      float f1;
      if (this.ATP == i)
      {
        this.ATq = false;
        f1 = 6.0F;
      }
      for (;;)
      {
        this.eFo.setColor(-1);
        paramCanvas.drawCircle(f2, f6, f4 + 5.0F + f1, this.eFo);
        this.eFo.setColor(ATm[i]);
        paramCanvas.drawCircle(f2, f6, f1 + f4, this.eFo);
        f2 += 2.0F * f4 + f5;
        i += 1;
        break;
        f1 = f3;
        if (this.ATq)
        {
          f1 = f3;
          if (i == 2) {
            f1 = 6.0F;
          }
        }
      }
    }
    AppMethodBeat.o(116443);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116441);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec((int)getResources().getDimension(2131428235), 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    if (this.ATi == null) {
      this.ATi = new Rect[ATm.length];
    }
    float f1 = getResources().getDimension(2131428313);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f1 * ATm.length) / (ATm.length - 1);
    i = (int)(2.0F * f1);
    paramInt2 = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    j = getDetailHeight() / 2;
    paramInt1 = 0;
    while (paramInt1 < ATm.length)
    {
      this.ATi[paramInt1] = new Rect(paramInt2 - i, j - i, paramInt2 + i, j + i);
      paramInt2 = (int)(paramInt2 + (2.0F * f1 + f2));
      paramInt1 += 1;
    }
    AppMethodBeat.o(116441);
  }
  
  public void setSelectColor(int paramInt)
  {
    AppMethodBeat.i(116440);
    int i = 0;
    for (;;)
    {
      if (i < ATm.length)
      {
        if (ATm[i] == paramInt) {
          this.ATP = i;
        }
      }
      else
      {
        this.ATq = false;
        postInvalidate();
        AppMethodBeat.o(116440);
        return;
      }
      i += 1;
    }
  }
  
  public void setSelectColorListener(SelectColorBar.a parama)
  {
    this.ATO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.footer.SelectColorBar
 * JD-Core Version:    0.7.0.1
 */