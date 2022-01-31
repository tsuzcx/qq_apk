package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsAdNativeLandingPagesVideoPlayerLoadingBar$1
  implements View.OnTouchListener
{
  SnsAdNativeLandingPagesVideoPlayerLoadingBar$1(SnsAdNativeLandingPagesVideoPlayerLoadingBar paramSnsAdNativeLandingPagesVideoPlayerLoadingBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(70291);
    if (paramMotionEvent.getAction() == 0)
    {
      ab.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
      SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn, false);
      SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn, paramMotionEvent.getX());
      if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn) != null) {
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn).aFf();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70291);
      return true;
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(this.qUn).getLayoutParams();
        i = paramView.leftMargin;
        int j = (int)(f - SnsAdNativeLandingPagesVideoPlayerLoadingBar.c(this.qUn));
        paramView.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn, j + i);
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(this.qUn).setLayoutParams(paramView);
        i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.qUn);
        if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(this.qUn) > 0)
        {
          paramView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(this.qUn).getLayoutParams();
          paramView.width = ((int)(i * 1.0D / SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(this.qUn) * SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(this.qUn)));
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(this.qUn).setLayoutParams(paramView);
        }
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(this.qUn).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.ol(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.ol(i % 60));
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn, true);
      }
      else if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(this.qUn))
      {
        i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.qUn);
        if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn) != null)
        {
          ab.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn).on(i);
        }
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.qUn, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar.1
 * JD-Core Version:    0.7.0.1
 */