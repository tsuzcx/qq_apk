package com.tencent.mm.plugin.sns.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;

final class SnsTimeLineUI$48
  implements View.OnClickListener
{
  SnsTimeLineUI$48(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    if (SystemClock.elapsedRealtime() - SnsTimeLineUI.O(this.pfC) < 300L) {
      SnsTimeLineUI.I(this.pfC);
    }
    SnsTimeLineUI.c(this.pfC, SystemClock.elapsedRealtime());
    af.aXq().removeCallbacks(SnsTimeLineUI.P(this.pfC));
    SnsTimeLineUI.P(this.pfC).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.48
 * JD-Core Version:    0.7.0.1
 */