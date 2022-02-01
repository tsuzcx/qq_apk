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
  private a AVq;
  private int AVr;
  private int AbS;
  private boolean lSK;
  private Scroller mScroller;
  private int mhq;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220163);
    init(paramContext);
    AppMethodBeat.o(220163);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220164);
    init(paramContext);
    AppMethodBeat.o(220164);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(220165);
    this.mScroller = new Scroller(paramContext);
    this.AVr = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(220165);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(220166);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    if (i == 0)
    {
      this.lSK = false;
      this.AbS = j;
      this.mhq = this.AbS;
      if (this.AVq != null) {
        this.AVq.eaV();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(220166);
      return bool;
      if (i == 2)
      {
        if ((this.AVq != null) && (this.AVq.ebu()) && (this.AbS - j >= this.AVr)) {
          this.lSK = true;
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
    AppMethodBeat.i(220168);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(220168);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.lSK;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(220169);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postOnAnimation(new OverScrollLinearout.1(this, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(220169);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(220167);
    int i = (int)paramMotionEvent.getY();
    if (this.AVq != null) {
      this.AVq.bB(this.mhq - i);
    }
    this.mhq = i;
    boolean bool = this.lSK;
    AppMethodBeat.o(220167);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.AVq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bB(float paramFloat);
    
    public abstract void eaV();
    
    public abstract boolean ebu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */