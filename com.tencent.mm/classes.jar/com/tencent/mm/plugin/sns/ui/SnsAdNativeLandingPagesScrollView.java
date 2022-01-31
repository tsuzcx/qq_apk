package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.y;

public class SnsAdNativeLandingPagesScrollView
  extends NestedScrollView
{
  private int oTU = 0;
  private int oTV = 0;
  private int oTW = 50;
  private am oTX = null;
  private long oTY = System.currentTimeMillis();
  private Runnable oTZ = new SnsAdNativeLandingPagesScrollView.1(this);
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void fling(int paramInt)
  {
    super.fling(paramInt / 3);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    y.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    super.scrollBy(paramInt1, paramInt2);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setScrollViewListener(am paramam)
  {
    this.oTX = paramam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView
 * JD-Core Version:    0.7.0.1
 */