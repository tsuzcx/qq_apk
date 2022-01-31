package com.tencent.mm.plugin.sight.decode.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;

final class VideoPlayView$3
  implements Runnable
{
  VideoPlayView$3(VideoPlayView paramVideoPlayView) {}
  
  public final void run()
  {
    AppMethodBeat.i(70317);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if ((this.qUK.getContext() instanceof MMActivity))
    {
      ((MMActivity)this.qUK.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      if ((VideoPlayView.a(this.qUK) instanceof VideoSightView)) {
        ((VideoSightView)VideoPlayView.a(this.qUK)).setDrawableWidth(localDisplayMetrics.widthPixels);
      }
    }
    ((View)VideoPlayView.a(this.qUK)).requestLayout();
    ((View)VideoPlayView.a(this.qUK)).postInvalidate();
    AppMethodBeat.o(70317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.3
 * JD-Core Version:    0.7.0.1
 */