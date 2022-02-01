package com.tencent.mm.plugin.music.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marginClickListener", "Lcom/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$IMarginClickListener;", "maxHeight", "maxWidth", "getMaxHeight", "getMaxWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMarginClickListener", "setMaxHeight", "setMaxWidth", "IMarginClickListener", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WxMaxSizeRecyclerView
  extends WxRecyclerView
{
  private WxMaxSizeRecyclerView.a LRe;
  private int maxHeight;
  private int maxWidth;
  
  public WxMaxSizeRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(270989);
    setOnTouchListener(new WxMaxSizeRecyclerView..ExternalSyntheticLambda0(new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new b(this))));
    AppMethodBeat.o(270989);
  }
  
  public WxMaxSizeRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270994);
    setOnTouchListener(new WxMaxSizeRecyclerView..ExternalSyntheticLambda0(new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new b(this))));
    AppMethodBeat.o(270994);
  }
  
  private static final boolean a(GestureDetector paramGestureDetector, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(271003);
    s.u(paramGestureDetector, "$gestureDetector");
    if ((paramView instanceof WxRecyclerView))
    {
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramGestureDetector, paramView.aYi(), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView", "_init_$lambda-0", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramGestureDetector, paramGestureDetector.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView", "_init_$lambda-0", "(Landroid/view/GestureDetector;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(271003);
      return bool;
    }
    AppMethodBeat.o(271003);
    return false;
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
    AppMethodBeat.i(271039);
    if (this.maxHeight > 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, -2147483648);
    }
    if (this.maxWidth > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, -2147483648);
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(271039);
  }
  
  public final void setMarginClickListener(WxMaxSizeRecyclerView.a parama)
  {
    AppMethodBeat.i(271048);
    s.u(parama, "marginClickListener");
    this.LRe = parama;
    AppMethodBeat.o(271048);
  }
  
  public final void setMaxHeight(int paramInt)
  {
    AppMethodBeat.i(271017);
    this.maxHeight = paramInt;
    invalidate();
    requestLayout();
    AppMethodBeat.o(271017);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(271025);
    this.maxWidth = paramInt;
    invalidate();
    requestLayout();
    AppMethodBeat.o(271025);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements GestureDetector.OnGestureListener
  {
    b(WxMaxSizeRecyclerView paramWxMaxSizeRecyclerView) {}
    
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
      AppMethodBeat.i(271005);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(271005);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    public final void onShowPress(MotionEvent paramMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270996);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      WxMaxSizeRecyclerView.a(this.LRf);
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/music/ui/view/WxMaxSizeRecyclerView$gestureDetector$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270996);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.view.WxMaxSizeRecyclerView
 * JD-Core Version:    0.7.0.1
 */