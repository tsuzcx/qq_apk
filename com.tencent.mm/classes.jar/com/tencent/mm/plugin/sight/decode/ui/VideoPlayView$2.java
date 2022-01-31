package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoPlayView$2
  implements View.OnTouchListener
{
  VideoPlayView$2(VideoPlayView paramVideoPlayView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(70316);
    if (paramMotionEvent.getAction() == 1) {
      VideoPlayView.m(this.qUK);
    }
    for (;;)
    {
      AppMethodBeat.o(70316);
      return true;
      paramMotionEvent.getAction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.2
 * JD-Core Version:    0.7.0.1
 */