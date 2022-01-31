package com.tencent.mm.plugin.sns.ui;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.ui.MMActivity;

final class SnsAdNativeLandingTestUI$7
  implements Runnable
{
  SnsAdNativeLandingTestUI$7(SnsAdNativeLandingTestUI paramSnsAdNativeLandingTestUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(38712);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if ((this.rNi.getContext() instanceof MMActivity))
    {
      ((MMActivity)this.rNi.getContext()).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      SnsAdNativeLandingTestUI.a(this.rNi).setDrawableWidth(localDisplayMetrics.widthPixels);
    }
    SnsAdNativeLandingTestUI.a(this.rNi).requestLayout();
    SnsAdNativeLandingTestUI.a(this.rNi).postInvalidate();
    AppMethodBeat.o(38712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingTestUI.7
 * JD-Core Version:    0.7.0.1
 */