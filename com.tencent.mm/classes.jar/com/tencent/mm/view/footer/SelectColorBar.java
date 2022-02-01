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
import com.tencent.mm.bo.a.c;

public class SelectColorBar
  extends View
{
  public static final int[] agLQ = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private final float agLA;
  private Rect[] agLM;
  private Paint agLP;
  private boolean agLU;
  private a agMt;
  private int agMu;
  private Paint mAa;
  
  public SelectColorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9417);
    this.agLA = getResources().getDimension(a.c.feature_padding);
    this.agMu = -1;
    this.agLU = true;
    this.agLP = new Paint(1);
    this.agLP.setColor(-16711936);
    this.agLM = new Rect[agLQ.length];
    this.mAa = new Paint(1);
    this.mAa.setStyle(Paint.Style.FILL);
    this.mAa.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(9417);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(9420);
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(9420);
      return true;
      do
      {
        i += 1;
        if (i >= this.agLM.length) {
          break;
        }
      } while (!this.agLM[i].contains(k, m));
      this.agMu = i;
      continue;
      do
      {
        j += 1;
        if ((this.agLM == null) || (j >= this.agLM.length)) {
          break;
        }
      } while ((!this.agLM[j].contains(k, m)) || (j != this.agMu) || (this.agMt == null));
      this.agMt.apC(agLQ[j]);
      requestLayout();
      postInvalidate();
    }
  }
  
  public int getCurColor()
  {
    if (this.agMu == -1) {
      return agLQ[2];
    }
    return agLQ[this.agMu];
  }
  
  protected int getDetailHeight()
  {
    AppMethodBeat.i(9422);
    int i = (int)getResources().getDimension(a.c.color_select_layout_height);
    AppMethodBeat.o(9422);
    return i;
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.agLA);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9421);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    float f4 = getResources().getDimension(a.c.doodle_radio);
    float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f4 * agLQ.length) / (agLQ.length - 1);
    float f2 = getPaddingLeftAndRight() / 2 + f4 + 5.0F;
    float f6 = 1.0F * getDetailHeight() / 2.0F;
    int i = 0;
    if (i < agLQ.length)
    {
      float f3 = 0.0F;
      float f1;
      if (this.agMu == i)
      {
        this.agLU = false;
        f1 = 6.0F;
      }
      for (;;)
      {
        this.mAa.setColor(-1);
        paramCanvas.drawCircle(f2, f6, f4 + 5.0F + f1, this.mAa);
        this.mAa.setColor(agLQ[i]);
        paramCanvas.drawCircle(f2, f6, f1 + f4, this.mAa);
        f2 += 2.0F * f4 + f5;
        i += 1;
        break;
        f1 = f3;
        if (this.agLU)
        {
          f1 = f3;
          if (i == 2) {
            f1 = 6.0F;
          }
        }
      }
    }
    AppMethodBeat.o(9421);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9419);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec((int)getResources().getDimension(a.c.color_select_layout_height), 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    if (this.agLM == null) {
      this.agLM = new Rect[agLQ.length];
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f1 * agLQ.length) / (agLQ.length - 1);
    i = (int)(2.0F * f1);
    paramInt2 = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    j = getDetailHeight() / 2;
    paramInt1 = 0;
    while (paramInt1 < agLQ.length)
    {
      this.agLM[paramInt1] = new Rect(paramInt2 - i, j - i, paramInt2 + i, j + i);
      paramInt2 = (int)(paramInt2 + (2.0F * f1 + f2));
      paramInt1 += 1;
    }
    AppMethodBeat.o(9419);
  }
  
  public void setSelectColor(int paramInt)
  {
    AppMethodBeat.i(9418);
    int i = 0;
    for (;;)
    {
      if (i < agLQ.length)
      {
        if (agLQ[i] == paramInt) {
          this.agMu = i;
        }
      }
      else
      {
        this.agLU = false;
        postInvalidate();
        AppMethodBeat.o(9418);
        return;
      }
      i += 1;
    }
  }
  
  public void setSelectColorListener(a parama)
  {
    this.agMt = parama;
  }
  
  public static abstract interface a
  {
    public abstract void apC(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.SelectColorBar
 * JD-Core Version:    0.7.0.1
 */