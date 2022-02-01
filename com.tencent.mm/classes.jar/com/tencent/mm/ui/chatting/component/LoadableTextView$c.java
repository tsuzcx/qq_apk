package com.tencent.mm.ui.chatting.component;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/LoadableTextView$gestureDetector$2$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LoadableTextView$c
  implements GestureDetector.OnDoubleTapListener
{
  LoadableTextView$c(LoadableTextView paramLoadableTextView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(256033);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/ui/chatting/component/LoadableTextView$gestureDetector$2$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    s.u(paramMotionEvent, "e");
    a.a(false, this, "com/tencent/mm/ui/chatting/component/LoadableTextView$gestureDetector$2$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(256033);
    return false;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(256030);
    s.u(paramMotionEvent, "e");
    m localm = LoadableTextView.c(this.aeuL);
    if (localm == null)
    {
      AppMethodBeat.o(256030);
      return false;
    }
    paramMotionEvent = (Boolean)localm.invoke(this.aeuL, paramMotionEvent);
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(256030);
      return false;
    }
    boolean bool = paramMotionEvent.booleanValue();
    AppMethodBeat.o(256030);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.LoadableTextView.c
 * JD-Core Version:    0.7.0.1
 */