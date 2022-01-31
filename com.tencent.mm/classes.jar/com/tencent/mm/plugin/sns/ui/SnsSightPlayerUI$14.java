package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;

final class SnsSightPlayerUI$14
  implements Runnable
{
  SnsSightPlayerUI$14(SnsSightPlayerUI paramSnsSightPlayerUI) {}
  
  public final void run()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.pdk.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    if ((SnsSightPlayerUI.g(this.pdk) instanceof VideoSightView)) {
      ((VideoSightView)SnsSightPlayerUI.g(this.pdk)).setDrawableWidth(localDisplayMetrics.widthPixels);
    }
    ((View)SnsSightPlayerUI.g(this.pdk)).requestLayout();
    ((View)SnsSightPlayerUI.g(this.pdk)).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI.14
 * JD-Core Version:    0.7.0.1
 */