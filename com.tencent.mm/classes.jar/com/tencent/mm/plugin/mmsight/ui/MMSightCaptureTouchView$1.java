package com.tencent.mm.plugin.mmsight.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.Log;

final class MMSightCaptureTouchView$1
  extends GestureDetector.SimpleOnGestureListener
{
  MMSightCaptureTouchView$1(MMSightCaptureTouchView paramMMSightCaptureTouchView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55074);
    Log.i("MicroMsg.MMSightCaptureTouchView", "onDoubleTap");
    if (System.currentTimeMillis() - MMSightCaptureTouchView.b(this.oNw) > 1000L)
    {
      if (MMSightCaptureTouchView.a(this.oNw) != null) {
        MMSightCaptureTouchView.a(this.oNw).bpb();
      }
      MMSightCaptureTouchView.a(this.oNw, System.currentTimeMillis());
    }
    AppMethodBeat.o(55074);
    return false;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55075);
    Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapConfirmed");
    AppMethodBeat.o(55075);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(55073);
    Log.i("MicroMsg.MMSightCaptureTouchView", "onSingleTapUp");
    if (MMSightCaptureTouchView.a(this.oNw) != null) {
      MMSightCaptureTouchView.a(this.oNw).T(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    AppMethodBeat.o(55073);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.1
 * JD-Core Version:    0.7.0.1
 */