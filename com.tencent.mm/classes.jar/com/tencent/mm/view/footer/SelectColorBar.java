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
import com.tencent.mm.bo.a.c;

public class SelectColorBar
  extends View
{
  public static final int[] wxV = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private Paint dHJ;
  private Paint wwa = new Paint(1);
  private final float wxF = getResources().getDimension(a.c.feature_padding);
  private Rect[] wxR;
  private boolean wxY = true;
  private SelectColorBar.a wyw;
  private int wyx = -1;
  
  public SelectColorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.wwa.setColor(-16711936);
    this.wxR = new Rect[wxV.length];
    this.dHJ = new Paint(1);
    this.dHJ.setStyle(Paint.Style.FILL);
    this.dHJ.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i = 0;
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      do
      {
        i += 1;
        if (i >= this.wxR.length) {
          break;
        }
      } while (!this.wxR[i].contains(k, m));
      this.wyx = i;
      continue;
      do
      {
        j += 1;
        if ((this.wxR == null) || (j >= this.wxR.length)) {
          break;
        }
      } while ((!this.wxR[j].contains(k, m)) || (j != this.wyx) || (this.wyw == null));
      this.wyw.IL(wxV[j]);
      requestLayout();
      postInvalidate();
    }
  }
  
  public int getCurColor()
  {
    if (this.wyx == -1) {
      return wxV[2];
    }
    return wxV[this.wyx];
  }
  
  protected int getDetailHeight()
  {
    return (int)getResources().getDimension(a.c.color_select_layout_height);
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.wxF);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    float f4 = getResources().getDimension(a.c.doodle_radio);
    float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f4 * wxV.length) / (wxV.length - 1);
    float f2 = getPaddingLeftAndRight() / 2 + f4 + 5.0F;
    float f6 = 1.0F * getDetailHeight() / 2.0F;
    int i = 0;
    if (i < wxV.length)
    {
      float f3 = 0.0F;
      float f1;
      if (this.wyx == i)
      {
        this.wxY = false;
        f1 = 6.0F;
      }
      for (;;)
      {
        this.dHJ.setColor(-1);
        paramCanvas.drawCircle(f2, f6, f4 + 5.0F + f1, this.dHJ);
        this.dHJ.setColor(wxV[i]);
        paramCanvas.drawCircle(f2, f6, f1 + f4, this.dHJ);
        f2 += 2.0F * f4 + f5;
        i += 1;
        break;
        f1 = f3;
        if (this.wxY)
        {
          f1 = f3;
          if (i == 2) {
            f1 = 6.0F;
          }
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    int j = View.MeasureSpec.makeMeasureSpec((int)getResources().getDimension(a.c.color_select_layout_height), 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    if (this.wxR == null) {
      this.wxR = new Rect[wxV.length];
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f1 * wxV.length) / (wxV.length - 1);
    i = (int)(f1 * 2.0F);
    paramInt2 = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    j = getDetailHeight() / 2;
    paramInt1 = 0;
    while (paramInt1 < wxV.length)
    {
      this.wxR[paramInt1] = new Rect(paramInt2 - i, j - i, paramInt2 + i, j + i);
      paramInt2 = (int)(paramInt2 + (2.0F * f1 + f2));
      paramInt1 += 1;
    }
  }
  
  public void setSelectColor(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < wxV.length)
      {
        if (wxV[i] == paramInt) {
          this.wyx = i;
        }
      }
      else
      {
        this.wxY = false;
        postInvalidate();
        return;
      }
      i += 1;
    }
  }
  
  public void setSelectColorListener(SelectColorBar.a parama)
  {
    this.wyw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.footer.SelectColorBar
 * JD-Core Version:    0.7.0.1
 */