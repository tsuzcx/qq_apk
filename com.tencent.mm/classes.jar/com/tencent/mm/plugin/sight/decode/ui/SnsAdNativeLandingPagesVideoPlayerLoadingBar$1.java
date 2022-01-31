package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;

final class SnsAdNativeLandingPagesVideoPlayerLoadingBar$1
  implements View.OnTouchListener
{
  SnsAdNativeLandingPagesVideoPlayerLoadingBar$1(SnsAdNativeLandingPagesVideoPlayerLoadingBar paramSnsAdNativeLandingPagesVideoPlayerLoadingBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      y.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
      SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY, false);
      SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY, paramMotionEvent.getX());
      if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY) != null) {
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY).akz();
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(this.ofY).getLayoutParams();
        i = paramView.leftMargin;
        int j = (int)(f - SnsAdNativeLandingPagesVideoPlayerLoadingBar.c(this.ofY));
        paramView.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY, j + i);
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.b(this.ofY).setLayoutParams(paramView);
        i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.ofY);
        if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(this.ofY) > 0)
        {
          paramView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(this.ofY).getLayoutParams();
          paramView.width = ((int)(i * 1.0D / SnsAdNativeLandingPagesVideoPlayerLoadingBar.e(this.ofY) * SnsAdNativeLandingPagesVideoPlayerLoadingBar.g(this.ofY)));
          SnsAdNativeLandingPagesVideoPlayerLoadingBar.f(this.ofY).setLayoutParams(paramView);
        }
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.h(this.ofY).setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.lC(i / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.lC(i % 60));
        SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY, true);
        return true;
      }
    } while (!SnsAdNativeLandingPagesVideoPlayerLoadingBar.i(this.ofY));
    int i = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.ofY);
    if (SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY) != null)
    {
      y.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + i);
      SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY).lE(i);
    }
    SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.ofY, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SnsAdNativeLandingPagesVideoPlayerLoadingBar.1
 * JD-Core Version:    0.7.0.1
 */