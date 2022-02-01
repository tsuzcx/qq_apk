package com.tencent.mm.ui.tools;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MMGestureGallery$d
  extends GestureDetector.SimpleOnGestureListener
{
  private MMGestureGallery$d(MMGestureGallery paramMMGestureGallery) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251100);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(251100);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251094);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    a.a(true, this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(251094);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251098);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(251098);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251097);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/ui/tools/MMGestureGallery$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(251097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.d
 * JD-Core Version:    0.7.0.1
 */