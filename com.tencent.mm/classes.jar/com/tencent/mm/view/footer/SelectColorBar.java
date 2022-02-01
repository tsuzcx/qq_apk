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
import com.tencent.mm.bv.a.c;

public class SelectColorBar
  extends View
{
  public static final int[] YQk = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private final float YPT;
  private a YQN;
  private int YQO;
  private Rect[] YQf;
  private Paint YQi;
  private boolean YQo;
  private Paint jZX;
  
  public SelectColorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9417);
    this.YPT = getResources().getDimension(a.c.feature_padding);
    this.YQO = -1;
    this.YQo = true;
    this.YQi = new Paint(1);
    this.YQi.setColor(-16711936);
    this.YQf = new Rect[YQk.length];
    this.jZX = new Paint(1);
    this.jZX.setStyle(Paint.Style.FILL);
    this.jZX.setStrokeCap(Paint.Cap.ROUND);
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
        if (i >= this.YQf.length) {
          break;
        }
      } while (!this.YQf[i].contains(k, m));
      this.YQO = i;
      continue;
      do
      {
        j += 1;
        if ((this.YQf == null) || (j >= this.YQf.length)) {
          break;
        }
      } while ((!this.YQf[j].contains(k, m)) || (j != this.YQO) || (this.YQN == null));
      this.YQN.akj(YQk[j]);
      requestLayout();
      postInvalidate();
    }
  }
  
  public int getCurColor()
  {
    if (this.YQO == -1) {
      return YQk[2];
    }
    return YQk[this.YQO];
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
    return (int)(2.0F * this.YPT);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9421);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    float f4 = getResources().getDimension(a.c.doodle_radio);
    float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f4 * YQk.length) / (YQk.length - 1);
    float f2 = getPaddingLeftAndRight() / 2 + f4 + 5.0F;
    float f6 = 1.0F * getDetailHeight() / 2.0F;
    int i = 0;
    if (i < YQk.length)
    {
      float f3 = 0.0F;
      float f1;
      if (this.YQO == i)
      {
        this.YQo = false;
        f1 = 6.0F;
      }
      for (;;)
      {
        this.jZX.setColor(-1);
        paramCanvas.drawCircle(f2, f6, f4 + 5.0F + f1, this.jZX);
        this.jZX.setColor(YQk[i]);
        paramCanvas.drawCircle(f2, f6, f1 + f4, this.jZX);
        f2 += 2.0F * f4 + f5;
        i += 1;
        break;
        f1 = f3;
        if (this.YQo)
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
    if (this.YQf == null) {
      this.YQf = new Rect[YQk.length];
    }
    float f1 = getResources().getDimension(a.c.doodle_radio);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f1 * YQk.length) / (YQk.length - 1);
    i = (int)(2.0F * f1);
    paramInt2 = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    j = getDetailHeight() / 2;
    paramInt1 = 0;
    while (paramInt1 < YQk.length)
    {
      this.YQf[paramInt1] = new Rect(paramInt2 - i, j - i, paramInt2 + i, j + i);
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
      if (i < YQk.length)
      {
        if (YQk[i] == paramInt) {
          this.YQO = i;
        }
      }
      else
      {
        this.YQo = false;
        postInvalidate();
        AppMethodBeat.o(9418);
        return;
      }
      i += 1;
    }
  }
  
  public void setSelectColorListener(a parama)
  {
    this.YQN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void akj(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.footer.SelectColorBar
 * JD-Core Version:    0.7.0.1
 */