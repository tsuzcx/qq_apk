package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager
  extends CustomViewPager
{
  private GestureDetector irA;
  
  public MusicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63269);
    this.irA = new GestureDetector(getContext(), new b((byte)0));
    setScroller(new a(getContext()));
    AppMethodBeat.o(63269);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63270);
    if ((super.onInterceptTouchEvent(paramMotionEvent)) && (this.irA.onTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(63270);
      return true;
    }
    AppMethodBeat.o(63270);
    return false;
  }
  
  public final class a
    extends Scroller
  {
    private int duration = 1000;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(63267);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.duration);
      AppMethodBeat.o(63267);
    }
    
    public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      AppMethodBeat.i(63266);
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.duration);
      AppMethodBeat.o(63266);
    }
  }
  
  final class b
    extends GestureDetector.SimpleOnGestureListener
  {
    private b() {}
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(63268);
      if (Math.abs(paramFloat2) < Math.abs(paramFloat1))
      {
        AppMethodBeat.o(63268);
        return true;
      }
      AppMethodBeat.o(63268);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager
 * JD-Core Version:    0.7.0.1
 */