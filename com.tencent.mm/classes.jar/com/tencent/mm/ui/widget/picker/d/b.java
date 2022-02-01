package com.tencent.mm.ui.widget.picker.d;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class b
  extends GestureDetector.SimpleOnGestureListener
{
  private final WheelView LyN;
  
  public b(WheelView paramWheelView)
  {
    this.LyN = paramWheelView;
  }
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200563);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onContextClick(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(200563);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200562);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(200562);
    return bool;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200559);
    paramMotionEvent1 = this.LyN;
    paramMotionEvent1.aQp();
    paramMotionEvent1.iNB = paramMotionEvent1.iNA.scheduleWithFixedDelay(new com.tencent.mm.ui.widget.picker.e.a(paramMotionEvent1, paramFloat2), 0L, 5L, TimeUnit.MILLISECONDS);
    AppMethodBeat.o(200559);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200561);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    super.onLongPress(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(200561);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200560);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/picker/listener/LoopViewGestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(200560);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.b
 * JD-Core Version:    0.7.0.1
 */