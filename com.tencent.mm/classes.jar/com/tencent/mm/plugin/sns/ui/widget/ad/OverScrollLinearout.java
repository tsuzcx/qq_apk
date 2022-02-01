package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OverScrollLinearout
  extends LinearLayout
{
  private int lDv;
  private boolean lqM;
  private Scroller mScroller;
  private int zhY;
  private a zlF;
  private int zlG;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200672);
    init(paramContext);
    AppMethodBeat.o(200672);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200673);
    init(paramContext);
    AppMethodBeat.o(200673);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(200674);
    this.mScroller = new Scroller(paramContext);
    this.zlG = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(200674);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200675);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      this.lqM = false;
      this.zhY = j;
      this.lDv = this.zhY;
      if (this.zlF != null) {
        this.zlF.dLb();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200675);
      return bool;
      if (i == 2)
      {
        if ((this.zlF != null) && (this.zlF.dLz()) && (this.zhY - j >= this.zlG)) {
          this.lqM = true;
        }
      }
      else if ((i == 1) || (i == 3))
      {
        this.mScroller.forceFinished(true);
        i = getScrollY();
        if (i != 0)
        {
          this.mScroller.startScroll(0, i, 0, -i, 300);
          invalidate();
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200677);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(200677);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.lqM;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200676);
    int i = (int)paramMotionEvent.getY();
    if (this.zlF != null) {
      this.zlF.bA(this.lDv - i);
    }
    this.lDv = i;
    boolean bool = this.lqM;
    AppMethodBeat.o(200676);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.zlF = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bA(float paramFloat);
    
    public abstract void dLb();
    
    public abstract boolean dLz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */