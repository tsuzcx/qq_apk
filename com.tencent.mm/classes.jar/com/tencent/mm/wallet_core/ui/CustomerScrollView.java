package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView
  extends ScrollView
{
  private float wBH;
  private float wBI;
  private float wBJ;
  private float wBK;
  
  public CustomerScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomerScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.wBI = 0.0F;
        this.wBH = 0.0F;
        this.wBJ = paramMotionEvent.getX();
        this.wBK = paramMotionEvent.getY();
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.wBH += Math.abs(f1 - this.wBJ);
      this.wBI += Math.abs(f2 - this.wBK);
      this.wBJ = f1;
      this.wBK = f2;
    } while (this.wBH <= this.wBI);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.CustomerScrollView
 * JD-Core Version:    0.7.0.1
 */