package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager
  extends WxViewPager
{
  private boolean LA = true;
  private boolean uSN = true;
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected final boolean ab(float paramFloat1, float paramFloat2)
  {
    if (this.uSN) {
      return super.ab(paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.LA) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.LA) {
      return false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      y.printErrStackTrace("MicroMsg.CustomViewPager", paramMotionEvent, "get a Exception", new Object[0]);
    }
    return false;
  }
  
  public void setCanSlide(boolean paramBoolean)
  {
    this.LA = paramBoolean;
  }
  
  public void setCanSlideBySide(boolean paramBoolean)
  {
    this.uSN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.CustomViewPager
 * JD-Core Version:    0.7.0.1
 */