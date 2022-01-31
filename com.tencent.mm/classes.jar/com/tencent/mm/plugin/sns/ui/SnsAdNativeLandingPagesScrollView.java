package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class SnsAdNativeLandingPagesScrollView
  extends NestedScrollView
{
  private int rLR;
  private int rLS;
  private int rLT;
  private am rLU;
  private long rLV;
  private Runnable rLW;
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38615);
    this.rLR = 0;
    this.rLS = 0;
    this.rLT = 50;
    this.rLU = null;
    this.rLV = System.currentTimeMillis();
    this.rLW = new SnsAdNativeLandingPagesScrollView.1(this);
    AppMethodBeat.o(38615);
  }
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38614);
    this.rLR = 0;
    this.rLS = 0;
    this.rLT = 50;
    this.rLU = null;
    this.rLV = System.currentTimeMillis();
    this.rLW = new SnsAdNativeLandingPagesScrollView.1(this);
    AppMethodBeat.o(38614);
  }
  
  public final void fling(int paramInt)
  {
    AppMethodBeat.i(38619);
    super.fling(paramInt / 3);
    AppMethodBeat.o(38619);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38620);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(38620);
    return bool;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38616);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ab.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(38616);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38618);
    super.scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(38618);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38617);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(38617);
  }
  
  public void setScrollViewListener(am paramam)
  {
    this.rLU = paramam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView
 * JD-Core Version:    0.7.0.1
 */