package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.CustomViewPager;

public class MusicViewPager
  extends CustomViewPager
{
  private GestureDetector iNw;
  
  public MusicViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63269);
    this.iNw = new GestureDetector(getContext(), new b((byte)0));
    setScroller(new a(getContext()));
    AppMethodBeat.o(63269);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63270);
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      GestureDetector localGestureDetector = this.iNw;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahE(), "com/tencent/mm/plugin/music/ui/MusicViewPager", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/music/ui/MusicViewPager", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
      {
        AppMethodBeat.o(63270);
        return true;
      }
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
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220710);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220710);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220709);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220709);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220708);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(220708);
    }
    
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
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220707);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicViewPager$YScrollDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220707);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicViewPager
 * JD-Core Version:    0.7.0.1
 */