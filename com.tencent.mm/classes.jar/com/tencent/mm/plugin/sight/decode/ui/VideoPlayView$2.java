package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class VideoPlayView$2
  implements View.OnTouchListener
{
  VideoPlayView$2(VideoPlayView paramVideoPlayView) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116163);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/sight/decode/ui/VideoPlayView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if (paramMotionEvent.getAction() == 1) {
      VideoPlayView.m(this.yTi);
    }
    for (;;)
    {
      a.a(true, this, "com/tencent/mm/plugin/sight/decode/ui/VideoPlayView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(116163);
      return true;
      paramMotionEvent.getAction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.2
 * JD-Core Version:    0.7.0.1
 */