package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class OverScrollLinearout
  extends LinearLayout
{
  private int Eki;
  private a FfW;
  private int FfX;
  private int FfY;
  private Scroller mScroller;
  private boolean nak;
  private int nrL;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(204017);
    init(paramContext);
    AppMethodBeat.o(204017);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204018);
    init(paramContext);
    AppMethodBeat.o(204018);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(204019);
    this.mScroller = new Scroller(paramContext);
    this.FfX = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(204019);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204020);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.nak = false;
      this.Eki = j;
      this.nrL = this.Eki;
      this.FfY = k;
      if (this.FfW != null) {
        this.FfW.fdL();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(204020);
      return bool;
      if (i == 2)
      {
        if ((this.FfW != null) && (this.FfW.fel()) && (this.FfY - k >= this.FfX)) {
          this.nak = true;
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
    AppMethodBeat.i(204022);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(204022);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.nak;
  }
  
  protected void onScrollChanged(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(204023);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postOnAnimation(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204016);
        Log.w("OverScrollLinearout", "the onScrollChanged: l is " + paramInt1 + ", t is " + paramInt2 + ", old l is " + paramInt3 + ", oldt is " + paramInt4);
        uy localuy = new uy();
        localuy.ebn.scrollX = paramInt1;
        localuy.ebn.scrollY = paramInt2;
        localuy.ebn.ebp = paramInt3;
        localuy.ebn.ebo = paramInt4;
        EventCenter.instance.publish(localuy);
        AppMethodBeat.o(204016);
      }
    });
    AppMethodBeat.o(204023);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204021);
    int i = (int)paramMotionEvent.getY();
    if (this.FfW != null) {
      this.FfW.bV(this.nrL - i);
    }
    this.nrL = i;
    boolean bool = this.nak;
    AppMethodBeat.o(204021);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.FfW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bV(float paramFloat);
    
    public abstract void fdL();
    
    public abstract boolean fel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */