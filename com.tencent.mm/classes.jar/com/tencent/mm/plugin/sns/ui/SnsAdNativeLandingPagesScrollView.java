package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdNativeLandingPagesScrollView
  extends NestedScrollView
{
  private int Exn;
  private int Exo;
  private int Exp;
  private az Exq;
  private long Exr;
  private Runnable Exs;
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98318);
    this.Exn = 0;
    this.Exo = 0;
    this.Exp = 50;
    this.Exq = null;
    this.Exr = System.currentTimeMillis();
    this.Exs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98316);
        int i = SnsAdNativeLandingPagesScrollView.this.getScrollY();
        Log.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this)), Integer.valueOf(i) });
        if (i != SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this))
        {
          if (SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this) != null)
          {
            SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.c(SnsAdNativeLandingPagesScrollView.this);
          }
          SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this, System.currentTimeMillis());
        }
        if (SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this) - i == 0)
        {
          if (SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this) != null)
          {
            SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.c(SnsAdNativeLandingPagesScrollView.this);
          }
          SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this, SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this));
        }
        SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this, SnsAdNativeLandingPagesScrollView.this.getScrollY());
        Log.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this)), Integer.valueOf(i) });
        SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.d(SnsAdNativeLandingPagesScrollView.this), SnsAdNativeLandingPagesScrollView.e(SnsAdNativeLandingPagesScrollView.this));
        AppMethodBeat.o(98316);
      }
    };
    AppMethodBeat.o(98318);
  }
  
  public SnsAdNativeLandingPagesScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(98317);
    this.Exn = 0;
    this.Exo = 0;
    this.Exp = 50;
    this.Exq = null;
    this.Exr = System.currentTimeMillis();
    this.Exs = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98316);
        int i = SnsAdNativeLandingPagesScrollView.this.getScrollY();
        Log.w("SnsAdNativeLandingPagesScrollView", "1 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this)), Integer.valueOf(i) });
        if (i != SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this))
        {
          if (SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this) != null)
          {
            SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.c(SnsAdNativeLandingPagesScrollView.this);
          }
          SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this, System.currentTimeMillis());
        }
        if (SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this) - i == 0)
        {
          if (SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this) != null)
          {
            SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this);
            SnsAdNativeLandingPagesScrollView.c(SnsAdNativeLandingPagesScrollView.this);
          }
          SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this, SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this));
        }
        SnsAdNativeLandingPagesScrollView.b(SnsAdNativeLandingPagesScrollView.this, SnsAdNativeLandingPagesScrollView.this.getScrollY());
        Log.w("SnsAdNativeLandingPagesScrollView", "2 middlePos %d, newPos %d", new Object[] { Integer.valueOf(SnsAdNativeLandingPagesScrollView.a(SnsAdNativeLandingPagesScrollView.this)), Integer.valueOf(i) });
        SnsAdNativeLandingPagesScrollView.this.postDelayed(SnsAdNativeLandingPagesScrollView.d(SnsAdNativeLandingPagesScrollView.this), SnsAdNativeLandingPagesScrollView.e(SnsAdNativeLandingPagesScrollView.this));
        AppMethodBeat.o(98316);
      }
    };
    AppMethodBeat.o(98317);
  }
  
  public final void fling(int paramInt)
  {
    AppMethodBeat.i(98322);
    super.fling(paramInt / 3);
    AppMethodBeat.o(98322);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(98323);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(98323);
    return bool;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98319);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.w("SnsAdNativeLandingPagesScrollView", "onScrollChanged x %d,y %d,oldx %d,oldy %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(98319);
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98321);
    super.scrollBy(paramInt1, paramInt2);
    AppMethodBeat.o(98321);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(98320);
    super.scrollTo(paramInt1, paramInt2);
    AppMethodBeat.o(98320);
  }
  
  public void setScrollViewListener(az paramaz)
  {
    this.Exq = paramaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesScrollView
 * JD-Core Version:    0.7.0.1
 */