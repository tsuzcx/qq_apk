package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public class OverScrollLinearout
  extends LinearLayout
{
  private int Kxr;
  private a LuB;
  private int LuC;
  private int LuD;
  private Scroller mScroller;
  private boolean qaz;
  private int qtD;
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198273);
    init(paramContext);
    AppMethodBeat.o(198273);
  }
  
  public OverScrollLinearout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198274);
    init(paramContext);
    AppMethodBeat.o(198274);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(198275);
    this.mScroller = new Scroller(paramContext);
    this.LuC = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(198275);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198282);
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      this.qaz = false;
      this.Kxr = j;
      this.qtD = this.Kxr;
      this.LuD = k;
      if (this.LuB != null) {
        this.LuB.fRE();
      }
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(198282);
      return bool;
      if (i == 2)
      {
        if ((this.LuB != null) && (this.LuB.fSf()) && (this.LuD - k >= this.LuC)) {
          this.qaz = true;
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
    AppMethodBeat.i(198291);
    super.onDraw(paramCanvas);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(0, this.mScroller.getCurrY());
      invalidate();
    }
    AppMethodBeat.o(198291);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.qaz;
  }
  
  protected void onScrollChanged(final int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4)
  {
    AppMethodBeat.i(198293);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postOnAnimation(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(266174);
        Log.w("OverScrollLinearout", "the onScrollChanged: l is " + paramInt1 + ", t is " + paramInt2 + ", old l is " + paramInt3 + ", oldt is " + paramInt4);
        wc localwc = new wc();
        localwc.fVk.fVm = paramInt1;
        localwc.fVk.fVl = paramInt2;
        localwc.fVk.fVo = paramInt3;
        localwc.fVk.fVn = paramInt4;
        EventCenter.instance.publish(localwc);
        AppMethodBeat.o(266174);
      }
    });
    AppMethodBeat.o(198293);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(198288);
    int i = (int)paramMotionEvent.getY();
    if (this.LuB != null) {
      this.LuB.cd(this.qtD - i);
    }
    this.qtD = i;
    boolean bool = this.qaz;
    AppMethodBeat.o(198288);
    return bool;
  }
  
  public void setOnScrollActionListener(a parama)
  {
    this.LuB = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cd(float paramFloat);
    
    public abstract void fRE();
    
    public abstract boolean fSf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.OverScrollLinearout
 * JD-Core Version:    0.7.0.1
 */