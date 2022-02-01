package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ac;

final class SnsAdNativeLandingPagesUI$6
  implements View.OnLayoutChangeListener
{
  SnsAdNativeLandingPagesUI$6(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI, int paramInt) {}
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(200444);
    try
    {
      paramView = new Rect();
      this.yHq.getWindow().getDecorView().getWindowVisibleDisplayFrame(paramView);
      paramInt1 = paramView.top;
      ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "rect=" + paramView.toString() + ", screenH=" + SnsAdNativeLandingPagesUI.c(this.yHq) + ", cutH=" + this.DeB + ", statusBarH=" + paramInt1);
      if (paramInt1 > 0)
      {
        if (paramInt1 != this.DeB)
        {
          ac.i("MicroMsg.SnsAdNativeLandingPagesUI", "cutH != statusBarH, reset height");
          paramView = (FrameLayout.LayoutParams)SnsAdNativeLandingPagesUI.b(this.yHq).getLayoutParams();
          paramView.height = (SnsAdNativeLandingPagesUI.c(this.yHq) - paramInt1);
          paramView.topMargin = paramInt1;
          SnsAdNativeLandingPagesUI.b(this.yHq).setLayoutParams(paramView);
          i.b(i.xNi, "", this.DeB, paramInt1, SnsAdNativeLandingPagesUI.M(this.yHq) + "|" + SnsAdNativeLandingPagesUI.c(this.yHq));
        }
        SnsAdNativeLandingPagesUI.b(this.yHq).removeOnLayoutChangeListener(this);
      }
      AppMethodBeat.o(200444);
      return;
    }
    catch (Throwable paramView)
    {
      ac.e("MicroMsg.SnsAdNativeLandingPagesUI", "onLayoutChange error:" + paramView.toString());
      SnsAdNativeLandingPagesUI.b(this.yHq).removeOnLayoutChangeListener(this);
      AppMethodBeat.o(200444);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.6
 * JD-Core Version:    0.7.0.1
 */