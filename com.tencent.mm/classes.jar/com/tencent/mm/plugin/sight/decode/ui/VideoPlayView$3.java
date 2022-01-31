package com.tencent.mm.plugin.sight.decode.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;

final class VideoPlayView$3
  implements Runnable
{
  VideoPlayView$3(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if ((this.ogv.getContext() instanceof MMActivity))
    {
      ((MMActivity)this.ogv.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      if ((VideoPlayView.a(this.ogv) instanceof VideoSightView)) {
        ((VideoSightView)VideoPlayView.a(this.ogv)).setDrawableWidth(localDisplayMetrics.widthPixels);
      }
    }
    ((View)VideoPlayView.a(this.ogv)).requestLayout();
    ((View)VideoPlayView.a(this.ogv)).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.3
 * JD-Core Version:    0.7.0.1
 */