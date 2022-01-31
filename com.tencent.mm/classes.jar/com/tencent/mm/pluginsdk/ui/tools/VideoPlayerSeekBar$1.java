package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoPlayerSeekBar$1
  implements View.OnTouchListener
{
  VideoPlayerSeekBar$1(VideoPlayerSeekBar paramVideoPlayerSeekBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117962);
    if (paramMotionEvent.getAction() == 0)
    {
      ab.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
      VideoPlayerSeekBar.a(this.wfA);
      VideoPlayerSeekBar.a(this.wfA, paramMotionEvent.getX());
      if (VideoPlayerSeekBar.b(this.wfA) != null) {
        VideoPlayerSeekBar.c(this.wfA).aFf();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117962);
      return true;
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.d(this.wfA).getLayoutParams();
        paramMotionEvent = this.wfA;
        i = paramView.leftMargin;
        i = VideoPlayerSeekBar.a(paramMotionEvent, (int)(f - VideoPlayerSeekBar.e(this.wfA)) + i, VideoPlayerSeekBar.f(this.wfA));
        paramView.leftMargin = i;
        VideoPlayerSeekBar.g(this.wfA).setLayoutParams(paramView);
        int j = VideoPlayerSeekBar.f(this.wfA).value;
        if (VideoPlayerSeekBar.h(this.wfA) > 0)
        {
          paramView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.i(this.wfA).getLayoutParams();
          paramView.width = i;
          VideoPlayerSeekBar.j(this.wfA).setLayoutParams(paramView);
        }
        VideoPlayerSeekBar.k(this.wfA).setText(VideoPlayerSeekBar.ol(j / 60) + ":" + VideoPlayerSeekBar.ol(j % 60));
        VideoPlayerSeekBar.l(this.wfA);
      }
      else
      {
        i = VideoPlayerSeekBar.m(this.wfA);
        if (VideoPlayerSeekBar.n(this.wfA)) {
          i = VideoPlayerSeekBar.a(this.wfA, VideoPlayerSeekBar.f(this.wfA).value);
        }
        if (VideoPlayerSeekBar.o(this.wfA) != null)
        {
          ab.i("MicroMsg.VideoPlayerSeekBar", "current time : ".concat(String.valueOf(i)));
          VideoPlayerSeekBar.p(this.wfA).on(i);
        }
        VideoPlayerSeekBar.q(this.wfA);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar.1
 * JD-Core Version:    0.7.0.1
 */