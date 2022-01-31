package com.tencent.mm.plugin.sight.decode.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.y;

final class AdVideoPlayerLoadingBar$1
  implements View.OnTouchListener
{
  AdVideoPlayerLoadingBar$1(AdVideoPlayerLoadingBar paramAdVideoPlayerLoadingBar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      y.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
      this.ofC.guU = false;
      this.ofC.ofx = paramMotionEvent.getX();
      if (this.ofC.ofn != null) {
        this.ofC.ofn.akz();
      }
    }
    do
    {
      return true;
      if (paramMotionEvent.getAction() == 2)
      {
        float f = paramMotionEvent.getX();
        paramView = (FrameLayout.LayoutParams)this.ofC.ofq.getLayoutParams();
        i = paramView.leftMargin;
        int j = (int)(f - this.ofC.ofx);
        paramView.leftMargin = AdVideoPlayerLoadingBar.a(this.ofC, j + i);
        this.ofC.ofq.setLayoutParams(paramView);
        i = this.ofC.getCurrentTimeByBarPoint();
        if (this.ofC.ofu > 0)
        {
          paramView = (FrameLayout.LayoutParams)this.ofC.ofo.getLayoutParams();
          paramView.width = ((int)(i * 1.0D / this.ofC.ofu * this.ofC.getBarLen()));
          this.ofC.ofo.setLayoutParams(paramView);
        }
        this.ofC.ofs.setText(AdVideoPlayerLoadingBar.lC(i / 60) + ":" + AdVideoPlayerLoadingBar.lC(i % 60));
        this.ofC.guU = true;
        return true;
      }
    } while (!this.ofC.guU);
    int i = this.ofC.getCurrentTimeByBarPoint();
    if (this.ofC.ofn != null)
    {
      y.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + i);
      this.ofC.ofn.lE(i);
    }
    this.ofC.guU = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar.1
 * JD-Core Version:    0.7.0.1
 */