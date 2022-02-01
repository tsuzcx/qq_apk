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
  public static final int[] Ltx = { -1, -16777216, -707825, -17592, -16535286, -15172610, -7054596, -449092 };
  private boolean LtB;
  private a LtZ;
  private final float Ltg;
  private Rect[] Lts;
  private Paint Ltv;
  private int Lua;
  private Paint gyK;
  
  public SelectColorBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9417);
    this.Ltg = getResources().getDimension(2131166286);
    this.Lua = -1;
    this.LtB = true;
    this.Ltv = new Paint(1);
    this.Ltv.setColor(-16711936);
    this.Lts = new Rect[Ltx.length];
    this.gyK = new Paint(1);
    this.gyK.setStyle(Paint.Style.FILL);
    this.gyK.setStrokeCap(Paint.Cap.ROUND);
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
        if (i >= this.Lts.length) {
          break;
        }
      } while (!this.Lts[i].contains(k, m));
      this.Lua = i;
      continue;
      do
      {
        j += 1;
        if ((this.Lts == null) || (j >= this.Lts.length)) {
          break;
        }
      } while ((!this.Lts[j].contains(k, m)) || (j != this.Lua) || (this.LtZ == null));
      this.LtZ.TD(Ltx[j]);
      requestLayout();
      postInvalidate();
    }
  }
  
  public int getCurColor()
  {
    if (this.Lua == -1) {
      return Ltx[2];
    }
    return Ltx[this.Lua];
  }
  
  protected int getDetailHeight()
  {
    AppMethodBeat.i(9422);
    int i = (int)getResources().getDimension(2131166048);
    AppMethodBeat.o(9422);
    return i;
  }
  
  public int getPaddingLeftAndRight()
  {
    return (int)(2.0F * this.Ltg);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9421);
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    float f4 = getResources().getDimension(2131166164);
    float f5 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f4 * Ltx.length) / (Ltx.length - 1);
    float f2 = getPaddingLeftAndRight() / 2 + f4 + 5.0F;
    float f6 = 1.0F * getDetailHeight() / 2.0F;
    int i = 0;
    if (i < Ltx.length)
    {
      float f3 = 0.0F;
      float f1;
      if (this.Lua == i)
      {
        this.LtB = false;
        f1 = 6.0F;
      }
      for (;;)
      {
        this.gyK.setColor(-1);
        paramCanvas.drawCircle(f2, f6, f4 + 5.0F + f1, this.gyK);
        this.gyK.setColor(Ltx[i]);
        paramCanvas.drawCircle(f2, f6, f1 + f4, this.gyK);
        f2 += 2.0F * f4 + f5;
        i += 1;
        break;
        f1 = f3;
        if (this.LtB)
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
    int j = View.MeasureSpec.makeMeasureSpec((int)getResources().getDimension(2131166048), 1073741824);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1 - paramInt2 - i, 1073741824), j);
    if (this.Lts == null) {
      this.Lts = new Rect[Ltx.length];
    }
    float f1 = getResources().getDimension(2131166164);
    float f2 = (getMeasuredWidth() - getPaddingLeftAndRight() - 2.0F * f1 * Ltx.length) / (Ltx.length - 1);
    i = (int)(2.0F * f1);
    paramInt2 = (int)(getPaddingLeftAndRight() / 2 + f1 + 5.0F);
    j = getDetailHeight() / 2;
    paramInt1 = 0;
    while (paramInt1 < Ltx.length)
    {
      this.Lts[paramInt1] = new Rect(paramInt2 - i, j - i, paramInt2 + i, j + i);
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
      if (i < Ltx.length)
      {
        if (Ltx[i] == paramInt) {
          this.Lua = i;
        }
      }
      else
      {
        this.LtB = false;
        postInvalidate();
        AppMethodBeat.o(9418);
        return;
      }
      i += 1;
    }
  }
  
  public void setSelectColorListener(a parama)
  {
    this.LtZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void TD(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.footer.SelectColorBar
 * JD-Core Version:    0.7.0.1
 */