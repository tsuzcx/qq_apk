package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsOnlineVideoActivity$8
  extends GestureDetector.SimpleOnGestureListener
{
  SnsOnlineVideoActivity$8(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39152);
    SnsOnlineVideoActivity.b(this.rUf, true);
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(39152);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(39151);
    paramFloat1 = paramMotionEvent2.getRawX() - paramMotionEvent1.getRawX();
    paramFloat2 = paramMotionEvent2.getRawY() - paramMotionEvent1.getRawY();
    if ((Math.abs(paramFloat1) <= SnsOnlineVideoActivity.b(this.rUf).getWidth()) && (Math.abs(paramFloat2) <= SnsOnlineVideoActivity.b(this.rUf).getHeight()) && (SnsOnlineVideoActivity.c(this.rUf)))
    {
      SnsOnlineVideoActivity.d(this.rUf).setTranslationX(paramFloat1);
      SnsOnlineVideoActivity.d(this.rUf).setTranslationY(paramFloat2);
    }
    AppMethodBeat.o(39151);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(39153);
    if (!SnsOnlineVideoActivity.e(this.rUf)) {
      this.rUf.bdV();
    }
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    AppMethodBeat.o(39153);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.8
 * JD-Core Version:    0.7.0.1
 */