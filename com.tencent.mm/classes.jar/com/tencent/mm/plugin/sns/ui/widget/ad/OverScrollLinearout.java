package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xt;
import com.tencent.mm.sdk.platformtools.Log;

public class OverScrollLinearout
  extends LinearLayout
{
  private int QVZ;
  private a RYc;
  private int RYd;
  private int RYe;
  private Scroller mScroller;
  private boolean tfE;
  private int tyi;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(309275);
    init(paramContext);
    AppMethodBeat.o(309275);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(309277);
    init(paramContext);
    AppMethodBeat.o(309277);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(309283);
    this.mScroller = new Scroller(paramContext);
    this.RYd = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(309283);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(309286);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.tfE = false;
      this.QVZ = j;
      this.tyi = this.QVZ;
      this.RYe = k;
      if (this.RYc != null) {
        this.RYc.hjE();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(309286);
      return bool;
      if (i == 2)
      {
        if ((this.RYc != null) && (this.RYc.hkk()) && (this.RYe - k >= this.RYd)) {
          this.tfE = true;
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
    AppMethodBeat.i(309301);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(309301);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.tfE;
  }
  
  protected void onScrollChanged(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(309303);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postOnAnimation(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(309271);
        Log.w("OverScrollLinearout", "the onScrollChanged: l is " + paramInt1 + ", t is " + paramInt2 + ", old l is " + paramInt3 + ", oldt is " + paramInt4);
        xt localxt = new xt();
        localxt.ibh.ibj = paramInt1;
        localxt.ibh.ibi = paramInt2;
        localxt.ibh.ibl = paramInt3;
        localxt.ibh.ibk = paramInt4;
        localxt.publish();
        AppMethodBeat.o(309271);
      }
    });
    AppMethodBeat.o(309303);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(309294);
    int i = (int)paramMotionEvent.getY();
    if (this.RYc != null) {
      this.RYc.dm(this.tyi - i);
    }
    this.tyi = i;
    boolean bool = this.tfE;
    AppMethodBeat.o(309294);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.RYc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dm(float paramFloat);
    
    public abstract void hjE();
    
    public abstract boolean hkk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */