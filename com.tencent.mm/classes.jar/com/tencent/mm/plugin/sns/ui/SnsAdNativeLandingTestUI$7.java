package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsAdNativeLandingTestUI$7
  implements Runnable
{
  SnsAdNativeLandingTestUI$7(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void run()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if ((this.oVg.mController.uMN instanceof MMActivity))
    {
      ((MMActivity)this.oVg.mController.uMN).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      SnsAdNativeLandingTestUI.a(this.oVg).setDrawableWidth(localDisplayMetrics.widthPixels);
    }
    SnsAdNativeLandingTestUI.a(this.oVg).requestLayout();
    SnsAdNativeLandingTestUI.a(this.oVg).postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.7
 * JD-Core Version:    0.7.0.1
 */