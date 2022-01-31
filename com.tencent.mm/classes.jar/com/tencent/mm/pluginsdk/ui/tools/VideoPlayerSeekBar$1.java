package com.tencent.mm.pluginsdk.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;

final class VideoPlayerSeekBar$1
  implements View.OnTouchListener
{
  VideoPlayerSeekBar$1(VideoPlayerSeekBar paramVideoPlayerSeekBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      y.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
      VideoPlayerSeekBar.a(this.snf);
      VideoPlayerSeekBar.a(this.snf, paramMotionEvent.getX());
      if (VideoPlayerSeekBar.b(this.snf) != null) {
        VideoPlayerSeekBar.c(this.snf).akz();
      }
    }
    for (;;)
    {
      return true;
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.d(this.snf).getLayoutParams();
        paramMotionEvent = this.snf;
        i = paramView.leftMargin;
        i = VideoPlayerSeekBar.a(paramMotionEvent, (int)(f - VideoPlayerSeekBar.e(this.snf)) + i, VideoPlayerSeekBar.f(this.snf));
        paramView.leftMargin = i;
        VideoPlayerSeekBar.g(this.snf).setLayoutParams(paramView);
        int j = VideoPlayerSeekBar.f(this.snf).value;
        if (VideoPlayerSeekBar.h(this.snf) > 0)
        {
          paramView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.i(this.snf).getLayoutParams();
          paramView.width = i;
          VideoPlayerSeekBar.j(this.snf).setLayoutParams(paramView);
        }
        VideoPlayerSeekBar.k(this.snf).setText(VideoPlayerSeekBar.lC(j / 60) + ":" + VideoPlayerSeekBar.lC(j % 60));
        VideoPlayerSeekBar.l(this.snf);
      }
      else
      {
        i = VideoPlayerSeekBar.m(this.snf);
        if (VideoPlayerSeekBar.n(this.snf)) {
          i = VideoPlayerSeekBar.a(this.snf, VideoPlayerSeekBar.f(this.snf).value);
        }
        if (VideoPlayerSeekBar.o(this.snf) != null)
        {
          y.i("MicroMsg.VideoPlayerSeekBar", "current time : " + i);
          VideoPlayerSeekBar.p(this.snf).lE(i);
        }
        VideoPlayerSeekBar.q(this.snf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar.1
 * JD-Core Version:    0.7.0.1
 */