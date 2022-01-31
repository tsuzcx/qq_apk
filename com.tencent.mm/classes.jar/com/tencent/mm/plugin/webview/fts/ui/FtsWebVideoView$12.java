package com.tencent.mm.plugin.webview.fts.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.sdk.platformtools.y;

final class FtsWebVideoView$12
  implements a.b
{
  FtsWebVideoView$12(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void ah(float paramFloat)
  {
    y.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:" + paramFloat);
    FtsWebVideoView.j(this.raW).setPercent(paramFloat);
    FtsWebVideoView.k(this.raW).setText(R.l.fts_web_video_volume);
    FtsWebVideoView.l(this.raW).setImageResource(R.k.fts_web_video_volume_icon);
    FtsWebVideoView.m(this.raW).setVisibility(0);
  }
  
  public final void ai(float paramFloat)
  {
    y.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:" + paramFloat);
    FtsWebVideoView.j(this.raW).setPercent(paramFloat);
    FtsWebVideoView.k(this.raW).setText(R.l.fts_web_video_brightness);
    FtsWebVideoView.l(this.raW).setImageResource(R.k.fts_web_video_brightness_icon);
    FtsWebVideoView.m(this.raW).setVisibility(0);
  }
  
  public final void akl()
  {
    y.d("MicroMsg.FtsWebVideoView", "onSingleTap");
    if (FtsWebVideoView.e(this.raW)) {
      FtsWebVideoView.c(this.raW).la(FtsWebVideoView.f(this.raW));
    }
  }
  
  public final void akm()
  {
    y.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
  }
  
  public final void akn()
  {
    if (FtsWebVideoView.d(this.raW).isLive())
    {
      y.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
      return;
    }
    FtsWebVideoView.g(this.raW).setVisibility(0);
    FtsWebVideoView.c(this.raW).cac();
  }
  
  public final void ako()
  {
    FtsWebVideoView.m(this.raW).setVisibility(8);
  }
  
  public final void akp()
  {
    FtsWebVideoView.m(this.raW).setVisibility(8);
  }
  
  public final boolean bNK()
  {
    return !FtsWebVideoView.i(this.raW);
  }
  
  public final int f(int paramInt, float paramFloat)
  {
    int j = 0;
    if (FtsWebVideoView.d(this.raW).isLive())
    {
      y.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
      return 0;
    }
    y.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramInt + "/" + paramFloat);
    paramFloat /= this.raW.getMeasuredWidth();
    int i = FtsWebVideoView.d(this.raW).getVideoDurationSec();
    paramInt = getCurrentPosition();
    paramInt = (int)(paramFloat * i) + paramInt;
    if (paramInt < 0) {
      paramInt = j;
    }
    for (;;)
    {
      String str = c.ce(i * 1000L);
      FtsWebVideoView.g(this.raW).setText(c.ce(paramInt * 1000L) + "/" + str);
      return paramInt;
      if (paramInt > i) {
        paramInt = i;
      }
    }
  }
  
  public final void g(int paramInt, float paramFloat)
  {
    FtsWebVideoView.c(this.raW).bOz();
    FtsWebVideoView.g(this.raW).setVisibility(8);
    y.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(FtsWebVideoView.d(this.raW).getCurrPosSec()), Float.valueOf(paramFloat) });
    if (FtsWebVideoView.d(this.raW).isLive()) {
      y.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
    }
    do
    {
      return;
      this.raW.D(paramInt, false);
      FtsWebVideoView.c(this.raW).bOz();
    } while (FtsWebVideoView.h(this.raW) == null);
    FtsWebVideoView.h(this.raW).caP();
  }
  
  public final int getCurrentPosition()
  {
    return FtsWebVideoView.d(this.raW).getCurrPosSec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.12
 * JD-Core Version:    0.7.0.1
 */