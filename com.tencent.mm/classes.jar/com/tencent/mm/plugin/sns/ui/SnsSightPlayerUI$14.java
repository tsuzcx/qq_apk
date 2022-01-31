package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsSightPlayerUI$14
  implements Runnable
{
  SnsSightPlayerUI$14(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(39268);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.rVT.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    if ((SnsSightPlayerUI.g(this.rVT) instanceof VideoSightView)) {
      ((VideoSightView)SnsSightPlayerUI.g(this.rVT)).setDrawableWidth(localDisplayMetrics.widthPixels);
    }
    ((View)SnsSightPlayerUI.g(this.rVT)).requestLayout();
    ((View)SnsSightPlayerUI.g(this.rVT)).postInvalidate();
    AppMethodBeat.o(39268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.14
 * JD-Core Version:    0.7.0.1
 */