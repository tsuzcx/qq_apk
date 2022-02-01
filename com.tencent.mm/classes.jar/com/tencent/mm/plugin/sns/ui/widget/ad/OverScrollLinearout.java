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
  private boolean kPn;
  private int ldE;
  private Scroller mScroller;
  private int xVc;
  private a xYI;
  private int xYJ;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(187795);
    init(paramContext);
    AppMethodBeat.o(187795);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187796);
    init(paramContext);
    AppMethodBeat.o(187796);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(187797);
    this.mScroller = new Scroller(paramContext);
    this.xYJ = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(187797);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187798);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      this.kPn = false;
      this.xVc = j;
      this.ldE = this.xVc;
      if (this.xYI != null) {
        this.xYI.dwC();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(187798);
      return bool;
      if (i == 2)
      {
        if ((this.xYI != null) && (this.xYI.dxa()) && (this.xVc - j >= this.xYJ)) {
          this.kPn = true;
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
    AppMethodBeat.i(187800);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(187800);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.kPn;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187799);
    int i = (int)paramMotionEvent.getY();
    if (this.xYI != null) {
      this.xYI.bs(this.ldE - i);
    }
    this.ldE = i;
    boolean bool = this.kPn;
    AppMethodBeat.o(187799);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.xYI = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bs(float paramFloat);
    
    public abstract void dwC();
    
    public abstract boolean dxa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */