package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marginClickListener", "Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$IMarginClickListener;", "maxHeight", "maxWidth", "getMaxHeight", "getMaxWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMarginClickListener", "setMaxHeight", "setMaxWidth", "IMarginClickListener", "plugin-music_release"})
public final class WxMaxSizeRecyclerView
  extends WxRecyclerView
{
  private a AoX;
  private int maxHeight;
  private int maxWidth;
  
  public WxMaxSizeRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(220077);
    setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(220070);
        if ((paramAnonymousView instanceof WxRecyclerView))
        {
          paramAnonymousView = this.AoY;
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.axQ(), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.pG(0)), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(220070);
          return bool;
        }
        AppMethodBeat.o(220070);
        return false;
      }
    });
    AppMethodBeat.o(220077);
  }
  
  public WxMaxSizeRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(220078);
    setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(220070);
        if ((paramAnonymousView instanceof WxRecyclerView))
        {
          paramAnonymousView = this.AoY;
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.axQ(), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.pG(0)), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(220070);
          return bool;
        }
        AppMethodBeat.o(220070);
        return false;
      }
    });
    AppMethodBeat.o(220078);
  }
  
  public final int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getMaxWidth()
  {
    return this.maxWidth;
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220075);
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    if (this.maxWidth > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(220075);
  }
  
  public final void setMarginClickListener(a parama)
  {
    AppMethodBeat.i(220076);
    p.h(parama, "marginClickListener");
    this.AoX = parama;
    AppMethodBeat.o(220076);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(220073);
    this.maxHeight = paramInt;
    invalidate();
    requestLayout();
    AppMethodBeat.o(220073);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(220074);
    this.maxWidth = paramInt;
    invalidate();
    requestLayout();
    AppMethodBeat.o(220074);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$IMarginClickListener;", "", "onClick", "", "plugin-music_release"})
  public static abstract interface a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-music_release"})
  public static final class b
    implements GestureDetector.OnGestureListener
  {
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220072);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(220072);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final void onShowPress(MotionEvent paramMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(220071);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      WxMaxSizeRecyclerView.a(this.AoZ);
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(220071);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.WxMaxSizeRecyclerView
 * JD-Core Version:    0.7.0.1
 */