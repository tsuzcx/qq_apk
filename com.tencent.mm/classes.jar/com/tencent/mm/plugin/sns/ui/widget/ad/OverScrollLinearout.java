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
  private a ADQ;
  private int ADR;
  private boolean lOj;
  private Scroller mScroller;
  private int mcY;
  private int zKL;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198615);
    init(paramContext);
    AppMethodBeat.o(198615);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198616);
    init(paramContext);
    AppMethodBeat.o(198616);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(198617);
    this.mScroller = new Scroller(paramContext);
    this.ADR = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(198617);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198618);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      this.lOj = false;
      this.zKL = j;
      this.mcY = this.zKL;
      if (this.ADQ != null) {
        this.ADQ.dXs();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(198618);
      return bool;
      if (i == 2)
      {
        if ((this.ADQ != null) && (this.ADQ.dXQ()) && (this.zKL - j >= this.ADR)) {
          this.lOj = true;
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
    AppMethodBeat.i(198620);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(198620);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.lOj;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198619);
    int i = (int)paramMotionEvent.getY();
    if (this.ADQ != null) {
      this.ADQ.bD(this.mcY - i);
    }
    this.mcY = i;
    boolean bool = this.lOj;
    AppMethodBeat.o(198619);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.ADQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bD(float paramFloat);
    
    public abstract boolean dXQ();
    
    public abstract void dXs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */