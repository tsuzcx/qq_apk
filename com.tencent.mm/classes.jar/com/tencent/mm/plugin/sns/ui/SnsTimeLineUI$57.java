package com.tencent.mm.plugin.sns.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsTimeLineUI$57
  implements View.OnClickListener
{
  SnsTimeLineUI$57(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155764);
    if (SystemClock.elapsedRealtime() - SnsTimeLineUI.U(this.rYv) < 300L) {
      SnsTimeLineUI.O(this.rYv);
    }
    SnsTimeLineUI.c(this.rYv, SystemClock.elapsedRealtime());
    ag.bEf().removeCallbacks(SnsTimeLineUI.V(this.rYv));
    SnsTimeLineUI.V(this.rYv).run();
    AppMethodBeat.o(155764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.57
 * JD-Core Version:    0.7.0.1
 */