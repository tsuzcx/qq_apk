package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AdVideoPlayerLoadingBar$1
  implements View.OnTouchListener
{
  AdVideoPlayerLoadingBar$1(AdVideoPlayerLoadingBar paramAdVideoPlayerLoadingBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117915);
    if (paramMotionEvent.getAction() == 0)
    {
      ab.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
      this.qTQ.hPP = false;
      this.qTQ.qTL = paramMotionEvent.getX();
      if (this.qTQ.qTB != null) {
        this.qTQ.qTB.aFf();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(117915);
      return true;
      int i;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)this.qTQ.qTE.getLayoutParams();
        i = paramView.leftMargin;
        int j = (int)(f - this.qTQ.qTL);
        paramView.leftMargin = AdVideoPlayerLoadingBar.a(this.qTQ, j + i);
        this.qTQ.qTE.setLayoutParams(paramView);
        i = this.qTQ.getCurrentTimeByBarPoint();
        if (this.qTQ.qTI > 0)
        {
          paramView = (FrameLayout.LayoutParams)this.qTQ.qTC.getLayoutParams();
          paramView.width = ((int)(i * 1.0D / this.qTQ.qTI * this.qTQ.getBarLen()));
          this.qTQ.qTC.setLayoutParams(paramView);
        }
        this.qTQ.qTG.setText(AdVideoPlayerLoadingBar.ol(i / 60) + ":" + AdVideoPlayerLoadingBar.ol(i % 60));
        this.qTQ.hPP = true;
      }
      else if (this.qTQ.hPP)
      {
        i = this.qTQ.getCurrentTimeByBarPoint();
        if (this.qTQ.qTB != null)
        {
          ab.i("MicroMsg.VideoPlayerLoadingBar", "current time : ".concat(String.valueOf(i)));
          this.qTQ.qTB.on(i);
        }
        this.qTQ.hPP = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.1
 * JD-Core Version:    0.7.0.1
 */