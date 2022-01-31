package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class SnsUnScaleTextView
  extends TextView
{
  public SnsUnScaleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsUnScaleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas) {}
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUnScaleTextView
 * JD-Core Version:    0.7.0.1
 */