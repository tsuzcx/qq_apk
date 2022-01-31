package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public class MMAutoSizeTextView
  extends TextView
{
  private float lgL;
  private Paint nV;
  private float uUk;
  private float uUl;
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMAutoSizeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void cAB()
  {
    this.lgL = getTextSize();
    if (this.lgL <= this.uUk) {
      this.lgL = this.uUl;
    }
  }
  
  private void dC(String paramString, int paramInt)
  {
    y.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramInt <= 0) {
      return;
    }
    paramInt = paramInt - getPaddingLeft() - getPaddingRight();
    cAB();
    float f1 = this.lgL;
    this.nV.setTextSize(f1);
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.uUk)
      {
        f2 = f1;
        if (this.nV.measureText(paramString) > paramInt)
        {
          f1 -= 1.0F;
          if (f1 > this.uUk) {
            break label162;
          }
          f2 = this.uUk;
        }
      }
      y.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[] { Float.valueOf(f2), Float.valueOf(this.lgL), Float.valueOf(this.nV.measureText(paramString)), Integer.valueOf(paramInt) });
      setTextSize(0, f2);
      return;
      label162:
      this.nV.setTextSize(f1);
    }
  }
  
  private void init()
  {
    setSingleLine();
    setEllipsize(TextUtils.TruncateAt.END);
    this.uUk = a.fromDPToPix(getContext(), 8);
    this.uUl = a.fromDPToPix(getContext(), 22);
    this.nV = new Paint();
    this.nV.set(getPaint());
    cAB();
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      y.printErrStackTrace("MicroMsg.MMAutoSizeTextView", paramCanvas, "", new Object[0]);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.MMAutoSizeTextView", localThrowable, "", new Object[0]);
    }
  }
  
  public boolean onPreDraw()
  {
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.w("MicroMsg.MMAutoSizeTextView", "on size changed");
    if (paramInt1 != paramInt3) {
      dC(getText().toString(), paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    y.w("MicroMsg.MMAutoSizeTextView", "on text changed");
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    dC(paramCharSequence.toString(), getWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSizeTextView
 * JD-Core Version:    0.7.0.1
 */